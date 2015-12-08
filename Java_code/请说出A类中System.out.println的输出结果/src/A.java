class B {
	int n;
	static int sum = 0;
	void setN(int n) {
		this.n = n;
	}
	int getSum() {
		for(int i = 1; i <= n; i++) 
			sum = sum + i;
		return sum;
	}
}
public class A {
	public static void main(String[] args) {
		B b1 = new B(), b2 = new B();
		b1.setN(3);
		b2.setN(5);
		int s1 = b1.getSum();
		int s2 = b2.getSum();
		System.out.println(s1+s2);
	}
}
