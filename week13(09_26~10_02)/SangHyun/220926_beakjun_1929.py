m,n=map(int,input().split())
ary=[True]*(n+1)
ary[0]=False
ary[1]=False
prime=[]
for i in range(2,n+1):
    if ary[i]:
        prime.append(i)
    for x in range(2*i,n+1,i):
        ary[x]=False
for num in prime:
    if num>=m:
        print(num)
        
