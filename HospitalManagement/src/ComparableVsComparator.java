
import java.util.*;

class Student implements Comparable<Student> {

    int marks;
    String name;

    Student(String name, int marks) {
        this.name = name;
        this.marks = marks;
    }

    // Natural ordering: marks ascending
    @Override
    public int compareTo(Student other) {
        return Integer.compare(this.marks, other.marks);
    }
}

public class ComparableVsComparator {

    public static void main(String[] args) {

        List<Student> students = new ArrayList<>();

        students.add(new Student("Abhi", 85));
        students.add(new Student("Rahul", 70));
        students.add(new Student("Raj", 95));

        // Comparable: sort by marks
        Collections.sort(students);

        System.out.println("Sorted by Marks:");

        for (Student student : students) {
            System.out.println(student.name + " - " + student.marks);
        }

        // Comparator: sort by name
        students.sort(
            (s1, s2) -> s1.name.compareTo(s2.name)
        );

        System.out.println("\nSorted by Name:");

        for (Student student : students) {
            System.out.println(student.name + " - " + student.marks);
        }
    }
}
