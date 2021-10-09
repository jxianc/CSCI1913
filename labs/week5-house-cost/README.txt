Your Name(s): Jingxian Chai

Consider the following function:
def closest(lst, value, costs):
    if is_sorted_costs(lst, costs):
        return sorted_closest(lst, value, costs)
    else:
        return unsorted_closest(lst, value, costs)


This function, while correct, is not generally useful from an efficiency standpoint.
That is, we cannot expect this to perform faster than O(n) in any case. Why not?

This is because the worst case run time of the function unsorted_closest() is O(n). Considering the worst case scenerio 
of the function closest(), which is the given list is unsorted, the function unsorted_closest() will be runned instead of
the function sorted_closest(), which its worst case run time is O(log n). 