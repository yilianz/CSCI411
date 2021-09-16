import java.io.*;
import java.util.*;

public class anyThread extends Thread{
    int num =0;

    public anyThread(int a){
        num = a;
    }

    public void run(){
        System.out.println("any thread "+num+" is running ! ");
        anyThreadGoSleep();
    }

    public void anyThreadGoSleep(){
        try {
            Thread.sleep(100000);
        } catch (InterruptedException e) {
          System.out.println("Interrupted");  
        }
    }
    
}
