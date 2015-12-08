import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;
import java.util.*;  					  //���������Random��

public class Tank {
	private int x, y;                    									//̹�˵�λ��
	
	public static final int XSPEED = 5;  									//�����ƶ�����
	public static final int YSPEED = 5;  									//�����ƶ�����
	
	public static final int WIDTH = 30;   //̹�˵Ŀ���
	public static final int HEIGHT = 30;  //̹�˵ĸ߶�
	
	private boolean live = true;          //̹�˵Ĵ��״̬
	public TankClient tc;                 //����һ�����ƶ˵�����
	private boolean good;                 //̹�˵������û�
	
	public boolean isGood() {             //��ȡgood
		return good;
	}
	private static Random r = new Random();//����һ�������������
	//���������������������static   �Ͳ���ÿ��������һ��    ��ҹ���һ��   �����
	public boolean isLive() {             //��ȡ̹�˵Ĵ��״̬����
		return live;
	}
	public void setLive(boolean live) {   //����̹�˵Ĵ��״̬����
		this.live = live;
	}
	private boolean bL = false, bU = false, bR = false, bD = false;    //�������������ĸ������״̬��
	enum Direction{L, LU, U, RU, R, RD, D, LD, STOP};            //����˸��������
	private Direction dir = Direction.STOP;                      //��ʼ��Ĭ��̹�����߷���
	private Direction ptDir = Direction.D;                       //��ʼ��Ĭ���ڹܷ���
	
	private int step = r.nextInt(12) + 3;      // ÿ��̹�˶���ȡһ����ʼ������  ����3��  ��stepΪ0ʱ   �ı�̹�˷���   �������ֻ��Եط�̹��
	
	public Tank(int x, int y,boolean good) {                     //̹�˹��캯��
		this.x = x;
		this.y = y;
		this.good = good;
	}
	
	public Tank(int x, int y,boolean good,Direction dir, TankClient tc){   //̹�˹��캯��
		this(x, y, good);
		this.dir = dir;
		this.tc = tc;
	}
	
	public void draw(Graphics g){               //��̹�˵ĺ���
		if(!live) {   //�ж��Ƿ���
			if(!good) { 
				tc.tanks.remove(this);    //�Ӽ�����ɾ���Ѿ�������̹��   �����Ͳ����ػ�
			}
			return ;
		}
		                                     //������ǰ���if�жϾ�˵��  ��̹��״̬�Ǵ���
		Color c = g.getColor();                 //���û��ʵ���ɫ
		if(good) g.setColor(Color.RED);           //�Ǽ���̹��    ��ô�ͻ��ɺ�ɫ
		else g.setColor(Color.BLUE);              //�ǵз�̹��   ���ó���ɫ
		g.drawRect(x, y, Tank.WIDTH, Tank.HEIGHT);  //��̹����״
		g.setColor(c);   //��ԭ������ɫ
		
		switch(ptDir){        //�ж���Ͳ�ķ���
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
	
	//���̰�������
	public void _KeyPressed(KeyEvent e) {   //���̰���ʱ
		int key = e.getKeyCode();         //��ȡ��������
		switch(key) {
		case KeyEvent.VK_LEFT:  bL = true; break;
		case KeyEvent.VK_UP:    bU = true; break;
		case KeyEvent.VK_RIGHT: bR = true; break;
		case KeyEvent.VK_DOWN:  bD = true; break;
		}
		locateDirection(); //  ��ȡ�˰�������֮��  �Ϳ��Ե������������  �ı�̹�˵�ǰ���ƶ�����
	}
	//���̰����ͷŴ���
	public void _KeyReleased(KeyEvent e) {
		int key = e.getKeyCode();
		switch(key) {
		case KeyEvent.VK_CONTROL:fire(); break;
		case KeyEvent.VK_LEFT:  bL = false; break;  //��������   �ָ�Ĭ������
		case KeyEvent.VK_UP:    bU = false; break;
		case KeyEvent.VK_RIGHT: bR = false; break;
		case KeyEvent.VK_DOWN:  bD = false; break;
		}
		locateDirection();  //  ��ȡ�˰�������֮��  �Ϳ��Ե������������  �ı�̹�˵�ǰ���ƶ�����
	}
	//ȷ������
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
	//����   ̹�˴���ӵ�
	public Missile fire(){                                       //�����õ��˵��ڻ�̫������
		if(!live) return null;     //���̹������   �Ͳ�Ҫ���ڵ���
		int x = this.x + Tank.WIDTH/2 - Missile.WIDTH/2;
		int y = this.y + Tank.HEIGHT/2 - Missile.HEIGHT/2;
		Missile m = new Missile(x, y,good, ptDir, tc);           //ֱ�Ӱ�̹�˱����ĺû���Ϊ�ӵ��ĺû������ӵ�����
		tc.missiles.add(m);                                      //��TankClient�˴�һ���������ø�Tank����Ϊ�˸�TankClient�˵Ķ��������ӵ�
		return m;
	}
	public Rectangle getRect(){
		return new Rectangle(x, y, WIDTH, HEIGHT);
	}
	//�ƶ�
	void move(){
		switch(dir){ 																	 //�ж�̹�����߷���
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
		if(x+Tank.WIDTH>TankClient.GAME_WIDTH) x = TankClient.GAME_WIDTH-Tank.WIDTH;     //�ж��Ƿ񵽴�߽�
		if(y<26) y = 26;
		if(y+Tank.HEIGHT>TankClient.GAME_HEIGHT) y = TankClient.GAME_HEIGHT-Tank.HEIGHT; //�ж��Ƿ񵽴�߽�
		
		if(!good) {
			Direction[] dirs = Direction.values();   //�����enumeration��һ��ת��������ķ���
			if(step == 0) {                       //������Ϊ0ʱ  
				step = r.nextInt(12)+3;			  //��Ϊ���µķ������³�ʼ��һ������
				int rn = r.nextInt(dirs.length);   //�������������  ��������Ӧ�øı䷽���ˣ�ʹ���������
				dir = dirs[rn];                     //��ʼ��һ���µķ���
			}
			step--;                               //��������Ϊ0ʱ  ���ͼ������ַ����ߣ�ÿ��һ����step�ݼ�1.
			if(r.nextInt(40)>38) this.fire();     //����з�̹���ڻ�̫��    ���������
		}
	}	
	
}