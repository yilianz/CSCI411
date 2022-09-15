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

		// Create a command line window
		System.out.print("bash>");

		// Read the command ** A command without parameter **
		ProcessBuilder pb;
		Process proc;
		Scanner console = new Scanner((System.in));
		String command = console.nextLine();
		String[] temp = command.split(" ");
		if (temp.length==1) {
			if(temp[0].equals("dir")||temp[0].equals("ls"))
			{ 
				pb = new ProcessBuilder("cmd","/c","dir");
			}else{
			 pb= new ProcessBuilder(command);
			}
			 proc = pb.start();	
		}else{
			System.out.println(temp[0]+" "+temp[1]);

			pb = new ProcessBuilder(temp[0], temp[1]);
			proc = pb.start();	
		}
		
		
		

		// obtain the input and output streams
		Scanner br = new Scanner(proc.getInputStream());
		
		while (br.hasNextLine()) {
                System.out.println(br.nextLine());
            }

		br.close();		
			

		// end	
			
			
		
	}
}
