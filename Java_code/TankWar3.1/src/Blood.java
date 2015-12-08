import java.awt.*;
//Ѫ����
public class Blood {
	int x, y, w, h;                               //Ѫ���λ���Լ����ȸ߶�
	TankClient tc;								  //�������ض˵�����
	int step = 0;								  //��ʼ������Ϊ0
	private boolean live = true;                  //Ѫ��Ĵ���״̬
	
	private int[][] pos= {                        //Ѫ���ƶ�·����Ѫ��λ�����飩
			{350,300},{370,300},{375,275},{400,200},{360,270},{365,290},{350,280}
	};
	public boolean isLive() {                     //Ѫ����״̬
		return live;
	}
	public void setLive(boolean live) {           //����Ѫ����״̬
		this.live = live;
	}
	public Rectangle getRect(){                   //��ȡѪ����� ��������ײ��⣩
		return new Rectangle(x, y, w, h);
	}
	public Blood() {                              //���캯��    ��ʼ��Ѫ����Ϣ
		x = pos[0][0];
		y = pos[0][1];
		w = h = 15;
	}
	
	public void draw(Graphics g){                 //��Ѫ�鷽��
		if(!live) return ;
		
		Color c = g.getColor();                   //������ɫ
		g.setColor(Color.magenta);                //������ɫ����
		g.fillRect(x, y, w, h);                   //����Ѫ��
		g.setColor(c);                            //��ԭ������ɫ
		
		move();                                   //����Ѫ���ƶ�����
	}
	private void move() {                         //Ѫ���ƶ�����
		step++; 								  //ÿһ���ƶ�һ��
		if(step == pos.length){                   //����������λ������ĳ��ȣ���λ�������е�ÿ��λ�ö��Ѿ�����һ�飩
			step = 0;							  //��������
		}
		x = pos[step][0];                         //Ѫ���ߵ���һ��λ��
		y = pos[step][1];
	}
	
}