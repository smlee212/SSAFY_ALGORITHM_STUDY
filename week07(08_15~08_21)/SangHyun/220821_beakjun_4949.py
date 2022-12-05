while True:
    s=input()
    if s=='.':
        break
    stack=[]
    for x in s:
        if x=='(' or x=='[':
            stack.append(x)
        elif x==')':
            if len(stack)==0 or stack[-1]!='(':
                print('no')
                break
            elif stack[-1]=='(':
                stack.pop(-1)
        elif x==']':
            if len(stack)==0 or stack[-1]!='[':
                print('no')
                break
            elif stack[-1]=='[':
                stack.pop(-1)
    else:
        if len(stack)!=0:
            print('no')
        else:
            print('yes')
    
