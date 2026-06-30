class taketwo1 extends Thread{
     public void run(){
        System.out.println("Hello Task!");
        try{
            Thread.sleep(1000);
        }
        catch(InterruptedException e){
            e.printStackTrace();
        }
       
     }
}
public class taketwo{
    public static void main(String args[]){
        taketwo1 t1 = new taketwo1();
        // taketwo1 t2 = new taketwo1();

        Thread t = new Thread(t1);
        t.start();
        
    }
}
