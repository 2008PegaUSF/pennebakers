package Questions;

public class questionThree {
	public String reverseString(String a) {
		String input = a;
		String output = "";
		String str;
		
		char[] rev = input.toCharArray();
		
		for(int i = rev.length-1; i >= 0; i--) {
			//System.out.print(rev[i]);
			str = Character.toString(rev[i]);
			output = output.concat(str);
		}
		return output;
	}

}
