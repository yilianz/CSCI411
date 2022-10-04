/**
 * Demonstrating process creation in Java.
 */
 
import java.io.*;
import java.util.*;
//import java.util.Arrays;

public class OSProcess {
	public static void main(String[] args) throws IOException {

		// show system enviroment
		// Map<String, String> enviro = System.getenv();
		// for (String key:enviro.keySet()) System.out.println(key+ " :
		// "+enviro.get(key));

		// show current directory process
		String workingDirectory = System.getProperty("user.dir") + "\\";
		System.out.println(workingDirectory);

		// Read the command ** A command without parameter **
		Scanner console = new Scanner((System.in));
		// Create a command line window
		System.out.println("bash>");
		String command = console.nextLine();
		// list for history
		ArrayList<String> userHistory = new ArrayList<String>();

		String[] clist = command.split(" ");
		ProcessBuilder pb;// = new ProcessBuilder();
		Process proc;// = pb.start();
		
		// while loop and condition for all commands
		while (!clist[0].equals("exit")) {
			// for PWD_CD
			if (clist[0].equals("pwd") || clist[0].equals("cd")) {
				userHistory.add(command);
				pb = new ProcessBuilder("cmd", "/c", "cd");
				proc = pb.start();
				Scanner br = new Scanner(proc.getInputStream());
				while (br.hasNextLine()) {
					System.out.println(br.nextLine());
				}
			}
			// LS_DIR
			else if (clist[0].equals("dir") || clist[0].equals("ls")) {
				userHistory.add(command);
				pb = new ProcessBuilder("cmd", "/c", "dir");
				proc = pb.start();
				Scanner br = new Scanner(proc.getInputStream());
				while (br.hasNextLine()) {
					System.out.println(br.nextLine());
				}
			}
			// CP_COPY
			else if (clist[0].equals("copy") || clist[0].equals("cp")) {
				userHistory.add(command);
				pb = new ProcessBuilder("cmd", "/c", "copy", clist[1], clist[2]);
				proc = pb.start();
			}
			// RM_DEL
			else if (clist[0].equals("rm") || clist[0].equals("del")) {
				userHistory.add(command);
				pb = new ProcessBuilder("cmd", "/c", "del", clist[1]);
				proc = pb.start();
				Scanner br = new Scanner(proc.getInputStream());
				while (br.hasNextLine()) {
					System.out.println(br.nextLine());
				}
			}
			// MORE
			else if (clist[0].equals("more")) {
				userHistory.add(command);
				pb = new ProcessBuilder("cmd", "/c", "more", clist[1]);
				proc = pb.start();
				Scanner br = new Scanner(proc.getInputStream());
				while (br.hasNextLine()) {
					System.out.println(br.nextLine());
				}
			}
			// MAN_HELP
			else if (clist[0].equals("man") || clist[0].equals("help")) {
				userHistory.add(command);
				pb = new ProcessBuilder("cmd", "/c", "help", clist[1]);
				proc = pb.start();
				Scanner br = new Scanner(proc.getInputStream());
				while (br.hasNextLine()) {
					System.out.println(br.nextLine());
				}
			}
			// NANO_NOTEPAD
			else if (clist[0].equals("nano") || clist[0].equals("notepad")) {
				userHistory.add(command);
				pb = new ProcessBuilder("notepad.exe");
				proc = pb.start();
				Scanner br = new Scanner(proc.getInputStream());
				while (br.hasNextLine()) {
					System.out.println(br.nextLine());
				}
			}
			// GREP_FIND
			else if (clist[0].equals("find") || clist[0].equals("grep")) {
				userHistory.add(command);
				pb = new ProcessBuilder( "/c", "find", clist[1], clist[2]);
				proc = pb.start();
				Scanner br = new Scanner(proc.getInputStream());
				while (br.hasNextLine()) {
					System.out.println(br.nextLine());
				}
			}
			// UNAME_VER
			else if (clist[0].equals("uname") || clist[0].equals("ver")) {
				userHistory.add(command);
				pb = new ProcessBuilder("cmd", "/c", "ver");
				proc = pb.start();
				Scanner br = new Scanner(proc.getInputStream());
				while (br.hasNextLine()) {
					System.out.println(br.nextLine());
				}
			}
			// MKDIR
			else if (clist[0].equals("mkdir")) {
				userHistory.add(command);
				pb = new ProcessBuilder("cmd", "/c", "mkdir", clist[1]);
				proc = pb.start();
				Scanner br = new Scanner(proc.getInputStream());
				while (br.hasNextLine()) {
					System.out.println(br.nextLine());
				}
			}
			// ECHO PATH
			else if (clist[0].equals("echo $PATH") || clist[0].equals("path")) {
				userHistory.add(command);
				pb = new ProcessBuilder("cmd", "/c", "path");
				proc = pb.start();
				Scanner br = new Scanner(proc.getInputStream());
				while (br.hasNextLine()) {
					System.out.println(br.nextLine());
				}
			}
			// WHICH_WHERE
			else if (clist[0].equals("which") || clist[0].equals("where")) {
				userHistory.add(command);
				pb = new ProcessBuilder("cmd", "/c", "where", clist[1]);
				proc = pb.start();
				Scanner br = new Scanner(proc.getInputStream());
				while (br.hasNextLine()) {
					System.out.println(br.nextLine());
				}
			}
			// ENV_SET
			else if (clist[0].equals("env") || clist[0].equals("set")) {
				userHistory.add(command);
				pb = new ProcessBuilder("cmd", "/c", "set");
				proc = pb.start();
				Scanner br = new Scanner(proc.getInputStream());
				while (br.hasNextLine()) {
					System.out.println(br.nextLine());
				}
			}
			// WHOAMI
			else if (clist[0].equals("whoami")) {
				userHistory.add(command);
				pb = new ProcessBuilder("whoami.exe");
				proc = pb.start();
				Scanner br = new Scanner(proc.getInputStream());
				while (br.hasNextLine()) {
					System.out.println(br.nextLine());
				}
			}
			// IPCONFIG_IFCONFIG
			else if (clist[0].equals("ipconfig") || clist[0].equals("ifconfig")) {
				userHistory.add(command);
				pb = new ProcessBuilder("ipconfig.exe");
				proc = pb.start();
				Scanner br = new Scanner(proc.getInputStream());
				while (br.hasNextLine()) {
					System.out.println(br.nextLine());
				}
			}
			// History
			else if(clist[0].equals("history")) {
				for (String string : userHistory ) {
				    System.out.print(string+ " ");
				}
				//System.out.print(toString(userHistory));
			}

			// EXIT
			else if (clist[0].equals("exit")) {
				pb = new ProcessBuilder("exit.exe");
				proc = pb.start();
				Scanner br = new Scanner(proc.getInputStream());
				while (br.hasNextLine()) {
					System.out.println(br.nextLine());
				}
			} else {
				System.out.println("Invalid command");
			}
			
			System.out.println();
			System.out.print("bash>");
			command = console.nextLine();

			clist = command.split(" ");
		}
		

		// obtain the input and output streams
		/*
		 * Scanner br = new Scanner(proc.getInputStream()); while (br.hasNextLine()) {
		 * System.out.println(br.nextLine()); }
		 */

		// br.close();

		// end
		console.close();

	}
}