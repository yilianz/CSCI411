/**
 * WorkerLock.java
 * 
 * This thread is used to demonstrate the operation of a lock.
 * 
 */
import java.util.concurrent.*;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class WorkerLock implements Runnable {

	private Lock lockX;
	private ClipboardText board;
	private int name;

	public WorkerLock(ClipboardText board, Lock loc, int name) {
		this.name = name;
		this.lockX = loc;
		this.board = board;
	}

	public void run() {
		
		// set priority of the threads
               // int num = name+3;
		//Thread.currentThread().setPriority(num);
			
		while (true) {
			
			//nap for a while
			SleepUtilities.nap();
			
		   lockX.lock();  //entry section
			
			//critical section
			System.out.println("WORKER "+ name + " requests clipboard");
			board.setText("WORKER "+ name+ " is using clipboard");
			System.out.println(board.getText());
			System.out.println("WORKER "+ name + " exits clipboard");
			
			
		    lockX.unlock();   //exit section
		
		}
	}

}
