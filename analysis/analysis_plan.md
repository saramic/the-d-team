#Analysis plan
Here we'll set ou the steps in our analysis

##Data cleaning
Check for outliers in different variables
Variables like Age where there is hidden "missing data" (here birth year 1900)
How to treat missing data 
Ideas for new variables (features) that we would need:
e.g. buying delay = dispensed_week - prescription_week
Ideas for aggregation
unusual correlations (correlation matrix)
think about possible relation between variables (e.g. dispensed_week<prescription_week, buying delay > 1 year (check expiration))
understanding our data:
system codes - meaning (location, data providers, companies?)
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
which stores belong to which chains
coexisting chronic illness and order of acquiring


how being insured by Banner Group affects buying choices

uniform way of naming new variables

leaflet - create interactive map to check what are the biggest problems in certain areas


situation/complication/questions/solutions
