#calculate the factorial for the given num. 
def range_prod(lo,hi):
    if lo+1 < hi:
        mid = (hi+lo)//2
        return range_prod(lo,mid) * range_prod(mid+1,hi)
    if lo == hi:
        return lo
    return lo*hi

def factorial(n):
    if n < 2:
        return 1
    return range_prod(1,n)

def trailingDigits(n):
	n = factorial(n)
	n = str(n)
	x = len(n) - 1
	while n[x]== 0 and x > 0:
		x= x-1
	if x == 0:
		return n[len(n) - 6: len(n) - 1]
	else:
		return n[x - 5: x]

def lastFive(n):
	print trailingDigits(n)


lastFive(1000000000000)