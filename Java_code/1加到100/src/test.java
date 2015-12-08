
public class test {
	public static void main(String[] args) {
		int num[] = new int[100];
		int sum = 0; 
		for(int i = 0; i < num.length; i++) {
			num[i] = i+1;
			System.out.println(num[i]);
			sum += num[i];
		}
		System.out.println("总和为："+sum);
		System.out.println("平均值为："+sum/100.0);
	}
}
