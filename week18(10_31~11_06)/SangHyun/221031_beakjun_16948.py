from collections import deque

dr = [-2, -2, 0, 0, 2, 2]
dc = [-1, 1, -2, 2, -1, 1]

n = int(input())
visited = [[0] * n for _ in range(n)]
r1, c1, r2, c2 = map(int, input().split())

q = deque([(r1, c1, 0)])
visited[r1][c1] = 1
cnt = 0
while q:
    r, c, cnt = q.popleft()
    if r == r2 and c == c2:
        print(cnt)
        break

    for d in range(6):
        nr = r + dr[d]
        nc = c + dc[d]

        if 0 <= nr < n and 0 <= nc < n and not visited[nr][nc]:
            q.append((nr, nc, cnt + 1))
            visited[nr][nc]=1
else:
    print(-1)
