/**
 * BoundedBuffer.java
 * 
 * This program implements the bounded buffer using Java synchronization.
 * 
 */

public class BoundedBuffer implements Buffer {
	private static final int BUFFER_SIZE = 5;

	private int count; // number of items in the buffer

	private int in; // points to the next free position in the buffer

	private int out; // points to the next full position in the buffer

	private Object[] buffer;

	public BoundedBuffer() {
		// buffer is initially empty
		count = 0;
		in = 0;
		out = 0;

		buffer = new Object[BUFFER_SIZE];
	}

	public synchronized void insert(Object item) {
		while (count == BUFFER_SIZE) {
			try {
				wait();
			} catch (InterruptedException e) {
			}
		}

		// add an item to the buffer
		++count;
		buffer[in] = item;
		in = (in + 1) % BUFFER_SIZE;

		if (count == BUFFER_SIZE)
			System.out.println("Producer Entered " + item + " Buffer FULL");
		else
			System.out.println("Producer Entered " + item + " Buffer Size = "
					+ count);

		notify();
	}

	// consumer calls this method
	public synchronized Object remove() {
		Object item;

		while (count == 0) {
			try {
				wait();
			} catch (InterruptedException e) {
			}
		}

		// remove an item from the buffer
		--count;
		item = buffer[out];
		out = (out + 1) % BUFFER_SIZE;

		if (count == 0)
			System.out.println("Consumer Consumed " + item + " Buffer EMPTY");
		else
			System.out.println("Consumer Consumed " + item + " Buffer Size = "
					+ count);

		notify();

		return item;
	}

}
