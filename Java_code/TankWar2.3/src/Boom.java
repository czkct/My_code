import java.awt.*;

public class Boom {
	int x, y;
	private boolean live = true;
	
	private TankClient tc;
	
	int[] diameter = {4,7, 12, 18, 26, 32, 49, 30, 14, 6};
	int step = 0; //�����ڼ���
	
	public Boom(int x, int y, TankClient tc){
		this.x = x;
		this.y = y;
		this.tc = tc; 
	}
	
	public void draw(Graphics g){
		if(!live) {
			tc.booms.remove(this);
			return ;
		}
		
		if(step == diameter.length){
			live = false;
			step = 0;
			return ;
		}
		
		Color c = g.getColor();
		g.setColor(Color.ORANGE);
		g.fillOval(x, y, diameter[step], diameter[step]);
		g.setColor(c);
		step++;
		
	}
}
