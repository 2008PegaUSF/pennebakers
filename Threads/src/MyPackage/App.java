package MyPackage;

public class App {

	public static void main(String[] args) {
		CustomThread ct = new CustomThread();
		CustomThread ct2 = new CustomThread();
		CustomThread ct3 = new CustomThread();
		ct.start();
		ct2.start();
		ct3.start();
	}

}
