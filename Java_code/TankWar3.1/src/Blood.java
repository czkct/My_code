import java.awt.*;
//血块类
public class Blood {
	int x, y, w, h;                               //血块的位置以及宽度高度
	TankClient tc;								  //传给主控端的引用
	int step = 0;								  //初始化步数为0
	private boolean live = true;                  //血块的存在状态
	
	private int[][] pos= {                        //血块移动路径（血块位置数组）
			{350,300},{370,300},{375,275},{400,200},{360,270},{365,290},{350,280}
	};
	public boolean isLive() {                     //血块存活状态
		return live;
	}
	public void setLive(boolean live) {           //设置血块存活状态
		this.live = live;
	}
	public Rectangle getRect(){                   //获取血块对象 （用于碰撞检测）
		return new Rectangle(x, y, w, h);
	}
	public Blood() {                              //构造函数    初始化血块信息
		x = pos[0][0];
		y = pos[0][1];
		w = h = 15;
	}
	
	public void draw(Graphics g){                 //画血块方法
		if(!live) return ;
		
		Color c = g.getColor();                   //画笔颜色
		g.setColor(Color.magenta);                //画笔颜色设置
		g.fillRect(x, y, w, h);                   //画好血块
		g.setColor(c);                            //还原画笔颜色
		
		move();                                   //调用血块移动方法
	}
	private void move() {                         //血块移动方法
		step++; 								  //每一次移动一步
		if(step == pos.length){                   //当步数等于位置数组的长度（即位置数组中的每个位置都已经走了一遍）
			step = 0;							  //步数清零
		}
		x = pos[step][0];                         //血块走到下一个位置
		y = pos[step][1];
	}
	
}
