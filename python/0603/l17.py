# あるクラスのテスト結果
test_list = [
  { "名前": "田中", "国語": 80, "算数": 45, "社会": 90 },
  { "名前": "鈴川", "国語": 62, "算数": 70, "社会": 58 },
  { "名前": "早川", "国語": 77, "算数": 69, "社会": 74 }
]
print(test_list[0]['名前'])
total=0
for p in test_list:
    total+=p['国語']
for p in test_list:
    p['合計']=p['国語']+p['算数']+p["社会"]
sorted_list3=sorted(test_list,key=lambda p:p['合計'],reverse=True)
for p in sorted_list3:
    print(f'{p["名前"]}:{p["合計"]}')
