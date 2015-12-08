
public class ChristmasCard extends Card{
	String content;
	ChristmasCard(String title, String content) {
		//super(title);   这一句不加的前提是Card类中有无参的构造函数或者不自行书写构造Card的函数
		this.content = content;
	}
	public void showCard() {
		System.out.println("*****"+getTitle()+"*****");
		System.out.printf("%s",content);
	}
}
