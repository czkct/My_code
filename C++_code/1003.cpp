#include<iostream>
#include<cstring>
#include<cstdio>
using namespace std;
const int _MIN = -(1<<30);
const int MAXN = 100000+5;

int a[MAXN];
int _biao[MAXN];
int d[MAXN];

int dp(int i, int flag){
	int& ans = d[i];
	if(ans > 0) return ans;
	ans = a[i]; 
	if(i==0) _biao[0] = 0;
	int m;
	 
	if((i-1)>=0) _biao[flag] = _biao[i-1];//假设 (dp(i-1, flag)+a[i])>ans 儿子的最优起点传给父亲 
	
	if((i-1)>=0 && (m=(dp(i-1, flag)+a[i]))>=ans){ //(dp(i-1, flag)+a[i]))与ans的关系注意是大于或者等于 
		ans = m;
	}
	else {
		_biao[flag] = i;//假设 (dp(i-1, flag)+a[i])<ans 
	}
	return ans;
}
int main(){
	int n, Case = 0;
	cin >> n; 
	while(n--){
		int len, _maxbiao, _minbiao;
		cin >> len;
		for(int i = 0; i < len; i++) {
			scanf("%d",&a[i]);
		}
		memset(d, 0, sizeof(d));
		memset(_biao, 0, sizeof(_biao));
		cout << "Case " << ++Case << ":" << endl;
		int _max = _MIN;
		int d;
		for(int i = 0; i < len; i++) {
			if((d = dp(i,i))>_max){
				_max = d;
				_maxbiao = i;
				_minbiao = _biao[i];
			}
		}
		cout << _max << " " << _minbiao+1 << " " << _maxbiao+1 << endl;
		if(n) cout << endl;//之前没有这一句  一直PE！！！OJ对格式的要求真心是严格！！严格！！ 
	}
	return 0;
}
