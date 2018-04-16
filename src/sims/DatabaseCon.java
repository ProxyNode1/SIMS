
package sims;

import java.sql.*;

public class DatabaseCon 
{   
    public static int check;
    
    public static Connection connect()
    {   
        try
        {
            String urlMySql = "jdbc:mysql://localhost/mysql?autoReconnect=true&useSSL=false";
            String username = "root";
            String password = "root";
            
            Class.forName("com.mysql.jdbc.Driver");
            
            // create a connection to the database
            Connection myConn = DriverManager.getConnection(urlMySql, username, password);
            check = 1;
            System.out.println("ok");
                        
            return myConn;
            
        }
        catch(Exception e)
        {
            e.printStackTrace();
            //HomePageController.StatusBtn0.setText("*Warning, Database Missing!");
            //Editing1Controller.StatusBtn1.setText("*Warning, Database Missing!");
            
            return null;
        }
    }    
}
   


