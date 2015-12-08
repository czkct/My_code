

// c 的三个状态  -1  正在访问   0从来没有访问过   1 已经访问过 

int c[maxn];
int topo[maxn], t;
bool dfs(int u) //u 是当前节点
{ 
	c[u] = -1;
	for(int v = 0; v < n; v++) // u节点指向的n个节点v
	{
		if(c[v] < 0） return false;  // 如果正在访问，说明有环 
		else if(!c[v] && !dfs(v))  //  如果这个点还没有访问过并且该点之后有环（深搜失败） 
			return false; 
	}
	c[u] = 1;
	topo[--t] = u;
	return true;	 
}
//建好图    基本没有问题、
  
bool toposort(){
	t = n; 
	memset(c, 0, sizeof(c));
	for(int  u = 0;  u < n ; u++) 
		if(!c[u]) 
			if(!dfs(u)) 
				return false;
	return true;
}
