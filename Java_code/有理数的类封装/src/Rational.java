
public class Rational {
	int numerator; //����
	int denominator; //��ĸ
	void setNumeratorAndDenominator(int fenzi, int fenmu) {// ���÷��Ӻͷ�ĸ
		int m = 1, n = 1;
		if(fenzi < 0) m = -1*fenzi;  //������ӷ�ĸ��ֻ��һ���Ǹ���   ���ս���Ǹ���    ����������Ǹ���  ���Ϊ����   
		if(fenmu < 0) n = -1*fenmu;  //   ����дͬʱ�ʹ�����������Ϊ����������
		if(fenzi == 0) {
			numerator = 0; 
			denominator = 1; 
			return ;
		}
		int c = f(m, n);
		numerator = fenzi/c;
		denominator = fenmu/c;
		if(numerator<0 && denominator<0) {
			numerator = -numerator;
			denominator = -denominator;
		}
	}
	int getNumerator() {
		return numerator;
	}
	int getDenominator() {
		return denominator;
	}
	int f(int a, int b) {
		if(a<b) {  //���a < b   ����a��b   Ҳ����Ҫ��֤a���ڵ���b
			int c = a;
			a = b;
			b = c;
		}
		int r = a%b;  // ʹr ���� a����b������
		while(r != 0) {
			a = b;   
			b = r; 
			r = a%b;
		}
		return b;   //  �������Լ�������ܹ�����a��b
	}
	// ������Ӻ���
	Rational add(Rational r) {
		int a = r.getNumerator();
		int b = r.getDenominator();
		int newNumerator = numerator*b + denominator*a;   //ͨ����ӵ��㷨
		int newDenominator = denominator*b;
		Rational result = new Rational();
		result.setNumeratorAndDenominator(newNumerator, newDenominator);
		return result;
	}
	Rational sub(Rational r) {   //��������
		int a = r.getNumerator();
		int b = r.getDenominator();
		int newNumerator = numerator*b - denominator*a;
		int newDenominator = denominator*b;
		Rational result = new Rational();
		result.setNumeratorAndDenominator(newNumerator, newDenominator);
		return result;
	}
	Rational muti(Rational r) {  //�˷�����
		int a = r.getNumerator();
		int b = r.getDenominator();
		int newNumerator = numerator*a; 
		int newDenominator = denominator*b;
		Rational result = new Rational();
		result.setNumeratorAndDenominator(newNumerator, newDenominator);
		return result;
	}
	Rational div(Rational r) {   //��������
		int a = r.getNumerator();
		int b = r.getDenominator();
		int newnumerator = numerator*b;
		int newDenominator = denominator*a;
		Rational result = new Rational();
		result.setNumeratorAndDenominator(newnumerator, newDenominator);
		return result;
	}
}
