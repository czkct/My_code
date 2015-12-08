class EspecialCar {
	void cautionSound() {
		
	}
}
class PoliceCar extends EspecialCar {
	void cautionSound() {
		System.out.println("zhua..zhua..zhua..");
	}
}
class AmbulanceCar extends EspecialCar {
	void cautionSound() {
		System.out.println("jiu..jiu..jiu..");
	}
}
class FireCar extends EspecialCar {
	void cautionSound() {
		System.out.println("huo..huo..huo..");
	}
}
public class Example5_11 {
	public static void main(String[] args) {
		EspecialCar car = new PoliceCar();
		car.cautionSound();
		car = new AmbulanceCar();
		car.cautionSound();
		car = new FireCar();
		car.cautionSound();
	}
}
