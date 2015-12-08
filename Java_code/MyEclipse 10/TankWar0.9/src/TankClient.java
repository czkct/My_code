import java.awt.Color;
import java.awt.FlowLayout;//��������awt�еģ�����
import java.awt.Graphics;
import java.awt.event.*;

import javax.swing.*;
import java.awt.*;

public class TankClient extends JFrame{
	public TankClient(){}
	public TankClient(String s, int x, int y, int w, int h){
		init(s, x, y, w, h);//��ʼ������
	}
	Tank myTank = new Tank(50, 50, this);
	Missile m = null;
	//-------------------------------
	Image offScreenImage = null;
	public void update(Graphics g) {  //��Ļ����g
		super.update(g);
		if(offScreenImage == null) { 
			offScreenImage = this.createImage(500, 600);
			//��С��Ӧ������ΪҪ���ǵĴ�С
		}
		 //Ļ�󻭱�gOffScreen
		Graphics gOffScreen = offScreenImage.getGraphics();
		paint(gOffScreen);
		g.drawImage(offScreenImage, 0, 0, null);
	}
	//------------------------------//���ڻ滭
	public void paint(Graphics g) {
		super.paint(g);
		if(m!=null) m.draw(g);
		myTank.draw(g);
	}
	//------------------------------���ڳ�ʼ��
	public void init(String s, int x, int y, int w, int h){
		setTitle(s);
		setVisible(true);
		setResizable(false);
		setLocation(x, y);
		setSize(w, h);
		setLayout(new FlowLayout());
//		this.addWindowListener(new WindowAdapter(){ 
//			public void windowClosing(WindowEvent e){
//			}
//		});
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		getContentPane().setVisible(false);
		setBackground(Color.GREEN);
		
		this.addKeyListener(new KeyMonitor());
		
		new Thread(new PaintThread()).start();
	}
	//----------------------------�ڲ���
	private class PaintThread implements Runnable{
		public void run() {
			while(true) {
				repaint();
				try {
					Thread.sleep(100);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
		
	}

	private class KeyMonitor extends KeyAdapter {
		public void keyPressed(KeyEvent e) {
			myTank._KeyPressed(e);
		}
		public void keyReleased(KeyEvent e) {
			myTank._KeyReleased(e);
		}
	}
}
