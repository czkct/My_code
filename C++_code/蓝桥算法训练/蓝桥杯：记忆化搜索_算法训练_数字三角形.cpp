//蓝桥杯：记忆化搜索：  算法训练 数字三角形   （ＤＡＧ动态规划入门） 

#include<bits/stdc++.h>
using namespace std;
const int maxn = 100+5;
int a[maxn][maxn];
int d[maxn][maxn];
int n; 
//dp(i, j) 表示从当前点出发到底端的最大值 
int dp(int i, int j){
	int& ans = d[i][j]; 
	if(ans >= 0) return ans;
	return ans = a[i][j] + (i==n ? 0 : max(dp(i+1, j), dp(i+1, j+1)));
}
void init() {
	memset(d, -1, sizeof(d));  //初始化d数组
}
int main() {
	while(scanf("%d", &n)!=EOF){
		for(int i = 1; i <= n; i++) {
			for(int j = 1; j <= i; j++){
				scanf("%d", &a[i][j]);
			}		
		}//存图
		init(); //不能少   必须初始化 
		cout << dp(1, 1) << endl;
	}
	return 0;
}
