
public class ImportantUniversity extends University {
	void enterRule(double math, double english, double chinese) {
		double total = math+english+chinese;
		if(total>=245)
			System.out.println("����" + total + "�ﵽ��ѧ���¼ȡ��");
		else
			System.out.println("����" + total + "δ�ﵽ��ѧ���¼ȡ��");
	}
}
