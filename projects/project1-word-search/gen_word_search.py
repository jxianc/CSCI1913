# allows a user enter words and a target size and get novel word search puzzles generated for them
from word_search import *

print("enter the grid size:")
width = input("width >>> ")
height = input("height >>> ")
print("")

word_lst = []
more_word = True
print("enter the words:")
while more_word:
    word = input("enter a word or -1 to >>> ")
    if word == "-1":
        more_word = False
    else:
        word_lst.append(word)
        print("current word list: {}\n".format(word_lst))
print("")

(word_grid, inserted_word_lst) = generate(int(width), int(height), word_lst)
print("find the word(s): {}\n".format(inserted_word_lst))
print_word_grid(word_grid)