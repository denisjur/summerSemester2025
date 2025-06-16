package printF;

public class printF {

	public static void main(String[] args) {
		// printf() = an optional method to control, format, and display text to the console window
		// two arguments = format string + (object/variable/value)
		// % [flags] [precision] [width] [conversion-character]

		
		boolean myBoolean = true;
		char myChar = '@';
		String myString = "Bro";
		int myInt = 50;
		double myDouble = 1000;
		
		// %b → boolean
		// %c → character
		// %s → string
		// %d → integer
		// %f → floating-point
		
		System.out.printf("%b\n", myBoolean);  // Prints: true or false
		System.out.printf("%c\n", myChar);     // Prints: a single character like '@'
		System.out.printf("%s\n", myString);   // Prints: a string like "Bro"
		System.out.printf("%d\n", myInt);      // Prints: an integer like 50
		System.out.printf("%f\n", myDouble);   // Prints: a floating-point number like 1000.000000

		
		// [width]
		// minimum number of characters to be written as output
		// System.out.printf("Hello %10s", myString);

		// [precision]
		// sets number of digits of precision when outputting floating-point values
		// System.out.printf("You have this much money %.2f ", myDouble);

		// [flags]
		// adds an effect to output based on the flag added to format specifier
		// - : left-justify
		// + : output a plus ( + ) or minus ( - ) sign for a numeric value
		// 0 : numeric values are zero-padded
		// , : comma grouping separator if numbers > 1000

		 System.out.printf("Boolean: %-5b | Char: %3c | String: %-10s | Int: %+08d | Money: %,.2f\n", myBoolean, myChar, myString, myInt, myDouble);

	}

}
