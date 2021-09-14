/**
 * Demonstrating process creation in Java.
 */
 
import java.io.*;
import java.util.*; 

// Try command such as  notepad, mspaint, SnippingTool, explorer   
// Try command with path such as :  C:\Program Files (x86)\Adobe\Acrobat DC\Acrobat\Acrobat.exe

public class CreateProcess {

    public static void main(String[] args) throws IOException {
    	// show system environment
		Map<String, String>  enviro = System.getenv();
        for (String key:enviro.keySet()) System.out.println(key+ "  :  "+enviro.get(key)); 
        

        // show current directory
		String workingDirectory = System.getProperty("user.dir") + "\\";
		System.out.println(workingDirectory);

        
        // Read the command ** A command without parameter **
		Scanner console = new Scanner((System.in));
		String command = console.nextLine();
        System.out.println("Start "+ command);

        //Open the process
        ProcessBuilder pb = new ProcessBuilder(command);  //step 1

        //get process environment 
        Map<String, String> enviroP = pb.environment();
        enviroP.forEach((key,value)-> System.out.println(key+" "+value));
        
		Process proc = pb.start();	// step 2

        //If process have input and output --- handle it. 

        //Implement start up process

        //create 10 notepad with this program

        console.close();


    }
    
}
