import sys

input=sys.stdin.readline

n,m=map(int,input().split())

ary=[1]*(n+1)

for i in range(1,n+1):
    ary[i]=ary[i-1]*i

num=ary[n]//(ary[m]*ary[n-m])
print(num)
