
package dao;

import model.Student;
import util.DBConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class StudentDAO {

    // 1. Add Student
    public boolean addStudent(Student student) throws SQLException {

        String sql = "INSERT INTO students (name, email, age) VALUES (?, ?, ?)";

        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, student.getName());
            ps.setString(2, student.getEmail());
            ps.setInt(3, student.getAge());

            int rowsAffected = ps.executeUpdate();

            return rowsAffected > 0;
        }
    }

    // 2. View All Students
    public List<Student> getAllStudents() throws SQLException {

        List<Student> students = new ArrayList<>();

        String sql = "SELECT * FROM students ORDER BY id";

        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {

                Student student = new Student(
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getString("email"),
                        rs.getInt("age")
                );

                students.add(student);
            }
        }

        return students;
    }

    // 3. Search Student By ID
    public Student searchStudentById(int id) throws SQLException {

        String sql = "SELECT * FROM students WHERE id = ?";

        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, id);

            try (ResultSet rs = ps.executeQuery()) {

                if (rs.next()) {

                    return new Student(
                            rs.getInt("id"),
                            rs.getString("name"),
                            rs.getString("email"),
                            rs.getInt("age")
                    );
                }
            }
        }

        return null;
    }

    // 4. Update Student
    public boolean updateStudent(Student student) throws SQLException {

        String sql = """
                UPDATE students
                SET name = ?, email = ?, age = ?
                WHERE id = ?
                """;

        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, student.getName());
            ps.setString(2, student.getEmail());
            ps.setInt(3, student.getAge());
            ps.setInt(4, student.getId());

            int rowsAffected = ps.executeUpdate();

            return rowsAffected > 0;
        }
    }

    // 5. Delete Student
    public boolean deleteStudent(int id) throws SQLException {

        String sql = "DELETE FROM students WHERE id = ?";

        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, id);

            int rowsAffected = ps.executeUpdate();

            return rowsAffected > 0;
        }
    }
}
