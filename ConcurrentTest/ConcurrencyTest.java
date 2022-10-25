/**
 * ConcurrencyTest.java
 *
 * This program uses a semaphore as a means of handling synchronization.
 * It creates 5 threads and a thread can perform its critical section
 * only if it is able to complete a acquire() operation on the sempahore.
 */

public class ConcurrencyTest
{
   public static void main(String args[]) {
      ClipboardText board = new ClipboardText();
      Semaphore sem = new Semaphore(1);

      Thread[] bees = new Thread[5];

      for (int i = 0; i < 5; i++)
         bees[i] = new Thread(new Worker(board, sem,i));

      for (int i = 0; i < 5; i++)
         bees[i].start();
   }
}

