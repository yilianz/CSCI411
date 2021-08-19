/**
 * @(#)simpleRunnable.java
 *
 *
 * @author
 * @version 1.00 2011/2/3
 */

import java.io.*;
import java.util.*;

public class simpleRunnable implements Runnable{
	private final String message;

	public simpleRunnable(final String s) {
		message = s;
	}

	// method run contains the code that a thread will execute
	@Override
	public void run() {

		try {
			final PrintWriter outFile = new PrintWriter("names.txt");
			for (int i = 1; i < 20; i++) {
				int sleeptime = (int) (3 * Math.random());
				try {
					Thread.sleep(2000 * sleeptime);
				} catch (InterruptedException e) {
					System.out.printf("Thread %s is interrupted \n",message);
					break;
				}

				// catch interrupt
<<<<<<< HEAD
				// if (Thread.currentThread().isInterrupted())
				//	break;
=======
				if (Thread.currentThread().isInterrupted())
				  	   break;
>>>>>>> 3680ff5e0f5cc858203952ec300ee6a24dc5396f


				// write to a file
				outFile.println("Ashley");
				System.out.println("Thread " + message + "   is running");
			}

			// close file
			System.out.println("Thread " + message + "   is done");
			outFile.close();

		} catch (final IOException e) {
		}
    }

}