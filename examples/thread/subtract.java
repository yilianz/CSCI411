/**
 * @(#)subtract.java
 *
 *  A thread which performs subtraction.
 * @author 
 * @version 1.00 2009/2/4
 */

import java.util.*;
import javax.swing.JOptionPane;

public class subtract implements Runnable{

	private value sharedvalue;
    public subtract(value i) {
    		this.sharedvalue = i;
    }
    
    public void run() {
    	int sum = 0;
    	
    	while (sum<10000)  {
    		//subtraction
    		sum = sharedvalue.getValue();
    		sum -=1000;
    		sharedvalue.setValue(sum);
    		System.out.println("Value subtracted by 1000: "+sharedvalue.getValue());
    		
    		//wait for user response
    		JOptionPane.showMessageDialog(null, "warning, subtract by 1000");
	
    	}
    		
    }
    	
    
}