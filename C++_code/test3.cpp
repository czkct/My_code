#include<stdio.h>
#include<stdlib.h>
#define NUM 3
typedef struct student {
	long int num;
	char name[10];
	int age;
}student;

student stua[NUM], stub[NUM], *p, *q;
int main() {
	FILE *fp;
	int i;
	p = stua;
	q = stub;
	if((fp = fopen("file3.txt", "wb+"))==NULL) {
		printf("Cannot open file strike any key exit!");
		getchar();
		exit(1);
	}
	printf("\ninput data:\n");
	for(i = 0; i < NUM; i++, p++) 
		scanf("%d%s%d", &p->num, p->name, &p->age);
	p = stua;
	fwrite(p, sizeof(student), NUM, fp);
	rewind(fp);
	while(!feof(fp)) {
		fread(q, sizeof(student), 1, fp);
		printf("%5d\t%s\t%4d\n", q->num, q->name, q->age);
		q++;
		fseek(fp, sizeof(student), 1);
	}

	fclose(fp);
} 
