package Questions;

public class questionThree {
	public void reverseString(String a) {
		String input = a;
		
		char[] rev = input.toCharArray();
		
		for(int i = rev.length-1; i >= 0; i--) {
			System.out.print(rev[i]);
		}
		System.out.println();
	}

}
