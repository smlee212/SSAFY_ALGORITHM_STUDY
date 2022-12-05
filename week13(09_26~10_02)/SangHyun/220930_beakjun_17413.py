word = list(input())
stack = []
ans = ''
i = 0
while True:
    if word[i].isalpha() or word[i].isdigit():
        stack.append(word[i])
    elif word[i] == ' ':
        while stack:
            ans += stack.pop()
        ans += ' '
    elif word[i] == '<':
        if stack:
            while stack:
                ans += stack.pop()
            i-=1
        else:
            while word[i] != '>':
                ans += word[i]
                i += 1
            ans += '>'
    i += 1
    if i>len(word)-1:
        break

while stack:
    ans += stack.pop()

print(ans)
