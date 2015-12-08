import javax.imageio.ImageIO;
import javax.swing.*;

import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.Image;
import java.io.IOException;
import static javax.swing.JFrame.*;//����JFrame�ľ�̬����
public class CalWindowMenu extends JFrame{
	JMenuBar menubar;//�˵���
	JMenu menu1, menu2, menu3;  //�˵�  �˵�Ҳ������Ϊһ���˵���
	JMenuItem item11, item12, item21, item22, item31, item32;  //�˵���  �˵���ǵ�����
	
	Mypanel key_panel;
	
	
	public CalWindowMenu(){};
	public CalWindowMenu(String s, int x, int y, int w, int h){
		this.init(s);
		this.setLocation(x,y); //����λ��
		this.setSize(w, h); //���ô�С
		this.setVisible(true);  //�����Ƿ���ӻ�
		this.setResizable(false);
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE); // ���ùرղ���
	}
	
	void init(String s){  //����˴���ͼ��
		//-----ͼ��
		String path = "/Img/�Ҿ�����30.jpg";
		try{
			Image img = ImageIO.read(this.getClass().getResource(path));
			this.setIconImage(img);
		}
		catch(IOException e){
			e.printStackTrace();
		}
		//���ò���
		this.setLayout(null);
		
		
		//------
		setTitle(s);//���˴���ı�������Ϊָ�����ַ�����
		menubar = new JMenuBar();//����һ���˵���
		menu1 = new JMenu("����������");  //���������˵�
		menu2 = new JMenu("��������");
		menu3 = new JMenu("����");
		
		item11 = new JMenuItem("������");  //���岢��ʼ���˵���
		item12 = new JMenuItem("��׼��");
		item21 = new JMenuItem("���һ�����ڵ�������ļ�");
		item22 = new JMenuItem("��ڶ������ڵ�������ļ�");
		item31 = new JMenuItem("�鿴����");
		item32 = new JMenuItem("���ڼ�����");
		
		menu1.add(item11);  //���˵�����ӵ��˵���
		menu1.add(item12);
		menu2.add(item21);
		menu2.add(item22);
		menu3.add(item31);
		menu3.add(item32);
		
		menubar.add(menu1);  //���˵���ӵ��˵���
		menubar.add(menu2);
		menubar.add(menu3);
		
		key_panel = new Mypanel();
		this.add(key_panel);
		//��Ӱ������key_panel
		key_panel.setLocation(10, 150);
		
		
		setJMenuBar(menubar); //���˴���Ĳ˵�������Ϊָ���Ĳ˵���
	}
	
	
}
