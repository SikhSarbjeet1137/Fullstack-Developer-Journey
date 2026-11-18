import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class BufferedWriterDemo {

    public static void main(String[] args) {

        try (BufferedWriter writer =
                 new BufferedWriter(
                     new FileWriter("student.txt", true))) {

            writer.newLine();
            writer.write("Department: Computer Science");

            writer.newLine();
            writer.write("Programming Language: Java");

            System.out.println("Data written successfully!");

        } catch (IOException e) {
            System.out.println("Error writing file!");
            e.printStackTrace();
        }
    }
} 