import java.io.FileWriter;
import java.io.IOException;

public class FileAppendDemo {

    public static void main(String[] args) {

        try (FileWriter writer =
                 new FileWriter("student.txt", true)) {

            writer.write("\nStatus: Active");
            writer.write("\nResult: Passed");

            System.out.println("Data appended successfully!");

        } catch (IOException e) {
            System.out.println("Error writing file!");
            e.printStackTrace();
        }
    }
}