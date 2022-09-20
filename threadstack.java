import java.io.*;
import java.util.*;
public class threadstack {

    public static void main(final String[] args) {

        // Create two threads where A is an instance of anyThread class
        // B is a thread object that executable anyRunnable task
        anyThread A = new anyThread(1);
        Thread B = new Thread(new anyRunnable(2));

        // Start the thread
        A.start();
        B.start();

        // Create one thread C where C runs simpleRunnable task.
        // and thread D where D continues printing random integers from 1-1000
        Thread C = new Thread(new simpleRunnable("filethread 1"));
        Thread D = new Thread(new Runnable(){ 
            @Override
            public void run(){
                for(int i =1; i<10; i++){
                    int rnumber = (int)(1000*Math.random());
                    System.out.println("Thread D running "+ rnumber);
                    try{Thread.sleep(500);}catch(InterruptedException e){}
                }

        }});
        C.start();
        D.start();

        // Main thread continues
        try {
            System.out.println(Thread.currentThread());
            System.out.println(C.getState());
            C.interrupt();
            System.out.println(C.getState());
            System.out.println(A.getState());
            A.join();
            System.out.println(A.getState());
            B.join();   
            System.out.println(Thread.currentThread());
        } catch (InterruptedException e) {
        }
        System.out.print("All done");
    }
}
