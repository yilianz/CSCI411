/**
 * ConcurrencyTestLock.java
 *
 *
 */
import java.util.concurrent.*;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ConcurrencyTestLock
{
   public static void main(String args[]) {
      ClipboardText board = new ClipboardText();
      Lock accessClipboard = new ReentrantLock();

      Thread[] bees = new Thread[5];

      for (int i = 0; i < 5; i++)
         bees[i] = new Thread(new WorkerLock(board, accessClipboard,i));

      for (int i = 0; i < 5; i++)
         bees[i].start();
   }
}

