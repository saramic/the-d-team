# MelbDatathon2017 - Kaggle competition 

As part of the MelbDatathon2017 there is a Kaggle competition to predict the
likely hood of someone taking Diabetes related medication.

## Questions

- [ ] do we get marks for people coming off medication? or do the 1's stay 1's
  for ever?

## Attempts

### Simple Linear regression

If useage is going clearly down mark as 0 if it is going up as 1 as per micro
analysis in [Pateint Year Illness](Patient_Year_Illness.ipynb)

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

