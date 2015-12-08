#include<cstdio>
#include<cstring>
#include<cstdlib>
using namespace std;

//含有1000个以内的矩形
const int MAXN = 1000+5; 
int G[MAXN][MAXN];
int a[MAXN],b[MAXN];
int d[MAXN]; 
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

int main() {
	int N;
	scanf("%d", &N);
	while(N--){
		memset(d, 0, sizeof(d));
		memset(G, 0, sizeof(G));// 初始化邻接表 
		scanf("%d", &n);
		for(int i = 1; i <= n; i++)
			scanf("%d%d", &a[i], &b[i]);//存点 
		
		for(int i = 1; i <= n; i++){
			for(int j = 1; j <= n; j++){
				if((a[i]>a[j]&&b[i]>b[j])||(a[i]>b[j]&&b[i]>a[j])) //这个判断非常容易写错 
				G[i][j] = 1;//G[i][j]就表示矩形i可以嵌套矩形j 
			}
		}
		int answ = 0; 
		for(int i = 1; i <= n; i++){
			answ = max(answ, dp(i));
		} 
		printf("%d\n", answ);
	}
	return 0;
} 
