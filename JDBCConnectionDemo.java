
import java.sql.PreparedStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JDBCConnectionDemo {

    public static void main(String[] args) {

        String url = "jdbc:postgresql://localhost:5433/java_jdbc_db";
        String username = "postgres";
        String password = System.getenv("DB_PASSWORD");

        String sql = "DELETE FROM students WHERE id = ?";

        try (Connection connection =
                 DriverManager.getConnection(url, username, password)) {

            System.out.println("Database Connected Successfully!");

            try (PreparedStatement statement =
                     connection.prepareStatement(sql)) {

                statement.setInt(1, 1);

                int rows = statement.executeUpdate();

                System.out.println(rows + " student deleted successfully!");
            }

        } catch (SQLException e) {
            System.out.println("Database Operation Failed!");
            e.printStackTrace();
        }
    }
}
