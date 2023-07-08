import java.sql.*;


public class JdbcCreateTableExample{
    public static void main(String[] args){
        Connection connection = null;
        Statement statement = null;

        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            String url ="jdbc:mysql://localhost:3306/mydatabase";
            String username = "root";
            String password = "16bitz";
            connection = DriverManager.getConnection(url,username,password);
            statement = connection.createStatement();
            String sql = "CREATE TABLE employees("
            +"id INT AUTO_INCREMENT PRIMARY KEY,"
            +"name VARCHAR(100) NOT NULL,"
            +"age INT,"
            +"salary DECIMAL(10,2)"
            +")";
            statement.executeUpdate(sql);
            System.out.println("Table 'employees' created!" );
        }
        catch(ClassNotFoundException e){
            e.printStackTrace();
        }catch(SQLException e){
            e.printStackTrace();
        }
        finally{
            try{
                if(statement != null){
                    statement.close();
                }
                else if(connection != null){
                    connection.close();
                }
                }catch(SQLException e){
                    e.printStackTrace();
                }
            
        }
    }

}