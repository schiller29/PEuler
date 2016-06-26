low = 100*100
high = 999*999
#mathematically, the smallest number of the 3 digit range squared will be the smallest product of three 
#digit numbers. And likewise, the largest number squared will be the largest product, so that makes the 
def calcLargestPalidrome(low, high):
	for num in range(high, low, -1):
		num = str(num)
		for index in range (0, len(num)/2):
			if index == int(len(num)/2) or index >= len(num)/2:
				return num
			elif num[index] != num[(len(num)-1) - index]:
				break
			elif num == '997799':
				import pdb; pdb.set_trace()
			else:
				continue
	#return 'no palindrome'
print calcLargestPalidrome(low, high)
