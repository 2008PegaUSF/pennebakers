package Questions;

public class questionSix {
	public void isEven(int n) {
		boolean isEven = true;
		
		for(int i = 1; i <= n; i++)
			isEven = !isEven;
		
		if(isEven == true)
			System.out.println("Even");
		else
			System.out.println("Odd");

	}
}
