import sys

input = sys.stdin.readline

n = int(input())
ary = list(map(int, input().split()))

left = 0
right = n - 1
ans_l = 0
ans_r = 0
min_num = sys.maxsize
while left < right:
    _sum = ary[left] + ary[right]

    if abs(_sum) < min_num:
        ans_l = left
        ans_r = right
        min_num = abs(_sum)

    if _sum > 0:
        right -= 1
    elif _sum < 0:
        left += 1
    else:
        break
print(ary[ans_l], ary[ans_r])
