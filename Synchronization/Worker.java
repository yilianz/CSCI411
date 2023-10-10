/**
 * Worker.java
 * 
 * This thread is used to demonstrate the operation of a semaphore. 
 * 
 */
import java.util.concurrent.*;
import java.util.concurrent.locks.Lock;

public class Worker implements Runnable {

	private Semaphore sem;
	private Lock lockX;
	private ClipboardText board;
	private int name;

	public Worker(ClipboardText board, Semaphore sem, Lock loc,int name) {
		this.name = name;
		this.sem = sem;
		this.lockX = loc;
		this.board = board;
	}

	public void run() {


		while (true) {

			// nap for a while
			SleepUtilities.nap();

			// entry section

			// critical section
			System.out.println("WORKER " + name + " requests clipboard");
			board.setText("WORKER " + name + " is using clipboard");
			// *** problem here??
			System.out.println("WORKER " + name + " copy to board: " + board.getText());
			System.out.println("WORKER " + name + " exits clipboard");

			//exit section

		}
	}

}
