#include<iostream>
#include<cstring>
#include<cstdio>
#include<cmath>
#include<iostream>
#include<algorithm>
using namespace std;

//三条边对应成比例 
const double eps = 1e-8;
int sgn(double x){
	if(fabs(x) < eps) return 0;
	if(x < 0) return -1;
	else return 1; 
}
 
int san[2][3];

struct Point{
	int x, y;
	Point(){
	}
	Point(int _x, int _y) {
		x = _x; y = _y;
	}
	Point operator -(const Point&b)const{
		return Point(x-b.x, y-b.y);
	}
	double operator *(const Point &b)const{
		return x*b.x + y*b.y;
	}
}point[6];

int dist(Point a, Point b) {
	return (a-b)*(a-b);
}

int main(){
	while(scanf("%d%d", &point[0].x, &point[0].y)!= EOF) {
		for(int i = 1; i <= 5; i++){
			scanf("%d%d", &point[i].x, &point[i].y);
		}
		san[0][0] = dist(point[0], point[1]);  // san[][]中全是平方 
		san[0][1] = dist(point[0], point[2]);
		san[0][2] = dist(point[1], point[2]);
		//  前三条边
		san[1][0] = dist(point[3], point[4]);
		san[1][1] = dist(point[3], point[5]);
		san[1][2] = dist(point[4], point[5]);
		//  后三条边 
		//test
	//	for(int i = 0; i <= 1; i++) {
	//		cout << san[i][0] << " " << san[i][1] << " " << san[i][2]<< " " << endl;
	//	}
		int flag = 0;
		int a[3] = {0, 1, 2};
		do{
			if(!sgn((san[0][0]*1.0/san[1][a[0]]-san[0][1]*1.0/san[1][a[1]]))
			&&!sgn((san[0][1]*1.0/san[1][a[1]]-san[0][2]*1.0/san[1][a[2]]))
			&&!sgn((san[0][0]*1.0/san[1][a[0]]-san[0][2]*1.0/san[1][a[2]])))
			flag = 1; 
		}while(next_permutation(a, a+3));
		if(flag) cout << "Yes"<< endl;
		else cout << "No" << endl;
	}
	return 0;
}
