import math
def findNPrime(toFind):
    count = 6
    num = 14
    while count < toFind:
        for number in range(2, int(math.sqrt(num) + 1)):
            if num % number == 0:
                num = num+1
                break
            elif number == int(math.sqrt(num)):
                count = count +1
                if count != toFind:
                    num= num+1

    return num 

print findNPrime(1000100)
