package Questions;

public class questionTwo {
	
	public void questionTwo() {
		int valueOne = 0, valueTwo = 1, value, count = 23;
		
		System.out.print(valueOne + " " + valueTwo);
		
		for(int i = 2; i <= count; i ++) {
			value = valueOne + valueTwo;
			System.out.print(" " + value);
			valueOne = valueTwo;
			valueTwo = value;
		}
	}
}
