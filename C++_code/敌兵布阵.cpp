#include<cstdio>
#include<iostream>
#include<cstring>
using namespace std;
const int TreeNode =  1<<17; 
struct Node
{
	int sum; //叶子节点的最大值同时也就是自身的值
	int left, right;
} node[TreeNode];
//建树 ,  这个过程中更新的是left和right
void build(int i, int left, int right) //由上向下递归建树
{
	if(left == right)//边界
	{
		scanf("%d", &node[i].sum);//边界的叶子节点数据处理   
		//这一句实在是666   递归过程中输入数据   第一次见 
		return ;
	}
	node[i].left = left;
	node[i].right = right;
	node[i].sum = 0;
	
	int M = (left+right)>>1;
	build(i*2, left, M);//左子树建立
	build(i*2+1, M+1, right);//右子树建立
	node[i].sum = node[i<<1].sum+node[i<<1|1].sum;
}
//更新树 //Add  int p位置  int add修改的值  修改点p
void update(int i, int left, int right, int p, int add)   //递归
{
	if(left == right)//边界
	{
		node[i].sum += add;   
		return ;
	}
	int M = (left+right)>>1;
	if(p <= M) update(i*2, left, M, p, add);//更新左子树
	else update(i*2+1, M+1, right, p, add); //更新右子树
	node[i].sum = node[i<<1].sum+node[i<<1|1].sum;
}

int query(int i, int ll, int rr, int l, int r) //查询线段树 
{
	if(ll<=l && rr >=r) return node[i].sum; //见小白书p200 
	int m = (l+r)>>1;
	int ans = 0; 
	//待查线段在当前线段中位置情况如下 
	if(ll<=m) ans+=query(i<<1, ll, rr, l, m);
	if(rr>m) ans+=query(i<<1|1, ll, rr, m+1, r);
	return ans; 
}
int main(){
	int T;
	int count = 0;
	cin >> T;
	char ch[10];
	while(T--)
	{
		int n; 
		cin >> n;
		build(1, 1, n);
		int a, b;
		printf("Case %d:\n",++count);
		while(scanf("%s", ch)!=EOF){
			if(ch[0] == 'E') break;    //学到了 
			scanf("%d%d", &a, &b);
			
			if(ch[0] == 'Q') {
				int temp = query(1, a, b, 1, n);
				printf("%d\n", temp);
			}
			else if(ch[0] == 'A') update(1, 1, n, a, b);
			else if(ch[0] == 'S') update(1, 1, n, a, b*-1);
		} 
		
	}
	return 0; 
}
