import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.ArrayList;
import java.util.List;
//子弹类
public class Missile {
	int x, y;  											//子弹的位置（x,y）
	public static final int XSPEED = 10;   				//子弹单位移动距离（XSPEED，YSPEED）
	public static final int YSPEED = 10;
	public static final int WIDTH = 10;					//子弹宽度（WIDTH），子弹高度（HEIGHT）
	public static final int HEIGHT = 10;				 
	private TankClient tc;								//主控端引用
	private boolean live = true;						//子弹存活状态
	private boolean good;  								//添加变量   子弹的好坏！
	Tank.Direction dir;									//坦克方向引用
	
	//获取子弹存活状态方法
	public boolean isLive() {
		return live;
	}
	
	//构造方法
	public Missile(int x, int y,boolean good, Tank.Direction dir){
		this.x = x;
		this.y = y;
		this.good = good;
		this.dir = dir;
	}
	
	//构造方法
	public Missile(int x, int y,boolean good, Tank.Direction dir, TankClient tc) {
		//super();
		this(x, y,good,dir);
		this.tc = tc;
	}
	
	//子弹绘画方法
	public void draw(Graphics g){
		if(!this.live) {
			tc.missiles.remove(this);                           //子弹死亡就直接从集合中移除
			return ;
		}
		Color c = g.getColor(); 								//获取画笔的颜色
		if(this.good) g.setColor(Color.RED);  					//己方坦克子弹的颜色
		else g.setColor(Color.BLACK);  							//敌方坦克子弹的颜色
		g.fillOval(x, y, WIDTH, HEIGHT);						//子弹形状
		g.setColor(c);   										//还原画笔的颜色
		
		move();													//调用子弹移动方法
	}
	
	//子弹移动方法
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
		if(x<0 || y<0 || x>TankClient.GAME_WIDTH||y>TankClient.GAME_HEIGHT){   //判断子弹不能出界
			live = false;
		}
	}
	
	//碰撞检测的辅助类Rectangle
	public Rectangle getRect(){
		return new Rectangle(x, y, WIDTH, HEIGHT);
	}
	
	//打坦克方法
	public boolean hitTank(Tank t){						//如果子弹活着 碰到了坦克   且坦克状态为存活   且子弹质量和坦克质量为敌对状态  
		if(this.live && this.getRect().intersects(t.getRect()) && t.isLive() && this.good!=t.isGood()){
			if(t.isGood()) {
				t.setLife(t.getLife() - 20);            //好坦克被 子弹打到  每次掉20的血量
				if(t.getLife()<=0) {					//好坦克血量为0时   设置好坦克死亡
					t.setLive(false);
				}
			}
			else {                                     //坏坦克只要被子弹打到就死亡
				t.setLive(false);
			}
			this.live = false;
			Boom bm = new Boom(x, y, tc);
			tc.booms.add(bm);
			return true;
		}
		return false;
	}
	
	//子弹打敌方坦克集合的方法
	public boolean hitTanks(List<Tank> tanks) {
		for(int i = 0; i < tanks.size(); i++) {                         //遍历主控端子弹集合中的每一个子弹
			if(hitTank(tanks.get(i))){
				return true;
			}
		}
		return false;
	}
	
	//子弹碰墙方法
	public boolean hitWall(Wall w){ //撞墙检测
		if(this.live&&this.getRect().intersects(w.getRect())){           //如果子弹存活且碰到了墙
			this.live = false;											 //使子弹死亡
			return true;
		}
		return false;
	}
	
}
