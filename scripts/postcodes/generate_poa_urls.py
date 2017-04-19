import csv

URL = "https://censusdata.abs.gov.au/arcgis/rest/services/ASGS2016/ASGS2016BoundariesOnline/MapServer/11/query?text={0}&geometry=&geometryType=esriGeometryEnvelope&inSR=&spatialRel=esriSpatialRelIntersects&relationParam=&objectIds=&where=&time=&returnCountOnly=false&returnIdsOnly=false&returnGeometry=true&maxAllowableOffset=&outSR=&outFields=*&f=pjson"

def get_all_urls(rows):
    for row in rows:
        api_call = URL.format(row[0])
        yield (row[0], api_call)

if __name__ == "__main__":
    with open("small_data/postcode_remotness_category.csv") as csv_file:
        reader = csv.reader(csv_file)
        responses = get_all_urls(reader)
        with open("output.json", "w") as out_file:
            writer = csv.writer(out_file)
            writer.writerows(responses)
