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

        // player 1
        Runnable player1 = () -> {
            while (true) {
                // always want to join the room
                System.out.println("Player 1 want to join the room" + intheRoom);
                if (intheRoom < 1) {
                    // wait!!! can it works?
                    intheRoom++; // The number of player is 1
                    if (intheRoom > 1)
                        System.out.println("Whoops We have " + intheRoom + " player"); // can it ever happens?

                    // nap for a while
                    SleepUtilities.nap();

                    System.out.println("Player 1 leave the room " + intheRoom);
                    intheRoom--;
                }
                // nap for a while
                SleepUtilities.nap();

            }
        };

        // Start the task with two players
        pool.execute(player1);

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