dist=384400*1000*1000 # 月までの距離(mm)
thickness=1 # 紙の厚さ(mm)
count=0 # 折り曲げた回数

while thickness<dist:
    thickness=thickness*2
    count=count+1
    print(f'{count:2d}回折り曲げた,厚み:{thickness}')
print(f'{count}回で月に到達しました。')
