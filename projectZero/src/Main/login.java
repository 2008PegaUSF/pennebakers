package Main;

import java.util.*;

public class login {
	
	private String username;
	private String password;

	public void login() {
		Scanner input = new Scanner(System.in);
		
		System.out.printf("Welcome to Bank App\nPlease enter your Username & Password below\n\n");
		
		System.out.println("Username: ");
		username = input.nextLine();
		
		System.out.println("Password: ");
		password = input.nextLine();
		
		
	}
	
	public String getUserName() {
		return username;
	}
	
	public String getPassword() {
		return password;
	}
	
	
	
	
	
	
}
