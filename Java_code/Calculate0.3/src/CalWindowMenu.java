import javax.swing.*;
import static javax.swing.JFrame.*;//����JFrame�ľ�̬����
public class CalWindowMenu extends JFrame{
	JMenuBar menubar;
	JMenu menu1, menu2;
	public CalWindowMenu(){};
	public CalWindowMenu(String s, int x, int y, int w, int h){
		init(s);
		setLocation(x,y); //����λ��
		setSize(w, h); //���ô�С
		setVisible(true);  //�����Ƿ���ӻ�
		setDefaultCloseOperation(DISPOSE_ON_CLOSE); // ���ùرղ���
	}
	
	void init(String s){
		setTitle(s);//���˴���ı�������Ϊָ�����ַ�����
		menubar = new JMenuBar();//����һ���˵���
		menu1 = new JMenu("����������");  //���������˵�
		menu2 = new JMenu("��������");
		menubar.add(menu1);  //���˵���ӵ��˵���
		menubar.add(menu2);
		setJMenuBar(menubar); //���˴���Ĳ˵�������Ϊָ���Ĳ˵���
	}
	
	
}
