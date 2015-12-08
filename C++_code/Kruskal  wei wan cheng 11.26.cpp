// duti yiding yao feichang zixi !!!!
//zhe ti wo fan de cuo wu jiu shi "buneng dandu de yi dian shifou chuxian lai panduan shifou liantong  "
#include<iostream>
#include<cstring>
#include<cstdio>
#include<algorithm>
using namespace std;

//  1-M ge cun zhuang
//  M < 100
//  while N = 0   end
//  first line   N   M
//  next  N line   num1  num2   price
//  jin tian shi gan en jie , wo de shu ru fa huai diao le, zhen shi ri le gou !
const int MAXN = 100+5;
int pre[MAXN]; // zuxian jie dian
int ans;//da an
int sum;
int u[MAXN];  //  di yi ge cun zhuang
int v[MAXN];  //  di er ge cun zhuang
int w[MAXN];  //  weight   quan  de  zhi 

void init(){
	memset(u, 0, sizeof(u));
	memset(v, 0, sizeof(v));
	memset(w, 0, sizeof(w));
	memset(pre, 0, sizeof(pre));
}

int cmp (const int i, const int j )  
{
	return w[i] < w[j];   //  anzhao  price[] zhong yuansu  duiying de quanzhi lai jinxing cong xiao dao da de pai xu
}

int unionsearch(int root) // find   // root jie dian zai gang chuan ru de shi hou hai bu shi gen jie dian
{
	int son = root;
	int temp;
	
	while(root != pre[root]){   //zhao dao le root jie dian
		root = pre[root];
	}
	//lu jing ya suo!
	while(son!= root){
		temp = pre[son];
		pre[son] = root;
		son = temp;
	}
	return root;  
}

void join(int x, int y, int w) {  // w shi quan  
	int root1 = unionsearch(x);
	int root2 = unionsearch(y);
	if(root1 != root2){
		sum++;//WA dian::不能单纯地以所有点是否出现来判断是否能连通！要看点与点之间是否连通！  
		pre[root1] = root2;
		ans += w;
	}
}

//he bing 
int main(){
	int N, M;
	while(scanf("%d%d",&N,&M)&&N)  //dang N wei 0 shi  , ye yao quan bu shuru jieshu  caineng tuichu xunhuan
	{	
		init();
		for(int i = 0; i < N; i++) {
			scanf("%d%d%d", &u[i], &v[i], &w[i]);
			pre[u[i]] = u[i]; //  gangkaishi mei ge cun zhuang de fujiedian dou shi ziji
			pre[v[i]] = v[i];
		}
		//  dang cunzhuang zhijian de lu meiyou ba suoyou cunzhuang dou lian zai yiqi shi, buneng dai biao M>N
		
		if(M == 1) {
			cout << 0 << endl;  // zhe li yinggai  shi 0 a !!
			continue;
		}
		
		
		// xian zai xu yao yige shuzu  lai cun fang  zhe xie price  xong xiao dao da de shun xu
		int price[MAXN];
		for(int i = 0; i < N; i++){
			price[i] = i;
		}
		// dui bian jinxing paixu
		sort(price, price+N, cmp);
		ans = 0; //  zhe ge shi haofei
		sum = 1; // yijing liantong de dian
		for(int i = 0; i < N; i++){
			//genju price yuansu de shunvu tian jia daolu 
			// u[price[i]]  v[price[i]]   w[price[i]]
			join(u[price[i]], v[price[i]], w[price[i]]);
		}
		if(sum!=M) cout << "?" << endl;
		else cout << ans << endl;
	}
	return 0;
}

/*

*/
