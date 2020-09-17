/**
 * @(#)value.java
 *
 * The address space shared by two threads
 *
 * @author 
 * @version 1.00 2009/2/4
 */



class value {
	
	private int val=0;
   
   	public int getValue(){
   		return val;
   	}
    
    public void setValue(int i){
    	this.val = i;
    }
    
}