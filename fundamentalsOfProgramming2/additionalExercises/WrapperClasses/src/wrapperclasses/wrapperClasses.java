package wrapperclasses;

public class wrapperClasses {

	public static void main(String[] args) {
		
		
		// #############  IMPORTANT Wrapper Class = provides a way to use primitive data types as reference data types! ###################################
        //                							reference data types contain useful methods
        //                							can be used with collections (ex. ArrayList)

		// IMPORTANT DE CE E IMPORTANT? Ca poti sa accesezi methode, cum am putut si la strings, dar la primitive data typs nu ai putea!!
        // primitive     wrapper
        // -----------   ------------
        // boolean       Boolean
        // char          Character
        // int           Integer
        // double        Double
		
		// reference data types are slower to acces, cause it takes more steps
		
        // autoboxing = the automatic conversion that the Java compiler makes between the primitive types and their corresponding object wrapper class
        // unboxing = the reverse of autoboxing automatic conversion of wrapper class to primitive
		
		// ################################################################################################################################################
		
		Boolean a = true; 	// -> Asta ce am facut aici a fost autoboxing. Dar daca ai vrea sa folosesti un wrapper ca primitive data type, atunci ar fii unboxing!
        Character b = '@';
        Integer c = 123;
        Double d = 3.14;
        String e = "Bro";

        System.out.println("Boolean: " + a);
        System.out.println("Character: " + b);
        System.out.println("Integer: " + c);
        System.out.println("Double: " + d);
        System.out.println("String: " + e);
	}

}
