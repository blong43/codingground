import java.util.*;

/*
 *  Author: Blong Thao
 *  Date:   9/2/15
 *  
 *  Assumptions for split function:
 *  -- String splits on a character and stores characters on the left of it
 *  -- Multiple split characters will produce an empty string in the array
 *  -- Cannot split a null String, will print out error
 *  -- 
 *  
 */

public class SplitDriver {
	
	public static void main(String[] args) {
		Library lib = new Library();
		testSplitFunctionality(lib);
		testSplitUserInput(lib);
	}
	
	// Test Code for split function
	private static void testSplitFunctionality(Library lib) {
		
		String[] stringsToSplit = 
			{"I love turtles", "baby", "Zookeeper", null, "", "abcd"};
		char[] splitOn = {' ', 'a', 'o', 'x', 'x', lib.emptyChar};
		String[][] strArrayTestCases = {{"I", "love", "turtles"}, {"b", "by"},
				{"Z", "", "", "keeper"}, {null}, {""}, {"a", "b", "c", "d"}};
		int testCaseLength;
		boolean success;
		
		System.out.println("--- TESTING split functionality ---");
		
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
			
			
			testCaseLength = strArrayTestCases[i].length;
			
			// Check against longer or shorter arrays, unsuccessful if not equal lengths
			if (stringArray != null && testCaseLength == stringArray.length) {
				for (int j = 0; j < strArrayTestCases[i].length; j++) {			
					if (!stringArray[j].equals(strArrayTestCases[i][j])) {
						success = false;
					}
				}
			}
			else {
				success = false;
			}
			
			if (!success) {
				System.out.println(stringsToSplit[i] + ": Unsuccessful Split");
			} 
			else {
				System.out.println(stringsToSplit[i] + ": Successful Split");
			}
			
			printOutput(stringArray);
			System.out.println("\n");
		}
	}
	
	// Allows for user input for the string to split and split on character
	private static void testSplitUserInput(Library lib) {
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