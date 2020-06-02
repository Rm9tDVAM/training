a_dict={'田中':48,'佐藤':78,'井上':49}
print(a_dict['佐藤'])
a_dict['佐藤']=79
print(a_dict['佐藤'])
print()
#for
for key in a_dict:
    print(f'{key}は{a_dict[key]}才')
    
