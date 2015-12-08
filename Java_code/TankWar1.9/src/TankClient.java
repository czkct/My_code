import java.awt.Color;
import java.awt.FlowLayout;//��������awt�еģ�����
import java.awt.Graphics;
import java.awt.event.*;

import javax.swing.*;
import java.awt.*;

import java.util.ArrayList;
import java.util.List;


public class TankClient extends JFrame{
	public static int GAME_WIDTH;
	public static int GAME_HEIGHT;
	
	public TankClient(){}
	public TankClient(String s, int x, int y, int w, int h){
		init(s, x, y, w, h);//��ʼ������
		GAME_WIDTH = w;
		GAME_HEIGHT = h;
	}
	Tank myTank = new Tank(50, 50, true, this);
	Tank enemTank = new Tank(50, 50, false, this);
	
	
	List<Boom> booms = new ArrayList<Boom>();
	
	
	
	List<Missile> missiles = new ArrayList<Missile>();
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
		
		//�ڵ�����
		g.drawString("missiles.count"+missiles.size(), 10, 50);
		g.drawString("booms count"+booms.size(), 100, 50);
		
		for(int i = 0; i < missiles.size();i++){
			Missile m = missiles.get(i);
			m.hitTank(enemTank);
//			if(!m.isLive()) missiles.remove(m);
			if(m!=null) m.draw(g);
		}
		
		for(int i  =0; i< booms.size(); i++){
			Boom bm = booms.get(i);
			bm.draw(g);
		}
		
		myTank.draw(g);
		enemTank.draw(g);
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
					Thread.sleep(50);
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
