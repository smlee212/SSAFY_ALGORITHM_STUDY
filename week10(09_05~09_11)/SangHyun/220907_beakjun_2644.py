def bfs(start,goal,n):
    visited=[0]*(n+1)
    queue=[start]
    visited[start]=1
    
    n=0
    
    while queue:
        size=len(queue)
        for _ in range(size):
            now=queue.pop(0)
            
            if now==goal:
                return n
            
            for x in ary[now]:
                if visited[x]==0:
                    visited[x]=1
                    queue.append(x)
        n+=1
    else:
        return -1
    

n=int(input())
p1,p2=map(int,input().split())
m=int(input())
ary = [[]for _ in range(n+1)]
for _ in range(m):
    i,j=map(int,input().split())
    ary[i].append(j)
    ary[j].append(i)

print(bfs(p1,p2,n))
