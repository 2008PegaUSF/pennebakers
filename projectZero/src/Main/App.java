package Main;

public class App {

	public static void main(String[] args) {
		login user = new login();
		adminPage adminPage = new adminPage();
		
		user.login();
		
		if(user.getUserName().equals("admin") && user.getPassword().contentEquals("admin")) {
			System.out.println("Welcome to the admin page");
			adminPage.adminHome();
		}
		else {
			System.out.println("Welcome to the basic user page");
		}
		
		

	}

}
