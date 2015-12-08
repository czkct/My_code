#include <stdio.h>
#include <time.h>

int main()
{
 time_t nowtime;                                                                                                                          
 struct tm *timeinfo;
 time( &nowtime );
 timeinfo = localtime( &nowtime );
 int year, month, day;
 year = timeinfo->tm_year + 1900;
 month = timeinfo->tm_mon + 1;
 day = timeinfo->tm_mday;
 printf("%d %d %d\n", year, month, day);
 return 0;
}
/*

struct tm -- 时间结构，time.h 定义如下： 
int tm_sec; 
int tm_min; 
int tm_hour; 
int tm_mday; 
int tm_mon; 
int tm_year; 
int tm_wday; 
int tm_yday; 
int tm_isdst; 

*/ 
