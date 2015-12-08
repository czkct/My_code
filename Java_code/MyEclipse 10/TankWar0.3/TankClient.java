import java.awt.Color;
import java.awt.FlowLayout;//布局是在awt中的！！！
import java.awt.Graphics;
import java.awt.event.*;

import javax.swing.*;
import java.awt.*;

public class TankClient extends JFrame{

	public void paint(Graphics g) {
		super.paint(g);
		Color c = g.getColor();
		g.setColor(Color.RED);
		g.fillOval(50, 50, 30, 40);  //位置和长宽
		g.setColor(c);
	}
	public TankClient(){}
	public TankClient(String s, int x, int y, int w, int h){
		init(s, x, y, w, h);//初始化窗口
	}
	
	//JLabel label1;
	public void init(String s, int x, int y, int w, int h){
		setTitle(s);
		setVisible(true);
		setResizable(false);
		setLocation(x, y);
		setSize(w, h);
		//setDefaultCloseOperation(EXIT_ON_CLOSE);
		//上面这句也是设置窗口关闭
		setLayout(new FlowLayout());//设置格式
		//测试----label1 = new JLabel("6666");
		//测试----add(label1);
		this.addWindowListener(new WindowAdapter(){ //关于接口的匿名类实例用来做监视器
			public void windowClosing(WindowEvent e){
//测试语句		TankClient tc = new TankClient("hahah", 100, 100, 100, 100);
//				for(int i = 0; i < 50*1e8; i++);
				System.exit(0);
			}
		});
		//当关闭窗口时WindowEvent类自动创建一个事件对象，并将它传递给
		//windowClosing(WindowEvent e)方法中的参数e，监视器将自动
		//调用方法：windowClosing(WindowEvent e)对发生的事件做出处理
//		要想实现WindowListener接口，就必须要写出这个接口中的所有的7方法，
//		无论这7中方法你觉得有用还是没有用你都要把他们写出来，少一个都不幸。
//		但是我们用了WindowAdapter适配器后，
//		我们就可以把我们认为所需要的接口的方法写出来即可。
		//注意  类在实现接口时，必须实现接口中所有的方法。。。
		//getContentPane().setBackground(Color.red);
		getContentPane().setVisible(false);
		setBackground(Color.GREEN);//设置背景色
	}
}
