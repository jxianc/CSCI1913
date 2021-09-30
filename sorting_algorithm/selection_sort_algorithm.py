def swap(array, i, j):
    temp = array[i]
    array[i] = array[j]
    array[j] = temp


def selection_sort(array):
    for i in range(len(array) - 1):
        smallest_index = i
        for j in range(i + 1, len(array)):
            if array[j] < array[smallest_index]:
                smallest_index = j
        swap(array, i, smallest_index)
