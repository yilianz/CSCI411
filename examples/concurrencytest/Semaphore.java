/**
 * Semaphore.java
 *
 * A basic counting semaphore using Java synchronization.
 */

public class Semaphore
{
   private int value;

   public Semaphore(int value) {
      this.value = value;
   }

   public synchronized void acquire() {
   	  // semaphore requires no busy waiting
      while (value <= 0) {
         try {
	    //System.out.println("wait "+value);
            wait();
	    //System.out.println("After wait "+value);
         }
         catch (InterruptedException e) { }
      }
	  // semaphore requires busy waiting
	  //while (value <= 0);

      value--;
   }

   public synchronized void release() {
      ++value;
	
	  //semaphore requires no busy waiting	
        notify();
      
      //semaphore requires busy waiting
      
   }
}

