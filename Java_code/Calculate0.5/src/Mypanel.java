import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.Panel;

import javax.swing.JButton;


public class Mypanel extends Panel{
//  Êý×Ö°´¼ü10¸ö
	JButton num_key[][];
	JButton huitui, dengyu;
	JButton _jia, _jian, _cheng, _chu;
	GridLayout grid;
	Mypanel(){
		grid = new GridLayout(3,3);
		this.setLayout(grid);
		this.setSize(200, 200);
		num_key = new JButton[3][3];
		for(int i = 0; i < 3; i++) {
			for(int j = 0; j < 3; j++){
				num_key[i][j] = new JButton(String.valueOf(i*3+j+1));
				this.add(num_key[i][j]);
			}
		}
		
		
	
	}
	
}
