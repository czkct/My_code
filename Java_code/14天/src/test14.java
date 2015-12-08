

import java.util.Calendar;


public class test14 {
	public static void main(String[] args){
//选择排序
		//算法思路：第一次从n个里面选最小的放到第0个位置；
		//       第二次从n-1个里面选最小的放到第1个位置；以此类推；
		int[] arry={3,5,1,7,6,2,9,0};
		for(int j=0;j<arry.length-1;j++)
		{
			int min_i=j;  //暂知最小值的下标
			for (int i = j+1; i < arry.length; i++) {
				if(arry[min_i]>arry[i])
					min_i=i;//交换最小值下标
			}
			int temp=arry[j];   //交换最小值
			arry[j]=arry[min_i];
			arry[min_i]=temp;
		}
		System.out.print("选择排序：");
		for (int i = 0; i < arry.length; i++) {
			if(i>0) System.out.print(","+arry[i]);
			else System.out.print(arry[i]);
		}
		System.out.println();
		
		
		
		
//冒泡排序：
		int[] ar={3,5,1,7,6};
		//3 1 5 6 7
		//1 3 5 6 7
		
		for(int j=0;j<ar.length-1;j++)   //遍历次数  ar.length
		{
			for (int i = 0; i < ar.length-1; i++) {
				if(ar[i]>ar[i+1]) //从小到大
				{
					int temp=ar[i];
					ar[i]=ar[i+1];
					ar[i+1]=temp;
				}
			}
		}
		
		System.out.print("冒泡排序：");
		for (int i = 0; i < ar.length; i++) {
			if(i>0) System.out.print(","+ar[i]);
			else System.out.print(ar[i]);
		}
		System.out.println();
//变种
		int[] arr={5,7,6,8,9,1,10,2,3,12};  
	
		for(int i=0;i<arr.length-1;i++)
		{
			for (int j = i+1; j < arr.length; j++) {
				if(arr[i]>arr[j]) //目的：从小到大排列
				{
					int temp=arr[i];
					arr[i]=arr[j];
					arr[j]=temp;
				}
			}
		}
		System.out.print("变种：");
		for (int i = 0; i < arr.length; i++) {
			if(i>0) System.out.print(","+arr[i]);
			else System.out.print(arr[i]);
		}
		System.out.println();
//二分查找
		//算法思路：
		//找mid
		//1.mid==目标    找到了
		//2.mid<目标  （left右移）
		//3.mid>目标（right左移）
		int[] arr1={1,2,3,5,6,7,8,9,10,12};    //必须有序
		
		int left=0;   //最左边界
		int right=arr1.length-1;  //最右边界
		int x = 5;//待查找数x
		while (left<=right) {
			int mid=(left+right)/2;
			if(arr[mid]==x)
			{
				System.out.println("存在");
				System.out.println("位置是第"+(mid+1)+"个！");
				break;
			}
			//---------------  --------|-------
			if(arr1[mid]<x)
			{
				left=mid+1;//左边界右移
			}
			if(arr1[mid]>x)
			{
				right=mid-1;//右边界左移
			}

		}
		if(left>right)
			System.out.println("不存在");
		
//Calendar类
		Calendar cal = Calendar.getInstance();//获取当前日历类对象
		System.out.println(cal);
		// 当前年
		System.out.println(Calendar.YEAR);  //这些都是ID编号
		int year = cal.get(Calendar.YEAR);
		System.out.println("年："+year);
		
		// 当前月 Calendar.MONTH从0开始
		System.out.println(Calendar.MONTH);
		int month = (cal.get(Calendar.MONTH)) + 1;
		System.out.println("month："+month);
		
		// 当前月的第几天:即当前日
		System.out.println(Calendar.DAY_OF_MONTH);
		int day_of_month = cal.get(Calendar.DAY_OF_MONTH);
		System.out.println("day："+day_of_month);
		
		// Calendar.DAY_OF_MONTH 和 Calendar.DATE 是等价的
		System.out.println(Calendar.DATE);
		int date = cal.get(Calendar.DATE);
		System.out.println("date"+date);
		
		// 当前时钟:HOUR_OF_DAY-24小时制
		System.out.println(Calendar.HOUR_OF_DAY);
		int hour24 = cal.get(Calendar.HOUR_OF_DAY);
		System.out.println("hour："+hour24);
		
		// HOUR-12小时制
		System.out.println(Calendar.HOUR);
		int hour12 = cal.get(Calendar.HOUR);
		System.out.println("hour："+hour12);
		
		// 当前:分钟
		System.out.println(Calendar.MINUTE);
		int minute = cal.get(Calendar.MINUTE);
		System.out.println("minute："+minute);
		
		// 当前秒
		System.out.println(Calendar.SECOND);
		int second = cal.get(Calendar.SECOND);
		System.out.println("second："+second);
		
		// 星期几 Calendar.DAY_OF_WEEK用数字（1~7）表示（星期日~星期六）
		System.out.println(Calendar.DAY_OF_WEEK);
		int day_of_week = cal.get(Calendar.DAY_OF_WEEK) - 1;
		System.out.println("day_of_week："+day_of_week);
		
		// 0-上午；1-下午
		System.out.println(Calendar.AM_PM);
		int ampm = cal.get(Calendar.AM_PM);
		System.out.println("上午还是下午："+ampm);

		// 当前年的第几周
		System.out.println(Calendar.WEEK_OF_YEAR);
		int week_of_year = cal.get(Calendar.WEEK_OF_YEAR);
		System.out.println("当前年的第几周："+week_of_year);

		// 当前月的星期数
		System.out.println(Calendar.WEEK_OF_MONTH);
		int week_of_month = cal.get(Calendar.WEEK_OF_MONTH);
		System.out.println("当前月的星期数："+week_of_month);

		// 当前月中的第几个星期
		System.out.println(Calendar.DAY_OF_WEEK_IN_MONTH);
		int day_of_week_in_month = cal.get(Calendar.DAY_OF_WEEK_IN_MONTH);
		System.out.println("当前月中的第几个星期："+day_of_week_in_month);

		// 当前年的第几天
		System.out.println(Calendar.DAY_OF_YEAR);
		int day_of_year = cal.get(Calendar.DAY_OF_YEAR);
		System.out.println("当前年的第几天："+day_of_year);
	}
}
