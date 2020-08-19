package Questions;

public class questionTwo {
	
	static int fib(int n) {
		int f1 = 0, f2 = 1, i;
		if(n < 1)
			return n;

		for(i = 1; i <= n; i++) {
			if(n < 1) {
				return n;
			}
			else {
				return fib(n-1) + fib(n-2);
			}
		}
		
	}
}
