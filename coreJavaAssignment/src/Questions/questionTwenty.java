package Questions;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class questionTwenty {
	
	public void readFile() {
		try {
			
			FileReader fileReader = new FileReader("C:\\Users\\vfxfu\\Desktop\\Revature\\Code\\coreJavaAssignment\\src\\Data.txt");
			
			Scanner readFile = new Scanner(fileReader);
			
			while(readFile.hasNextLine()) {
				String output = readFile.nextLine();
				String[] arr = output.split(":");
				Arrays.deepToString(output.split(":"));
				System.out.println("Name: " + arr[0] + " " + arr[1]);
				System.out.println("Age: " + arr[2] + " years");
				System.out.println("State: " + arr[3] + " State\n");
			}
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
