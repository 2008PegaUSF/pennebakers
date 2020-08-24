package Questions;

public class questionFive {
	public String substring(String str, int idx) {
		char[] input = str.toCharArray();
		String output = "";
		for(int i = 0; i <= idx-1; i++) {
			output = output.concat(String.valueOf(input[i]));
		}
		return output;
	}
}
