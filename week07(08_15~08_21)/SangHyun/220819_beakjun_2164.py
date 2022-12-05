n = int(input())
ary=[0]*500001
for x in range(1,n+1):
    if x==1:
        ary[x]=1
    elif x==2:
        ary[x]=2
    else:
        ary[x]= ary[x-1]+2 if x>=ary[x-1]+2 else 2
print(ary[n])
