#include<stdio.h>
#include<stdlib.h>
#include<string.h>
#include<memory.h>
int splogin() {
	char spUserPswd[40], tspUserPswd[40];   //  ���ò���ʼ����������Ա�˺ż����뼰��ʱ��������Ա�˺ż�����
	memset(spUserPswd, '\0', sizeof(spUserPswd));
	memset(tspUserPswd, '\0', sizeof(tspUserPswd));
	printf("\t\t            ��������Ա�˻���¼        \n\n");
	printf("\t\t    �˻�����");
	scanf("%s", tspUserPswd);
	int len = strlen(tspUserPswd);
	char *tp = tspUserPswd+len;
	*tp = '#';
	printf("\t\t    ��  �룺");
	scanf("%s", tp+1);

//	//   ��ʱָ��
//
//	FILE *temp;
//	temp = fopen("splogin.txt", "w+");//�½��ļ�
//	char s[20];
//	scanf("%s", s);
//	fputs(s, temp);
//	fclose(temp);
//
//	//   д���ļ�


	FILE *fp;
	fp = fopen("splogin.txt", "r");  // ���ļ�
//	char ch;
//	char *t1 = spuser, *t2 = sppswd;
//	int flag = 0;   //   ����һ��С���
	fgets(spUserPswd, strlen(tspUserPswd)+1, fp);	

//	*t1 = '\0';
//	*t2 = '\0'; 
	fclose(fp);     // �ر��ļ�
//	printf("spuser----%s\n", spuser);
//	printf("tspuser----%s\n", tspuser);
//	printf("sppswd----%s\n", sppswd);
//	printf("tsppswd----%s\n", tsppswd);
//	printf("spUserPswd = %s\n", spUserPswd); 
//	printf("tspUserPswd = %s\n", tspUserPswd); 
	if(!strcmp(spUserPswd, tspUserPswd)) return 1; // ��¼�ɹ�
	else return 0;  // ��¼ʧ��
}
int main(){
	if(splogin())  printf("�ɹ�\n");
	else printf("ʧ��\n"); 
	return 0;
} 


