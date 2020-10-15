/**
 * @(#)ClipboardText.java
 *
 *
 * @author 
 * @version 
 */
import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.Transferable;
import java.awt.datatransfer.StringSelection;
import java.awt.datatransfer.*;
import java.io.IOException;

public class ClipboardText  {
        
    /**
     * Get the system clipboard
     */
    public String getText()  {
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
     ** Set content to system clipborad
     *
     */
     public  void setText(String s){
     	// get the system clipboard
		Clipboard systemClipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
		
		// set the content of clipboard
		try{
			StringSelection content = new StringSelection( s );
			systemClipboard.setContents((Transferable)content,null);
		}
		catch (Exception e){}
 	
     }
}
