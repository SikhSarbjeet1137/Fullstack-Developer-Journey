import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class StudentFileManager {

    public static void main(String[] args) {

        // Save student records
        try (BufferedWriter writer =
                 new BufferedWriter(
                     new FileWriter("students.txt", true))) {

            writer.write("101,Abhi,Java");
            writer.newLine();

            writer.write("102,Rahul,Python");
            writer.newLine();

            writer.write("103,Raj,Spring Boot");
            writer.newLine();

            System.out.println("Student records saved!");

        } catch (IOException e) {
            System.out.println("Error saving records!");
        }

        // Read student records
        System.out.println("\n--- STUDENT RECORDS ---");

        try (BufferedReader reader =
                 new BufferedReader(
                     new FileReader("students.txt"))) {

            String line;

            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }

        } catch (IOException e) {
            System.out.println("Error reading records!");
        }
    }
}