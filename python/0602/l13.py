# 今回集計するデータ --- (*1)
s = """
サンマ,カツオ,サンマ,サンマ,マグロ,フグ,マグロ,マグロ,マグロ,サンマ,ニシン,イワシ,サンマ,サンマ,カツオ,サンマ,カツオ,サンマ,カツオ,サンマ,マグロ,マグロ,マグロ,ニシン
"""
# データの前後にある空白を除去 --- (*2)
s = s.strip()
# カンマでデータを区切る --- (*3)
s_list = s.split(",")
# 空のdictを作成
dic=dict()
# forでリストを回しながらdictを更新していく
for fish in s_list:
    if fish in dic:
        dic[fish]+=1
    else:
        dic[fish]=1
# 結果を出力
for name,count in dic.items():
    print(f'{name}={count}')

