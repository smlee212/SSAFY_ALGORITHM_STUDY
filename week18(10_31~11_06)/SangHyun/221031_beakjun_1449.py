n, l = map(int, input().split())
holes = list(map(int, input().split()))
ary=[0]*(max(holes)+1)
for x in holes:
    ary[x]=1

count=0
for x in range(max(holes)+1):
    if ary[x]==1:
        for i in range(l):
            if x+i<max(holes)+1:
                ary[x+i]=0
        count+=1

print(count)
