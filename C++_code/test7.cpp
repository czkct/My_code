#include<stdio.h>
#include<string.h>
void orlogin() {
	//  �ȴ�һ���ļ��ж�ȡһ���ж��ٸ���ͨ�û�
	//  Ȼ�����һ���ļ��ж������е���ͨ�û�  �������������
	//  �������н����˺�����Ѱ�Ҳ��ȶ�    �ҵ��˾ͳɹ���½  �����½ʧ��
	FILE *fp = fopen("num_oruser.txt", "r");
	int sum = 0; 
	char ch;
	while((ch = fgetc(fp)) != EOF)
//		{
			sum = sum*10 + (ch -'0'); 
//			printf("ch = %d\n", (ch -'0'));
//		} 
//	printf("%d", sum);
//   sum ��ֵ����������ͨ�û��ĸ���  
	
}
int main() {
	orlogin();
	return 0;
}
