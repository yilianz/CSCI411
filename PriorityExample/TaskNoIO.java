public class TaskNoIO implements Runnable {
	public int prio;

	public TaskNoIO(int N) {
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
			 * NO IO BLOCK   
			 * if ((counter % 100000) == 0) {
			 * System.out.format("Thread %d, tick = %d%n", name, counter);
			 * }
			 */

		}

		// System.out.println("Thread "+name +" is done");

	}
}
