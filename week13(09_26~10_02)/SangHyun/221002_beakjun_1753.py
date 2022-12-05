INF = 10000000
from collections import deque
from sys import stdin

input=stdin.readline



def dijkstra(start):
    D = [INF] * (v + 1)
    D[start] = 0
    q = deque([start])

    while q:
        node = q.popleft()

        for next, w in adj[node]:
            if D[node] + w < D[next]:
                D[next] = D[node] + w
                q.append(next)
    return D


v, e = map(int, input().split())
k = int(input())
adj = deque()
for _ in range(v + 1):
    adj.append(deque())
for _ in range(e):
    a, b, w = map(int, input().split())
    adj[a].append((b, w))

print(adj)

d = dijkstra(k)

for i in range(1, v + 1):
    if d[i] == INF:
        print('INF')
    else:
        print(d[i])
