import javax.swing.*;
import static javax.swing.JFrame.*;//引入JFrame的静态常量

public class Cal {
	public static void main(String[] args){
		//0.1
		JFrame window = new JFrame("大数加法计算器-叫兽版");
		window.setBounds(200, 200, 300, 500);//前面两个参数是窗口定位，后面两个参数是窗口大小
		window.setVisible(true);//设置窗口可见
		window.setDefaultCloseOperation(EXIT_ON_CLOSE);//这边如果报错说明没有引入JFrame的静态常量
		//0.2
		JMenuBar menubar = new JMenuBar();//创建一个菜单条
		JMenu menu1, menu2;
		menu1 = new JMenu("文件");
		menu2 = new JMenu("计算器类型");
		menubar.add(menu1);  //将菜单添加到菜单条
		menubar.add(menu2);
		setJMenuBar(menubar);  //报错
		
	}
}
//目的：添加菜单条、菜单、菜单项