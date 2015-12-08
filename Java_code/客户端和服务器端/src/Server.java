import java.io.*;
import java.net.*;
public class Server {
	public static void main(String args[]) {
		String [] answer = {"在算错的情况下","狗就能生狗","电视、面包、沙发"};//String类定义了一个字符串对象数组answer
		ServerSocket serverForClient = null;
		Socket socketOnServer = null;  //声明一个临时的套接字   下面要用于接受服务器套接字连接上的客户端的套接字
		DataOutputStream out = null;
		DataInputStream in = null;
		try {
			serverForClient = new ServerSocket(2010);//服务器建立了一个ServerSocket对象serverForClient用于与客户端套接字连接起来
			//从而达到客户端和服务器端的连接
			//记忆方法：
			//客户端的套接字用Socket类来定义
			//服务器端的套接字用ServerSocket类来定义
		}
		catch(IOException e1) {
			System.out.println(e1);
		}
		try {
			System.out.println("等待客户呼叫");
			socketOnServer = serverForClient.accept();  //用临时申请的socketOnServer套接字来接收通过服务器套接字连接上的客户端的套接字
			//accept()方法返回客户端的套接字
			out = new DataOutputStream(socketOnServer.getOutputStream());
			in = new DataInputStream(socketOnServer.getInputStream());
			for(int i = 0; i<answer.length; i++) {
				String s = in.readUTF();
				System.out.println("服务器收到客户的提问："+s);
				out.writeUTF(answer[i]);
				Thread.sleep(500);
			}
		}
		catch(Exception e) {
			System.out.println("客户已经断开"+e);
		}
	}
}
//客户端的套接字和服务器端的套接字连接后
//服务器的输入数据流就是客户端的输出数据流
//服务器的输出数据流就是可独断的输入数据流