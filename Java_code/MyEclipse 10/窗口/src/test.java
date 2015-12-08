import javax.swing.*;//这个包中有JComponent这个组件类(Component)的间接子类
import static javax.swing.JFrame.*;//引入JFrame的静态常量
//JFrame类的实例就是一个底层容器，即通常所说的窗口
public class test {
	public static void main(String[] args){
		JFrame window1 = new JFrame("撤销窗口");
		JFrame window2 = new JFrame("退出程序");
		window1.setBounds(60, 100, 188, 108);  //设置容器大小
		window2.setBounds(260, 100, 188, 108);
		window1.setVisible(true);//设置窗口可见
		window1.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		window2.setVisible(true);
		window2.setDefaultCloseOperation(EXIT_ON_CLOSE);
//setDefaultCloseOperation()方法的作用是设置单击窗口右上角的关闭图标后，程序会做出怎样的处理。
	}
}
