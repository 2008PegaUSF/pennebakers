package Questions;

import java.util.Scanner;


public class questionSeventeen {
	
	private int principal;
	private int time;
	private int rate;
	
	public int calculateInterest() {
		int output;
		enterPrincipal();
		enterTime();
		enterRate();
		output = (getPrincipal() * getTime() * getRate());
		System.out.println("Interest: " + (getPrincipal() * getTime() * getRate()));
		return output;
	}
	
	public void enterPrincipal() {
		Scanner inputP = new Scanner(System.in);
		System.out.println("Enter Your Principal: ");
		principal = inputP.nextInt();
		
	}
	
	public void enterTime() {
		Scanner inputT = new Scanner(System.in);
		System.out.println("Enter Your Time: ");
		time = inputT.nextInt();
		
	}
	
	public void enterRate() {
		Scanner inputR = new Scanner(System.in);
		System.out.println("Enter Your Rate: ");
		rate = inputR.nextInt();
		
	}
	
	public int getPrincipal() {
		return principal;
	}
	
	public int getTime() {
		return time;
	}
	
	public int getRate() {
		return rate;
	}
}
