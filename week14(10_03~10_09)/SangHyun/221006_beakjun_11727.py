n=int(input())
dp=[0,1,3,5,11]
for i in range(5,n+1):
    dp.append(2*dp[i-2]+dp[i-1])
print(dp[n]%10007)
