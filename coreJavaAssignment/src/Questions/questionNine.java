package Questions;

import java.util.ArrayList;

public class questionNine {
	
	public void printPrimeNumbers() {
	ArrayList<Integer> numbers = new ArrayList<Integer>(100);
	
	for(int i = 1; i <= 100; i++) {
		numbers.add(i);
		}
	
	for(int temp : numbers) {
		System.out.println(temp);
	}
	
  }
}
