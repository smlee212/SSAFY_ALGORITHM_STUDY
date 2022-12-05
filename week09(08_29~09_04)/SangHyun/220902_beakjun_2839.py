n=int(input())
min_num=5000
for i in range(n//5+1):
    for j in range(n//3+1):
        if ((5*i)+(3*j))==n:
            temp=i+j
            min_num=temp if min_num>temp else min_num

if min_num!=5000:
    print(min_num)
else:
    print(-1)
