import java.awt.Color;
import java.awt.FlowLayout;//布局是在awt中的！！！
import java.awt.Graphics;
import java.awt.event.*;

import javax.swing.*;
import java.awt.*;

import java.util.ArrayList;
import java.util.List;


public class TankClient extends JFrame{
	public static int GAME_WIDTH;   //游戏窗口宽度
	public static int GAME_HEIGHT;  //游戏窗口高度
	
	private static int x, y;     //游戏窗口位置
	
	List<Boom> booms = new ArrayList<Boom>();   //爆炸集合
	List<Tank> tanks = new ArrayList<Tank>();   //敌方坦克集合
	List<Missile> missiles = new ArrayList<Missile>();   //子弹集合
	
	public TankClient(int x, int y, int w, int h){
		TankClient.x = x;
		TankClient.y = y;
		GAME_WIDTH = w;
		GAME_HEIGHT = h;
	}   //坦克端构造函数
	public TankClient(String s, int x, int y, int w, int h){  //坦克端构造函数
		this(x, y, w, h);
		init(s, TankClient.x, TankClient.y, w, h);   //初始化游戏窗口名字、窗口位置、窗口宽度和高度
	}					// 坦克坐标位置，  坦克好坏，         坦克初始方向，                   传出去的引用
	Tank myTank = new Tank(150, 150, true,Tank.Direction.STOP, this);
//	Tank enemTank = new Tank(50, 50, false, this);
	
	
	
	
	//------------------------------- 
	Image offScreenImage = null; 
	public void update(Graphics g) {        //屏幕画笔g 
		super.update(g); 
		if(offScreenImage == null) { 
			offScreenImage = this.createImage(GAME_WIDTH, GAME_HEIGHT); 
			                                    //大小就应该设置为要覆盖的大小  
		} 
		//幕后画笔gOffScreen 
		Graphics gOffScreen = offScreenImage.getGraphics(); //获取这个图片的图像
		paint(gOffScreen);     //把画笔传递给paint方法，然后一次性呈现出来
		g.drawImage(offScreenImage, 0, 0, null); 
	} 
	//------------------------------//窗口绘画 
	public void paint(Graphics g) { 
		//super.paint(g); 
		if(offScreenImage == null) { 
			offScreenImage = this.createImage(GAME_WIDTH, GAME_HEIGHT); 	                                    //大小就应该设置为要覆盖的大小  
		} 
		//幕后画笔gOffScreen 
		Graphics gOffScreen = offScreenImage.getGraphics(); //获取这个图片的图像
		//paint(gOffScreen);     //把画笔传递给paint方法，然后一次性呈现出来
		gOffScreen.setColor(Color.GREEN);  //设置新画笔的背景色
		gOffScreen.fillRect(TankClient.x, TankClient.y, GAME_WIDTH, GAME_HEIGHT);  //画好背景
		//super.paint(gOffScreen); 
		gOffScreen.setColor(Color.BLACK);  //还原画笔的颜色
		
		//炮弹个数
		gOffScreen.drawString("missiles.count"+missiles.size(), 10, 50);
		gOffScreen.drawString("booms count"+booms.size(), 10, 70);
		gOffScreen.drawString("tanks count"+tanks.size(), 10, 90);
		
		for(int i = 0; i < missiles.size();i++){
			Missile m = missiles.get(i);
			m.hitTanks(tanks);
			m.draw(gOffScreen);
		}//画出所有的子弹
		
		for(int i = 0; i< booms.size(); i++){
			Boom bm = booms.get(i);
			bm.draw(gOffScreen);
		}//画出所有的爆炸
		
		for(int i = 0; i < tanks.size(); i++){
//			Tank t = tanks.get(i);
//			t.draw(g);
			tanks.get(i).draw(gOffScreen);
		}//画出所有的敌对坦克
		
		myTank.draw(gOffScreen);
	//	enemTank.draw(g);
		g.drawImage(offScreenImage, 0, 0, null); 
	}
	//------------------------------窗口初始化
	public void init(String s, int x, int y, int w, int h){
		for(int i = 0; i < 10; i++) {
			tanks.add(new Tank(50+40*(i+1), 50, false, Tank.Direction.D, this));
		}
		setTitle(s);  //设置窗口标题
		setVisible(true);  //设置窗口可显
		setResizable(false);  //设置窗口大小不可改
		setLocation(x, y);   //设置窗口位置
		setSize(w, h);   //设置窗口宽度和高度
		setLayout(new FlowLayout());   //设置窗口布局方式
		setDefaultCloseOperation(EXIT_ON_CLOSE);  //设置窗口关闭操作
		//getContentPane().setVisible(false);  //使内容面板不可显示    最好不这样使用
		getContentPane().setBackground(Color.GREEN);
		
		this.addKeyListener(new KeyMonitor());  //对当前窗口添加按键监听器
		new Thread(new PaintThread()).start();//匿名线程对象被new出来,并调用start()方法启动线程。
	}
	//----------------------------内部类
	private class PaintThread implements Runnable{ //调用线程来重画   这样的好处是实时更新 
		//继承接口  就要实现其中所有的方法
		public void run() {
			while(true) {
				repaint();//因为窗口继承的是JFrame这个轻量级组件，所以重画时值调用paint方法
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
