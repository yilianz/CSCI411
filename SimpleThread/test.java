import java.util.*;

public class test {
    public static void main(String[] args) {
        System.out.println("Hello World");
        // Create two threads where A is an instance of anyThread class
        // B is an instance of anyRunnable
        anyThread A = new anyThread(1);
        Thread B = new Thread(new anyRunnable());

        // check the state of thread
        System.out.println("Thread A state:" + A.getState());
        System.out.println("Thread B state:" + B.getState());

        // Start the two threads
        A.start();
        B.start();

        //Create thread C 
        Thread C = new Thread(new simpleRunnable("C"));
        Thread D = new Thread(new Runnable() {
            @Override
            public void run() {
                while(true){
                try {
                    // create random integer from 1-1000
                    
                    int random = (int) (Math.random() * 1000);
                    // sleep for random time
                    Thread.sleep(1000);
                    // print the random number
                    System.out.println("Random number: " + random);
                    // check if the current thread is interrupted
                    if (Thread.currentThread().isInterrupted()) {
                        System.out.println("Thread D is interrupted here");
                        break;
                    }

                }
                // catch the exception
                catch (InterruptedException e) {
                    System.out.println("Thread D is interrupted");
                    break;
                }
            }
            }});

            // Start the two threads
            C.start();
            D.start();
            C.interrupt();

            // check the state of thread
            System.out.println("Thread C state:" + C.getState()); 
            System.out.println("Thread D state:" + D.getState());

            // create more threads with tasks
            Runnable task1 = () -> {
                System.out.println("Task 1 is running");
            };

            Thread E = new Thread(task1);
            E.start();


            // wait for the two threads
            try {
                A.join();
                B.join();
                C.join();
                System.out.println("Thread A B C are done");
                // check the state of threads
                System.out.println("Thread A state:" + A.getState());
                System.out.println("Thread B state:" + B.getState());
                System.out.println("Thread C state:" + C.getState());
                while (D.isAlive()) {
                    D.interrupt();
                    Thread.sleep(500);
                }
                D.join();
                System.out.println("Thread D is done" + D.getState());
            } catch (InterruptedException e) {
                System.out.println("Main thread is interrupted");
            }


  
    }
    
}
