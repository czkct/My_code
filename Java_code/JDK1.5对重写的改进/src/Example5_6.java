class Factory {
	public HomeEletricity make() {  //������������HomeEletricity��
		HomeEletricity machine = new HomeEletricity();
		return machine;
	}
}
class TVFactory extends Factory {  //��д������������HomeEletricity������ࣺTelevision
	public Television make() {
		Television tv = new Television();
		tv.setWeight(21);
		return tv;
	}
}
class IceboxFactory extends Factory {  //��д������������HomeEletricity������ࣺIcebox
	public Icebox make() {
		Icebox icebox = new Icebox();
		icebox.setWeight(67);
		return icebox;
	}
}
public class Example5_6 {
	public static void main(String[] args) {
		TVFactory factory1 = new TVFactory();
		Television tv = factory1.make();   //factory1������д����
		tv.showMess();
		IceboxFactory factory2 = new IceboxFactory();
		Icebox icebox = factory2.make();
		icebox.showMess();
	}
}
