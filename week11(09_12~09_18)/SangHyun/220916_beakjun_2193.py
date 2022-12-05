n = int(input())
count = 0
for i in range(1, n + 1):
    binaryNum = bin(i)[2:]
    print(binaryNum)
    if '11' not in binaryNum:
        count += 1
print(count)
