import java.awt.Color;
import java.awt.FlowLayout;//布局是在awt中的！！！
import java.awt.Graphics;
import java.awt.event.*;

import javax.swing.*;
import java.awt.*;

public class TankClient extends JFrame{
	public TankClient(){}
	public TankClient(String s, int x, int y, int w, int h){
		init(s, x, y, w, h);//初始化窗口
	}
	int x = 50, y = 50;
	//-------------------------------
	Image offScreenImage = null;
	public void update(Graphics g) {  //屏幕画笔g
		super.update(g);
		if(offScreenImage == null) { 
			offScreenImage = this.createImage(500, 600);
			//大小就应该设置为要覆盖的大小
		}
		 //幕后画笔gOffScreen
		Graphics gOffScreen = offScreenImage.getGraphics();
		paint(gOffScreen);
		g.drawImage(offScreenImage, 0, 0, null);
	}
	//------------------------------//窗口绘画
	public void paint(Graphics g) {
		super.paint(g);
		Color c = g.getColor();
		g.setColor(Color.RED);
		g.fillOval(x, y, 30, 40);  //画椭圆
		g.setColor(c);
	}
	//------------------------------窗口初始化
	public void init(String s, int x, int y, int w, int h){
		setTitle(s);
		setVisible(true);
		setResizable(false);
		setLocation(x, y);
		setSize(w, h);
		setLayout(new FlowLayout());
		this.addWindowListener(new WindowAdapter(){ 
			public void windowClosing(WindowEvent e){
			}
		});
		getContentPane().setVisible(false);
		setBackground(Color.GREEN);
		
		this.addKeyListener(new KeyMonitor());
		
		new Thread(new PaintThread()).start();
	}
	//----------------------------内部类
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

		@Override
		public void keyPressed(KeyEvent e) {
			int key = e.getKeyCode();
			switch(key) {
			case KeyEvent.VK_LEFT:  x -= 5; break;
			case KeyEvent.VK_UP:    y -= 5; break;
			case KeyEvent.VK_RIGHT: x += 5; break;
			case KeyEvent.VK_DOWN:  y += 5; break;
			}
		}
		
	}
}
