try:
    f = open("data.txt","r")
    print(f.read())
except FileNotFoundError:
    print("File not found")
finally:
    print("File Operation Completed")
    
    try:
        x = int(input())
        print(10/x)
        
    except(ValueError,ZeroDivisionError):
        print("Invalid input or division error")