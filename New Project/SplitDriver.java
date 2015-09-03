import java.util.*;

/*
 *  Author: Blong Thao
 *  
 *  All Questions:
 *  -- What should happen when there are two or more onSplit characters? (Edge Case)
 *  -- What should the output look like?
 *  	Zookeeper output in document does not work with my logic since I store the
 *      prior string after a split. (checked with the split function and it should
 *      be ["Z", "", "keeper"])
 *  -- How do I input a null and whitespace character as the onSplit character?
 *  
 *  Assumptions:
 *  
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
		boolean success = true;
		
		System.out.println("---TESTING split functionality---");
		
		for (int i = 0; i < stringsToSplit.length; i++)	{
			String[] stringArray = lib.split(stringsToSplit[i], splitOn[i]);
			System.out.println("String to split: " + '"' + stringsToSplit[i] + 
					'"' + ", on " + '"' + splitOn[i] + '"');
			
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
		String stringToSplit;
		char splitOn;
		Scanner in = new Scanner(System.in);
		
		System.out.println("Enter a string to split");
		stringToSplit = in.nextLine();
		
		System.out.println("Enter a char to split on (Will take first character)");
		splitOn = in.next().charAt(0);
		
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