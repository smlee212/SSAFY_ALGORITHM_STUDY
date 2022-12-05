t = int(input())

for _ in range(t):
    x, y = map(int,input().split())
    distance = y - x
    count = 0  
    move = 1 
    total = 0 
    while total < distance :
        count += 1
        total += move
        if count % 2 == 0 :
            move += 1  
    print(count)
