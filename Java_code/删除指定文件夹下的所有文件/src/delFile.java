import java.io.*;

public class delFile {
	void del(String str) {//�ݹ�ɾ����
		File f = new File(str);
		File [] fs = f.listFiles();
		for(File c:fs){
			if(c.delete()){ //����ֵΪtrue
				continue;
			}
			else { //ɾ�����ɹ�
				//��¼���ɾ�����ɹ��Ķ���
				File x = c;
				del(str+"/"+c.getName());
				c.delete(); //�ļ����µ����ļ�ȫ��ɾ����ϣ�ɾ���ÿ��ļ���
			}
		}
	}
}
