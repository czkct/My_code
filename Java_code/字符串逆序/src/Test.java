import java.util.*;
public class Test {
	public static void main(String[] args) {
		System.out.println("������һ���ַ���:");
		Scanner scan = new Scanner(System.in);
		String str = new String(scan.next());
//System.out.println("������ַ��������ǣ�"+ str);
		char [] c;
		c = str.toCharArray();
		System.out.println("�������ַ���Ϊ��");
		for(int i = c.length-1; i >= 0; i--) {
			System.out.print(c[i]);
		}
	}
}
