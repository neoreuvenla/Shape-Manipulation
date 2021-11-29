/*
*	Converters.java    
*
*	To facilitate conversions of Strings to integers and integers to Strings
*
*	v1.0
*
*	23/11/21
*/

package conversion;

public class Converters {

	// Method to convert a String to an integer without an object
	public static int convertStrInt(String stringIn) {
		return Integer.parseInt(stringIn);
	}

	// Method to convert an integer to a String without an object
	public static String convertIntStr(int intIn) {
		return String.valueOf(intIn);
	}
}