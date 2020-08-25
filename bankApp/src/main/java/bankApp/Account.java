package bankApp;

import java.io.Serializable;
import java.util.Scanner;

public class Account implements Serializable{
	

	private static final long serialVersionUID = 1L;

	//static Scanner input = new Scanner(System.in);
	
	//variables for storing their information
	private String firstname;
	private String lastname;
	private String username;
	private String password;
	private int uniqueID;
	private int balance;
	private boolean verified;
	
	public Account(String username, String password, String firstname, String lastname, int balance) {
		this.username = username;
		this.password = password;
		this.firstname = firstname;
		this.lastname = lastname;
		this.balance = balance;
	}
	
	@Override
	public String toString() {
		return "Account [username= " + username + ", password=" + password + ", firstname=" + firstname + ", lastname=" + lastname + ", balance=" + balance + "]";
	}
}
