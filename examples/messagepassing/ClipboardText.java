/**
 * @(#)ClipboardText.java
 *
 *
 * @author 
 * @version 1.00 2009/2/2
 */
import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.*;
import java.io.IOException;

public class ClipboardText {
        
    /**
     * Get the system clipboard
     */
    public static String getText()  {
    	// get the system clipboard
		Clipboard systemClipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
		
		// get the content of the clipboard
		Transferable contentsClip = systemClipboard.getContents(null);
		
		// empty or not
		String contentsText = "";
		if (contentsClip ==null) 
			contentsText = "Empty" ;
		else
			try {
				contentsText = (String)contentsClip.getTransferData(DataFlavor.stringFlavor);
			}
			catch (Exception e){}
			
		return contentsText;	
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        System.out.println("Get Text From Clipboard   ");
		String textClipboard = getText();
		System.out.println(textClipboard);
        
        
    }
}
