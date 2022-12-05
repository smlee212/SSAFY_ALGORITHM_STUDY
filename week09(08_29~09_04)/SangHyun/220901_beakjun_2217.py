n = int(input())
rope = []
for _ in range(n):
    rope.append(int(input()))

rope.sort(reverse=True)
max_num = 0
for i in range(len(rope)):
    num = rope[i] * (i + 1)
    if num >= rope[0]:
        max_num = num if max_num < num else max_num
    else:
        break

print(max_num)
