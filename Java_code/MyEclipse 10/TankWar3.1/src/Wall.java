import java.awt.*;
//墙类（注意项：子弹的单位移动距离不能太大，墙不能太薄   不然   子弹会穿墙）
public class Wall {
	int x, y, w, h;   												//墙的位置（x,y）  宽度w  高度h
	TankClient tc;   											    //保留一个主控端的引用
	
	//墙的构造方法
	public Wall(int x, int y, int w, int h, TankClient tc) {       
		this.x = x;
		this.y = y;
		this.w = w;
		this.h = h;
		this.tc = tc;
	}
	
	//画墙方法
	public void draw(Graphics g){
		g.fillRect(x, y, w, h);  
	}
	
	//碰撞检测类
	public Rectangle getRect() {    
		return new Rectangle(x, y, w, h);
	}
}