import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.ArrayList;
import java.util.List;
//�ӵ���
public class Missile {
	int x, y;  											//�ӵ���λ�ã�x,y��
	public static final int XSPEED = 10;   				//�ӵ���λ�ƶ����루XSPEED��YSPEED��
	public static final int YSPEED = 10;
	public static final int WIDTH = 10;					//�ӵ����ȣ�WIDTH�����ӵ��߶ȣ�HEIGHT��
	public static final int HEIGHT = 10;				 
	private TankClient tc;								//���ض�����
	private boolean live = true;						//�ӵ����״̬
	private boolean good;  								//���ӱ���   �ӵ��ĺû���
	Tank.Direction dir;									//̹�˷�������
	
	//��ȡ�ӵ����״̬����
	public boolean isLive() {
		return live;
	}
	
	//���췽��
	public Missile(int x, int y,boolean good, Tank.Direction dir){
		this.x = x;
		this.y = y;
		this.good = good;
		this.dir = dir;
	}
	
	//���췽��
	public Missile(int x, int y,boolean good, Tank.Direction dir, TankClient tc) {
		//super();
		this(x, y,good,dir);
		this.tc = tc;
	}
	
	//�ӵ��滭����
	public void draw(Graphics g){
		if(!this.live) {
			tc.missiles.remove(this);                           //�ӵ�������ֱ�ӴӼ������Ƴ�
			return ;
		}
		Color c = g.getColor(); 								//��ȡ���ʵ���ɫ
		if(this.good) g.setColor(Color.RED);  					//����̹���ӵ�����ɫ
		else g.setColor(Color.BLACK);  							//�з�̹���ӵ�����ɫ
		g.fillOval(x, y, WIDTH, HEIGHT);						//�ӵ���״
		g.setColor(c);   										//��ԭ���ʵ���ɫ
		
		move();													//�����ӵ��ƶ�����
	}
	
	//�ӵ��ƶ�����
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
		if(x<0 || y<0 || x>TankClient.GAME_WIDTH||y>TankClient.GAME_HEIGHT){   //�ж��ӵ����ܳ���
			live = false;
		}
	}
	
	//��ײ���ĸ�����Rectangle
	public Rectangle getRect(){
		return new Rectangle(x, y, WIDTH, HEIGHT);
	}
	
	//��̹�˷���
	public boolean hitTank(Tank t){						//����ӵ����� ������̹��   ��̹��״̬Ϊ���   ���ӵ�������̹������Ϊ�ж�״̬  
		if(this.live && this.getRect().intersects(t.getRect()) && t.isLive() && this.good!=t.isGood()){
			if(t.isGood()) {
				t.setLife(t.getLife() - 20);            //��̹�˱� �ӵ���  ÿ�ε�20��Ѫ��
				if(t.getLife()<=0) {					//��̹��Ѫ��Ϊ0ʱ   ���ú�̹������
					t.setLive(false);
				}
			}
			else {                                     //��̹��ֻҪ���ӵ��򵽾�����
				t.setLive(false);
			}
			this.live = false;
			Boom bm = new Boom(x, y, tc);
			tc.booms.add(bm);
			return true;
		}
		return false;
	}
	
	//�ӵ���з�̹�˼��ϵķ���
	public boolean hitTanks(List<Tank> tanks) {
		for(int i = 0; i < tanks.size(); i++) {                         //�������ض��ӵ������е�ÿһ���ӵ�
			if(hitTank(tanks.get(i))){
				return true;
			}
		}
		return false;
	}
	
	//�ӵ���ǽ����
	public boolean hitWall(Wall w){ //ײǽ���
		if(this.live&&this.getRect().intersects(w.getRect())){           //����ӵ������������ǽ
			this.live = false;											 //ʹ�ӵ�����
			return true;
		}
		return false;
	}
	
}