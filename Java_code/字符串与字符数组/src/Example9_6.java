// public void getChars(int start, int end, char c[], int offset)
//getChars()方法是将当前字符串中的一部分字符复制到参数c指定的数组中，将字符串中从位置start到end-1位置上的祖父复制到数组c中，并从数组c的offset处开始存放这些字符。
//注意点：必须保证数组c能容纳下要被复制的字符。
//这个方法就是取字符串中的字串到数组中
public class Example9_6 {
	public static void main(String[] args) {
		char [] a, b, c;
		String s = "2009年10月1日是国庆60周年";
		a = new char[2];
		s.getChars(11, 13, a, 0);
		System.out.println(a);
		c = "十一长假期间，学校都放假了".toCharArray();
		for(char ch:c)
			System.out.print(ch);
	}
}
//public char[] toCharArray()方法
//字符串对象条用该方法返回一个字符数组，该数组的长度与字符串的长度相等，第i单元中的字符刚好为当前字符串中的第i个字符
//就是字符串到数组