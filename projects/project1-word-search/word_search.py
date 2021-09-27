# return (width, height)
def get_size(grid):
    height = len(grid)
    width = len(grid[0])
    return (width, height)

def print_word_grid(grid):
    for row in grid:
        word = ''
        for letter in row:
            word += letter
        print(word)

def copy_word_grid(grid):
    new_grid = []
    for row in grid:
        new_row = []
        for letter in row:
            new_row.append(letter)
        new_grid.append(new_row)
    return new_grid

def extract(grid, position, direction, max_len):
    size = get_size(grid)
    (x, y) = position
    word = ''
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
        (x, y) = solution[0]
        direction = solution[1]
        copy_grid = copy_word_grid(grid)
        found = True
        for letter in word:
            if grid[y][x] == letter:
                copy_grid[y][x] = copy_grid[y][x].capitalize()
                x += direction[0]
                y += direction[1]
            else:
                found = False
                break
        if found == True:
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

    # evaluate the next letter of the first letter found in grid
    # if next letter matches the word, then insert into a dictionary,
    # where key is first letter location, value is direction
    result_dict = {}
    for first_letter_location in first_letter_locations:
        for direction in DIRECTIONS:
            next_x = first_letter_location[0] + direction[0]
            next_y = first_letter_location[1] + direction[1]
            if 0 <= next_x < size[0] and 0 <= next_y < size[1]:
                if word[1] == grid[next_y][next_x]:
                    result_dict[first_letter_location] = direction

    # evaluate the rest of the letter 
    # if the rest of the letters match the word, then do nothing
    # else insert into remove_list with its first letter location
    remove_list = []
    for location, direction in result_dict.items():
        for i in range(2, len(word)):
            next_x = location[0] + i * direction[0]
            next_y = location[1] + i * direction[1]
            if 0 <= next_x < size[0] and 0 <= next_y < size[1]:
                if word[i] != grid[next_y][next_x]:
                    remove_list.append(location)
            else:
                remove_list.append(location)

    # check if any first letter location in remove_list
    # remove element from the dictionary using first letter location
    if remove_list:
        for element in remove_list:
            result_dict.pop(element)

    # check if any result in the dictionary
    # return false if no result in the dictionary
    if result_dict:
        result_list = []
        for location, direction in result_dict.items():
            result_list.append((location, direction))
        return result_list
    else:
        return False

def find_all(grid, word_list):
    result_dictionary = {}
    for word in word_list:
        result = find(grid, word)
        result_dictionary[word] = result
    return result_dictionary

RIGHT = (1, 0)
DOWN = (0, 1)
RIGHT_DOWN = (1, 1)
RIGHT_UP = (1, -1)
DIRECTIONS = (RIGHT, DOWN, RIGHT_DOWN, RIGHT_UP)

grid = [
    ['p', 'c', 'n', 'd', 't', 'h', 'g'],
    ['w', 'a', 'x', 'o', 'a', 'x', 'f'],
    ['o', 't', 'w', 'g', 'd', 'r', 'k'],
    ['l', 'j', 'p', 'i', 'b', 'e', 't'],
    ['f', 'v', 'l', 't', 'o', 'w', 'n']
]

# size = get_size(grid)
# print("size: {}".format(size))

# word = extract(grid, (2, 1), RIGHT_DOWN, 6)
# print("extracted word: {}".format(word))

# solution = ((1, 0), (0, 1))
# show_solution(grid, "cat", solution)

word_list = ["ktn"]
res_list = find_all(grid, word_list)
print(res_list)