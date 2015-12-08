#include<iostream>  //�����в�����ʹ�������ͼ���(���˸�����һ��һ�Եĵ�)�໥�ϲ���һ�� 
#include<cstring>  // ����ÿ�����϶�����ά��һ����Ӧ��  ����Ԫ�ظ������� setMAX 
#include<cstdio>
#include<algorithm>
using namespace std;
const int MAXN = 10000000+10; 
int setMAX[MAXN];  //��ʼ��ֵ��Ӧ���� 1
int pre[MAXN];  //��ʼ��ֵ��Ӧ�����Լ� 
void init(){
	for(int i = 1; i <= MAXN; i++) {
		pre[i] = i; 
		setMAX[i] = 1;
	}
} 
int unionsearch(int root) 
{
	int son = root;
	int temp;
	
	while(root!=pre[root]) root = pre[root];
	
	while(son != root) {
		temp = pre[son];
		pre[son] = root;
		son = temp;
	}
	return root; 
}

int root_max(int x, int y)
{
	int root1 = unionsearch(x);
	int root2 = unionsearch(y);
	if(root1 != root2) {
		pre[root1] = root2;   //���������ﷸ����   ǧ��Ҫд��pre[x]  = y   
		setMAX[root2] += setMAX[root1];   //��һ��Ҫ������һ���˳�� 
	}
}

int main(){ 
	int n; 
	int a, b; 
	while(cin >> n) { 
		if(!n) {
			printf("1\n");  //����������  ��nΪ0ʱ  һ��Ҫ����1 
			continue;
		}
		init();
		for(int i = 0; i < n; i++){ 
			scanf("%d%d", &a, &b); 
			root_max(a, b); 
		} 
		
		int MAX = 0;
		for(int i = 0; i <= MAXN; i++) 
		if(setMAX[i]>MAX) MAX = setMAX[i]; 
		cout << MAX << endl;
	}
	return 0;
}
