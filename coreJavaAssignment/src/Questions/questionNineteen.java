package Questions;

import java.util.ArrayList;
import java.util.Arrays;

public class questionNineteen {
	String output = "";
	public boolean isPrime(int a) {
		if(a == 2) {
			return true;
		}
		int i, n = 0;
		
		n = a / 2;
		
		for(i = 2; i <= n; i++) {
			if(a % i == 0) {
				return false;
			}
		}
		return true;
	}
	
	public String questionNineteen() {
		ArrayList<Integer> alist = new ArrayList<>();
		
		for(int i = 1; i <= 10; i++) {
			alist.add(i);
		}
		
		int sumEven = 0;
		int sumOdd = 0;
		
		for(int b : alist) {
			if(b % 2 == 0)
				sumEven += b;
			else
				sumOdd += b;
		}
		
		System.out.println("List: " + Arrays.deepToString(alist.toArray()));
		System.out.println("Even number sum: " + sumEven);
		System.out.println("Odd number sum: " + sumOdd);
		
		System.out.println("\nRemoving prime number: ");
		for(int i = 1; i <= 10; i++) {
			if(isPrime(i)) {
				alist.remove(new Integer(i));
			}
		}
		
		//System.out.println("List: " + Arrays.toString(alist.toArray()));
		output = Arrays.toString(alist.toArray());
		
		return output;
	}
	
}