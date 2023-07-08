
import java.sql.*;

public class SelectDb {
    public static void main(String args[]){
        Connection connection = null;
       
    try{
        Class.forName("com.mysql.cj.jdbc.Driver");
        String url = "jdbc:mysql://localhost:3306/mydatabase";
        String username = "root";
        String password = "16bitz";
        connection = DriverManager.getConnection(url, username, password);
        System.out.println("Select database mydatabase");

    }
    catch(ClassNotFoundException | SQLException e){
        e.printStackTrace();
    }
    finally{
        try{
            if(connection != null){
                connection.close();
            }
        }catch(SQLException e){
            e.printStackTrace();
        }
    }    
    }
}
