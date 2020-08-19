package Questions;

public class questionTwelve {
	public void printEvenArray() {
		int[] numbers = new int[101];
		
		for(int i = 1; i <= 100; i++) {
			numbers[i] = i;
		}
		
		for(int values : numbers) {
				if(values%2 == 0) {
					System.out.println(values);
				}
				else
					continue;
			}
		}
	}

