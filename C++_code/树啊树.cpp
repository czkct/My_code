#include<bits/stdc++.h>
using namespace std;
int n; 
const int MAXV = 10000+10;//MAXV  ���ֵ 
int in_order[MAXV], post_order[MAXV], lch[MAXV], rch[MAXV];
//�������� 
int build(int L1, int R1, int L2, int R2) {
	//��L1==R1��ʱ��˵����Ҷ�ӽڵ�  ��L1>R1��Ϊ�� 
	if(L1 > R1) return 0;  //����Ϊ��   �жϺ����������
	//��ӵ�Ҳ��˵������Ҳ������ 
	int root = post_order[R2];
	int p = L1;
	while(in_order[p] != root) p++;
	int cnt = p-L1; 
	lch[root] = build(L1, p-1, L2, L2+cnt-1);
	rch[root] = build(p+1, R1, L2+cnt, R2-1);
	return root;	
}
int best, best_sum;
void dfs(int u, int sum) {//��root�ڵ���� 
	sum += u;
	if(!lch[u]&&!rch[u]){
		//�ҵ���Ҷ�ӽڵ���
		if(sum < best_sum ||(sum == best_sum && u < best)){
			best = u; best_sum = sum;
		} 
	}
	if(lch[u]) dfs(lch[u], sum); //������ 
	if(rch[u]) dfs(rch[u], sum); //������ 
} 

bool read_list(int* a){  //���봦���� 
	string line;  //�������ͦ�õģ� 
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
