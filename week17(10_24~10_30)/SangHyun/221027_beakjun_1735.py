def gcd(a, b):
    while b > 0:
        a, b = b, a % b
    return a


a1, a2 = map(int, input().split())
b1, b2 = map(int, input().split())

m = a2 * b2
s = a2 * b1 + a1 * b2

a=gcd(m,s)

print(s//a,m//a)
