#include<iostream>
#include<cstdio>
#include<cstring>
using namespace std;
int main(){
	int B, C;
	while(cin >> B >> C) {
		// c > 0   两正两负
	// c < 0   一正一负 
		int flag = 0;
		int p, q;
		for(int i= -1000; i<= 1000; i++) {
			int a = i; 
			int b = B-a; 
			if((a*b) == C && a<=b) {
				p = a; 
				q = b; 
				flag = 1; 
				break;
			}
		} 
		if(flag) cout << p << " " << q << endl;
		else cout << "impossible" << endl;
	}
	return 0;
}
