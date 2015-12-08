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
			++Map[C[0]-'a'][C[len-1]-'a'];//��β��ĸ��ͬ�ĵ������� 
			++out[C[0]-'a'];//����ĸ�ĳ��� 
			++in[C[len-1]-'a']; //β��ĸ����� 
		}
		int a = 0, b = 0;
		bool flag = true;
		for(int i = 0; i < 26; i++) 
		{
			if(in[i] != out[i]) //��Ȳ����ڳ��� 
			{
				if(in[i] == out[i]+1) a++;//��ȴ�ĵ㣨�����յ㣩���� 
				else if(in[i]+1 == out[i]) b++; //���ȴ�ĵ㣨������㣩����
				else{
					flag = false; break; //��Ⱥͳ�������1  ������ͼ�϶����� 
				}
			}
		}
		if(a&&b&&a+b>2) flag = false;  //����������   ������ͼ���� 
		if(flag) //������flag��ȻΪ�棬��˵�������˶������ʣ�������ֻҪ���Ƿ���ͨ������ 
		{
			memset(vis, false, sizeof(vis));
			if(2 == a+b) {//��ʱ��Ӧ�ôӳ��ȴ�����ȵ������� �����ɶԳ��֣� 
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
			for(int j = 0; j < 26; j++) //�����Ѿ����ֵĵ��л���û�з��ʹ���
			{//��˵������ͨ 
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
