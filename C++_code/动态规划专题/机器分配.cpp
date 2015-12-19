#include<bits/stdc++.h>   
using namespace std;
const int maxn = 11;
const int maxm = 16;
const int INF = 1<<30;
int value[maxn][maxm];//第maxn个公司maxm个机器获取的最大价值
int F[maxn][maxm];//前maxn个公司maxm个机器获取的最大价值
int answer[maxn][maxm]; //第maxn个公司maxm个机器获取最大价值时第maxn个公司所需要的机器数
//不但要记忆化 前maxn个公司maxm个机器获取的最大价值，
//还要记忆化 第maxn个公司maxm个机器获取最大价值时第maxn个公司所需要的机器数
void init(){
	memset(F, -1, sizeof(F));
}
void output(int i, int j) {
	if(i == 0) return ;
	output(i-1, j-answer[i][j]);
	printf("%d %d\n", i, answer[i][j]);
}
int dp(int i, int j) {
	if(i == 0) return 0;
	int& ans = F[i][j];
	if(ans >= 0) return ans;
	ans = -INF;
	for(int k = 0; k <= j; k++) {
		int tmp = dp(i-1, j-k)+value[i][k];
		if(tmp > ans) {
			ans = tmp;
			answer[i][j] = k;
		}
	}
	return ans; 
} 

int main() {
	int n, m;
	while(cin >> n >> m) {
		for(int i = 1; i <= n; i++) 
			for(int j = 1; j <= m; j++) {
				scanf("%d", &value[i][j]);
			}
		//存图完毕
		init();
		int ans = dp(n, m);
		cout << ans << endl;
		output(n, m);
	}
	return 0;
}
