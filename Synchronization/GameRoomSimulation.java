/* A simple code that demonstrate use if statement  */

import java.util.concurrent.*;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;


public class GameRoomSimulation {
    private static int MAXIMUM_THREAD = 10;
    private static int intheRoom = 0; // measure number of the player in the room

    public static void main(String[] args) {

        // fixed size thread pool
        ExecutorService pool = java.util.concurrent.Executors.newFixedThreadPool(MAXIMUM_THREAD);

        System.out.println("Start multithreading");

        // player
        Runnable player = () -> {
            while (true) {
                // always want to join the room
                // System.out.println("Player "+ Thread.currentThread().getId()+" wants to join the room");
                if (intheRoom < 1) {
                    // wait!!! can it works?
                    intheRoom++; // The number of player is 1
                    // System.out.println("Player "+ Thread.currentThread().getId()+" is in the room");
                    if (intheRoom > 1){
                        System.out.println("Whoops We have " + intheRoom + " player"); // can it ever happens?
                        break;
                    }
                    // nap for a while
                    // SleepUtilities.nap();
                    // leave the room
                    intheRoom--;
                }
                // nap for a while
                //SleepUtilities.nap();
            }
        };

        // Start the task with two players
        pool.execute(player); 
        pool.shutdown(); // wait for termination

        try {
            if (!pool.awaitTermination(3600, TimeUnit.SECONDS)) {
                // wait for too long
                pool.shutdownNow();
                System.err.println("Tasks are not completed");
            } else {
                // done
                System.out.println("Simulation is over");
            }
        } catch (InterruptedException e) {
            pool.shutdownNow();
        }

    }
}