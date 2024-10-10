// Purpose: test the clipboard

public class testClipboard {
    public static void main(String[] args) {
		//  a simple test on clipboard --- sharing resource 	
		ClipboardText board = new ClipboardText();
		for(int i=0; i<100000; i++){
			board.setText("Hello, Writing to Clipboard " + i + " times");
			//thread sleep for 1ms
			try{
				Thread.sleep(1);
			}catch(InterruptedException e){
				e.printStackTrace();
			}
		}
		
    }
}


