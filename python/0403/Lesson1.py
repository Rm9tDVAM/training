print([0]*6)
print([n for n in reversed(range(1,6))])
print(list(range(5,0,-1)))
print(list('Hello'))
print([[i*3+j+1 for j in range(3)]for i in range(2)])
print([True,False]*2)
print([n%2==0 for n in range(4)])
print([[i, j] for i in range(2) for j in range(2)])
print()
print(["FizzBuzz" if n%15==0
    else "Fizz" if n%3==0
    else "Buzz" if n%5==0
    else n for n in range(1,51)])
