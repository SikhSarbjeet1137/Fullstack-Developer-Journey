import java.util.LinkedList;
import java.util.Queue;

public class QueueDemo {

    public static void main(String[] args) {

        Queue<String> patients = new LinkedList<>();

        // Add patients
        patients.add("Abhi");
        patients.add("Rahul");
        patients.add("Krishna");

        System.out.println("Patient Queue: " + patients);

        // First patient
        System.out.println("Next Patient: " + patients.peek());

        // Serve first patient
        System.out.println("Serving: " + patients.poll());

        // Updated queue
        System.out.println("Remaining Patients: " + patients);
    }
}