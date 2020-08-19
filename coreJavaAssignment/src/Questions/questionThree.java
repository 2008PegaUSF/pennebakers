package Questions;

public class questionThree {
	public void reverseString(String a) {
		String input = a;
		
		char[] reverse = input.toCharArray();
		
		for(int i = reverse.length-1; i >= 0; i--) {
			System.out.print(reverse[i]);
		}
		System.out.println();
	}

}
