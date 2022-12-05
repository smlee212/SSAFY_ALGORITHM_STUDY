import sys

input = sys.stdin.readline

T = int(input())
for _ in range(T):
    p = list(input())
    n = int(input())
    ary = list(input().rstrip().strip('[ ]').split(','))
    temp = []
    for x in ary:
        if x.isdigit():
            temp.append(x)
    front = 0
    rear = len(temp)
    flag = 0
    r_flag = 0
    for word in p:
        if word == 'R':
            r_flag = 1 if r_flag == 0 else 0
        elif word == 'D':
            if front == rear:
                flag = 1
                break
            else:
                if r_flag == 1:
                    rear -= 1
                else:
                    front += 1
    if flag == 1:
        print('error')
    else:
        ary = list(map(str, list(temp[front:rear])))
        if r_flag == 1:
            ary = ary[::-1]
        s = ','.join(ary)
        s = '[' + s + ']'
        print(s)
