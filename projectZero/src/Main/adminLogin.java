package Main;

import java.util.*;

public class adminLogin {
	
	private String username;
	private String password;
	
	public void adminLogin() {
		System.out.println("\nWelcome To The Bank App Admin Login Page\nPlease Enter Your Username and Password");
		
		credentials();
		
	}
	
	public void credentials() {
		Scanner input = new Scanner(System.in);
		
		System.out.print("Username: ");
		username = input.nextLine();
		System.out.print("Password: ");
		password = input.nextLine();
	}
}
