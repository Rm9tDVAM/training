'''
0723
N=int(input())
dic={key:0 for key in input().split()}
M=int(input())
for i in range(M):
    o,p=input().split()
    dic[o]+=int(p)
dic=dict(sorted(dic.items(),key=lambda x:x[1],reverse=True))
for k in dic:
    print(k)

0721
N=int(input())
dic={}
for i in range(N):
    list=input().split()
    v=list[0]
    p=int(list[1])
    if v in dic:
        dic[v]=dic[v]+p
    else:
        dic[v]=p
point=0
if "0" in dic:
    point+=dic["0"]//100*5
if "1" in dic:
    point+=dic["1"]//100*3
if "2" in dic:
    point+=dic["2"]//100*2
if "3" in dic:
    point+=dic["3"]//100*1
print(point)

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