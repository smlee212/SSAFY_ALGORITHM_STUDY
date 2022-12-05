n=int(input())
num_list=[]
for _ in range(n):
    num_list.append(int(input()))
num_list=sorted(num_list)
max_check=0
for i in num_list:
    check=0
    temp_list=list(i+j for j in range(5))
    for k in temp_list:
        if k in num_list:
            check+=1
            if max_check<check:
                max_check=check
                
print(5-(max_check if max_check<=5 else 5))            
    
