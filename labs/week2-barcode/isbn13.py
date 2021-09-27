"""Jingxian Chai, Janani Kannan"""

# function that checks the validity of the isbn number
def check_isbn13(isbn):
    if int(isbn)>0:
        if len(isbn) in range(0,14):
            sum_even = 0
            sum_odd = 0
            y = 1
            for i in isbn:
                i = int(i)
                if y % 2 == 0:
                    sum_even += i
                else:
                    sum_odd += i
                y += 1

            total = sum_odd + 3 * sum_even
            if total % 10 == 0:
                return True
            else:
                return False
        else:
            return False
    else:
        return False

# taking user input and executing the function
if __name__=="__main__":
    again = True
    while (again):
        x = input("input the isbn13 digits \n")
        result = check_isbn13(x)
        if result == True:
            again = False
            print("Valid")
        else:
            print("Invalid")
        again = input("again?    (y/n) \n")
        if again == "y":
            again = True
        else:
            again = False

