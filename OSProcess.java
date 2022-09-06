/**
 * Demonstrating process creation in Java.
 */
 
import java.io.*;
import java.util.*;

public class OSProcess
{
	public static void main(String[] args) throws IOException {
		
		/*  // show system enviroment
		Map<String, String>  enviro = System.getenv();
		for (String key:enviro.keySet()) System.out.println(key+ "  :  "+enviro.get(key));
		*/


		/*// show current directory
		String workingDirectory = System.getProperty("user.dir") + "\\";
		System.out.println(workingDirectory);
		*/	

		/*  Create a command line window
		System.out.print("bash>");

		// Read the command ** A command without parameter **
		Scanner console = new Scanner((System.in));
		String command = console.nextLine();
		*/
		
		ProcessBuilder pb = new ProcessBuilder("mspaint.exe");
		Process proc = pb.start();	

		 /* // obtain the input and output streams
		Scanner br = new Scanner(proc.getInputStream());
		
		while (br.hasNextLine()) {
                System.out.println(br.nextLine());
            }

		br.close();		
			*/

		// end	
			
			
		
	}
}
