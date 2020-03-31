n=1 # 最初の数
minute=0 # 経過時間
days=1 # 検証日数
day_minute=days*24*60 # 分に換算

while minute<day_minute:
    n*=2
    minute+=5
    print(minute,'分後',n)
print(n)
