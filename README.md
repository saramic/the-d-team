# The D Team

The D team for the [Melbourne 2017
Datathon](http://www.datasciencemelbourne.com/datathon/)

## Data analysis

First steps in analysing the data.

  - [ ] What does it represent?
  - [ ] what do the fields mean?
  - [ ] how do the fields vary?
  - [ ] what is the value we can deliver and to whom?

## Questions

Suggested questions to ask (from the competition guidelines)

  - [ ] Are there any data quality issues?
  - [ ] Are there any demographic patterns in illnesses?
  - [ ] Which pharmacies have best patient loyalty; is loyalty age skewed?
  - [ ] Distribution of packet sizes (are larger pack sizes favoured, why?
        Does this change by geographical location?)
  - [ ] Are generic medicines favoured by any geographical location, age or gender?
  - [ ] Any explanation of the seasonal demand patterns?
  - [ ] Any specific seasonal patterns for particular drugs?
  - [ ] Any suspicious behavior in the data?
  - [ ] Can patients be clustered by drug usage patterns?
  - [ ] Any insights about where the trajectory of the health of Australia is heading?

## Tools

  maps
  * read up more http://jupyter-gmaps.readthedocs.io/en/latest/gmaps.html
  * https://github.com/pbugnion/gmaps
  * https://github.com/ellisonbg/ipyleaflet

  interactive python notebooks
  * https://github.com/jupyter-widgets/ipywidgets
  * BQ 2D plot - https://github.com/bloomberg/bqplot
  * three.js 3D plots - https://github.com/jovyan/pythreejs
  * take a look at the demo widgets -
    https://github.com/jupyter-widgets/ipywidgets/blob/master/docs/source/examples/Index.ipynb

  ggplot in python
  * [quick demo chart](http://ggplot.yhathq.com/)
  * [aggregating and plotting time series](http://blog.yhat.com/posts/aggregating-and-plotting-time-series-in-python.html)
  * [ggplot for python blog](http://blog.yhat.com/posts/ggplot-for-python.html)

  CRISP-DM
  * https://www.the-modeling-agency.com/crisp-dm.pdf
  * http://101.datascience.community/tag/crisp-dm/

  ATC
  * https://en.wikipedia.org/wiki/Anatomical_Therapeutic_Chemical_Classification_System
  * harverster - https://github.com/AlexisEidelman/medicam

## Data sets

  * **Postcode geolocation**
    via http://www.corra.com.au/australian-postcode-location-data/ in
    http://www.corra.com.au/downloads/Australian_Post_Codes_Lat_Lon.zip
    alternative is to use http://v0.postcodeapi.com.au/

  * Census

  * **Health Direct Medicine catalogue**
    https://www.healthdirect.gov.au/medicines/search-results/A?pageIndex=1.1
    like
    https://www.healthdirect.gov.au/medicines/brand/amt,746141000168100/ceftazidime-mylan

  * **CMI - Consumer Medicine Information**
    from Health Direct link
    https://www.ebs.tga.gov.au/ebs/picmi/picmirepository.nsf/pdf?OpenAgent&id=CP-2016-CMI-01672-1&d=2017041516114622483

  * **PBS**
    * from Health Direct Link
      http://www.pbs.gov.au/pbs/search?term=cefotaxime&analyse=false&search-type=medicines
    * Pharmaceutical Benefits Scheme https://www.pbs.gov.au/info/browse/download
      not sure how useful, it has a lot of doseage and potentially a characterisation like ATC?


## Techniques

Techniques to try on the data - based on examples/samples from books etc.

  - [ ] Python/R notebooks
  - [ ] Deep Learning
    * based on examples from Deep Learning with Python - using Keras
      - [ ] binary classification - like classifying IMDB movie reviews
      - [ ] multi-class classification - like classifying newswires
      - [ ] regression - like predicting house prices
    * based on examples from ML with Tensor Flow
      - [ ] linear regression
      - [ ] classification
      - [ ] automatic clustering
      - [ ] hidden markov models
      - [ ] autoencoders
      - [ ] reinforcement learning
      - [ ] convolutional neural networks
    * based on fast.ai course
      - [ ] image classification
      - [ ] ...
  - [ ] Spark
    * based on examples from GraphX in action book
      - [ ] page rank
      - [ ] personalized page rank
      - [ ] connectedness through triangle count
      - [ ] shortest path
      - [ ] deriving taxonomies with MST
            text analysis done using Word2vec and googles news wire data set
    * based on examples from Spark in action book
      - [ ] MLlib classification and clustering
  - [ ] BigQuery - can we store data there? does this pipeline make sense
  - [ ] other
    - [ ] NLP
    - [ ] Taming Text book on text specific
    - [ ] Pentaho mondrial - Tableau like OLTP dashboard
    - [ ] Real World Machine Learning
    - [ ] solr, lucene, sphinx - search engines
  - [ ] processing
    - AWS
    - Google Data Proc
    - local laptop
    - Databricks cluster
    - other?
  - [ ] visualisation with React and D3.js

## Results

Results from the data

