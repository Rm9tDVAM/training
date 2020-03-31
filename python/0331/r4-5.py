temp=[7.8,9.1,10.2,11.0,12.5,12.4,14.3,13.8,12.9,12.4]
for count in range(len(temp)):
    print('{}時 {}度'.format(count+8,temp[count]))
temp_new=list()
for count in range(len(temp)):
    if count==5:
        temp_new.append('N/A')
    else:
        temp_new.append(temp[count])
print(temp)
print(temp_new)
total=0
for data in temp_new:
    if isinstance(data,float):
        total=total+data
print(total/(len(temp_new)-1))
