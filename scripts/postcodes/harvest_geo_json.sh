cat small_data/postcode_urls.csv | xargs -L1 scripts/postcodes/to_geo_json.sh
