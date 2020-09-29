
public class anyThread extends Thread{
    int num =0;

    public anyThread(int a){
        num = a;
    }

    public void run(){
        System.out.println("any thread is running ! ");
    }
    
}
