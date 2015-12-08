import java.util.*;
import static java.util.Calendar.*;  //静态导入Calendar类的静态常量  如果不导入  ，YEAR  MONTH  等等Calendar类静态常量都不可识别
public class Cal_Time {
	public static void main(String[] args) {
		Calendar calendar = Calendar.getInstance();//利用Calendar的static方法初始化一个日历对象；
		int year = calendar.get(YEAR);
		int month = calendar.get(MONTH);
		int day = calendar.get(DAY_OF_WEEK);
		int hour = calendar.get(HOUR_OF_DAY);
		int minute = calendar.get(MINUTE);
		int second = calendar.get(SECOND);
		System.out.println("当前时间是："+ year + "年" + month  + "月" + day + "日" + hour + "时" + minute + "分" + second + "秒");
		if(day == 1) {  //如果是一个月份的1号
			if((month==2)||(month==4)||(month==6)||(month==9)||(month==11)) { //如果当前月份是小月或者平月，则上月份一定是大月
				day = 31;
				month--;
			}
			else if(month==3) {//由于二月份是平月，所以要特判month=3
				if(((year%4==0)&&(year%100!=0))||(year%400==0)) {//如果是闰年
					day = 29;
					month--;
				}
				else {
					day = 28;//平年
					month--;
				}
			}
			else if(month==1) {//特殊情况新年第一天
				day = 31;
				month = 12;
				year--;
			}
			else {//5.7.8.10.12这几个月份
				day = 30;
				month--;
			}
			System.out.println("昨天的当前时间是："+ year + "年" + month  + "月" + day + "日" + hour + "时" + minute + "分" + second + "秒");
		}
		else { //是一个月当中除了1号的某一天
			day--;
			System.out.println("昨天的当前时间是："+ year + "年" + month  + "月" + day + "日" + hour + "时" + minute + "分" + second + "秒");
		}
	}
}
/*  解题思路：
 * 
 * 	1.获取当前时间（即一个月份的1号）；

	2.分别获取当前时间的年月日时分秒，并且保存；

	3.计算前一天的当前时间:
		1> .判断是否月份临界点；
		2> .对于二月份要加上是否闰年的判断处理；
		3> .还有一种新年第一天的情况；
	*/
 