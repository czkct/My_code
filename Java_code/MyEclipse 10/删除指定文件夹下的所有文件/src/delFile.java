import java.io.*;

public class delFile {
	void del(String str) {//递归删除法
		File f = new File(str);
		File [] fs = f.listFiles();
		for(File c:fs){
			if(c.delete()){ //返回值为true
				continue;
			}
			else { //删除不成功
				//记录这个删除不成功的对象；
				File x = c;
				del(str+"/"+c.getName());
				c.delete(); //文件夹下的子文件全部删除完毕，删除该空文件夹
			}
		}
	}
}
