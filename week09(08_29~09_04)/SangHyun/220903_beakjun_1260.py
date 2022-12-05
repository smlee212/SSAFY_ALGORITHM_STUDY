def dfs(v):
    visited[v] = 1        
    print(v, end = " ")
    for i in ary[v]:
        if not visited[i]:
            dfs(i)
            
def bfs(g, v, n):
    queue = []
    queue.append(v)
    visited[v] = 1

    while queue:
        t = queue.pop(0)
        print(f'{t}', end=' ')
        for i in g[t]:
            if not visited[i]:
                queue.append(i)
                visited[i]=1
    
    
                
n,m,v=map(int,input().split())

ary=[[] for _ in range(n+1)]

for _ in range(m):
    i,j=map(int,input().split())
    if j not in ary[i]:
        ary[i].append(j)
    if i not in ary[j]:
        ary[j].append(i)

for i in ary:
    i.sort()

visited=[0]*(n+1)
        
dfs(v)

print()

visited=[0]*(n+1)
bfs(ary,v,n)
