import java.io.*;
public class About {
	public static void main(String[] args){
		try{
			String s = new String();
			FileOutputStream out = new FileOutputStream("¾Å¾Å³Ë·¨±í.txt");
			byte[] a = "\r\n".getBytes();
			for(int i = 1; i <= 9; i++){
				for(int j = 1; j <= i; j++){
					s=j+" x "+i+" = "+i*j+'\t';
					byte[] ch = s.getBytes();
					out.write(ch);
					//System.out.print(s);
				}
				out.write(a);
				//System.out.println();
			}
			out.close();
		}
		catch(IOException e){
			System.out.println("Error"+e);
		}
	}
}
