import java.util.*;

/*
 *  Author: Blong Thao
 *  Date:   9/2/15
 *  
 *  Assumptions for split function:
 *  -- Cannot split a null String, will print out error
 *  
 *  -- String splits on a character and stores characters on the left of it
 *  	into the String array as a string.
 *  
 *  -- Multiple split characters will produce empty strings in the array
 *  	equal to the amount of adjacent split characters.
 *  
 *  -- An empty string stores an empty string into the String[]
 *  
 *  -- An empty onSplit character splits all characters in the string into
 *  	the string array.
 *  
 *  Edge Cases:
 *  -- Empty String: Stores an empty string into the String array ([""])
 *  
 *  -- null String: Returns null, and error message ("Cannot split null")
 *  
 *  Limitations:
 *  -- User Input: cannot input null or whitespace for the onSplit character
 *  	and does not prompt user again to split another String.
 */

public class SplitDriver {
	
	public static void main(String[] args) {
		Library lib = new Library();
		testSplitFunctionality(lib);
		testSplitUserInput(lib);
	}
	
	// Test Code for split function
	private static void testSplitFunctionality(Library lib) {
		// Test Cases
		String[] stringsToSplit = 
			{"I love turtles", "baby", "Zookeeper", null, "", "abcd"};
		char[] splitOn = {' ', 'a', 'o', 'x', 'x', lib.emptyChar};
		String[][] strArrayTestCases = {{"I", "love", "turtles"}, {"b", "by"},
				{"Z", "", "", "keeper"}, {null}, {""}, {"a", "b", "c", "d"}};
		int testCaseLength;
		boolean success;
		
		System.out.println("--- TESTING split functionality ---");
		
		// Traverses through the test case arrays to see if the split function
		// returns the correct output, otherwise, prints out an error message
		for (int i = 0; i < stringsToSplit.length; i++)	{
			success = true;
			String[] stringArray = lib.split(stringsToSplit[i], splitOn[i]);
			
			if (stringArray == null) {
				System.out.println("String to split: " + stringsToSplit[i] +
						", on " + '"' + splitOn[i] + '"');
				System.out.println("Cannot split null\n");
				continue;
			} else {
				System.out.println("String to split: " + '"' + stringsToSplit[i] + 
						'"' + ", on " + '"' + splitOn[i] + '"');
			}
			
			// Store the length of each test case string to be compared against
			testCaseLength = strArrayTestCases[i].length;
			
			// Check against longer or shorter Strings, unsuccessful if not equal lengths
			if (stringArray != null && testCaseLength == stringArray.length) {
				
				// Traverse through each string in the testcase[] and string[]
				for (int j = 0; j < strArrayTestCases[i].length; j++) {
					// Unsuccessful split if test case strings did not match
					if (!stringArray[j].equals(strArrayTestCases[i][j])) {
						success = false;
					}
				}
			}
			else {
				success = false;
			}
			
			// Print out success or fail
			if (!success) {
				System.out.println(stringsToSplit[i] + ": Unsuccessful Split");
			} 
			else {
				System.out.println(stringsToSplit[i] + ": Successful Split");
			}
			
			// Print the string array, unravel it and make it look pretty
			printOutput(stringArray);
			System.out.println("\n");
		}
	}
	
	// Allows for user input for the string to split and splitOn character
	private static void testSplitUserInput(Library lib) {
		System.out.println("--- TESTING User Input for split ---\n");
		
		String stringToSplit = "";
		char splitOn = '\0';
		boolean error = true;
		Scanner in = new Scanner(System.in);
		
		do {
			try {
				System.out.println("Enter a string to split");
				stringToSplit = in.nextLine();
				
				System.out.println("Enter a char to split on (Will take first character)");
				splitOn = in.next().charAt(0);
				error = false;
			}
			catch (Exception e) {
				System.out.println("Error, re-input values");
			}
		} while (error);
		
		String[] stringArray = lib.split(stringToSplit, splitOn);
		System.out.println("String to split: " + '"' + stringToSplit + 
				'"' + ", on " + '"' + splitOn + '"');
		printOutput(stringArray);
		in.close();
	}
	
	private static void printOutput(String[] stringArray) {
		// String[] is null, output "null"
		if (stringArray == null) {
			System.out.print("null");
		}
		else {
			// Print out each String in the String[]
			System.out.print("[");
			for (int j = 0; j < stringArray.length; j++) {
				System.out.print('"' + stringArray[j] + '"');
				if (j != stringArray.length - 1) {
					System.out.print(", ");
				} else {
					System.out.print("]");
				}
			}
		}
	}
	
}