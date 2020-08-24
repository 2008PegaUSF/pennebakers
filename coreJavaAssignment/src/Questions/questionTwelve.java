package Questions;

import java.util.Arrays;
import java.util.Scanner;

public class questionTwelve {
	public String printEvenArray() {
		String output = "";
		
		// declaring numbers
		int numbers[] = new int[100];
		  
		// assigning 1 to 100
		for(int i=1; i<=100; i++)
		{
		numbers[i-1] = i;
		}
		  
		// enhanced for loop
		for (int num: numbers) {
			if(num%2 == 0) {
				System.out.print(num+" ");
				output = output.concat(Integer.toString(num));
			}
		}
		
		return output;
		
		
	
  }
}

