import java.io.*;
import java.util.*;

public class anyRunnable implements Runnable{

    public anyRunnable(){

    }

    public void run(){
        System.out.println("Any runnable is running");
        anyRunnableGoSleep();
    }

    public void anyRunnableGoSleep(){
        try {
            Thread.sleep(100000);
        } catch (InterruptedException e) {
          System.out.println("Interrupted");  
        }

    }

    
}
