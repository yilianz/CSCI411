import java.io.*;
import java.util.*;
public class threadstack {

    public static void main(final String[] args) {

        // Create two threads where A is an instance of anyThread class
        // B is a thread object that executable anyRunnable task


        // Start the thread


        // Create one thread C where C runs simpleRunnable task.
        // and thread D where D continues printing random integers from 1-1000


        // Main thread continues
        try {
            A.join();
            B.join();   
            System.out.println(Thread.currentThread());
        } catch (InterruptedException e) {
        }
        System.out.print("All done");
    }
}
