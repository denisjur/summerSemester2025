package myjavaproject;

public class dataTypes {
		
	public static void main (String[] args) {
				// TODO Auto-generated method stub
				
				// ################# Merke ##########################################################
				
				// data type   | size     | primitive/reference | value
				// -----------------------------------------------------------
				// ⭐ boolean   | 1 bit    | primitive           | true or false
				// byte        | 1 byte   | primitive           | -128 to 127
				// short       | 2 bytes  | primitive           | -32,768 to 32,767
				// ⭐ int       | 4 bytes  | primitive           | -2 billion to 2 billion
				// long        | 8 bytes  | primitive           | -9 quintillion to 9 quintillion
				// float       | 4 bytes  | primitive           | fractional number up to 6-7 digits
				//		                                               ex. 3.141592f
				// ⭐ double    | 8 bytes  | primitive           | fractional number up to 15 digits
				//		                                               ex. 3.141592653589793
				// ⭐ char      | 2 bytes  | primitive           | single character/letter/ASCII value
				//		                                               ex. 'f'
				// ⭐ String    | varies   | reference           | a sequence of characters
				//		                                               ex. "Hello world!"
				
				// ##################################################################################
				
				// primitive vs reference data types

				// primitive:
				// - 8 types (boolean, byte, etc.)
				// - stores data
				// - can only hold 1 value
				// - less memory
				// - fast

				// reference:
				// - unlimited (user defined)
				// - stores an address
				// - could hold more than 1 value
				// - more memory
				// - slower

				// ###################################################################################
				
				int x = 123; // initialisation
				
				long y;	// declraration  	La long trebuie la sfarsit sa pui un L, ca sa mearga!!!!
				y = 298864665345435432L; // assignment
				
				float z = 3.1443523453f;  	// La float iti trebuie la sfarsit un F !!!!
				
				boolean a = true;
				
				char b = '@';
				
				String name = "Bro";
				
				System.out.println("value of x: " + x);
				System.out.println("value of y: " + y);
				System.out.println("value of z: " + z);
				System.out.println("value of a: " + a);
				System.out.println("value of b: " + b);
				System.out.println("value of name: " + name);
			
			
				

	}
	
	
	
}
