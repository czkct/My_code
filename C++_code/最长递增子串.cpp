#include<iostream>
#include<cstdio>
#include<cstdlib>
#include<cstring>
using namespace std;
const int MAXN = 10000+5;
int d[MAXN];
char a[MAXN];
bool G[MAXN][MAXN]; 

int max(int a, int b){
	if(a > b) return a;
	else return b;
} 
int dp(int i){
	int& ans = d[i];
	if(ans > 0) return ans;
	ans = 1; 
	for(int j = i-1; j >= 0; j--)
	if(G[i][j]) ans = max(ans, dp(j)+1);
	return ans; 
}
void _G(int len){  //存图 
	for(int i = 0; i < len-1; i++)//从1开始   第0个的G[0]就应该是0 
	{
		for(int j = i; j>=0; j--){
			if(a[i]>a[j]) G[i][j] = 1;
		} 
	} 
}

void init(){
	memset(a, 0, sizeof(a));
	memset(G, 0, sizeof(G));
	memset(d, 0, sizeof(d));
}
int main(){
	int N;
	cin >> N;
	while(N--){
		init(); 
		scanf("%s", a);
		int len = strlen(a);
		_G(len); // 存好图
		int ans = 0;  // ans是答案
		for(int i = 0; i < len; i++){
			ans = max(ans, dp(i));
		} 
		printf("%d\n", ans);
	}
	return 0;
}
