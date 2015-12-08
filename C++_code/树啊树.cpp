#include<bits/stdc++.h>
using namespace std;
int n; 
const int MAXV = 10000+10;//MAXV  最大值 
int in_order[MAXV], post_order[MAXV], lch[MAXV], rch[MAXV];
//建树函数 
int build(int L1, int R1, int L2, int R2) {
	//当L1==R1的时候说明是叶子节点  当L1>R1才为空 
	if(L1 > R1) return 0;  //子树为空   判断好了中序结束
	//间接地也就说明后序也结束了 
	int root = post_order[R2];
	int p = L1;
	while(in_order[p] != root) p++;
	int cnt = p-L1; 
	lch[root] = build(L1, p-1, L2, L2+cnt-1);
	rch[root] = build(p+1, R1, L2+cnt, R2-1);
	return root;	
}
int best, best_sum;
void dfs(int u, int sum) {//从root节点出发 
	sum += u;
	if(!lch[u]&&!rch[u]){
		//找到了叶子节点了
		if(sum < best_sum ||(sum == best_sum && u < best)){
			best = u; best_sum = sum;
		} 
	}
	if(lch[u]) dfs(lch[u], sum); //左子树 
	if(rch[u]) dfs(rch[u], sum); //右子树 
} 

bool read_list(int* a){  //输入处理函数 
	string line;  //这个函数挺好的！ 
	if(!getline(cin, line)) return false;
	stringstream ss(line);
	n = 0;
	int x;
	while(ss>>x) a[n++] = x; 
	return n > 0;
}


int main(){
	while(read_list(in_order)){
		read_list(post_order);
		build(0, n-1, 0, n-1);
		best_sum = 1<<30;
		dfs(post_order[n-1], 0);
		cout << best << endl; 
	}
	return 0;
}
