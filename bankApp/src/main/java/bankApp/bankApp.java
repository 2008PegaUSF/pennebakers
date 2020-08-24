package bankApp;

import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Scanner;

public class bankApp{
	
	Scanner optionInput = new Scanner(System.in);
	int optionSelected; 
	
	ArrayList<Account> accounts = new ArrayList<Account>();
    String username;
	String password;
	String firstname;
	String lastname;
	int balance;
	
	public void run() {
		homeScreen();
	}
	
	public void homeScreen() {
		System.out.println("Welcome To The Bank App");
		System.out.println("Select an Option Below...");
		System.out.println("1.Create An Account");
		System.out.println("2.Create A Joint Account");
		System.out.println("3.Login");
		System.out.println("4.Exit");
		optionSelected = optionInput.nextInt();
		optionInput.nextLine();
		
		
		if(optionSelected == 1) {
			System.out.println("First Name: ");
			firstname = optionInput.nextLine();
			System.out.println("Last Name: ");
			lastname = optionInput.nextLine();
			System.out.println("Username: ");
			username = optionInput.nextLine();
			System.out.println("password: ");
			password = optionInput.nextLine();
			
			balance = 0;
			accounts.add(new Account(username, password, firstname, lastname));
			
			try {
				FileOutputStream fileout = new FileOutputStream("usersInfo.txt", true);
				ObjectOutputStream objectOut = new ObjectOutputStream(fileout);
				objectOut.writeObject(accounts);
				objectOut.close();
				fileout.close();
				System.out.println("The user information was logged.");
			}
			catch(Exception ex) {
				ex.printStackTrace();
			}
		}
		else if(optionSelected == 2) {
			//createJointAccount();
		}
		else if(optionSelected == 3) {
			//loginScreen();
		}
		else {
			System.exit(0);
		}
		
	}

}
