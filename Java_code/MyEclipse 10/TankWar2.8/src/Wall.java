import java.awt.*;
public class Wall {
	int x, y, w, h;   //墙的位置  宽度  高度
	TankClient tc;    //保留一个坦克端的引用
	public Wall(int x, int y, int w, int h, TankClient tc) {
		super();
		this.x = x;
		this.y = y;
		this.w = w;
		this.h = h;
		this.tc = tc;
	}
	public void draw(Graphics g){   //画墙
		g.fillRect(x, y, w, h);   //把墙画出来
	}
	
	public Rectangle getRect() {    //碰撞检测类
		return new Rectangle(x, y, w, h);
	}
}


//子弹的速度不能太快墙不能太薄   不然   子弹可能穿墙