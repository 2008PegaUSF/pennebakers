package Questions;

public class questionTen {
	public int questionTen(int valueOne, int valueTwo, int valueThree){
		int temp, result;
		
		temp = valueOne < valueTwo ? valueOne:valueTwo;
		result = valueThree < temp ? valueThree:temp;
		
		System.out.println("Values Inputted: " + valueOne + ", " + valueTwo + ", " + valueThree);
		System.out.println("Smallest value: " + result);
		
		return result;
	}
}
