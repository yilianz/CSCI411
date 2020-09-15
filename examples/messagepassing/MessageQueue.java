/**
 * This program implements the bounded buffer using message passing.
 * Note that this solutions is NOT thread-safe. A thread safe solution
 * can be developed using Java synchronization which is discussed in Chapter 6.
 */

import java.util.Vector;

public class MessageQueue implements Channel
{
	private static final int   QUEUE_SIZE = 20;
   private Vector queue;

   public MessageQueue() {
      queue = new Vector();
   }

   /*
    * This implements a non-blocking send
    */
   public void send(Object item) {
   	// while (queue.size()>= QUEUE_SIZE);  // bounded capacity
      queue.addElement(item);
   }

   /*
    * This implements a non-blocking receive
    */

   public Object receive() {
      while (queue.size() == 0) {
      }

      return queue.remove(0);
    }
}
