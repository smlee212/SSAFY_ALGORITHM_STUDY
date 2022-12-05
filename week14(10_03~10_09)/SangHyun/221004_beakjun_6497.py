def find_set(x):
    while x != p[x]:
        x = p[x]
    return x


def union(x, y):
    p[find_set(y)] = find_set(x)

while True:
    m, n = map(int, input().split())
    if m==0 and n==0:
        break
    adj = []
    p = [i for i in range(m)]
    for _ in range(n):
        a, b, w = map(int, input().split())
        adj.append((w, a, b))

    adj.sort()

    total = 0

    for w, a, b in adj:
        if find_set(a) != find_set(b):
            union(a, b)
        else:
            total += w
    print(total)
