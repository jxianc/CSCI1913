import random

def get_size(grid):
    height = len(grid)
    width = len(grid[0])
    return (width, height)

def print_word_grid(grid):
    for row in grid:
        word = ""
        for letter in row:
            word += letter
        print(word)

def copy_word_grid(grid):
    new_grid = []
    for row in grid:
        new_row = row.copy()
        new_grid.append(new_row)
    return new_grid

def extract(grid, position, direction, max_len):
    size = get_size(grid)
    (x, y) = position
    word = ""
    for _ in range(0, max_len):
        if 0 <= x < size[0] and 0 <= y < size[1]:
            word += grid[y][x]
            x += direction[0]
            y += direction[1]
    return word

def show_solution(grid, word, solution):
    if solution == False:
        print("{} is not found in this word search".format(word))
    else:
        (location_x, location_y) = solution[0]
        (direction_x, direction_y) = solution[1]
        copy_grid = copy_word_grid(grid)
        found = True
        for letter in word:
            if grid[location_y][location_x] == letter:
                copy_grid[location_y][location_x] = copy_grid[location_y][location_x].capitalize()
                location_x += direction_x
                location_y += direction_y
            else:
                found = False
                break
        if found == True:
            print("{} can be found as below".format(word.upper()))
            print_word_grid(copy_grid)
        else:
            print("{} is not found in this word search".format(word))

def find(grid, word):
    size = get_size(grid)
    # loop over all element and find the first letter
    # insert the location of the first letter found in grid
    first_letter_locations = []
    for row_index in range(size[1]):
        for col_index in range(size[0]):
            if word[0] == grid[row_index][col_index]:
                first_letter_locations.append((col_index, row_index))
    result_list = []
    for first_letter_location in first_letter_locations:
        for direction in DIRECTIONS:
            extracted_word = extract(
                grid, first_letter_location, direction, len(word))
            if extracted_word == word:
                result_list.append((first_letter_location, direction))
    return result_list if result_list else False

def find_all(grid, word_list):
    result_dictionary = {}
    for word in word_list:
        result = find(grid, word)
        result_dictionary[word] = result
    return result_dictionary

def generate(width, height, word_list):
    # create an empty grid
    grid = []
    for _ in range(height):
        row = []
        for _ in range(width):
            row.append(" ")
        grid.append(row)
    inserted_word_list = []
    for word in word_list:
        # try to insert the word 100 times
        for _ in range(0, 101):
            location_direction = get_random_location_direction(width, height)
            result = verify_location_direction(grid, word, location_direction)
            # if result is true, the word is possible to insert
            if result:
                insert(grid, word, location_direction)
                inserted_word_list.append(word)
                break
    # insert the rest of the empty space with random letters
    letters = 'abcdefghijklmnopqrstuvwxyz'
    for y in range(height):
        for x in range(width):
            if grid[y][x] == " ":
                random_letter = random.choice(letters)
                grid[y][x] = random_letter
    return (grid, inserted_word_list)

def get_random_location_direction(width, height):
    # get random location in range of given width and height
    # and random direction from the default directions
    location_x = random.randint(0, width - 1)
    location_y = random.randint(0, height - 1)
    direction = random.choice(DIRECTIONS)
    return ((location_x, location_y), direction)

def verify_location_direction(grid, word, location_direction):
    # verify the word if possible to be inserted into the grid
    # with the random location and direction
    ((location_x, location_y), (direction_x, direction_y)) = location_direction
    (width, height) = get_size(grid)
    # create a count to keep tracking the number of letters able to insert
    # then compare to the length of the given word
    # if count is equal to length of word, meaning all letter can be inserted successfully
    # else the given word is not possible to insert
    count = 0
    for i in range(len(word)):
        x = location_x + i * direction_x
        y = location_y + i * direction_y
        if 0 <= x < width and 0 <= y < height and grid[y][x] == " ":
            count += 1
        else:
            # break the loop, there is no point to continue verify the rest of the letters
            break
    return True if count == len(word) else False

def insert(grid, word, location_direction):
    ((location_x, location_y), (direction_x, direction_y)) = location_direction
    for letter in word:
        grid[location_y][location_x] = letter
        location_x += direction_x
        location_y += direction_y

RIGHT = (1, 0)
DOWN = (0, 1)
RIGHT_DOWN = (1, 1)
RIGHT_UP = (1, -1)
DIRECTIONS = (RIGHT, DOWN, RIGHT_DOWN, RIGHT_UP)

grid = [
    ["p", "c", "n", "d", "t", "h", "g"],
    ["w", "a", "x", "o", "a", "x", "f"],
    ["o", "t", "w", "g", "d", "r", "k"],
    ["l", "j", "p", "i", "b", "e", "t"],
    ["f", "v", "l", "t", "o", "w", "n"],
]

show_solution(grid, "cat", ((1, 0), (0, 1)))

# word_list = ['dog', 'cat', 'asd', 'aaaaaaaaaaa']
# (grid, inserted) = generate(15, 10, word_list)
# print_word_grid(grid)
# print("inserted words: {}".format(inserted))
