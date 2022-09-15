

public class threadApp {
    public static void main(String[] args) throws InterruptedException {

        // one thread
        long starttime = System.nanoTime();
        double sum = 0;
        int sign = 1;
        for (int i = 0; i < 4000000; i++) {
            sum += 1.0 / (2.0 * i + 1) * sign;
            sign = (-1) * sign;
        }
        sum = 4 * sum;

        long endtime = System.nanoTime();

        System.out.println("Execution time for one thread is " + (endtime - starttime) + " Answer is " + sum);

        // four 
        //  0 -1000000 1000000- 2000000 2000000 - 300000 3000000-4000000
        double partialSum1[]=new double[4];
        partialSum1[0]=0;   // use a loop if you can
        partialSum1[1]=0;
        Runnable task1 = ()->{
            int sig = 1;
            for (int i = 0; i < 1000000; i++) {
                partialSum1[0] += 1.0 / (2.0 * i + 1) * sig;
                sig = (-1) * sig;
            }
        };

        // get another task     


        Thread worker1 = new Thread(task1);
        //Thread worker2 = new Thread(task2);
        starttime = System.nanoTime();

        /* Start all threads */

        worker1.start();       //???? can we have array of threads 
         
        /* Wait for all threads to be finished */
       
        worker1.join();  
        

        /*After all finished Add the partial sum */

        endtime = System.nanoTime();
        System.out.println("Execution time for four threads is " + (endtime - starttime) + " Answer is " + (4*partialSum1[0]));
    }

}
