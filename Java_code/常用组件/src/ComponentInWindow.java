import java.awt.*;
import javax.swing.*;
public class ComponentInWindow extends JFrame{
	JTextField text;  //单行文本框
	JButton button;   // 按钮
	JCheckBox checkbox1, checkbox2, checkbox3;   //多选框
	JRadioButton radio1, radio2;  //单选框
	ButtonGroup group;   // ？？？
	JComboBox comBox; //？？？
	JTextArea area; //多行文本框
	public ComponentInWindow(){
		init();
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	void init(){
		setLayout(new FlowLayout());
		//-------------------------
		add(new JLabel("文本框："));
		text = new JTextField(10);
		add(text);
		//-------------------------
		add(new JLabel("按钮："));
		button = new JButton("确定");
		add(button);
		//----------------------
		add(new JLabel("选择框："));
		checkbox1 = new JCheckBox("喜欢音乐");
		checkbox2 = new JCheckBox("喜欢旅游");
		checkbox3 = new JCheckBox("喜欢篮球");
		add(checkbox1);
		add(checkbox2);
		add(checkbox3);
		//----------------------
		add(new JLabel("单选按钮:"));
		group = new ButtonGroup();
		radio1 = new JRadioButton("nan");
		radio2 = new JRadioButton("nv");
		group.add(radio1);
		group.add(radio2);
		add(radio1);
		add(radio2);
		//-------------------------
		add(new JLabel("下拉列表："));
		comBox = new JComboBox();
		comBox.addItem("音乐天地");
		comBox.addItem("无数天地");
		comBox.addItem("xiangqi");
		add(comBox);
		//-------------------------
		add(new JLabel("wenbenqu"));
		area = new JTextArea(6,12);
		add(new JScrollPane(area));
	}
}
