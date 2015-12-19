#include<bits/stdc++.h>
using namespace std;
//状态F[i][j]:前i首歌曲所达到的最优状态
//这个最优状态包括两个小的最优状态
//1.最大歌曲数 、 2.最长歌曲时间 
//状态转移方程：F[i][j] = 最优(F[i-1][j], F[i-1][j-t] + t[i]); 
const int maxn = 50 + 5;
const int maxt = 50 * 3 * 60 + 5;
//顺序读入  边读边计算使得可以不要t[maxn]这个数组,所以可以直接用t代替当前第i首歌曲的时间 
typedef struct {//状态节点定义 
	int n;//1.最大歌曲数 
	int len;//2.最长歌曲时间 
}Node;
Node F[maxn][maxt]; //状态节点 
Node best(Node& x, Node& y){
	if(x.n < y.n) return y;  //先要保证歌曲数最大的情况下 ，再保证总时间最长 
	else if(x.n == y.n && x.len<=y.len) return y;
	else return x;
}
int main() {
	int T;
	cin >> T;
	int count = 0;
	while(T--) {
		int n, t0, t;
		cin >> n >> t0;
		memset(F, 0, sizeof(F)); 
		for(int i = 1; i <= n; i++) {
			cin >> t;//输入可以放在这里   能够这样写取决于状态的设定(状态要求使得i是顺序枚举) 
			for(int j = 0; j <= t0-1; j++) {
				if(i==1){   //边界一定要记得处理 
					F[i][j].n = 0; 
					F[i][j].len = 0;
				}else {
					F[i][j] = F[i-1][j];
					//无论如何,先使当前状态(F[i][j])等于相同时间j下不加上当前这首歌(i)的最优状态F[i-1][j] 
				}
				if(j >= t) {
					Node tmp;
					tmp.n = F[i-1][j-t].n + 1;
					tmp.len = F[i-1][j-t].len + t;
					F[i][j] = best(F[i][j], tmp);//两个子状态的比较
				}  
			}
		}
		cout << "Case " << ++count << ": " << F[n][t0-1].n+1 << " " << F[n][t0-1].len +678 << endl;
	} 
	return 0;
}
 
