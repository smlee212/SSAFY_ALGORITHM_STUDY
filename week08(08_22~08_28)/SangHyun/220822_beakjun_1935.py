n=int(input())
s=input()
stack=[]
num_dict={}
for i in range(n):
    num_dict[chr(ord('A')+i)]=int(input())
for x in s:
    if 'A' <= x <='Z':
        stack.append(num_dict[x])
    elif x=='+':
        stack[-2]=stack[-1]+stack[-2]
        stack.pop(-1)
    elif x=='-':
        stack[-2]=stack[-2]-stack[-1]
        stack.pop(-1)
    elif x=='*':
        stack[-2]=stack[-2]*stack[-1]
        stack.pop(-1)
    elif x=='/':
        stack[-2]=stack[-2]/stack[-1]
        stack.pop(-1)
print(f'{stack[0]:.2f}')
                
        
