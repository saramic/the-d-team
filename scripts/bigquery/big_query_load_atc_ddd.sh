if [ -z "$1" ]
  then
    echo "Loads all ATC DDD information from Google Cloud Storage into BigQuery."
    echo "Usage: ./big_query_load_atc_ddd.sh <DATASET>.<TABLENAME>"
    exit 1
fi

bq load --nosync -F ";" --skip_leading_rows=1 $1 gs://lookups-1234/atc-ddd.csv ATC_CODE:STRING,ANATOMICAL_MAIN_GROUP:STRING,THERAPEUTIC_SUBGROUP:STRING,PHARMACOLOGICAL_SUBGROUP:STRING,CHEMICAL_SUBGROUP:STRING,CHEMICAL_SUBSTANCE:STRING,DDD:FLOAT,UNIT:STRING,ADM_R:STRING,NOTE:STRING
