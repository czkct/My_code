#include<stdio.h>
#include<stdlib.h>
int main() {
	FILE *fp;
	char ch;
	if((fp = fopen("file.txt", "r"))==NULL) {
		printf("cannot open file please strike any key exit!");
		getchar();
		exit(1);
	}
	ch = fgetc(fp);
	while(ch != EOF) {
		putchar(ch);
		ch = fgetc(fp);
	}
	printf("\n");
	fclose(fp);
}
