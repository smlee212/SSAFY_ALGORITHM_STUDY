def find_set(x):
    while p[x] != x:
        x = p[x]
    return x


def union(x, y):
    p[find_set(y)] = find_set(x)


n = int(input())
m = int(input())
p = [i for i in range(n + 1)]
adj = []
for _ in range(m):
    a, b, w = map(int, input().split())
    adj.append((w, a, b))

adj.sort()
total = 0
for w, a, b in adj:
    if find_set(a) != find_set(b):
        union(a, b)
        total += w
print(total)
