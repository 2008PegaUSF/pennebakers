package Questions;

public class questionSix {
	public boolean isEven(int n) {
		boolean isEven = true;
		boolean isFalse = false;
		
		for(int i = 1; i <= n; i++)
			isEven = !isEven;
		
		if(isEven == true)
			return isEven;
		else
			return isFalse;

	}
}
