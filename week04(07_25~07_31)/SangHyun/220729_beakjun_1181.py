T=int(input())
word_list=[]
for i in range(T):
    word_list.append(input())


word_list=sorted(set(word_list))
word_list=sorted(word_list,key= lambda word_list : len(word_list))
for i in word_list:
    print(i)
