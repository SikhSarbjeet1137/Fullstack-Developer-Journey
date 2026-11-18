class MyTask extends Thread{
    public void run(){
            System.out.print("Running:- "+Thread.currentThread().getName());
    }
}

public class StartVsRun{
    public static void main(String[] args){
        MyTask t1=new MyTask();
        System.out.println("The run Word example");
        t1.run();
        MyTask t2=new MyTask();
        System.out.println("The Start word example");
        t2.start();
    }
}