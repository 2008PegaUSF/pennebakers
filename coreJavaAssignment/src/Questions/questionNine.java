package Questions;

import java.util.ArrayList;

public class questionNine {
	public void printPrimeNumbers() {
	
	int i = 0;
	int num = 0;
		
	ArrayList<Integer> numbers = new ArrayList<Integer>(100);
	
	//for(int i = 1; i <= 100; i++) {
	//	numbers.add(i);
	//	}
	
	for(i = 1; i <= 100; i++) {
		int counter = 0;
		for(num = i; num >= 1; num--) {
			if(i%num==0) {
				counter = counter + 1;
			}
		}
		if(counter == 2)
		{
			numbers.add(i);
		}
	}
	
	for(Integer a : numbers) {
		System.out.print(a + " ");
	}
	
  }
}
