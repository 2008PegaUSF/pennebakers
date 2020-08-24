package Questions;

import java.util.ArrayList;
import java.util.*; 
import java.lang.*; 

public class questionEight {
	
	public ArrayList<String> palindrome() {
		
		ArrayList<String> originalList = new ArrayList<String>();
		ArrayList<String> palindromeList = new ArrayList<String>();
		
		originalList.add("karan");
		originalList.add("madam");
		originalList.add("tom");
		originalList.add("civic");
		originalList.add("radar");
		originalList.add("jimmy");
		originalList.add("kayak");
		originalList.add("john");
		originalList.add("refer");
		originalList.add("billy");
		originalList.add("did");
		
		
		
		for(String a : originalList) {
			String reverse = new StringBuffer(a).reverse().toString();
			
			if(a.contentEquals(reverse)) {
				palindromeList.add(reverse);
			}
		}
		
		for(String b : palindromeList) {
			System.out.print(b + " ");
		}	
		
		return palindromeList;
	}
}
