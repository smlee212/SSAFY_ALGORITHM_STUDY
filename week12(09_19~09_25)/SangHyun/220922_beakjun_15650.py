n, m = map(int, input().split())
num_ary = [i for i in range(n)]
visited = [0] * (n + 1)

temp = []


def comb(now, temp):
    if len(temp) == m:
        print(*temp)
        return
    else:
        for i in range(now+1,n+1):
            temp.append(i)
            comb(i, temp)
            temp.pop()


comb(0, temp)
