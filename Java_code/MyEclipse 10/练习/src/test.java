class Car {
	String name;
	double price;
}
class Driver {
	String name;
	int age;
	Car c;
	public void driverCar() {
		System.out.println("¿ª³µ");
	}
}

class test{
	public static void main(String[] args) {
		Driver d = new Driver();
		d.name = "adf";
		d.age = 23;
		d.c = new Car();
		d.c.name = " ";
		d.c.price =234;
		d.driverCar();
	}
}