import javax.swing.*;
import static javax.swing.JFrame.*;//����JFrame�ľ�̬����

public class Cal {
	public static void main(String[] args){
		//0.1
		JFrame window = new JFrame("�����ӷ�������-���ް�");
		window.setBounds(200, 200, 300, 500);//ǰ�����������Ǵ��ڶ�λ���������������Ǵ��ڴ�С
		window.setVisible(true);//���ô��ڿɼ�
		window.setDefaultCloseOperation(EXIT_ON_CLOSE);//����������˵��û������JFrame�ľ�̬����
		//0.2
		JMenuBar menubar = new JMenuBar();//����һ���˵���
		JMenu menu1, menu2;
		menu1 = new JMenu("�ļ�");
		menu2 = new JMenu("����������");
		menubar.add(menu1);  //���˵���ӵ��˵���
		menubar.add(menu2);
		setJMenuBar(menubar);  //����
		
	}
}
//Ŀ�ģ���Ӳ˵������˵����˵���