import java.awt.Color;
import java.awt.FlowLayout;//��������awt�еģ�����
import java.awt.Graphics;
import java.awt.event.*;

import javax.swing.*;
import java.awt.*;

import java.util.ArrayList;
import java.util.List;


public class TankClient extends JFrame{
	public static int GAME_WIDTH;                                         //��Ϸ���ڿ���
	public static int GAME_HEIGHT;                                        //��Ϸ���ڸ߶�
	private static int x, y;                                              //��Ϸ����λ��
	
	List<Boom> booms = new ArrayList<Boom>();                             //��ը����
	List<Tank> tanks = new ArrayList<Tank>();                             //�з�̹�˼���
	List<Missile> missiles = new ArrayList<Missile>();                    //�ӵ�����
	Tank myTank = new Tank(10, 400, true,Tank.Direction.STOP, this);     // ̹������λ�ã��û�����ʼ���򣬱�����������
	Wall w1 = new Wall(100, 200, 20, 150, this), w2 = new Wall(300, 100, 300, 20,this);
	//���������ǽ
	
	Blood b = new Blood();
	
	public TankClient(int x, int y, int w, int h){                        //̹�˶˹��캯��
		TankClient.x = x; 
		TankClient.y = y;
		GAME_WIDTH = w;
		GAME_HEIGHT = h;
	}  
	public TankClient(String s, int x, int y, int w, int h){              //̹�˶˹��캯��
		this(x, y, w, h);
		init(s, TankClient.x, TankClient.y, w, h);                        //��ʼ����Ϸ�������֡�����λ�á����ڿ��Ⱥ͸߶�
	}		
	//------------------------------- 
	Image offScreenImage = null; 										  //����ͼƬ
	/*public void update(Graphics g) {                                    //��Ļ����g 
		super.update(g); 
		if(offScreenImage == null) { 
			offScreenImage = this.createImage(GAME_WIDTH, GAME_HEIGHT);   //��С��Ӧ������ΪҪ���ǵĴ�С  
		}  
		Graphics gOffScreen = offScreenImage.getGraphics();               //����Ļ�󻭱�gOffScreen����ȡ���ͼƬ��ͼ��
		paint(gOffScreen);                                                //�ѻ��ʴ��ݸ�paint������Ȼ��һ���Գ��ֳ���
		g.drawImage(offScreenImage, 0, 0, null); 
	} 
	//------------------------------//���ڻ滭                             					  update�������ᱻ����  ����ע��   */
	public void paint(Graphics g) { 
		//super.paint(g); 
		if(offScreenImage == null) { 
			offScreenImage = this.createImage(GAME_WIDTH, GAME_HEIGHT);   //ͼƬ(offScreenImage)�Ĵ�С��Ӧ������ΪҪ���ǵĴ�С  
		} 
		Graphics gOffScreen = offScreenImage.getGraphics();               //����Ļ�󻭱�gOffScreen����ȡ���ͼƬ�Ļ���
		gOffScreen.setColor(Color.GREEN);                                 //���û��ʵı���ɫ
		gOffScreen.fillRect(0, 0, GAME_WIDTH, GAME_HEIGHT);               //��Ҫ����λ��  ��Ȼ����ʱ����ͼ����ƫ��
		gOffScreen.setColor(Color.BLACK);                                 //�ٴ����û��ʵ���ɫΪ��ɫ  ���������������
		gOffScreen.drawString("ս���ӵ������� "+missiles.size(), 10, 50);//�ڵ�����
		gOffScreen.drawString("��ը������ "+booms.size(), 10, 70);      //��ը����
		gOffScreen.drawString("�з�̹�˻�ʣ�� "+tanks.size(), 10, 90);      //̹�˸���
		gOffScreen.drawString("̹������ֵ�� "+myTank.getLife(), 10, 110);      //̹�˸���
		for(int i = 0; i < missiles.size();i++){                          //�������е��ӵ�
			Missile m = missiles.get(i);
			m.hitTanks(tanks);											  //���е��ӵ��Ǵ�з�̹��   �Ƿ����  fire������������
			m.hitTank(myTank);											  //���е��ӵ��Ǵ��ҷ�̹��
			m.hitWall(w1);
			m.hitWall(w2);
			m.draw(gOffScreen);
		}
		for(int i = 0; i< booms.size(); i++){                             //�������еı�ը
			Boom bm = booms.get(i);
			bm.draw(gOffScreen);
		}
		for(int i = 0; i < tanks.size(); i++){                            //�������еĵж�̹��
			Tank t = tanks.get(i);
			t.collidesWithWall(w1);    // Ҫע��tanks�ǵз�̹�˼���   ����������ֻ�ез�̹�˺�ǽ�Ż������Ч����
			t.collidesWithWall(w2);
			t.collidesWithTanks(tanks);
			t.draw(gOffScreen);
		}
		myTank.eat(b);
		myTank.draw(gOffScreen);                                          //�����ҵ�̹��
		myTank.collidesWithWall(w1);//������д��д���Ծ����ҿɲ��������ף�����
		myTank.collidesWithWall(w2);
		w1.draw(gOffScreen);
		w2.draw(gOffScreen);
		b.draw(gOffScreen);
		g.drawImage(offScreenImage, 0, 0, null);                          //������ͼ(offScreenImage), ����g������
	}
	//------------------------------���ڳ�ʼ��
	public void init(String s, int x, int y, int w, int h){
		for(int i = 0; i < 10; i++) {                                     //���̹�˼�����ÿһ��̹�˶���һ���Լ���x��y(��̹�˵�λ��),�����ڵ���draw����ʱ��λ�ò����໥Ӱ��
			tanks.add(new Tank(50+40*(i+1), 50, false, Tank.Direction.D, this));
		}
		setTitle(s);                                                      //���ô��ڱ���
		setVisible(true);  												  //���ô��ڿ���
		setResizable(false); 											  //���ô��ڴ�С���ɸ�
		setLocation(x, y); 												  //���ô���λ��
		setSize(w, h);  												  //���ô��ڿ��Ⱥ͸߶�
		setLayout(new FlowLayout());   									  //���ô��ڲ��ַ�ʽ
		setDefaultCloseOperation(EXIT_ON_CLOSE); 						  //���ô��ڹرղ���
		//getContentPane().setVisible(false); 							  //ʹ������岻����ʾ    ��ò�����ʹ��
		getContentPane().setBackground(Color.GREEN);
		this.addKeyListener(new KeyMonitor());  						  //�Ե�ǰ�������Ӱ���������
		new Thread(new PaintThread()).start();							  //�����̶߳���new����,������start()���������̡߳�
	}
	//----------------------------�ڲ���
	private class PaintThread implements Runnable{          			  //�����߳����ػ�   �����ĺô���ʵʱ���� 
		public void run() {												  //�̳нӿ�  ��Ҫʵ���������еķ���(Runnable�ӿ���ֻ��һ������)
			while(true) {
				repaint();												  //��Ϊ���ڼ̳е���JFrame�������������������ػ�ʱֻ�����paint����
				try {
					Thread.sleep(50);                                     //����߳̿������ػ����ҹ̶�ÿ50�����ػ�һ��
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
		
	}

	private class KeyMonitor extends KeyAdapter {                         //��KeyAdapter��̳еļ��̼�����
		public void keyPressed(KeyEvent e) {							  //���¼����¼�����
			myTank._KeyPressed(e);
		}
		public void keyReleased(KeyEvent e) {							  //��������¼�����
			myTank._KeyReleased(e);
		}
	}
}