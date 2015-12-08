import java.awt.*;
//爆炸类
public class Boom {       
	int x, y;                                                     //位置属性
	private boolean live = true;								  //存活状态
	
	private TankClient tc;                                        //传给主控端的引用
	
	int[] diameter = {4,7, 12, 18, 26, 32, 49, 30, 14, 6};        //爆炸的大小变化
	int step = 0;                                                 //画到第几个（表示数组中的某一个）
	
	
	//构造方法（获取应当爆炸的位置以及获取主控端引用）
	public Boom(int x, int y, TankClient tc){                     
		this.x = x;
		this.y = y;
		this.tc = tc; 
	}
	
	
	//绘画方法，画出爆炸
	public void draw(Graphics g){                                  
		if(!live) {												   //如果爆炸状态死亡（爆炸结束）
			tc.booms.remove(this);								   //就从爆炸集合中去掉这个爆炸元素，释放内存
			return ;
		}
		if(step == diameter.length){							   //当步数等于位置数组的长度（即位置数组中的每个爆炸图形都已经画了一遍）
			live = false;										   //当前这个爆炸结束
			step = 0;											   //初始化下一个爆炸的起始位置为0
			return ;
		}
		Color c = g.getColor();									   //获取画笔颜色
		g.setColor(Color.ORANGE); 								   //设置画笔颜色（要画的爆炸的颜色）
		g.fillOval(x, y, diameter[step], diameter[step]);		   //画出一个爆炸图形元素
		g.setColor(c);											   //还原画笔颜色
		step++;													   //初始化下一个爆炸图片对应的下标
		
	}
}
