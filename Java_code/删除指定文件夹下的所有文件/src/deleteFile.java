import java.io.*;
import java.util.Scanner;

public class deleteFile {
	public static void main(String[] args) {
		System.out.println("请输入要删除的目标文件夹路径：");
		Scanner scan = new Scanner(System.in);
		String str = new String(scan.next());
		System.out.println("请输入该目标文件夹名称：");
		String str1 = new String(scan.next());
		delFile m = new delFile();
		m.del(str+"/"+str1);
		//删除空的文件夹
		File f = new File(str,str1);
		f.delete();
		System.out.println("删除完毕！");
	}
}

/*
 * 1.用File对象形式返回目录下的全部文件，到一个File对象数组中
 * 2.遍历数组中每一个对象并且删除它
 * 		1>.如果删除成功，则继续删除下一个
 * 		2>.苟泽递归这个删除方法
 * 		3>.删除了文件夹下的子文件之后就删除这个文件夹
 * */
