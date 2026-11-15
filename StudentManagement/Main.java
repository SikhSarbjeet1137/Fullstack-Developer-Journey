
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {

        // Create ArrayList
        ArrayList<Student> students = new ArrayList<>();

        // Add 3 Students
        students.add(new Student(101, "Rahul", 85));
        students.add(new Student(102, "Aman", 90));
        students.add(new Student(103, "Karan", 75));

        // Display All Students
        System.out.println("----- All Students -----");

        for (Student s : students) {
            System.out.println(
                "ID: " + s.getId() +
                ", Name: " + s.getName() +
                ", Marks: " + s.getMarks()
            );
        }

        // Search Student By ID
        int searchId = 102;
        boolean found = false;

        System.out.println("\n----- Search Student -----");

        for (Student s : students) {
            if (s.getId() == searchId) {
                System.out.println("Student found: " + s.getName());
                found = true;
                break;
            }
        }

        if (!found) {
            System.out.println("Student not found!");
        }

        // Remove Student By ID
        int removeId = 103;
        boolean removed = false;

        System.out.println("\n----- Remove Student -----");

        for (int i = 0; i < students.size(); i++) {

            if (students.get(i).getId() == removeId) {
                students.remove(i);
                removed = true;
                System.out.println("Student with ID " + removeId + " removed.");
                break;
            }
        }

        if (!removed) {
            System.out.println("Student not found!");
        }

        // Calculate Average Marks
        double total = 0;

        for (Student s : students) {
            total += s.getMarks();
        }

        double average = 0;

        if (!students.isEmpty()) {
            average = total / students.size();
        }

        System.out.println("\n----- Average Marks -----");
        System.out.println("Average Marks: " + average);
    }
}
