/**
 * @(#)add.java
 *
 *  A thread which performs addition. 
 * @author 
 * @version 1.00 2009/2/4
 */
import java.util.*;

public class multiply implements Runnable{

	private value sharedvalue;
    public multiply(value i) {
    	this.sharedvalue = i;
    }
    
    public void run() {
    	int sum = 0;
    	
    	while (sum <100000) {
    		//multiply
    		sum = sharedvalue.getValue();
    		sum *=2;	
    		sharedvalue.setValue(sum);
    		System.out.println("Value multiply by two: "+sharedvalue.getValue());
    			
    		// sleep
    		int naptime = 2000+(int)(Math.random())*10000;
    		try { Thread.sleep(naptime); }
        	catch (InterruptedException e) {}
    		
    	}
    	
    }
    
    
}