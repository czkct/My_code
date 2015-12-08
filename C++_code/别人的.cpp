#include<stdio.h>
#include<windows.h> 
void put_ch(char ch,int a,int b)//在a个空格后，显示b个字符ch 
{
int i;
for(i=0;i<a;i++)
printf("%c",' ');
for(i=0;i<b;i++)
printf("%c",ch); 
} 
int main (void)
{
int a,b,c;
int i;
printf("\n"); 
printf("\n");
system("color 0c"); 
a=22,b=8,c=12; 
put_ch(0x03,a,b);
put_ch(0x03,c,b);
printf("\n");
a=a-3,b=b+3+2,c=c-4; 
for(i=0;i<3;i++)
{
put_ch(0x03,a,b);
put_ch(0x03,c,b);
printf("\n"); 
a-=2;
if(a<0)
a=1; 
b=b+4;
c=c-4; 
}
b=b-4;
a++; 
put_ch(0x03,a,b-17);
printf(" I L o v e Y o u 某 某 某 "); 
put_ch(0x03,c,b-16);
printf("\n");
b=b*2+1; 
put_ch(0x03,a,b+1); 
printf("\n");
a++; 
for(i=0;i<8;i++)
{
put_ch(0x03,a,b-1);
printf("\n"); 
b=b-4;
a=a+2;
}
for(i=0;i<3;i++)
{
put_ch(0x03,a,b);
printf("\n"); 
b=b-8;
a=a+4;
} 
}
