import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.ArrayList;
import java.util.List;
public class Missile {
	public static final int XSPEED = 10;
	public static final int YSPEED = 10;
	
	public static final int WIDTH = 10;
	public static final int HEIGHT = 10;
	
	private TankClient tc;
	private boolean live = true;
	
	private boolean good;   //添加变量   子弹的好坏！
	
	//子弹是否活着
	public boolean isLive() {
		return live;
	}
	int x, y;  //子弹的位置
	Tank.Direction dir;
	public Missile(int x, int y,boolean good, Tank.Direction dir){
		this.x = x;
		this.y = y;
		this.good = good;
		this.dir = dir;
	}
	public Missile(int x, int y,boolean good, Tank.Direction dir, TankClient tc) {
		//super();
		this(x, y,good,dir);
		this.tc = tc;
	}
	public void draw(Graphics g){
		if(!this.live) {
			tc.missiles.remove(this);
			return ;
		}
		Color c = g.getColor(); //获取画笔的颜色
		g.setColor(Color.BLACK);  
		g.fillOval(x, y, WIDTH, HEIGHT);
		g.setColor(c);   //还原画笔的颜色
		
		move();
	}
	private void move() {
		switch(dir){
		case L: x -= XSPEED; break;
		case LU: x -= XSPEED; y -= YSPEED; break;
		case U: y -= YSPEED; break;
		case RU: x += XSPEED; y -= YSPEED; break;
		case R: x += XSPEED;break;
		case RD: x += XSPEED; y += YSPEED; break;
		case D: y += YSPEED; break;
		case LD: x -= XSPEED; y += YSPEED; break;
		}
		if(x<0 || y<0 || x>TankClient.GAME_WIDTH||y>TankClient.GAME_HEIGHT){
			live = false;
		}
	}
	//碰撞检测的辅助类Rectangle
	public Rectangle getRect(){
		return new Rectangle(x, y, WIDTH, HEIGHT);
	}
	//打坦克
	public boolean hitTank(Tank t){
		if(this.live && this.getRect().intersects(t.getRect()) && t.isLive() && this.good!=t.isGood()){//如果子弹活着   this.good!=t.good不是一路人才会打
			t.setLive(false);
			this.live = false;
			Boom bm = new Boom(x, y, tc);
			tc.booms.add(bm);
			return true;
		}
		return false;
	}
	
	public boolean hitTanks(List<Tank> tanks) {
		for(int i = 0; i < tanks.size(); i++) {
			if(hitTank(tanks.get(i))){
				return true;
			}
		}
		return false;
	}
	
	
}
