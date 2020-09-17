/**
 * @(#)addSubtract.java
 *
 *
 * @author 
 * @version 1.00 2009/2/4
 */

public class addSubtract {
        
    /**
     * Creates a new instance of <code>addSubtract</code>.
     */
    public addSubtract() {
    	
    	// allocate addressspace
    	value sharedvalue = new value();  
    	
    	// create threads
    	Thread addthr = new Thread(new add(sharedvalue));
    	Thread subthr = new Thread(new subtract(sharedvalue));
    	
    	
    	// start threads
    	addthr.start();
    	subthr.start();
    
    
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
    	
      addSubtract test=new addSubtract();
      
      
    }
}
