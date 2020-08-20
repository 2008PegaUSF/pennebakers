package Challenge;

import java.util.Random;
import java.util.ArrayDeque;

public class CustomThread extends Thread {
	static ArrayDeque<Integer> a;
	
	public CustomThread() {
		//Random b = new Random();
		if(a ==  null) {
			a = new ArrayDeque<Integer>();
		}
	}
	
	
	public void addNumberSyncBlock() {
		//synchronized(a) {
		Random r = new Random();
		int i = r.nextInt(10000);
		System.out.println("Thread: " + this.toString() + "Next int: " + i);
		
		a.addFirst(i);
		//}
	}
	
	public void modulusSyncBlock() {
		Random b = new Random();
		//synchronized(a) {
			if(isPrime(a.getLast()) == true) {
				System.out.println("Next int: " + a.getLast() + " is Prime");
				a.removeLast();
				System.out.println(a.size());
				a.addFirst(b.nextInt(10000));
			}
			else {
				System.out.println("Next int: " + a.getLast() + " is NOT prime");
				a.removeLast();
				System.out.println(a.size());
				a.addFirst(b.nextInt(10000));	
			}
			
			for(Integer t : a) {
				System.out.println(t);
			}
			//a.remove();
			//a.addFirst(b.nextInt(10000));
	//	}
	}
	
	public void run() {
		for(int i = 1; i <= 5; i++) {
			addNumberSyncBlock();
		}
		modulusSyncBlock();
		
	}
	
	public boolean isPrime(int n) {
        if (n <= 1) 
            return false; 
        for (int i = 2; i < n; i++) 
            if (n % i == 0) 
                return false; 
        return true; 
	}
	
	
	public ArrayDeque<Integer> getDeq() {
		return a;
	}
}
