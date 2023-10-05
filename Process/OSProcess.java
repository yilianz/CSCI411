/**
 * Demonstrating process creation in Java.
 */
 
import java.io.*;
import java.util.*;

public class OSProcess
{
	public static void main(String[] args) throws IOException {
		
		// show system enviroment
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

		// obtain the input and output streams
		Scanner br = new Scanner(proc.getInputStream());
		
		while (br.hasNextLine()) {
                System.out.println(br.nextLine());
            }

		br.close();		
			
		// Read the command **A command with parameter **
		System.out.print("bash>");
		List<String>  commandlist = new ArrayList<String>(); 
		String a = console.nextLine();
		String[] temp = a.split(" ");
		System.out.print(temp[0]+"   ---"+ temp[1]);
		//Scanner  toker = new Scanner(console.nextLine()); 
		//while (toker.hasNext()) commandlist.add(toker.next());
		//System.out.println(commandlist);
		
		//ProcessBuilder pb1 = new ProcessBuilder(commandlist);
		//Process proc1 = pb1.start();	

		/*  obtain the input and output streams
		Scanner br1 = new Scanner(proc1.getInputStream());
		
		while (br1.hasNextLine()) {
                System.out.println(br1.nextLine());
            }

		br1.close();			
		
		// end	
		*/
			
		
	}
}
