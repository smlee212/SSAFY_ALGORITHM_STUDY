#include <iostream>
int ch[10];
using namespace std;

int main()
{
    int room_num;
    cin>>room_num;
    
    while(room_num!=0)
    {
        int num;
        num=room_num%10; //10으로 나눈 나머지 
        room_num=room_num/10; //몫
        if(num==6)
        {
            if(ch[6]==0 || (ch[6]!=0 && ch[9]!=0)) ch[6]++;
            else if(ch[6]!=0 && ch[9]==0) ch[9]++; 
        }
        else if(num==9)
        {
            if(ch[9]==0 || (ch[6]!=0 && ch[9]!=0)) ch[9]++;
            else if(ch[9]!=0 &&ch[6]==0) ch[6]++;
        }
        else
        {
            ch[num]++;
        }    
    }
    int num1=ch[6]+ch[9];
    
    if(num1%2==0)
    {
        ch[9]=ch[6]=num1/2;
    }
    else
    {
        ch[9]=num1/2;
        ch[6]=1+(num1/2);
    }
    
    int max=-2147000000;
    for(int i=0;i<10;i++)
    {
        if(ch[i]>max) max=ch[i];
    }
    
    cout<<max<<endl;
    
    return 0;
}