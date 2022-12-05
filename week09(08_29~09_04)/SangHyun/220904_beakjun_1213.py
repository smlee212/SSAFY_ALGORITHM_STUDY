ary=list(input())
alpha=[0]*26
for c in ary:
    alpha[ord(c)-65]+=1

count=0
for n in alpha:
    if n%2:
        count+=1
if count>1:
    print("I'm Sorry Hansoo")
else:
    stack=[]
    word=''
    for n in range(26):
        for _ in range(alpha[n]//2):
            word+=chr(n+65)
            stack.append(chr(n+65))
    for n in range(26):
        if alpha[n]%2:
            word+=chr(n+65)
            break
    while stack:
        word+=stack.pop()
    print(word)
        
        
            
