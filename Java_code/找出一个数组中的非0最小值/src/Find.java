import java.util.Scanner;
public class Find {
	public static void main(String[] args) {
		System.out.println("����������Ĵ�С��");
		Scanner input = new Scanner(System.in);
	    int size = input.nextInt();
	    int a[] = new int[size];
//System.out.println("size:"+size);
		System.out.println("����������Ԫ��ÿ���ûس�������");
		
		for(int i = 0; i < size; i++) {
			a[i] = input.nextInt();
		}
		int min = 0;
		for(int i = 0; i < size; i++) {
//System.out.println("i="+i);
//System.out.println(a[i]);
			if(min == 0) {
				if(a[i]!=0) min = a[i];
				else continue;
			}
			else {
				if(a[i] != 0 && a[i] < min) min = a[i];
			}
		}
		System.out.println("������Ԫ������СֵΪ��  "+min);
	}
}
