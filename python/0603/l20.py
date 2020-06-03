"""
ある水族館では入場料が2000円です。
ただし、3才未満は無料
6才未満は500円
60才以上は1500円
そして月曜であれば2割引き
この水族館の入場料を計算する関数calc_feeを定義して
実行例
print(calc_fee(18,False)) ->2000
print(calc_fee(20,True))->1600
print(calc_fee(2,False))->0
print(calc_fee(70,True))->1200
"""
def calc_fee(age:int,is_mon:bool)->int:
    price=2000
    if age<3:
        return 0
    elif age<6:
        price=500
    elif 60>=age:
        price=1500
    return price
print(calc_fee(2,False))

