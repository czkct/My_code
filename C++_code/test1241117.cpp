#include<iostream>
#include<string>
using namespace std;
class employee
{
public:
	void setname(){	cin>>name;}
	void setall(){
		cin>>city;
		cin>>address;
		cin>>youbian;}
	void display(){
	cout<<name<<"\t"<<city<<"\t";
	cout<<city<<"\t"<<youbian<<endl;
	}

private:
	int youbian;
	char city[20];
	char name[20];
	char address[50];
};

int main(){
	employee q;
	q.setname();
	q.setall();
	q.display();
	q.setname();
	q.display();
	return 0;
}
