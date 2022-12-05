import copy
t=int(input())
test_list=[]
for _ in range(t):
    test_list.append(int(input()))


for n in test_list:
    num_0=[1,0]
    num_1=[0,1]
    num_n=[0,0]
    i=0
    while i<=n:
        if i==0:
            num_n=num_0[:]
        elif i==1:
            num_n=num_1[:]
        else:
            num_n[0]=num_0[0]+num_1[0]
            num_n[1]=num_0[1]+num_1[1]
            num_0=copy.deepcopy(num_1)
            num_1=copy.deepcopy(num_n)
        i+=1
            
    print(f'{num_n[0]} {num_n[1]}')
