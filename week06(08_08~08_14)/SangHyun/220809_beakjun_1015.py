n=int(input())
p=list(i for i in range(n))

a=list(map(int,input().split()))

new_list=[]

for i,j in enumerate(a):
    new_list.append([j,i])

new_list=sorted(new_list,key = lambda x : x[0])

for i in range(n):
    new_list[i][0]=i

new_list=sorted(new_list,key = lambda x : x[1])

for i in range(n):
    print(new_list[i][0],end=' ')
