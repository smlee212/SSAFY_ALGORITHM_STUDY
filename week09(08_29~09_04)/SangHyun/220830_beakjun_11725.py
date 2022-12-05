import sys
input=sys.stdin.readline
sys.setrecursionlimit(10**9)

n=int(input())

ary=[[] for _ in range(n+1)]

parent=[0 for _ in range(n+1)]


for _ in range(n-1):
    i,j=map(int,input().split())
    ary[i].append(j)
    ary[j].append(i)
    


def dfs(start,tree,parent):
    for i in tree[start]:
        if parent[i]==0:
            parent[i]=start
            dfs(i,tree,parent)

dfs(1,ary,parent)
            
for i in range(2,n+1):
    print(parent[i])
