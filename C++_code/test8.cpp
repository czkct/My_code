#include<stdio.h>  
#include<stdlib.h>  
void exchange(int max, int m[], int po) {
	int t = 0; 
	t = m[0];
	m[0] = m[po];
	m[po] = t;
}

int main() {  
	int num[5];
	int MAX = 0; 
	int flag = 0;
	
	for(int i = 0; i < 5; i++) {
		scanf("%d", &num[i]);
		if(i == 0) {
			flag = 0;
			MAX = num[0];
		}
		else if(num[i]>MAX) {
			MAX = num[i];
			flag = i;
		}
	}
	exchange(MAX, num, flag);
	for(int i = 0; i < 5; i++) {
		printf("%d ", num[i]);
	}
	return 0;  
}  
