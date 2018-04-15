
package sims;

import java.sql.*;

public class DatabaseCon 
{
    public static Connection connect()
    {
        try
        {
            Connection myConn = DriverManager.getConnection("jdbc:mysql://localhost:3306/studentinfoschema?autoReconnect=true&useSSL=false", "root", "root");
            System.out.println("ok");
            
            return myConn;
            
        }
        catch(Exception e)
        {
            e.printStackTrace();
            //HomePageController.StatusBtn0.setVisible(true);
            Editing3Controller.StatusBtn1.setVisible(true);
            
            return null;
        }
    }
}
   


