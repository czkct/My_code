// public void getChars(int start, int end, char c[], int offset)
//getChars()�����ǽ���ǰ�ַ����е�һ�����ַ����Ƶ�����cָ���������У����ַ����д�λ��start��end-1λ���ϵ��游���Ƶ�����c�У���������c��offset����ʼ�����Щ�ַ���
//ע��㣺���뱣֤����c��������Ҫ�����Ƶ��ַ���
//�����������ȡ�ַ����е��ִ���������
public class Example9_6 {
	public static void main(String[] args) {
		char [] a, b, c;
		String s = "2009��10��1���ǹ���60����";
		a = new char[2];
		s.getChars(11, 13, a, 0);
		System.out.println(a);
		c = "ʮһ�����ڼ䣬ѧУ���ż���".toCharArray();
		for(char ch:c)
			System.out.print(ch);
	}
}
//public char[] toCharArray()����
//�ַ����������ø÷�������һ���ַ����飬������ĳ������ַ����ĳ�����ȣ���i��Ԫ�е��ַ��պ�Ϊ��ǰ�ַ����еĵ�i���ַ�
//�����ַ���������