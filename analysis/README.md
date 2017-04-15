# Analysis

`jupyter notebook` and take a browse around

  * File_field_analysis.ipynb
  * Most_popular_drug.ipynb

## Setting up Jupyter Python notebooks

**Jupyter Notebooks**

  [Installing Jupyter](http://jupyter.org/install.html)

**Requried libraries**

  `pip install -r requirements.txt`

**Maps**

**Google GMaps**

according to https://github.com/pbugnion/gmaps

    ```{bash}
    $ pip install -U jupyter
    $ jupyter nbextension install --py --sys-prefix widgetsnbextension
    $ jupyter nbextension enable --py --sys-prefix widgetsnbextension

    $ pip install gmaps
    $ jupyter nbextension install --py --sys-prefix gmaps
    $ jupyter nbextension enable --py --sys-prefix gmaps
    ```

finally configure the API key which I suggest via an environment variable

    export GMAP_API_THE_D_TEAM=AI...pc

then in the code you can refer to it

    gmaps.configure(api_key=os.environ['GMAP_API_THE_D_TEAM'])

Read more on how to use maps in notebooks

  http://jupyter-gmaps.readthedocs.io/en/latest/gmaps.html

**Leaflet**

https://github.com/ellisonbg/ipyleaflet

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

