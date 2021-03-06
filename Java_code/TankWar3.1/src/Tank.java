import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;
import java.util.*;  					  //这个里面有Random类
//坦克类
public class Tank {
	private int x, y;                    									//坦克的位置
	private int oldx, oldy;                                                 //用来记录坦克的上一个位置
	public static final int XSPEED = 5;  									//横向移动长度
	public static final int YSPEED = 5;  									//纵向移动长度
	public static final int WIDTH = 30;   									//坦克的宽度
	public static final int HEIGHT = 30; 								    //坦克的高度
	private int life = 100;          									    //坦克初始血量
	private boolean live = true;          								    //坦克的初始存活状态
	private boolean good;                								    //坦克的质量（好坦克还是坏坦克）
	public TankClient tc;                 									//声明一个控制端的引用
	private boolean bL = false, bU = false, bR = false, bD = false;   	    //定义上下左右四个方向！按键！的状态量
	enum Direction{L, LU, U, RU, R, RD, D, LD, STOP};            	 	    //定义八个方向的量（使用枚举数据类型）
	private Direction dir = Direction.STOP;                      			//初始化默认坦克行走方向
	private Direction ptDir = Direction.D;                       			//初始化默认炮管方向
	
	private int step = r.nextInt(12) + 3;      		// 每个坦克都获取一个初始化步数  最少3步  当step为0时   改变坦克方向   这个变量只针对敌方坦克
	
	private BloodBar bb = new BloodBar();									//己方坦克上的血条
	private static Random r = new Random();			//建立一个随机数产生器，并且把这个随机数生成器定义成static，就不会每个对象都有一个  ，大家公用一个很好
	
	//获取坦克血量方法
	public int getLife() {
		return life;
	}
	
	//设置坦克血量方法
	public void setLife(int life) {
		this.life = life;
	}

	//获取坦克好坏
	public boolean isGood() {           								    
		return good;
	}
	
	//获取坦克的存活状态方法
	public boolean isLive() {            								    
		return live;
	}
	
	//设置坦克的存活状态方法
	public void setLive(boolean live) {   									
		this.live = live;
	}
	

	//坦克构造方法
	public Tank(int x, int y,boolean good) {                     
		this.x = x;
		this.y = y;
		this.oldx = x;
		this.oldy = y;
		this.good = good;
	}
	
	//坦克构造方法
	public Tank(int x, int y,boolean good,Direction dir, TankClient tc){  
		this(x, y, good);
		this.dir = dir;
		this.tc = tc;
	}
	
