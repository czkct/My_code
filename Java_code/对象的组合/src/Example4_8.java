
public class Example4_8 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Circle circle = new Circle();
		circle.setRadius(29);
		
		
		Circular circular = new Circular();
		circular.setBottom(circle);
		circular.setHeight(128.76);
		System.out.println("Բ׶��Բ�İ뾶��"+circular.getBottomRadius());
		System.out.printf("Բ׶�����������3λС������%5.3f\n", circular.getVolme());
		circular.setBottomRadius(208);
		System.out.println("Բ׶��Բ�İ뾶��"+circular.getBottomRadius());
		System.out.printf("Բ׶�����������3λС������%5.3f\n", circular.getVolme());
	}

}
