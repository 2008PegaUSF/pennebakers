package Questions;

import java.util.Scanner;
import java.time.LocalDate;
import java.lang.Math;
import java.util.Arrays;
import java.util.Random;

public class questionFourteen {
	public String switchCasePrint() {
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
			Scanner inputValue = new Scanner(System.in);
			System.out.println("Enter a number: ");
			double number = inputValue.nextDouble();
			square = Math.pow(number, 2);
			System.out.println("The square value of: " + number + "\nEquals: " + square);
			String strSolved = Double.toHexString(square);
		case 2:
			System.out.println(myObj);
			strSolved = myObj.toString();
			return strSolved;
		case 3:
			String string = "I am learning Core Java";
			String[] strArray = string.split("g", 2);
			
			for(String a : strArray) {
				System.out.println(a);
			}
			strSolved = Arrays.toString(strArray);
			return strSolved;
		default:
			strSolved = "";
			return strSolved;
		}
	}
	
}
