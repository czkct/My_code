import java.awt.FlowLayout;  //��������awt�еģ�����
import java.awt.event.*;
import javax.swing.JFrame;  //��J�Ķ�����swing����
import javax.swing.JLabel;

public class multi extends JFrame{
	JLabel label1;
	public multi(){}
	public multi(String s, int x, int y, int w, int h){
		init(s, x, y, w, h);//��ʼ������
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
		addWindowListener(new WindowAdapter(){ //������ʵ��������������
			public void windowClosing(WindowEvent e){
				System.exit(0);
			}
		});
	}
}
