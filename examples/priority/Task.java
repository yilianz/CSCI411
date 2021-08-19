public class Task implements Runnable
{
	public int name;
	
	public Task (int N){
		this.name = N;
	}

	public void run() {
		int counter = 0;
		//set the priority
	    Thread.currentThread().setPriority(Thread.MIN_PRIORITY+name);
		
		// perform a counter
		while (true) {
			 
        	 counter++;
        	
        	/*NO IO BLOCK 
        	if ((counter % 1000000) == 0) {
                System.out.format("Thread %d, tick = %d\n", name, counter);
                
        	}
            */
            if (Thread.currentThread().isInterrupted()) break;
    	}
    	
   	 System.out.println("Thread "+name +" is done");	
   	 
	}
}
