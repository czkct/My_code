
public class ChristmasCard extends Card{
	String content;
	ChristmasCard(String title, String content) {
		//super(title);   ��һ�䲻�ӵ�ǰ����Card�������޲εĹ��캯�����߲�������д����Card�ĺ���
		this.content = content;
	}
	public void showCard() {
		System.out.println("*****"+getTitle()+"*****");
		System.out.printf("%s",content);
	}
}
