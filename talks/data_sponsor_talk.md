Mike, Director and Founder of NostraData
Provides healthcare analytics and data integration services.

4000 retail pharmacies (72% of all), 3 major customers, 25 pharmaceutical companies

Product: CarePro --> predictive analytics to assess a patient's outcome based on medicines prescribed

ABS, Institute of Health and Welfare

They have over the counter data as well, but don't use it because it's not connected to specific customers.

16.7 million patients per year!

Repeat skipped: filled in a pharmacy not in our dataset!!!

He said we have some fields that we don't have, such as Type Code and EAN Code (barcode) and IsDoctorSpecialist
SOURCESYSTEMCODE FRED!!! 

Q&A

-> If financially viable, is it worthy to improve patient outcomes for a small group of patients?
A: Depends on severity of the disease --> yes --> then yes, unless not financially viable.
If something is not financially viable (e.g. cancer medicine), they approach the manufacturer to try and do it anyway.
Big primary care diseases (which can be dealth with by a GP), financial outcomes are more commercially viable
The more patients, the better the math. E.g. Diabetes.

-> To clarify your business model, why aren't you collecting prescriptions at the GP level rather than pharmacy level.
only 5k pharmacies but 120k doctors, and it wouldn't be better anyway. ROI does not stack up, doctors reluctant.
Unique information: 
* Compliance (are people taking meds), 
* Persistence (how long are you taking before you quit, e.g. depression).
missing piece: diagnosis, which is collected by Institute of Health and Welfare (poor reporting)
They currently assume 30 tables for 30 days rather than looking at DDD.

-> Relationship with stores, how does the data flow back to the pharmacies:
"Microstrategy" business intelligence to provide reporting before they had a financial model.
Pharmacies log into the website to access business intelligence report, running out of medicines, patient outcomes, retail information.
CarePro is the new one, which is better (predictive algorithms, warn when patients aren't taking medicine properly).
MedAdvisor uses this info as well to figure out patient compliance.

-> Granularity: is every single prescription separate: yes, dispense quantity will show amount.
Price is total for dispense quantity.
Regulation 24: more than one prescription at once (6 -> 0 repeats with no gap), when people go for holidays.
Repeats left excluded if equal to 1 or 0 .

Are they interested in substance abuse, yes. if they can convince the government, then the government has a duty of care.
codein or pseudoephedrine abuse are already tracked.

8 software providers, 32 POS providers, all accumulated.

30% of prescriptions, ERX electronic filling system for prescriptions, communication between doctors and pharmacies, don't know which ones.

Big Pharma: interested in effectiveness of drugs and how well they are taken.
Diabetes: pharmaceutical companies use nostradata to know how effective radical new medicines are, and how well doctors are prescribing it.
They pay for research, not for data.


Mapping between drugs and chronical illnesses.
> based on ATC code.

> female/male split, can you determine sex from prescriptions?
prostate drugs, pill, etc could deliver this information, hormone replacement therapies, androgens, etc.
Yes they can be used as markers.
Pharmaceutical companies and pharmacies not interested.

> 1990 birth dates
Population health study, how to infer children? based on them taking pediatric medication in recent years.

Panadol osteo: changed indication, now no longer on PBS. 

dispensary is critical to profit (more than 50%) and is what differentiates them from supermarkets.
Idea is to create value for patients rather than consumers.
70% of profits are from prescriptions

being cut from pbs reform
front of shop competes with 


Some addresses have PO BOX postcode??
postcode can be based on nursing home rather than patient.

From this conversation, it's obvious that they don't have a "deep learning" mindset.

Is there still room to improve the efficiency of pre-ordering drugs (as a pharmacy)?
> Yes, and there's another company that focuses on that (he could introduce us).
How good are they at predicting the future performance of indivdual drugs?
They are working on that, currently they use a monte carlo method to predict this,
but it's still quite crude and they are keen to improve it.

