import javax.swing.JFrame;
import static javax.swing.JFrame.*;//引入JFrame的静态常量

public class Cal {
	public static void main(String[] args){
		JFrame window = new JFrame("大数加法计算器-叫兽版");
		window.setBounds(200, 200, 300, 500);//前面两个参数是窗口定位，后面两个参数是窗口大小
		window.setVisible(true);//设置窗口可见
		window.setDefaultCloseOperation(EXIT_ON_CLOSE);//这边如果报错说明没有引入JFrame的静态常量
		
	}
}
//目的：建立一个窗口  设置几个基本属性