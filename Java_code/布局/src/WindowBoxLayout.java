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
		boxV1 = Box.createVerticalBox();//�����ʽ��ʽ���ֺ�ʽ����
		boxV1.add(new JLabel("����"));
		boxV1.add(Box.createVerticalStrut(8));//�߶�Ϊ8�Ĵ�ֱ֧��
		boxV1.add(new JLabel("email"));
		boxV1.add(Box.createVerticalStrut(8));
		boxV1.add(new JLabel("ְҵ"));
		
		boxV2 = Box.createVerticalBox();//�����ʽ��ʽ���ֺ�ʽ����
		boxV2.add(new JTextField(10));//�����ı���
		boxV2.add(Box.createVerticalStrut(8));
		boxV2.add(new JTextField(10));
		boxV2.add(Box.createVerticalStrut(8));
		boxV2.add(new JTextField(10));
		
		//boxV3.setLayout(null);
		JTextField c = new JTextField(10);
		JButton button = new JButton("ȷ��");
		boxV3.add(button);
		boxV3.add(c);
		c.setBounds(0, 0, 100, 100);
		button.setBounds(66, 66, 300, 300);
		
		
		baseBox = Box.createHorizontalBox();//�����ʽ��ʽ���ֺ�ʽ����
		baseBox.add(boxV1);
		baseBox.add(Box.createHorizontalStrut(10));
		baseBox.add(boxV2);
		baseBox.add(Box.createHorizontalStrut(10));
		baseBox.add(boxV3);
		add(baseBox);
	}
}
