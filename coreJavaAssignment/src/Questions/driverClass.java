package Questions;

import java.util.ArrayList;
import java.util.Collections;

public class driverClass {

	public static void main(String[] args) {
		
		//Question 1
		//Perform a bubble sort on the following integer array:  1,0,5,6,3,2,3,7,9,8,4
		int[] bubbleArray = {1,0,5,6,3,2,3,7,9,8,4};
		questionOne ob = new questionOne();
		ob.bubbleSort(bubbleArray);
		ob.printArray(bubbleArray);
		
		//Question 2
		//Write a program to display the first 25 Fibonacci numbers beginning at 0.
		//questionTwo f = new questionTwo();
		//System.out.println(f.fib(25));
		
		//Question 3
		//Reverse a string without using a temporary variable.  Do NOT use reverse() in the StringBuffer or the StringBuilder APIs.
		questionThree a = new questionThree();
		a.reverseString("Hello");
		
		System.out.println();
		
		//Question 4
		//Write a program to compute N factorial.
		questionFour b = new questionFour();
		b.fac(5);
		
		System.out.println();
		
		//Question 5
		//Write a substring method that accepts a string str and an integer idx and 
		//returns the substring contained between 0 and idx-1 inclusive.  Do NOT use any of the existing substring methods 
		//in the String, StringBuilder, or StringBuffer APIs.
		questionFive c = new questionFive();
		c.substring("Hello", 3);
		
		//Question 6
		//Write a program to determine if an integer is even without using the modulus operator (%)
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
		
		//Question 9
		//Create an ArrayList which stores numbers from 1 to 100 and prints out all the prime numbers to the console.
		//questionNine f = new questionNine();
		//f.printPrimeNumbers();
		
		//Question 10
		
		//Question12
		//Write a program to store numbers from 1 to 100 in an array. 
		//Print out all the even numbers from the array. Use the enhanced FOR loop for printing out the numbers.
		questionTwelve g = new questionTwelve();
		g.printEvenArray();
		
		
	}

}
