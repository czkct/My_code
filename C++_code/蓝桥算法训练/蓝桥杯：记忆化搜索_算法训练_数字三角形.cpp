//���ű������仯������  �㷨ѵ�� ����������   ���ģ��Ƕ�̬�滮���ţ� 

#include<bits/stdc++.h>
using namespace std;
const int maxn = 100+5;
int a[maxn][maxn];
int d[maxn][maxn];
int n; 
//dp(i, j) ��ʾ�ӵ�ǰ��������׶˵����ֵ 
int dp(int i, int j){
	int& ans = d[i][j]; 
	if(ans >= 0) return ans;
	return ans = a[i][j] + (i==n ? 0 : max(dp(i+1, j), dp(i+1, j+1)));
}
void init() {
	memset(d, -1, sizeof(d));  //��ʼ��d����
}
int main() {
	while(scanf("%d", &n)!=EOF){
		for(int i = 1; i <= n; i++) {
			for(int j = 1; j <= i; j++){
				scanf("%d", &a[i][j]);
			}		
		}//��ͼ
		init(); //������   �����ʼ�� 
		cout << dp(1, 1) << endl;
	}
	return 0;
}
