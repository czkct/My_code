import java.io.*;
import java.util.Scanner;

public class deleteFile {
	public static void main(String[] args) {
		System.out.println("������Ҫɾ����Ŀ���ļ���·����");
		Scanner scan = new Scanner(System.in);
		String str = new String(scan.next());
		System.out.println("�������Ŀ���ļ������ƣ�");
		String str1 = new String(scan.next());
		delFile m = new delFile();
		m.del(str+"/"+str1);
		//ɾ���յ��ļ���
		File f = new File(str,str1);
		f.delete();
		System.out.println("ɾ����ϣ�");
	}
}

/*
 * 1.��File������ʽ����Ŀ¼�µ�ȫ���ļ�����һ��File����������
 * 2.����������ÿһ��������ɾ����
 * 		1>.���ɾ���ɹ��������ɾ����һ��
 * 		2>.����ݹ����ɾ������
 * 		3>.ɾ�����ļ����µ����ļ�֮���ɾ������ļ���
 * */
