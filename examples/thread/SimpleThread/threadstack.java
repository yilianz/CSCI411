import java.io.*;
import java.util.*;
public class threadstack {

    public static void main(final String[] args) {

        // Create two threads where A is an instance of anyThread class
        // B is an instance of anyRunnable
        Thread A = new Thread(new anyRunnable());
        anyThread B = new anyThread(1);

        // wait for the two threads
        try {
            A.join();
            B.join();
        } catch (InterruptedException e) {
        }
        System.out.print("All done");
    }
}
