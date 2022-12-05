n = int(input())
m = int(input())
p = [[] for _ in range(n + 1)]

for _ in range(m):
    a, b = map(int, input().split())
    p[a].append(b)
    p[b].append(a)

p_set = set(p[1])

for x in p[1]:
    for y in p[x]:
        if y not in p[1]:
            p_set = p_set | {y}

if len(p_set):
    print(len(p_set) - 1)
else:
    print(0)
