// 内包表記(List comprehension)
squares=[i**2 for i in range(5)]
print(squares)

squares=[]
for i in range(5):
    squares.append(i**2)

print(squares)
