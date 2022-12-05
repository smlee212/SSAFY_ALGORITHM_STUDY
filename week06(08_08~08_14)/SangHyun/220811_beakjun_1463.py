n=int(input())
num=1
remem=[0 for _ in range(n)]
while num<n+1:
    temp=num
    count=0
    while temp>1:
        if temp>3:
            temp_list=[]
            if temp%3==0:
                temp_list.append(remem[(temp//3)-1])
            if temp%2==0:
                temp_list.append(remem[(temp//2)-1])
            temp_list.append(remem[temp-2])
            count=min(temp_list)+1
            break
        elif temp%3==0:
            temp=temp//3
        elif temp%2==0:
            temp=temp//2
        else :
            temp-=1
        count+=1
    remem[num-1]=count
    num+=1
print(remem[-1])
