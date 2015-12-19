#include<bits/stdc++.h>
using namespace std;
const int maxn = 50+5;
int value[maxn];
int f[maxn][maxn];
int main() {
	int T;
	cin >> T;
	while(T--) {
		int n, t;
		cin >> n >> t; 
		memset(f, 0, sizeof(f));
		for(int i = 1; i <= n; i++) {
			cin >> value[i];
		}
		for(int i = 1; i <= n; i++) {
			for(int j = 1; j <= t; j++) {
				for(int k = 1; k <= n; k++) {
					f[i][j] = (i == 1? 0 : f[i-1][j]);
					int tmp = f[i-1][j-value[k]]+value[k];
					if(t > tmp) f[i][j] = max(f[i][j], tmp);
				} 
			}
		}
		cout << f[n][t-1]+678 << endl;
	}
	return 0;
} 
