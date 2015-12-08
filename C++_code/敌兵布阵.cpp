#include<cstdio>
#include<iostream>
#include<cstring>
using namespace std;
const int TreeNode =  1<<17; 
struct Node
{
	int sum; //Ҷ�ӽڵ�����ֵͬʱҲ���������ֵ
	int left, right;
} node[TreeNode];
//���� ,  ��������и��µ���left��right
void build(int i, int left, int right) //�������µݹ齨��
{
	if(left == right)//�߽�
	{
		scanf("%d", &node[i].sum);//�߽��Ҷ�ӽڵ����ݴ���   
		//��һ��ʵ����666   �ݹ��������������   ��һ�μ� 
		return ;
	}
	node[i].left = left;
	node[i].right = right;
	node[i].sum = 0;
	
	int M = (left+right)>>1;
	build(i*2, left, M);//����������
	build(i*2+1, M+1, right);//����������
	node[i].sum = node[i<<1].sum+node[i<<1|1].sum;
}
//������ //Add  int pλ��  int add�޸ĵ�ֵ  �޸ĵ�p
void update(int i, int left, int right, int p, int add)   //�ݹ�
{
	if(left == right)//�߽�
	{
		node[i].sum += add;   
		return ;
	}
	int M = (left+right)>>1;
	if(p <= M) update(i*2, left, M, p, add);//����������
	else update(i*2+1, M+1, right, p, add); //����������
	node[i].sum = node[i<<1].sum+node[i<<1|1].sum;
}

int query(int i, int ll, int rr, int l, int r) //��ѯ�߶��� 
{
	if(ll<=l && rr >=r) return node[i].sum; //��С����p200 
	int m = (l+r)>>1;
	int ans = 0; 
	//�����߶��ڵ�ǰ�߶���λ��������� 
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
			if(ch[0] == 'E') break;    //ѧ���� 
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
