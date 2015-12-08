import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.Image;
import java.io.IOException;
import static javax.swing.JFrame.*;//引入JFrame的静态常量
public class CalWindowMenu extends JFrame{
	JMenuBar menubar;//菜单栏
	JMenu menu1, menu2, menu3;  //菜单  菜单也可以作为一个菜单项
	JMenuItem item11, item12, item21, item22, item31, item32;  //菜单项  菜单项都是单条的
	public CalWindowMenu(){};
	public CalWindowMenu(String s, int x, int y, int w, int h){
		init(s);
		setLocation(x,y); //设置位置
		setSize(w, h); //设置大小
		setVisible(true);  //设置是否可视化
		setDefaultCloseOperation(DISPOSE_ON_CLOSE); // 设置关闭操作
	}
	
	void init(String s){  //添加了窗口图标
		//-----图标
		String path = "/Img/我就是我30.jpg";
		try{
			Image img = ImageIO.read(this.getClass().getResource(path));
			this.setIconImage(img);
		}
		catch(IOException e){
			e.printStackTrace();
		}
		//------
		setTitle(s);//将此窗体的标题设置为指定的字符串。
		menubar = new JMenuBar();//创建一个菜单条
		menu1 = new JMenu("计算器类型");  //创建两个菜单
		menu2 = new JMenu("大数导入");
		menu3 = new JMenu("帮助");
		
		item11 = new JMenuItem("标准型");  //定义并初始化菜单项
		item12 = new JMenuItem("大数型");
		item21 = new JMenuItem("向第一个窗口导入大数文件");
		item22 = new JMenuItem("向第二个窗口导入大数文件");
		item31 = new JMenuItem("查看帮助");
		item32 = new JMenuItem("关于计算器");
		
		menu1.add(item11);  //将菜单项添加到菜单中
		menu1.add(item12);
		menu2.add(item21);
		menu2.add(item22);
		menu3.add(item31);
		menu3.add(item32);
		
		menubar.add(menu1);  //将菜单添加到菜单条
		menubar.add(menu2);
		menubar.add(menu3);
		
		setJMenuBar(menubar); //将此窗体的菜单栏设置为指定的菜单栏
	}
	
	
}
