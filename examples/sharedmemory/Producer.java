/**
 * This is the producer thread for the bounded buffer problem.
 */


import java.util.*;
import javax.swing.JOptionPane;

public class Producer implements Runnable
{
   public Producer(Buffer b) {
      buffer = b;
   }
   
   public void run()
   {
   String message;
     
      while (true) {
        // System.out.println("Producer napping");
	 	
         // produce an item & enter it into the buffer
         message = JOptionPane.showInputDialog("Please produce a product.");     
         System.out.println("Producer produced " + message);
         
         buffer.insert(message);
      }
   }
   
   private  Buffer buffer;
}
