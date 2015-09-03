import java.util.*;

/*
 *  Author: Blong Thao
 *  Date:   9/2/15
 *  
 *  Assumptions for stringToInt function:
 *  -- Default stringToInt(String) function has a preset base of 10
 *  	OR stringToInt(string, base) allows users to input any base value
 *  -- User can input the string they want to convert to integer, errors checks
 *      for invalid strings with characters not in the base characters.
 *  -- Number overflow may occur if String value is larger than an integer
 *       int is 32 bit signed type ranges from -2,147,483,648 to 2,147,483,647
 *       OR not go above the max value of an integer
 *  -- The base number value can be between 2 and 62, outputs accordingly
 *  -- Allows user to input only once upon successful conversion     
 */


public class StringToIntDriver {
	
	public static void main(String[] args) {
		Library lib = new Library();
		testStringToInt(lib);
		testStrToIntInput(lib);
	}
	
	// Run the test cases for the stringToInt function and print the number
	private static void testStringToInt(Library lib) {
		String[] testCases = {"abc", "123", "123ab45"};
		Integer[] results = {null, 123, null};
		Integer number;
		String testResult;

		System.out.println("--- TESTING stringToInt functionality ---");
		
		// Show the results of each of the test cases
		for (int i = 0; i < testCases.length; i++) {
			number = lib.stringToInt(testCases[i]);
			
			testResult = "stringToInt(" + "'" + testCases[i] + "'): ";
			if (number == results[i]) {
				System.out.println(testResult + "success");
			} 
			else {
				System.out.println(testResult + "fail");
			}
			System.out.println("return: " + number + "\n");
		}
	}
	
	// Takes in user input and outputs the number
	private static void testStrToIntInput(Library lib) {
		Scanner in = new Scanner(System.in);
		boolean error = true;
		String inputVal = "";
		int base = 10;

		// Gets user input, upon error, user can re-input values
		while (error) {
			
			// Get the string from user
			System.out.println("Enter a string to convert to int");
			if (in.hasNext()) {
				inputVal = in.nextLine();
			}
			else {
				System.out.println("Invalid string");
				in.next();
				continue;
			}
			
			// Get the base number from user
			System.out.println("Enter a integer for the base");
			if (in.hasNextInt()) {
				base = in.nextInt();
			}
			else {
				System.out.println("Invalid integer");
				in.next();
				continue;
			}
			error = false;
		}
		
		// Get the number of the string from the user input 
		Integer number = lib.stringToInt(inputVal, base);
		
		// Print the number if its not null
		if (number != null) {
			System.out.println(number);
		}
	}
}
