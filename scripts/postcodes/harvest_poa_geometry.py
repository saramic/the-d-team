#! /usr/bin/env python3
import requests
import time
import csv
from json import dumps

headers = {
    "Accept": "text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,*/*;q=0.8",
    "Accept-Encoding": "gzip, deflate, sdch, br",
    "Accept-Language": "en-US,en;q=0.8",
    "Connection": "keep-alive",
    "User-Agent": "Mozilla/5.0 (Macintosh; Intel Mac OS X 10_11_6) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/57.0.2987.133 Safari/537.36"
}

def get_all_responses(rows):
    for row in rows:
        api_call = row[1]
        response = requests.get(api_call, headers=headers)
        json = response.json()
        try:
            features = json['features'][0]
            attributes = features['attributes']
            geometry = features['geometry']
            yield list(attributes.values()) + [dumps(geometry)]
        except Exception as e:
            print(e)

        time.sleep(0.1)


if __name__ == "__main__":
    with open("postcode_urls.csv") as csv_file:
        reader = csv.reader(csv_file)
        responses = get_all_responses(reader)
        with open("output.csv", "w") as out_file:
            writer = csv.writer(out_file)
            writer.writerows(responses)
