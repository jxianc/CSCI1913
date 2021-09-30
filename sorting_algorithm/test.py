from merge_sort_algorithm import merge_sort
from selection_sort_algorithm import selection_sort
from insetion_sort_algorithm import insertion_sort

array = [23, 39, -17, 4, 69, 1, -27]

# # merge sort
# print("before merge sorting, array: {}".format(array))
# merge_sort(array, 0, len(array) - 1)
# print("after merge sorting, array: {}".format(array))

# # selection sort
# print("before selection sorting, array: {}".format(array))
# selection_sort(array)
# print("after selection sorting, array: {}".format(array))

# insertion sort
print("before insertion sorting, array: {}".format(array))
insertion_sort(array)
print("after insertion sorting, array: {}".format(array))
