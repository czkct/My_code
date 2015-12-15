//算法训练 最大的算式  动态规划 资源分配类型（最大乘积）
//不能改变他们的相对位置
#include<bits/stdc++.h>
using namespace std;

const int maxn = 15+5;
int s[maxn];

int getsum(int* name, int start, int end){
	int sum = 0;
	for(int i = start; i <= end; i++) {
		sum += name[i];
	}
	return sum;
}
int mulmax(int* name, int start, int len, int mulcount){
	if(mulcount==0) 
		return getsum(name, start, start+len-1);
	int ans = 0;
	for(int loc = start; loc < start+len-1; loc++) {
		ans = max(ans, getsum(name, start,loc)*mulmax(name,loc+1, start+len-loc-1, mulcount-1));
	}
	return ans;
}
int main() {
	int n, k;
	cin >> n >> k;
	for(int i = 0; i < n; i++){
		cin >> s[i];
	}
	int ans = mulmax(s, 0, n, k);
	cout << ans << endl;
	return 0;
} 
