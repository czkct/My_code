#include<stdio.h>
#include<stdlib.h>
const int MAXN = 100000+5; 
int max(int a, int b){
	return a>b;
}
int maxsum(int* A, int x, int y){
	if(y-x==1) return A[x];
	int m = x+(y-x)/2;
	int maxs = max(maxsum(A, x, m), maxsum(A, m, y));
	int v, L, R;
	v = 0; L = A[m-1];
	for(int i = m-1; i >= x; i--) L = max(L, v+=A[i]);
	v = 0; R = A[m];
	for(int i = m; i < y; i++) R = max(R, v+=A[i]);
	return max(maxs, L+R);
}
int main() {
	int n; 
	while(n--) {
		int m;
		scanf("%d", &m);
		for(int i = 0; i < m; i++){
			scanf("%d", &a[i]);
		}
		printf("Case %d:\n", ++count);
		maxsum(a, 0, m);
	}
}
