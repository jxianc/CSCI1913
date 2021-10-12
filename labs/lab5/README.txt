1.  Who worked on this lab (I.E. if you worked alone, clearly list that, if you worked withpartners, clearly list that, and the name of your partner)
    Jingxian Chai

2.  Which image files in your submission are which input case (I.E. what is the filenamefor the backwards list plot, which is the random list plot, etc.)
    backwards list plot: backwards_plot.png
    near sorted list plot: near_sorted_plot.png
    random list plot: random_plot.png
    sorted list plot: sorted_plot.png

3.  For each algorithm, how did it behave?  Was it’s behavior consistent across input cases,or did it vary?  If it varied briefly describe why.
    The behavior of selection sort and merge sort are consistent across input cases, whereas the behavior of insertion sort varies across input cases.

    In backwards sorted case, which is the worst case, insertion sort have to compare j time where j = i(the index of element that is checking), there are i of element in list, so the runtime in this case will be O(n^2).
    In sorted case, which is the best case, since every jth element is greater than the previous one, the condition of the loop is false, therefore insertion sort only have to run i times (or n times) by checking if the jth element is greater than the previous one, so the runtime in this case will be O(n).
    Nearly sorted case is similar to sorted case, assume only a few of the jth element is smaller than the previous one, so in this case, insertion sort will run slightly more times than in sorted case, so the overall runtime in this case is O(n).
    In random case, however, it is hard to analyze or predict, but according the plot, the comparison count curve is bounded between backwards sorted case(worst case) and sorted case(best case), so we can consider that this is average case.

4.  For  each  algorithm  how  does  the  shape  of  it’s  comparison  count  curve  match  our expectations.  If the algorithm varied case-by-case, how does this answer change case-by-case?
    The shape of comparison count curve of selection sort and merge sort match our expectation, but the comparison count curve of insertion sort varies case by case.
    Insertion sort generate linear line in sorted case(best case), quadratic curve in backwards sorted and random case

5.  Merge sort is theoretically the fastest algorithm, are there cases where another algo-rithm might be faster?
    Insertion sort does slightly better than merge sort in sorted case.

6.  If you didn’t know the order of data you might want to sort, what algorithm might you use to sort it, and why?
    I will use merge sort because merge sort behave consistently and it is the fastest sorting algorithm overall.