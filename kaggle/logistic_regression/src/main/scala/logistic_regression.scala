import org.apache.spark.SparkContext
import org.apache.spark.SparkConf
import org.apache.spark.sql.types.{StructType,StructField,StringType,DoubleType}
import org.apache.spark.sql.Row
import org.apache.spark.sql.DataFrame
import org.apache.spark.ml.feature.StringIndexer
import org.apache.spark.ml.feature.StringIndexerModel
import org.apache.spark.ml.feature.OneHotEncoder
import org.apache.spark.ml.feature.VectorAssembler
import org.apache.spark.ml.classification.LogisticRegression
import org.apache.spark.ml.classification.LogisticRegressionModel
import org.apache.spark.ml.param.ParamMap
import org.apache.spark.ml.evaluation.BinaryClassificationEvaluator
import org.apache.spark.mllib.evaluation.BinaryClassificationMetrics
import org.apache.spark.ml.tuning.CrossValidator
import org.apache.spark.ml.tuning.ParamGridBuilder
import org.apache.spark.ml.linalg.DenseVector
import org.apache.spark.sql.functions._

object logistic_regression {
  def main(args: Array[String]) {
    var sc = new SparkContext(new SparkConf().setMaster("local")
      .setAppName("logistic_regression"))

    val sqlContext = new org.apache.spark.sql.SQLContext(sc)
    val df = sqlContext
      .read
      .format("com.databricks.spark.csv")
      .option("header", "true")
      .option("inferSchema", "true")
      .load("../../../data/patient_pot_ind_drugs_diabetes.csv")

    // show some data has been read in
    df.show(4)

    // clean up and reshape data
    val df_pivoted = df
      .groupBy("Patient_ID", "Diabetes")
      .pivot("generic_ingredient_name")
      .count
      .na
      .fill(0)

    val va = new VectorAssembler()
      .setOutputCol("features")
      .setInputCols(df_pivoted.columns.diff(Array("Diabetes", "Patient_ID")))

    val lpoints = va
      .transform(df_pivoted)
      .select("Patient_ID", "features", "Diabetes")
      .withColumnRenamed("Diabetes", "label")

    lpoints.show(5)

    // split into training
    val splits = lpoints.randomSplit(Array(0.8, 0.2))
    val diabetesTrain = splits(0).cache()
    val diabetesValid = splits(1).cache()

    // logistic regression
    val lr = new LogisticRegression
    lr.setRegParam(0.01).setMaxIter(500).setFitIntercept(true)
    val lrmodel = lr.fit(diabetesTrain)

    // resulting coefficients and intercept
    println(s"Coefficients: ${lrmodel.coefficients}")
    println(s"Intercept: ${lrmodel.intercept}")

    // get predictions and evaluate
    val validpredicts = lrmodel.transform(diabetesValid)
    val bceval = new BinaryClassificationEvaluator()

	  println(bceval.evaluate(validpredicts))
	  // res: Double = 0.6879395068102876

    /*
    // alternately use a cross validator to find best staring parameters
    val cv = new CrossValidator()
      .setEstimator(lr)
      .setEvaluator(bceval)
      .setNumFolds(5)
    val paramGrid = new ParamGridBuilder()
      .addGrid(lr.maxIter, Array(1000))
      .addGrid(lr.regParam, Array(0.0001, 0.001, 0.005, 0.01, 0.05, 0.1, 0.5))
      .build()
    cv.setEstimatorParamMaps(paramGrid)
    val cvmodel = cv.fit(diabetesTrain)

    cvmodel.bestModel.asInstanceOf[LogisticRegressionModel].coefficients
    cvmodel.bestModel.parent.asInstanceOf[LogisticRegression].getRegParam

	  new BinaryClassificationEvaluator().evaluate(cvmodel.bestModel.transform(diabetesValid))
	  // res11: Double = 0.6879395068102875 happens to be same as above 0.01
    */

    val vectorToColumn = udf{ (x:DenseVector, index: Int) => if(x != null) x(index) else 0 }

    // prediction.withColumn("probability", vectorToColumn(col("probability"),lit(1))).show
    val df_baseline = sqlContext
      .read
      .format("com.databricks.spark.csv")
      .option("header", "true")
      .option("inferSchema", "true")
      .load("../../../data/kaggle_baseline.csv")

    val df_out = df_baseline.join(validpredicts, Seq("Patient_ID"), "left_outer")
    println(df_out.count)
	  // res47: Long = 279152
    df_out.show(5)

    // need to make sure directories do not exist
    // rm -rf pred_data/ prob_data/
    df_out
      .select("Patient_ID", "Diabetes", "Prediction")
      .coalesce(1)
      .write
      .format("com.databricks.spark.csv")
      .option("header", "true")
      .save("pred_data")

    df_out
      .select("Patient_ID", "Diabetes", "Prediction", "probability")
      .withColumn("probability", vectorToColumn(col("probability"),lit(1)))
      .coalesce(1)
      .write
      .format("com.databricks.spark.csv")
      .option("header", "true")
      .save("prob_data")
  }

  // is this handy?
  // val dfnumeric = indexStringColumns(dfrawnona, Array("col_name_1", "col_name_n"))
  def indexStringColumns(df:DataFrame, cols:Array[String]):DataFrame = {
    var newdf = df
    for(col <- cols) {
      val si = new StringIndexer().setInputCol(col).setOutputCol(col+"-num")
      val sm:StringIndexerModel = si.fit(newdf)
      newdf = sm.transform(newdf).drop(col)
      newdf = newdf.withColumnRenamed(col+"-num", col)
		}
		newdf
	}

  // or this as opposed to the sparce matrix created by the pivot?
  // val dfhot = oneHotEncodeColumns(dfnumeric, Array("col_name_1", "col_name_n"))
  def oneHotEncodeColumns(df:DataFrame, cols:Array[String]):DataFrame = {
    var newdf = df
    for(c <- cols) {
      val onehotenc = new OneHotEncoder().setInputCol(c)
      onehotenc.setOutputCol(c+"-onehot").setDropLast(false)
      newdf = onehotenc.transform(newdf).drop(c)
      newdf = newdf.withColumnRenamed(c+"-onehot", c)
    }
    newdf
  }

  // not yet used
  def computePRCurve(train:DataFrame, valid:DataFrame, lrmodel:LogisticRegressionModel) = {
    for(threshold <- 0 to 10)
    {
        var thr = threshold/10.0
        if(threshold == 10)
            thr -= 0.001
        lrmodel.setThreshold(thr)
        val validpredicts = lrmodel.transform(valid).rdd
        val validPredRdd = validpredicts.map(row => (row.getDouble(4), row.getDouble(1)))
        val bcm = new BinaryClassificationMetrics(validPredRdd)
        val pr = bcm.pr.collect()(1)
        println("%.1f: R=%f, P=%f".format(thr, pr._1, pr._2))
    }
  }

  // not yet used
  def computeROCCurve(train:DataFrame, valid:DataFrame, lrmodel:LogisticRegressionModel) = {
    for(threshold <- 0 to 10)
    {
        var thr = threshold/10.0
        if(threshold == 10)
            thr -= 0.001
        lrmodel.setThreshold(thr)
        val validpredicts = lrmodel.transform(valid).rdd
        val validPredRdd = validpredicts.map(row => (row.getDouble(4), row.getDouble(1)))
        val bcm = new BinaryClassificationMetrics(validPredRdd)
        val pr = bcm.roc.collect()(1)
        println("%.1f: FPR=%f, TPR=%f".format(thr, pr._1, pr._2))
    }
  }
}
