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
	if(x.n < y.n) return y;  //��Ҫ��֤��������������� ���ٱ�֤��ʱ��� 
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
		memset(F, 0, sizeof(F));
		for(int i = 1; i <= n; i++) {
			cin >> t[i];//������Է�������   �ܹ�����дȡ����״̬���趨(״̬Ҫ��i��˳��ö��) 
			for(int j = 0; j <= t0-1; j++) {
				if(i==1){   //�߽�һ��Ҫ�ǵô��� 
					F[i][j].n = 0;
					F[i][j].len = 0;
				}else {
					F[i][j] = F[i-1][j];
				}
				if(j >= t[i]) {
					Node tmp;
					tmp.n = F[i-1][j-t[i]].n + 1;
					tmp.len = F[i-1][j-t[i]].len + t[i];
					F[i][j] = best(F[i][j], tmp);//������״̬�ıȽ�
				} 
//				tmp.len <= (t0-1)����������ж�ʵ�����ǲ���Ҫ�ģ�֮����ǰ��һ���������ϣ�
//				������Ϊ���Լ���������״̬�����Ǻ����
//				��ʱ״̬tmp ����֮ǰ.ǰi-1�׸�����j-t[i]��ʱ���ڴﵽ������״̬F[i-1][j-t[i]]�Ļ����� 
//				�ټ���i���׸�����ʱ��t[i]���ﵽ����״̬��Ҳ����˵tmp״̬����F[i][j]��һ�־���(���ӵ�i�׸���)����
//				F[i][j]����һ�־�����Ȼ����F[i-1][j](�������ӵ�i�׸���),������������һ��tmp������ʱ�伴
//				tmp.lenһֱ����j�� j�ı仯��Χ��1~(t0-1), ��Ȼ�Ͳ��ᳬ��t0-1���ֵ������ 
//				tmp.len <= (t0-1)����ж������Ƕ���ġ� 
//				cout << "F["<< i <<"]["<< j <<"] = " << F[i][j].len << endl; //��ӡ״̬ 
			}
		}
		cout << "Case " << ++count << ": " << F[n][t0-1].n+1 << " " << F[n][t0-1].len +678 << endl;
	} 
	return 0;
}
 
