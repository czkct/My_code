import javax.swing.*;
import static javax.swing.JFrame.*;//引入JFrame的静态常量
public class CalWindowMenu extends JFrame{
	JMenuBar menubar;
	JMenu menu1, menu2;
	public CalWindowMenu(){};
	public CalWindowMenu(String s, int x, int y, int w, int h){
		init(s);
		setLocation(x,y); //设置位置
		setSize(w, h); //设置大小
		setVisible(true);  //设置是否可视化
		setDefaultCloseOperation(DISPOSE_ON_CLOSE); // 设置关闭操作
	}
	
	void init(String s){
		setTitle(s);//将此窗体的标题设置为指定的字符串。
		menubar = new JMenuBar();//创建一个菜单条
		menu1 = new JMenu("计算器类型");  //创建两个菜单
		menu2 = new JMenu("大数导入");
		menubar.add(menu1);  //将菜单添加到菜单条
		menubar.add(menu2);
		setJMenuBar(menubar); //将此窗体的菜单栏设置为指定的菜单栏
	}
	
	
}
