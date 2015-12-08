import javax.swing.*;
import static javax.swing.JFrame.*;
public class WindowBoxLayout extends JFrame{
	Box baseBox, boxV1, boxV2;
	JPanel boxV3 = new JPanel();
	public WindowBoxLayout(){
		setLayout(new java.awt.FlowLayout());
		init();
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	void init(){
		boxV1 = Box.createVerticalBox();//获得列式盒式布局盒式容器
		boxV1.add(new JLabel("姓名"));
		boxV1.add(Box.createVerticalStrut(8));//高度为8的垂直支撑
		boxV1.add(new JLabel("email"));
		boxV1.add(Box.createVerticalStrut(8));
		boxV1.add(new JLabel("职业"));
		
		boxV2 = Box.createVerticalBox();//获得列式盒式布局盒式容器
		boxV2.add(new JTextField(10));//单行文本框
		boxV2.add(Box.createVerticalStrut(8));
		boxV2.add(new JTextField(10));
		boxV2.add(Box.createVerticalStrut(8));
		boxV2.add(new JTextField(10));
		
		//boxV3.setLayout(null);
		JTextField c = new JTextField(10);
		JButton button = new JButton("确定");
		boxV3.add(button);
		boxV3.add(c);
		c.setBounds(0, 0, 100, 100);
		button.setBounds(66, 66, 300, 300);
		
		
		baseBox = Box.createHorizontalBox();//获得行式盒式布局盒式容器
		baseBox.add(boxV1);
		baseBox.add(Box.createHorizontalStrut(10));
		baseBox.add(boxV2);
		baseBox.add(Box.createHorizontalStrut(10));
		baseBox.add(boxV3);
		add(baseBox);
	}
}
