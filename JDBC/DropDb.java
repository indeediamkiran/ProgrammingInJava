
import java.sql.*;

public class DropDb {
    public static void main(String args[]){
        Connection connection = null;
        Statement statement = null;
try{
    Class.forName("com.mysql.cj.jdbc.Driver");
    String url = "jdbc:mysql://localhost:3306/";
    String username = "root";
    String password = "16bitz";
    connection = DriverManager.getConnection(url, username, password);
    String databaseName = "mydatabase";
    statement = connection.createStatement();
    String dropDatabaseQuery = "DROP DATABASE "+ databaseName;
    statement.executeUpdate(dropDatabaseQuery);
    System.out.println("Database Deleted");

}
catch(SQLException | ClassNotFoundException e){
    e.printStackTrace();
}
finally{
    try{
        if(connection  != null){
            connection.close();
        }
        if(statement != null){
            statement.close();
        }
    }catch(SQLException e){
        e.printStackTrace();
    }
}
    }
    
}
