
import dao.StudentDAO;
import model.Student;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

public class StudentDatabaseManagement {

    private static final Scanner sc = new Scanner(System.in);
    private static final StudentDAO studentDAO = new StudentDAO();

    public static void main(String[] args) {

        int choice=0;

        do {
            System.out.println("\n===== STUDENT MANAGEMENT SYSTEM =====");
            System.out.println("1. Add Student");
            System.out.println("2. View All Students");
            System.out.println("3. Search Student By ID");
            System.out.println("4. Update Student");
            System.out.println("5. Delete Student");
            System.out.println("6. Exit");

            System.out.print("Enter your choice: ");

            if (!sc.hasNextInt()) {
                System.out.println("Please enter a valid number!");
                sc.nextLine();
                continue;
            }

            choice = sc.nextInt();

            try {
                switch (choice) {

                    case 1:
                        addStudent();
                        break;

                    case 2:
                        viewAllStudents();
                        break;

                    case 3:
                        searchStudent();
                        break;

                    case 4:
                        updateStudent();
                        break;

                    case 5:
                        deleteStudent();
                        break;

                    case 6:
                        System.out.println("Application closed.");
                        break;

                    default:
                        System.out.println("Invalid choice!");
                }

            } catch (SQLException e) {
                System.out.println("Database Error: " + e.getMessage());
            }

        } while (choice != 6);

        sc.close();
    }

    // 1. Add Student
    private static void addStudent() throws SQLException {

        sc.nextLine();

        System.out.print("Enter Student Name: ");
        String name = sc.nextLine();

        System.out.print("Enter Student Email: ");
        String email = sc.nextLine();

        System.out.print("Enter Student Age: ");
        int age = sc.nextInt();

        Student student = new Student(0, name, email, age);

        boolean result = studentDAO.addStudent(student);

        if (result) {
            System.out.println("Student added successfully!");
        } else {
            System.out.println("Student could not be added.");
        }
    }

    // 2. View All Students
    private static void viewAllStudents() throws SQLException {

        List<Student> students = studentDAO.getAllStudents();

        if (students.isEmpty()) {
            System.out.println("No students found!");
            return;
        }

        System.out.println("\n========== STUDENT RECORDS ==========");

        System.out.printf("%-10s %-20s %-30s %-10s%n",
                "ID", "NAME", "EMAIL", "AGE");

        System.out.println("----------------------------------------------------------------");

        for (Student student : students) {

            System.out.printf("%-10d %-20s %-30s %-10d%n",
                    student.getId(),
                    student.getName(),
                    student.getEmail(),
                    student.getAge());
        }
    }

    // 3. Search Student By ID
    private static void searchStudent() throws SQLException {

        System.out.print("Enter Student ID: ");
        int id = sc.nextInt();

        Student student = studentDAO.searchStudentById(id);

        if (student != null) {

            System.out.println("\nStudent Found!");
            System.out.println("ID    : " + student.getId());
            System.out.println("Name  : " + student.getName());
            System.out.println("Email : " + student.getEmail());
            System.out.println("Age   : " + student.getAge());

        } else {
            System.out.println("Student not found!");
        }
    }

    // 4. Update Student
    private static void updateStudent() throws SQLException {

        System.out.print("Enter Student ID to update: ");
        int id = sc.nextInt();

        Student existingStudent = studentDAO.searchStudentById(id);

        if (existingStudent == null) {
            System.out.println("Student not found!");
            return;
        }

        sc.nextLine();

        System.out.print("Enter New Name: ");
        String name = sc.nextLine();

        System.out.print("Enter New Email: ");
        String email = sc.nextLine();

        System.out.print("Enter New Age: ");
        int age = sc.nextInt();

        Student student = new Student(id, name, email, age);

        boolean result = studentDAO.updateStudent(student);

        if (result) {
            System.out.println("Student updated successfully!");
        } else {
            System.out.println("Student update failed!");
        }
    }

    // 5. Delete Student
    private static void deleteStudent() throws SQLException {

        System.out.print("Enter Student ID to delete: ");
        int id = sc.nextInt();

        Student existingStudent = studentDAO.searchStudentById(id);

        if (existingStudent == null) {
            System.out.println("Student not found!");
            return;
        }

        System.out.println("Student Name: " + existingStudent.getName());

        System.out.print("Are you sure you want to delete? (1 = Yes, 0 = No): ");
        int confirm = sc.nextInt();

        if (confirm == 1) {

            boolean result = studentDAO.deleteStudent(id);

            if (result) {
                System.out.println("Student deleted successfully!");
            } else {
                System.out.println("Student deletion failed!");
            }

        } else {
            System.out.println("Delete operation cancelled.");
        }
    }
}
