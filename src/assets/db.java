
package assets;

import java.sql.*;
import sims.Editing3Controller;
import sims.HomePageController;



public class db 
{
   
    public static void main(String[] args)
    {
        try
        {  
            Connection myConn = DriverManager.getConnection("jdbc:mysql://localhost:3306/studentinfoschema?autoReconnect=true&useSSL=false", "root", "root");
            //HomePageController.StatusBtn0.setVisible(true);
            Statement myStmt = myConn.createStatement();
            ResultSet myRs = myStmt.executeQuery("select * from basic_info");
            

            while(myRs.next())
            {
                String s = myRs.getString(2); //2 is the column number
                System.out.println(s); 
                System.out.println(myRs.getInt(1)); 
            }
        }
        catch(Exception e)
        {
            e.printStackTrace();
            //Editing3Controller.StatusBtn1.setVisible(true);
        }
    }
}


