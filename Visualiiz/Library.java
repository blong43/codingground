/*
 *  Author: Blong Thao
 *  Date:   9/2/15
 */

public class Library {
	// ASCII character for null is 0
	public char emptyChar = 0;
	private String alphanumeric = "0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
	
	public String[] split( String value, char splitOn ) {
		// Make sure value is not null, then begin splitting
		if (value != null) {
			// Will resize string later when it needs to become larger
			String[] retVal = new String[1];
			
			// Empty String, returns an [""]
			if (value.isEmpty()) {
				retVal[0] = "";
			}
			else {
				// Resize String array
				retVal = new String[value.length()];
				
				// Empty Char case
				if (splitOn == emptyChar) {
					
					// Set each character from value to the String[]
					for (int i = 0; i < value.length(); i++) {
						retVal[i] = Character.toString(value.charAt(i));
					}
				}
				else {
					int startStr = 0;		// start of value to set in string array
					int strArrayIndex = 0;  // index for string array
					int next = 0;
					char element, nextElement;			
					boolean split, atEndOfString, adjacent = false;
					String[] temp = new String[value.length()];
					
					// Traverse value string and set the string array per split
					for (int i = 0; i < value.length(); i++) {
						element = value.charAt(i);
						
						atEndOfString = (i == value.length() - 1);
						split = (element == splitOn);
						
						// Split value and set to temp array and move forward index
						// and starting position of the next string
						if ( split || atEndOfString ) {
							// Save the next index, used in multiple places
							next = i + 1;
							
							// Check if next element is another onSplit char
							// as long as its not the end of string
							if (!atEndOfString) {
								nextElement = value.charAt(next);
								adjacent = (element == nextElement);
							}
							
							// Gets the last character, cannot be the onSplit char
							if ( atEndOfString && !split) {
								i += 1;
							}
							
							temp[strArrayIndex] = value.substring(startStr, i);
							strArrayIndex++;
							
							// nextElement is also the onSplit character
							if ( adjacent && startStr < i) {
								startStr++;
								temp[strArrayIndex] = value.substring(startStr, i);
								strArrayIndex++;
								adjacent = false;
							}
							startStr = next;
								
						}
					}
					
					// Set size of String[] to the actual size of valid strings
					retVal = new String[strArrayIndex];
					
					// Assign the temp array values to the retVal array
					// to avoid null values in String[]
					for (int i = 0; i < temp.length; i++) {
						if (temp[i] == null) {
							break;
						}
						retVal[i] = temp[i];
					}
				}
			}
			return retVal;
		}
		// value was null
		return null;
	}
	
	// stringToInt with only the String parameter, defaults to base 10
	public Integer stringToInt(String value) {
		return stringToInt(value, 10);
	}
	
	public Integer stringToInt(String value, int base) {
		// The base has to be between 2-62 to work
		if (base < 2 || base > 62) {
			System.out.println("Error: input a base from 2 to 62");
			return null;
		}
		
		// String is not null, then begin the string to int conversion
		if (value != null) {
			// number to return, element is a char in String
			int number = 0, power = 0, element;
			boolean valid;
			
			// characters in each base
			String baseChars = alphanumeric.substring(0, base);
			
			// check string if it contains any invalid characters
			for (int i = 0; i < value.length(); i++) {
				// reset valid after checking against baseChars
				valid = false;
				
				for (int j = 0; j < baseChars.length(); j++) {
					if (value.charAt(i) == baseChars.charAt(j) ) {
						valid = true;
						break;
					}
				}
				// Return null upon invalid strings
				if (!valid) {
					System.out.println("Invalid String");
					return null;
				}
			}
			
			// Start from the rightmost character in the String
			for (int i = value.length() - 1; i >= 0; i--, power++) {
				element = value.charAt(i);
				
				// Check if the element is a valid character
				if (!Character.isLetterOrDigit(element)) {
					return null;
				}
				// Convert from ASCII to integer for 0-9
				else if (Character.isDigit(element)) {
					element -= '0';
				}
				// Convert from ASCII to integer for a-z
				else if (Character.isLowerCase(element)) {
					element -= 'a' - 10;
				}
				// Convert from ASCII to integer for A-Z
				else if (Character.isUpperCase(element)) {
					element -= 'A' - 36;
				}
				
				// Get the decimal(base10) value of the string
				number += element * Math.pow(base, power);
			}
			return number;
		}
		// Invalid string (null check)
		System.out.println("String is null");
		return null;
	}
	
}
