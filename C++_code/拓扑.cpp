

// c ������״̬  -1  ���ڷ���   0����û�з��ʹ�   1 �Ѿ����ʹ� 

int c[maxn];
int topo[maxn], t;
bool dfs(int u) //u �ǵ�ǰ�ڵ�
{ 
	c[u] = -1;
	for(int v = 0; v < n; v++) // u�ڵ�ָ���n���ڵ�v
	{
		if(c[v] < 0�� return false;  // ������ڷ��ʣ�˵���л� 
		else if(!c[v] && !dfs(v))  //  �������㻹û�з��ʹ����Ҹõ�֮���л�������ʧ�ܣ� 
			return false; 
	}
	c[u] = 1;
	topo[--t] = u;
	return true;	 
}
//����ͼ    ����û�����⡢
  
bool toposort(){
	t = n; 
	memset(c, 0, sizeof(c));
	for(int  u = 0;  u < n ; u++) 
		if(!c[u]) 
			if(!dfs(u)) 
				return false;
	return true;
}
