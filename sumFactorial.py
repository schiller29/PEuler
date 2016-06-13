def factorial(n):
    if n == 0:
        return 1
    else:
        return n * factorial(n-1)

def sumNum(string):
	sum = 0
	x = len(string)
	for y in range(0, x):
		sum+= int(string[y])
	return sum

  
bigString = str(factorial(100))
