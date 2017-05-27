# MelbDatathon2017 - Kaggle competition

As part of the MelbDatathon2017 there is a Kaggle competition to predict the
likely hood of someone taking Diabetes related medication.

## Questions

- [ ] do we get marks for people coming off medication? or do the 1's stay 1's
  for ever?

## Attempts

### Logistic Linear Regression

As per Ch 8.2 Spark in Action

- [x] **target variable - have ever had diabetes**
  select all patients and if they have or have not ever had a diabetic drug.
  This will be used as the target variable, is a patient likely to have
  diabetes.

      SELECT
        t.patient_id AS Patient_ID,
        CASE
          WHEN GROUP_CONCAT(UNIQUE(c.ChronicIllness)) like '%Diabetes%' THEN 1.0
          ELSE 0.0
        END AS Diabetes
      FROM
        dthon.transactions t
      LEFT JOIN
        dthon.chronic_illness_lookup c
      ON
        t.Drug_ID = c.MasterProductID
      GROUP BY
        Patient_ID

  saved as dthon.baseline_diabetes_binary

- [x] **drugs that are potential indicators of diabetes**
  select all drugs that have ever been taken by a patient who has taken a
  diabetic drug but that are not diabetic drugs. The thinking here is that all
  drugs that are diabetic are of no use as indicators, and all drugs that are
  not connected will never be able to help predict, ultimately reducing the
  data set.

        SELECT
          d.GenericIngredientName AS generic_ingredient_name,
        FROM
          dthon.transactions_all_c2 t
        JOIN
          dthon.drug_lookup d
          ON t.Drug_ID = d.MasterProductID
        LEFT JOIN
          dthon.chronic_illness_lookup c
          ON t.Drug_ID = c.MasterProductID
        JOIN dthon.baseline_diabetes_binary b
          ON t.Patient_ID = b.Patient_ID
        WHERE
          b.Diabetes = 1.0
          AND c.ChronicIllness != 'Diabetes'
        GROUP BY
          generic_ingredient_name

  131 generic ingredients in all

      "DOXEPIN", "PREGABALIN", "FLUTICASONE/SALMETEROL", "INFLIXIMAB",
      "ROSUVASTATIN", "GOLIMUMAB", "EZETIMIBE/ATORVASTATIN",
      "EPROSARTAN/HYDROCHLOROTHIAZIDE", "ALFUZOSIN",
      "IRBESARTAN/HYDROCHLOROTHIAZIDE", "OLMESARTAN/AMLODIPINE/HCT", "LITHIUM CARB",
      "DULOXETINE", "LAMOTRIGINE", "RISEDRONATE SOD/CALCIUM CARB", "ATORVASTATIN",
      "MOCLOBEMIDE", "ALENDRONATE SODIUM ONCE WEEKLY", "AGOMELATINE", "IRBESARTAN",
      "INDACATEROL (AS MALEATE)", "PINDOLOL", "PHENELZINE", "VENLAFAXINE",
      "IVABRADINE", "WARFARIN SODIUM", "TELMISARTAN", "AMLODIPINE/VALSARTAN",
      "TELMISARTAN/HYDROCHLOROTHIAZID", "VALSARTAN/HYDROCHLOROTHIAZIDE",
      "AMLODIPINE/VALSARTAN/HCT", "RALOXIFENE", "FLUVASTATIN XL", "PRAVASTATIN",
      "MIRTAZAPINE", "AMLODIPINE/ATORVASTATIN", "CANDESARTAN CILEXETIL",
      "DUTASTERIDE", "OLMESARTAN MEDOXOM/AMLODIPINE", "EPLERENONE", "CARVEDILOL",
      "TOFACITINIB", "OXCARBAZEPINE", "TRANYLCYPROMINE", "BISOPROLOL FUMARATE",
      "CANDESARTAN HCT", "DENOSUMAB", "UMECLIDINIUM/VILANTEROL", "UMECLIDINIUM",
      "RISEDRONATE/CALCIUM CARB", "VALSARTAN", "FINASTERIDE", "GLYCOPYRRONIUM BR",
      "ATENOLOL", "SECUKINUMAB", "USTEKINUMAB", "MIANSERIN", "DABIGATRAN ETEXILATE",
      "SERTRALINE", "TIOTROPIUM/OLODATEROL", "ACLIDINIUM/EFORMOTEROL", "RITUXIMAB",
      "TELMISARTAN/AMLODIPINE", "STRONTIUM RANELATE", "TERAZOSIN",
      "DUTASTERIDE/TAMSULOSIN", "APIXABAN", "PRIMIDONE", "DESVENLAFAXINE",
      "ENOXAPARIN", "CITALOPRAM", "FLUVOXAMINE", "GABAPENTIN", "TRIMIPRAMINE",
      "ALENDRONATE/COLECALCIF/CALCIUM", "TERIPARATIDE", "CERTOLIZUMAB PEGOL",
      "ALENDRONATE SOD/COLECALCIFEROL", "EPROSARTAN MESYLATE",
      "EZETIMIBE/SIMVASTATIN", "METOPROLOL SUCCINATE", "LACOSAMIDE", "REBOXETINE",
      "LABETALOL", "PERAMPANEL", "AMITRIPTYLINE", "TOCILIZUMAB", "PHENYTOIN",
      "METOPROLOL TARTRATE", "CLONAZEPAM", "TIOTROPIUM BROMIDE", "ETANERCEPT",
      "ACLIDINIUM", "OLMESARTAN", "TIAGABINE", "ESCITALOPRAM",
      "BUDESONIDE/EFORMOTEROL", "RISEDRONATE/CALCIUM/COLECALC", "ROSUVASTATIN & EZETIMIBE",
      "FLUVASTATIN (AS SODIUM)", "VORTIOXETINE", "FENOFIBRATE",
      "ATORVASTATIN & EZETIMIBE", "PROPRANOLOL", "CLOMIPRAMINE", "ZONISAMIDE",
      "SODIUM VALPROATE", "ABATACEPT", "PAROXETINE", "SOTALOL", "LEVETIRACETAM",
      "RISEDRONATE SODIUM", "RIVAROXABAN", "LOSARTAN",
      "OLMESARTAN/HYDROCHLOROTHIAZIDE", "OXPRENOLOL", "CARBAMAZEPINE", "VIGABATRIN",
      "SULTHIAME", "NORTRIPTYLINE", "TOPIRAMATE", "ZOLEDRONIC ACID (MONOHYDRATE)",
      "FLUTICASONE/VILANTEROL", "ADALIMUMAB", "NEBIVOLOL (AS HCL)", "SIMVASTATIN",
      "TAMSULOSIN", "EZETIMIBE", "INDACATEROL/GLYCOPYRRONIUM", "GEMFIBROZIL",
      "PHENOBARBITONE"

