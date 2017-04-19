if [ -z "$1" ]
  then
    echo "Loads all ATC DDD information from Google Cloud Storage into BigQuery."
    echo "Usage: ./big_query_load_postcode_boundaries.sh <DATASET>.<TABLENAME>"
    exit 1
fi

bq load --nosync -F "," --skip_leading_rows=1 $1 gs://lookups-1234/postcode_boundaries.csv POA_CODE_2016:INTEGER,POA_NAME_2016:STRING,AREA_ALBERS_SQKM:FLOAT,OBJECTID:INTEGER,GEOMETRY_JSON:STRING
