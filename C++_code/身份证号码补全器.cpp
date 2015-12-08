#include<bits/stdc++.h>
using namespace std;

int main() {
	cout << "请输入身份证号码的前17位："<< endl;
	char A[18];
	cin >> A;
	int W[18];
	for(int i = 0; i < 17; i++) {
		W[i] = (int)pow(2, 17-i)%11;
	}
	int S[18];
	for(int i = 0; i < 17; i++) {
		S[i] = (A[i]-48)*W[i];
	}
	int sum = 0;
	for(int i = 0; i < 17; i++) {
		sum += S[i];
	}
	int Y = sum%11;
	switch(Y) {
		case 0: A[17] = '1'; break;
		case 1: A[17] = '0'; break;
		case 2: A[17] = 'X'; break;
		case 3: A[17] = '9'; break;
		case 4: A[17] = '8'; break;
		case 5: A[17] = '7'; break;
		case 6: A[17] = '6'; break;
		case 7: A[17] = '5'; break;
		case 8: A[17] = '4'; break;
		case 9: A[17] = '3'; break;
		case 10: A[17] = '2'; break;
	}
	cout << endl << "完整的身份证号码为："<< endl;
	puts(A);
	cout << endl << endl << endl  << endl << endl; 
	system("pause");
	
/*	
for(int i = 0; i < 17; i++) {
		cout << W[i] << " " ;
*/	
	return 0;
}
