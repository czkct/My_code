#include<bits/stdc++.h>
using namespace std;
const int maxn = 50 + 5;
int value[maxn];
typedef struct {
	int n;
	int len;
}node;
const int maxt = 50*3*60+5;
node F[maxn][maxt];
 
int main() {
	int T;
	cin >> T;
	int n, t;
	while(cin >> n >> t) {
		memset(F, 0, sizeof(F));
		for(int i = 1; i <= n; i++) {
			cin >> value[i];
		}
		for(int i = 1; i<= n; i++) {
			for(int j = 1; j <= t-1; i++) {//Ê±¼ät 
				if()
			}
		}
	}
	return 0;
} 
