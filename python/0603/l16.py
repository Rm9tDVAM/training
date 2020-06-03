a_list=[33,98,74,74,88,85]
a_list.sort() #自分自身を並べ替え
print(a_list)
b_list=sorted(a_list,reverse=True)
print(b_list)
f_dict={'Orange':300,'Banana':200,'Apple':500}
print(f_dict)
sorted_list=sorted(f_dict)
print(sorted_list)
for key in sorted_list:
    print(f'{key}:{f_dict[key]}')
sorted_list2=sorted(f_dict.items(),key=lambda x:x[1])
print(sorted_list2)
for name,price in sorted_list2:
    print(f'{name}:{price}')
