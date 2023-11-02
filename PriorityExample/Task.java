public class Task implements Runnable {
	public int prio;

	public Task(int N) {
		this.prio = N;
	}

	public void run() {
		int counter = 0;
		// set the priority
		Thread.currentThread().setPriority(prio);

		// perform a counter
		while (true) {

			counter++;

			/*
			 * IO BLOCK
			 */
			if ((counter % 100000) == 0) {
				System.out.format("Thread priority %d, tick = %d%n", prio, counter);
			}

		}

		// System.out.println("Thread "+name +" is done");

	}
}
