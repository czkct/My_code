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
//[left, right]�Ǳպ�����
void BuildTree(int i, int left, int right) { //Ϊ����[left, right]����    ��iΪ����
	node[i].left = left;
	node[i].right = right;
	node[i].value = 0;
	if(left == right) {  //�����䳤��Ϊ0ʱ  �����ݹ�
		father[i] = left;
		return ;
	}
	//��������������
	BuildTree(i*2, left, (left+right)/2);
	//��������������
	BuildTree(i*2+1, (left+right)/2+1, right);
}  //������ϣ�
//��ѯ[ql, qr]�е���Сֵ
int ql, qr;
 
//���������������ϸ���
void UpdateTree(int ri) { //UpdataTree(ri)���Ǹ���ri�ĸ����
	if(ri == 1) return ;
	int fi = ri/2;  //�����
	int a = node[fi<<1].value;  //���ӽڵ��ֵ
	int b = node[(fi<<1)+1].value;  //���ӽڵ��ֵ
	node[fi].value = (a>b)?a:b;    // �����������㣨���������ӽ����������ģ�
	UpdataTree(ri/2); // �ݹ���£��ɸ����������
}
//���������������¸��£�Ҳ�ǵݹ����
void UpdateTree(int o, int L, int R){  //ȫ�ֱ���p�����޸ĵ��λ��   minv[]�洢������Сֵ 
	int M = (L+R)/2;
	if(L==R) minv[o] = value;  //Ҷ�ڵ㣬ֱ�Ӹ���
	else {//L<R
		if(p<=M) UpdateTree(o*2, L, M); 
		else UpdateTree(o*2+1, M+1, R);
		minv[o] = min(minv[o*2], minv[o*2+1]);
	} 
} 
int Max = INF;
void Query(int i, int l, int r) { //iΪ��������  ������[l,r]�ڲ�ѯ���ֵ 
	if(node[i].left == l && node[i].right == r) {
		Max = max(Max, node[i].value);
		return ;
	} 
	i <<= 1;
	if(l <= node[i].right){//���������漰 
		if(r <= node[i].right) //ȫ�����������䣬���ѯ������̬���� 
			Query(i, l, r);
		else //������������� 
			Query(i, l, node[i].right);
	}
	else 
	
}
