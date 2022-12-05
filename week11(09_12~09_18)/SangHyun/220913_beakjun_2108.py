import sys

input=sys.stdin.readline

n=int(input())
nums=[]
for _ in range(n):
    nums.append(int(input()))
nums.sort()
    
count=[0]*8001
for x in nums:
    count[4000+x]+=1

max_num=max(count)
i_num=count.index(max_num)
if max_num in count[i_num+1:]:
    i_num=i_num+count[i_num+1:].index(max_num)+1


print(round(sum(nums)/n))
print(nums[n//2])
print(i_num-4000)
print(abs(nums[-1]-nums[0]))
