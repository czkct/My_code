import java.awt.Color;
import java.awt.FlowLayout;//��������awt�еģ�����
import java.awt.Graphics;
import java.awt.event.*;

import javax.swing.*;
import java.awt.*;

public class TankClient extends JFrame{

	public void paint(Graphics g) {
		super.paint(g);
		Color c = g.getColor();
		g.setColor(Color.RED);
		g.fillOval(50, 50, 30, 40);  //λ�úͳ���
		g.setColor(c);
	}
	public TankClient(){}
	public TankClient(String s, int x, int y, int w, int h){
		init(s, x, y, w, h);//��ʼ������
	}
	
	//JLabel label1;
	public void init(String s, int x, int y, int w, int h){
		setTitle(s);
		setVisible(true);
		setResizable(false);
		setLocation(x, y);
		setSize(w, h);
		//setDefaultCloseOperation(EXIT_ON_CLOSE);
		//�������Ҳ�����ô��ڹر�
		setLayout(new FlowLayout());//���ø�ʽ
		//����----label1 = new JLabel("6666");
		//����----add(label1);
		this.addWindowListener(new WindowAdapter(){ //���ڽӿڵ�������ʵ��������������
			public void windowClosing(WindowEvent e){
//�������		TankClient tc = new TankClient("hahah", 100, 100, 100, 100);
//				for(int i = 0; i < 50*1e8; i++);
				System.exit(0);
			}
		});
		//���رմ���ʱWindowEvent���Զ�����һ���¼����󣬲��������ݸ�
		//windowClosing(WindowEvent e)�����еĲ���e�����������Զ�
		//���÷�����windowClosing(WindowEvent e)�Է������¼���������
//		Ҫ��ʵ��WindowListener�ӿڣ��ͱ���Ҫд������ӿ��е����е�7������
//		������7�з�����������û���û�����㶼Ҫ������д��������һ�������ҡ�
//		������������WindowAdapter��������
//		���ǾͿ��԰�������Ϊ����Ҫ�Ľӿڵķ���д�������ɡ�
		//ע��  ����ʵ�ֽӿ�ʱ������ʵ�ֽӿ������еķ���������
		//getContentPane().setBackground(Color.red);
		getContentPane().setVisible(false);
		setBackground(Color.GREEN);//���ñ���ɫ
	}
}
