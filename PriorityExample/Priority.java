import java.util.concurrent.*;

public class Priority
{
	private static int MAXIMUM_THREAD = 10;

	public static void main(String[] args) {


		//fixed size thread pool
		ExecutorService pool = java.util.concurrent.Executors.newFixedThreadPool(MAXIMUM_THREAD);

		System.out.println("Start multithreading");


		// just for  kicks, use a thread pool
		//	System.out.println("Thread " +i +"  starts");

			pool.execute(new Task(0));

		// sleep for 10 seconds

		try { Thread.sleep(1000000); } catch (InterruptedException ie) { }

		System.out.println("Main Thread  is done");
		pool.shutdown();


	}
}
