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
	if(x.n < y.n) return y;  //先要保证歌曲数最大的情况下 ，再保证总时间最长 
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
		memset(F, 0, sizeof(F));
		for(int i = 1; i <= n; i++) {
			cin >> t[i];//输入可以放在这里   能够这样写取决于状态的设定(状态要求i是顺序枚举) 
			for(int j = 0; j <= t0-1; j++) {
				if(i==1){   //边界一定要记得处理 
					F[i][j].n = 0;
					F[i][j].len = 0;
				}else {
					F[i][j] = F[i-1][j];
				}
				if(j >= t[i]) {
					Node tmp;
					tmp.n = F[i-1][j-t[i]].n + 1;
					tmp.len = F[i-1][j-t[i]].len + t[i];
					F[i][j] = best(F[i][j], tmp);//两个子状态的比较
				} 
//				tmp.len <= (t0-1)这个条件的判断实际上是不需要的，之所以前面一个代码会加上，
//				就是因为对自己定义的这个状态还不是很清楚
//				临时状态tmp 是在之前.前i-1首歌曲在j-t[i]的时间内达到的最优状态F[i-1][j-t[i]]的基础上 
//				再加上i这首歌曲的时间t[i]所达到的新状态，也就是说tmp状态就是F[i][j]的一种决策(增加第i首歌曲)，而
//				F[i][j]的另一种决策自然就是F[i-1][j](即不增加第i首歌曲),所以无论是哪一个tmp，他的时间即
//				tmp.len一直都是j， j的变化范围是1~(t0-1), 自然就不会超过t0-1这个值，所以 
//				tmp.len <= (t0-1)这个判断条件是多余的。 
//				cout << "F["<< i <<"]["<< j <<"] = " << F[i][j].len << endl; //打印状态 
			}
		}
		cout << "Case " << ++count << ": " << F[n][t0-1].n+1 << " " << F[n][t0-1].len +678 << endl;
	} 
	return 0;
}
 
