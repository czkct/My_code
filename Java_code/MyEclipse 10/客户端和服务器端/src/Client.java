import java.io.*;
import java.net.*;
public class Client {
	public static void main(String args[]) {
		String [] mess = {"1+1在什么情况下不等于2", "狗为什么不生跳蚤","什么东西能看、能吃、能坐"};//用String类定义了一个字符串对象数组mess
		Socket mysocket;
		DataInputStream in = null;  //数据输入流in
		DataOutputStream out = null;  //数据输出流out
		try {
			mysocket = new Socket("127.0.0.1", 2010);   //Socket类客户端套接字对象mysocket
			in = new DataInputStream(mysocket.getInputStream()); 
			out = new DataOutputStream(mysocket.getOutputStream());
			/*
			 * getInputStream()的返回值是InputStream类对象
			 * getOutputStream()的返回值是OutputStream类对象
			 * DataInputStream创建的对象是数据输入流
			 * DataOutputStream创建的对象是数据输出流
			 * DataInputStream类继承了InputStream类   比InputStream多了一些方法
			 * DataOutputStream与上同理
			 * */
			for(int i = 0; i < mess.length; i++) {
				out.writeUTF(mess[i]);//writeUTF的作用是写入一个字符串 它是DataOutputStream类中的一个方法
				//此处是将mess[i]中的字符串写到out对象中
				String s = in.readUTF(); //readUTF的作用是读取一个UTF字符串   它是DataInputStream类中的一个方法   返回值是一个字符串的引用
				//in 读取信息  ，堵塞状态
				System.out.println("客户端收到服务端的回答："+s);
				Thread.sleep(500);
			}
		}
		catch(Exception e) {
			System.out.println("服务器已经断开"+e);
		}
	}
}
//客户端的套接字和服务器端的套接字连接后
//客户端的输出数据流是服务器端的输入数据流
//客户端的输入数据流是服务器端的输出数据流