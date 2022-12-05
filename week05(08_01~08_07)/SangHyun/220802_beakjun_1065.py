def check_hansu(n):
    count=0
    for i in range(1,n+1):
        num_list=list(map(int,list(str(i))))
        if len(num_list)>2:
            if (num_list[2]-num_list[1])==(num_list[1]-num_list[0]):
                count+=1
        else:
            count+=1
    return count

n=int(input())
print(check_hansu(n))
