import sys
from collections import deque

input=sys.stdin.readline


di = [1, 0, -1, 0]
dj = [0, 1, 0, -1]

def bfs(start):
    global ary
    visited = [[0] * m for _ in range(n)]
    queue = deque()
    for x, y in start:
        visited[x][y] = 1
        queue.append((x, y))

    days = 0

    while queue:
        size = len(queue)
        for _ in range(size):
            i, j = queue.popleft()

            for d in range(4):
                ni = i + di[d]
                nj = j + dj[d]

                if 0 <= ni < n and 0 <= nj < m and ary[ni][nj] == 0 and visited[ni][nj] == 0:
                    queue.append((ni, nj))
                    visited[ni][nj] = 1
                    ary[ni][nj] = 1


        else:
            days += 1

    return days


m, n = map(int, input().split())
ary = [list(map(int, input().split())) for _ in range(n)]
start = []
for a in range(n):
    for b in range(m):
        if ary[a][b] == 1:
            start.append((a, b))
result=bfs(start)-1
for a in range(n):
    if 0 in ary[a]:
        result=-1
print(result)
