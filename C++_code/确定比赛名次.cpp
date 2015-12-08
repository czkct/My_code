//拓扑排序(dfs)
#include<bits/stdc++.h>
using namespace std;
//n 个数字1-n  m个数字间的关系

const int maxn = 100+5;

int n, m;
int c[maxn];
int topo[maxn];
int G[maxn][maxn];
int t; 
bool dfs(int u)
{
	c[u] = -1; 
	for(int v = 1; v <= n; v++) 
		if(G[u][v]) {
			if(c[v]<0) return false;
			else if(!c[v] && !dfs(v)) return false;
		}
	c[u] = 1; 
	topo[--t] = u;
	
	return true;
}

bool toposort()
{
	t = n; 
	memset(c, 0, sizeof(c));
	for(int u = n; u >=1; u--) 
		if(!c[u])
			if(!dfs(u))
				return false; 
	return true;  
}





void print_G(){  //测试 
	for(int i = 0; i < n; i++){
		for(int j = 0; j < n; j++) {
			cout << G[i][j] << " ";
		}
		cout << G[i][n] << endl;
	}
}

void print_topo()
{
	int i;
	for(i = 0; i < n-1; i++) {
		cout << topo[i] << " " ;
	} 
	cout << topo[n-1] << endl;
}

int main(){
	while((cin>>n>>m)&&(n||m)) {
		int p1, p2;
		memset(G,0,sizeof(G)); 
		for(int i = 0; i < m; i++) {
			cin >> p1 >> p2;
			G[p1][p2] = 1; 
		}
		int flag = toposort();
		if(flag) {
			print_topo();
		}
	}
	return 0;
}
