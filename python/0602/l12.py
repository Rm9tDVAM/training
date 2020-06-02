"""
洋風カレー:900->1170円
オムライス:870->1131円

math.ceil(72.4)->73
"""
import math
# レストランのメニュー
menu_dict = {
    "洋風カレー": 900,
    "オムライス": 870,
    "ラザニア": 790,
    "ハンバーグ定食": 920,
    "トマトパスタ": 720
}
for key in menu_dict:
    print(f'{key}:{menu_dict[key]}->{math.ceil(menu_dict[key]*1.3)}円')
