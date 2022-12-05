def back():
    global visited

    if len(visited) == m:
        for a in visited:
            print(ary[a], end=' ')
        print()
        return

    for i in range(n):
        if i not in visited:
            visited.append(i)
            back()
            visited.pop()


n, m = map(int, input().split())
visited = []
ary = [i for i in range(1, n + 1)]
back()
