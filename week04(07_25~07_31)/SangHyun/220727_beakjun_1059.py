def check_good(L,S,n):
    A=0
    B=0
    for i in S:
        if i<n:
            A=i
        elif i>n:
            B=i
            break;
        else:
            return 0,0
    return A,B

L=int(input())
S=sorted(list(map(int,input().split())))
n=int(input())
A,B=check_good(L,S,n)
        
good=list(range(A+1,B))
count=0
for j in good:
    if j<n:
        for k in good[good.index(n):]:
            count+=1
    elif j>n:
        count+=1
        
print(count)    
