primes = []
a, b = map(int, input().split())
nums = [1] * (b + 1)
count = [0] * (b + 1)
nums[1] = 0
nums[0] = 0
under_prime = 0
for i in range(2, b + 1):
    if nums[i] == 1:
        temp = 2
        while i * temp <= b:
            nums[i * temp] = 0
            temp += 1
        primes.append(i)
        count[i] = 1
    else:
        for x in primes:
            if i % x == 0:
                count[i] = count[i // x] + 1
                break

for j in range(a,b+1):
    if count[j] in primes:
        under_prime+=1

print(under_prime)