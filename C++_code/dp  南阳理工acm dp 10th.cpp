#include<cstdio>
#include<iostream>
#include<cstring>
#include<cstdlib>
using namespace std;

const int MAXN =  100+5;
int G[MAXN][MAXN][4];
int d[MAXN][MAXN];
int a[MAXN][MAXN];

int max(int a, int b){
	if(a>b) return a;
	else    return b;
} 

int dp(int i, int j, int r, int c){
	int& ans = d[i][j];
	if(ans>0) return ans;
	ans = 1; 
	if((i-1>=0)   && G[i][j][0])  ans = max(ans, dp(i-1, j, r, c)+1);  //���� 
	if((i+1<=r-1) && G[i][j][2])  ans = max(ans, dp(i+1, j, r, c)+1);  //���� 
	if((j-1>=0)   && G[i][j][3])  ans = max(ans, dp(i, j-1, r, c)+1);  //���� 
	if((j+1<=c-1) && G[i][j][1])  ans = max(ans, dp(i, j+1, r, c)+1); //���� 
	return ans;
}
int _G(int r, int c) {  //��ͼʱ��ÿ�������ݶ��Ѿ����ȴ洢���� 
	for(int i = 0; i < r; i++){
		for(int j = 0; j < c; j++){
			if((i-1>=0)   && a[i][j]>a[i-1][j]) G[i][j][0] = 1;  //���� 
			if((i+1<=r-1) && a[i][j]>a[i+1][j]) G[i][j][2] = 1;  //���� 
			if((j-1>=0)   && a[i][j]>a[i][j-1]) G[i][j][3] = 1;  //���� 
			if((j+1<=c-1) && a[i][j]>a[i][j+1]) G[i][j][1] = 1; //���� 
		}
	}
}
void init(){
	memset(G, 0, sizeof(G));
	memset(d, 0, sizeof(d));
	memset(a, 0, sizeof(a));
}
/*
void print_map(int r, int c){  //��ӡ��ͼ 
	for(int i = 0; i < r; i++){
		for(int j = 0; j < c; j++){
			printf("(%d,%d,%d,%d) ", G[i][j][0], G[i][j][1], G[i][j][2], G[i][j][3]);  //�����е�˳�������������ֱ��Ƿ�����ͨ 
		}
		printf("\n");
	}
} 
*/
int main(){
	int T;
	scanf("%d", &T);
	while(T--){
		int r, c;
		scanf("%d%d",&r, &c);
		init();
		for(int i = 0; i < r; i++){//�洢��
			for(int j = 0; j < c; j++) {
				scanf("%d", &a[i][j]);
			}
		}
		
		_G(r,c);//��ͼ 
		
		int ans = 0; 
		for(int i = 0; i < r; i++){
			for(int j = 0; j < c; j++) {
				ans = max(ans, dp(i, j, r, c));
			}
		}
		
		printf("%d\n", ans);
	//	print_map(r, c); 
	}
	return 0;
}
