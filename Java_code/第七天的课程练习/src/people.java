
public class people extends biology implements chouyan , dance {
	private int time;
	//构造
	people() {
	}
	people(int time){
		this.time = time;
	}
	//set、get
	public void setTime(int time) {
		this.time = time;
	}
	public int life() {//抽象函数的实现
		return time;
	}
	//实现接口
	public void dong() {
		System.out.print("bengbengbeng");
	}
	public void maoyan() {
		System.out.print("dududududu");
	}
	//表达
	public void show() {
		maoyan();
		System.out.print(",");
		dong();
		System.out.print("我的生命有"+life()+"岁！");
		if(life()>100) System.out.println("我是人精！");
	}
}
