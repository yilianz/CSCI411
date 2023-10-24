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
	//private Lock lockX;   // Please remove it if you use other synchroization tools. 
	private String name;

	public students(dashboard board,/*Lock loc*/ String name) {
		this.name = name;
		this.board = board;
		//this.lockX = loc;  // Please remove it if you use other synchroization tools.   
	}

	public void run() {
		

		while (true) {
			
			//programming for a while
			SleepUtilities.nap(10);		
			//seek help from TA
			
            //post the status of the students whenever their status change.
			board.postMessage(name+" need help"); 

			// if the waiting room has space,  wait in hallway. 
			// Otherwise do more programming. 
			board.waitHallway(name);

			
			SleepUtilities.nap();
			
			//enter the office if TA is available
			//wait in hallway if TA is not available
			//leave if the hallway is full
			
			board.leaveHallway(name);
			board.enterRoom(name);
			
			SleepUtilities.nap();

			//leave the office and go back
			board.leaveRoom(name);
			
			
		
		}
	}

}
