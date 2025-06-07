package varargs;

public class VarArgs {

    public static void main(String[] args) {

        // ******************************************************************************
        // varargs = allow a method to accept a varying # of arguments
        // makes methods more flexible, no need for overloaded methods
        // Java will pack the arguments into an array
        // ... (ellipsis)
        // ******************************************************************************

        // Gibt den Durchschnitt der Zahlen 1, 2, 3 und 4 auf der Konsole aus
        System.out.println(average(1, 2, 3, 4));
    }

    /*
     * In loc de a scrie asa:
     * static double add(int a, int b) { ... }
     * static double add(int a, int b, int c) { ... }
     * static double add(int a, int b, int c, int d) { ... }
     * static double add(int a, int b, int c, int d, int e) { ... }
     * static double add(int a, int b, int c, int d, int e, int f) { ... }
     * static double add(int a, int b, int c, int d, int e, int f, int g) { ... }
     * 
     * Putem scrie asta prin o ellipsa "...". 
     * Asa noi putem baga un infinit de numere in methoda.
     */

    // Methode zur Berechnung des Durchschnitts beliebig vieler Zahlen
    static double average(double... numbers) { // <-- Aici am folosit ellipsa
        double sum = 0;

        // Schleife über alle Zahlen im Array 'numbers'
        for (double number : numbers) {
            sum += number; // Addiere jede Zahl zur Summe
        }

        // Gib den Durchschnitt zurück: Summe geteilt durch die Anzahl der Zahlen
        return sum / numbers.length;
    }
}
