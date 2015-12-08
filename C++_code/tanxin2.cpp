#include<bits/stdc++.h>
using namespace std;
const int maxn = 1000+5;
double best_v[maxn];
int J[maxn], F[maxn];
int e[maxn];
bool cmp(int i, int j){
	return best_v[i] > best_v[j];
}
int main(){
	int M, N;
	while(scanf("%d%d", &M, &N)!=EOF && (M!=-1 || N!=-1))
	{
		for(int i = 0; i < N; i++) {
			scanf("%d%d", &J[i], &F[i]);
			best_v[i] = J[i]*1.0/F[i];
			e[i] = i;
		}
		sort(e, e+N, cmp);
		double sum = 0;
		int t = 0; 
		while(M) {
			if(M > F[e[t]]) {
				M -= F[e[t]];
				sum += J[e[t]];   
				t++; 
			}
			else{
				sum += best_v[e[t]]*M;
				break;
			}
			if(t > N-1) break;
		} 
		printf("%.3lf\n", sum);
	}
	return 0;
}
