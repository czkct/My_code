#include <iostream>
#include <string.h>
#include <cstdio>
using namespace std;
int G[1010][1010];
int d[1010];
int n;
int max(int a, int b){
	if(a>b) return a;
	else return b;
}
int dp(int i) {
    int &ans=d[i];
    if(ans>0) return ans; //记忆化
    ans=1;
    for(int j=1; j<=n; j++) {
        if(G[i][j]) ans = max(ans, dp(j)+1);
    }
    return ans;
}

int main()
{
    int N;
    scanf("%d", &N);
    while(N--){
        int a[1010], b[1010];
        memset(G, 0, sizeof(G));
        memset(d, 0, sizeof(d));
        scanf("%d", &n);
        for(int i=1;i<=n;i++) {
            scanf("%d%d", &a[i], &b[i]);
        }
        for(int i=1; i<=n; i++) {
            for(int j=1;j<=n; j++) {
                if((a[i]>a[j]&&b[i]>b[j])||(a[i]>b[j]&&b[i]>a[j])) {
                    G[i][j]=1;                                      ///建图,有向无环图。
                }
            }
        }
        int ans = 0;
        for(int i=1; i<=n; i++) {
            ans = max(ans, dp(i));
        }
        cout<<ans<<endl;
    }
    return 0;
}
