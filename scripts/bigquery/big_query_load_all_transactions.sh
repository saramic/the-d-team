if [ -z "$1" ]
  then
    echo "Loads all transactions from Google Cloud Storage into BigQuery."
    echo "Usage: ./big_query_load_all_transactions.sh <DATASET>.<TABLENAME>"
    exit 1
fi

bq load --nosync -F "\t" --skip_leading_rows=1 $1 gs://lookups-1234/transactions/patients_\*.txt Patient_ID:INTEGER,Store_ID:INTEGER,Prescriber_ID:INTEGER,Drug_ID:INTEGER,SourceSystem_Code:STRING,Prescription_Week:DATE,Dispense_Week:DATE,Drug_Code:STRING,NHS_Code:STRING,IsDeferredScript:BOOLEAN,Script_Qty:INTEGER,Dispensed_Qty:INTEGER,MaxDispense_Qty:INTEGER,PatientPrice_Amt:FLOAT,WholeSalePrice_Amt:FLOAT,GovernmentReclaim_Amt:FLOAT,RepeatsTotal_Qty:INTEGER,RepeatsLeft_Qty:INTEGER,StreamlinedApproval_Code:INTEGER
