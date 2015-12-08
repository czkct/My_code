#include<iostream>
using namespace std;
class MyClass{
	int m;
	public:
		void setm(int i){m = i;}
		void disp() {
			cout << "m="<<m << endl;}
};
int main() {
	void (MyClass::*pfun)(int);
	MyClass a;
	pfun = &MyClass::setm;
	(a.*pfun)(98);
	a.disp();
	return 0;
}
