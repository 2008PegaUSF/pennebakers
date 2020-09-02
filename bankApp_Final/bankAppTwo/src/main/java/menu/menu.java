package menu;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import DAO.AccountDao;
import beans.Account;
import beans.User;
import connection.ConnFactory;
import daoImplementations.AccountDaoImpl;
import daoImplementations.UserDaoImpl;

public class menu {
	
	static Logger log=LogManager.getLogger(menu.class);
	static Scanner scan = new Scanner(System.in);
	static User user = new User();
	public static void welcomeScreen() throws SQLException {
		
		System.out.println("Welcome To The Banking App!");
		System.out.println("Please Select An Option Below...");
		System.out.println("1. Create An Account.");
		System.out.println("2. Customer Login.");
		System.out.println("3. Admin Login.");
		System.out.println("4. Exit.");
		int option = scan.nextInt();
		
		switch(option) {
		case 1:
			createAccount();
			break;
		case 2:
			customerLogin();
			break;
		case 3:
			adminLogin();
			break;
		case 4:
			System.out.println("\nThank You For Choosing The Banking App!");
			System.out.println("Please Come Back Soon!");
			System.exit(0);
		}
	}
	public static void adminLogin() throws SQLException {
		scan.nextLine();
		String usernameInput;
		String passwordInput;
		System.out.println("\nWelcome To The Admin Login Screen...");
		System.out.println("Please Enter Your Login Information Below.");
		System.out.println("Username: ");
		usernameInput = scan.nextLine();
		System.out.println("Password: ");
		passwordInput = scan.nextLine();	
		
		if(usernameInput.equals("admin") && passwordInput.equals("admin")) {
			adminHomeScreen();
		}
		else {
			System.out.println("Error, Try Again...");
			welcomeScreen();
		}
	}

