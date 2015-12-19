#include<bits/stdc++.h>
using namespace std;
//״̬F[i][j]:ǰi�׸������ﵽ������״̬
//�������״̬��������С������״̬
//1.�������� �� 2.�����ʱ�� 
//״̬ת�Ʒ��̣�F[i][j] = ����(F[i-1][j], F[i-1][j-t[i]] + t[i]); 
const int maxn = 50 + 5;
const int maxt = 50 * 3 * 60;
int t[maxn];//ÿ�׸���ʱ��
typedef struct {//״̬�ڵ㶨�� 
	int n;//1.�������� 
	int len;//2.�����ʱ�� 
}Node;
Node F[maxn][maxt]; //״̬�ڵ� 
Node best(Node& x, Node& y){
	if(x.n < y.n) return y;
	else if(x.n == y.n && x.len<=y.len) return y;
	else return x;
}
int main() {
	int T;
	cin >> T;
	int count = 0;
	while(T--) {
		int n, t0;
		cin >> n >> t0;
		//F����ĳ�ʼ��;
		memset(F, 0, sizeof(F)); 
		for(int i = 0; i <= n; i++) {
			cin >> t[i];
		}
		for(int i = 1; i <= n; i++) {
			for(int j = 1; j <= t0-1; j++) {
				if(i==1){
					F[i][j].n = 0;
					F[i][j].len = 0;
				}else {
					F[i][j] = F[i-1][j];
				}
				Node tmp;
				if(j >= t[i]) {
					tmp.n = F[i-1][j-t[i]].n + 1;
					tmp.len = F[i-1][j-t[i]].len + t[i];
				}
				if(j >= t[i] && tmp.len <= (t0-1)) F[i][j] = best(F[i][j], tmp);//������״̬�ıȽ� 
				//cout << "F["<< i <<"]["<< j <<"] = " << F[i][j].len << endl; //��ӡ״̬ 
			}
		}
		cout << "Case " << ++count << ": " << F[n][t0-1].n+1 << " " << F[n][t0-1].len +678 << endl;
	} 
	return 0;
}
 
