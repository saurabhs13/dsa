#Complexity: O(log(n))
def find_item(list,item):
    low = 0
    high = len(list) - 1
    
    while low <= high: 
        mid = int((low+high)/2)
        guess = list[mid]
        if guess == item:
            return mid
        elif guess < item:
            low = mid + 1
        else:
            high = mid - 1
    return None

item  = input("Please enter the number you want to search for:")
try:
    item = int(item)
    list = [1,2,3,4,5,6,7,8,9,11,12,13,14,15,16,17]
    if None != item:
        index = find_item(list,item)
        if None != index:
            print("Found the number at index: ",index)
        else:
            print("Not found")
    else:
        print("Invalid Input !!")
except ValueError:
    print("Invalid Input")
except TypeError:
    print("Invalid Input")

