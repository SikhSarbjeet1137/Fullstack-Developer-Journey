
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

public class StudentDatabaseManagement {

    public static void main(String[] args) {

        String url = "jdbc:postgresql://localhost:5433/java_jdbc_db";
        String username = "postgres";
        String password = System.getenv("DB_PASSWORD");

        Scanner scanner = new Scanner(System.in);

        if (password == null || password.isBlank()) {
            System.out.println("Database password not configured!");
            scanner.close();
            return;
        }

        try (Connection connection =
                 DriverManager.getConnection(url, username, password)) {

            System.out.println("Database Connected Successfully!");

            int choice;

            do {

                System.out.println("\n===== STUDENT MANAGEMENT SYSTEM =====");
                System.out.println("1. Add Student");
                System.out.println("2. View All Students");
                System.out.println("3. Search Student");
                System.out.println("4. Update Student");
                System.out.println("5. Delete Student");
                System.out.println("6. Exit");

                System.out.print("Enter your choice: ");

                choice = scanner.nextInt();

                switch (choice) {

                    // INSERT STUDENT
                    case 1: {

                        scanner.nextLine();

                        System.out.print("Enter Student Name: ");
                        String name = scanner.nextLine();

                        System.out.print("Enter Student Email: ");
                        String email = scanner.nextLine();

                        System.out.print("Enter Student Age: ");
                        int age = scanner.nextInt();

                        String sql = """
                            INSERT INTO students (name, email, age)
                            VALUES (?, ?, ?)
                            """;

                        try (PreparedStatement statement =
                                 connection.prepareStatement(sql)) {

                            statement.setString(1, name);
                            statement.setString(2, email);
                            statement.setInt(3, age);

                            int rows = statement.executeUpdate();

                            System.out.println(rows + " Student Added Successfully!");
                        }

                        break;
                    }

                    // VIEW ALL STUDENTS
                    case 2: {

                        String sql = "SELECT * FROM students ORDER BY id";

                        try (PreparedStatement statement =
                                 connection.prepareStatement(sql);
                             ResultSet result = statement.executeQuery()) {

                            boolean found = false;

                            while (result.next()) {

                                found = true;

                                System.out.println("\nStudent ID: " + result.getInt("id"));
                                System.out.println("Name: " + result.getString("name"));
                                System.out.println("Email: " + result.getString("email"));
                                System.out.println("Age: " + result.getInt("age"));
                                System.out.println("-------------------------");
                            }

                            if (!found) {
                                System.out.println("No Students Found!");
                            }
                        }

                        break;
                    }

                    // SEARCH STUDENT
                    case 3: {

                        System.out.print("Enter Student ID: ");
                        int id = scanner.nextInt();

                        String sql = "SELECT * FROM students WHERE id = ?";

                        try (PreparedStatement statement =
                                 connection.prepareStatement(sql)) {

                            statement.setInt(1, id);

                            try (ResultSet result = statement.executeQuery()) {

                                if (result.next()) {

                                    System.out.println("\nStudent Found!");
                                    System.out.println("ID: " + result.getInt("id"));
                                    System.out.println("Name: " + result.getString("name"));
                                    System.out.println("Email: " + result.getString("email"));
                                    System.out.println("Age: " + result.getInt("age"));

                                } else {
                                    System.out.println("Student ID Not Found!");
                                }
                            }
                        }

                        break;
                    }

                    // UPDATE STUDENT
                    case 4: {

                        System.out.print("Enter Student ID: ");
                        int id = scanner.nextInt();

                        scanner.nextLine();

                        System.out.print("Enter New Student Name: ");
                        String name = scanner.nextLine();

                        System.out.print("Enter New Student Email: ");
                        String email = scanner.nextLine();

                        System.out.print("Enter New Student Age: ");
                        int age = scanner.nextInt();

                        String sql = """
                            UPDATE students
                            SET name = ?, email = ?, age = ?
                            WHERE id = ?
                            """;

                        try (PreparedStatement statement =
                                 connection.prepareStatement(sql)) {

                            statement.setString(1, name);
                            statement.setString(2, email);
                            statement.setInt(3, age);
                            statement.setInt(4, id);

                            int rows = statement.executeUpdate();

                            if (rows > 0) {
                                System.out.println("Student Updated Successfully!");
                            } else {
                                System.out.println("Student ID Not Found!");
                            }
                        }

                        break;
                    }

                    // DELETE STUDENT
                    case 5: {

                        System.out.print("Enter Student ID to Delete: ");
                        int id = scanner.nextInt();

                        String sql = "DELETE FROM students WHERE id = ?";

                        try (PreparedStatement statement =
                                 connection.prepareStatement(sql)) {

                            statement.setInt(1, id);

                            int rows = statement.executeUpdate();

                            if (rows > 0) {
                                System.out.println("Student Deleted Successfully!");
                            } else {
                                System.out.println("Student ID Not Found!");
                            }
                        }

                        break;
                    }

                    // EXIT
                    case 6:

                        System.out.println(
                            "Thank you for using Student Management System!"
                        );

                        break;

                    default:

                        System.out.println("Invalid Choice! Try Again.");
                }

            } while (choice != 6);

        } catch (SQLException e) {

            System.out.println("Database Operation Failed!");
            e.printStackTrace();

        } finally {

            scanner.close();
        }
    }
}
