
public class ImportantUniversity extends University {
	void enterRule(double math, double english, double chinese) {
		double total = math+english+chinese;
		if(total>=245)
			System.out.println("考分" + total + "达到大学最低录取线");
		else
			System.out.println("考分" + total + "未达到大学最低录取线");
	}
}
