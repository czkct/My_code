import java.util.*;
import static java.util.Calendar.*;  //��̬����Calendar��ľ�̬����  ���������  ��YEAR  MONTH  �ȵ�Calendar�ྲ̬����������ʶ��
public class Cal_Time {
	public static void main(String[] args) {
		Calendar calendar = Calendar.getInstance();//����Calendar��static������ʼ��һ����������
		int year = calendar.get(YEAR);
		int month = calendar.get(MONTH);
		int day = calendar.get(DAY_OF_WEEK);
		int hour = calendar.get(HOUR_OF_DAY);
		int minute = calendar.get(MINUTE);
		int second = calendar.get(SECOND);
		System.out.println("��ǰʱ���ǣ�"+ year + "��" + month  + "��" + day + "��" + hour + "ʱ" + minute + "��" + second + "��");
		if(day == 1) {  //�����һ���·ݵ�1��
			if((month==2)||(month==4)||(month==6)||(month==9)||(month==11)) { //�����ǰ�·���С�»���ƽ�£������·�һ���Ǵ���
				day = 31;
				month--;
			}
			else if(month==3) {//���ڶ��·���ƽ�£�����Ҫ����month=3
				if(((year%4==0)&&(year%100!=0))||(year%400==0)) {//���������
					day = 29;
					month--;
				}
				else {
					day = 28;//ƽ��
					month--;
				}
			}
			else if(month==1) {//������������һ��
				day = 31;
				month = 12;
				year--;
			}
			else {//5.7.8.10.12�⼸���·�
				day = 30;
				month--;
			}
			System.out.println("����ĵ�ǰʱ���ǣ�"+ year + "��" + month  + "��" + day + "��" + hour + "ʱ" + minute + "��" + second + "��");
		}
		else { //��һ���µ��г���1�ŵ�ĳһ��
			day--;
			System.out.println("����ĵ�ǰʱ���ǣ�"+ year + "��" + month  + "��" + day + "��" + hour + "ʱ" + minute + "��" + second + "��");
		}
	}
}
/*  ����˼·��
 * 
 * 	1.��ȡ��ǰʱ�䣨��һ���·ݵ�1�ţ���

	2.�ֱ��ȡ��ǰʱ���������ʱ���룬���ұ��棻

	3.����ǰһ��ĵ�ǰʱ��:
		1> .�ж��Ƿ��·��ٽ�㣻
		2> .���ڶ��·�Ҫ�����Ƿ�������жϴ���
		3> .����һ�������һ��������
	*/
 