#include<iostream>
#define PI 3.14159265358979323846
using namespace std;
class simplecircle
{
public:
	int getradius(){
		cin>>itsradius;
		int	radius;
		radius=itsradius;
		return itsradius;
	}
	void mj(){
		int radius=itsradius;
		cout<<radius*radius*PI<<endl;
	}
	void bc(){
		int radius=itsradius;
		cout<<radius*PI*2<<endl;
	}

private:
	int itsradius;
};
int main(){
	simplecircle q;
	q.getradius();
	q.mj();
	q.bc();
	return 0;
}


