class Factory {
	public HomeEletricity make() {  //方法的烈性是HomeEletricity类
		HomeEletricity machine = new HomeEletricity();
		return machine;
	}
}
class TVFactory extends Factory {  //重写犯法的类型是HomeEletricity类的子类：Television
	public Television make() {
		Television tv = new Television();
		tv.setWeight(21);
		return tv;
	}
}
class IceboxFactory extends Factory {  //重写犯法的类型是HomeEletricity类的子类：Icebox
	public Icebox make() {
		Icebox icebox = new Icebox();
		icebox.setWeight(67);
		return icebox;
	}
}
public class Example5_6 {
	public static void main(String[] args) {
		TVFactory factory1 = new TVFactory();
		Television tv = factory1.make();   //factory1调用重写方法
		tv.showMess();
		IceboxFactory factory2 = new IceboxFactory();
		Icebox icebox = factory2.make();
		icebox.showMess();
	}
}
