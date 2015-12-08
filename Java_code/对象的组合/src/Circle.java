
public class Circle {
	double pi = 3.14;
	double radius;
	double getRadius() {
		return radius;
	}
	double getArea() {
		return pi*radius*radius;
	}
	void setRadius(double r) {
		radius = r;
	}
}
