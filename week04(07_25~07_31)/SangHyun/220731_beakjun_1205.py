#N: 리스트에 있는 점수의 개수, P : 리스트에 올라갈 수 있는 점수의 개수
def scoring():
    N, new_score, P = map(int,input().split())

    if N==0:
        return 1
    else:
        score_list=list(map(int,input().split()))
        if N==P and new_score<=score_list[-1]:
            return -1
        else :
            rank=N+1
            for i in range(N):
                if score_list[i]<=new_score:
                    rank=i+1
                    break
            return rank

print(scoring())
