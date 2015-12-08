
public class person {
	private int high;
	private int weight;
	private int age;
	private String sex;
	
	person(){}
	person(int high, int weight, int age, String sex){
		this.high = high;
		this.weight = weight;
		this.age = age;
		this.sex = sex;
	}
	public int getHigh() {
		return high;
	}
	public void setHigh(int high) {
		this.high = high;
	}
	public int getWeight() {
		return weight;
	}
	public void setWeight(int weight) {
		this.weight = weight;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	@Override
	public String toString() {
		return "person [high=" + high + ", weight=" + weight + ", age=" + age
				+ ", sex=" + sex + "]";
	}
	void show() {
		System.out.println(toString());
	}
	class DU{
		String name;
		int xiaodian;
		public DU() {
			// TODO Auto-generated constructor stub
		}
		public DU(int xiaodian,String name) {
			this.xiaodian = xiaodian; 
			this.name = name;
		}
		@Override
		public String toString() {
			return "DU [name=" + name + ", xiaodian=" + xiaodian + "]";
		}
		void show() {
			System.out.println(toString());
		}
	}
}
