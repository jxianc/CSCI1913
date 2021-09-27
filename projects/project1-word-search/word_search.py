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
    first_letter_locations = []
    for row_index in range(size[1]):
        for col_index in range(size[0]):
            if word[0] == grid[row_index][col_index]:
                first_letter_locations.append((col_index, row_index))
    print(first_letter_locations)
    result_list = {}
    for first_letter_location in first_letter_locations:
        for direction in DIRECTIONS:
            next_x = first_letter_location[0] + direction[0]
            next_y = first_letter_location[1] + direction[1]
            if word[1] == grid[next_y][next_x]:
                result_list[first_letter_location] = direction
    for location, direction in result_list.items():
        for i in range(2, len(word)):
            next_x = location[0] + i * direction[0]
            next_y = location[1] + i * direction[1]
            if word[i] != grid[next_y][next_x]:
                result_list.pop(location)
    if result_list:
        for location, direction in result_list.items():
            result = (location, direction)
        return result
    else:
        return False

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

result = find(grid, "cxg")
print(result)