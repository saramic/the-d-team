# Analysis

`jupyter notebook` and take a browse around

  * File_field_analysis.ipynb
  * Most_popular_drug.ipynb

## Setting up Jupyter Python notebooks

**Jupyter Notebooks**

  [Installing Jupyter](http://jupyter.org/install.html)

**Requried libraries**

  `pip install -r requirements.txt`

**Google Cloud**

I started looking at this but am not convinced we need this if we can do a `pandas.read_gbq`

  * Following along with [GCloud clinet
    libraries](https://cloud.google.com/bigquery/docs/reference/libraries#client-libraries-install-python)
  * `pip install --upgrade google-cloud-bigquery`
  * Install [Google Cloud SDK](https://cloud.google.com/sdk/docs)
  * authenticate by running `gcloud auth application-default login`
  * now you should be able to run BigQuery queries from ipython notebook

      from google.cloud import bigquery
      client = bigquery.Client(project=project_id)
      dataset = client.dataset('dthon')
      print(list(dataset.list_tables()))

