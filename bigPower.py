def sumNum(string):
	sum = 0
	x = len(string)
	for y in range(0, x):
		sum+= int(string[y])
	return sum

def calcNums(length):
	maxNums = []
	for i in range(5, length):
		for k in range(0, length):
			maxNums.append(sumNum(str(i**k)))
	return max(maxNums)

print(calcNums(15))
