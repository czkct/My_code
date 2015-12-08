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
		int t = 0; //这里忘记初始化了 t表示当前房间 
		while(M&&t<N) {//一共质量为M  //循环体写成这样的好处是  每次循环必然“消耗掉一个房间” 
			if(M > F[e[t]]) {
				M -= F[e[t]];
				sum += J[e[t]];   
				t++; 
			}
			else{
				sum += best_v[e[t]]*M;
				break;
				/*  之前这里思路混乱 
					sum += best_v[e[t]];
					cnt++;
					M--;
					if(cnt >= F[e[t]]) {
						t++;
						cnt = 0;
					}
				*/
			}
			//判断好t的边界   如果t把N个房间全部都走了一遍    即使猫粮还有剩余
				//还是要跳出这个循环
				//加一个判断
			 //或者不要这一句   然后把while(M)换成while(M&&N--)  或 while(M&&t<N) 
			//if(t >= N) break;   但是写在这里就是会错 我也弄不懂为什么 
		} 
		printf("%.3lf\n", sum);
	}
	return 0;
}
