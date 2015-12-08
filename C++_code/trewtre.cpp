#include <iostream>
#include <stdio.h>
using namespace std;
char a[1000010];
int next[1000010];
int n;
void GetNext()    //获得a数列的next数组
{
    int i=0,k=-1;
    next[0] = -1;
    while(i<n){
        if(k==-1){
            next[i+1] = 0;
            i++;k++;
        }
        else if(a[i]==a[k]){
            next[i+1] = k+1;
            i++;k++;
        }
        else
            k = next[k];
    }
}
void DisRes(int num)
{
    int j;
    printf("Test case #%d\n",num);
    for(int i=0;i<n;i++){
        if(next[i]==-1 || next[i]==0)   //next[i]是-1或0的忽略，说明之前没有周期性前缀
            continue;
        j = i - next[i];
        if(i%j==0)  //能整除，说明存在周期性前缀
            printf("%d %d\n",i,i/j);    //输出这个前缀的长度和周期数
    }
    printf("\n");
}
int main()
{
    int num = 0;
    while(scanf("%d",&n)!=EOF){
        if(n==0) break;
        scanf("%s",a);
        GetNext();  //获得next[]数组
        DisRes(++num);  //输出结果
    }
    return 0;
}
