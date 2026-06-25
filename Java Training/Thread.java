import java.util.*;
class Thread1{
    void demo(){
        System.out.println("Hello");
    }
    void task(){
        System.out.println("Process!");
    }
}
class Thread2 extends Thread1{
    void task() {
        for (int i =0;i<5;i++){
            System.out.println("Task!");
        }
        
    }
}
public class Thread{
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        Thread1 t1 = new Thread1();
        t1.demo();

        t1.task();
        System.out.println("Thread2 Implementation!");
        Thread2 t2 = new Thread2();
        t2.demo();

        t2.task();

        /*
        Process is a complete program that is currently running on the OS.

        Thread is a smaller unit present inside the process.

        Process is having its own seperate memory but thread is sharing the memory between itself.

        Multi-Threading, is used when we want to execute multiple threads simultaneously inside a process,we are making use of the concept called Multi-Threading.
        
        When CPU is executing multiple tasks at a time ,it is called as multi-tasking.
    
        Thread based multitasking & Process based multitasking.

        Type 1:
        Process based multitasking
        In this type CPU is executing multiple independent processes or applications at a time.
        Here all the processes having its own specific memory.
        ex: Opening chrome, notepad at a time.

        Type 2:
        Thread Based Multi-tasking, when CPU is executing multiple threads at a time, it is known as Thread based multi-tasking.
        Here all the threads are sharing resources and memory.


        */
        
        scanner.close();

    }
}