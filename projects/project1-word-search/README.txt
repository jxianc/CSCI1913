Name: Jingxian Chai

You should assume the following:
 * the letter grid parameter has width W and height H.
 * The word parameter has length L.
 * concatenating a letter to a string takes O(1) time
 * the get_size function takes O(1) time
 * accessing a list by index takes O(1) time

Your task:

#Q1
What is the Big-O runtime of the extract function in terms of W, H, and L (defined above)

Big-O runtime: O(L)
Explanation: 
the for loop run L time to extract each letter in the word 

#Q2 
What is the Big-O runtime of the find function in terms of W, H, and L (defined above)

Big-O runtime: O(WHL)
Explanation: 

the nested for loop run H * W * 4 * L time

first, loop over the grid to find the first letter take H * W times in the worst
case which the first letter is at grid[H][W] (bottom right)

second, after finding the first letter, loop over the 4 directions and extract the word with the direction
and the location of first letter which run in L time

therefore the worst case runtime is H * W * 4 * L

(Please attempt to explain your reasoning. An incorrect answer with no stated reasoning will not be suject to partial credit)
