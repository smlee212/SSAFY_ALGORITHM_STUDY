def preorder(i):
    if tree[i]:
        print(tree[i], end='')
        if i*2+1<=N:
            preorder(i * 2)
            preorder(i * 2 + 1)


def inorder(i):
    if tree[i]:
        if i*2+1<=N:
            inorder(i * 2)
        print(tree[i], end='')
        if i*2+1<=N:
            inorder(i * 2 + 1)


def postorder(i):
    if tree[i]:
        if i*2+1<=N:
            postorder(i * 2)
            postorder(i * 2 + 1)
        print(tree[i], end='')


N = int(input())
tree = [0] * (N + 1)
for _ in range(N):
    p, c1, c2 = input().split()
    tree[ord(p) - 65 + 1] = p

print(tree)
preorder(1)
