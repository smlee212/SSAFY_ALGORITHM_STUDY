n=int(input())
ary=[0,1,2,4,7]
for i in range(6):
    ary.append(ary[i+2]+ary[i+3]+ary[i+4])
for _ in range(n):
    num=int(input())
    print(ary[num])
