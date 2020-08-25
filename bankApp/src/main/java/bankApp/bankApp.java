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
	
	private ArrayList<Account> accList;
	
	public void run() {
		homeScreen();
	}
	
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
		else if(optionSelected == 2) {
			//createJointAccount();
		}
		else if(optionSelected == 3) {
			loginScreen();
		}
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
	

	
	public void readAccountsFile(){
		try {
			ArrayList<Account> list;
			FileInputStream is = new FileInputStream(new File ("usersInfo.txt"));
			ObjectInputStream os = new ObjectInputStream(is);
			list = (ArrayList<Account>) os.readObject();
			
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
	
	public void loginScreen() {
		Scanner usernameLogin = new Scanner(System.in);
		Scanner passwordLogin = new Scanner(System.in);
		
		String username;
		String password;
		
		System.out.println("Enter Username: ");
		username = usernameLogin.nextLine();
		
		System.out.println("Enter Password: ");
		password = passwordLogin.nextLine();
		
		
		
		//Make method to iterate through list and find an == to the username and password.
		//for(int i = 0; i < accList.size(); i++)
		//if(accList.get(i).getusername() == username && accList.get(i).getpassword() == password)
		if(accList.contains(username)) {
			//accountHomeScreen();
			System.out.println("Succesful login");
		}
		else {
			System.out.println("error");
		}
		
	}

	/*public void accountHomeScreen() {
		Scanner homeScreenInput = new Scanner(System.in);
		
		System.out.println();
		
	}*/

}
