package com.iotek.shu;

import java.awt.Color;
import java.awt.Font;
import java.awt.Point;
import java.awt.Toolkit;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class DTS extends JFrame implements Runnable{
	private int num = 0;
	private JLabel[] mouses;
	private ImageIcon imgMouse;
	private JLabel back;
	private JLabel jtf;
	public DTS(){
		this.setResizable(true);
		this.getContentPane().setLayout(null);
		this.setTitle("我的打地鼠游戏");
		back = new JLabel();
		back.setBounds(0,-35, 600, 438);
		
		this.setBounds(300, 100, 600, 438);
		this.setCursor(Toolkit.getDefaultToolkit().createCustomCursor(Toolkit.getDefaultToolkit().getImage("src/com/iotek/shu/1.png"), new Point(3,3), "self"));
		ImageIcon icon = new ImageIcon(this.getClass().getResource("3.jpg"));
		back.setIcon(icon);
		imgMouse = new ImageIcon(this.getClass().getResource("2.png"));
		mouses = new JLabel[9];
		for(int i=0;i<9;i++){
			mouses[i] = new JLabel();
			mouses[i].setSize(imgMouse.getIconWidth(), imgMouse.getIconHeight());
			//mouses[i].setIcon(imgMouse);
			mouses[i].addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					Object object = e.getSource();
					if(object instanceof JLabel){
						JLabel label = (JLabel) object;
						if(label.getIcon()!=null){
							num++;
							jtf.setText("您的得分是："+num+ "分");
						}
						label.setIcon(null);
					}
				}
			});
			this.getContentPane().add(mouses[i]);
			
		}
		jtf = new JLabel();
		jtf.setBounds(360,10,230,50);
		jtf.setFont(new Font("", 20, 25));
		jtf.setForeground(Color.blue);
		jtf.setText("您的得分是："+" "+ "分");
		
		mouses[0].setLocation(88, 53); // 设置每个标签的位置
		mouses[1].setLocation(240, 53);
		mouses[2].setLocation(390, 53);
		
		mouses[3].setLocation(55, 160);
		mouses[4].setLocation(245, 160);
		mouses[5].setLocation(430, 160);
		
		mouses[6].setLocation(36, 296);
		mouses[7].setLocation(230, 296);
		mouses[8].setLocation(445, 296);
		this.getContentPane().add(jtf);
		this.getContentPane().add(back);
		this.setVisible(true);
		this.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
	}
	
	public static void main(String[] args) {
		DTS d1 = new DTS();
		Thread t1 = new Thread(d1);
		t1.start();
	}

	@Override
	public void run() {
		while(true){//flash动画  flex 
			try {
				Thread.sleep(500);
				int index = (int) (Math.random()*9);
				if(mouses[index].getIcon()==null){
					mouses[index].setIcon(imgMouse);
					Thread.sleep(800);
					if(mouses[index].isShowing()){
						mouses[index].setIcon(null);
					}
				}
				
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}
}
