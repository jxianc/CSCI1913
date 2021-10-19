def swap(array, i, j):
    temp = array[i]
    array[i] = array[j]
    array[j] = temp


def insertion_sort(array):
    for first_unsorted_index in range(1, len(array)):
        for i in range(first_unsorted_index, 0, -1):
            if array[i] < array[i - 1]:
                swap(array, i, i - 1)

print("asd")