import java.awt.*;
public class Wall {
	int x, y, w, h;   //ǽ��λ��  ���  �߶�
	TankClient tc;    //����һ��̹�˶˵�����
	public Wall(int x, int y, int w, int h, TankClient tc) {
		super();
		this.x = x;
		this.y = y;
		this.w = w;
		this.h = h;
		this.tc = tc;
	}
	public void draw(Graphics g){   //��ǽ
		g.fillRect(x, y, w, h);   //��ǽ������
	}
	
	public Rectangle getRect() {    //��ײ�����
		return new Rectangle(x, y, w, h);
	}
}


//�ӵ����ٶȲ���̫��ǽ����̫��   ��Ȼ   �ӵ����ܴ�ǽ