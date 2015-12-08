#include<stdio.h>
#include<stdlib.h>
int main() {
	FILE *fp;
	char ch;
	if((fp=fopen("file2.txt", "w+"))==NULL) {
		printf("Cannot open file please strike any key exit !");
		getchar();
		exit(1);
	}
	printf("input a string:\n");
	ch = getchar();
	while(ch!='\n') {
		fputc(ch, fp);
		ch = getchar();
	}
	rewind(fp);
	ch = fgetc(fp);
	while(ch!=EOF) {
		putchar(ch);
		ch = fgetc(fp); 
	}
	printf("\n");
	fclose(fp);
}
