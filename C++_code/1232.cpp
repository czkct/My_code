#include<iostream>
#include<cstdio>
#include<cstring>
using namespace std;
const int MAXN = 1000+5;
int pre[MAXN];

//�Ҹ����
int unionsearch(int root)
{
	int temp;
	int son = root;
	while(root != pre[root]) 
		root = pre[root];
	//·��ѹ��
	while(son != root){
		temp = pre[son];
		pre[son] = root;
		son = temp;
	} 
	return root;
}


int main(){
	int N, M;
	int total; 
	while(scanf("%d%d", &N, &M)!=EOF&&N){
		memset(pre, 0, sizeof(pre));
		int total = N-1;   //ע������Ҫ·����������Ӧ��ΪN-1�� 
		int a, b;
		for(int i = 1; i <= N; i++) {
			pre[i] = i;
		}
		for(int i = 0; i < M; i++) {
			scanf("%d%d", &a, &b);
			int x = unionsearch(a);
			int y = unionsearch(b);
			if(x != y) 
			{
				pre[x] = y;
				total--;
			}
		}
		printf("%d\n", total);
	}
	return 0;
}