- [x] **patient to potential indicator drugs**
  for all patients select all drugs(generic ingredient name) from previous
  step. These are the variables to be analysed.

      SELECT
        t.Patient_ID AS Patient_ID,
        d.GenericIngredientName AS generic_ingredient_name,
        b.Diabetes AS Diabetes
      FROM
        dthon.transactions_all_c2 t
        JOIN
          dthon.drug_lookup d
          ON t.Drug_ID = d.MasterProductID
        LEFT JOIN
          dthon.chronic_illness_lookup c
          ON t.Drug_ID = c.MasterProductID
        JOIN
          dthon.baseline_diabetes_binary b
          ON t.Patient_ID = b.Patient_ID
      WHERE
        d.GenericIngredientName IN (
          SELECT
            d.GenericIngredientName AS generic_ingredient_name,
          FROM
            dthon.transactions_all_c2 t
            JOIN
              dthon.drug_lookup d
              ON t.Drug_ID = d.MasterProductID
            LEFT JOIN
              dthon.chronic_illness_lookup c
              ON t.Drug_ID = c.MasterProductID
            JOIN
              dthon.baseline_diabetes_binary b
              ON t.Patient_ID = b.Patient_ID
          WHERE
            b.Diabetes = 1.0
            AND c.ChronicIllness != 'Diabetes'
          GROUP BY
            generic_ingredient_name)
      GROUP BY
        Patient_ID
        , generic_ingredient_name
        , Diabetes
      ORDER BY
        Patient_ID

  saved as patient_pot_ind_drugs_diabetes

- [x] **run the regression**

  got a worse result - presumably got more wrong then right out of the 757
  patients that were predicted to get diabetes.
  baseline:   0.94182
  submission: 0.94042

