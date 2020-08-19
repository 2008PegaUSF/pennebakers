package Main;

public class App {

	public static void main(String[] args) {
		welcomePage welcomePage = new welcomePage();
		newAccount newAccount = new newAccount();
		login user = new login();
		adminLogin admin = new adminLogin();
		
		welcomePage.welcomePage();
		if(welcomePage.getOption() == 1){
			newAccount.newAccount();
		}
		else if(welcomePage.getOption() == 2) {
			user.login();
		}
		else {
			admin.adminLogin();
		}
	}

}
