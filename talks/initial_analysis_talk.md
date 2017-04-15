First talk:

# CRISP-DM, the data science process

* Business/Data Understanding
* Data Preparation
* Modelling/Analysis
* Evaluation

[We could use this to help frame our work.](https://en.wikipedia.org/wiki/Cross_Industry_Standard_Process_for_Data_Mining)

# Insights competition

Understanding the Problem:

1. Situation
2. Complication
3. Questions
4. Solution

Reverse brief stakeholders.

# Kaggle - Diabetes

* Define a target
* Samples
* Training dataset
* Train a model
* estimate performance without submitting

## Dataset overview

Part of the data has been withheld (drop in transaction volume) to evaluate kaggle competition.

Steps
--> Define a target
1. Get a list of customers who were prescribed diabetes medication in 2016
2. Flag all patients as diabetic/non-diabetic

--> Training, Test, Validation datasets

--> Create some features 
* e.g. count of prescriptions per patient id split by chronical illness

--> Build a model (e.g. using R library 'caret')

