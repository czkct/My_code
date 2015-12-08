#include<stdio.h>
#include<cstdio>
#include<iostream>
using namespace std; 
int main()
{
	int n;
	double i,z,s=0;
	while(scanf("%d",&n)!=EOF)
	{	
		double min=100000,max=-10000000;
		s=0;
		while(n--)
		{
			scanf("%lf",&i);
			if(min>i)
			{	
				min=i;
				cout << "min = " << min << ";  i = " << i << endl;
			}
			if(max<i)
			{
				max=i;
				cout << "max = " << max << ";  i = " << i << endl;
			}
			s+=i;
			cout << "s = " << s << endl; 
		}
		printf("%.2llf\n",(s-max-min)/(n-2));
	}
	return 0;
}
