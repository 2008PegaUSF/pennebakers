package Questions;

public class questionThirteen {
	public String printTriangle() {
        int inputvalue = 0;
        String output = "";
        for(int i = 1;i<=4;i++){
            for(int j = 0;j<i;j++){
            	output = output.concat(Integer.toString(inputvalue));
                System.out.print(inputvalue+ " ");
                inputvalue = flip(inputvalue);
            }
            System.out.println();
        }
        System.out.println("The values below are for testing purposes...");
        return output;
	}

	public int flip(int value) {
	     if(value == 0){
	            return 1;
	        }
	        else{
	            return 0;
	        }
	}
}
