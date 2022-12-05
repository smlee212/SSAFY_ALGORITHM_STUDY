N=int(input())
A=list(map(int,input().split()))
B=list(map(int,input().split()))

C=[]
D=[0]*N
for i in enumerate(B):
    C.append(list(i))
C=sorted(C, key = lambda x : x[1],reverse = True)
A=sorted(A)
for j in range(N):
    D[C[j][0]]=A[j]
for k in range(N):
    D[k]=D[k]*B[k]
print(sum(D))
