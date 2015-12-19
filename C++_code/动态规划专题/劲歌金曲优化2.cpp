#include<bits/stdc++.h>
using namespace std;
//״̬F[i][j]:ǰi�׸������ﵽ������״̬
//�������״̬��������С������״̬
//1.�������� �� 2.�����ʱ�� 
//״̬ת�Ʒ��̣�F[i][j] = ����(F[i-1][j], F[i-1][j-t] + t[i]); 
const int maxn = 50 + 5;
const int maxt = 50 * 3 * 60 + 5;
//˳�����  �߶��߼���ʹ�ÿ��Բ�Ҫt[maxn]�������,���Կ���ֱ����t���浱ǰ��i�׸�����ʱ�� 
typedef struct {//״̬�ڵ㶨�� 
	int n;//1.�������� 
	int len;//2.�����ʱ�� 
}Node;
Node F[maxn][maxt]; //״̬�ڵ� 
Node best(Node& x, Node& y){
	if(x.n < y.n) return y;  //��Ҫ��֤��������������� ���ٱ�֤��ʱ��� 
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
		memset(F, 0, sizeof(F)); 
		for(int i = 1; i <= n; i++) {
			cin >> t;//������Է�������   �ܹ�����дȡ����״̬���趨(״̬Ҫ��ʹ��i��˳��ö��) 
			for(int j = 0; j <= t0-1; j++) {
				if(i==1){   //�߽�һ��Ҫ�ǵô��� 
					F[i][j].n = 0; 
					F[i][j].len = 0;
				}else {
					F[i][j] = F[i-1][j];
					//�������,��ʹ��ǰ״̬(F[i][j])������ͬʱ��j�²����ϵ�ǰ���׸�(i)������״̬F[i-1][j] 
				}
				if(j >= t) {
					Node tmp;
					tmp.n = F[i-1][j-t].n + 1;
					tmp.len = F[i-1][j-t].len + t;
					F[i][j] = best(F[i][j], tmp);//������״̬�ıȽ�
				}  
			}
		}
		cout << "Case " << ++count << ": " << F[n][t0-1].n+1 << " " << F[n][t0-1].len +678 << endl;
	} 
	return 0;
}
 
