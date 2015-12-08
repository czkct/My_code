#include<iostream>
#include<cstdio>
#include<cstring>
#include<cstdlib>
using namespace std;
const int MAXN = 100+5;
int d[MAXN][MAXN], a[MAXN][MAXN];
int max(int a, int b){
	if(a>b) return a;
	else return b;
}
int main(){
	int n;
	cin >> n; 
	for(int i = 1; i <= n; i++){
		for(int j = 1; j <= i; j++){
			scanf("%d", &a[i][j]); 
		}
	} 
	for(int i = 1; i <= n; i++) {
		d[n][i] = a[n][i];
	}
	for(int i = n-1; i>=1; i--){
		for(int j = 1; j <= i; j++){
			d[i][j] = max(d[i+1][j], d[i+1][j+1])+a[i][j]; 
		}
	}
	cout << d[1][1] << endl;
	return 0; 
}
