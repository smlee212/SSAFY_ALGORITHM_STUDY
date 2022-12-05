num = int(input())
switch = [0] + list(map(int, input().split()))
student = int(input())
for _ in range(student):
    gender, point = map(int, input().split())
    if gender == 1:
        for a in range(1, num + 1):
            if a % point == 0:
                switch[a] = 1 if switch[a] == 0 else 0
    else:
        switch[point] = 1 if switch[point] == 0 else 0
        i = 1
        while point - i >= 1 and point + i <= num:
            if switch[point - i] == switch[point + i]:
                switch[point - i] = 1 if switch[point - i] == 0 else 0
                switch[point + i] = 1 if switch[point + i] == 0 else 0
                i += 1
            else:
                break

for j in range(1, num + 1):
    if j % 20 == 0:
        print(switch[j])
    else:
        print(switch[j], end=' ')
