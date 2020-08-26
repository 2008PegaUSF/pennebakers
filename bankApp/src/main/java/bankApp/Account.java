package bankApp;

import java.io.Serializable;
import java.util.Scanner;

public class Account implements Serializable{
	

	private static final long serialVersionUID = 1L;

	//static Scanner input = new Scanner(System.in);
	
	//variables for storing their information
	private String firstname;
	private String lastname;
	private String secondFirstName;
	private String secondLastName;
	private String username;
	private String password;
	private int balance;
	private boolean verified;
	
	public Account(String username, String password, String firstname, String lastname, String secondFirstName, String secondLastName, int balance, boolean verified) {
		this.username = username;
		this.password = password;
		this.firstname = firstname;
		this.lastname = lastname;
		this.secondFirstName = secondFirstName;
		this.secondLastName = secondLastName;
		this.balance = balance;
		this.verified = verified;
	}
	
	@Override
	public String toString() {
		return "Account [username=" + username + ", password=" + password + ", firstname=" + firstname + ", lastname=" + lastname +  ", secondFirstName=" + secondFirstName + ", secondLastName=" + secondLastName + ", balance=" + balance + ", verified=" + verified + "]";
	}

	public String getUsername() {
		return username;
	}
	
	public String getPassword() {
		return password;
	}
	
	public String getFirstname() {
		return firstname;
	}
	
	public String getLastname() {
		return lastname;
	}
	
	public String getSecondFirstName() {
		return secondFirstName;
	}
	
	public String getSecondLastName() {
		return secondLastName;
	}
	
	public int getBalance() {
		return balance;
	}
	
	public boolean getVerified() {
		return verified;
	}
	
	public void setBalance(int input) {
		this.balance = input;
	}
	
	public void setVerified(boolean verified) {
		this.verified = verified;
	}
	
}
