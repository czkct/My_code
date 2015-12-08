import java.io.*;
public class IOIOIO {
	public static void main(String[] args){
		int n = -1;
		byte[] a = new byte[1000];
		try{
			File f = new File("C:/Users/acer_/Desktop/code.txt");
			FileReader in = new FileReader(f);
			while((n = in.read())!=-1) {
				System.out.print((char)n);
			}
			in.close();
		} 
		catch(IOException e){
			System.out.println("File read Error "+ e);
		}
	}
}
