from collections import deque

di = [1, 0, -1, 0]
dj = [0, 1, 0, -1]


def bfs(start):
    q = deque([start])
    visited = [[0] * m for _ in range(n)]
    i, j = start
    visited[i][j] = 1
    count = 1

    while q:
        size = len(q)
        for _ in range(size):
            i, j = q.popleft()

            if i == n - 1 and j == m - 1:
                return count

            for d in range(4):
                ni = i + di[d]
                nj = j + dj[d]

                if 0 <= ni < n and 0 <= nj < m and visited[ni][nj] == 0 and maze[ni][nj] == 1:
                    visited[ni][nj] = 1
                    q.append((ni, nj))
        else:
            count += 1


n, m = map(int, input().split())
maze = [list(map(int, list(input()))) for _ in range(n)]
start = (0, 0)
print(bfs(start))
