/**
 * Worker.java
 * 
 * This thread is used to demonstrate the operation of a semaphore.
 * 
 */

public class Worker implements Runnable {

	private Semaphore sem;
	private ClipboardText board;
	private int name;

	public Worker(ClipboardText board, Semaphore sem, int name) {
		this.name = name;
		this.sem = sem;
		this.board = board;
	}

	public void run() {
		
		// set priority of the threads
               // int num = name+3;
		//Thread.currentThread().setPriority(num);
			
		while (true) {
			
			//nap for a while
			SleepUtilities.nap();
			
		   sem.acquire();  //entry section
			
			//critical section
			System.out.println("WORKER "+ name + " requests clipboard");
			board.setText("WORKER "+ name+ " is using clipboard");
//*** problem here 
			System.out.println("WORKER"+ name+"get"+board.getText());
			System.out.println("WORKER "+ name + " exits clipboard");
			
			
		    sem.release();   //exit section
		
		}
	}

}
