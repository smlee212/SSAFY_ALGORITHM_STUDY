n=int(input())
id_list=[]
for i in range(n):
    id_list.append(input())
for j in range(1, len(id_list[0])+1):
    check=[]
    for k in range(n):
        if id_list[k][-j:] in check:
            break
        else:
            check.append(id_list[k][-j:])
    if len(check)==n:
        print(j)
        break
