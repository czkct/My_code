import java.io.*;
import java.net.*;
public class Server {
	public static void main(String args[]) {
		String [] answer = {"�����������","����������","���ӡ������ɳ��"};//String�ඨ����һ���ַ�����������answer
		ServerSocket serverForClient = null;
		Socket socketOnServer = null;  //����һ����ʱ���׽���   ����Ҫ���ڽ��ܷ������׽��������ϵĿͻ��˵��׽���
		DataOutputStream out = null;
		DataInputStream in = null;
		try {
			serverForClient = new ServerSocket(2010);//������������һ��ServerSocket����serverForClient������ͻ����׽�����������
			//�Ӷ��ﵽ�ͻ��˺ͷ������˵�����
			//���䷽����
			//�ͻ��˵��׽�����Socket��������
			//�������˵��׽�����ServerSocket��������
		}
		catch(IOException e1) {
			System.out.println(e1);
		}
		try {
			System.out.println("�ȴ��ͻ�����");
			socketOnServer = serverForClient.accept();  //����ʱ�����socketOnServer�׽���������ͨ���������׽��������ϵĿͻ��˵��׽���
			//accept()�������ؿͻ��˵��׽���
			out = new DataOutputStream(socketOnServer.getOutputStream());
			in = new DataInputStream(socketOnServer.getInputStream());
			for(int i = 0; i<answer.length; i++) {
				String s = in.readUTF();
				System.out.println("�������յ��ͻ������ʣ�"+s);
				out.writeUTF(answer[i]);
				Thread.sleep(500);
			}
		}
		catch(Exception e) {
			System.out.println("�ͻ��Ѿ��Ͽ�"+e);
		}
	}
}
//�ͻ��˵��׽��ֺͷ������˵��׽������Ӻ�
//���������������������ǿͻ��˵����������
//��������������������ǿɶ��ϵ�����������