#self defined to string function for integers

def toString(nums):
    strfDict = {0:"0", 1:"1", 2:"2", 3:"3", 4:"4", 5:"5",
                6:"6", 7:"7", 8:"8", 9:"9"
                }
    stringValue = ""
    if nums == 0:
        return strfDict[0]

    iterate = nums
    original = nums
    units = 1
    if nums > 0:
        while original > 0:
            stringValue = stringValue + strfDict[original%10]
            units*=10
            original = iterate//units
        return stringValue
    else:
        while original > 0:
            stringValue = stringValue + strfDict[original%10]
            units*=10
            original = iterate//units
        return "-"+stringValue

def main():
    integer = int(input("Enter an integer value to be converted to a string:\n"))
    print("Before conversion, the type of %d is %s"%(integer,type(integer)))
    
    print("After conversion, the type of {} is {}".format(integer, type(toString(integer))))
main()
