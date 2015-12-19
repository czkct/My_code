//机器分配：  递推  解决dp问题
#include<bits/stdc++.h>
using namespace std;
const int maxn = 11;
const int maxm = 16;
int dp[maxn][maxm], result[maxn][maxm], val[maxn][maxm];

int main() {
	int n, m;
	cin >> n >> m;
	for(int i = 1; i <= n; i++) {
		for(int j = 1; j <= m; j++) {
			cin >> val[maxn][maxm]; 
		}
	}
	int ans = 0;
	for(int i = 1; i <= n; i++) {
		for(int j = 1; j <= m; j++) {
			for(int k = 0; k <=j ; k++) {
				ans = dp[i][j-k]+val[i-1][k];
				if(ans > dp[i][j]){
					dp[i][j] = ans;
					result[i][j] = k;
				}
			}
		}
	}
}
