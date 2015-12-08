import java.awt.FlowLayout;  //布局是在awt中的！！！
import java.awt.event.*;
import javax.swing.JFrame;  //带J的都是在swing里面
import javax.swing.JLabel;

public class multi extends JFrame{
	JLabel label1;
	public multi(){}
	public multi(String s, int x, int y, int w, int h){
		init(s, x, y, w, h);//初始化窗口
	}
	public void init(String s, int x, int y, int w, int h){
		setVisible(true);
		setTitle(s);
		setResizable(false);
		setLocation(x, y);  
		setSize(w, h);
		//setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLayout(new FlowLayout());
		label1 = new JLabel("6666");
		add(label1);
		addWindowListener(new WindowAdapter(){ //匿名类实例用来做监视器
			public void windowClosing(WindowEvent e){
				System.exit(0);
			}
		});
	}
}
