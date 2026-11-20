
package service;

import exception.StudentNotFoundException;
import exception.DuplicateStudentException;

import dao.StudentDAO;
import model.Student;

import java.sql.SQLException;
import java.util.List;

public class StudentService {

    private final StudentDAO studentDAO;

    // Constructor Dependency Injection
    public StudentService(StudentDAO studentDAO) {
        this.studentDAO = studentDAO;
    }

    // Common Student Validation
    private void validateStudent(Student student) {

        if (student == null) {
            throw new IllegalArgumentException(
                "Student cannot be null"
            );
        }

        if (student.getName() == null ||
            student.getName().isBlank()) {

            throw new IllegalArgumentException(
                "Student name cannot be empty"
            );
        }

        if (student.getEmail() == null ||
            !student.getEmail().contains("@")) {

            throw new IllegalArgumentException(
                "Invalid email address"
            );
        }

        if (student.getAge() <= 0) {

            throw new IllegalArgumentException(
                "Age must be greater than zero"
            );
        }
    }

    // 1. Add Student
    public boolean addStudent(Student student) throws SQLException {

        validateStudent(student);

        try {
            return studentDAO.addStudent(student);

        } catch (SQLException e) {

            if ("23505".equals(e.getSQLState())) {
                throw new DuplicateStudentException(
                    "A student with this email already exists."
                );
            }

            throw e;
        }
    }

    // 2. Get All Students
    public List<Student> getAllStudents() throws SQLException {

        return studentDAO.getAllStudents();
    }

    // 3. Search Student By ID
    public Student searchStudentById(int id) throws SQLException {

        if (id <= 0) {
            throw new IllegalArgumentException(
                "Student ID must be greater than zero"
            );
        }

        Student student = studentDAO.searchStudentById(id);

        if (student == null) {
            throw new StudentNotFoundException(
                "Student not found with ID: " + id
            );
        }

        return student;
    }

    // 4. Update Student
    public boolean updateStudent(Student student) throws SQLException {

        if (student == null || student.getId() <= 0) {
            throw new IllegalArgumentException(
                "Invalid Student ID"
            );
        }

        validateStudent(student);

        Student existingStudent =
                studentDAO.searchStudentById(student.getId());

        if (existingStudent == null) {
            throw new StudentNotFoundException(
                "Student not found with ID: " + student.getId()
            );
        }

        try {
            return studentDAO.updateStudent(student);

        } catch (SQLException e) {

            if ("23505".equals(e.getSQLState())) {
                throw new DuplicateStudentException(
                    "A student with this email already exists."
                );
            }

            throw e;
        }
    }

    // 5. Delete Student
    public boolean deleteStudent(int id) throws SQLException {

        if (id <= 0) {
            throw new IllegalArgumentException(
                "Student ID must be greater than zero"
            );
        }

        Student existingStudent =
                studentDAO.searchStudentById(id);

        if (existingStudent == null) {
            throw new StudentNotFoundException(
                "Student not found with ID: " + id
            );
        }

        return studentDAO.deleteStudent(id);
    }
}
