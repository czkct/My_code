#include<iostream>
#include<cstring>
#include<cstdio>
using namespace std;
const int MAXN  = 1000+5;
int pre[MAXN];

int unionsearch(int root)
{
	int temp;
	int son = root;
	while(root!=pre[root])
		root = pre[root];
	//压缩路径
	while(son != root) {
		temp = pre[son];
		pre[son] = root;
		son = temp;
	} 
	return root;
}

int main() {
	int T;
	cin >> T;
	while(T--){
		int a, b;
		scanf("%d%d", &a, &b);
		int total = a;  //  这里total不再是路  而是桌子！！！   这里可以模拟一下假设相互之间都不认识 
		memset(pre, 0, sizeof(pre));
		for(int i = 1; i <= a; i++) pre[i] = i;
		int x, y;
		for(int i = 0; i < b; i++) {
			scanf("%d%d", &x, &y);
			int root1 = unionsearch(x);
			int root2 = unionsearch(y);
			if(root1 != root2) { //这里千万不能写错   不能误写为pre[x] = y;  可以手动模拟一下 
				pre[root1] = root2;
				a--;
			}
		}
		printf("%d", a);
			//if(T) 
		printf("\n");  //此处格式比较无语 
	}
	return 0;
} 
