package Main;

import java.util.*;

public class login {
	
	private String username;
	private String password;

	public void login() {
		Scanner input = new Scanner(System.in);
		
		System.out.println("Welcome Back To The Bank App.\nPlease Enter Your Username and Password");
		
		System.out.print("Username: ");
		username = input.nextLine();
		
		System.out.print("Password: ");
		password = input.nextLine();
		
		
	}
	
	public String getUserName() {
		return username;
	}
	
	public String getPassword() {
		return password;
	}
	
	
	
	
	
	
}
