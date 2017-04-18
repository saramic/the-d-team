# The D Team

The D team for the [Melbourne 2017
Datathon](http://www.datasciencemelbourne.com/datathon/)

## Data analysis

First steps in analysing the data.

  - [ ] What does it represent?
  - [ ] what do the fields mean?
  
    **column meanings added for transactions files, there are some questions to be asked during hackday 2**
    
  - [ ] how do the fields vary?
  - [ ] what is the value we can deliver and to whom?
  
    * **Government**
      + information about how NHS subsidizing policies shape medication consumption
      + interactive geospatial visualization and summary of medical spendings and seasonal patterns
      + disease trends
      + epidemic signals (daily data would give them even better predictive power)
      + drug oversuse
    * **Pharmacies**
      + how to predict the future consumption and stock properly, including data from NHS and seasonal trends
    * **Chain stores**
      + regions with high spending, finding good places for expanding business


## Questions and Answers

  - [x] What is the most popular drug by number of transactions?
    
    **Crestor**
    [analysis link](https://github.com/saramic/the-d-team/blob/master/analysis/Most_popular_drug.ipynb)

  - [x] What are the 10 most popular drugs?
    
    **CRESTOR, PANADOL OSTEO, LIPITOR, NEXIUM, COVERSYL, MICARDIS, SPIRIVA,
    NOTEN, ATACAND, SOMAC**
    [analysis link](https://github.com/saramic/the-d-team/blob/master/analysis/Most_popular_drug.ipynb)

  - [x] What is the trend of the 10 most popular drugs?

    **They are mostly in decline, some with very sharp drops (Crestor,
    Lipitor, Micardis), a few still growing(Panadol Osteo, Spiriva)**
    [analysis link](https://github.com/saramic/the-d-team/blob/master/analysis/Most_popular_drug.ipynb)

  - [ ] What are the 10 most popular drugs with regards to amount of daily doses sold?
  
  - [ ] What leads to sudden drops in some popular drugs?

  - [ ] Do many other drugs have sudden drops like Crestor, Lipitor, Micardis?
    what do they have in common?

  - [ ] Given that there is a general growth in useage, what is replacing the
    use of Crestor, Lipitor, Micardis?

  - [ ] In drug transactions over time, there is a peak every 3 months or so why?

  - [ ] In drug transactions over time, there is a peak in Dec and drop in Jan why?
    holidays? is it really so pronounced? ask a pharmacist?

  - [x] how many patients have an age?
    
    **only 6.8% - 37,809 out of 558,353**

  - [x] what is the distribution of age?
    
    **Peak around 1945**
    [analysis link](https://github.com/saramic/the-d-team/blob/master/analysis/File_field_analysis.ipynb)

  - [ ] is there a correlation between something and the patients who have an
    age? pharamcy? drug? particular source system?

  - [ ] what areas do we have no patients for? by postcode? are there any significant areas?

  - [ ] what are some of the characteristics of source systems by drug? geography? etc...

  - [ ] what is the distribution of drug prices?

  - [ ] what is the distribution vs ATC other?

  - [ ] what is the patient distribution compared to geography? city vs country? vs real population?

  - [ ] what correlations exist in the data? correlate all vs all and cluster?

  - [x] what is the age distribution for various illnesses?
    
    **peaks seem different for Depression compared to others**
    [initial analysis](analysis/Illness_overview.ipynb)
    - [ ] normalize against spread of data per age
    - [ ] normalize against each other to compare peaks
    
   - [ ] Does using certain drugs predicts development of additional illnesses in the future?

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

  infografic tool for final presnetation
  * a good list http://www.creativebloq.com/infographic/tools-2131971
  * is there a way to make a notebook look more like an infographic?
  * is a notebook exported to PDF enought?
  * demo of embedding [D3.js in notebook](https://github.com/cmoscardi/embedded_d3_example)
    * via [Embedding D3 in an IPython Notebook](http://blog.thedataincubator.com/2015/08/embedding-d3-in-an-ipython-notebook/)
  * can draw with [Ciaro](http://www.tortall.net/mu/wiki/CairoTutorial)
  * interactive with [Bokeh](https://www.analyticsvidhya.com/blog/2015/08/interactive-data-visualization-library-python-bokeh/)
  * some examples
    * https://flipboard.com/@vinayk/data-analysis-%2C-infographics%2C-tools-%26-examples-1qt8tkraz

  maps
  * read up more http://jupyter-gmaps.readthedocs.io/en/latest/gmaps.html
  * https://github.com/pbugnion/gmaps
  * https://github.com/ellisonbg/ipyleaflet
  * svg for area on map of region/postcode

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

    **Postcode categorisation**
    http://mams.rmit.edu.au/gdn3pkz4qzna1.pdf
    * 1) Inner Regional Australia
    * 2) Outer Regional Australia
    * 3) Remote Australia
    * 4) Very Remote Australia

    Or potentially this http://www.aihw.gov.au/rural-health-remoteness-classifications/

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
    * a good resource https://github.com/donnemartin/data-science-ipython-notebooks
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

## Results

Results from the data

