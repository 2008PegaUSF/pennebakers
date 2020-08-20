package Challenge;

public class App {

	public static void main(String[] args) {
		CustomThread ct1 = new CustomThread();
		CustomThread ct2 = new CustomThread();
		
		ct1.run();
		ct2.run();
	}

}
