import random
jyan=['グー','チョキ','パー']

while True:
    hand=int(input('手を入力(0.グー, 1.チョキ, 2.パー)'))
    print(f'あなたは{jyan[hand]}')
    pcHand=random.randint(0,2)
    print(f'PCは{jyan[pcHand]}')
    if hand==pcHand:
        print('あいこ')
        continue
    elif hand==0 and pcHand==1 or hand==1 and pcHand==2 or hand==2 and pcHand==0:
        print('あなたの勝ちです')
    else:
        print('あなたの負けです')
    break
