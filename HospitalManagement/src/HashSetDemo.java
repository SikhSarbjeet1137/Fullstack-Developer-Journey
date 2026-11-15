
import java.util.HashSet;

public class HashSetDemo {

    public static void main(String[] args) {

        HashSet<String> students = new HashSet<>();

        students.add("Abhi");
        students.add("Rahul");
        students.add("Krishna");
        students.add("Abhi");

        // Check before removal
        System.out.println("Rahul Exists: "
                + students.contains("Rahul"));

        // Remove Rahul
        students.remove("Rahul");

        // Check after removal
        System.out.println("Rahul Exists After Removal: "
                + students.contains("Rahul"));

        // Display final HashSet
        System.out.println("Students: " + students);

        System.out.println("Total: " + students.size());
    }
}
