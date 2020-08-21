package Questions;

import java.util.Scanner;
import java.time.LocalDate;
import java.lang.Math; 
import java.util.Random;

public class questionFourteen {
	public void switchCasePrint() {
		LocalDate myObj = LocalDate.now();
		Random rand = new Random();
		
		int upperbound = 100;
		
		double square;
		
		int value;
		Scanner input = new Scanner(System.in);
		
		System.out.println("Enter a number from 1-3: ");
		value = input.nextInt();
		//input.close();
	
		
		switch(value) {
		case 1:
			int int_random = rand.nextInt(upperbound);
			square = Math.pow(int_random, 2);
			System.out.println("The square value of: " + int_random + "\nEquals: " + square);
			break;
		case 2:
			System.out.println(myObj);
			break;
		case 3:
			String string = "I am learning Core Java";
			String[] strArray = string.split("g", 2);
			
			for(String a : strArray) {
				System.out.println(a);
			}
			break;
		}
	}
	
}
