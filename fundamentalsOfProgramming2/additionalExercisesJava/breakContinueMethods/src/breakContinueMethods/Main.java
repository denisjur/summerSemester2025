package breakContinueMethods;

public class Main {
    public static void main(String[] args){
        // break = break out of a loop (STOP)
        // continue = skip current iteration of a loop (SKIP)

        for(int i = 0; i < 10; i++){

            if(i == 5){
            	// break; // Output: 0 1 2 3 4
                continue; // Skip current iteration, Output: 0 1 2 3 4 6 7 8 9
            }

            System.out.print(i + " ");
        }
    }
}

