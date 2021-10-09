# allows a user to enter a wordsearch and awords list
# the user will then be shown the solution to the word search puzzle
from word_search import *

print("enter the grid size")
width = input("width >>> ")
height = input("height >>> ")
print("")

grid = []
for i in range(int(height)):
    row = []
    valid_input = False
    while valid_input != True:
        print("enter row {} with {} letters".format((i + 1), width))
        input_row = input(">>> ")
        if len(input_row) == int(width):
            valid_input = True
        else:
            print("invalid input! please try again\n")
    for letter in input_row:
        row.append(letter)
    grid.append(row)
print("")

word_lst = []
more_word = True
while more_word:
    word = input("enter a word or -1 to >>> ")
    if word == "-1":
        more_word = False
    else:
        word_lst.append(word)
        print("current word list: {}\n".format(word_lst))
print("")

results = find_all(grid, word_lst)
for word, solution in results.items():
    show_solution(grid, word, solution)
    print("")