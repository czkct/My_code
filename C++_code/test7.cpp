#include<stdio.h>
#include<string.h>
void orlogin() {
	//  先从一个文件中读取一共有多少个普通用户
	//  然后从另一个文件中读出所有的普通用户  并存放在链表中
	//  从链表中进行账号密码寻找并比对    找到了就成功登陆  否则登陆失败
	FILE *fp = fopen("num_oruser.txt", "r");
	int sum = 0; 
	char ch;
	while((ch = fgetc(fp)) != EOF)
//		{
			sum = sum*10 + (ch -'0'); 
//			printf("ch = %d\n", (ch -'0'));
//		} 
//	printf("%d", sum);
//   sum 的值就是所有普通用户的个数  
	
}
int main() {
	orlogin();
	return 0;
}
