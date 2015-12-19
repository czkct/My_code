#include<bits/stdc++.h>
using namespace std;
//状态F[j]:前i首歌曲所达到的最优状态
//这个最优状态包括两个小的最优状态
//1.最大歌曲数 、 2.最长歌曲时间 
//状态转移方程：F[j] = 最优(F[j], F[i-1][j-t] + t); 
//F数组是从上到下、从右往左计算的。在计算F[i][j]之前，F[j]中保存的就是F[i-1][j]的值，所以可以把它写成一维
//参考紫书p273图（9-6） 这个就是滚动数组，优化了空间   注意使用滚动数组时  j一定要逆序枚举   不然后面的F元素
//会因为前面已经更新的F元素而再次更新 (倒序就不会发生这样的情况)，从而发生错误。！！！ 
//const int maxn = 50 + 5;F变成一维数组  ，这个也就省略了 
const int maxt = 50 * 3 * 60 + 5;
//顺序读入  边读边计算使得可以不要t[maxn]这个数组,所以可以直接用t代替当前第i首歌曲的时间 
typedef struct {//状态节点定义 
	int n;//1.最大歌曲数 
	int len;//2.最长歌曲时间 
}Node;
Node F[maxt]; //状态节点 
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
		//F数组的初始化;
		memset(F, 0, sizeof(F));   //这一句其实也可以不要  想一想这个数组的更新过程就知道了
		//不过最好还是写上，以区别每一组测试数组就清空一下F状态数组 
		for(int i = 1; i <= n; i++) {
			cin >> t;//输入可以放在这里   能够这样写取决于状态的设定(状态要求使得i是顺序枚举) 
			for(int j = t0-1; j>= 0; j--) {
				if(i==1){   //边界一定要记得处理 
					F[j].n = 0; 
					F[j].len = 0;
				}else {
					F[j] = F[j];
					//无论如何,先使当前状态(F[i][j])等于相同时间j下不加上当前这首歌(i)的最优状态F[i-1][j] 
				}
				if(j >= t) {
					Node tmp;
					tmp.n = F[j-t].n + 1;
					tmp.len = F[j-t].len + t;
					F[j] = best(F[j], tmp);//两个子状态的比较
				} 
			}
		}
		cout << "Case " << ++count << ": " << F[t0-1].n+1 << " " << F[t0-1].len +678 << endl;
	} 
	return 0;
}
 
