'''
0719
ATK,DEF,AGI=(int(i) for i in input().split())
N=int(input())
count=0
for i in range(N):
    list=input().split()
    if int(list[1])<=ATK<=int(list[2]) and\
       int(list[3])<=DEF<=int(list[4]) and\
       int(list[5])<=AGI<=int(list[6]):
          print(list[0])
          count+=1
    if(i+1==N and count==0):
        print("no evolution")

0713
N=int(input())
M=int(input())
print(N*M)

0712
val=int(input())
if 40<=val<=60:
    print("OK")
else#:
    print("NG")

0712
list=[len(input()) for i in range(3)]
print(max(list))

0711
val=input()
print("*"*int(val))
'''