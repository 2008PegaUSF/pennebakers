package bankApp;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class bankApp{
	
	Scanner optionInput = new Scanner(System.in);
	int optionSelected; 
	
	//used to store the accounts after they are verified...
	ArrayList<Account> accounts = new ArrayList<Account>();
	
	//used to store the accounts for when they need to be verified...
	ArrayList<Account> needVerified = new ArrayList<Account>();
	
    String username;
	String password;
	String firstname;
	String lastname;
	String secondFirstName;
	String secondLastName;
	int balance;
	boolean verified;
	
	
	//used to be able to get all the accounts from the deserialized file. Use this if you want to search for an account through the list. 
	private ArrayList<Account> nonVerifiedAccList;
	
	private ArrayList<Account> verifiedAccList;
	
	public void run() {
		homeScreen();
	}
	
	
	//Home Screen After Logging In
	public void homeScreen() {
		//readInfoFromFile();
		readVerifiedFile();
		readNonVerifiedFile();
		
		System.out.println("Welcome To The Bank App");
		System.out.println("Select an Option Below...");
		System.out.println("1.Create An Account");
		System.out.println("2.Create A Joint Account");
		System.out.println("3.User Login");
		System.out.println("4.Employee Login");
		System.out.println("5.Admin Login");
		System.out.println("6.Exit");
		optionSelected = optionInput.nextInt();
		optionInput.nextLine();
		
		//Option 1 for creating an account
		if(optionSelected == 1) {
			System.out.println("First Name: ");
			firstname = optionInput.nextLine();
			System.out.println("Last Name: ");
			lastname = optionInput.nextLine();
			System.out.println("Username: ");
			username = optionInput.nextLine();
			System.out.println("password: ");
			password = optionInput.nextLine();
			
			secondFirstName = "/";
			secondLastName = "/";
			verified = false;
			
			balance = 0;
			needVerified.add(new Account(username, password, firstname, lastname, secondFirstName, secondLastName, balance, verified));
			
			saveNonVerifiedFile(needVerified);
			
			System.out.println("New Account Is Created...");
			System.out.println("Login To Access Your Account...");
			homeScreen();
			
		}
		//Option For Creating A Joint Account
		else if(optionSelected == 2) {
			createJointAccount();
		}
		//Option For Logging In
		else if(optionSelected == 3) {
			loginScreen();
		}
		else if(optionSelected == 4) {
			employeeLogin();
		}
		else if(optionSelected == 5) {
			adminLogin();
		}
		//Logging Out
		else if(optionSelected == 6){
			System.exit(0);
		}
		
	}
	
	
	public void adminLogin() {
		Scanner adminUsername = new Scanner(System.in);
		Scanner adminPassword = new Scanner(System.in);
		String aUsername;
		String aPassword;
		// TODO Auto-generated method stub
		System.out.println("Username: ");
		aUsername = adminUsername.nextLine();
		System.out.println("Password: ");
		aPassword = adminPassword.nextLine();
		
		if(aUsername.equals("admin") && aPassword.equals("admin")) {
			adminHomeScreen();
		}
		else {
			System.out.println("Error, Try Again...");
			adminLogin();
		}
		
	}


	private void adminHomeScreen() {
		Scanner ahsInput = new Scanner(System.in);
		System.out.println("Welcome To The Employee Home Screen...");
		System.out.println("Select An Option Below...");
		System.out.println("1. View All Verified Accounts");
		System.out.println("2. View All Non-Verified Accounts");
		System.out.println("3. Withdraw");
		System.out.println("4. Deposit");
		System.out.println("5. Transfer");
		System.out.println("6. Cancel An Account");
		System.out.println("7. Logout");
		String input = ahsInput.nextLine();
		
		if(input.equals("1")) {
			System.out.println("All Verified Accounts And Account Information...");
			readVerifiedFile();
			for(Account a : verifiedAccList) {
				System.out.println(a);
			}
			System.out.println("Select 1 To Go Back To The Admin Home Screen...");
			input = ahsInput.nextLine();
			if(input.equals("1")) {
				adminHomeScreen();
			}
		}
		else if(input.equals("2")) {
			String newInput;
			String verifyUsername;
			Account a = null;
			Account b = null;
			System.out.println("All Non-Verified Accounts And Account Information...");
			for(Account d : nonVerifiedAccList) {
				System.out.println(d);
			}
			System.out.println("Select An Option Below...");
			System.out.println("1. Select An Account To Verify");
			System.out.println("2. Back To Admin Home Screen");
			newInput = ahsInput.nextLine();
			
			if(newInput.equals("1")){
				System.out.println("Enter The Username Of The Account You Would Like To Verify: ");
				verifyUsername = ahsInput.nextLine();
				
				for(Account c : nonVerifiedAccList) {
					if(c.getUsername().equals(verifyUsername)) {
						b = c;
						a = c;
						break;
					}
				}
				
				if(b == null) {
					System.out.println("Account Not Found! Please Try Again...");
					employeeHomeScreen();
				}
				
				b.setVerified(true);
				nonVerifiedAccList.remove(a);
				saveNonVerifiedFile(nonVerifiedAccList);
				verifiedAccList.add(b);
				saveVerifiedFile(verifiedAccList);
				employeeHomeScreen();
			}
			else if(newInput.equals("2")) {
				adminHomeScreen();
			}
		}
		else if(input.equals("3")) {
			input = "";
			int withdrawAmount;
			Account b = null;
			System.out.println("Select An Option Below...");
			System.out.println("1. Enter The Account You Would Like To Withdraw From.");
			System.out.println("2. Back To The Admin Home Screen.");
			input = ahsInput.nextLine();
			if(input.equals("1")) {
				input = "";
				System.out.println("Enter The Username Of The Account.");
				for(Account c : nonVerifiedAccList) {
					if(c.getUsername().equals(input)) {
						b = c;
						break;
					}
				}
				
				if(b == null) {
					System.out.println("Account Not Found! Please Try Again...");
					employeeHomeScreen();
				}
				System.out.println("Account Found!");
				
				System.out.println("How Much Would You Like To Withdraw: $");
				withdrawAmount = ahsInput.nextInt();
				
				//Check if the balance is big enough to be able to withdraw, if its not sufficient enough, it sends you back to the home screen
				if(b.getBalance() < withdrawAmount) {
					System.out.println("Error, Insufficient Balance...");
					System.out.println("Please Try Again...");
					adminHomeScreen();
				}
				else {
					b.setBalance(b.getBalance() - withdrawAmount);
					saveVerifiedFile(verifiedAccList);
					System.out.println("Current Balance Is Now: " + b.getBalance());
					adminHomeScreen();
				}
			}
			else if(input.equals("2")) {
				adminHomeScreen();
			}
		}
		else if(input.equals("4")) {
			input = "";
			int depositAmount;
			Account b = null;
			System.out.println("Select An Option Below...");
			System.out.println("1. Enter The Account You Would Like To Deposit From.");
			System.out.println("2. Back To The Admin Home Screen.");
			input = ahsInput.nextLine();
			if(input.equals("1")) {
				input = "";
				System.out.println("Enter The Username Of The Account.");
				for(Account c : verifiedAccList) {
					if(c.getUsername().equals(input)) {
						b = c;
						break;
					}
				}
				
				if(b == null) {
					System.out.println("Account Not Found! Please Try Again...");
					adminHomeScreen();
				}
				System.out.println("Account Found!");
				
				System.out.println("How Much Would You Like To Deposit: $");
				depositAmount = ahsInput.nextInt();
				
				//Check if the balance is big enough to be able to withdraw, if its not sufficient enough, it sends you back to the home screen
					b.setBalance(b.getBalance() + depositAmount);
					saveVerifiedFile(verifiedAccList);
					System.out.println("Current Balance Is Now: " + b.getBalance());
					adminHomeScreen();
				}
			}
			else if(input.equals("2")) {
				adminHomeScreen();
			}
		else if(input.equals("5")) {
			input = "";
			int transferAmount;
			Account firstAccount = null;
			Account secondAccount = null;
			System.out.println("Select An Option Below...");
			System.out.println("1. Enter The Accounts You Would Like To Transfer From and To.");
			System.out.println("2. Back To The Admin Home Screen.");
			input = ahsInput.nextLine();
			if(input.equals("1")) {
				input = "";
				System.out.println("Enter The Username Of The Account You Would Like To Transfer From.");
				input = ahsInput.nextLine();
				for(Account c : verifiedAccList) {
					if(c.getUsername().equals(input)) {
						firstAccount = c;
						break;
					}
				}
				
				if(firstAccount == null) {
					System.out.println("Account Not Found! Please Try Again...");
					adminHomeScreen();
				}
				System.out.println("Account Found!");
				System.out.println("How Much Would You Like To Transfer: $");
				transferAmount = ahsInput.nextInt();
				
				if(firstAccount.getBalance() < transferAmount) {
					System.out.println("Error, Insufficient Balance, Please Try Again...");
					adminHomeScreen();
				}
				else {
					input = "";
					System.out.println("Enter The Username Of The Account You Would Like To Transfer To.");
					input = ahsInput.nextLine();
					
					for(Account e : verifiedAccList) {
						if(e.getUsername().equals(input)) {
							secondAccount = e;
							break;
						}
					}
					
					if(secondAccount == null) {
						System.out.println("Account Not Found! Please Try Again...");
						adminHomeScreen();
					}
						
				}
				
				//Check if the balance is big enough to be able to withdraw, if its not sufficient enough, it sends you back to the home screen
					firstAccount.setBalance(firstAccount.getBalance() - transferAmount);
					secondAccount.setBalance(secondAccount.getBalance() + transferAmount);
					saveVerifiedFile(verifiedAccList);
					adminHomeScreen();
				}
		}
		else if(input.equals("6")) {
			input = "";
			Account b = null;
			for(Account d : verifiedAccList) {
				System.out.println(d);
			}
			System.out.println("Select An Option Below...");
			System.out.println("1. Select The Account You Would Like To Cancel.");
			System.out.println("2. Back To The Admin Home Screen.");
			input = ahsInput.nextLine();
			
			if(input.equals("1")) {
				input = "";
				System.out.println("Enter The Username Of The Account That You Would Like To Cancel...");
				input = ahsInput.nextLine();
				
				for(Account c : verifiedAccList) {
					if(c.getUsername().equals(input)) {
						b = c;	
						break;
					}
				}
				
				if(b == null) {
					System.out.println("Account Not Found! Please Try Again...");
					employeeHomeScreen();
				}
				
				verifiedAccList.remove(b);
				saveVerifiedFile(verifiedAccList);
				adminHomeScreen();
			}
			else if(input.equals("2")) {
				adminHomeScreen();
			}
			
		}
		else if(input.equals("7")) {
			homeScreen();
		}
			
	}
		
		
		
		
		



	public void employeeLogin() {
		Scanner employeeUsername = new Scanner(System.in);
		Scanner employeePassword = new Scanner(System.in);
		String eUsername;
		String ePassword;
		// TODO Auto-generated method stub
		System.out.println("Username: ");
		eUsername = employeeUsername.nextLine();
		System.out.println("Password: ");
		ePassword = employeePassword.nextLine();
		
		if(eUsername.equals("employee") && ePassword.equals("employee")) {
			employeeHomeScreen();
		}
		else {
			System.out.println("Error, Try Again...");
			employeeLogin();
		}
	}


	public void employeeHomeScreen() {
		Scanner ehsInput = new Scanner(System.in);
		String input;
		System.out.println("Welcome To The Employee Home Screen...");
		System.out.println("Select An Option Below...");
		System.out.println("1. View All Verified Accounts");
		System.out.println("2. View All Non-Verified Accounts");
		System.out.println("3. Logout");
		input = ehsInput.nextLine();
		
		if(input.equals("1")) {
			System.out.println("All Verified Accounts And Account Information...");
			readVerifiedFile();
			for(Account a : verifiedAccList) {
				System.out.println(a);
			}
			System.out.println("Select 1 To Go Back To The Employee Home Screen...");
			input = ehsInput.nextLine();
			if(input.equals("1")) {
				employeeHomeScreen();
			}
		}
		else if(input.equals("2")) {
			String newInput;
			String verifyUsername;
			Account a = null;
			Account b = null;
			System.out.println("All Non-Verified Accounts And Account Information...");
			for(Account d : nonVerifiedAccList) {
				System.out.println(d);
			}
			System.out.println("Select An Option Below...");
			System.out.println("1. Select An Account To Verify");
			System.out.println("2. Back To The Employee Home Screen");
			newInput = ehsInput.nextLine();
			
			if(newInput.equals("1")) {
				System.out.println("Enter The Username Of The Account You Would Like To Verify: ");
				verifyUsername = ehsInput.nextLine();
				
				for(Account c : nonVerifiedAccList) {
					if(c.getUsername().equals(verifyUsername)) {
						b = c;
						a = c;
						break;
					}
				}
				
				if(b == null) {
					System.out.println("Account Not Found! Please Try Again...");
					employeeHomeScreen();
				}
				
				b.setVerified(true);
				nonVerifiedAccList.remove(a);
				saveNonVerifiedFile(nonVerifiedAccList);
				accounts.add(b);
				saveVerifiedFile(accounts);
				employeeHomeScreen();
				
				
			}
			else if(newInput.equals("2")) {
				employeeHomeScreen();
			}
			
			
		}
		else if(input.equals("3")) {
			homeScreen();
		}
	}


	public void createJointAccount() {
		System.out.println("Person 1. First Name: ");
		firstname = optionInput.nextLine();
		System.out.println("Person 1. Last Name: ");
		lastname = optionInput.nextLine();
		System.out.println("Person 2. First Name: ");
		secondFirstName = optionInput.nextLine();
		System.out.println("Person 2. Last Name: ");
		secondLastName = optionInput.nextLine();
		System.out.println("Username: ");
		username = optionInput.nextLine();
		System.out.println("password: ");
		password = optionInput.nextLine();
		
		verified = false;
		balance = 0;
		needVerified.add(new Account(username, password, firstname, lastname, secondFirstName, secondLastName, balance, verified));
		
		saveNonVerifiedFile(needVerified);
		
		System.out.println("New Account Is Created...");
		System.out.println("Login To Access Your Account...");
		homeScreen();
		
	}


	//Method To Serialize Information and Save To A File
	public void saveNonVerifiedFile(ArrayList<Account> accounts) {
		try {
			//Dont add 'true' to FileOutPutStream bc it will overwrite the arraylists and cause issues. 
			FileOutputStream fileout = new FileOutputStream("needVerified.txt");
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
	
	public void saveVerifiedFile(ArrayList<Account> accounts) {
		try {
			//Dont add 'true' to FileOutPutStream bc it will overwrite the arraylists and cause issues. 
			FileOutputStream fileout = new FileOutputStream("Verified.txt");
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

	//This Is How we are reading from the serialized file and desearializing the file so we may access the saved accounts. 
	public void readNonVerifiedFile(){
		try {
			ArrayList<Account> list;
			FileInputStream is = new FileInputStream(new File ("needVerified.txt"));
			ObjectInputStream os = new ObjectInputStream(is);
			list = (ArrayList<Account>) os.readObject();
			
			
			//We are saving the list into the accList that is made globally at the top of the program
			nonVerifiedAccList = list;

			os.close();
			is.close();
		}
		catch (IOException i) {
		   i.printStackTrace();
		} catch (ClassNotFoundException c) {
		       System.out.println("Account not found");
		       c.printStackTrace();
		}
		
	}
	
	public void readVerifiedFile(){
		try {
			ArrayList<Account> list;
			FileInputStream is = new FileInputStream(new File ("Verified.txt"));
			ObjectInputStream os = new ObjectInputStream(is);
			list = (ArrayList<Account>) os.readObject();
			
			
			//We are saving the list into the accList that is made globally at the top of the program
			verifiedAccList = list;

			os.close();
			is.close();
		}
		catch (IOException i) {
		   i.printStackTrace();
		} catch (ClassNotFoundException c) {
		       System.out.println("Account not found");
		       c.printStackTrace();
		}
		
	}
	
	
	//Login screen Method
	public void loginScreen() {
		Scanner usernameLogin = new Scanner(System.in);
		Scanner passwordLogin = new Scanner(System.in);
		
		String username;
		String password;
		
		System.out.println("Enter Username: ");
		username = usernameLogin.nextLine();
		
		System.out.println("Enter Password: ");
		password = passwordLogin.nextLine();
		
		
		
		//Referenced account.
		Account a;
		for(int i = 0; i < verifiedAccList.size(); i++) {
			if(verifiedAccList.get(i).getUsername().equals(username) && verifiedAccList.get(i).getPassword().equals(password)) {
				a = verifiedAccList.get(i);
				System.out.println("Successful login");
				
				accountHomeScreen(a);
			}
		}
		
		
	}
	
	
	
	public void accountHomeScreen(Account a) {
		Scanner homeScreenInput = new Scanner(System.in);
		String input;
		System.out.println("Welecome To Your Account Home Screen...");
		System.out.println("Please Select An Option Below...");
		System.out.println("1. View Account Information.");
		System.out.println("2. Deposit.");
		System.out.println("3. Withdraw. ");
		System.out.println("4. Transfer. ");
		System.out.println("5. Logout. ");
		input = homeScreenInput.nextLine();
		
		
		
		if(input.equals("1")){
			System.out.println(a.toString());
			
			System.out.println("Type 1 To Go Back To Your Account Home Screen");
			input = homeScreenInput.nextLine();
			if(input.equals("1")) {
				accountHomeScreen(a);
			}
		}
		else if(input.equals("2"))
		{
			Scanner depInput = new Scanner(System.in);
			int depositAmount;
			System.out.println("Current Balance: " + a.getBalance());
			System.out.println("Enter Amount To Deposit: $");
			depositAmount = depInput.nextInt();
			
			a.setBalance(a.getBalance() + depositAmount);
			saveVerifiedFile(verifiedAccList);
			System.out.println("Current Balance Is Now: " + a.getBalance());
			accountHomeScreen(a);
		}
		//Withdrawing Money
		else if(input.equals("3")) {
			Scanner withdrawInput = new Scanner(System.in);
			int withdrawAmount;
			
			System.out.println("Current Balance: " + a.getBalance());
			System.out.println("Enter Amount To Withdraw: $");
			withdrawAmount = withdrawInput.nextInt();
			
			//Check if the balance is big enough to be able to withdraw, if its not sufficient enough, it sends you back to the home screen
			if(a.getBalance() < withdrawAmount) {
				System.out.println("Error, Insufficient Balance...");
				System.out.println("Please Try Again...");
				accountHomeScreen(a);
			}
			else {
				a.setBalance(a.getBalance() - withdrawAmount);
				saveVerifiedFile(verifiedAccList);
				System.out.println("Current Balance Is Now: " + a.getBalance());
				accountHomeScreen(a);
			}
		}
		//Transferring Money
		else if(input.equals("4")) {
			Scanner usernameInput = new Scanner(System.in);
			Scanner transferInput = new Scanner(System.in);
			String findUsername;
			int transferAmount;
			System.out.println("Current Balance: $" + a.getBalance());
			System.out.println("Enter A Username You Would Like To Transfer To: ");
			findUsername = usernameInput.nextLine();
			
			Account b;
			
			for(int i = 0; i < verifiedAccList.size(); i++) {
				if(verifiedAccList.get(i).getUsername().equals(findUsername)) {
					b = verifiedAccList.get(i);
					System.out.println("Your Current Balance Is: $" + a.getBalance());
					System.out.println("How Much Would You Like To Transfer: $");
					transferAmount = transferInput.nextInt();
					
					a.setBalance(a.getBalance() - transferAmount);
					b.setBalance(b.getBalance() + transferAmount);
					saveVerifiedFile(verifiedAccList);
					System.out.println("Transfer Successful...");
					System.out.println("Current Balance Is Now: "  + a.getBalance());
					accountHomeScreen(a);
				}
			}
		}
		
	}
}
