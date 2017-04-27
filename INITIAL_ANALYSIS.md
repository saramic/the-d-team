# Initial Analysis

## Data dictionary
  * [data schema](analysis/Database%20Diagram.pdf)
  * [File Field Analysis](analysis/File_field_analysis.ipynb)
  * [DATA DICTIONARY](analysis/DATA_DICTIONARY.md)

## Questions and Answers

	**Short List**

	* final report
		- [ ] beginning cartoon
			- [ ] off side but interesting findings
		- [ ] 3 core finding streams
		- [ ] the details
		- [ ] conculusion/next steps

	* try techniques
		- [ ] network diagram like D3.js or Gephi
		- [ ] based on GraphX
			- [ ] page rank on pharmacies as ranked by patients of other pharmacies, or
						pateints of same drug, etc
			- [ ] triangle distance on patients and drug and store and prescriber
			- [ ] deriving taxonomies with MST
						text analysis done using Word2vec and googles news wire data set
    - [ ] based on examples from Spark in action book
      - [ ] MLlib classification and clustering
    - [ ] based on examples from Deep Learning with Python - using Keras
			- [ ] binary classification - like classifying IMDB movie reviews
			- [ ] multi-class classification - like classifying newswires
			- [ ] regression - like predicting house prices
	  - [ ] linear regression http://tutorials.iq.harvard.edu/R/Rstatistics/Rstatistics.html
		- [ ] on random forrests but quite old? https://www.youtube.com/watch?v=kwt6XEh7U3g
		- [ ] plot forest importance http://scikit-learn.org/stable/auto_examples/ensemble/plot_forest_importances.html

	* get data
		- [ ] [SEIFA](http://www.abs.gov.au/websitedbs/censushome.nsf/home/seifa)

	* charting examples
	  - [ ] [complex graphs tute](http://tutorials.iq.harvard.edu/R/Rgraphics/Rgraphics.html)
		- [ ] ggplot `facet_grid` from [Harvard RProgramming
					Tute](http://tutorials.iq.harvard.edu/R/RProgramming/Rprogramming.html#final_england_and_wales_data_cleanup)
	  - [ ] infographic and graph ideas in health care http://marketrealist.com/2016/03/generic-drugs-aid-curtail-health-care-costs/

	- [ ] Patent drop offs
		- [ ] who are the patients? prescribers? stores? socio economic areas?
		- [ ] what can be predicted on drugs going out of patent?
		- [ ] how can patient switches be catacorised?
    - [ ] what is the cost/profit impact?
		- [ ] is there a useage increas?
		- [ ] why was there an observed cost and travel increas on lipitor?
		- [ ] patent expiry past and present
			- [ ] [Pharmacomasss Patent Expiry](http://www.pharmacompass.com/patent-expiry-expiration) with our data set.
  		- [ ] parse this https://newdrugapprovals.org/patent-expiry/
  		- [ ] and this https://www.drugs.com/article/patent-expirations.html

  - [ ] how far do patients buy from?

	**Long List**

  - [x] What is the most popular drug by number of transactions?
    
    **Crestor**
    [Most Popular Drug NB](analysis/Most_popular_drug.ipynb)

  - [x] What are the 10 most popular drugs?
    
    **CRESTOR, PANADOL OSTEO, LIPITOR, NEXIUM, COVERSYL, MICARDIS, SPIRIVA,
    NOTEN, ATACAND, SOMAC**
    [Most Popular Drug NB](analysis/Most_popular_drug.ipynb)

  - [x] What is the trend of the 10 most popular drugs?

    **They are mostly in decline, some with very sharp drops (Crestor,
    Lipitor, Micardis), a few still growing(Panadol Osteo, Spiriva)**
    [Most Popular Drug](analysis/Most_popular_drug.ipynb)

    **Lipitor went out of patent Nov 2011 and by Jan 2012 70% of users switched
    onto generics**
    [initial analysis](analysis/Lipitor_replacement.ipynb)

  - [x] In drug transactions over time, there is a peak in Dec and drop in Jan why?
    holidays? is it really so pronounced? ask a pharmacist?

		**More people reaching the safety net** in fact the last days of the year
		are businest for chemists as the saftey net resets on 1st Jan

  - [x] how many patients have an age?
    
    **only 6.8% - 37,809 out of 558,353**
    
  - [x] how many different postcodes to patients buy from?

    **35 for patient 109876 and only around half buy from 1**
    [analysis](analysis/Stores_per_patient.ipynb)

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
    
   - [ ] Does using certain drugs predict development of additional illnesses in the future?
   
   - [ ] What can be expected about drugs popularity based on NHS subsidizing updates each year?

   - [x] how much money is being made per store?

    **up to $1.75M per year per store in Inner Regional Australia in NSW,
    interestingly there was a peak in 2012 and currently a decline**
    [analysis](analysis/Sales_per_store_by_region.ipynb)

   - [ ] Can we predict the specialisation of physicians (prescribers) based on their prescriptions?

   - [ ] Do prescribers exhibit brand loyalty when prescribing drugs?

   - [ ] Can we predict the approximate location/concentration of prescribers based on postcodes?

   - [ ] Can we predict the spread of viral/bacterial diseases (flu, cold, etc)?

   - [ ] are there any signs of epidemics where stores in a particular area
     have an exponential growthi in a particular drug?

## Delivery Focus

  * What value can we deliver and to whom?
    * **Government**
      + information about how NHS subsidizing policies shape medication consumption
      + improve yearly reporting, their summaries are hard to digest https://www.pbs.gov.au/statistics/2014-2015-files/exp-prs-book-01-2014-15.pdf
      + interactive geospatial visualization and summary of medical spendings and seasonal patterns
      + disease trends
      + epidemic signals (daily data would give them even better predictive power)
      + drug oversuse
    * **Pharmacies**
      + how to predict the future consumption and stock properly, including data from NHS and seasonal trends
    * **Chain stores**
      + regions with high spending, finding good places for expanding business

## Questions

  **Suggested questions**

  _from the competition guidelines_

  *  Are there any data quality issues?
  *  Are there any demographic patterns in illnesses?
  *  Which pharmacies have best patient loyalty; is loyalty age skewed?
  *  Distribution of packet sizes (are larger pack sizes favoured, why?
     Does this change by geographical location?)
  *  Are generic medicines favoured by any geographical location, age or gender?
  *  Any explanation of the seasonal demand patterns?
  *  Any specific seasonal patterns for particular drugs?
  *  Any suspicious behavior in the data?
  *  Can patients be clustered by drug usage patterns?
  *  Any insights about where the trajectory of the health of Australia is heading?

  **Questions for hackday 2**

  - [ ] What happens to patient ID when patient moves to a new city (post code is assigned to patient ID)?   
  - [ ] What happens to store ID when a pharmacy owner changes/it joins or leaves a banner group?
  - [ ] What are the interpretations of the columns with to be confirmed status in Field Analysis file?
  
## Bad data

  - 1900 births
  - postcode in data wrong `1212	QLD	5615	1` should be 4615 for Qld
  - store `408	TAS	NULL	0` has no postcode
  - postcode in our data out of date

      SELECT 5090 AS postcode
      , 'Hope Valley' AS suburb
      , 'SA' AS state
      , 'NULL' AS dc
      , 'NULL' AS type
      , -34.847 AS lat
      , 138.699 AS lon
      , 0 AS regional_category
      , 'Metropolitan' AS regional_name

  - duplicate records 2 million for Tasmania
  - 150 patients with an invalid postcode < 800, feels like the last number was
    dropped? is it regular like a page turn?

## Other Data sets

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
		[Socio Economic Index For Areas](http://www.abs.gov.au/websitedbs/censushome.nsf/home/seifa)

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

  * **Patent Expiry**
    * simple list with dates from [Pharmacomasss Patent Expiry](http://www.pharmacompass.com/patent-expiry-expiration)
    * some past expiries https://newdrugapprovals.org/patent-expiry/
    * more links to patent expiry, how to calculate etc https://www.informationvine.com/index?qsrc=999&qo=semQuery&ad=semD&o=36180&l=sem&askid=a3de4dcd-9b5d-4037-b8d9-d2eceec7ea14-0-iv_gsb&q=patent%20expiration%20dates&dqi=&am=broad&an=google_s
    * $75 for 10 day access but some preview https://www.drugpatentwatch.com/p/patent-expiry/2017

  * **More on drugs**
    * things like sideffects https://www.drugs.com/drug_information.html
    * by patent like https://www.google.com/patents/US6011020
    * including images http://www.webmd.com/drugs/2/drug-64439/abilify-oral/details#images
    * also https://pubchem.ncbi.nlm.nih.gov/compound/24847876
    * on generics http://marketrealist.com/2016/03/generic-drugs-aid-curtail-health-care-costs/
      in particular small infographic on cost saving
    * more on projections of pharmaceuticals https://www.drugs.com/slideshow/looking-ahead-pharma-projections-for-2016-and-beyond-1230

  * **Social Media**
    * [Mining twitter data](http://tutorials.iq.harvard.edu/Python/twitter/)

## Tools

  infografic tool for final presnetation
  * a good list http://www.creativebloq.com/infographic/tools-2131971
  * is there a way to make a notebook look more like an infographic?
  * is a notebook exported to PDF enought?
  * demo of embedding [D3.js in notebook](https://github.com/cmoscardi/embedded_d3_example)
    * via [Embedding D3 in an IPython Notebook](http://blog.thedataincubator.com/2015/08/embedding-d3-in-an-ipython-notebook/)
    * [D3 gallery](https://github.com/d3/d3/wiki/Gallery)
  * can draw with [Ciaro](http://www.tortall.net/mu/wiki/CairoTutorial)
  * interactive with [Bokeh](https://www.analyticsvidhya.com/blog/2015/08/interactive-data-visualization-library-python-bokeh/)
  * some examples
    * https://flipboard.com/@vinayk/data-analysis-%2C-infographics%2C-tools-%26-examples-1qt8tkraz
    * [How to design infographics](https://designschool.canva.com/how-to-design-infographics/)
    * lot's of visualization demos http://www.visualisingdata.com/resources/
    * [sparklines on map demo](http://www.datascienceassn.org/content/geosparkgrams-tiny-histograms-map-ipython-notebook-and-d3js)
    * [GIS information visualisation](https://au.pinterest.com/jennybarnard157/gis-information-visualisation/)
    * [GIS visualization](https://au.pinterest.com/jcramac/gis/)
    * [Visualization](https://au.pinterest.com/bhayek02/visualization/)
    * [Beautiful plots with Pandas and matplotlib](https://datasciencelab.wordpress.com/2013/12/21/beautiful-plots-with-pandas-and-matplotlib/)
    * http://dataviz.tools/category/interactive-charting/
  
  visualization
  * shiny & shiny dashboard in R https://rich.shinyapps.io/college_map/  https://www.showmeshiny.com/response-times/
  * Bokeh for Python http://bokeh.pydata.org/en/latest/docs/gallery.html
  * d3.js https://github.com/d3/d3/wiki/Gallery
  
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
  - [ ] visualisation with React and D3.js

