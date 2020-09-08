/**
 * Demonstrating process creation in Java.
 */
 
import java.io.*;
import java.util.*;

public class OSprocess
{
	public static void main(String[] args) throws IOException {
		
		// show system environment
		Map<String, String>  enviro = System.getenv();
		for (String key:enviro.keySet()) System.out.println(key+ "  :  "+enviro.get(key));
		
		// show current directory
		String workingDirectory = System.getProperty("user.dir") + "\\";
		System.out.println(workingDirectory);
			
		// Create a command line window
		System.out.print("bash>");

		// Read the command ** A command without parameter **
		Scanner console = new Scanner((System.in));
		String command = console.nextLine();
		
		ProcessBuilder pb = new ProcessBuilder(command);
		Process proc = pb.start();	

		// obtain the input and output streams of process
		Scanner br = new Scanner(proc.getInputStream());
		
		while (br.hasNextLine()) {
                System.out.println(br.nextLine());
            }

		br.close();	
		
			
		// Read the command **A command with parameter ** 
		// Run   cmd /c dir 
		System.out.print("bash>");
		List<String>  commandlist = new ArrayList<String>(); 
		Scanner  toker = new Scanner(console.nextLine()); 
		while (toker.hasNext()) commandlist.add(toker.next());
		System.out.println(commandlist);
		
		ProcessBuilder pb1 = new ProcessBuilder(commandlist);
		Process proc1 = pb1.start();	

		// obtain the input and output streams
		Scanner br1 = new Scanner(proc1.getInputStream());
		
		while (br1.hasNextLine()) {
                System.out.println(br1.nextLine());
            }

		br1.close();			
		console.close();	
		// end	
			
			
		
	}
}
