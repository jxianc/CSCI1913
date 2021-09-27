RIGHT = (1, 0)
DOWN = (0, 1)
RIGHT_DOWN = (1, 1)
RIGHT_UP = (1, -1)
DIRECTIONS = (RIGHT, DOWN, RIGHT_DOWN, RIGHT_UP)

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

grid = [
    ['p', 'c', 'n', 'd', 't', 'h', 'g'],
    ['w', 'a', 'x', 'o', 'a', 'x', 'f'],
    ['o', 't', 'w', 'g', 'd', 'r', 'k'],
    ['l', 'j', 'p', 'i', 'b', 'e', 't'],
    ['f', 'v', 'l', 't', 'o', 'w', 'n']
]

size = get_size(grid)
print("size: {}".format(size))

word = extract(grid, (2, 1), RIGHT_DOWN, 6)
print("extracted word: {}".format(word))