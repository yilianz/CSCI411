/**
 * This creates the buffer and the producer and consumer threads.
 *
 */
public class Factory
{
	public static void main(String args[]) {
		Buffer server = new BoundedBuffer();

      		// now create the producer and consumer threads
      		Thread producerThread = new Thread(new Producer(server));
      		Thread consumerThread = new Thread(new Consumer(server));
      
      		producerThread.start();
      		consumerThread.start();               
	}
}
