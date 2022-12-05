l, c = map(int, input().split())
password = list(input().split())
password.sort()
# print(password)

vowels = []
cons = []

possible = []

for x in password:
    if x in ['a', 'e', 'i', 'o', 'u']:
        vowels.append(x)
    else:
        cons.append(x)

v_num = len(vowels)
c_num = len(cons)

for a in range(1 << v_num):
    temp = []
    for b in range(v_num):
        if a & (1 << b):
            temp.append(vowels[b])
    if len(temp) > 0 and l - len(temp) >= 2:
        for c in range(1 << c_num):
            c_temp = temp[:]
            for d in range(c_num):
                if c & (1 << d):
                    c_temp.append(cons[d])
            if len(c_temp) == l:
                c_temp.sort()
                possible.append(''.join(c_temp))

possible.sort()
for x in possible:
    print(x)
