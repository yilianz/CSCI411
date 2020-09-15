 /**
 * An interface for a message passing scheme.
 */

public interface Channel
{
        /**
         * Send a message to the channel.
         * It is possible that this method may or may not block.
         */
	public  abstract void send(Object message);
        
        /**
         * Receive a message from the channel
         * It is possible that this method may or may not block.
         */
	public  abstract Object receive();
}
