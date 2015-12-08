import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;
import java.util.*;  					  //���������Random��
//̹����
public class Tank {
	private int x, y;                    									//̹�˵�λ��
	private int oldx, oldy;                                                 //������¼̹�˵���һ��λ��
	public static final int XSPEED = 5;  									//�����ƶ�����
	public static final int YSPEED = 5;  									//�����ƶ�����
	public static final int WIDTH = 30;   									//̹�˵Ŀ���
	public static final int HEIGHT = 30; 								    //̹�˵ĸ߶�
	private int life = 100;          									    //̹�˳�ʼѪ��
	private boolean live = true;          								    //̹�˵ĳ�ʼ���״̬
	private boolean good;                								    //̹�˵���������̹�˻��ǻ�̹�ˣ�
	public TankClient tc;                 									//����һ�����ƶ˵�����
	private boolean bL = false, bU = false, bR = false, bD = false;   	    //�������������ĸ����򣡰�������״̬��
	enum Direction{L, LU, U, RU, R, RD, D, LD, STOP};            	 	    //����˸����������ʹ��ö���������ͣ�
	private Direction dir = Direction.STOP;                      			//��ʼ��Ĭ��̹�����߷���
	private Direction ptDir = Direction.D;                       			//��ʼ��Ĭ���ڹܷ���
	
	private int step = r.nextInt(12) + 3;      		// ÿ��̹�˶���ȡһ����ʼ������  ����3��  ��stepΪ0ʱ   �ı�̹�˷���   �������ֻ��Եз�̹��
	
	private BloodBar bb = new BloodBar();									//����̹���ϵ�Ѫ��
	private static Random r = new Random();			//����һ������������������Ұ��������������������static���Ͳ���ÿ��������һ��  ����ҹ���һ���ܺ�
	
	//��ȡ̹��Ѫ������
	public int getLife() {
		return life;
	}
	
	//����̹��Ѫ������
	public void setLife(int life) {
		this.life = life;
	}

	//��ȡ̹�˺û�
	public boolean isGood() {           								    
		return good;
	}
	
	//��ȡ̹�˵Ĵ��״̬����
	public boolean isLive() {            								    
		return live;
	}
	
	//����̹�˵Ĵ��״̬����
	public void setLive(boolean live) {   									
		this.live = live;
	}
	

	//̹�˹��췽��
	public Tank(int x, int y,boolean good) {                     
		this.x = x;
		this.y = y;
		this.oldx = x;
		this.oldy = y;
		this.good = good;
	}
	
	//̹�˹��췽��
	public Tank(int x, int y,boolean good,Direction dir, TankClient tc){  
		this(x, y, good);
		this.dir = dir;
		this.tc = tc;
	}
	
