import java.awt.Color;
import java.awt.FlowLayout;//��������awt�еģ�����
import java.awt.Graphics;
import java.awt.event.*;

import javax.swing.*;
import java.awt.*;

import java.util.ArrayList;
import java.util.List;


public class TankClient extends JFrame{
	public static int GAME_WIDTH;   //��Ϸ���ڿ���
	public static int GAME_HEIGHT;  //��Ϸ���ڸ߶�
	
	private static int x, y;     //��Ϸ����λ��
	
	List<Boom> booms = new ArrayList<Boom>();   //��ը����
	List<Tank> tanks = new ArrayList<Tank>();   //�з�̹�˼���
	List<Missile> missiles = new ArrayList<Missile>();   //�ӵ�����
	
	public TankClient(int x, int y, int w, int h){
		TankClient.x = x;
		TankClient.y = y;
		GAME_WIDTH = w;
		GAME_HEIGHT = h;
	}   //̹�˶˹��캯��
	public TankClient(String s, int x, int y, int w, int h){  //̹�˶˹��캯��
		this(x, y, w, h);
		init(s, TankClient.x, TankClient.y, w, h);   //��ʼ����Ϸ�������֡�����λ�á����ڿ��Ⱥ͸߶�
	}					// ̹������λ�ã�  ̹�˺û���         ̹�˳�ʼ����                   ����ȥ������
	Tank myTank = new Tank(150, 150, true,Tank.Direction.STOP, this);
//	Tank enemTank = new Tank(50, 50, false, this);
	
	
	
	
	//------------------------------- 
	Image offScreenImage = null; 
	public void update(Graphics g) {        //��Ļ����g 
		super.update(g); 
		if(offScreenImage == null) { 
			offScreenImage = this.createImage(GAME_WIDTH, GAME_HEIGHT); 
			                                    //��С��Ӧ������ΪҪ���ǵĴ�С  
		} 
		//Ļ�󻭱�gOffScreen 
		Graphics gOffScreen = offScreenImage.getGraphics(); //��ȡ���ͼƬ��ͼ��
		paint(gOffScreen);     //�ѻ��ʴ��ݸ�paint������Ȼ��һ���Գ��ֳ���
		g.drawImage(offScreenImage, 0, 0, null); 
	} 
	//------------------------------//���ڻ滭 
	public void paint(Graphics g) { 
		//super.paint(g); 
		if(offScreenImage == null) { 
			offScreenImage = this.createImage(GAME_WIDTH, GAME_HEIGHT); 	                                    //��С��Ӧ������ΪҪ���ǵĴ�С  
		} 
		//Ļ�󻭱�gOffScreen 
		Graphics gOffScreen = offScreenImage.getGraphics(); //��ȡ���ͼƬ��ͼ��
		//paint(gOffScreen);     //�ѻ��ʴ��ݸ�paint������Ȼ��һ���Գ��ֳ���
		gOffScreen.setColor(Color.GREEN);  //�����»��ʵı���ɫ
		gOffScreen.fillRect(TankClient.x, TankClient.y, GAME_WIDTH, GAME_HEIGHT);  //���ñ���
		//super.paint(gOffScreen); 
		gOffScreen.setColor(Color.BLACK);  //��ԭ���ʵ���ɫ
		
		//�ڵ�����
		gOffScreen.drawString("missiles.count"+missiles.size(), 10, 50);
		gOffScreen.drawString("booms count"+booms.size(), 10, 70);
		gOffScreen.drawString("tanks count"+tanks.size(), 10, 90);
		
		for(int i = 0; i < missiles.size();i++){
			Missile m = missiles.get(i);
			m.hitTanks(tanks);
			m.draw(gOffScreen);
		}//�������е��ӵ�
		
		for(int i = 0; i< booms.size(); i++){
			Boom bm = booms.get(i);
			bm.draw(gOffScreen);
		}//�������еı�ը
		
		for(int i = 0; i < tanks.size(); i++){
//			Tank t = tanks.get(i);
//			t.draw(g);
			tanks.get(i).draw(gOffScreen);
		}//�������еĵж�̹��
		
		myTank.draw(gOffScreen);
	//	enemTank.draw(g);
		g.drawImage(offScreenImage, 0, 0, null); 
	}
	//------------------------------���ڳ�ʼ��
	public void init(String s, int x, int y, int w, int h){
		for(int i = 0; i < 10; i++) {
			tanks.add(new Tank(50+40*(i+1), 50, false, Tank.Direction.D, this));
		}
		setTitle(s);  //���ô��ڱ���
		setVisible(true);  //���ô��ڿ���
		setResizable(false);  //���ô��ڴ�С���ɸ�
		setLocation(x, y);   //���ô���λ��
		setSize(w, h);   //���ô��ڿ��Ⱥ͸߶�
		setLayout(new FlowLayout());   //���ô��ڲ��ַ�ʽ
		setDefaultCloseOperation(EXIT_ON_CLOSE);  //���ô��ڹرղ���
		//getContentPane().setVisible(false);  //ʹ������岻����ʾ    ��ò�����ʹ��
		getContentPane().setBackground(Color.GREEN);
		
		this.addKeyListener(new KeyMonitor());  //�Ե�ǰ�������Ӱ���������
		new Thread(new PaintThread()).start();//�����̶߳���new����,������start()���������̡߳�
	}
	//----------------------------�ڲ���
	private class PaintThread implements Runnable{ //�����߳����ػ�   �����ĺô���ʵʱ���� 
		//�̳нӿ�  ��Ҫʵ���������еķ���
		public void run() {
			while(true) {
				repaint();//��Ϊ���ڼ̳е���JFrame�������������������ػ�ʱֵ����paint����
				try {
					Thread.sleep(1);
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