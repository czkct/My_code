#include<iostream>
#include<cstring>
#include<cstdio>
using namespace std;



//使根节点的值等于根节点的父亲节点的值，这样就可以很轻松的判断出是否是根节点
int unionsearch(int root)
{
	int son, tmp; 
	son = root;  //先假设出传入的节点是一个子节点
	while(root!=pre[root])  //这个循环的目的是找到这个节点的根节点 
		root = pre[root];  //当root与pre[root]相等的时候 说明找到了根节点 
	while(son != root) //路径压缩  //使得每个子节点的父结点都变成同一个根节点 
	{
		tmp = pre[son];
		pre[son] = root;
		son = temp;	
	} 
	return root; 
}

void join(int root1, int root2) //判断两个点是否连通(即两点的根节点是否是同一个)，不连通就合并 
{
	int x, y;
	x = unionsearch(root1);
	y = unionsearch(root2);
	if(x != y) //如果不连通，就把它们所在的连通分支合并
		pre[x] = y; 
}
  
