package MyPackage;

import java.util.ArrayList;
import java.util.Random;

public class CustomThread extends Thread{
	
	static ArrayList<Integer> myNumbers;
	
	public CustomThread() {
		if(myNumbers == null)
			myNumbers = new ArrayList<Integer>();
	}
	
	/*public static synchronized void addNumber() {
		Random r = new Random();
		int i = r.nextInt();
		System.out.println("Next int: " + i);
		//myNumbers.add(r.nextInt);
	}*/
	
	public void addNumberSyncBlock() {
		synchronized(myNumbers) {
		Random r = new Random();
		int i = r.nextInt();
		System.out.println("Thread: " + this.toString() + "Next int: " + i);
		//myNumbers.add(r.nextInt);
		
		myNumbers.add(i);
		}
	}
	
	public void run() {
		for(int i = 0; i < 10; i++) {
			addNumberSyncBlock();
		}
	}
}