	public static void adminHomeScreen() throws SQLException {
		Scanner scan = new Scanner(System.in);
		System.out.println("Welcome To The Admin Home Page...");
		System.out.println("Please Select An Option Below...");
		
		System.out.println("1.View All Users.");
		System.out.println("2.View All Accounts.");
		System.out.println("3.Create New User.");
		System.out.println("4.Update A User.");
		System.out.println("5.Delete A User.");
		System.out.println("6.Logout.");
		int input = scan.nextInt();
		
		switch(input) {
		case 1:
			viewAllUsers();
			break;
		case 2:
			viewAllAccounts();
			break;
		case 3:
			createNewUser();
			break;
		case 4:
			updateAUser();
			break;
		case 5:
			deleteAUser();
			break;
		case 6:
			welcomeScreen();
		}
		
	}
	public static void deleteAUser() throws SQLException {
		System.out.println("Welcome To The Delete A User Page!");
		Scanner scan = new Scanner(System.in);
		UserDaoImpl udi = new UserDaoImpl();
		AccountDaoImpl adi = new AccountDaoImpl();
		List<User> users = new ArrayList<User>();
		User b = null;
		users = udi.getUsers(); 
		
		System.out.println("Here's A List Of All The Users.");
		
		for(User u : users) {
			System.out.println(u);
		}
		
		System.out.println("Enter The UserID That You Would Like To Be Deleted: ");
		int input = scan.nextInt();
		
		
		for(User u : users) {
			//System.out.println(account);
			if(u.getUserId() == input) {
				b = u;
			}
		}
		
		if(b == null) {
			System.out.println("Error, Can't Find UserID, Please Try Again.");
			adminHomeScreen();
		}
		
		udi.deleteUserById(input);
		adi.deleteAccountById(input);
		
		System.out.println("User Deleted");
		
		adminHomeScreen();
		
	}
	public  static void updateAUser() throws SQLException {
		UserDaoImpl udi = new UserDaoImpl();
		List<User> users = new ArrayList<User>();
		users = udi.getUsers(); 
		int inputid;
		System.out.println("Here's A List Of All The Users.");
		
		for(User u : users) {
			System.out.println(u);
		}
		
		System.out.println("Welcome To The Update A User Page...");
		System.out.println("Please Select An Option Below...");
		System.out.println("1. Update Username.");
		System.out.println("2. Update Password.");
		System.out.println("3. Update FirstName.");
		System.out.println("4. Update LastName. ");
		System.out.println("5. Admin Home Screen");
		int input = scan.nextInt();

		switch(input) {
		case 1:
			System.out.println("Enter User ID To Update...");
			inputid = scan.nextInt();
			System.out.println("Enter New Username...");
			String usernameInput = scan.nextLine();
			udi.updateUserName(usernameInput, inputid);
			System.out.println("Information Updated...");
			adminHomeScreen();
			break;
		case 2:
			System.out.println("Enter User ID To Update...");
			inputid = scan.nextInt();
			System.out.println("Enter Password...");
			String passwordInput = scan.nextLine();
			udi.updatePassword(passwordInput, inputid);
			System.out.println("Information Updated...");
			adminHomeScreen();
			break;
		case 3:
			System.out.println("Enter User ID To Update...");
			inputid = scan.nextInt();
			System.out.println("Enter New FirstName...");
			String firstnameInput = scan.nextLine();
			udi.updateFirstName(firstnameInput, inputid);
			System.out.println("Information Updated...");
			adminHomeScreen();
			break;
		case 4:
			System.out.println("Enter User ID To Update...");
			inputid = scan.nextInt();
			System.out.println("Enter New LastName...");
			String lastNameInput = scan.nextLine();
			udi.updateLastName(lastNameInput, inputid);
			System.out.println("Information Updated...");
			adminHomeScreen();
			break;
		case 5:
			adminHomeScreen();
			break;
		}
	}
	public static void viewAllAccounts() throws SQLException {
		Scanner scan = new Scanner(System.in);
		AccountDaoImpl adi = new AccountDaoImpl();
		List<Account> account = new ArrayList<Account>();
		account = adi.getAccounts(); 
		
		System.out.println("Here's A List Of All The Accounts.");
		
		for(Account a : account) {
			System.out.println(a);
		}
		
		System.out.println("\nPress '1' To Go Back To The Admin Home Screen...");
		int input = scan.nextInt();
		
		if(input == 1) {
			adminHomeScreen();
		}
		
	}
	public static void viewAllUsers() throws SQLException {
		Scanner scan = new Scanner(System.in);
		UserDaoImpl udi = new UserDaoImpl();
		List<User> users = new ArrayList<User>();
		users = udi.getUsers(); 
		
		System.out.println("Here's A List Of All The Users.");
		
		for(User u : users) {
			System.out.println(u);
		}
		
		System.out.println("\nPress '1' To Go Back To The Admin Home Screen...");
		int input = scan.nextInt();
		
		if(input == 1) {
			adminHomeScreen();
		}
		
	}
	public static void customerLogin() throws SQLException {
		UserDaoImpl udi = new UserDaoImpl();
		AccountDaoImpl adi = new AccountDaoImpl();
		List<User> users = new ArrayList<User>();
		Account a = null;
		
		
		String usernameInput;
		String passwordInput;
		scan.nextLine();
		System.out.println("\nWelcome To The Customer Login Screen...");
		System.out.println("Please Enter Your Login Information Below.");
		System.out.println("Username: ");
		usernameInput = scan.nextLine();
		System.out.println("Password: ");
		passwordInput = scan.nextLine();
		
		//users.add(udi.getUsers(usernameInput));
		users = udi.getUsers();
		
		for(User u : users) {
			if((u.getUsername().equals(usernameInput)) && u.getPassword().equals(passwordInput)) {
				System.out.println("Login Succesful");
				a= adi.getAccount(u.getUserId());
				customerHomeScreen(u, a);
			}
		}
		
		
	}
	
