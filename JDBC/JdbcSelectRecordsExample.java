import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
public class JdbcSelectRecordsExample {
 public static void main(String[] args) {
 Connection connection = null;
 Statement statement = null;
 ResultSet resultSet = null;
 try {
 // Step 1: Load the JDBC driver
 Class.forName("com.mysql.jdbc.Driver");
 // Step 2: Establish a connection to the MySQL server
 String url = "jdbc:mysql://localhost:3306/mydatabase";
 String username = "root";
 String password = "16bitz";
 connection = DriverManager.getConnection(url, username, password);
 // Step 3: Create a statement object
 statement = connection.createStatement();
 // Step 4: Execute the SQL query
 String sql = "SELECT * FROM employees";
 resultSet = statement.executeQuery(sql);
 // Step 5: Process the result set
 while (resultSet.next()) {
 int id = resultSet.getInt("id");
 String name = resultSet.getString("name");
 int age = resultSet.getInt("age");
 System.out.println("ID: " + id + ", Name: " + name + ", Age: " + age);
 }
 } catch (ClassNotFoundException e) {
 e.printStackTrace();
 } catch (SQLException e) {
 e.printStackTrace();
 } finally {
 // Step 6: Close the result set, statement, and connection
 try {
 if (resultSet != null) {
 resultSet.close();
 }
 if (statement != null) {
 statement.close();
 }
 if (connection != null) {
 connection.close();
 }
 } catch (SQLException e) {
 e.printStackTrace();
 }
 }
 }
}