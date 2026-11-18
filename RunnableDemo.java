class MyRunnable implements Runnable {

    @Override
    public void run() {

        System.out.println("Runnable task is running!");

        System.out.println(
            "Thread: " + Thread.currentThread().getName()
        );
    }
}

public class RunnableDemo {

    public static void main(String[] args) {

        MyRunnable task = new MyRunnable();

        Thread t1 = new Thread(task);

        t1.start();

        System.out.println("Main thread is running!");
    }
}