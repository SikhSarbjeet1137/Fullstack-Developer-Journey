import java.util.Stack;

public class StackDemo {

    public static void main(String[] args) {

        Stack<String> medicalFiles = new Stack<>();

        // Push files
        medicalFiles.push("File A");
        medicalFiles.push("File B");
        medicalFiles.push("File C");

        System.out.println("Medical Files: " + medicalFiles);

        // View top file
        System.out.println("Top File: " + medicalFiles.peek());

        // Remove top file
        System.out.println("Removed File: " + medicalFiles.pop());

        // Remaining files
        System.out.println("Remaining Files: " + medicalFiles);
    }
}