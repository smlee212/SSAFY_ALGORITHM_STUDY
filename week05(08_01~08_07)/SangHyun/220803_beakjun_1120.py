def check_string():
    a,b=input().split()
    count=0
    count_list=[]
    if a in b:
        return 0
    if len(a)==len(b):
        for i in range(len(a)):
            if a[i]!=b[i]:
                count+=1
        return count
    else:
        for j in range(len(b)-len(a)+1):
            count=0
            for k in range(len(a)):
                if a[k]!=b[j+k]:
                    count+=1
            count_list.append(count)
        return min(count_list)
 
print(check_string())
