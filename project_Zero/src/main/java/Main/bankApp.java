package Main;

import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.util.Scanner;

public final class bankApp {
	
	private static Scanner input = new Scanner(System.in);
	private static accUser usr;
	
	private bankApp() {
		run();
	}
	
	public static void run() {
		usr = new accUser();
		
		//method call for the login screen
		loginScreen();
	}
	
	public static void loginScreen() {
		System.out.println("Welcome to the banking app!");
		System.out.println("Select An Option Below...");
		System.out.println("1. Create an account");
		System.out.println("2. Log in");
		String option = input.nextLine();
		
		if(option.equals("1")) {
			createNewUser();
		}
		
		
	}
	
	
	public static void createNewUser() {
		String firstname;
		String lastname;
		String username;
		String password;
		
		System.out.println("Enter Your Username: ");
		username = input.nextLine();
		
		System.out.println("Enter Your Password: ");
		password = input.nextLine();
		
		System.out.println("Enter Your FirstName: ");
		firstname = input.nextLine();
		
		System.out.println("Enter Your Lastname: ");
		lastname = input.nextLine();
		
		accUser usr = new accUser(firstname, lastname, username, password);
		
		try {
			FileOutputStream fileout = new FileOutputStream("users.txt");
			ObjectOutputStream objectOut = new ObjectOutputStream(fileout);
			objectOut.writeObject(usr);
			objectOut.close();
			System.out.println("The user information was logged.");
		}catch(Exception ex) {
			ex.printStackTrace();
		}
		
	}
	
	
}
