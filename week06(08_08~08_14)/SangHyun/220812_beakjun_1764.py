n,m=map(int,input().split())
not_listen=[]
not_see=[]
for _ in range(n):
    not_listen.append(input())
for _ in range(m):
    not_see.append(input())
not_listen=set(not_listen)
not_see=set(not_see)
answer=sorted(not_listen & not_see)
print(len(answer))
for i in range(len(answer)):
    print(answer[i])
