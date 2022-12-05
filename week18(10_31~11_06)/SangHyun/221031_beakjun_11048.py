n, m = map(int, input().split())
ary=[list(map(int,input().split())) for _ in range(n)]
for a in range(0,n):
    for b in range(0,m):
        if a==0 and b==0:
            pass
        elif a==0:
            ary[a][b]+=ary[a][b-1]
        elif b==0:
            ary[a][b] += ary[a-1][b]
        else:
            ary[a][b]+=max(ary[a-1][b],ary[a-1][b-1],ary[a][b-1])
print(ary[-1][-1])
