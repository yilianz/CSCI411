import java.util.concurrent.*;

public class Priority
{
	private static int MAXIMUM_THREAD = 10;
	private static int num_priority = 6;
		public static void main(String[] args) {
		
		
		//fixed size thread pool
		ExecutorService pool = java.util.concurrent.Executors.newFixedThreadPool(MAXIMUM_THREAD);
		
		System.out.println("Start multithreading");
		
	
		// just for kicks, use a thread pool
		pool.execute(new Task(0));


		//or get a runnable task directly 
		Runnable taskwithIO = () -> {
			Thread.currentThread().setPriority(num_priority);
                        int counter = 0;
                        while(true){
                            counter++;
                            if ((counter % 1000000) == 0) {
               			 System.out.format("Thread %d, tick = %d\n", num_priority, counter);
                
        		    }
			    if (Thread.currentThread().isInterrupted()) break;
			}
			System.out.println(" taskIO is done");
		};
	
		//pool.execute(taskwithIO);

		// sleep for 300 seconds
		try { Thread.sleep(300000); } catch (InterruptedException ie) { }

		System.out.println("Main Thread  is done");	
		pool.shutdownNow();
		
	}
}