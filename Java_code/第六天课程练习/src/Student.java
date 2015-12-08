
public class Student {
	private String name;
	private String Nickname;
	private String sex;
	
	Student(){}
	Student(String name, String Nickname, String sex){
		this.name = name;
		this.Nickname = Nickname;
		this.sex = sex;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getNickname() {
		return Nickname;
	}
	public void setNickname(String nickname) {
		Nickname = nickname;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	//功能方法：
	public void speak() {
		System.out.println(name+"的昵称是："+Nickname+",性别是："+sex);
		System.out.println(getName()+"的昵称是："+getNickname()+",性别是："+getSex());
	}
}
