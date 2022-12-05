while True:
    n=int(input())
    if not n:
        break
    a = [False,False] + [True]*(2*n+1)
    primes=[]

    for i in range(2,(2*n)+1):
      if a[i]:
        primes.append(i)
        for j in range(2*i, (2*n)+1, i):
            a[j] = False
    count=0
    for x in primes:
        if n<x<=2*n:
            count+=1
            
    print(count)
    
