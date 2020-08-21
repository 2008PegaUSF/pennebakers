package Questions;

import floatValueOne.floatValueOne;
import floatValueTwo.floatValueTwo;

public class driverClass {

	public static void main(String[] args) {
		
		//Question 1
		//Perform a bubble sort on the following integer array:  1,0,5,6,3,2,3,7,9,8,4
		System.out.println("Question 1");
		int[] bubbleArray = {1,0,5,6,3,2,3,7,9,8,4};
		questionOne ob = new questionOne();
		ob.bubbleSort(bubbleArray);
		ob.printArray(bubbleArray);
		
		//Question 2
		//Write a program to display the first 25 Fibonacci numbers beginning at 0.
		System.out.println("\nQuestion 2");
		questionTwo k = new questionTwo();
		k.questionTwo();
		System.out.println();
		
		//Question 3
		//Reverse a string without using a temporary variable.  Do NOT use reverse() in the StringBuffer or the StringBuilder APIs.
		System.out.println("\nQuestion 3");
		questionThree a = new questionThree();
		a.reverseString("Hello");
		
		System.out.println();
		
		//Question 4
		//Write a program to compute N factorial.
		System.out.println("\nQuestion 4");
		questionFour b = new questionFour();
		b.fac(5);
		
		System.out.println();
		
		//Question 5
		//Write a substring method that accepts a string str and an integer idx and 
		//returns the substring contained between 0 and idx-1 inclusive.  Do NOT use any of the existing substring methods 
		//in the String, StringBuilder, or StringBuffer APIs.
		System.out.println("\nQuestion 5");
		questionFive c = new questionFive();
		c.substring("Hello", 3);
		
		//Question 6
		//Write a program to determine if an integer is even without using the modulus operator (%)
		System.out.println("\nQuestion 6");
		questionSix u = new questionSix();
		u.isEven(3);
		
		/*Question7
		ArrayList<questionSeven> ar = new ArrayList<questionSeven>();
		ar.add(new questionSeven("Seth", "Math", 23));
		ar.add(new questionSeven("Dave", "Poly Sci", 23));
		questionSeven e = new questionSeven();
		Collections.sort(ar, new SortByAge());
		*/
		
		//Question 8
		//Write a program that stores the following strings in an ArrayList and saves all the palindromes in another ArrayList.
		System.out.println("\nQuestion 8");
		questionEight i = new questionEight();
		i.palindrome();
		
		
		//Question 9
		//Create an ArrayList which stores numbers from 1 to 100 and prints out all the prime numbers to the console.
		System.out.println("\nQuestion9");
		questionNine f = new questionNine();
		f.printPrimeNumbers();
		
		//Question 10
		//Find the minimum of two numbers using ternary operators
		System.out.println("\nQuestion 10");
		questionTen ten = new questionTen(25, 222, 666);
		
		
		//Question 11. 
		//Write a program that would access two float-variables from a class that exists in 
		//another package. Note, you will need to create two packages to demonstrate the solution.
		System.out.println("\nQuestion 11");
		floatValueOne one = new floatValueOne();
		floatValueTwo two = new floatValueTwo();
		System.out.println(one.getValueOne());
		System.out.println(two.getValueTwo());
		
		
		
		//Question12
		//Write a program to store numbers from 1 to 100 in an array. 
		//Print out all the even numbers from the array. Use the enhanced FOR loop for printing out the numbers.
		System.out.println("\nQuestion 12");
		questionTwelve g = new questionTwelve();
		g.printEvenArray();
		
		//Question13
		System.out.println("\nQuestion 13");
		
		//Question 14
		//Write a program that demonstrates the switch case. Implement the following functionalities in the cases:java
		//Case 1: Find the square root of a number using the Math class method.
		//Case 2: Display today’s date.
		//Case 3: Split the following string and store it in a string array. “I am learning Core Java”
		System.out.println("\nQuestion 14");
		questionFourteen n = new questionFourteen();
		n.switchCasePrint();
		
		//Question 15
		System.out.println("\nQuestion 15");
		questionFifteenPTwo m = new questionFifteenPTwo();
		m.addition(15, 30);
		m.division(2, 4);
		m.multiplication(5, 5);
		m.subtraction(100, 50);
		
		//Question 16
		//Write a program to display the number of characters for a string input. 
		//The string should be entered as a command line argument using (String [ ] args).
		  System.out.println("\nQuestion 16");
		//questionSixteen j = new questionSixteen();
		//j.display();
		
		//Question 17
		//Write a program that calculates the simple interest on the principal, rate of interest and number of 
		//years provided by the user. Enter principal, rate and time through the console using the Scanner class.
		//Interest = Principal* Rate* Time
		System.out.println("\nQuestion 17");
		questionSeventeen o = new questionSeventeen();
		o.calculateInterest();
		
		//Question 18
		//
		System.out.println("\nQuestion 18");
		
		//Question 19
		//Create an ArrayList and insert integers 1 through 10. Display the 
		//ArrayList. Add all the even numbers up and display the result. Add 
		//all the odd numbers up and display the result. 
		//Remove the prime numbers from the ArrayList and 
		//print out the remaining ArrayList.
		System.out.println("\nQuestion 19");
		questionNineteen e = new questionNineteen();
		e.displayArrayList();
		e.displayEvenArrayList();
		e.displayOddArrayList();
		
		//Question 20
		System.out.println("\nQuestion 20");
	}
	


}
