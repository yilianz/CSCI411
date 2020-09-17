/**
 * @(#)add.java
 *
 *  A thread which performs addition. 
 * @author 
 * @version 1.00 2009/2/4
 */
import java.util.*;

public class add implements Runnable{

	private value sharedvalue;
    public add(value i) {
    	this.sharedvalue = i;
    }
    
    public void run() {
    	int sum = 0;
    	
    	while (sum <100000) {
    		//add
    		sum = sharedvalue.getValue();
    		sum++;	
    		sharedvalue.setValue(sum);
    		System.out.println("Value add by one: "+sharedvalue.getValue());
    			
    		// sleep
    		int naptime = 2000+(int)(Math.random())*10000;
    		try { Thread.sleep(naptime); }
        	catch (InterruptedException e) {}
    		
    	}
    	
    }
    
    
}