package stringmethods;

public class stringMethods {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
			
	    // String = a reference data type that can store one or more characters
        // reference data types have access to useful methods

        String name = "Bro";

        
        // ############# //IMPORTANT #########################################################################################################
        
           boolean result = name.equals("bro"); 			//Vergleicht ob der String identisch ist
        // boolean result = name.equalsIgnoreCase("bro");	//Vergleicht ob der String identisch ist unabhängig der Groß und Kleinschreibung
        // int result = name.length();						//Findet die Length des Strings
        // char result = name.charAt(0);					//Findet den Index des Characters, also die position
        // int result = name.indexOf("o");					//Findet den Char der Position, also des Index
        // boolean result = name.isEmpty();					//Falls String empty sein sollte
        // String result = name.toUpperCase();				//Schreibt den ganzen String in Großbuchstaben
        // String result = name.toLowerCase();				//Schreibt den ganzen String in kleinbuchstaben
        // String result = name.trim();						//Schneidet alle Leerzeilen aus
        // String result = name.replace('o', 'a');			//Tauscht den char aus mit einem neuen char
        
        // ###################################################################################################################################
        
        System.out.println(result); // gibt true aus
    }
	

}
