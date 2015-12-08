#include<stdio.h>
#include<stdlib.h>
typedef struct node {
	int num, score;
	struct node *next;
}node;
node *creat(node *head, int n) {
	node *p, *q;
	int i;
	for(i = 1; i <= n; i++) {
		q = (node *)malloc(sizeof(node));
		printf("Input %d num, score: \n", i);  
	}
}
int main() {
	
} 
