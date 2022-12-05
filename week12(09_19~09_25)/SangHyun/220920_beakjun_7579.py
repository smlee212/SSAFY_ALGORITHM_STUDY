from collections import deque
from sys import stdin

input = stdin.readline

dx = [1, -1, 0, 0, 0, 0]
dy = [0, 0, 1, -1, 0, 0]
dz = [0, 0, 0, 0, 1, -1]


def bfs(start):
    global tomatoes
    visited = [[[0] * m for _ in range(n)] for _ in range(h)]

    queue = deque()

    for i, j, k in start:
        visited[i][j][k] = 1
        queue.append((i, j, k))

    days = 0

    while queue:
        size = len(queue)
        for _ in range(size):
            i, j, k = queue.popleft()

            for d in range(6):
                ni = i + dx[d]
                nj = j + dy[d]
                nk = k + dz[d]

                if 0 <= ni < h and 0 <= nj < n and 0 <= nk < m and visited[ni][nj][nk] == 0 and tomatoes[ni][nj][nk] == 0:
                    visited[ni][nj][nk] = 1
                    tomatoes[ni][nj][nk] = 1
                    queue.append((ni, nj, nk))
        else:
            days += 1

    return days


m, n, h = map(int, input().split())
tomatoes = [[list(map(int, input().split())) for _ in range(n)] for _ in range(h)]

start = []

for a in range(h):
    for b in range(n):
        for c in range(m):
            if tomatoes[a][b][c] == 1:
                start.append((a, b, c))

day = bfs(start)

for a in range(h):
    for b in range(n):
        if 0 in tomatoes[a][b]:
            day = 0

print(day - 1)
