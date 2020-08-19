package Main;

import java.util.*;

public class newAccount {
	
	//variables for storing their information
	private String firstName;
	private String lastName;
	private String phoneNumber;
	private String address;
	
	public void newAccount() {
		System.out.println("\nWelcome New User to the Bank App!");
		System.out.println("Please fill out the information below.");
		
		//calls the information method to be able to input the data/information
		information();
	}
	
	//Asks for information and stores the inputs in the variables
	public void information() {
		Scanner input = new Scanner(System.in);
		
		System.out.print("First Name: ");
		firstName = input.nextLine();
		System.out.print("Last Name: ");
		lastName = input.nextLine();
		System.out.print("Phone Number: ");
		phoneNumber = input.nextLine();
		System.out.print("Address: ");
		address = input.nextLine();
	}
	
	public String getFirstName() {
		return firstName;
	}
	
	public String getLastName() {
		return lastName;
	}
	
	public String getPhoneNumber() {
		return phoneNumber;
	}
	
	public String getAddress() {
		return address;
	}
}
