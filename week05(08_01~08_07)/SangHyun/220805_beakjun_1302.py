n=int(input())
word_dict={}
for _ in range(n):
    word=input()
    if word in word_dict.keys():
        word_dict[word]+=1
    else:
        word_dict[word]=1
name=''
count=0
word_dict=dict(sorted(word_dict.items()))
word_dict=dict(sorted(word_dict.items(),key=lambda x:x[1]))
for x,y in word_dict.items():
    if count<y:
        count=y
        name=x
print(name)
