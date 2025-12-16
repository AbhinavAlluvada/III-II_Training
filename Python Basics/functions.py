# Functions
def tables(num):
    for i in range(1, 11):
        print(f"{num} X {i} = {num * i}")


def fact(num):
    if num == 0 | num == 1:
        return 1
    return num * fact(num - 1)


def fib(num):
    first = 0
    second = 1
    print(first, second, end=" ")
    for i in range(1, num):
        sum = first + second
        print(sum, end=" ")
        first = second
        second = sum


num = int(input("Enter number: "))
fib(num)
