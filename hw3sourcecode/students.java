/**
 * Student.java
 * 
 * 
 * 
 */
import java.util.concurrent.*;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class students implements Runnable {

	private dashboard board;
	private Lock lockX;   // You might remove it if you don't need the lock. 
	private String name;

	public students(dashboard board, Lock loc, String name) {
		this.name = name;
		this.board = board;
		this.lockX = loc;
	}

	public void run() {
		

		while (true) {
			
			//programming for a while
					
			//seek help from TA
			

			board.postMessage(name+" need help");
			board.waitHallway(name);

			
			SleepUtilities.nap();
			
			//enter the office if TA is available
			//wait in hallway if TA is not available
			//leave if the hallway is full
			
			board.leaveHallway(name);
			board.enterRoom(name);
			
			SleepUtilities.nap();

			
			board.leaveRoom(name);
			
			//leave the office and go back
		
		}
	}

}
