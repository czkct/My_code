/*
�ַ����������   
   ��һ���ַ���������뵽��һ���ַ����У�
   ����ָ���ڵڼ�λ���롣
   �磺���ַ�����abcde����������ַ�����ABCDE���Ľ��Ϊ��aAbBcCdDeE����AaBbCcDdEe����
*/ 
#include<stdio.h>
#include<string.h>
#define MAXN 10000
char s1[MAXN];//�ַ���1 
char s2[MAXN];//�ַ���2
char s3[2*MAXN];//�ϲ��� 
int  len2;//s2���ִ��� 
 
void Cross() {//ָ������λ�ò�����ĺ���
	int pos; 
	printf("\n��ָ������λ��: ");
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
	printf("�������ַ���1��");
	scanf("%s", s1);
	printf("\n");
	printf("�������ַ���2��");
	scanf("%s", s2);
	Cross();
	printf("\n------\n\n���Ϊ��%s\n", s3);
	return 0; 
}
