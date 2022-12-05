n, w, l = map(int, input().split())
truck = [0] + list(map(int, input().split()))

queue = []
now = 1
count = 0

while True:
    print(queue)
    if now==n+1:
        break

    for i in queue:
        i[1] += 1
    for i in queue:
        if i[1] == w+1:
            queue.pop(0)

    if not queue:
        queue.append([truck[now], 1])
        now += 1
    elif len(queue) == w:
        count += 1
        continue
    else:
        temp = [i[0] for i in queue]
        if sum(temp) + truck[now] <= l:
            queue.append([truck[now], 1])
            now += 1
    count += 1

print(count+w)
