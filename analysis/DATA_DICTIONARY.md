# Data Dictionary

from http://www.datasciencemelbourne.com/datathon/data_dictionary/

## Main Data

    Store_ID                        – The unique identifier for each Pharmacy (Link to Store lookup table)
    SourceSystem_Code               – Identifies the dispensary system being used in the pharmacy
    Dispense_Date                   – The date when the script was dispensed
    Drug_Code                       – Internal drug code
    DrugMaster_ID                   – The unique identifier for each Drug (Link
                                      to Drug lookup table & Chronic illness lookup table)
    Type_Code                       – Drug type code, these codes are different for each SourceSystem_Code
    E.g. SourceSystem_Code ‘FRED’
                                    Value     Meaning
                                    N             NHS Script
                                    P             Private Script
                                    B             Doctors Bag Script
                                    T             Schedule Three Recordable Script
                                    R             Repatriation Script
                                    D             Dental Script
                                    E             Optometrist Script
                                    U             Nurse Practitioner Script
                                    F             Midwife Script
    EAN_Code                        – Drug Barcode
    NHS_Code                        – National Health Services code
    Status_Code                     – Drug status code (A- active)
    IsDeferredScript                – Whether a script has been differed to a
                                      later date (1-differed, 0-not differed)
    IsDoctorSpecialist              – Indicates a specialist doctor wrote the prescription
    Script_Qty                      – No. of packets on the script
    MaxDispense_Qty                 – Max No. of packets to be dispensed
    Dispensed_Qty                   – Actual No. of packets that were dispensed
    PatientPrice_Amt                – Value the patient paid to buy the drug
    WholeSalePrice_Amt              – Value the pharmacy paid to buy the drug
    GovernmentReclaim_Amt           – Value reimbursed by the government
    RepeatsTotal_Qty                – The number of times a script can be refilled
    RepeatsLeft_Qty                 – The number of refills left
    StreamlinedApproval_Code        – Drug restriction code
    HCPMasterPrescriber_ID          – Doctor ID
    MasterPatient_ID                – The unique identifier for each Patient
                                      (Link to Patient lookup table)
    Prescription_Date               – The date the prescription was made

## Patient lookup

    MasterPatient_ID                – The unique ID identifier for each Patient
    PostCode_Code                   – Patient postcode
    Birth_Date                      – Patient year of birth
    Gender_Code                     – Patient Gender (F- female, M- male, U- unknown)

## Store lookup

    StoreID                         – The unique identifier for each Pharmacy
    BannerGroupName                 – Pharmacy banner group (e.g. AMCAL,
                                      Chemist Warehouse, Guardian)
    StateCode                       – State location of pharmacy
    PostCode                        – Pharmacy postcode

## Drug lookup

    MasterProductID                 – The unique identifier for each Drug
    MasterProductCode               – Internal product code
    MasterProductFullName           – Complete drug name (including strength,
                                      form, and packet size)
    BrandName                       – Drug Name
    FormCode                        – Drug form (e.g. TAB- tablet, CAP-
                                      capsule, SR-CAP- slow release capsule,
                                      OINT- ointment, PFS- prefilled syringe,
                                      POWD – powder, (AMP, INJ, SYRNG)- syringe)
    StrengthCode                    – Drug strength (e.g. MG- milligram, MCG-
                                      microgram, ML- millilitre, 1% 10MG-
                                      Product is 10MG but active ingredient
                                      makes only 1% of product))
    PackSizeNumber                  – Number in packet (e.g. A product with
                                      form tablet and packet size 30 = Product
                                      has 30 tablets
    GenericIngredientName           – The active ingredient
    EthicalSubCategoryName          – Whether product is on the PBS
                                      (Pharmaceutical benefits scheme) or not
                                      and whether product is Branded (patented
                                      product), Substitutable (Was branded but
                                      patent has expired) or Generic
                                      (Competitor to substitutable product)
    EthicalCategoryName             – Whether product is on the PBS
                                      (Pharmaceutical benefits scheme) or not
    ManufacturerCode                – Manufacturer Code (A manufacturer may
                                      have multiple codes)
    ManufacturerName                – Manufacturer full name
    ManufacturerGroupID             – Manufacturer Grouping ID (A Group may
                                      have multiple manufacturers)
    ManufacturerGroupCode           – Manufacturer Grouping
    ChemistListPrice                – Product price
    ATCLevel5Code                   – (Link to ATC lookup table)
    ATCLevel4Code                   – (Link to ATC lookup table)
    ATCLevel3Code                   – (Link to ATC lookup table)
    ATCLevel2Code                   – (Link to ATC lookup table)
    ATCLevel1Code                   – (Link to ATC lookup table)

## Chronic Illness lookup

    ChronicIllness                  – Chronic Illness name
    MasterProductID                 – The unique identifier for each Drug
    MasterProductFullName           – Complete drug name (including strength,
                                      form, and packet size)

## ATC (Anatomical Therapeutic Chemical) lookup

    ATCLevel1Code                   – ATC level 1 code
    ATCLevel1Name                   – Anatomical main group
    ATCLevel2Code                   – ATC level 2 code
    ATCLevel2Name                   – Therapeutic main group
    ATCLevel3Code                   – ATC level 3 code
    ATCLevel3Name                   – Therapeutic/pharmacological subgroup
    ATCLevel4Code                   – ATC level 4 code
    ATCLevel4Name                   –  Chemical/therapeutic/pharmacological subgroup
    ATCLevel5Code                   – ATC level 5 code
    ATCLevel5Name                   – Chemical substance

