import java.awt.*;
//��ը��
public class Boom {       
	int x, y;                                                     //λ������
	private boolean live = true;								  //���״̬
	
	private TankClient tc;                                        //�������ض˵�����
	
	int[] diameter = {4,7, 12, 18, 26, 32, 49, 30, 14, 6};        //��ը�Ĵ�С�仯
	int step = 0;                                                 //�����ڼ�������ʾ�����е�ĳһ����
	
	
	//���췽������ȡӦ����ը��λ���Լ���ȡ���ض����ã�
	public Boom(int x, int y, TankClient tc){                     
		this.x = x;
		this.y = y;
		this.tc = tc; 
	}
	
	
	//�滭������������ը
	public void draw(Graphics g){                                  
		if(!live) {												   //�����ը״̬��������ը������
			tc.booms.remove(this);								   //�ʹӱ�ը������ȥ�������ըԪ�أ��ͷ��ڴ�
			return ;
		}
		if(step == diameter.length){							   //����������λ������ĳ��ȣ���λ�������е�ÿ����ըͼ�ζ��Ѿ�����һ�飩
			live = false;										   //��ǰ�����ը����
			step = 0;											   //��ʼ����һ����ը����ʼλ��Ϊ0
			return ;
		}
		Color c = g.getColor();									   //��ȡ������ɫ
		g.setColor(Color.ORANGE); 								   //���û�����ɫ��Ҫ���ı�ը����ɫ��
		g.fillOval(x, y, diameter[step], diameter[step]);		   //����һ����ըͼ��Ԫ��
		g.setColor(c);											   //��ԭ������ɫ
		step++;													   //��ʼ����һ����ըͼƬ��Ӧ���±�
		
	}
}
