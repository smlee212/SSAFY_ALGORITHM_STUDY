from collections import deque
di=[1,0,-1,0]
dj=[0,1,0,-1]

n=int(input())
ary=[list(input()) for _ in range(n)]
visited=[[0]*n for _ in range(n)]

def bfs(start):
    global visited
    si,sj=start
    visited[si][sj]=1
    q=deque([start])

    while q:
        i,j=q.popleft()

        for d in range(4):
            ni=i+di[d]
            nj=j+dj[d]

            if 0<=ni<n and 0<=nj<n and visited[ni][nj]==0 and ary[si][sj]==ary[ni][nj]:
                q.append((ni,nj))
                visited[ni][nj] =1

count1=0
for i in range(n):
    for j in range(n):
        if visited[i][j]==0:
            bfs((i,j))
            count1+=1

for i in range(n):
    for j in range(n):
        if ary[i][j]=='G':
            ary[i][j] = 'R'

count2=0
visited=[[0]*n for _ in range(n)]
for i in range(n):
    for j in range(n):
        if visited[i][j]==0:
            bfs((i,j))
            count2+=1


print(count1,count2)
