#include<iostream>
#include<cstring>
#include<cstdio>
using namespace std;
const int MAXN  = 1000+5;
int pre[MAXN];

int unionsearch(int root)
{
	int temp;
	int son = root;
	while(root!=pre[root])
		root = pre[root];
	//ѹ��·��
	while(son != root) {
		temp = pre[son];
		pre[son] = root;
		son = temp;
	} 
	return root;
}

int main() {
	int T;
	cin >> T;
	while(T--){
		int a, b;
		scanf("%d%d", &a, &b);
		int total = a;  //  ����total������·  �������ӣ�����   �������ģ��һ�¼����໥֮�䶼����ʶ 
		memset(pre, 0, sizeof(pre));
		for(int i = 1; i <= a; i++) pre[i] = i;
		int x, y;
		for(int i = 0; i < b; i++) {
			scanf("%d%d", &x, &y);
			int root1 = unionsearch(x);
			int root2 = unionsearch(y);
			if(root1 != root2) { //����ǧ����д��   ������дΪpre[x] = y;  �����ֶ�ģ��һ�� 
				pre[root1] = root2;
				a--;
			}
		}
		printf("%d", a);
			//if(T) 
		printf("\n");  //�˴���ʽ�Ƚ����� 
	}
	return 0;
} 
