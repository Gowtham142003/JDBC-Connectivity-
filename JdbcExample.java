import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JdbcExample {
    public static void main(String[] args) {
        // Database URL, username, and password
        String url = "jdbc:mysql://localhost:3306/yourDatabaseName"; // Update with your database name
        String user = "yourUsername"; // Update with your username
        String password = "yourPassword"; // Update with your password

        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;

        try {
            // Establishing the connection
            connection = DriverManager.getConnection(url, user, password);
            System.out.println("Connected to the database!");

            // Creating a statement
            statement = connection.createStatement();

            // Executing a query
            String query = "SELECT * FROM yourTableName"; // Update with your table name
            resultSet = statement.executeQuery(query);

            // Processing the result set
            while (resultSet.next()) {
                int id = resultSet.getInt("id"); // Update with your column name
                String name = resultSet.getString("name"); // Update with your column name
                System.out.println("ID: " + id + ", Name: " + name);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            // Closing resources
            try {
                if (resultSet != null) resultSet.close();
                if (statement != null) statement.close();
                if (connection != null) connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
