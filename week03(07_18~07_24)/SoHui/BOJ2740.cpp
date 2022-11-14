#include <iostream>

using namespace std;
int num1[100][100],num2[100][100],res[100][100];

int main()
{
    int N,M,K;
    cin>>N>>M;
    for(int i=0;i<N;i++)
    {
        for(int j=0;j<M;j++)
        {
            cin>>num1[i][j];
        }
    }
    
    cin>>M>>K;
    for(int i=0;i<M;i++)
    {
        for(int j=0;j<K;j++)
        {
            cin>>num2[i][j];
        }
    }
    
    for(int i=0;i<N;i++)
    {
        for(int j=0;j<K;j++)
        {
            for(int k=0;k<M;k++)
            {
                res[i][j]+=num1[i][k]*num2[k][j];
            }
            cout<<res[i][j]<<" ";
        }
        cout<<endl;
    }
    
    return 0;
}