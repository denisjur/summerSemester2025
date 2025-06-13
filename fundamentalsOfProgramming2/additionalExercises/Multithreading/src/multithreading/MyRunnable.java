package multithreading;

public class MyRunnable implements Runnable { //Implements Interface Runnable
	
	
	private final String text;
	
	MyRunnable(String text) {
		this.text = text;
	};
	
	@Override
	public void run() {
		for(int i = 1; i <= 5; i++) {
			try {
				Thread.sleep(1000); //Thread should wait 1 sek before looping on
				//System.out.println(Thread.currentThread().getName()+ " " + i); // print current Thread
				System.out.println(text);
			}
			catch (InterruptedException e) {
				System.out.println("Thread was interrupted");
			}
		}
	}
}