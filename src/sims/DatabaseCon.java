
package sims;

import java.sql.*;

public class DatabaseCon 
{
    public static void connect()
    {
        try
        {
        Connection mycon = DriverManager.getConnection("jdbc:mysql://locathost3306/studentinfoschema", "root", "root");
        }
        catch(Exception e)
        {
            HomePageController hp = new HomePageController();
            hp.getStatusBtn().setVisible(true);
            
            Editing3Controller e3 = new Editing3Controller();
            e3.getStatusBtn().setVisible(true);
        }
    }
}


