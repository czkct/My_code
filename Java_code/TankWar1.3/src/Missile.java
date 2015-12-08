import java.awt.Color;
import java.awt.Graphics;

public class Missile {
	public static final int XSPEED = 10;
	public static final int YSPEED = 10;
	
	public static final int WIDTH = 10;
	public static final int HEIGHT = 10;
	
	private TankClient tc2;
	
	private boolean live = true;
	
	public boolean isLive() {
		return live;
	}
	int x, y;
	Tank.Direction dir;
	public Missile(){}
	public Missile(int x, int y, Tank.Direction dir, TankClient tc) {
		super();
		this.x = x;
		this.y = y;
		this.dir = dir;
		this.tc2 = tc;
	}
	public void draw(Graphics g){
		Color c = g.getColor(); 
		g.setColor(Color.BLACK);
		g.fillOval(x, y, WIDTH, HEIGHT);
		g.setColor(c);
		
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
	
	
}