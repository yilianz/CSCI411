/**
 * ConcurrencyTest.java
 *
 * This program uses a semaphore as a means of handling synchronization.
 * It creates 5 threads and a thread can perform its critical section
 * only if it is able to complete a acquire() operation on the sempahore.
 */

import java.util.concurrent.*;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ConcurrencyTest
{
   public static void main(String args[]) {
      ClipboardText board = new ClipboardText();
      Semaphore sem = new Semaphore(1);
      Lock boardlock = new ReentrantLock();


      Thread[] bees = new Thread[5];

      for (int i = 0; i < 5; i++)
         bees[i] = new Thread(new Worker(board, sem,boardlock,i));

      for (int i = 0; i < 5; i++)
         bees[i].start();
   }
}

