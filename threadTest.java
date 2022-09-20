/*****
 ** Thread Example
 **
 **
 */


import java.io.*;
import java.util.*;

public class threadTest{
    private static int k = 4;
    private static double[] a = {0,0,0,0};
    public static void main(final String[] args) {

		// Create a new thread
		simpleThreadClass mythread1;
		simpleThreadClass mythread2;
		
	
		mythread1 = new simpleThreadClass(0);
		mythread2 = new simpleThreadClass(1);
		final Thread mythread3 = new Thread(new simpleRunnable("R1"));
		

	
		final Thread mythread4 = new Thread(new Runnable() {
			@Override
			public void run() {
				System.out.println("Thread " + k + " is running");
			}
		});


		
		Runnable task1 = () ->{
			a[0]++;
			System.out.println(a[0]);
		};

		Thread worker = new Thread(task1);
		worker.start();


		Runnable task = () -> {
			System.out.println("this is a runnable task");
		};

		// Get another worker

		System.out.println(mythread4.getState());

		// Run the thread
		mythread1.start();
		mythread2.start();
		mythread3.start();
		mythread4.start();
	

		// main thread continues
		try {
			int sleeptime = (int) (2 * Math.random());
			Thread.sleep(2000 * sleeptime);
			System.out.println("My thread 4 is "+mythread4.getState());

			// interrupt method
			//mythread3.interrupt();
			//System.out.println(mythread3.getState());
			// use deferred cancellation

			// main thread wait for other threads 
			mythread1.join();

	
		} catch (InterruptedException e) {
		}

	
	    System.out.println(Thread.currentThread());



    }

}

