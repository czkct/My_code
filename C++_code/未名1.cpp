#include<iostream>
#include<cstdio>
#include<cstring>
using namespace std;
int plen, slen;

const int strMAXN = 1000000+5;
int next[strMAXN];
char ch[strMAXN];

void getNext(char* p, int* next) {
	next[0] = -1;
	int k = -1;
	int j = 0; 
	while(j < plen) {
		if(k == -1 || p[j] == p[k]) {
			++j;
			++k;
			next[j] = k;
		}
		else {
			k = next[k];
		}
	}
}

int main() {
	int n; 
	int count = 0;
	while((cin >> n)&& n){
		scanf("%s", ch);
		printf("Test case #%d\n",++count);
		getNext(ch, next);
		for(int i = 1; i < n; i++) {
			if(i%(i-next[i])==0 && i/(i - next[i])>=2) cout << i << " " << i/(i-next[i]) << endl;
		}
	} 
	return 0;
}

