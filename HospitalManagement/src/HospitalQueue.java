import java.util.LinkedList;
import java.util.Queue;

public class HospitalQueue {

    public static void main(String[] args) {

        Queue<String> patients = new LinkedList<>();
        
        patients.add("Abhi");
        patients.add("Rahul");
        patients.add("Krishna");
        patients.add("Vishwam");


        System.out.println("Patient Queue: " + patients);

        System.out.println("Next Patient: " + patients.peek());

        System.out.println("Serving: " + patients.poll());

        System.out.println("Remaining Patients: " + patients);

patients.add("Sarbjeet");

System.out.println("Updated Queue: " + patients);

System.out.println("Total Waiting Patients: " + patients.size());

        }}