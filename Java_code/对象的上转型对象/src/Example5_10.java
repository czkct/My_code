
public class Example5_10 {
	public static void main(String[] args) {
		People people = null;
		American Johnson = new American();
		people = Johnson;
		people.height = 187;
		people.weight = 78.67;
		people.showBodyMess();
		people.mustDoingThing();
		Chinese zhang = new Chinese();
		people = zhang;
		people.height = 177;
		people.weight = 68.59;
		people.showBodyMess();
		people.mustDoingThing();
		
		
		zhang = (Chinese)people;
		zhang.speakChinese();
	}
}
