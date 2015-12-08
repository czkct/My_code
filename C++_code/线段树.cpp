#include<iostream>
#include<cstdio>
using namespace std;
const int MAXN = 1000000;
const int INF = -(1<<30);

struct Node {
	int value;
	int left, right;
} node[MAXN];
int father[MAXN];
//[left, right]是闭合区间
void BuildTree(int i, int left, int right) { //为区间[left, right]建树    以i为祖先
	node[i].left = left;
	node[i].right = right;
	node[i].value = 0;
	if(left == right) {  //当区间长度为0时  结束递归
		father[i] = left;
		return ;
	}
	//继续建立左子树
	BuildTree(i*2, left, (left+right)/2);
	//继续建立右子树
	BuildTree(i*2+1, (left+right)/2+1, right);
}  //建树完毕！
//查询[ql, qr]中的最小值
int ql, qr;
 
//更新树，从下往上更新
void UpdateTree(int ri) { //UpdataTree(ri)就是更新ri的父结点
	if(ri == 1) return ;
	int fi = ri/2;  //父结点
	int a = node[fi<<1].value;  //左子节点的值
	int b = node[(fi<<1)+1].value;  //右子节点的值
	node[fi].value = (a>b)?a:b;    // 更新这个父结点（从两个孩子结点中挑个大的）
	UpdataTree(ri/2); // 递归更新，由父结点往上找
}
//更新树，从上往下更新，也是递归更新
void UpdateTree(int o, int L, int R){  //全局变量p代表修改点的位置   minv[]存储区间最小值 
	int M = (L+R)/2;
	if(L==R) minv[o] = value;  //叶节点，直接更新
	else {//L<R
		if(p<=M) UpdateTree(o*2, L, M); 
		else UpdateTree(o*2+1, M+1, R);
		minv[o] = min(minv[o*2], minv[o*2+1]);
	} 
} 
int Max = INF;
void Query(int i, int l, int r) { //i为区间的序号  从区间[l,r]内查询最大值 
	if(node[i].left == l && node[i].right == r) {
		Max = max(Max, node[i].value);
		return ;
	} 
	i <<= 1;
	if(l <= node[i].right){//左区间有涉及 
		if(r <= node[i].right) //全包含于左区间，则查询区间形态不变 
			Query(i, l, r);
		else //半包含于左区间 
			Query(i, l, node[i].right);
	}
	else 
	
}
