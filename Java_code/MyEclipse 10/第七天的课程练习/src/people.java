
public class people extends biology implements chouyan , dance {
	private int time;
	//����
	people() {
	}
	people(int time){
		this.time = time;
	}
	//set��get
	public void setTime(int time) {
		this.time = time;
	}
	public int life() {//��������ʵ��
		return time;
	}
	//ʵ�ֽӿ�
	public void dong() {
		System.out.print("bengbengbeng");
	}
	public void maoyan() {
		System.out.print("dududududu");
	}
	//���
	public void show() {
		maoyan();
		System.out.print(",");
		dong();
		System.out.print("�ҵ�������"+life()+"�꣡");
		if(life()>100) System.out.println("�����˾���");
	}
}
