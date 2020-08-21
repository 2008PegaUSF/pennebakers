package Questions;

import java.util.ArrayList;

public class questionNineteen {
	static ArrayList<Integer> ints = new ArrayList<Integer>();
	public void displayArrayList() {
		for(int i = 1; i <= 10; i++) {
			ints.add(i);
		}
		
		for(Integer a : ints) {
			System.out.print(a + " ");
		}
		
	}
	
	public void displayEvenArrayList() {
		System.out.println();
		for(Integer a : ints) {
			if(a%2 == 0) {
				System.out.print(a + " ");
			}
		}
	}
	
	public void displayOddArrayList() {
		System.out.println();
		for(Integer a : ints) {
			if(a%2 != 0) {
				System.out.print(a + " ");
			}
		}
	}
	
}
