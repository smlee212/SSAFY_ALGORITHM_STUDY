while True:
    s = list(map(int, input().split()))
    if len(s) == 1 and s[0] == 0:
        break
    n = s[0]
    nums = s[1:]
    ans=[]
    for i in range(1<<n):
        temp=[]
        for j in range(n):
            if i&(1<<j):
                temp.append(nums[j])
        if len(temp)==6:
            ans.append(temp[:])
    ans.sort()
    for x in ans:
        print(*x)
    print()
