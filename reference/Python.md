## Python
Sample
~~~python
ele=[input('名前を入力>>')]
ele.append(input('年齢を入力>>'))
ele.append(float(input('身長(cm)を入力>>')))
print(type(ele[2]))
ele.append(input('体重(kg)を入力>>'))
print(type(ele[3]))
print(f'要素数は{len(ele)}')
print(f'私の名前は{ele[0]}、年齢は{int(ele[1]):3d}歳\n身長は{int(ele[2]):3d}cmです、体重は{int(ele[3]):3d}kgです、BMIは{float(ele[3])/(ele[2]/100)**2:.2f}。')
~~~
~~~
名前を入力>> hoge
年齢を入力>> 20
身長(cm)を入力>> 170
<class 'float'>
体重(kg)を入力>> 70
<class 'str'>
要素数は4
私の名前はhoge、年齢は 20歳
身長は170cmです、体重は 70kgです、BMIは24.22。
~~~
sample
~~~python
print(d)
a=[10,20,30,40,50]
print(a)
b=a[1:3]
print(b)
c=a[:4]
print(c)
d=a[2:]
print(d)
a[0]=100
print(a)
~~~
~~~
[10, 20, 30, 40, 50]
[20, 30]
[10, 20, 30, 40]
[30, 40, 50]
[100, 20, 30, 40, 50]
~~~
