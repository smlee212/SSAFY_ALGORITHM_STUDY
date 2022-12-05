import sys

input = sys.stdin.readline

n = int(input())
nums = list(map(int, input().split()))
count = [0] * 20000001
for x in nums:
    count[x + 10000000] += 1
m = int(input())
a_list = list(map(int, input().split()))
for x in range(m):
    a_list[x] = count[a_list[x] + 10000000]
print(*a_list)
