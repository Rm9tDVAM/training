import random
import time
#変数の初期化
a=b=0
goal=20
#ユーザーからの入力を得る
user=input('aとbのどちらのカメが勝つか?')
#競争開始
print('競争開始!')
#aとbのどちらもゴールしていない間繰り返す
while a<goal and b<goal:
    print('---')
    a+=random.randint(1,6)
    b+=random.randint(1,6)
    print('a:'+'>'*a+'@')
    print('b:'+'>'*b+'@')
    time.sleep(1)
#判定
winner='同時' if a==b else 'a' if a>b else 'b'
"""
if a==b:
    winner='同時'
elif a>b:
    winner='a'
else:
    winner='b'
"""
#予想は当たった?
print('当たり' if winner==user else 'はずれ')
"""
if winner==user:
    print('当たり')
else:
    print('はずれ')
"""
