#include<iostream>
#include<cstring>
#include<cstdio>
using namespace std;



//ʹ���ڵ��ֵ���ڸ��ڵ�ĸ��׽ڵ��ֵ�������Ϳ��Ժ����ɵ��жϳ��Ƿ��Ǹ��ڵ�
int unionsearch(int root)
{
	int son, tmp; 
	son = root;  //�ȼ��������Ľڵ���һ���ӽڵ�
	while(root!=pre[root])  //���ѭ����Ŀ�����ҵ�����ڵ�ĸ��ڵ� 
		root = pre[root];  //��root��pre[root]��ȵ�ʱ�� ˵���ҵ��˸��ڵ� 
	while(son != root) //·��ѹ��  //ʹ��ÿ���ӽڵ�ĸ���㶼���ͬһ�����ڵ� 
	{
		tmp = pre[son];
		pre[son] = root;
		son = temp;	
	} 
	return root; 
}

void join(int root1, int root2) //�ж��������Ƿ���ͨ(������ĸ��ڵ��Ƿ���ͬһ��)������ͨ�ͺϲ� 
{
	int x, y;
	x = unionsearch(root1);
	y = unionsearch(root2);
	if(x != y) //�������ͨ���Ͱ��������ڵ���ͨ��֧�ϲ�
		pre[x] = y; 
}
  
