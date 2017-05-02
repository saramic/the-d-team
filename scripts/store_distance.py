stores = [ ( "Store 1", 1, 2, 3 ), ( "Store 2", 2, 3 ), ( "Store 3", 1), ("Store 4", 1, 2) ]
print(stores)

for store_a_name, *store_a_patients in stores:
    for store_b_name, *store_b_patients in stores:
        if store_a_name <= store_b_name:
            continue

        visited_both = set(store_a_patients) & set(store_b_patients)
        visited_either = set(store_a_patients) | set(store_b_patients)

        if not (visited_both and visited_either):
            print("No connection between", store_a_name, store_b_name)
            continue
        distance = ( ( len(visited_both) )  / len(visited_either) )
    

        print("Distance between", store_a_name, "and", store_b_name, distance)
        