	//画坦克的方法
	public void draw(Graphics g){              
		if(!live) {   													//如果坦克死亡
			if(!good) { 												//并且坦克是敌方坦克
				tc.tanks.remove(this);    								//从集合中删除已经死亡的敌方坦克，释放内存，也就不会重画
			}
			return ;													//对已经死亡的敌方坦克不进行重画
		}
																		//不满足前面的if判断就说明  该坦克状态是存活的
		Color c = g.getColor();                 						//设置画笔的颜色
		if(good) g.setColor(Color.RED);          						//是己方坦克    那么就画成红色
		else g.setColor(Color.BLUE);              						//是敌方坦克   设置成蓝色
		if(good) g.fillOval(x, y, Tank.WIDTH, Tank.HEIGHT);				//己方坦克画成圆形
		else g.fillRect(x, y, Tank.WIDTH, Tank.HEIGHT);  				//敌方坦克画成矩形
		g.setColor(c);   												//还原画笔颜色
		if(good)  bb.draw(g);  										    //给己方坦克画血条（敌方坦克也有血条但是不画！）
		
		switch(ptDir){        											//判断炮筒的方向
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
		move();															//调用移动方法
	}
	
	//键盘按键处理方法
	public void _KeyPressed(KeyEvent e) {   							//键盘按下时
		int key = e.getKeyCode();        							    //获取按键编码
		switch(key) {
		case KeyEvent.VK_F2: if(!this.live) {							//如果按键是F2，就使坦克满血重现
			this.live = true;
			this.life = 100;
		}
		case KeyEvent.VK_LEFT:  bL = true; break;						//按键左
		case KeyEvent.VK_UP:    bU = true; break;						//按键上
		case KeyEvent.VK_RIGHT: bR = true; break;						//按键右
		case KeyEvent.VK_DOWN:  bD = true; break;						//按键下
		}
		locateDirection(); 												//获取按键之后,调用这个方法,改变坦克当前的移动方向
	}
	
	//键盘按键释放处理
	public void _KeyReleased(KeyEvent e) {
		int key = e.getKeyCode();
		switch(key) {
		case KeyEvent.VK_CONTROL:fire(); break;							//按键Ctrl发射子弹
		case KeyEvent.VK_LEFT:  bL = false; break;  					//按键弹起   恢复默认设置
		case KeyEvent.VK_UP:    bU = false; break;
		case KeyEvent.VK_RIGHT: bR = false; break;
		case KeyEvent.VK_DOWN:  bD = false; break;
		case KeyEvent.VK_A: superFire(); break;							//按键A调用超级开火方法想八个方向发射子弹
		}
		locateDirection();  											//获取按键之后,调用这个方法,改变坦克当前的移动方向
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
	public Missile fire(){                                       
		if(!live) return null;     								 //如果坦克死了   就不要发炮弹了
		int x = this.x + Tank.WIDTH/2 - Missile.WIDTH/2;		 //子弹发射的横纵坐标
		int y = this.y + Tank.HEIGHT/2 - Missile.HEIGHT/2;
		Missile m = new Missile(x, y,good, ptDir, tc);           //直接把坦克本身的好坏（good）作为子弹的好坏传给子弹就行
		tc.missiles.add(m);                                      //从TankClient端传一个对象引用给Tank就是为了给TankClient端的对象添加子弹
		return m;
	}
	
	//有传入固定方向 的发射炮弹方法  与上一个不同
	public Missile fire(Direction dir){  						
		if(!live) return null;     								//如果坦克死了   就不要发炮弹了
		int x = this.x + Tank.WIDTH/2 - Missile.WIDTH/2;
		int y = this.y + Tank.HEIGHT/2 - Missile.HEIGHT/2;
		Missile m = new Missile(x, y,good, dir, tc);             //直接把坦克本身的好坏作为子弹的好坏传给子弹就行
		tc.missiles.add(m);                                      //从TankClient端传一个对象引用给Tank就是为了给TankClient端的对象添加子弹
		return m;
	}
	
	//获取坦克矩形对象，用于碰撞检测的方法
	public Rectangle getRect(){
		return new Rectangle(x, y, WIDTH, HEIGHT);
	}
	
	//使坦克回到撞墙之前的方法
	private void stay() {  										 //创建一个给撞墙方法要调用的stay方法，作用是回到撞墙之前的一个位置
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
		if(this.dir != Direction.STOP){                                                  //当坦克不是停止状态时，使坦克炮筒方向为他的行驶方向
			this.ptDir = this.dir;
		}
		if(x<0) x = 0;
		if(x+Tank.WIDTH>TankClient.GAME_WIDTH) x = TankClient.GAME_WIDTH-Tank.WIDTH;     //判断坦克横向是否到达边界
		if(y<26) y = 26;
		if(y+Tank.HEIGHT>TankClient.GAME_HEIGHT) y = TankClient.GAME_HEIGHT-Tank.HEIGHT; //判断坦克纵向是否到达边界
		
		if(!good) {																		 //针对敌方坦克
			Direction[] dirs = Direction.values();   									 //values是enumeration类型的一个转换到数组的方法
			if(step == 0) {                       										 //当步数为0时  
				step = r.nextInt(12)+3;			  										 //（为了新的方向）重新初始化一个步数
				int rn = r.nextInt(dirs.length);   										 //产生了随机数了  接下来就应该改变方向了（使用随机数）
				dir = dirs[rn];                     									 //初始化一个新的方向
			}
			step--;                               										 //step为确定一个方向时要行走的步数
			if(r.nextInt(40)>38) this.fire();     										 //避免敌方坦克炮火太猛    随机数限制
		}
	}	
	
	//撞墙方法
	public boolean collidesWithWall(Wall w) {   
		if(this.live&&this.getRect().intersects(w.getRect())){   						 //如果撞墙了  就让坦克回到上一个位置
			this.stay();
			return true;
		}
		return false;
	}
	
	//一个坦克和所有坦克之间的碰撞检测
	public boolean collidesWithTanks(java.util.List<Tank> tanks){ 
		for(int i = 0; i<tanks.size(); i++){
			Tank t = tanks.get(i);
			if(this != t) {                                                              //不是同一辆坦克才检测
				if(this.live && t.isLive() && this.getRect().intersects(t.getRect())){   //如果撞墙了  就让坦克回到上一个位置
					this.stay();                                                         //“停下”当前坦克（实质回到上一个位置）
					t.stay();                                                            //被撞的坦克  也要“停下”（实质回到上一个位置）
					return true;
				}
			}
		}
		return false;
	}
	
	//超级开火方法：八个方向  超级炮弹！！  朝向八个方向都有炮弹
	private void superFire() { 
		Direction[]  dirs = Direction.values();
		for(int i = 0; i < 8; i++) {
			fire(dirs[i]);
			//tc.missiles.add(fire(dirs[i]));  因为fire方法中已经添加过一次子弹 所以不用再次添加子弹了  直接fire就行    否则每次发射  都是两枚炮弹
		}
	}
	
	//画血条方法
	private class BloodBar{  
		public void draw(Graphics g) {
			Color c = g.getColor();
			g.setColor(Color.red);
			//g.drawRect(x, y-10, WIDTH, 10);
			int w = WIDTH * life/100;
			g.fillRect(x, y-8, w, 8);  //血条的位置和宽高
			int line_num = 100/20-1; //要画的线条数目
			int sp_line = WIDTH * 20 / 100; //要画的线条间隔
			g.setColor(Color.WHITE);
			for(int i = 1; i <= line_num; i++)
			g.drawLine(x+i*sp_line, y-8, x+i*sp_line, y);
			g.setColor(c);
		}
	}
	
	//己方坦克吃到敌方坦克子弹掉血方法
	public boolean eat(Blood b){
		if(this.live&&b.isLive()&&this.getRect().intersects(b.getRect())){
			this.life = 100;
			b.setLive(false);
			return true;
		}
		return false;
	}
}
