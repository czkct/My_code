

import java.util.Calendar;


public class test14 {
	public static void main(String[] args){
//ѡ������
		//�㷨˼·����һ�δ�n������ѡ��С�ķŵ���0��λ�ã�
		//       �ڶ��δ�n-1������ѡ��С�ķŵ���1��λ�ã��Դ����ƣ�
		int[] arry={3,5,1,7,6,2,9,0};
		for(int j=0;j<arry.length-1;j++)
		{
			int min_i=j;  //��֪��Сֵ���±�
			for (int i = j+1; i < arry.length; i++) {
				if(arry[min_i]>arry[i])
					min_i=i;//������Сֵ�±�
			}
			int temp=arry[j];   //������Сֵ
			arry[j]=arry[min_i];
			arry[min_i]=temp;
		}
		System.out.print("ѡ������");
		for (int i = 0; i < arry.length; i++) {
			if(i>0) System.out.print(","+arry[i]);
			else System.out.print(arry[i]);
		}
		System.out.println();
		
		
		
		
//ð������
		int[] ar={3,5,1,7,6};
		//3 1 5 6 7
		//1 3 5 6 7
		
		for(int j=0;j<ar.length-1;j++)   //��������  ar.length
		{
			for (int i = 0; i < ar.length-1; i++) {
				if(ar[i]>ar[i+1]) //��С����
				{
					int temp=ar[i];
					ar[i]=ar[i+1];
					ar[i+1]=temp;
				}
			}
		}
		
		System.out.print("ð������");
		for (int i = 0; i < ar.length; i++) {
			if(i>0) System.out.print(","+ar[i]);
			else System.out.print(ar[i]);
		}
		System.out.println();
//����
		int[] arr={5,7,6,8,9,1,10,2,3,12};  
	
		for(int i=0;i<arr.length-1;i++)
		{
			for (int j = i+1; j < arr.length; j++) {
				if(arr[i]>arr[j]) //Ŀ�ģ���С��������
				{
					int temp=arr[i];
					arr[i]=arr[j];
					arr[j]=temp;
				}
			}
		}
		System.out.print("���֣�");
		for (int i = 0; i < arr.length; i++) {
			if(i>0) System.out.print(","+arr[i]);
			else System.out.print(arr[i]);
		}
		System.out.println();
//���ֲ���
		//�㷨˼·��
		//��mid
		//1.mid==Ŀ��    �ҵ���
		//2.mid<Ŀ��  ��left���ƣ�
		//3.mid>Ŀ�꣨right���ƣ�
		int[] arr1={1,2,3,5,6,7,8,9,10,12};    //��������
		
		int left=0;   //����߽�
		int right=arr1.length-1;  //���ұ߽�
		int x = 5;//��������x
		while (left<=right) {
			int mid=(left+right)/2;
			if(arr[mid]==x)
			{
				System.out.println("����");
				System.out.println("λ���ǵ�"+(mid+1)+"����");
				break;
			}
			//---------------  --------|-------
			if(arr1[mid]<x)
			{
				left=mid+1;//��߽�����
			}
			if(arr1[mid]>x)
			{
				right=mid-1;//�ұ߽�����
			}

		}
		if(left>right)
			System.out.println("������");
		
//Calendar��
		Calendar cal = Calendar.getInstance();//��ȡ��ǰ���������
		System.out.println(cal);
		// ��ǰ��
		System.out.println(Calendar.YEAR);  //��Щ����ID���
		int year = cal.get(Calendar.YEAR);
		System.out.println("�꣺"+year);
		
		// ��ǰ�� Calendar.MONTH��0��ʼ
		System.out.println(Calendar.MONTH);
		int month = (cal.get(Calendar.MONTH)) + 1;
		System.out.println("month��"+month);
		
		// ��ǰ�µĵڼ���:����ǰ��
		System.out.println(Calendar.DAY_OF_MONTH);
		int day_of_month = cal.get(Calendar.DAY_OF_MONTH);
		System.out.println("day��"+day_of_month);
		
		// Calendar.DAY_OF_MONTH �� Calendar.DATE �ǵȼ۵�
		System.out.println(Calendar.DATE);
		int date = cal.get(Calendar.DATE);
		System.out.println("date"+date);
		
		// ��ǰʱ��:HOUR_OF_DAY-24Сʱ��
		System.out.println(Calendar.HOUR_OF_DAY);
		int hour24 = cal.get(Calendar.HOUR_OF_DAY);
		System.out.println("hour��"+hour24);
		
		// HOUR-12Сʱ��
		System.out.println(Calendar.HOUR);
		int hour12 = cal.get(Calendar.HOUR);
		System.out.println("hour��"+hour12);
		
		// ��ǰ:����
		System.out.println(Calendar.MINUTE);
		int minute = cal.get(Calendar.MINUTE);
		System.out.println("minute��"+minute);
		
		// ��ǰ��
		System.out.println(Calendar.SECOND);
		int second = cal.get(Calendar.SECOND);
		System.out.println("second��"+second);
		
		// ���ڼ� Calendar.DAY_OF_WEEK�����֣�1~7����ʾ��������~��������
		System.out.println(Calendar.DAY_OF_WEEK);
		int day_of_week = cal.get(Calendar.DAY_OF_WEEK) - 1;
		System.out.println("day_of_week��"+day_of_week);
		
		// 0-���磻1-����
		System.out.println(Calendar.AM_PM);
		int ampm = cal.get(Calendar.AM_PM);
		System.out.println("���绹�����磺"+ampm);

		// ��ǰ��ĵڼ���
		System.out.println(Calendar.WEEK_OF_YEAR);
		int week_of_year = cal.get(Calendar.WEEK_OF_YEAR);
		System.out.println("��ǰ��ĵڼ��ܣ�"+week_of_year);

		// ��ǰ�µ�������
		System.out.println(Calendar.WEEK_OF_MONTH);
		int week_of_month = cal.get(Calendar.WEEK_OF_MONTH);
		System.out.println("��ǰ�µ���������"+week_of_month);

		// ��ǰ���еĵڼ�������
		System.out.println(Calendar.DAY_OF_WEEK_IN_MONTH);
		int day_of_week_in_month = cal.get(Calendar.DAY_OF_WEEK_IN_MONTH);
		System.out.println("��ǰ���еĵڼ������ڣ�"+day_of_week_in_month);

		// ��ǰ��ĵڼ���
		System.out.println(Calendar.DAY_OF_YEAR);
		int day_of_year = cal.get(Calendar.DAY_OF_YEAR);
		System.out.println("��ǰ��ĵڼ��죺"+day_of_year);
	}
}
