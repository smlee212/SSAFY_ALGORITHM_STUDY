def p(now,temp):
    if now==m:
        print(*temp)
        return
    else:
        for i in range(1,n+1):
            temp.append(i)
            p(now+1,temp)
            temp.pop()


n,m=map(int,input().split())
p(0,[])
