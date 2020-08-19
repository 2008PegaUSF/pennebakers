package Main;

import java.util.*;

public class welcomePage {
	
	private int option;
	
	public void welcomePage() {
		Scanner input = new Scanner(System.in);

		System.out.println("Welcome To The Banking App\nPlease Select An Option Below.\n");
		
		System.out.println("1. Create New Account");
		System.out.println("2. User Login");
		System.out.println("3. Admin Login");
		System.out.print("Option: ");
		option = input.nextInt();
	}
	
	public int getOption() {
		return option;
	}

}
