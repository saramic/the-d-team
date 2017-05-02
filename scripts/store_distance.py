#! /usr/bin/env python3

import csv
import itertools
import operator

stores = [ ( "Store 1", 1, 2, 3 ), ( "Store 2", 2, 3 ), ( "Store 3", 1), ("Store 4", 1, 2) ]

def calculate_weights(stores):
    for store_a_name, *store_a_patients in stores:
        for store_b_name, *store_b_patients in stores:
            if store_a_name <= store_b_name:
                continue

            visited_both = set(store_a_patients) & set(store_b_patients)
            visited_either = set(store_a_patients) | set(store_b_patients)

            if not (visited_both and visited_either):
                print("No connection between", store_a_name, store_b_name)
                continue

            distance = 1.0 / (len(visited_both) / len(visited_either))

            if distance <= 100.0:
                yield store_a_name, store_b_name, distance
            

if __name__ == "__main__":
    with open("./small_data/patient_stores_pairs.csv") as csv_file:
        pairs = csv.DictReader(csv_file)

        groups = itertools.groupby(pairs, key=operator.itemgetter("store_id"))

        stores = [ [int(store_id)] + [int(g["patient_id"]) for g in group] for store_id, group in groups]

        with open("./small_data/store_distances.csv", "w") as out_file:
            writer = csv.writer(out_file)
            writer.writerows(calculate_weights(stores))
