T = int(input())
for _ in range(T):
    n, m = map(int, input().split())
    queue = list(map(int, input().split()))
    i_list = list(range(n))
    count = 0
    x = 0
    while True:
        if queue[x] == max(queue):
            if i_list[x] == m:
                print(count+1)
                break
            else:
                count += 1
                queue[x] = 0
        else:
            x = (x + 1) % n
