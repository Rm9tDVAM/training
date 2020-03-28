## Python
- 基本
[]リスト
{}ディクショナリ
()
- リスト
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
- リスト
~~~python
a=[1,2,3,4,5]
print(a)
print(f'a[1:3]={a[1:3]}')
print(f'a[:4]={a[:4]}')
print(f'a[2:]={a[2:]}')
print(f'a[-1]={a[-1]}')
a[0]=10
print(a)
~~~
~~~
[1, 2, 3, 4, 5]
a[1:3]=[2, 3]
a[:4]=[1, 2, 3, 4]
a[2:]=[3, 4, 5]
a[-1]=5
[10, 2, 3, 4, 5]
~~~
- ディクショナリ
~~~python


~~~
~~~


~~~
