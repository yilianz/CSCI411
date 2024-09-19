/* Create a external process in Java -- process with input */
import java.io.*;
import java.util.*;

public class createprocess {
    public static void main(String args[]) {
        try {
            //print the bash symbol
            System.out.print("bash>");
            //read input from the keyboard - input is a command
            Scanner input = new Scanner(System.in);
            String command = input.nextLine();


            //create a new process using ProcessBuilder
            ProcessBuilder pb = new ProcessBuilder("cmd", "/c", command);
            //start the process
            Process process = pb.start();

            //Obtain the input stream
            Scanner inputfromprocess = new Scanner(process.getInputStream());
            //display the information from the process
            while (inputfromprocess.hasNext()) {
                System.out.println(inputfromprocess.nextLine());
            }

            //wait for the process to finish
            process.waitFor();
         
       
        } catch (Exception err) {
            err.printStackTrace();
        }
    }
}
