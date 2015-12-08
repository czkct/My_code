#include<stdio.h>
#include<stdlib.h> 
typedef struct or_user{
	char orUP[40];  //普通用户账号密码
	long long money;  //普通用户现余金额
	int num_ZJ_liu;  //资金流动态数目
}or_user;

int main() {
	or_user NO1, NO2, NO3;
	scanf("%s%lld%d", NO1.orUP, &NO1.money, &NO1.num_ZJ_liu);
	FILE *fp;
	fp = fopen("login.txt", "w+");
	fwrite(&NO1, sizeof(or_user), 1, fp);
	rewind(fp);
	fread(&NO2, sizeof(or_user), 1, fp);
	printf("%s\t%lld\t%d", NO2.orUP, NO2.money, NO2.num_ZJ_liu);
	fclose(fp);
		fp = fopen("login.txt", "r+");
	rewind(fp);
	fread(&NO3, sizeof(or_user), 1, fp);
	printf("%s\t%lld\t%d", NO3.orUP, NO3.money, NO3.num_ZJ_liu);
	fclose(fp);
	
	return 0;
}
 
 
 
 
 
 
 
 
// 	FILE *fp;
//	fp = fopen("orlogin.txt", "w+");
//	or_user NO1;
//	scanf("%s", NO1->orUP);
//	scanf("%d", NO1->money);
//	scanf("%d", NO1->num_ZJ_liu);
//	fwrite(NO1, sizeof(or_user), 1, fp);
