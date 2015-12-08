#include<iostream>
#include<cstdio>
#include<cstring>
using namespace std;
const int MAXN = 1000+5;
int pre[MAXN];

//找父结点
int unionsearch(int root)
{
	int temp;
	int son = root;
	while(root != pre[root]) 
		root = pre[root];
	//路径压缩
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
		int total = N-1;   //注意所需要路的最少条数应该为N-1条 
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
