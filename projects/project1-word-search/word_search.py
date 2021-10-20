import random

def get_size(grid):
    '''
    this function find the size of the given grid

    parameter
        (1) grid - a letter grid
    return
        (width, height) - size of the grid in tuple form
    '''
    height = len(grid)
    width = len(grid[0])
    return (width, height)

def print_word_grid(grid):
    '''
    this function print out the given grid 

    parameter
        (1) grid - a letter grid
    '''
    for row in grid:
        word = ""
        for letter in row:
            word += letter
        print(word)

def copy_word_grid(grid):
    '''
    this function copy the given grid into an independent new grid

    parameter
        (1) grid - a letter grid
    return
        an independent new grid
    '''
    new_grid = []
    for row in grid:
        new_row = row.copy()
        new_grid.append(new_row)
    return new_grid
    
def extract(grid, position, direction, max_len):
    '''
    this function extracts a word from the given grid, starting from given position, 
    moving in given direction containing given maximum length of letter

    parameters
        (1) grid - a letter grid
        (2) position - a location in tuple form, (position_x, position_y)
        (3) direction - a direction in tuple form, (direction_x, direction_y) from defined directions
        (4) max_len - maximum length of word to be extracted
    return 
        a word extracted from the grid
    '''
    width, height = get_size(grid)
    position_x, position_y = position
    direction_x, direction_y = direction
    word = ""
    for _ in range(0, max_len):
        # check if the word inside the grid
        if 0 <= position_x < width and 0 <= position_y < height:
            word += grid[position_y][position_x]
            position_x += direction_x
            position_y += direction_y
        else:   # out of grid so break the loop
            break
    return word

def show_solution(grid, word, solution):
    '''
    this function show the given solution of the word search
    by printing out the grid, with capitalized word if the solution is true,
    else word can't be found in this search is printed

    parameters:
        (1) gird - a lette grid
        (2) word - the word that show the solution for
        (3) solution - (location, direction) or False
    '''
    if solution == False:
        print("{} is not found in this word search".format(word))
    else:
        location_x, location_y = solution[0]
        direction_x, direction_y = solution[1]
        extract_word = extract(grid, (location_x, location_y), (direction_x, direction_y), len(word))
        # verify extracted word 
        if extract_word == word:
            copy_grid = copy_word_grid(grid)
            for _ in range(len(word)):
                # capitalize the word
                copy_grid[location_y][location_x] = copy_grid[location_y][location_x].upper()
                location_x += direction_x
                location_y += direction_y
            print("{} can be found as below".format(word.upper()))
            print_word_grid(copy_grid)
        else:
            print("{} is not found in this word search".format(word))

def find(grid, word):
    '''
    this function find the given word in the given grid

    parameters
        (1) grid - a letter grid
        (2) word - a string 
    return 
        the location and direction at which the word can be found or
        False if the word can't be found in the ground
    '''
    width, height = get_size(grid)
    for location_y in range(height):
        for location_x in range(width):
            if word[0] == grid[location_y][location_x]:
                for direction in DIRECTIONS:
                    extracted_word = extract(grid, (location_x, location_y), direction, len(word))
                    if extracted_word == word:
                        return ((location_x, location_y), direction)
    return False

def find_all(grid, word_lst):
    '''
    this function find the word from the given word list in the given grid

    parameters
        (1) grid - a letter grid
        (2) word_lst - a string list containing words
    return 
        a dictionary where key is the word in the word list, value is 
        the location and direction at which the word can be found or
        False if the word can't be found in the ground
    '''
    result_dct = {}     # result dictionary
    for word in word_lst:
        result = find(grid, word)
        result_dct[word] = result
    return result_dct

def generate(width, height, word_lst):
    '''
    this function generate a letter grid with the given width and height, and try to insert 
    the word from the given word list, then print out the generated grid

    parameters
        (1) width - width of the grid
        (2) height - height of the grid
        (3) word_lst - a string list containing words
    return 
        (grid, inserted_word_lst) - the generated grid and a string list containing words 
        that is inserted successfully
    '''
    # create an empty grid
    grid = []
    for _ in range(height):
        row = []
        for _ in range(width):
            row.append(" ")
        grid.append(row)
    inserted_word_list = []
    for word in word_lst:
        # try to insert the word 100 times
        for _ in range(0, 100):
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
    '''
    this function generate a random location in the range of given width and height,
    and a random direction

    parameters
        (1) width - width of the grid
        (2) height - height of the grid
    return 
        (location, direction) - a random location and a random direction
    '''
    location_x = random.randint(0, width - 1)
    location_y = random.randint(0, height - 1)
    direction = random.choice(DIRECTIONS)
    return ((location_x, location_y), direction)

def verify_location_direction(grid, word, location_direction):
    '''
    this function verify the given word if possible to be inserted into the grid 
    with the given location and direction

    parameters
        (1) grid - a letter grid
        (2) word - a string
        (3) location_direction - location and direction
    return
        True if the word is possible to be inserted
        False if the word is not possible to be inserted
    '''
    (location_x, location_y), (direction_x, direction_y) = location_direction
    width, height = get_size(grid)
    # create a count to keep tracking the number of letters able to insert
    count = 0
    for i in range(len(word)):
        x = location_x + i * direction_x
        y = location_y + i * direction_y
        # verify the location still in the grid and if the location is empty
        if 0 <= x < width and 0 <= y < height and grid[y][x] == " ":
            count += 1
        else:
            # break the loop, there is no need to continue verify the rest of the letters
            break
    # if the count is equal to the length of word, then the word is possible to be inserted
    return True if count == len(word) else False

def insert(grid, word, location_direction):
    '''
    this function insert the given word into the grid starting from the given location, 
    moving in given direction 

    parameters
        (1) grid - a letter grid
        (2) word - a string
        (3) location_direction - location and direction 
    '''
    (location_x, location_y), (direction_x, direction_y) = location_direction
    for letter in word:
        grid[location_y][location_x] = letter
        location_x += direction_x
        location_y += direction_y

RIGHT = (1, 0)
DOWN = (0, 1)
RIGHT_DOWN = (1, 1)
RIGHT_UP = (1, -1)
DIRECTIONS = (RIGHT, DOWN, RIGHT_DOWN, RIGHT_UP)