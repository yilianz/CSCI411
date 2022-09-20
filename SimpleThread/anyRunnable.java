import java.io.*;
import java.util.*;

public class anyRunnable implements Runnable{

    int num =0;
    public anyRunnable(int n){
	num = n;
    }

    public void run(){
        System.out.println("Any runnable "+num+ " is running!");
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
