import java.io.FileWriter;
import java.io.IOException;

public class FileWriteDemo {

    public static void main(String[] args) {

        try {

            FileWriter writer = new FileWriter("student.txt");

            writer.write("Student Name: Abhi\n");
            writer.write("Course: Integrated MCA\n");
            writer.write("Semester: 7\n");
            writer.write("Language: Java");

            writer.close();

            System.out.println("Data written successfully!");

        } catch (IOException e) {

            System.out.println("An error occurred!");
            e.printStackTrace();

        }
    }
}