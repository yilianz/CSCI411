import java.util.concurrent.*;

public class Sync
{
	private static int MAXIMUM_THREAD = 10;
	private static int num_priority1 = 1; 
	private static int num_priority2 = 10; 
	private static int count = 0;
	
		public static void main(String[] args) {
		
		
		//fixed size thread pool
		ExecutorService pool = java.util.concurrent.Executors.newFixedThreadPool(2);
		
		System.out.println("Start multithreading");
		

		//Task 1 --- increase count 
		Runnable task1 = () -> {
			Thread.currentThread().setPriority(num_priority1);
                        for(int i = 0; i< 100000; i++){
                            count++;
                            System.out.println("count in task 1 is "+count);
			    if (Thread.currentThread().isInterrupted()) break;
			}
		};

		//Task 2 --- decrease count 
		Runnable task2 = () -> {
			Thread.currentThread().setPriority(num_priority2);
                        for(int i = 0; i< 100000; i++){
                            count--;
			    if (Thread.currentThread().isInterrupted()) break;
			}
		};

	
		pool.execute(task1); 
		pool.execute(task2);  

	
		pool.shutdown(); // wait for termination 

		try{
		    if(!pool.awaitTermination(3600, TimeUnit.SECONDS)){
			// wait for too long
			pool.shutdownNow();
			System.err.println("Tasks are not completed");
		 }else {
                        // done
			System.out.println("Count is "+count);
		  }
		}catch (InterruptedException e){
			pool.shutdownNow();
		}

		
	}
}