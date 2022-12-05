from collections import deque

n, k = map(int, input().split())
queue = deque()
for i in range(1, n + 1): queue.append(i)
ans = []
num = 1
while queue:
    now = queue.popleft()
    if num == k:
        ans.append(now)
        num = 1
        continue
    else:
        queue.append(now)
    num += 1

print('<', end='')
for a in range(0, n - 1):
    print(f'{ans[a]}', end=', ')
print(f'{ans[-1]}>')
