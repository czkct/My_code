import java.util.*;
public class Test {
	public static void main(String[] args) {
		System.out.println("请输入一个字符串:");
		Scanner scan = new Scanner(System.in);
		String str = new String(scan.next());
//System.out.println("输入的字符串内容是："+ str);
		char [] c;
		c = str.toCharArray();
		System.out.println("逆序后的字符串为：");
		for(int i = c.length-1; i >= 0; i--) {
			System.out.print(c[i]);
		}
	}
}
