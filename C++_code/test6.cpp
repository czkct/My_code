#include<stdio.h>
#include<stdlib.h>
#include<string.h>
#include<memory.h>
int splogin() {
	char spUserPswd[40], tspUserPswd[40];   //  设置并初始化超级管理员账号及密码及临时超级管理员账号及密码
	memset(spUserPswd, '\0', sizeof(spUserPswd));
	memset(tspUserPswd, '\0', sizeof(tspUserPswd));
	printf("\t\t            超级管理员账户登录        \n\n");
	printf("\t\t    账户名：");
	scanf("%s", tspUserPswd);
	int len = strlen(tspUserPswd);
	char *tp = tspUserPswd+len;
	*tp = '#';
	printf("\t\t    密  码：");
	scanf("%s", tp+1);

//	//   临时指针
//
//	FILE *temp;
//	temp = fopen("splogin.txt", "w+");//新建文件
//	char s[20];
//	scanf("%s", s);
//	fputs(s, temp);
//	fclose(temp);
//
//	//   写入文件


	FILE *fp;
	fp = fopen("splogin.txt", "r");  // 打开文件
//	char ch;
//	char *t1 = spuser, *t2 = sppswd;
//	int flag = 0;   //   设置一个小标记
	fgets(spUserPswd, strlen(tspUserPswd)+1, fp);	

//	*t1 = '\0';
//	*t2 = '\0'; 
	fclose(fp);     // 关闭文件
//	printf("spuser----%s\n", spuser);
//	printf("tspuser----%s\n", tspuser);
//	printf("sppswd----%s\n", sppswd);
//	printf("tsppswd----%s\n", tsppswd);
//	printf("spUserPswd = %s\n", spUserPswd); 
//	printf("tspUserPswd = %s\n", tspUserPswd); 
	if(!strcmp(spUserPswd, tspUserPswd)) return 1; // 登录成功
	else return 0;  // 登录失败
}
int main(){
	if(splogin())  printf("成功\n");
	else printf("失败\n"); 
	return 0;
} 


