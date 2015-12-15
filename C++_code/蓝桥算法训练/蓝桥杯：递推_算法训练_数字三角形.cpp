//蓝桥杯：递推：  算法训练 数字三角形   （ＤＡＧ动态规划入门） 
#include<bits/stdc++.h>
using namespace std;
const int maxn = 100+5;
int a[maxn][maxn];
int d[maxn][maxn];
void init(){
	memset(d, -1, sizeof(d));
}
int main() {
	int n;
	while(cin >> n) {
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < i+1; j++) {
				cin >> a[i][j];
			}
		}
		//init();递推中这个可有可无 
		for(int j = 0; j < n; j++) d[n-1][j] = a[n-1][j];
		for(int i = n-2; i >= 0; i--) 
			for(int j = 0; j < i+1; j++)
				d[i][j] = a[i][j]+max(d[i+1][j], d[i+1][j+1]);
		cout << d[0][0] << endl;
	}
	return 0;
}
