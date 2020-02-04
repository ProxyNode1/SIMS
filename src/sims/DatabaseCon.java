package sims;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseCon 
{   

    public static Connection connect()
    {   
        try
        {
            Class.forName("com.mysql.jdbc.Driver");
            
            
            String username = "root";
            String password = "root";
            String url = "jdbc:mysql://localhost/mysql?autoReconnect=true&useSSL=false";
            
            // create a connection to the database
            Connection myConn = DriverManager.getConnection(url, username, password);
                              
            System.out.println("Db Connected");
                        
            return myConn;
            
        }
        catch(SQLException | ClassNotFoundException e)
        {
            System.err.println(e.getMessage());
         
            return null;
        }
    }    
}