

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

        // four threads
       
    }

}
