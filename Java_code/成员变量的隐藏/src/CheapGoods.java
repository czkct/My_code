
public class CheapGoods extends Goods {//CheapGoods是Goods的子类
	public int weight;   //父类中也有一个weight变量;不过类型不同
	public void newSetWeight(int w) {
		weight = w;
		System.out.println("int型的weight="+weight);
	}
	public double newGetPrice() {
		double price = weight*10;
		return price;
	}
}
