def p(stg, temp):
    if stg > m:
        print(*temp)
        return
    else:
        for i in range(n):
            if len(temp) > 0 and ary[i] > temp[-1]:
                temp.append(ary[i])
                p(stg + 1, temp)
                temp.pop()
            elif len(temp) == 0:
                temp.append(ary[i])
                p(stg + 1, temp)
                temp.pop()


n, m = map(int, input().split())
ary = list(map(int, input().split()))
ary.sort()
p(1, [])
