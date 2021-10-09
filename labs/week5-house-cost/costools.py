sorted_lst = [
    "house0",
    "house1",
    "house2",
    "house3",
    "house4",
    "house5",
    "house6",
    "house7",
    "house8",
    "house9",
    "house10",
    "house11",
    "house12",
]

unsorted_lst = [
    "house11",
    "house5",
    "house9",
    "house4",
    "house10",
    "house2",
    "house1",
    "house8",
    "house3",
    "house12",
    "house0",
    "house7",
    "house6",
]

test_costs_sorted = {
    "house0": 120,
    "house1": 150,
    "house2": 180,
    "house3": 200,
    "house4": 230,
    "house5": 250,
    "house6": 270,
    "house7": 280,
    "house8": 300,
    "house9": 305,
    "house10": 310,
    "house11": 320,
    "house12": 335,
}

def is_sorted_costs(lst, costs):
    '''
    this function checks if the given list is sorted
    parameters: 
        (1) lst - a list of strings representing products names
        (2) costs - a dictionary from strings (product names) to costs
    return:
        True if list is sorted
        False if list is unsorted
    '''
    for i in range(len(lst) - 1):
        # compare the values
        if costs[lst[i]] > costs[lst[i + 1]]:
            return False    # previous is larger, therefore list is unsorted
    return True


def unsorted_insert(lst, key):
    '''
    this function insert the given key into a given unsorted list
    parameters: 
        (1) lst - a list of strings representing products names
        (2) key - a string representing a product not currently in the list
    '''
    if key not in lst:
        lst.append(key)

def sorted_insert(lst, key, costs):
    '''
    this function insert the given key into a given sorted list
    parameters: 
        (1) lst - a list of strings representing products names
        (2) key - a string representing a product not currently in the list
        (3) costs - a dictionary from strings (product names) to costs
    '''
    # edge and corner case
    if costs[key] < costs[lst[0]]:
        lst.insert(0, key)
    elif costs[key] > costs[lst[-1]]:
        lst.insert(len(lst), key)
    else:
        # general case
        index = 0
        for cost in costs.values():
            if costs[key] > cost:
                index += 1
            else:
                break
        lst.insert(index, key)

def unsorted_closest(lst, value, costs):
    '''
    this function find the product in the unsorted product list that is closest to the target value
    parameters:
        (1) lst - a unsorted list of strings representing product names
        (2) value - a float representing a target cost
        (3) costs - a dictionary from strings (product names) to costs
    return:
        a product that is closest to the target value
    '''
    # a dictionary where the key is the difference between value and cost,
    # and the value is the house
    diff_with_house = {}
    for house in lst:
        diff = abs(value - costs[house])
        diff_with_house[diff] = house
    return diff_with_house[min(diff_with_house.keys())]

def sorted_closest(lst, value, costs):
    '''
    this function find the product in the sorted product list that is closest to the target value
    parameters:
        (1) lst - a sorted list of strings representing product names
        (2) value - a float representing a target cost
        (3) costs - a dictionary from strings (product names) to costs
    return:
        a product that is closest to the target value
    '''
    # initialize low and high
    low = 0 
    high = len(lst) - 1
    # edge and corner case
    if value > costs[lst[high]]:
        return lst[high]
    elif value < costs[lst[low]]:
        return lst[low]
    # general case
    while (low <= high):
        mid = (low + high) // 2 
        if costs[lst[mid]] == value:
            return lst[mid]
        elif costs[lst[mid]] < value and value < costs[lst[mid + 1]]:
            # value in between, thus calculate the difference
            left_diff = value - costs[lst[mid]]
            right_diff = costs[lst[mid + 1]] - value
            # return the smaller one
            return lst[mid] if left_diff < right_diff else lst[mid + 1]
        elif costs[lst[mid]] < value:
            low = mid + 1
        elif costs[lst[mid]] > value:
            high = mid - 1