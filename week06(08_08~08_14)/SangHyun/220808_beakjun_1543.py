file=list(input())
word=input()

i=0
length=len(file)
count=0
while i<length:
    if word==''.join(file[i:i+len(word)]):
        del file[i:i+len(word)]
        length-=len(word)
        count+=1
    else:
        i+=1

print(count)
