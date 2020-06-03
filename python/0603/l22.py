import datetime
#特定の日付からオリンピックまでの日数を調べる
def calc_days(y,m,d):
    olympic=datetime.datetime(2021,7,23).timestamp()
    target=datetime.datetime(y,m,d).timestamp()
    #1日あたりの秒数
    perday=24*60*60
    days=int(olympic-target)//perday
    s=f'{y}/{m}/{d}から{days}日後'
    print(s)
calc_days(2018,12,1)
t=datetime.date.today()
calc_days(t.year,t.month,t.day)
