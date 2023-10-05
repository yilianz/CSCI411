/* The progam will create four thread from threadpool and run the same task */
/* import the library contains Executors */
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class parallelcomputing {
    // the main program that create multiple threads
    public static void main(final String[] args) {
        // create threads with Executor service
        ExecutorService executor = Executors.newFixedThreadPool(4);

        // run the task through the threads
        task [] tasks = new task[4];

        long starttime = System.nanoTime();

        for (int i = 0; i < 4; i++) {
            tasks[i] = new task(i*1000000);
            executor.execute(tasks[i]);
        }
        //wait for all threads to finish
        double Total = 0;
        executor.shutdown(); // no more new tasks
        // Use awaitTermination to wait for all threads to finish
        try {
            executor.awaitTermination(Long.MAX_VALUE, java.util.concurrent.TimeUnit.NANOSECONDS);
            System.out.println("All threads are finished");
            for (int i = 0; i < 4; i++) {
                Total += tasks[i].getSum();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


        long endtime = System.nanoTime();
        System.out.println("Execution time for four threads is " + (endtime - starttime) + " Answer is " + (4*Total));

    }
  
}


/**
 * Innerparallelcomputing
 */
class task implements Runnable {
    private int startvalue;
    private double sum;
    

    public task(int startvalue) {
        this.startvalue = startvalue;
        this.sum = 0;
    }
    public double getSum() {
        return this.sum;
    }

    @Override
    public void run() {
        System.out.println("Thread " + startvalue + " is running");
        int sig = 1;
        for (int i = startvalue; i < startvalue+1000000; i++) {
                this.sum += 1.0 / (2.0 * i + 1) * sig;
                sig = (-1) * sig;
            }
        System.out.println("Thread " + startvalue + " is finished "+ this.sum);
    }    
}