#include<bits/stdc++.h>
using namespace std;
int main() {
	int a[3];
	int temp, d = 0, f = 0;
	int s;
	for(int i = 0; i < 3; i++) {
		cin >> a[i]; 
	}
	for(int i = 0; i < 3; i++) {
		cin >> temp;
		if((s = a[i] - temp)>0) d += s/2;
		else f += (temp -a[i]);
	}
	if(d>=f) cout << "Yes" << endl;
	else cout << "No" << endl;
	return 0;
}
