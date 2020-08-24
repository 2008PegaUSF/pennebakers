package Questions;

import java.io.File;
import java.util.ArrayList;

import floatValueOne.floatValueOne;
import floatValueTwo.floatValueTwo;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import Questions.questionOne;
import Questions.questionTwo;
import Questions.questionThree;
import Questions.questionFour;
import Questions.questionFive;

public class myTests {
	static questionOne p = new questionOne();
	static questionTwo q = new questionTwo();
	static questionThree b = new questionThree();
	static questionFour a = new questionFour();
	static questionFive c = new questionFive();
	static questionSix d = new questionSix();
	static questionEight f = new questionEight();
	static questionNine g = new questionNine();
	static questionTen h = new questionTen();
	static floatValueOne i = new floatValueOne();
	static floatValueTwo i2 = new floatValueTwo();
	static questionTwelve j = new questionTwelve();
	static questionFifteenPTwo m = new questionFifteenPTwo();
	static questionSixteen n = new questionSixteen();
	static questionSeventeen o = new questionSeventeen();
	static questionTwenty r = new questionTwenty();
	static driverClass et = new driverClass();
	static questionFourteen ft = new questionFourteen();
	static questionThirteen tt = new questionThirteen();
	static questionNineteen nt = new questionNineteen();

	
	
	@Test
	public void testQuestionOne() {
		int[] expected = {0, 1, 2, 3, 3, 4, 5, 6, 7, 8, 9};
		int[] bubbleArray = {1,0,5,6,3,2,3,7,9,8,4};
		Assertions.assertArrayEquals(expected, p.bubbleSort(bubbleArray));
		
	}
	
	
	@Test
	public void testQuestionTwo() {
		int valueOne = 0, valueTwo = 1, value, count = 23;
		int[] expectedArr = new int[24];
		expectedArr[0] = valueOne;
		expectedArr[1] = valueTwo;
		
		//System.out.print(valueOne + " " + valueTwo);
		
		for(int i = 2; i <= count; i ++) {
			value = valueOne + valueTwo;
			expectedArr[i] = value;
			valueOne = valueTwo;
			valueTwo = value;
		}
		
		Assertions.assertArrayEquals(expectedArr, q.questionTwo());
	}
	
	//Question 3 Test
	@Test
	public void testQuestionThree() {
		Assertions.assertEquals("olleH", b.reverseString("Hello"));
		Assertions.assertNotEquals("oll", b.reverseString("Hello"));
	}
	
	
	//Question 4 Test
	@Test
	public void testQuestionFour() {
		Assertions.assertEquals(120, a.fac(5));
		Assertions.assertNotEquals(121, a.fac(5));
	}
	
	@Test
	public void testQuestionFive() {
		Assertions.assertEquals("Hel", c.substring("Hello", 3));
		Assertions.assertNotEquals("Hell", c.substring("Hello", 3));
	}
	
	public void testQuestionSix() {
		Assertions.assertEquals(false, d.isEven(5));
		Assertions.assertEquals(true, d.isEven(4));
		
	}
	
	@Test
	public void testQuestionSeven() {
		questionSeven qs = new questionSeven("Seth", "Math", 25);
		
		Assertions.assertEquals(true, qs.department.contentEquals("Math"));
	}
	
	@Test
	public void testQuestionEight() {
		ArrayList<String> checkedList = new ArrayList<String>();
		ArrayList<String> nonCheckedList = new ArrayList<String>();
		
		nonCheckedList.add("karan");
		nonCheckedList.add("madam");
		nonCheckedList.add("tom");
		nonCheckedList.add("civic");
		nonCheckedList.add("radar");
		nonCheckedList.add("jimmy");
		nonCheckedList.add("kayak");
		nonCheckedList.add("john");
		nonCheckedList.add("refer");
		nonCheckedList.add("billy");
		nonCheckedList.add("did");
		
		checkedList.add("madam");
		checkedList.add("civic");
		checkedList.add("radar");
		checkedList.add("kayak");
		checkedList.add("refer");
		checkedList.add("did");
		
		Assertions.assertEquals(f.palindrome(), checkedList);
		Assertions.assertNotEquals(nonCheckedList, f.palindrome());
	}
	
	@Test
	public void testQuestionNine() {
		ArrayList<Integer> checkedList = new ArrayList<Integer>();
		
		checkedList.add(2);
		checkedList.add(3);
		checkedList.add(5);
		checkedList.add(7);
		checkedList.add(11);
		checkedList.add(13);
		checkedList.add(17);
		checkedList.add(19);
		checkedList.add(23);
		checkedList.add(29);
		checkedList.add(31);
		checkedList.add(37);
		checkedList.add(41);
		checkedList.add(43);
		checkedList.add(47);
		checkedList.add(53);
		checkedList.add(59);
		checkedList.add(61);
		checkedList.add(67);
		checkedList.add(71);
		checkedList.add(73);
		checkedList.add(79);
		checkedList.add(83);
		checkedList.add(89);
		checkedList.add(97);
		
		Assertions.assertEquals(checkedList, g.printPrimeNumbers());
	}
	
	@Test
	public void testQuestionTen() {
		int expectedOutput = 54;
		Assertions.assertEquals(expectedOutput, h.questionTen(55, 65, 54));
	}
	
	@Test
	public void testQuestionEleven() {
		float valueOne = 12.12345f;
		float valueTwo = 1.12345f;
		
		Assertions.assertEquals(valueOne, i.getValueOne());
		Assertions.assertEquals(valueTwo, i2.getValueTwo());
	}
	
	//@Test
	public void testQuestionTwelve() {
		String expected = "2468101214161820222426283032343638404244464850525456586062646668707274767880828486889092949698100";
		
		Assertions.assertEquals(expected, j.printEvenArray());
	}
	
	@Test
	public void testQuestionThirteen(){
		String expected = "0101010101";
		Assertions.assertEquals(expected, tt.printTriangle());
	}
	
	@Test 
	public void testQuestionFourteen() {
		//switch case 1
		Assertions.assertNotEquals("2020-08-23", ft.switchCasePrint());	
	}
	
	@Test
	public void testQuestionFifteen() {
		Assertions.assertEquals(2, m.addition(1, 1));
		Assertions.assertEquals(4, m.subtraction(5, 1));
		Assertions.assertEquals(2, m.division(4, 2));
		Assertions.assertEquals(10, m.multiplication(5, 2));
		
	}
	
	@Test
	public void testQuestionSixteen() {
		String[] arguments = {"Seth"};
		Assertions.assertEquals(4, n.numberOfChar(arguments));
	}
	
	@Test
	public void testQuestionSeventeen() {
		Assertions.assertNotEquals(1, o.calculateInterest());
		Assertions.assertEquals(125, o.calculateInterest());
	
	}
	
	@Test
	public void testQuestionEighteen() {
		Assertions.assertEquals(true, et.checkUppercaseStrings("hEllo"));
		Assertions.assertEquals(15, et.conStringToInt("5"));
	}
	
	@Test
	public void testQuestionNineteen() {
		String expected ="[4, 6, 8, 9, 10]";
		Assertions.assertEquals(expected, nt.questionNineteen());
		
	}
	
	@Test
	public void testQuestionTwenty() {
		File file = new File("C:\\Users\\vfxfu\\Desktop\\Revature\\Code\\coreJavaAssignment\\src\\Data.txt");
		Assertions.assertEquals(true, file.exists());
	}
}
