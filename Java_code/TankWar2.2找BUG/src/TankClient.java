import java.awt.Color;
import java.awt.FlowLayout;//布局是在awt中的！！！
import java.awt.Graphics;
import java.awt.event.*;

import javax.swing.*;
import java.awt.*;

import java.util.ArrayList;
import java.util.List;


public class TankClient extends JFrame{
	public static int GAME_WIDTH;                                         //游戏窗口宽度
	public static int GAME_HEIGHT;                                        //游戏窗口高度
	private static int x, y;                                              //游戏窗口位置
	
	List<Boom> booms = new ArrayList<Boom>();                             //爆炸集合
	List<Tank> tanks = new ArrayList<Tank>();                             //敌方坦克集合
	List<Missile> missiles = new ArrayList<Missile>();                    //子弹集合
	
	public TankClient(int x, int y, int w, int h){                        //坦克端构造函数
		TankClient.x = x; 
		TankClient.y = y;
		GAME_WIDTH = w;
		GAME_HEIGHT = h;
	}  
	public TankClient(String s, int x, int y, int w, int h){              //坦克端构造函数
		this(x, y, w, h);
		init(s, TankClient.x, TankClient.y, w, h);                        //初始化游戏窗口名字、窗口位置、窗口宽度和高度
	}		
	Tank myTank = new Tank(150, 150, true,Tank.Direction.STOP, this);     // 坦克坐标位置，好坏，初始方向，本类对象的引用
	//------------------------------- 
	Image offScreenImage = null; 										  //设置图片
	/*public void update(Graphics g) {                                    //屏幕画笔g 
		super.update(g); 
		if(offScreenImage == null) { 
			offScreenImage = this.createImage(GAME_WIDTH, GAME_HEIGHT);   //大小就应该设置为要覆盖的大小  
		}  
		Graphics gOffScreen = offScreenImage.getGraphics();               //设置幕后画笔gOffScreen并获取这个图片的图像
		paint(gOffScreen);                                                //把画笔传递给paint方法，然后一次性呈现出来
		g.drawImage(offScreenImage, 0, 0, null); 
	} 
	//------------------------------//窗口绘画                             					  update方法不会被调用  所以注释   */
	public void paint(Graphics g) { 
		//super.paint(g); 
		if(offScreenImage == null) { 
			offScreenImage = this.createImage(GAME_WIDTH, GAME_HEIGHT);   //图片(offScreenImage)的大小就应该设置为要覆盖的大小  
		} 
		Graphics gOffScreen = offScreenImage.getGraphics();               //设置幕后画笔gOffScreen并获取这个图片的画笔
		gOffScreen.setColor(Color.GREEN);                                 //设置画笔的背景色
		gOffScreen.fillRect(0, 0, GAME_WIDTH, GAME_HEIGHT);               //不要设置位置  不然贴的时候贴图会有偏移
		gOffScreen.setColor(Color.BLACK);                                 //再次设置画笔的颜色为黑色  用来画下面的内容
		gOffScreen.drawString("missiles count： "+missiles.size(), 10, 50);//炮弹个数
		gOffScreen.drawString("booms count： "+booms.size(), 10, 70);      //爆炸个数
		gOffScreen.drawString("tanks count： "+tanks.size(), 10, 90);      //坦克个数
		for(int i = 0; i < missiles.size();i++){                          //画出所有的子弹
			Missile m = missiles.get(i);
			m.hitTanks(tanks);
			m.draw(gOffScreen);
		}
		for(int i = 0; i< booms.size(); i++){                             //画出所有的爆炸
			Boom bm = booms.get(i);
			bm.draw(gOffScreen);
		}
		for(int i = 0; i < tanks.size(); i++){                            //画出所有的敌对坦克
			Tank t = tanks.get(i);
			t.draw(gOffScreen);
		}
		myTank.draw(gOffScreen);                                          //画好我的坦克
		g.drawImage(offScreenImage, 0, 0, null);                          //画笔贴图(offScreenImage), 贴到g画笔中
	}
	//------------------------------窗口初始化
	public void init(String s, int x, int y, int w, int h){
		for(int i = 0; i < 10; i++) {
			tanks.add(new Tank(50+40*(i+1), 50, false, Tank.Direction.D, this));
		}
		setTitle(s);                                                      //设置窗口标题
		setVisible(true);  												  //设置窗口可显
		setResizable(false); 											  //设置窗口大小不可改
		setLocation(x, y); 												  //设置窗口位置
		setSize(w, h);  												  //设置窗口宽度和高度
		setLayout(new FlowLayout());   									  //设置窗口布局方式
		setDefaultCloseOperation(EXIT_ON_CLOSE); 						  //设置窗口关闭操作
		//getContentPane().setVisible(false); 							  //使内容面板不可显示    最好不这样使用
		getContentPane().setBackground(Color.GREEN);
		this.addKeyListener(new KeyMonitor());  						  //对当前窗口添加按键监听器
		new Thread(new PaintThread()).start();							  //匿名线程对象被new出来,并调用start()方法启动线程。
	}
	//----------------------------内部类
	private class PaintThread implements Runnable{          			  //调用线程来重画   这样的好处是实时更新 
		public void run() {												  //继承接口  就要实现其中所有的方法(Runnable接口中只有一个方法)
			while(true) {
				repaint();												  //因为窗口继承的是JFrame这个轻量级组件，所以重画时只会调用paint方法
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
