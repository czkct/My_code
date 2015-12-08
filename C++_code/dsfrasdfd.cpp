#include<iostream>
#include<cstdio>
using namespace std;
const int MAXN = 1000010;
int NEXT[MAXN];
int n;
char s[MAXN];



void getNext(char* p, int* next) {
	next[0] = -1; 
	int k = -1;
	int j = 0; 
	while(j < n) {
		if(k == -1 || p[j] == p[k]) {
			++j; ++k;
			if(p[j] != p[k]) next[j] = k;
			else next[j] = next[k];
		}
		else k = next[k];
	}
}


void DisRes(int num, int* next) {
	int j; 
	printf("Test case #%d\n", num); 
	for(int i = 0; i <= n; i++) {
		if(next[i] == -1 || next[i] == 0) continue;
		j = i - next[i];
		if(i % j == 0) printf("%d %d\n", i, i/j);
	}
	printf("\n");
}

int main() {
	int count = 0; 
	while(scanf("%d", &n) != EOF && n!= 0) {
		if(n == 0) break;
		scanf("%s", s);
		getNext(s, NEXT); 
		DisRes(++count, NEXT);
	}
	return 0;
}
