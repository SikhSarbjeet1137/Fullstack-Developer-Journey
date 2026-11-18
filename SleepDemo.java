public class SleepDemo {

    public static void main(String[] args) {

        for (int i = 1; i <= 5; i++) {

            System.out.println("Count: " + i);

            try {
                Thread.sleep(1000);
            } 
            catch (InterruptedException e) {
                System.out.println("Thread interrupted!");
                Thread.currentThread().interrupt();
                break;
            }
        }

        System.out.println("Task completed!");
    }
}