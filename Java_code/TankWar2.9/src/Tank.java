import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;
import java.util.*;  					  //这个里面有Random类


public class Tank {
	private int x, y;                    									//坦克的位置
	private int oldx, oldy;                                                 //用来记录坦克的上一个位置
	public static final int XSPEED = 5;  									//横向移动长度
	public static final int YSPEED = 5;  									//纵向移动长度
	
	public static final int WIDTH = 30;   //坦克的宽度
	public static final int HEIGHT = 30;  //坦克的高度
	private int life = 100;           //给一个好的坦克初始默认血量
	
	private BloodBar bb = new BloodBar();
	
	public int getLife() {
		return life;
	}
	public void setLife(int life) {
		this.life = life;
	}
	private boolean live = true;          //坦克的存活状态
	public TankClient tc;                 //声明一个控制端的引用
	private boolean good;                 //坦克的质量好坏
	
	public boolean isGood() {             //获取good
		return good;
	}
	private static Random r = new Random();//建立一个随机数产生器
	//把这个随机数生成器定义成static   就不会每个对象都有一个    大家公用一个   会更好
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
	
	private int step = r.nextInt(12) + 3;      // 每个坦克都获取一个初始化步数  最少3步  当step为0时   改变坦克方向   这个变量只针对地方坦克
	
	public Tank(int x, int y,boolean good) {                     //坦克构造函数
		this.x = x;
		this.y = y;
		this.oldx = x;
		this.oldy = y;
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
		g.drawRect(x, y, Tank.WIDTH, Tank.HEIGHT);  //画坦克形状
		g.setColor(c);   //还原画笔颜色
		
		if(good)  bb.draw(g);   //给好的坦克弄好血条
		switch(ptDir){        //判断炮筒的方向
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
		move();
	}
	
	//键盘按键处理
	public void _KeyPressed(KeyEvent e) {   //键盘按下时
		int key = e.getKeyCode();         //获取按键编码
		switch(key) {
		case KeyEvent.VK_LEFT:  bL = true; break;
		case KeyEvent.VK_UP:    bU = true; break;
		case KeyEvent.VK_RIGHT: bR = true; break;
		case KeyEvent.VK_DOWN:  bD = true; break;
		}
		locateDirection(); //  获取了按键内容之后  就可以调用这个方法，  改变坦克当前的移动方向
	}
	//键盘按键释放处理
	public void _KeyReleased(KeyEvent e) {
		int key = e.getKeyCode();
		switch(key) {
		case KeyEvent.VK_CONTROL:fire(); break;
		case KeyEvent.VK_LEFT:  bL = false; break;  //按键弹起   恢复默认设置
		case KeyEvent.VK_UP:    bU = false; break;
		case KeyEvent.VK_RIGHT: bR = false; break;
		case KeyEvent.VK_DOWN:  bD = false; break;
		case KeyEvent.VK_A: superFire(); break;
		}
		locateDirection();  //  获取了按键内容之后  就可以调用这个方法，  改变坦克当前的移动方向
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
		//move();
	}
	//开火   坦克打出子弹
	public Missile fire(){                                       //不能让敌人的炮火太过猛烈
		if(!live) return null;     //如果坦克死了   就不要发炮弹了
		int x = this.x + Tank.WIDTH/2 - Missile.WIDTH/2;
		int y = this.y + Tank.HEIGHT/2 - Missile.HEIGHT/2;
		Missile m = new Missile(x, y,good, ptDir, tc);           //直接把坦克本身的好坏作为子弹的好坏传给子弹就行
		tc.missiles.add(m);                                      //从TankClient端传一个对象引用给Tank就是为了给TankClient端的对象添加子弹
		return m;
	}
	public Missile fire(Direction dir){  //有传入固定方向 的发射炮弹
		if(!live) return null;     //如果坦克死了   就不要发炮弹了
		int x = this.x + Tank.WIDTH/2 - Missile.WIDTH/2;
		int y = this.y + Tank.HEIGHT/2 - Missile.HEIGHT/2;
		Missile m = new Missile(x, y,good, dir, tc);           //直接把坦克本身的好坏作为子弹的好坏传给子弹就行
		tc.missiles.add(m);                                      //从TankClient端传一个对象引用给Tank就是为了给TankClient端的对象添加子弹
		return m;
	}
	public Rectangle getRect(){
		return new Rectangle(x, y, WIDTH, HEIGHT);
	}
	private void stay() {  //创建一个给撞墙方法要调用的stay方法，作用是回到撞墙之前的一个位置
		x = oldx;
		y = oldy;
	}
	//移动
	void move(){
		this.oldx = x;   //记录移动之前的位置
		this.oldy = y;
		switch(dir){ 																	 //判断坦克行走方向
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
		if(x+Tank.WIDTH>TankClient.GAME_WIDTH) x = TankClient.GAME_WIDTH-Tank.WIDTH;     //判断是否到达边界
		if(y<26) y = 26;
		if(y+Tank.HEIGHT>TankClient.GAME_HEIGHT) y = TankClient.GAME_HEIGHT-Tank.HEIGHT; //判断是否到达边界
		
		if(!good) {
			Direction[] dirs = Direction.values();   //这个是enumeration的一个转换到数组的方法
			if(step == 0) {                       //当步数为0时  
				step = r.nextInt(12)+3;			  //（为了新的方向）重新初始化一个步数
				int rn = r.nextInt(dirs.length);   //产生了随机数了  接下来就应该改变方向了（使用随机数）
				dir = dirs[rn];                     //初始化一个新的方向
			}
			step--;                               //当步数不为0时  ，就继续保持方向走，每走一步，step递减1.
			if(r.nextInt(40)>38) this.fire();     //避免敌方坦克炮火太猛    随机数限制
		}
	}	
	
	public boolean collidesWithWall(Wall w) {   //撞墙方法
		if(this.live&&this.getRect().intersects(w.getRect())){   //如果撞墙了  就让坦克回到上一个位置
			this.stay();
			return true;
		}
		return false;
	}
	
	public boolean collidesWithTanks(java.util.List<Tank> tanks){ //一个坦克和所有坦克之间的碰撞检测
		for(int i = 0; i<tanks.size(); i++){
			Tank t = tanks.get(i);
			if(this != t) {   //不是同一辆坦克才检测
				if(this.live && t.isLive() && this.getRect().intersects(t.getRect())){   //如果撞墙了  就让坦克回到上一个位置
					this.stay();   //“停下”当前坦克
					t.stay();   //被撞的坦克  也要“停下”
					return true;
				}
			}
		}
		return false;
	}
	
	private void superFire() { //八个方向  超级炮弹！！  朝向八个方向都有炮弹
		Direction[]  dirs = Direction.values();
		for(int i = 0; i < 8; i++) {
			fire(dirs[i]);
			//tc.missiles.add(fire(dirs[i]));  因为fire方法中已经添加过一次子弹 所以不用再次添加子弹了  直接fire就行    否则每次发射  都是两枚炮弹
		}
	}
	private class BloodBar{  //画血条   类名后面怎么能跟括号？？？  显然不能！！
		public void draw(Graphics g) {
			Color c = g.getColor();
			g.setColor(Color.red);
			g.drawRect(x, y-10, WIDTH, 10);
			int w = WIDTH * life/100;
			g.fillRect(x, y-10, w, 10);
			g.setColor(c);
		}
	}
	public boolean eat(Blood b){
		if(this.live&&b.isLive()&&this.getRect().intersects(b.getRect())){
			this.life = 100;
			b.setLive(false);
			return true;
		}
		return false;
	}
}
