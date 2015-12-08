
public class Rational {
	int numerator; //分子
	int denominator; //分母
	void setNumeratorAndDenominator(int fenzi, int fenmu) {// 设置分子和分母
		int m = 1, n = 1;
		if(fenzi < 0) m = -1*fenzi;  //如果分子分母中只有一个是负数   最终结果是负数    如果两个都是负数  最后为正数   
		if(fenmu < 0) n = -1*fenmu;  //   这样写同时就处理了两个都为负数的问题
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
		if(a<b) {  //如果a < b   交换a和b   也就是要保证a大于等于b
			int c = a;
			a = b;
			b = c;
		}
		int r = a%b;  // 使r 等于 a除以b的余数
		while(r != 0) {
			a = b;   
			b = r; 
			r = a%b;
		}
		return b;   //  最终最大公约数就是能够整除a的b
	}
	// 分数相加函数
	Rational add(Rational r) {
		int a = r.getNumerator();
		int b = r.getDenominator();
		int newNumerator = numerator*b + denominator*a;   //通分相加的算法
		int newDenominator = denominator*b;
		Rational result = new Rational();
		result.setNumeratorAndDenominator(newNumerator, newDenominator);
		return result;
	}
	Rational sub(Rational r) {   //减法运算
		int a = r.getNumerator();
		int b = r.getDenominator();
		int newNumerator = numerator*b - denominator*a;
		int newDenominator = denominator*b;
		Rational result = new Rational();
		result.setNumeratorAndDenominator(newNumerator, newDenominator);
		return result;
	}
	Rational muti(Rational r) {  //乘法运算
		int a = r.getNumerator();
		int b = r.getDenominator();
		int newNumerator = numerator*a; 
		int newDenominator = denominator*b;
		Rational result = new Rational();
		result.setNumeratorAndDenominator(newNumerator, newDenominator);
		return result;
	}
	Rational div(Rational r) {   //除法运算
		int a = r.getNumerator();
		int b = r.getDenominator();
		int newnumerator = numerator*b;
		int newDenominator = denominator*a;
		Rational result = new Rational();
		result.setNumeratorAndDenominator(newnumerator, newDenominator);
		return result;
	}
}
