
package dao;

import model.Student;
import java.sql.SQLException;
import java.util.List;

public interface StudentDAO {

    boolean addStudent(Student student) throws SQLException;

    List<Student> getAllStudents() throws SQLException;

    Student searchStudentById(int id) throws SQLException;

    boolean updateStudent(Student student) throws SQLException;

    boolean deleteStudent(int id) throws SQLException;
}
