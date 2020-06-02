import random
n=3
win=lose=draw=0
for i in range(1,n+1):
    print(f'じゃんけん{i}回目')
    print('あなたの手は?')
    user=int(input('0:グー、1:チョキ、2:パー>'))
    pc=random.randint(0,2)
    print(f'pcの手は{pc}')
    diff=(user-pc + 3)%3
    if diff == 0:
        print('あいこ')
        draw+=1
    elif diff == 2:
        print('勝ち')
        win+=1
    else:
        print('負け')
        lose+=1
    print()
print(f'結果({n}戦) win:{win} lose:{lose} draw:{draw}')
