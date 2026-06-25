
class thread extends Thread{
    counter c;
    thread(counter c){
        this.c = c;
    }
    public void run(){
        for(int i =1;i<=1000;i++){
            c.increment();
        }
    }
}
public class power {
    public static void main(String[] args) {
        counter c = new counter();
        thread t1 = new thread(c);
        thread t2 = new thread(c);
        t1.start();
        t2.start();
        try{
            t1.join();
            t2.join();
        }
        catch(InterruptedException e){
            e.printStackTrace();
        }
        System.out.println(c.count);
    }
}