	public static void customerHomeScreen(User userPassedIn, Account accountPassedIn) {
		User u = userPassedIn;
		Account a = accountPassedIn;
		int chsInput;
		System.out.println("Welcome To The Customer Home Screen!");
		System.out.println("Please Select An Option Below...");
		System.out.println("\n1. View Account Information.");
		System.out.println("2. View Account Balances.");
		System.out.println("3. Deposit Money.");
		System.out.println("4. Withdraw Money.");
		System.out.println("5. Delete Account.");
		System.out.println("6. Add A Bank Account");
		System.out.println("7. Logout.");
		chsInput = scan.nextInt();
		
		switch(chsInput) {
		case 1:
			viewAccountInformation(a, u);
			break;
		case 2:
			viewBalance(u, a);
			break;
		case 3:
			depositMoney(u, a);
			break;
		case 4:
			withdrawMoney(u, a);
			break;
		case 5:
			deleteAccount(u, a);
			break;
		case 6:
			addNewAccount(u, a);
			break;
		case 7:
			//welcomeScreen();
		default:
			//welcomeScreen();
		}
		
	}
	public static void deleteAccount(User u, Account a) {
		AccountDaoImpl adi = new AccountDaoImpl();
		
		Account b = null;
		List<Account> acc = new ArrayList<Account>();
		acc = adi.getAccounts(u.getUserId(), a);
		
		
		System.out.println("Welcome To The Delect Bank Account Page...");
		System.out.println("Note! Balance Must Be $0 For It To Be Deleted.");
		
		for(Account account : acc) {
			System.out.println(account);
		}
		System.out.println("Enter Your Account ID: ");
		int accId = scan.nextInt();
		scan.nextLine();
		
		for(Account account : acc) {
			//System.out.println(account);
			if(account.getAccountId() == accId) {
				b = account;
			}
		}
		
		if(b==null) {
			System.out.println("Error, Account Can't Be Found! Try Again");
		}
		else if(b.getBalance() > 0) {
			System.out.println("Error, Please Try Again. Balance Needs To Be 0");
			customerHomeScreen(u, a);
		}
		
		adi.deleteAccountById(accId);
		System.out.println("Account: " + accId + " Has Been Deleted");
		
		customerHomeScreen(u, a);
		
	}
	public static void addNewAccount(User u, Account a) {
		AccountDaoImpl adi = new AccountDaoImpl();
		adi.addNewAccount(a, u);
		
		System.out.println("A New Account Has Been Added!\n");
		customerHomeScreen(u, a);
		
	}
	public static void withdrawMoney(User uPassedIn, Account aPassedIn) {
		User u = uPassedIn;
		Account a = aPassedIn;
		Account b = null;
		AccountDaoImpl adi = new AccountDaoImpl();
		List<Account> acc = new ArrayList<Account>();
		acc = adi.getAccounts(u.getUserId(), a);
		
		for(Account account : acc) {
			System.out.println(account);
		}
		System.out.println("Enter The AccountID You Would Like To Withdraw From: ");
		int accid = scan.nextInt();

		for(Account account : acc) {
			//System.out.println(account);
			if(account.getAccountId() == accid) {
				b = account;
			}
		}
		
		if(b == null) {
			System.out.println("Error, Cant Find Bank Account...");
			System.out.println("Please Try Again.");
			withdrawMoney(u, a);
		}
		
		System.out.println("Enter How Much You Would Like To Withdraw: ");
		int withdrawAmount = scan.nextInt();
		
		
		
		
		if(b.getBalance() - withdrawAmount < 0) {
			System.out.println("Error, Insufficient Amount, Please Try Again...");
			withdrawMoney(u, a);
		}
		else {
			b.setBalance(b.getBalance() - withdrawAmount);
			adi.updateAccountBalance(b);
			System.out.println("You Withdrawed: $" + withdrawAmount + ". Your Current Balance Is Now: " + b.getBalance());
			log.info("UserID: " + b.getUserId() + " withdrawed $" + "withdrawAmount");
			customerHomeScreen(u, a);
		}
	}
		
		
	public static void depositMoney(User uPassedIn, Account aPassedIn) {
		User u = uPassedIn;
		Account a = aPassedIn;
		Account b = null;
		AccountDaoImpl adi = new AccountDaoImpl();
		List<Account> acc = new ArrayList<Account>();
		acc = adi.getAccounts(u.getUserId(), a);
		
		System.out.println("Welcome To The Deposit Page...");
		System.out.println("Your Account Balances Are Listed Below...");
		
		for(Account accounts : acc) {
			System.out.println(accounts);
		}
		
		System.out.println("Enter Your Account ID Of The Account You Would Like To Deposit To Below.");
		System.out.println("Enter Account Id: ");
		int accountId = scan.nextInt();
		
		for(Account account : acc) {
			//System.out.println(account);
			if(account.getAccountId() == accountId) {
				b = account;
			}
		}
		
		if(b == null) {
			System.out.println("Error, Cant Find Bank Account...");
			System.out.println("Please Try Again.");
			depositMoney(u, a);
		}
		
		
		System.out.println("\nHow Much Would You Like To Deposit: ");
		double depositAmount = scan.nextDouble();
		
		if(depositAmount <= 0) {
			System.out.println("Error, Invalid Deposit Amount, Try Again.");
			depositMoney(u, a);
		}
		else {
			b.setBalance(b.getBalance() + depositAmount);
			adi.updateAccountBalance(a);
			System.out.println("You Deposited $" + depositAmount + ". Your Current Balance Is Now: " + b.getBalance());
			log.info("UserID " + b.getUserId() + " deposited $" + depositAmount);
			customerHomeScreen(u, a);
		}
		
	}
	public static void viewBalance(User passedIn, Account a) {
		User u = passedIn;
		AccountDaoImpl adi = new AccountDaoImpl();
		List<Account> acc = new ArrayList<Account>();
		acc = adi.getAccounts(u.getUserId(), a);
		System.out.println("\nWelcome " + u.getFirstname() + " To The View Balance Page...");
		
		for(Account ac : acc) {
			System.out.println(ac);
		}
		
		System.out.println("Press '1' To Go Back To The Customer Home Screen...");
		int input = scan.nextInt();
		
		if(input == 1) {
			customerHomeScreen(u, a);
		}
		
	}
	public static void viewAccountInformation(Account a, User passedIn) {
		User u = passedIn;
		
		System.out.println("\nWelcome To The Account Information Page...");
		System.out.println("Below Is Some Information On Your Account.");
		System.out.println("UserId: " + u.getUserId());
		System.out.println("Username: " + u.getUsername());
		System.out.println("FirstName: " + u.getFirstname());
		System.out.println("Lastname: " + u.getLastname());
		
		System.out.println("\nPress '1' To Go Back To The Customer Home Page...");
		int input = scan.nextInt();
		
		if(input == 1) {
			customerHomeScreen(u, a);
		}
	}
	public static void createAccount() throws SQLException {
		
		//used for making an account after the user has registered. Makes the account
		//then sends to the database.
		AccountDaoImpl adi = new AccountDaoImpl();
		UserDaoImpl udi = new UserDaoImpl();
		
		String usernameInput;
		String passwordInput;
		String firstnameInput;
		String lastnameInput;
		double balance = 0;
		scan.nextLine();
		System.out.println("\nWelcome New Customer!");
		System.out.println("Please Provide Your Information To The Fields Below...");
		System.out.println("Enter A Username For Your Account: ");
		usernameInput = scan.nextLine();
		System.out.println("Enter A Password For Your Account: ");
		passwordInput = scan.nextLine();
		System.out.println("Enter Your First Name: ");
		firstnameInput = scan.nextLine();
		System.out.println("Enter Your Last Name: ");
		lastnameInput = scan.nextLine();
		
		//get the next account id available
		int accountid = adi.getNextId();
		
		//create the user with the information
		User user = new User(accountid, usernameInput, passwordInput, firstnameInput, lastnameInput);
		
		//process for storing the user into the database
		udi.createUser(user);
		
		
		//create the user account, then send to account accountDaoImpl to create account and send to database.
		Account a = new Account(accountid, accountid, balance);
		adi.createAccount(a, user);
		
		System.out.println("\n\nThank You For Registering...");
		System.out.println("You Will Be Sent To The Bank App Welcome Screen...");
		
		welcomeScreen();
	}
	
