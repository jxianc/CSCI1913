# Jingxian Chai, Janani Kannan
import math

# find the heights difference, take 2 arguments (2 different height) and return the difference of 2 heights
def heights_difference(h1, h2):
    return h1 - h2

# check the length of the list
def check_list_length(list, number):
    if (len(list) < number):
        return True
    else:
        return False

def steepest_angle(heights):
    is_not_enough = check_list_length(heights, 2)
    if is_not_enough:
        return 0
    else:
        diff_list = []
        for i in range(0, len(heights) - 1):
            diff = heights_difference(heights[i], heights[i + 1])
            if diff < 0:
                diff = abs(diff)
            diff_list.append(diff)
        max_diff = max(diff_list)
    return math.atan2(max_diff, 1) * 180 / math.pi

def total_distance(heights):
    is_not_enough = check_list_length(heights, 2)
    if is_not_enough:
        return 0
    else:
        distance_sum = 0
        for i in range(0, len(heights) - 1):
            distance = math.sqrt((heights[i] - heights[i + 1]) ** 2 + 1)
            distance_sum += distance
        return distance_sum

def longest_sequential_climb(heights):
    is_not_enough = check_list_length(heights, 2)
    if is_not_enough:
        return 0
    else:
        sequential_sum = 0
        sequential_sum_list = []
        for i in range(0, len(heights) - 1):
            diff = heights_difference(heights[i], heights[i + 1])  
            if diff < 0:
                distance = math.sqrt((heights[i] - heights[i + 1]) ** 2 + 1)
                sequential_sum += distance
            else:
                # sequential sum break, insert sum into list, reset the sequential sum
                sequential_sum_list.append(sequential_sum)
                sequential_sum = 0
        # find the maximum value in the list
        return max(sequential_sum_list)

def num_of_peaks_and_valleys(heights):
    is_not_enough = check_list_length(heights, 3)
    peaks = 0
    valleys = 0
    if is_not_enough:
        return (peaks, valleys)
    else:
        for i in range(1, len(heights) - 1):
            left_diff = heights_difference(heights[i], heights[i - 1])
            right_diff = heights_difference(heights[i], heights[i + 1])
            if left_diff > 0 and right_diff > 0:
                peaks += 1
            elif left_diff < 0 and right_diff < 0:
                valleys += 1
        return (peaks, valleys)

def fill_valleys(heights, target):
    heights = list(heights)
    for i in range(0, len(heights)):
        if heights[i] < target:
            heights[i] = target
    return heights
