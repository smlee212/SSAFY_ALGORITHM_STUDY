def p(stg, temp):
    if stg > m:
        print(*temp)
        return
    else:
        for i in range(1, n + 1):
            if len(temp) > 0 and i >= temp[-1]:
                temp.append(i)
                p(stg + 1, temp)
                temp.pop()
            elif len(temp)==0:
                temp.append(i)
                p(stg + 1, temp)
                temp.pop()


n, m = map(int, input().split())
p(1, [])
