num, p1, p2=map(int,input().split())
tornament=[0]*(num+1)
tornament[p1]=1
tornament[p2]=1
count=1
while len(tornament)!=2:
    if len(tornament)%2==0:
        tornament+=[0]
    for i in range(1,len(tornament),2):
        a=tornament.pop(1)
        b=tornament.pop(1)
        if a==1 or b==1:
            if a==b:
                break
            else:
                tornament.append(1)
        else:
            tornament.append(0)
    else:
        count+=1
        continue
    break
    
print(count)
    
    
