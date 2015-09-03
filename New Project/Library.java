/*
 *  Author: Blong Thao
 *  
 *  Questions:
 *  -- What happens when there are two or more onSplit characters?
 *  
 *  Assumptions:
 *  
 *  
 */

public class Library {
	// ASCII character for null is 0
	public char emptyChar = 0;
	
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
					char element;			
					boolean split, atEndOfString;
					String[] temp = new String[value.length()];
					
					// Traverse value string and set the string array per split
					for (int i = 0; i < value.length(); i++) {
						element = value.charAt(i);
						atEndOfString = (i == value.length() - 1);
						split = ((element == splitOn) || atEndOfString);
						
						// Split value and set to temp array and move forward index
						// and starting position of the next string
						if ( split ) {
							// Gets the last character
							if ( atEndOfString ) {
								i += 1;
							}
							temp[strArrayIndex] = value.substring(startStr, i);
							strArrayIndex++;
							startStr = i + 1;
						}
						// What happens if you have two or more split chars in a row?
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
}

