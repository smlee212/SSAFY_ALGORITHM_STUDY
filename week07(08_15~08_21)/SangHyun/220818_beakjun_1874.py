n = int(input())
stack = []
ary = [int(input()) for _ in range(n)]
answer = []
j = 1
for i in ary:
    while j <= n:
        if i >= j:
            stack.append(j)
            answer.append('+')
        elif len(stack) != 0 and stack[-1] == i:
            stack.pop(-1)
            answer.append('-')
            break
        j += 1
    else:
        if j == n + 1 and i == stack[-1]:
            stack.pop(-1)
            answer.append('-')
        else:
            print('NO')
            break
else:
    for a in answer:
        print(a)
