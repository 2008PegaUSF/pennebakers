package Questions;

public class questionSixteen {
	public int numberOfChar(String args[]) {
		int count = 0;
		
		for(int i = 0; i < args.length; i++) {
			count = count + args[i].length();
		}
		
		//System.out.println(count);
		
		return count;
	}
}
