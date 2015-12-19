#include <iostream>
#include <cstdio>
#include <algorithm>
#include <cstring>
using namespace std;

const int maxm = 16;
const int maxn = 11;

int dp[maxn][maxm], result[maxn][maxm], n, m, profit[maxn][maxm];
void output(int x, int y);

int main()
{
		while(scanf("%d %d", &n, &m) != EOF)
	{
		memset(dp, 0, sizeof(dp));
		memset(profit, 0, sizeof(profit));
		memset(result, 0, sizeof(result));
		for(int i = 1; i <= n; i++)
		{
			for(int j = 1; j <= m; j++)
				scanf("%d", &profit[i][j]);
		}
		for(int i = 1; i <= n; i++)
		{
			for(int j = 1; j <= m; j++)
			{
				for(int k = 0; k <= j; k++)
				{
					int val = dp[i - 1][j - k] + profit[i][k];
					if(dp[i][j] <= val)
					{
						dp[i][j] = val;
						result[i][j] = k;
					}
				}
			}
		}
		printf("%d\n", dp[n][m]);
	//	output(n, m);
	}
		return 0;
}

void output(int x, int y)
{
	if(x == 0)
		return;
	output(x - 1, y - result[x][y]);
	printf("%d %d\n", x, result[x][y]);
}

