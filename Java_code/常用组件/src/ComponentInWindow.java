import java.awt.*;
import javax.swing.*;
public class ComponentInWindow extends JFrame{
	JTextField text;  //�����ı���
	JButton button;   // ��ť
	JCheckBox checkbox1, checkbox2, checkbox3;   //��ѡ��
	JRadioButton radio1, radio2;  //��ѡ��
	ButtonGroup group;   // ������
	JComboBox comBox; //������
	JTextArea area; //�����ı���
	public ComponentInWindow(){
		init();
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	void init(){
		setLayout(new FlowLayout());
		//-------------------------
		add(new JLabel("�ı���"));
		text = new JTextField(10);
		add(text);
		//-------------------------
		add(new JLabel("��ť��"));
		button = new JButton("ȷ��");
		add(button);
		//----------------------
		add(new JLabel("ѡ���"));
		checkbox1 = new JCheckBox("ϲ������");
		checkbox2 = new JCheckBox("ϲ������");
		checkbox3 = new JCheckBox("ϲ������");
		add(checkbox1);
		add(checkbox2);
		add(checkbox3);
		//----------------------
		add(new JLabel("��ѡ��ť:"));
		group = new ButtonGroup();
		radio1 = new JRadioButton("nan");
		radio2 = new JRadioButton("nv");
		group.add(radio1);
		group.add(radio2);
		add(radio1);
		add(radio2);
		//-------------------------
		add(new JLabel("�����б�"));
		comBox = new JComboBox();
		comBox.addItem("�������");
		comBox.addItem("�������");
		comBox.addItem("xiangqi");
		add(comBox);
		//-------------------------
		add(new JLabel("wenbenqu"));
		area = new JTextArea(6,12);
		add(new JScrollPane(area));
	}
}
