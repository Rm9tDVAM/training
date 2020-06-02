a_list=[20,35,82,50,33]
print(a_list[0])
print(a_list[-1])
print()

#for文
for i in a_list:
    print(i)
print()

#要素数
print(len(a_list))
print()

#平均点
points = [62, 58, 72, 60, 47, 81, 74, 65, 59, 38]
print(points)
total=sum(points)
ans=total/len(points)
print(ans)
print(max(points))
print(min(points))
ls=sorted(points) #昇順の並び替えたものを返す
print(ls)
ls=sorted(points,reverse=True) #昇順の並び替えたものを返す
print(ls)
ls2=points[0:3]
print(ls2)
ls3=points[3:5]
print(ls3)
ls4=points[-2:]
print(ls4)
