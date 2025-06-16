package threading;

public class MyRunnable implements Runnable {

	@Override
	public void run() { // Every code you want to run on a separate thread, place it within the run method
		for (int i = 1; i <= 5; i++) {
			try {
				Thread.sleep(1000); // Wartet 1000 ms (1 Sekunde)
			} catch (InterruptedException e) {
				System.out.println("Thread was interrupted");
			};
			
			if (i == 5) {
				System.out.println("Time is up!");
				System.exit(0); // Hiermit kann man nach Ablauf der Zeit nicht mehr den Namen schreiben!
								// So we exit the Thread!
			}
		}
	}
	
}
