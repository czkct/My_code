#include<stdio.h>
#include<stdlib.h>
typedef struct stu {
	int num;
	char *name;
	char sex;
	float score;
}stu;
int main() {
	stu *ps;
	ps = (stu *)malloc(sizeof(stu));
	ps->num = 1001;
	ps->name = "Zhang";
	ps->sex = 'M';
	ps->score = 95.5;
	printf("No.=%d\nName=%s\n", ps->num, ps->name);
	printf("Sex=%c\nScore=%f\n", ps->sex, ps->score);
	free(ps);
} 

