
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
	//���ܷ�����
	public void speak() {
		System.out.println(name+"���ǳ��ǣ�"+Nickname+",�Ա��ǣ�"+sex);
		System.out.println(getName()+"���ǳ��ǣ�"+getNickname()+",�Ա��ǣ�"+getSex());
	}
}
