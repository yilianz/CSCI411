/**
 * This is the consumer thread for the bounded buffer problem.
 */


import java.util.*;

class Consumer implements Runnable
{
   public Consumer(Channel m) { 
      mbox = m;
   }
   
   public void run() {
   Date message;
   
     while (true)
      {
	SleepUtilities.nap();

         // consume an item from the buffer
         System.out.println("Consumer wants to consume.");
       	 message = (Date)mbox.receive();
	     if (message != null)
         	System.out.println("Consumer consumed " + message);
      }
   }
   
   private  Channel mbox;
}
