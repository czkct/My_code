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
		int t = 0; //�������ǳ�ʼ���� t��ʾ��ǰ���� 
		while(M&&t<N) {//һ������ΪM  //ѭ����д�������ĺô���  ÿ��ѭ����Ȼ�����ĵ�һ�����䡱 
			if(M > F[e[t]]) {
				M -= F[e[t]];
				sum += J[e[t]];   
				t++; 
			}
			else{
				sum += best_v[e[t]]*M;
				break;
				/*  ֮ǰ����˼·���� 
					sum += best_v[e[t]];
					cnt++;
					M--;
					if(cnt >= F[e[t]]) {
						t++;
						cnt = 0;
					}
				*/
			}
			//�жϺ�t�ı߽�   ���t��N������ȫ��������һ��    ��ʹè������ʣ��
				//����Ҫ�������ѭ��
				//��һ���ж�
			 //���߲�Ҫ��һ��   Ȼ���while(M)����while(M&&N--)  �� while(M&&t<N) 
			//if(t >= N) break;   ����д��������ǻ�� ��ҲŪ����Ϊʲô 
		} 
		printf("%.3lf\n", sum);
	}
	return 0;
}
