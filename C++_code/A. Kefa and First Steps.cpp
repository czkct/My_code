#include<iostream>
#include<algorithm>
#include<cstring>
#include<cstdio>
using namespace std;
const int MAXN = 100000+5;
long long a[MAXN];
int b[MAXN];
int cmp(int i, int j) {
	return a[i] < a[j];
} 
int cmp2(int i , int j) {
	return a[i] < a[j];
}
int main() {
	int c;
	int n;
	int ln;
	while(cin >> c) {
		int i = 0;  //�����±� 
		int flag = 0;
		nl = 0; 
		memset(b, 0, sizeof(b));
		for(int j = 0; j < c; j++){
			scanf("%d", &n);
			if(flag&&(n>=ln)){//������ǵ�һ�� �Һ���Ĵ���ǰ���
				a[i] += n; 
				b[i]++;
			}
			else if(flag&&(n<ln)){//������ǵ�һ��  �к����С��ǰ���
				i++;
				a[i] = n; 
				b[i] = 1;
				flag = 1;
			}
			else if(!flag){// ����ǵ�һ��
				a[i] = n; 
				b[i] = 1;
				flag = 1; 
			}
			ln = n; 
		}
		sort(b, b+i+1, cmp);
		//=====================
//		
//		for(int l = 0; l <= i; l++){
//			cout << b[l] << " " ;
//		} 
//		cout << endl;
//		
		
		//===================== 
		
		sort(a, a+i+1, cmp2);
		long long temp = a[0];
		int cnt = 0;
		while(temp == a[cnt++]);
		int maxn = b[0];
		for(int k = 1; k < cnt; k++){
			if(b[k]>maxn) maxn = b[k];
		}
		cout << maxn << endl;
	}
	return 0;
} 
