#include<bits/stdc++.h>
using namespace std;

int Map[26][26];
int in[26], out[26];
bool vis[26];
int T, N;

void dfs(int k)
{
	vis[k] = true;
	for(int i = 0; i < 26; i++)
	{
		if(Map[k][i] && !vis[i]) dfs(i);
	}

}


int main()
{
	cin >> T;
	while(T--) 
	{
		cin >> N;
		char C[1100];
		memset(in, 0, sizeof(in));
		memset(out, 0, sizeof(out));
		memset(Map, 0, sizeof(Map));
		for(int i = 0; i< N; i++) 
		{
			cin >> C;
			int len = strlen(C);
			++Map[C[0]-'a'][C[len-1]-'a'];//首尾字母相同的单词总数 
			++out[C[0]-'a'];//首字母的出度 
			++in[C[len-1]-'a']; //尾字母的入度 
		}
		int a = 0, b = 0;
		bool flag = true;
		for(int i = 0; i < 26; i++) 
		{
			if(in[i] != out[i]) //入度不等于出度 
			{
				if(in[i] == out[i]+1) a++;//入度大的点（可能终点）个数 
				else if(in[i]+1 == out[i]) b++; //出度大的点（可能起点）个数
				else{
					flag = false; break; //入度和出度相差超过1  这样的图肯定不行 
				}
			}
		}
		if(a&&b&&a+b>2) flag = false;  //奇点多余两个   这样的图不行 
		if(flag) //到这里flag仍然为真，则说明满足了度数性质，接下来只要看是否连通就行了 
		{
			memset(vis, false, sizeof(vis));
			if(2 == a+b) {//这时就应该从出度大于入度的奇点出发 （奇点成对出现） 
				for(int i = 0; i < 26; i++) {
					if(out[i] && 1==(out[i]-in[i])) {
						dfs(i); break; 
					}
				}		
			}
			else  // 
				for(int i = 0; i < 26; i++)
				{
					if(out[i])  {
						dfs(i); break;
					} 
				} 
			bool flag1 = true;
			for(int j = 0; j < 26; j++) //凡是已经出现的点中还有没有访问过的
			{//就说明不连通 
				if(out[j]&&!vis[j]) {
					flag1 = false; break;
				}
				if(in[j]&&!vis[j]) {
					flag1 = false; break;
				}
			}
			if(flag1) cout << "Ordering is possible."<< endl;
			else cout << "The door cannot be opened." << endl;
		}
		else cout << "The door cannot be opened." <<endl;
	}
	return 0; 
}
