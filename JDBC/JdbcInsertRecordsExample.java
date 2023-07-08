import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
public class JdbcInsertRecordsExample {
 public static void main(String[] args) {
 Connection connection = null;
 PreparedStatement preparedStatement = null;
 try {
 // Step 1: Load the JDBC driver
 Class.forName("com.mysql.cj.jdbc.Driver");
 // Step 2: Establish a connection to the MySQL server
 String url = "jdbc:mysql://localhost:3306/mydatabase";
 String username = "root";
 String password = "16bitz";
 connection = DriverManager.getConnection(url, username, password);
 // Step 3: Prepare the SQL statement for insertion
 String sql = "INSERT INTO employees (id, name, age) VALUES (?, ?, ?)";
 preparedStatement = connection.prepareStatement(sql);

 // Step 4: Set the parameter values for the SQL statement
 preparedStatement.setInt(1, 1);
 preparedStatement.setString(2, "John Doe");
 preparedStatement.setInt(3, 30);
 // Step 5: Execute the SQL statement to insert the record
 int rowsAffected = preparedStatement.executeUpdate();
 // Step 6: Check the number of rows affected
 if (rowsAffected > 0) {
 System.out.println("Record inserted successfully!");
 } else {
 System.out.println("Failed to insert record!");
 }
 } catch (ClassNotFoundException e) {
 e.printStackTrace();
 } catch (SQLException e) {
 e.printStackTrace();
 } finally {
 // Step 7: Close the prepared statement and connection
 try {
 if (preparedStatement != null) {
 preparedStatement.close();
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