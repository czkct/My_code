#include<iostream>  //此题中并不会使各个大型集合(除了给出的一对一对的点)相互合并到一起 
#include<cstring>  // 所以每个集合都可以维护一个相应的  自身元素个数变量 setMAX 
#include<cstdio>
#include<algorithm>
using namespace std;
const int MAXN = 10000000+10; 
int setMAX[MAXN];  //初始化值都应该是 1
int pre[MAXN];  //初始化值都应该是自己 
void init(){
	for(int i = 1; i <= MAXN; i++) {
		pre[i] = i; 
		setMAX[i] = 1;
	}
} 
int unionsearch(int root) 
{
	int son = root;
	int temp;
	
	while(root!=pre[root]) root = pre[root];
	
	while(son != root) {
		temp = pre[son];
		pre[son] = root;
		son = temp;
	}
	return root; 
}

int root_max(int x, int y)
{
	int root1 = unionsearch(x);
	int root2 = unionsearch(y);
	if(root1 != root2) {
		pre[root1] = root2;   //总是在这里犯错误   千万不要写成pre[x]  = y   
		setMAX[root2] += setMAX[root1];   //这一句要根据上一句的顺序 
	}
}

int main(){ 
	int n; 
	int a, b; 
	while(cin >> n) { 
		if(!n) {
			printf("1\n");  //栽在这里了  当n为0时  一定要等于1 
			continue;
		}
		init();
		for(int i = 0; i < n; i++){ 
			scanf("%d%d", &a, &b); 
			root_max(a, b); 
		} 
		
		int MAX = 0;
		for(int i = 0; i <= MAXN; i++) 
		if(setMAX[i]>MAX) MAX = setMAX[i]; 
		cout << MAX << endl;
	}
	return 0;
}
