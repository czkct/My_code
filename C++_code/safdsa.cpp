#include<iostream>
using namespace std;
class Date {
public:
	Date() {};
	Date(int _year = 2015, int _mon = 9, int _day = 20) {
		year = _year;
		mon = _mon;
		day = _day;
	}
	void print_date() {
		cout << year <<"��"<<mon << "��"<< day << "��"<<endl;
	}
	void next_day() {
		if(mon == 2) {
			if((!(year%4)&&(year%100))||year%400) //������
			else  // ��ƽ�� 
		} 
	}
private:
	int year, mon, day;		
};
