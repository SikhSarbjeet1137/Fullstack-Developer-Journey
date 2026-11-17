
import java.util.*;
import java.util.stream.Collectors;

public class StudentSteamDemo {

    public static void main(String[] args) {

        List<Student> students = new ArrayList<>();

        students.add(new Student("Abhi", 85));
        students.add(new Student("Rahul", 45));
        students.add(new Student("Raj", 92));
        students.add(new Student("Amit", 35));
        students.add(new Student("Jay", 75));

        // Filter students with marks >= 60
        List<Student> passedStudents = students.stream()
                .filter(student -> student.getMarks() >= 60)
                .collect(Collectors.toList());

        System.out.println("Passed Students:");

        passedStudents.forEach(student ->
                System.out.println(
                    student.getName() + " - " + student.getMarks()
                )
        );

        // Extract only student names
        List<String> studentNames = students.stream()
                .filter(student -> student.getMarks() >= 60)
                .map(Student::getName)
                .collect(Collectors.toList());

        System.out.println("\nPassed Student Names: " + studentNames);
    }
}
