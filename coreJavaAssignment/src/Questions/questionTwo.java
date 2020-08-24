package Questions;

public class questionTwo {
	
	public int[] questionTwo() {
		int valueOne = 0, valueTwo = 1, value, count = 23;
		int[] arrReturn = new int[24];
		arrReturn[0] = valueOne;
		arrReturn[1] = valueTwo;
		
		//System.out.print(valueOne + " " + valueTwo);
		
		for(int i = 2; i <= count; i ++) {
			value = valueOne + valueTwo;
			arrReturn[i] = value;
			//System.out.print(" " + value);
			valueOne = valueTwo;
			valueTwo = value;
		}
		
		return arrReturn;
	}
}
