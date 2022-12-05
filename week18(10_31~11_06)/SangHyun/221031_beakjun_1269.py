a, b = map(int, input().split())
set_a = set(list(map(int, input().split())))
set_b = set(list(map(int, input().split())))
union = set_b & set_a

print(len(set_a)+len(set_b)-2*len(union))
