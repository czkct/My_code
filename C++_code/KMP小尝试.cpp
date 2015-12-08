#include<iostream>
#include<cstdio>
#include<cstring>
using namespace std;
int plen, slen;
const int MAXN = 1000;
int next[MAXN];

void getNext(char* p, int* next) {
	next[0] = -1;
	int k = -1;
	int j = 0; 
	while(j < plen) {
		if(k == -1 || p[j] == p[k]) {
			++j;
			++k;
		    if (p[j] != p[k])  
                next[j] = k;   //֮ǰֻ����һ��  
            else  
                //��Ϊ���ܳ���p[j] = p[ next[j] ]�����Ե�����ʱ��Ҫ�����ݹ飬k = next[k] = next[next[k]]  
                next[j] = next[k];
		}
		else {
			k = next[k];
		}
	}
}

int kmpSearch(char* s, char* p) {
	int i = 0; 
	int j = 0; 
	slen = strlen(s);
	plen = strlen(p);
	while(i < slen && j < plen) {
		if(j == -1 || s[i] == p[j]) {
			++i;
			++j;
		}
		else {
			j = next[j];
		}
	}
	if(j == plen) {
		return i - j;
	}
	else 
		return -1; 
} 

int main() {
	char a[100] = "asdfghjkdfghjkdafkdsjdioqweiruhkdjakfdafdkshdsjklajf";
	char b[100] = "jf";
	memset(next, 0, sizeof(next));
	getNext(b, next);
	int pos = kmpSearch(a, b);
	cout << "pos = " << pos << endl;
	return 0;
}

