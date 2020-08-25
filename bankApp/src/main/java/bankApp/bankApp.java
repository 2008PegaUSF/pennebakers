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
	
	ArrayList<Account> accounts = new ArrayList<Account>();
    String username;
	String password;
	String firstname;
	String lastname;
	int balance;
	
	
	//used to be able to get all the accounts from the deserialized file. Use this if you want to search for an account through the list. 
	private ArrayList<Account> accList;
	
	public void run() {
		homeScreen();
	}
	
	
	//Home Screen After Logging In
	public void homeScreen() {
		//readInfoFromFile();
		readAccountsFile();
		
		System.out.println("Welcome To The Bank App");
		System.out.println("Select an Option Below...");
		System.out.println("1.Create An Account");
		System.out.println("2.Create A Joint Account");
		System.out.println("3.Login");
		System.out.println("4.Exit");
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
			
			balance = 0;
			accounts.add(new Account(username, password, firstname, lastname, balance));
			
			saveInfoToFile(accounts);
			
			System.out.println("New Account Is Created...");
			System.out.println("Login To Access Your Account...");
			homeScreen();
			
		}
		//Option For Creating A Joint Account
		else if(optionSelected == 2) {
			//createJointAccount();
		}
		//Option For Loggin In
		else if(optionSelected == 3) {
			loginScreen();
		}
		//Logging Out
		else {
			System.exit(0);
		}
		
	}
	
	
	//Method To Serialize Information and Save To A File
	public void saveInfoToFile(ArrayList<Account> accounts) {
		try {
			//Dont add 'true' to FileOutPutStream bc it will overwrite the arraylists and cause issues. 
			FileOutputStream fileout = new FileOutputStream("usersInfo.txt");
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
	public void readAccountsFile(){
		try {
			ArrayList<Account> list;
			FileInputStream is = new FileInputStream(new File ("usersInfo.txt"));
			ObjectInputStream os = new ObjectInputStream(is);
			list = (ArrayList<Account>) os.readObject();
			
			
			//We are saving the list into the accList that is made globally at the top of the program
			accList = list;

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
		for(int i = 0; i < accList.size(); i++) {
			if(accList.get(i).getUsername().equals(username) && accList.get(i).getPassword().equals(password)) {
				a = accList.get(i);
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
			saveInfoToFile(accList);
			System.out.println("Current Balance Is Now: " + a.getBalance());
			accountHomeScreen(a);
		}
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
				saveInfoToFile(accList);
				System.out.println("Current Balance Is Now: " + a.getBalance());
				accountHomeScreen(a);
			}
		}
		else if(input.equals("4")) {
			Scanner usernameInput = new Scanner(System.in);
			Scanner transferInput = new Scanner(System.in);
			String findUsername;
			int transferAmount;
			System.out.println("Current Balance: $" + a.getBalance());
			System.out.println("Enter A Username You Would Like To Transfer To: ");
			findUsername = usernameInput.nextLine();
			
			Account b;
			
			for(int i = 0; i < accList.size(); i++) {
				if(accList.get(i).getUsername().equals(findUsername)) {
					b = accList.get(i);
					System.out.println("Your Current Balance Is: $" + a.getBalance());
					System.out.println("How Much Would You Like To Transfer: $");
					transferAmount = transferInput.nextInt();
					
					a.setBalance(a.getBalance() - transferAmount);
					b.setBalance(b.getBalance() + transferAmount);
					saveInfoToFile(accList);
					System.out.println("Transfer Successful...");
					System.out.println("Current Balance Is Now: "  + a.getBalance());
					accountHomeScreen(a);
				}
			}
		}
		
	}
}