### Baseline

Patient id between 279,201 and 558,352 leading to 279,153 rows including a
header with the probablility in the range [0-1].

**Note:** _need to `LEFT JOIN` on chronic_illness_lookup as there are drugs
          without a valid lookup (for 17,195 patients)_

    SELECT
      Patient_ID
      , MAX(Diabetes) AS Diabetes
    FROM
      (
      SELECT
        t.patient_id AS Patient_ID
        , CASE WHEN c.ChronicIllness == 'Diabetes' THEN 1.0 ELSE 0.0 END as Diabetes
      FROM
        dthon.transactions t
        JOIN dthon.drug_lookup d
          ON t.Drug_ID = d.MasterProductID
        LEFT JOIN dthon.chronic_illness_lookup c
          ON c.MasterProductID = d.MasterProductID
      WHERE
        t.patient_id BETWEEN 279201 AND 558352
      )
    GROUP BY
      Patient_ID
    ORDER BY
      Patient_ID

output

    Patient_ID,Diabetes
    279201,0
    ...
    279206,0
    279207,1
    279208,1
    279209,0
    ...
    558350,0
    558351,0
    558352,1

line count

    279153 ../data/kaggle_baseline.csv

## Background

More info links

  * [Week 1 Kaggle Competition
    #melbdarathon2017](https://chrisdlangton.ghost.io/2017/04/21/week-1-kaggle-competition-melbdarathon2017/)
  * [AusDM09](http://tiberius.biz/ausdm09/index.html#4)
  * [Comment on past
    winners](https://inclass.kaggle.com/c/dsm2017/forums/t/31449/welcome?forumMessageId=174409#post174409)

[Public Leaderboard - Melbourne Datathon 2017](https://inclass.kaggle.com/c/dsm2017/leaderboard)

_This leaderboard is calculated on approximately 10% of the test data._

_The final results will be based on the other 90%, so the final standings may be
different._

### Kaggle dsm2017

[Melbourne Datathon 2017](https://inclass.kaggle.com/c/dsm2017)

**Who is heading for Diabetes?**

This is the predictive part of the [2017 Melbourne
Datathon](http://www.datasciencemelbourne.com/datathon/).

The task is to predict the probability that a patient will be dispensed a drug
related to Diabetes post 2015. This is quite important research as it will be
an early warning system for doctors so intervention can potentially be made
before it is too late.

Use the patients that we have provided all the records for to build your model,
then see how it performs on these unseen people.

For patient ID'S 279,201 to 558,352 you need to submit a file with 2 columns,
the Patient_ID and the probability in the range [0-1]. The file will have
279,153 rows including the header row. An example submission file is provided
for download.

    Patient_ID,Diabetes
    279201,0.0
    279202,0.2
    279203,0.7
    279204,1.0
    ......
    558350,0.3
    558351,0.6
    558352,1.3

If you are planning on applying for one of the Data Science Internships on
offer then this is your chance to shine - if so we recommend entering as an
individual to have the best chance of landing a role.

Good luck!

    Started:  4:50 pm,   Monday  3 April 2017 UTC
    Ends:     2:00 am,  Tuesday 30 May 2017 UTC (56 total days)
    Points:   this competition does not award ranking points
    Tiers:    this competition does not count towards tiers

## More Reading

  - [ ] https://www.import.io/post/how-to-win-a-kaggle-competition/
  - [ ] https://chrisdlangton.ghost.io/2017/04/21/week-1-kaggle-competition-melbdarathon2017/
  - [ ] http://tiberius.biz/ausdm09/index.html#4
  - [ ] https://www.kaggle.com/c/hhp#milestone-winners
  - [ ] https://www.kaggle.com/c/hhp#milestone-winners
  - [ ] [Datathon tutorial](https://docs.google.com/presentation/d/1LkurpfhvI9JAO_OCCJNgsU436mJBwMU3t9pv9knZmmE/edit#slide=id.g1d6e8e07d1_0_138)
  - [ ] https://inclass.kaggle.com/c/dsm2017/forums/t/31747/problems-about-training-data-truth?forumMessageId=176094#post176094
  - [ ] http://www.datasciencemelbourne.com/datathon/important-update/

