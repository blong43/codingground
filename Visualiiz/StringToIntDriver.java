import java.util.*;

/*
 *  Author: Blong Thao
 *  Date:   9/2/15
 *  
 *  Assumptions:
 *  -- Accounts for only base 10 strings (0-9), otherwise, returns null 
 *  -- Default stringToInt(String) function is preset base 10
 *  	OR stringToInt(string, base), does not have this functionality yet
 *  -- Negative numbers("-1") are valid strings
 *  -- User can input the string they want to convert to integer
 *  -- Number overflow will occur if String value is larger than the Integer
 *       int is 32 bit signed type ranges from -2,147,483,648 to 2,147,483,647     
 */


public class StringToIntDriver {
	
	public static void main(String[] args) {
		Library lib = new Library();
		testStringToInt(lib);
		testStrToIntInput(lib);
	}
	
	// Run the test cases for the stringToInt function and print the number
	private static void testStringToInt(Library lib) {
		String[] testCases = {"123", "abc", "123ab45"};
		Integer number;

		System.out.println("--- TESTING stringToInt functionality ---");
		
		for (int i = 0; i < testCases.length; i++) {
			number = lib.stringToInt(testCases[i]);
			System.out.println(number);
		}
	}
	
	// Takes in user input and outputs the number
	private static void testStrToIntInput(Library lib) {
		Scanner in = new Scanner(System.in);
		boolean error = true;
		String inputVal = "";
		
		do {
			try {
				System.out.println("Enter a string to convert to int");
				inputVal = in.nextLine();

				error = false;
			}
			catch (Exception e) {
				System.out.println("Error, re-input values");
			}
		} while (error);

		Integer number = lib.stringToInt(inputVal);
		if (number != null) {
			System.out.println(number);
		}
		else {
			System.out.println("Cannot parse string, needs to be base 10");
		}
	}

}
