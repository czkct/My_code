import java.io.*;
import java.net.*;
public class Client {
	public static void main(String args[]) {
		String [] mess = {"1+1��ʲô����²�����2", "��Ϊʲô��������","ʲô�����ܿ����ܳԡ�����"};//��String�ඨ����һ���ַ�����������mess
		Socket mysocket;
		DataInputStream in = null;  //����������in
		DataOutputStream out = null;  //���������out
		try {
			mysocket = new Socket("127.0.0.1", 2010);   //Socket��ͻ����׽��ֶ���mysocket
			in = new DataInputStream(mysocket.getInputStream()); 
			out = new DataOutputStream(mysocket.getOutputStream());
			/*
			 * getInputStream()�ķ���ֵ��InputStream�����
			 * getOutputStream()�ķ���ֵ��OutputStream�����
			 * DataInputStream�����Ķ���������������
			 * DataOutputStream�����Ķ��������������
			 * DataInputStream��̳���InputStream��   ��InputStream����һЩ����
			 * DataOutputStream����ͬ��
			 * */
			for(int i = 0; i < mess.length; i++) {
				out.writeUTF(mess[i]);//writeUTF��������д��һ���ַ��� ����DataOutputStream���е�һ������
				//�˴��ǽ�mess[i]�е��ַ���д��out������
				String s = in.readUTF(); //readUTF�������Ƕ�ȡһ��UTF�ַ���   ����DataInputStream���е�һ������   ����ֵ��һ���ַ���������
				//in ��ȡ��Ϣ  ������״̬
				System.out.println("�ͻ����յ�����˵Ļش�"+s);
				Thread.sleep(500);
			}
		}
		catch(Exception e) {
			System.out.println("�������Ѿ��Ͽ�"+e);
		}
	}
}
//�ͻ��˵��׽��ֺͷ������˵��׽������Ӻ�
//�ͻ��˵�����������Ƿ������˵�����������
//�ͻ��˵������������Ƿ������˵����������