class MyThread extends Thread {

    public void run() {
        for (int i = 1; i <= 5; i++) {
            System.out.println( i);

            try{
                Thread.sleep(2000);
            }
            catch(InterruptedException e){
                e.printStackTrace();
            }
        }
    }
}

public class ThreadOperations {

    public static void main(String[] args) {

        MyThread t1 = new MyThread();
        MyThread t2 = new MyThread();

        Thread t = new Thread(t1);
        t2.start();
        /*
        When multiple threads are not executing at a same time, and are followed one after another in a synchornized manner, then it is called Synchronization.
        After executing the thread then another thread is going to execute.
        For synchronization we have to make use of synchronized method.
        */
        t.start();
    }
}