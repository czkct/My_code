import javax.swing.*;//���������JComponent��������(Component)�ļ������
import static javax.swing.JFrame.*;//����JFrame�ľ�̬����
//JFrame���ʵ������һ���ײ���������ͨ����˵�Ĵ���
public class test {
	public static void main(String[] args){
		JFrame window1 = new JFrame("��������");
		JFrame window2 = new JFrame("�˳�����");
		window1.setBounds(60, 100, 188, 108);  //����������С
		window2.setBounds(260, 100, 188, 108);
		window1.setVisible(true);//���ô��ڿɼ�
		window1.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		window2.setVisible(true);
		window2.setDefaultCloseOperation(EXIT_ON_CLOSE);
//setDefaultCloseOperation()���������������õ����������ϽǵĹر�ͼ��󣬳�������������Ĵ���
	}
}
