import sys
input=sys.stdin.readline

n=int(input())
pyramid=[]
for _ in range(n):
    pyramid.append(list(map(int,input().split())))
    
for x in range(1,n):
    size=len(pyramid[x])
    for y in range(size):
        if y==0:
            pyramid[x][y]+=pyramid[x-1][0]
        elif y==size-1:
            pyramid[x][y]+=pyramid[x-1][-1]
        else:
            pyramid[x][y]+=pyramid[x-1][y-1] if pyramid[x-1][y-1]>pyramid[x-1][y] else pyramid[x-1][y]
print(max(pyramid[n-1]))
            
