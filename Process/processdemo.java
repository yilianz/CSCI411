import java.io.IOException;

public class processdemo {
    public static void main(String[] args) {
        try {
            // Create a new process using the ProcessBuilder class
            ProcessBuilder processBuilder = new ProcessBuilder("C:\\Program Files\\Microsoft Office\\root\\Office16\\WINWORD.EXE");
            
            // Start the process
            Process process = processBuilder.start();
            
            // Wait for the process to complete
            int exitCode = process.waitFor();
            
            // Print the exit code
            System.out.println("Process exited with code: " + exitCode);
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }
}