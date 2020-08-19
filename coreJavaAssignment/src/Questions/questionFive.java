package Questions;

public class questionFive {
	void substring(String str, int idx) {
		char[] input = str.toCharArray();
		
		for(int i = 0; i <= idx-1; i++) {
			System.out.print(input[i]);
		}
		System.out.println();
	}
}
