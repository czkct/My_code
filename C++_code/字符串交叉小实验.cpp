/*
字符串交叉插入   
   将一个字符串交叉插入到另一个字符串中，
   可以指定在第几位插入。
   如：将字符串“abcde”交叉插入字符串“ABCDE”的结果为“aAbBcCdDeE”或“AaBbCcDdEe”，
*/ 
#include<stdio.h>
#include<string.h>
#define MAXN 10000
char s1[MAXN];//字符串1 
char s2[MAXN];//字符串2
char s3[2*MAXN];//合并串 
int  len2;//s2的字串长 
 
void Cross() {//指定插入位置并交叉的函数
	int pos; 
	printf("\n请指定插入位置: ");
	scanf("%d", &pos);
	len2 = strlen(s2);
	if(pos < len2) {
		for(int i = 0; i < pos; i++) s3[i] = s2[i];
		int j = pos, i = 0, k = pos;
		while(s1[i] != '\0' || s2[j] != '\0') {
			if(s1[i] != '\0') {s3[k] = s1[i]; ++k; ++i;}
			if(s2[j] != '\0') {s3[k] = s2[j]; ++k; ++j;}
		}
	}
	else {//pos >= len2 
		strcat(s3, s2);
		strcat(s3, s1);
	}
}
int main() {
	printf("请输入字符串1：");
	scanf("%s", s1);
	printf("\n");
	printf("请输入字符串2：");
	scanf("%s", s2);
	Cross();
	printf("\n------\n\n结果为：%s\n", s3);
	return 0; 
}