	//��̹�˵ķ���
	public void draw(Graphics g){              
		if(!live) {   													//���̹������
			if(!good) { 												//����̹���ǵз�̹��
				tc.tanks.remove(this);    								//�Ӽ�����ɾ���Ѿ������ĵз�̹�ˣ��ͷ��ڴ棬Ҳ�Ͳ����ػ�
			}
			return ;													//���Ѿ������ĵз�̹�˲������ػ�
		}
																		//������ǰ���if�жϾ�˵��  ��̹��״̬�Ǵ���
		Color c = g.getColor();                 						//���û��ʵ���ɫ
		if(good) g.setColor(Color.RED);          						//�Ǽ���̹��    ��ô�ͻ��ɺ�ɫ
		else g.setColor(Color.BLUE);              						//�ǵз�̹��   ���ó���ɫ
		if(good) g.fillOval(x, y, Tank.WIDTH, Tank.HEIGHT);				//����̹�˻���Բ��
		else g.fillRect(x, y, Tank.WIDTH, Tank.HEIGHT);  				//�з�̹�˻��ɾ���
		g.setColor(c);   												//��ԭ������ɫ
		if(good)  bb.draw(g);  										    //������̹�˻�Ѫ�����з�̹��Ҳ��Ѫ�����ǲ�������
		
		switch(ptDir){        											//�ж���Ͳ�ķ���
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
		move();															//�����ƶ�����
	}
	
	//���̰�����������
	public void _KeyPressed(KeyEvent e) {   							//���̰���ʱ
		int key = e.getKeyCode();        							    //��ȡ��������
		switch(key) {
		case KeyEvent.VK_F2: if(!this.live) {							//���������F2����ʹ̹����Ѫ����
			this.live = true;
			this.life = 100;
		}
		case KeyEvent.VK_LEFT:  bL = true; break;						//������
		case KeyEvent.VK_UP:    bU = true; break;						//������
		case KeyEvent.VK_RIGHT: bR = true; break;						//������
		case KeyEvent.VK_DOWN:  bD = true; break;						//������
		}
		locateDirection(); 												//��ȡ����֮��,�����������,�ı�̹�˵�ǰ���ƶ�����
	}
	
	//���̰����ͷŴ���
	public void _KeyReleased(KeyEvent e) {
		int key = e.getKeyCode();
		switch(key) {
		case KeyEvent.VK_CONTROL:fire(); break;							//����Ctrl�����ӵ�
		case KeyEvent.VK_LEFT:  bL = false; break;  					//��������   �ָ�Ĭ������
		case KeyEvent.VK_UP:    bU = false; break;
		case KeyEvent.VK_RIGHT: bR = false; break;
		case KeyEvent.VK_DOWN:  bD = false; break;
		case KeyEvent.VK_A: superFire(); break;							//����A���ó������𷽷���˸��������ӵ�
		}
		locateDirection();  											//��ȡ����֮��,�����������,�ı�̹�˵�ǰ���ƶ�����
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
	public Missile fire(){                                       
		if(!live) return null;     								 //���̹������   �Ͳ�Ҫ���ڵ���
		int x = this.x + Tank.WIDTH/2 - Missile.WIDTH/2;		 //�ӵ�����ĺ�������
		int y = this.y + Tank.HEIGHT/2 - Missile.HEIGHT/2;
		Missile m = new Missile(x, y,good, ptDir, tc);           //ֱ�Ӱ�̹�˱����ĺû���good����Ϊ�ӵ��ĺû������ӵ�����
		tc.missiles.add(m);                                      //��TankClient�˴�һ���������ø�Tank����Ϊ�˸�TankClient�˵Ķ��������ӵ�
		return m;
	}
	
	//�д���̶����� �ķ����ڵ�����  ����һ����ͬ
	public Missile fire(Direction dir){  						
		if(!live) return null;     								//���̹������   �Ͳ�Ҫ���ڵ���
		int x = this.x + Tank.WIDTH/2 - Missile.WIDTH/2;
		int y = this.y + Tank.HEIGHT/2 - Missile.HEIGHT/2;
		Missile m = new Missile(x, y,good, dir, tc);             //ֱ�Ӱ�̹�˱����ĺû���Ϊ�ӵ��ĺû������ӵ�����
		tc.missiles.add(m);                                      //��TankClient�˴�һ���������ø�Tank����Ϊ�˸�TankClient�˵Ķ��������ӵ�
		return m;
	}
	
	//��ȡ̹�˾��ζ���������ײ���ķ���
	public Rectangle getRect(){
		return new Rectangle(x, y, WIDTH, HEIGHT);
	}
	
	//ʹ̹�˻ص�ײǽ֮ǰ�ķ���
	private void stay() {  										 //����һ����ײǽ����Ҫ���õ�stay�����������ǻص�ײǽ֮ǰ��һ��λ��
		x = oldx;
		y = oldy;
	}
	
	//�ƶ�
	void move(){
		this.oldx = x;   //��¼�ƶ�֮ǰ��λ��
		this.oldy = y;
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
		if(this.dir != Direction.STOP){                                                  //��̹�˲���ֹͣ״̬ʱ��ʹ̹����Ͳ����Ϊ������ʻ����
			this.ptDir = this.dir;
		}
		if(x<0) x = 0;
		if(x+Tank.WIDTH>TankClient.GAME_WIDTH) x = TankClient.GAME_WIDTH-Tank.WIDTH;     //�ж�̹�˺����Ƿ񵽴�߽�
		if(y<26) y = 26;
		if(y+Tank.HEIGHT>TankClient.GAME_HEIGHT) y = TankClient.GAME_HEIGHT-Tank.HEIGHT; //�ж�̹�������Ƿ񵽴�߽�
		
		if(!good) {																		 //��Եз�̹��
			Direction[] dirs = Direction.values();   									 //values��enumeration���͵�һ��ת��������ķ���
			if(step == 0) {                       										 //������Ϊ0ʱ  
				step = r.nextInt(12)+3;			  										 //��Ϊ���µķ������³�ʼ��һ������
				int rn = r.nextInt(dirs.length);   										 //�������������  ��������Ӧ�øı䷽���ˣ�ʹ���������
				dir = dirs[rn];                     									 //��ʼ��һ���µķ���
			}
			step--;                               										 //stepΪȷ��һ������ʱҪ���ߵĲ���
			if(r.nextInt(40)>38) this.fire();     										 //����з�̹���ڻ�̫��    ���������
		}
	}	
	
	//ײǽ����
	public boolean collidesWithWall(Wall w) {   
		if(this.live&&this.getRect().intersects(w.getRect())){   						 //���ײǽ��  ����̹�˻ص���һ��λ��
			this.stay();
			return true;
		}
		return false;
	}
	
	//һ��̹�˺�����̹��֮�����ײ���
	public boolean collidesWithTanks(java.util.List<Tank> tanks){ 
		for(int i = 0; i<tanks.size(); i++){
			Tank t = tanks.get(i);
			if(this != t) {                                                              //����ͬһ��̹�˲ż��
				if(this.live && t.isLive() && this.getRect().intersects(t.getRect())){   //���ײǽ��  ����̹�˻ص���һ��λ��
					this.stay();                                                         //��ͣ�¡���ǰ̹�ˣ�ʵ�ʻص���һ��λ�ã�
					t.stay();                                                            //��ײ��̹��  ҲҪ��ͣ�¡���ʵ�ʻص���һ��λ�ã�
					return true;
				}
			}
		}
		return false;
	}
	
	//�������𷽷����˸�����  �����ڵ�����  ����˸��������ڵ�
	private void superFire() { 
		Direction[]  dirs = Direction.values();
		for(int i = 0; i < 8; i++) {
			fire(dirs[i]);
			//tc.missiles.add(fire(dirs[i]));  ��Ϊfire�������Ѿ����ӹ�һ���ӵ� ���Բ����ٴ������ӵ���  ֱ��fire����    ����ÿ�η���  ������ö�ڵ�
		}
	}
	
	//��Ѫ������
	private class BloodBar{  
		public void draw(Graphics g) {
			Color c = g.getColor();
			g.setColor(Color.red);
			//g.drawRect(x, y-10, WIDTH, 10);
			int w = WIDTH * life/100;
			g.fillRect(x, y-8, w, 8);  //Ѫ����λ�úͿ���
			int line_num = 100/20-1; //Ҫ����������Ŀ
			int sp_line = WIDTH * 20 / 100; //Ҫ�����������
			g.setColor(Color.WHITE);
			for(int i = 1; i <= line_num; i++)
			g.drawLine(x+i*sp_line, y-8, x+i*sp_line, y);
			g.setColor(c);
		}
	}
	
	//����̹�˳Ե��з�̹���ӵ���Ѫ����
	public boolean eat(Blood b){
		if(this.live&&b.isLive()&&this.getRect().intersects(b.getRect())){
			this.life = 100;
			b.setLive(false);
			return true;
		}
		return false;
	}
}