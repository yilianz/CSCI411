/**
 * This program gives an example of how deadlock can occur between threads.
 * 
 */

class  tworker implements Runnable
{
   private Semaphore first, second;
   private int name;
   
   public tworker(Semaphore first, Semaphore second, int name) {
      this.first = first;
      this.second = second;
      this.name = name;
   }
   
   public void run() {
    
			while (true) {
			
			//nap for a while
			SleepUtilities.nap();
			
			// Two entry
			System.out.println("WORKER "+ name + " before first entry");
			first.acquire();
			System.out.println("WORKER "+ name + " before second entry");
			second.acquire();
			
			// critical section 
			System.out.println("WORKER "+ name + " in critical section");
			
			//Two release
			first.release();
			System.out.println("WORKER "+ name + " leave first entry");
			second.release();
			System.out.println("WORKER "+ name + " leave second entry");
			}

   }
}



public class DeadlockSemaphore
{  
   public static void main(String arg[]) {         
      Semaphore sem1 = new Semaphore(1);
      Semaphore sem2 = new Semaphore(1);
      
      Thread threadA = new Thread(new tworker(sem1,sem2,1));
      Thread threadB = new Thread(new tworker(sem2,sem1,2));
      
      threadA.start();
      threadB.start();
   }
}

