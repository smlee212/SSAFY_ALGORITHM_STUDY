n=int(input())
m=int(input())
ary=[ [] for _ in range(n+1)]
for _ in range(m):
    i,j=map(int,input().split())
    ary[i].append(j)
    ary[j].append(i)

queue=[1]
visited=[0]*(n+1)
visited[1]=1
while queue:
    now=queue.pop(0)
    
    for k in ary[now]:
        if visited[k]==0:
            visited[k]=1
            queue.append(k)
count=0
for c in visited:
    if c==1:
        count+=1
print(count-1)
