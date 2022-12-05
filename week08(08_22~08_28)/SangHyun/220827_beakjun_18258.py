import sys
input=sys.stdin.readline

q=[0]*2000001
top=0
rear=0

def push(n):
    global rear
    rear=(rear+1)%2000000
    q[rear]=n

def pop():
    global top
    if top==rear:
        return -1
    else:
        top=(top+1)%2000000
        return q[top]

def size():
    return rear-top

def empty():
    if top==rear:
        return 1
    else:
        return 0
    
def front():
    if top==rear:
        return -1
    else:
        return q[top+1]
    
def back():
    if top==rear:
        return -1
    else:
        return q[rear]
    

n=int(input())
for _ in range(n):
    s=list(input().split())
    if s[0]=='push':
        push(int(s[1]))
    elif s[0]=='pop':
        print(pop())
    elif s[0]=='size':
        print(size())
    elif s[0]=='empty':
        print(empty())
    elif s[0]=='front':
        print(front())
    elif s[0]=='back':
        print(back())
