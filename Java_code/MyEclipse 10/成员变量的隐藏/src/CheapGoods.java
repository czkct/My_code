
public class CheapGoods extends Goods {//CheapGoods��Goods������
	public int weight;   //������Ҳ��һ��weight����;�������Ͳ�ͬ
	public void newSetWeight(int w) {
		weight = w;
		System.out.println("int�͵�weight="+weight);
	}
	public double newGetPrice() {
		double price = weight*10;
		return price;
	}
}