	public static void createNewUser() throws SQLException {
		
		//used for making an account after the user has registered. Makes the account
		//then sends to the database.
		AccountDaoImpl adi = new AccountDaoImpl();
		UserDaoImpl udi = new UserDaoImpl();
		
		String usernameInput;
		String passwordInput;
		String firstnameInput;
		String lastnameInput;
		double balance = 0;
		//scan.nextLine();
		System.out.println("\nWelcome New Customer!");
		System.out.println("Please Provide Your Information To The Fields Below...");
		System.out.println("Enter A Username For Your Account: ");
		usernameInput = scan.nextLine();
		System.out.println("Enter A Password For Your Account: ");
		passwordInput = scan.nextLine();
		System.out.println("Enter Your First Name: ");
		firstnameInput = scan.nextLine();
		System.out.println("Enter Your Last Name: ");
		lastnameInput = scan.nextLine();
		
		//get the next account id available
		int accountid = adi.getNextId();
		
		//create the user with the information
		User user = new User(accountid, usernameInput, passwordInput, firstnameInput, lastnameInput);
		
		//process for storing the user into the database
		udi.createUser(user);
		
		
		//create the user account, then send to account accountDaoImpl to create account and send to database.
		Account a = new Account(accountid, accountid, balance);
		adi.createAccount(a, user);
		
		System.out.println("New User Created!");
		adminHomeScreen();
	}
	
}
