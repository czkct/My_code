
public class Example4_17 {
	public static void main(String[] args) {
		Yuan circle = new Yuan();
		circle.setRadius(123);
		System.out.println("circle的半径："+circle.getRadius());
		//circle.radius = -523;是非法的
		circle.setRadius(-523);
		System.out.println("circle的半径："+circle.getRadius());
	}
}
