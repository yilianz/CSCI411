/**
 * tutorRoom.java
 *
 *
 */
import java.util.concurrent.*;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class tutorRoom
{
   public static void main(String args[]) {
   	dashboard board = new dashboard();
      String[] names = {"Mary", "Emma","Jennifer","Mike","Alan","Bruce","Tom"};
      Thread[] collegestudents = new Thread[7];
      // Lock mutexBoardLock = new ReentrantLock(); // Remove if you use other tools

      String  TAname= "David";

      Thread  teachingAssistant = new Thread(new TA(board,TAname));
      for(int i = 0; i < 7; i++)
         collegestudents[i] = new Thread(new students(board,/*mutexBoardLock,*/ names[i]));

      teachingAssistant.start();
      for (int i = 0; i < 7; i++)
         collegestudents[i].start();
   }
}

