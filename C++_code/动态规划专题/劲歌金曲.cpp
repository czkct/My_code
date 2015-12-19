#include<bits/stdc++.h>
using namespace std;
//状态F[i][j]:前i首歌曲所达到的最优状态
//这个最优状态包括两个小的最优状态
//1.最大歌曲数 、 2.最长歌曲时间 
//状态转移方程：F[i][j] = 最优(F[i-1][j], F[i-1][j-t[i]] + t[i]); 
const int maxn = 50 + 5;
const int maxt = 50 * 3 * 60;
int t[maxn];//每首歌曲时间
typedef struct {//状态节点定义 
	int n;//1.最大歌曲数 
	int len;//2.最长歌曲时间 
}Node;
Node F[maxn][maxt]; //状态节点 
Node best(Node& x, Node& y){
	if(x.n < y.n) return y;
	else if(x.n == y.n && x.len<=y.len) return y;
	else return x;
}
int main() {
	int T;
	cin >> T;
	int count = 0;
	while(T--) {
		int n, t0;
		cin >> n >> t0;
		//F数组的初始化;
		memset(F, 0, sizeof(F)); 
		for(int i = 0; i <= n; i++) {
			cin >> t[i];
		}
		for(int i = 1; i <= n; i++) {
			for(int j = 1; j <= t0-1; j++) {
				if(i==1){
					F[i][j].n = 0;
					F[i][j].len = 0;
				}else {
					F[i][j] = F[i-1][j];
				}
				Node tmp;
				if(j >= t[i]) {
					tmp.n = F[i-1][j-t[i]].n + 1;
					tmp.len = F[i-1][j-t[i]].len + t[i];
				}
				if(j >= t[i] && tmp.len <= (t0-1)) F[i][j] = best(F[i][j], tmp);//两个子状态的比较 
				//cout << "F["<< i <<"]["<< j <<"] = " << F[i][j].len << endl; //打印状态 
			}
		}
		cout << "Case " << ++count << ": " << F[n][t0-1].n+1 << " " << F[n][t0-1].len +678 << endl;
	} 
	return 0;
}
 
