class WorkerThread extends Thread {

    @Override
    public void run() {

        for (int i = 1; i <= 3; i++) {
            System.out.println("Worker: " + i);
        }
    }
}

public class JoinDemo {

    public static void main(String[] args)
            throws InterruptedException {

        WorkerThread worker = new WorkerThread();

        worker.start();

        worker.join();

        System.out.println("Main thread completed!");
    }
}