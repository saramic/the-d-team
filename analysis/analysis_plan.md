# Analysis plan
Here we'll set ou the steps in our analysis

## Steps for Data Cleaning
* Check for outliers in different variables, data which does not find any relevance  

* Identify more variables where there might be missing data such as age (birth year 1990) and find ways to find relationship between varibles  

* Identify new variables that would be required to required to gain more information about the data * * e.g buying delay = dispensed_week - prescription_week 

* Find how corelated variables are with each other by coming up with corelation matrix 

* Ideas for aggregation ( ? what does it mean ?) 

*  Identify more variables that will help to  understand the data better * * e.g dispensed week and prescription week, buying delay (year wise)*

* Michal was working on finding the relationship between system codes in the patients file to understand the relevance *  

* isbannergroup - banner group is a group of pharmacies using one branding, but the owners have almost full autonomy in local advertising choice, is the owner of property etc. It's not a franchise and not a chain pharmacy.*

**Trcking the migration pattern**
* How does the health is affected when people move from one region to another 
* When the patient moves to area with new postcode is the patient alloted new ID or old ID is carried forward 


* NA in the gender- What has to be done with this 

* Check what are the data formats for each variable and whether they are correct or need to some varible change ( int, string, date)

* Find the missing cross references between lookups and trasanction files - state all the reasons 

* Which data can be useful in categorical form (? Did not understand the meaning to ellaborate)

**Find relation between dose recommended and patients**
* Does new drug have effect in the buying pattern
* Is there a way to find whether there is a case where the couples share a disease and are given one presecription
* Is there a way to identify the overusage of drugs ( can be looked at the buying pattern of patients)
* Come up with new variable (such as min recommended or max daily intake per drug) and relate them with amount of doses bought (can be found by using size of packging in drug lookup 
* Check is there a delay between when the person will buy and when the dose will get over 

* Is there a pattern between the treatment and when there are not eough drugs available 

* Amount of drugs overall to the person diagonised with diseases 



**Findings from Michal**
* Which stores belong to which chains - checked, too difficult/impossible to enrich current data coexisting chronic illness and order of acquiring

* Uniform way of naming variables

**Can we come up with an interactive map to show what are the biggest problems in certain areas**

**Seasonlity**
* Find the sesonality between the outbrusts of the diseases 
* How does seasonlity factor has affect on different location 
* When the new medicine outbreaks in the market, does it have affect on buying pattern or change in the recommended usage 
* Which cities are early adopters of new medication
* Can it be used to predict how well it will fare in the rest of the country or early adopters based on any aggregation

**Need to shift all the questions in trello in the structured form of situation/complication/questions/solutions with proper descroption** 
* Need to find a place where this can be done - excel of kanban


* Find a link betweeen mdedication PBS and medication prices
* How does the annual update effect the consumption ( ?update of what?)
* related columns GovernmentReclaim_Amt, Ethical_sth
* Investigate the relation between whole sale price and patient price 
* Look for more medication programs other than PBS
* Look for immunisation statistics 
* Look for the revenue in general ( reuse the app )
* How advertising influence sales 
* Understand the doctor and patient behaviour 



Variables like Age where there is hidden "missing data" (here birth year 1900)
How to treat missing data 
Ideas for new variables (features) that we would need:
e.g. buying delay = dispensed_week - prescription_week
Ideas for aggregation
unusual correlations (correlation matrix)
think about possible relation between variables (e.g. dispensed_week<prescription_week, buying delay > 1 year (check expiration))
understanding our data:
system codes - meaning (location, data providers, companies?)
isbannergroup - banner group is a group of pharmacies using one branding, but the owners have almost full autonomy in local advertising choice, is the owner of property etc. It's not a franchise and not a chain pharmacy.

we could try tracking the migration patterns (patient ID permanently changing the store ID with specific post code or find people
travelling a lot, how does it affect health)
what happens when a patient moves (new ID with new postcode/patient is updated and only last pc is stored/first postcode used)
what to do with unknown gender
correct data formats in variables (int, date, string)
missing cross references between files/lookups - possible reasons
which continuous data could also be useful in categorical form
checking which patients take the required dose (buy new drugs often enough, could be a problem if a couple sharre a disease and are
given one prescription)
detecting overuse of drugs (e.g. painkillers/psychotropic) - patient buys more often than required by maximum dose
new variables - min/recommended/max daily intake per drug + 
for each transaction - amount of recommended/max daily doses bought,based on the data about size of the packaging in drug lookup
check how it relates to days between buying
if not enough drugs - how it affects the treatment
relate amount of certain drugs overall to people diagnosed with diseases (chronic)
detecting/predicting outbursts of diseases
which stores belong to which chains - checked, too difficult/impossible to enrich current data
coexisting chronic illness and order of acquiring



uniform way of naming new variables

leaflet - create interactive map to check what are the biggest problems in certain areas

how to treat/incorporate in the model the seasonality, any other special apart from yearly?
how does seasonality change with location
how new medication/change of recommended drug per disease results in amounts sold
which cities are early adopters of new medication, can it be used to predict how well it will fare in the rest of the country?
or early adopters based on any aggregation

situation/complication/questions/solutions - in what tool? kanban/excel

create a description for each column - share files and find the meaning

resources link in trello - add there

subsidizing for medication PBS, how does it link to medication prices, how annual updates affect medication consumption
related columns GovernmentReclaim_Amt, Ethical_sth
investigate how wholesale is related to patient price
different medidcation programs, other than PBS
vaccines - immunisation statistics
revenue in general, reuse the map app
how advertising influences sales, doctor behavior/patient behavior
