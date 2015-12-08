#include<iostream> 
using namespace std;
class demo{
	public:
		static int constructor, copy_constructor;
		demo() {
			cout << "default constructor"<<endl;
			constructor++;
		}
		demo(const demo& x) {
			cout<<"copy constructor"<< endl;
			copy_constructor++;
		}
		
}; 
int demo::constructor = 0; 
int demo::copy_constructor = 0; 
demo usercode(demo b) {
	demo c(b);
	return c;
}
int main() {
	demo a, d;
	cout << "calling usercode" << endl;
	d = usercode(a);
	cout << demo::constructor << ", "<< demo::copy_constructor << endl;
	system("pause");
	return 0;
}

