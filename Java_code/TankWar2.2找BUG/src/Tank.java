import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;


public class Tank {
	private int x, y;                     //坦克的位置
	
	public static final int XSPEED = 10;  //横向移动长度
	public static final int YSPEED = 10;  //纵向移动长度
	
	public static final int WIDTH = 30;   //坦克的宽度
	public static final int HEIGHT = 30;  //坦克的高度
	
	private boolean live = true;          //坦克的存活状态
	public TankClient tc;                 //声明一个控制端的引用
	private boolean good;                 //坦克的质量好坏
	
	public boolean isLive() {             //获取坦克的存活状态方法
		return live;
	}
	public void setLive(boolean live) {   //设置坦克的存活状态方法
		this.live = live;
	}
	
	private boolean bL = false, bU = false, bR = false, bD = false;    //定义上下左右四个方向的状态量
	enum Direction{L, LU, U, RU, R, RD, D, LD, STOP};            //定义八个方向的量
	private Direction dir = Direction.STOP;                      //初始化默认坦克行走方向
	private Direction ptDir = Direction.D;                       //初始化默认炮管方向
	
	
	public Tank(int x, int y,boolean good) {                     //坦克构造函数
		this.x = x;
		this.y = y;
		this.good = good;
	}
	
	public Tank(int x, int y,boolean good,Direction dir, TankClient tc){   //坦克构造函数
		this(x, y, good);
		this.dir = dir;
		this.tc = tc;
	}
	
	public void draw(Graphics g){               //画坦克的函数
		if(!live) {   //判断是否存活
			if(!good) { 
				tc.tanks.remove(this);    //从集合中删除已经死亡的坦克   这样就不会重画
			}
			return ;
		}
		                                      //不满足前面的if判断就说明  该坦克状态是存活的
		Color c = g.getColor();                 //设置画笔的颜色
		if(good) g.setColor(Color.RED);           //是己方坦克    那么就画成红色
		else g.setColor(Color.BLUE);              //是敌方坦克   设置成蓝色
		g.drawRect(x, y, Tank.WIDTH, Tank.HEIGHT);  //画椭圆
		g.setColor(c);
		
		switch(ptDir){
		case L: g.drawLine(x+Tank.WIDTH/2, y+Tank.HEIGHT/2, x, y+Tank.HEIGHT/2 ); 
			break;
		case LU: g.drawLine(x+Tank.WIDTH/2, y+Tank.HEIGHT/2, x, y ); 
			break;
		case U: g.drawLine(x+Tank.WIDTH/2, y+Tank.HEIGHT/2, x+Tank.WIDTH/2, y); 
			break;
		case RU: g.drawLine(x+Tank.WIDTH/2, y+Tank.HEIGHT/2, x+Tank.WIDTH, y);
			break;
		case R: g.drawLine(x+Tank.WIDTH/2, y+Tank.HEIGHT/2, x+Tank.WIDTH, y+Tank.HEIGHT/2 );
			break;
		case RD: g.drawLine(x+Tank.WIDTH/2, y+Tank.HEIGHT/2, x+Tank.WIDTH, y+Tank.HEIGHT ); 
			break;
		case D: g.drawLine(x+Tank.WIDTH/2, y+Tank.HEIGHT/2, x+Tank.WIDTH/2, y+Tank.HEIGHT ); 
			break;
		case LD: g.drawLine(x+Tank.WIDTH/2, y+Tank.HEIGHT/2, x, y+Tank.HEIGHT ); 
			break;
		}
	}
	//移动
	void move(){
		switch(dir){
		case L: x -= XSPEED; break;
		case LU: x -= XSPEED; y -= YSPEED; break;
		case U: y -= YSPEED; break;
		case RU: x += XSPEED; y -= YSPEED; break;
		case R: x += XSPEED;break;
		case RD: x += XSPEED; y += YSPEED; break;
		case D: y += YSPEED; break;
		case LD: x -= XSPEED; y += YSPEED; break;
		case STOP: break;
		}
		if(this.dir != Direction.STOP){
			this.ptDir = this.dir;
		}
		if(x<0) x = 0;
		if(x+Tank.WIDTH>TankClient.GAME_WIDTH) x = TankClient.GAME_WIDTH-Tank.WIDTH;
		if(y<26) y = 26;
		if(y+Tank.HEIGHT>TankClient.GAME_HEIGHT) y = TankClient.GAME_HEIGHT-Tank.HEIGHT;
	}
	//键盘按键处理
	public void _KeyPressed(KeyEvent e) {
		int key = e.getKeyCode();
		switch(key) {
		case KeyEvent.VK_LEFT:  bL = true; break;
		case KeyEvent.VK_UP:    bU = true; break;
		case KeyEvent.VK_RIGHT: bR = true; break;
		case KeyEvent.VK_DOWN:  bD = true; break;
		}
		locateDirection();
	}
	//键盘按键释放处理
	public void _KeyReleased(KeyEvent e) {
		int key = e.getKeyCode();
		switch(key) {
		case KeyEvent.VK_CONTROL:fire(); break;
		case KeyEvent.VK_LEFT:  bL = false; break;
		case KeyEvent.VK_UP:    bU = false; break;
		case KeyEvent.VK_RIGHT: bR = false; break;
		case KeyEvent.VK_DOWN:  bD = false; break;
		}
		locateDirection();
	}
	//确定方向
	void locateDirection(){
		if(bL && !bU && !bR && !bD) dir = Direction.L;
		else if(bL && bU && !bR && !bD) dir = Direction.LU;
		else if(!bL && bU && !bR && !bD) dir = Direction.U;
		else if(!bL && bU && bR && !bD) dir = Direction.RU;
		else if(!bL && !bU && bR && !bD) dir = Direction.R;
		else if(!bL && !bU && bR && bD) dir = Direction.RD;
		else if(!bL && !bU && !bR && bD) dir = Direction.D;
		else if(bL && !bU && !bR && bD) dir = Direction.LD;
		else if(!bL && !bU && !bR && !bD) dir = Direction.STOP;
		move();
	}
	//开火   坦克打出子弹
	public Missile fire(){
		int x = this.x + Tank.WIDTH/2 - Missile.WIDTH/2;
		int y = this.y + Tank.HEIGHT/2 - Missile.HEIGHT/2;
		Missile m = new Missile(x, y, ptDir, tc);
		tc.missiles.add(m);//从TankClient端传一个对象引用给Tank就是为了给TankClient端的对象添加子弹
		return m;
	}
	public Rectangle getRect(){
		return new Rectangle(x, y, WIDTH, HEIGHT);
	}

	
}
