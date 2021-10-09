def binary_search(array, target):
    low = 0
    high = len(array) - 1
    while low <= high:
        mid = (low + high) // 2
        if target > array[mid]:
            low = mid + 1
        elif target < array[mid]:
            high = mid - 1
        elif target == array[mid]:
            return mid
    return "not found"
