#N : 끊어진 기타줄의 개수, M : 기타줄 브랜드
n,m=map(int,input().split())
#패키지 가격,낱개의 가격
price_list=[]
for i in range(m):
    price_list.append(list(map(int,input().split())))
package_list=[]
individual_list=[]
for j in price_list:
    package_list.append(j[0])
    individual_list.append(j[1])

if 6*min(individual_list)<min(package_list):
    total=min(individual_list)*n
else :
    
    if (n%6)*min(individual_list)>min(package_list):
        total=min(package_list)*((n//6)+1)
    else:
        total=min(package_list)*(n//6)+(n%6)*min(individual_list)

print(total)
