def merge_sort(array, start, end):
    if start >= end:
        return
    mid = (start + end) // 2
    merge_sort(array, start, mid)
    merge_sort(array, mid + 1, end)
    merge(array, start, mid, end)


def merge(array, start, mid, end):
    if array[mid] < array[mid]:
        return
    i = start
    j = mid + 1
    k = 0
    temp_array = []
    temp_array_size = end - start + 1
    for _ in range(temp_array_size):
        temp_array.append(0)
    while i <= mid and j <= end:
        if array[i] < array[j]:
            temp_array[k] = array[i]
            k += 1
            i += 1
        else:
            temp_array[k] = array[j]
            k += 1
            j += 1
    while i <= mid:
        temp_array[k] = array[i]
        k += 1
        i += 1
    while j <= end:
        temp_array[k] = array[j]
        k += 1
        j += 1
    for element in temp_array:
        array[start] = element
        start += 1
