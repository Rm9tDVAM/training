def show_next_olympic(year:int):
    if year%4==0:
        print(f'次のオリンピックは{year+4}年')
        return
    while True:
        year+=1
        if year%4==0:
            print(f'次のオリンピックは{year}年')
            return

show_next_olympic(2017)
show_next_olympic(2020)
show_next_olympic(2022)
