import math

def count(words):
    counts = {}
    for word in words:
        if word in counts.keys():
            num = counts[word]
            num += 1
            counts[word] = num
        else:
            counts[word] = 1
    return counts

def normalize(word_dct):
    square_sum = 0
    for count in word_dct.values():
        square = count ** 2
        square_sum += square
    size = math.sqrt(square_sum)
    normalized_dct = {}
    for word, count in word_dct.items():
        normalized_dct[word] = 0 if size == 0 else count / size
    return normalized_dct

# comparing two normalized dictionary, if word(key) in nrm_dct1 does not exists in nrm_dct2,
# then add the word as key, 0 as the value into nrm_dct2
# and do the same thing in nrm_dct1
def compare(nrm_dct1, nrm_dct2):
    for word in nrm_dct1.keys():
        if word not in nrm_dct2.keys():
            nrm_dct2[word] = 0
    for word in nrm_dct2.keys():
        if word not in nrm_dct1.keys():
            nrm_dct1[word] = 0

def word_count_distance(count1, count2):
    nrm_dct1 = normalize(count1)
    nrm_dct2 = normalize(count2)
    compare(nrm_dct1, nrm_dct2)
    count_sum = 0
    for word in nrm_dct1.keys():
        count_sum += nrm_dct1[word] * nrm_dct2[word]
    distance_score = 2 - 2 * count_sum
    return distance_score

too_common_words = ["the","be","to","of","and","a","in","that","have","I","it","for","not","on","with","he","as","you","do","at","this","but","his","by","from","they","we","say","her","she","or","an","will","my","one","all","would","there","their","what","so","up","out","if","about","who","get","which","go","me"]

def most_common_word(counts):
    max_count = 0
    mcw_set = set() # most common word set
    for word, count in counts.items():
        if count > max_count and word not in too_common_words:
            max_count = count
    for word, count in counts.items():
        if count == max_count and word not in too_common_words:
            mcw_set.add(word)
    return mcw_set

def most_similar(samples):
    distance_score_with_pair = {}
    for first, first_counts in samples.items():
        for second, seocnd_counts in samples.items():
            if first != second:
                distance_score = word_count_distance(first_counts, seocnd_counts)
                distance_score_with_pair[distance_score] = (first, second)
    if distance_score_with_pair:
        min_distance_score = min(distance_score_with_pair.keys())
        return distance_score_with_pair[min_distance_score]
    else:
        return ()