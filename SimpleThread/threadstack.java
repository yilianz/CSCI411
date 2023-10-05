import java.io.*;
import java.util.*;
public class threadstack {

    public static void main(final String[] args) {

        // Create two threads where A is an instance of anyThread class
        // B is an instance of anyRunnable
        Thread B = new Thread(new anyRunnable());
        anyThread A = new anyThread(1);
        // check the state of thread 
        System.out.println("Thread A state:" + A.getState());

        // Start the two threads
        A.start();
        B.start();

        // wait for the two threads
        try{
            A.join();
            B.join();
        }catch(InterruptedException e){
            System.out.println("Interrupted");
        }

         
        System.out.print("Main --- All done");

        // create more threads 
        Thread D = new Thread(new Runnable(){
            public void run(){
                while(true){
                    Random rand = new Random();
                    System.out.println("Thread D produced" + rand.nextInt(1000));
                    try{
                        Thread.sleep(10000);
                    }catch(InterruptedException e){
                        System.out.println("Interrupted");
                    }
                }
            }
        });
        D.start();
        //create thread C


    }
}
