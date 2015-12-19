#include<bits/stdc++.h>
using namespace std;
const int maxt = 50 * 3 * 60 + 5;
typedef struct { 
	int n;
	int len;
}Node;
Node F[maxt];
Node best(Node& x, Node& y){
	if(x.n < y.n) return y;
	else if(x.n == y.n && x.len<=y.len) return y;
	else return x;
}
int main() {
	int T;
	scanf("%d", &T);
	int count = 0;
	while(T--) {
		int n, t0, t;
		scanf("%d%d", &n, &t0);
		memset(F, 0, sizeof(F)); 
		int max_t;
		max_t = min(maxt, t0);
		for(int i = 1; i <= n; i++) {
			scanf("%d", &t);
			for(int j = max_t-1; j>= 0; j--) {
				if(i==1){
					F[j].n = 0; 
					F[j].len = 0;
				}else {
					F[j] = F[j];
				}
				if(j >= t) {
					Node tmp;
					tmp.n = F[j-t].n + 1;
					tmp.len = F[j-t].len + t;
					F[j] = best(F[j], tmp);
				} 
			}
		}
		printf("Case %d: %d %d\n", ++count, F[t0-1].n+1, F[t0-1].len+678);
	} 
	return 0;
}
 
