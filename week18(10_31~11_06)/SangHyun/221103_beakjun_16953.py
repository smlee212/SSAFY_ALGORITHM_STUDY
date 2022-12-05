from collections import deque

a, b = map(int, input().split())

q = deque([a])
count = 1

while q:
    size = len(q)
    for _ in range(size):
        now = q.popleft()
        if now == b:
            break
        if now>b:
            continue
        if now <= 5 * (10 ** 8):
            q.append(now * 2)
            if now < 10 ** 8:
                q.append(now * 10 + 1)
    else:
        count += 1
        if not q:
            count = -1
        continue
    break

print(count)
