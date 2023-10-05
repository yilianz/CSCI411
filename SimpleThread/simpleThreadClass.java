/*****
 ** A test simple thread 
 ** create a new thread
 **  USCA ACSC492F
 **
 */


import java.io.*;
import java.util.*;


public class simpleThreadClass extends Thread{
    
    private int num=0;
    
    public simpleThreadClass(final int n) {

		// the nth thread
		num = n;

	}

	// method run contains the code that a thread will execute
	@Override
	public void run() {
		for (int i = 1; i < 20; i++) {
			int sleeptime = (int) (3 * Math.random());
			try {
				Thread.sleep(2000 * sleeptime);
			} catch (final InterruptedException e) {
					System.out.printf("Thread %d is interrupted",num);
				} 
			
	    	System.out.println("Thread " + num + "   is running");
		}
    }
}

