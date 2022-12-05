di = [1, 0, -1, 0]
dj = [0, 1, 0, -1]


def bfs(ary, i, j):
    global visited
    queue = [(i, j)]
    visited[i][j] = 1

    while queue:
        i, j = queue.pop(0)
        for d in range(4):
            ni = i + di[d]
            nj = j + dj[d]
            if 0 <= ni < n and 0 <= nj < m and visited[ni][nj] != 1 and ary[ni][nj] == 1:
                visited[ni][nj] = 1
                queue.append((ni, nj))

    return 1


T = int(input())
for _ in range(T):
    m, n, k = map(int, input().split())
    ary = [[0 for _ in range(m)] for _ in range(n)]
    for _ in range(k):
        j, i = map(int, input().split())
        ary[i][j] = 1
    visited = [[0 for _ in range(m)] for _ in range(n)]

    count = 0

    for i in range(n):
        for j in range(m):
            if ary[i][j] == 1 and visited[i][j] == 0:
                if bfs(ary, i, j) == 1:
                    count += 1

    print(count)
