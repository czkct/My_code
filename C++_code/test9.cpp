//�Ӽ����������20���ַ����� ������ENDʱ��������
//�ҵ������ַ���    �������
#include<stdio.h>
#include<string.h>
int main() {
	char s[20][20];
	char (*p)[20];
	p = s;
//////	char str[20] = "END";
	while(scanf("%s", p) && strcmp(*p, "END")) 
	p++;
	int len = (p-s);

	char MAX[20];
	memset(MAX, 0, sizeof(MAX));
	strcpy(MAX, s[0]);
	
	for(int i = 1; i < len; i++) 
		if(strcmp(s[i], MAX) == 1) strcpy(MAX, s[i]);
		
	printf("%s\n", MAX);
	
	return 0;
} 
