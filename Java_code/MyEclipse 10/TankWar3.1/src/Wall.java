import java.awt.*;
//ǽ�ࣨע����ӵ��ĵ�λ�ƶ����벻��̫��ǽ����̫��   ��Ȼ   �ӵ��ᴩǽ��
public class Wall {
	int x, y, w, h;   												//ǽ��λ�ã�x,y��  ���w  �߶�h
	TankClient tc;   											    //����һ�����ض˵�����
	
	//ǽ�Ĺ��췽��
	public Wall(int x, int y, int w, int h, TankClient tc) {       
		this.x = x;
		this.y = y;
		this.w = w;
		this.h = h;
		this.tc = tc;
	}
	
	//��ǽ����
	public void draw(Graphics g){
		g.fillRect(x, y, w, h);  
	}
	
	//��ײ�����
	public Rectangle getRect() {    
		return new Rectangle(x, y, w, h);
	}
}