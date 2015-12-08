class ArrayDemo 
{
	public static void main(String[] args) 
	{
		Person[] p=new Person[2];
	//	p[0].person("hahah", 13);
	//	p[1].person("wangwu",12);
		System.out.println(p[0]==null);
	//	p[1].show();
		p[0].show();
	}
}
class Person
{
	private int age;
	private String name;
	Person(String n,int a){
		name=n;
		age=a;
	}
	public void person(String name,int age)
	{
		this.name=name;
		this.age=age;
	}
	public void show()
	{
		System.out.println(name+"...."+age);
	}
}

