package sims;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class DatabaseIO 
{
    Connection myConn = null;
    Statement stmt = null;
    PreparedStatement ps = null;
    ResultSet res = null;

    public DatabaseIO() 
    {
        myConn = DatabaseCon.connect();
        if(myConn != null){
            System.out.println("Database connection established!");
            createTables();
        }else{
            System.out.println("Connection could not be established!");
        }
    }
    
    public void createTables()
    {
        String cr8schema = "CREATE SCHEMA studentinfoschema;";
        
        String basicInfo =  "CREATE TABLE IF NOT EXISTS studentinfoschema.basic_info (" + 
                            "name VARCHAR(30) NOT NULL," +
                            "clgId VARCHAR(10) NOT NULL," +
                            "dept VARCHAR(5) NOT NULL," +
                            "cedu VARCHAR(2) NOT NULL," +
                            "csem INT(1) UNSIGNED NOT NULL," +
                            "contact VARCHAR(10) NOT NULL," +
                            "dob DATE NOT NULL," +
                            " PRIMARY KEY (name)," +
                            " UNIQUE INDEX clgId_UNIQUE (clgId ASC)," +
                            " UNIQUE INDEX contact_UNIQUE (contact ASC));" ;
        
        String sscInfo =    "CREATE TABLE IF NOT EXISTS studentinfoschema.ssc_info ("+
                            "name VARCHAR(30) NULL,"+
                            "SYop INT(4) UNSIGNED NOT NULL,"+
                            "SRn INT(10) UNSIGNED NOT NULL,"+
                            "SBoard VARCHAR(5) NOT NULL,"+
                            "SMedium VARCHAR(10) NOT NULL,"+
                            "SSch VARCHAR(30) NOT NULL,"+
                            "SCity VARCHAR(10) NOT NULL,"+
                            "SPtng INT(3) UNSIGNED NOT NULL,"+
                            " INDEX Sname_idx (name ASC),"+
                            " CONSTRAINT Sname"+
                            " FOREIGN KEY (name)"+
                            " REFERENCES studentinfoschema.basic_info (name) " +
                            " ON DELETE CASCADE " +
                            " ON UPDATE CASCADE);";
        
        String hsscInfo = "CREATE TABLE IF NOT EXISTS studentinfoschema.hssc_info (" +
                          "name VARCHAR(30) NULL," +
                          "HYop INT(4) UNSIGNED NULL," +
                          "HRn INT(10) UNSIGNED NULL," +
                          "HBoard VARCHAR(5) NULL," +
                          "HMedium VARCHAR(10) NULL," +
                          "HSch VARCHAR(30) NULL," +
                          "HCity VARCHAR(10) NULL," +
                          "HPtng INT(3) UNSIGNED NULL," +
                          "math INT(3) UNSIGNED NULL," +
                          "chemistry INT(3) UNSIGNED NULL," +
                          "physics INT(3) NULL," +
                          " INDEX Hname_idx (name ASC)," +
                          " CONSTRAINT Hname" +
                          " FOREIGN KEY (name)" +
                          " REFERENCES studentinfoschema.basic_info (name) " +
                          " ON DELETE CASCADE " +
                          " ON UPDATE CASCADE);";
        
        String dipInfo = "CREATE TABLE IF NOT EXISTS studentinfoschema.diploma_info (" +
                         "name VARCHAR(30) NULL," +
                         "DPtng1 INT(3) UNSIGNED NULL," +
                         "DPtng2 INT(3) UNSIGNED NULL," +
                         "DPtng3 INT(3) UNSIGNED NULL," +
                         "DPtng4 INT(3) UNSIGNED NULL," +
                         "DPtng5 INT(3) UNSIGNED NULL," +
                         "DPtng6 INT(3) UNSIGNED NULL," +
                         "INDEX Dname_idx (name ASC)," +
                         " CONSTRAINT Dname" +
                         " FOREIGN KEY (name)" +
                         " REFERENCES studentinfoschema.basic_info (name) " +
                         " ON DELETE CASCADE " +
                         " ON UPDATE CASCADE );";
        
        String uInfo = "CREATE TABLE IF NOT EXISTS studentinfoschema.ug_info (" +
                       "name VARCHAR(30) NULL," +
                       "EPtng1 INT(3) UNSIGNED NULL," +
                       "EPtng2 INT(3) UNSIGNED NULL," +
                       "EPtng3 INT(3) UNSIGNED NULL," +
                       "EPtng4 INT(3) UNSIGNED NULL," +
                       "EPtng5 INT(3) UNSIGNED NULL," +
                       "EPtng6 INT(3) UNSIGNED NULL," +
                       "EPtng7 INT(3) UNSIGNED NULL," +
                       "EPtng8 INT(3) UNSIGNED NULL," +
                       "INDEX Uname_idx (name ASC)," +
                       " CONSTRAINT Uname" +
                       " FOREIGN KEY (name)" +
                       " REFERENCES studentinfoschema.basic_info (name) " +
                       " ON DELETE CASCADE " +
                       " ON UPDATE CASCADE);";
        
        String pInfo = "CREATE TABLE IF NOT EXISTS studentinfoschema.pg_info (" +
                       "name VARCHAR(30) NULL," +
                       "PPtng1 INT(3) UNSIGNED NULL," +
                       "PPtng2 INT(3) UNSIGNED NULL," +
                       "PPtng3 INT(3) UNSIGNED NULL," +
                       "PPtng4 INT(3) UNSIGNED NULL," +
                       " INDEX Pname_idx (name ASC)," +
                       " CONSTRAINT Pname" +
                       " FOREIGN KEY (name)" +
                       " REFERENCES studentinfoschema.basic_info (name) " +
                       " ON DELETE CASCADE " +
                       " ON UPDATE CASCADE);";
        
        String oInfo = "CREATE TABLE IF NOT EXISTS studentinfoschema.other_info (" +
                       "name VARCHAR(30) NULL," +
                       "CEmail VARCHAR(50) NOT NULL," +
                       "PEmail VARCHAR(50) NULL," +
                       "FatherCntct VARCHAR(10) NOT NULL," +
                       "FamCntct VARCHAR(10) NULL," +
                       "Certification VARCHAR(5) NULL," +
                       "AddInfo TEXT NULL," +
                       "INDEX Oname_idx (name ASC)," +
                       "UNIQUE INDEX PEmail_UNIQUE (PEmail ASC)," +
                       "UNIQUE INDEX CEmail_UNIQUE (CEmail ASC)," +
                       " CONSTRAINT Oname" +
                       " FOREIGN KEY (name)" +
                       " REFERENCES studentinfoschema.basic_info (name) " +
                       " ON DELETE CASCADE " +
                       " ON UPDATE CASCADE);";
        
        try
        {
            stmt = myConn.createStatement();
            stmt.executeUpdate(cr8schema);
            
        }
        catch(Exception e)
        {
            System.out.println("schema already there!");
            
        }
        try{
            stmt = myConn.createStatement();
            stmt.executeUpdate(basicInfo);
            
        }
        catch(Exception e)
        {
            e.printStackTrace();
            
        }
        
        try{
            stmt = myConn.createStatement();
            stmt.executeUpdate(sscInfo);
            
        }
        catch(Exception e)
        {
            e.printStackTrace();
            
        }
        
        try{
            stmt = myConn.createStatement();
            stmt.executeUpdate(hsscInfo);
            
        }
        catch(Exception e)
        {
            e.printStackTrace();
            
        }
        
        try{
            stmt = myConn.createStatement();
            stmt.executeUpdate(dipInfo);
            
        }
        catch(Exception e)
        {
            e.printStackTrace();
            
        }
        
        try{
            stmt = myConn.createStatement();
            stmt.executeUpdate(uInfo);
            
        }
        catch(Exception e)
        {
            e.printStackTrace();
            
        }
        
        try{
            stmt = myConn.createStatement();
            stmt.executeUpdate(pInfo);
           
        }
        catch(Exception e)
        {
            e.printStackTrace();
            
        }
        
        try{
            stmt = myConn.createStatement();
            stmt.executeUpdate(oInfo);
            System.out.println("succ 7");
        }
        catch(Exception e)
        {
            e.printStackTrace();
            System.out.println("err 7");
        }
        
    }
    void setBasicinfo(String s1, String s2, String s3, String s4, int s5, String s6, String s7)
    {   String sql = "insert into studentinfoschema.basic_info VALUES("+ s1 + ","+ s2 +","+ s3 +","+ s4 +","+ s5 +","+ s6 +","+ s7 +");";
        try{
            ps = myConn.prepareCall(sql);
            ps.executeUpdate();
            ps = null;
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }
    
    void setSscinfo(String s1, int s2, int s3, String s4, String s5, String s6, String s7, int s8)
    {
        String sql = "insert into studentinfoschema.ssc_info VALUES("+ s1 + ","+ s2 +","+ s3 +","+ s4 +","+ s5 +","+ s6 +","+ s7 +","+ s8 +");";
        try{
            ps = myConn.prepareCall(sql);
            ps.executeUpdate();
            ps = null;
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }   
    }
    
    void setHsscinfo(String s1, int s2, int s3, String s4, String s5, String s6, String s7, int s8, int s11, int s10, int s9)
    {
        String sql = "insert into studentinfoschema.hssc_info VALUES("+ s1 + ","+ s2 +","+ s3 +","+ s4 +","+ s5 +","+ s6 +","+ s7 +","+ s8 +","+ s11 +","+ s10 +","+ s9 +");";
        try{
            ps = myConn.prepareCall(sql);
            ps.executeUpdate();
            ps = null;
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }   
    }
    
    void setDipinfo(String s1, int s2, int s3, int s4, int s5, int s6, int s7)
    {
        String sql = "insert into studentinfoschema.diploma_info VALUES("+ s1 +", "+ s2 +", "+ s3 +", "+ s4 +", "+ s5 +", "+ s6 +", "+ s7 +");";
        try{
            ps = myConn.prepareCall(sql);
            ps.executeUpdate();
            ps = null;
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }   
    }
    
    void setUginfo(String s1, int s2, int s3, int s4, int s5, int s6, int s7, int s8, int s9)
    {
        String sql = "insert into studentinfoschema.ug_info VALUES ("+ s1 + ", "+ s2 +", "+ s3 +", "+ s4 +", "+ s5 +", "+ s6 +", "+ s7 +", "+ s8 +", "+ s9 +" );";
        try{
            ps = myConn.prepareCall(sql);
            ps.executeUpdate();
            ps = null;
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }   
    }
    
    void setPginfo(String s1, int s2, int s3, int s4, int s5)
    {
        String sql = "insert into studentinfoschema.pg_info VALUES("+ s1 +", "+ s2 +", "+ s3 +", "+ s4 +", "+ s5 +");";
        try{
            ps = myConn.prepareCall(sql);
            ps.executeUpdate();
            ps = null;
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }   
    }
    
    void setUlinfo(String s1, String s2, String s3, String s4, String s5, String s6, String s7)
    {
        String sql = "insert into studentinfoschema.other_info VALUES ("+ s1 + "," + s2 + "," + s3 +","+ s4 +","+ s5 +","+ s6 +","+ s7 +");";
        
        try{
            ps = myConn.prepareCall(sql);
            ps.executeUpdate();
            ps = null;
            System.out.println("sent!");
        }
        catch(Exception e)
        {
            e.printStackTrace();
        } 
    }
    
    
    
    
    void DelBasicinfo(String s1)
    {   String sql = "DELETE FROM studentinfoschema.basic_info WHERE name = " + s1 + ";";
        try{
            ps = myConn.prepareCall(sql);
            ps.executeUpdate();
            ps = null;
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }
    
    void DelSscinfo(String s1)
    {   String sql = "DELETE FROM studentinfoschema.ssc_info WHERE name = " + s1 + ";";
        try{
            ps = myConn.prepareCall(sql);
            ps.executeUpdate();
            ps = null;
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }
    
    void DelHsscinfo(String s1)
    {   String sql = "DELETE FROM studentinfoschema.hssc_info WHERE name = " + s1 + ";";
        try{
            ps = myConn.prepareCall(sql);
            ps.executeUpdate();
            ps = null;
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }
    
    void DelDipinfo(String s1)
    {   String sql = "DELETE FROM studentinfoschema.diploma_info WHERE name = " + s1 + ";";
        try{
            ps = myConn.prepareCall(sql);
            ps.executeUpdate();
            ps = null;
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }
    
    void DelUGinfo(String s1)
    {   String sql = "DELETE FROM studentinfoschema.ug_info WHERE name = " + s1 + ";";
        try{
            ps = myConn.prepareCall(sql);
            ps.executeUpdate();
            ps = null;
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }
    
    void DelPGinfo(String s1)
    {   String sql = "DELETE FROM studentinfoschema.pg_info WHERE name = " + s1 + ";";
        try{
            ps = myConn.prepareCall(sql);
            ps.executeUpdate();
            ps = null;
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }
           
    void DelUlinfo(String s1)
    {   String sql = "DELETE FROM studentinfoschema.other_info WHERE name = " + s1 + ";";
        try{
            ps = myConn.prepareCall(sql);
            ps.executeUpdate();
            ps = null;
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }
    
    
    void UpBasicinfo(String s1, String s2, String s3, String s4, int s5, String s6, String s7)
    {   
        String sql = "UPDATE studentinfoschema.basic_info SET name = "+ s1 +", clgID = "+ s2 +", dept = "+ s3 +", currEdu = "+ s4 +", csem = "+ s5 +", contact = "+ s6 +", dob = "+ s7 +"WHERE name ="+ s1 +";";
        try{
            ps = myConn.prepareCall(sql);
            ps.executeUpdate();
            ps = null;
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }
    void UpSscinfo(String s1, int s2, int s3, String s4, String s5, String s6, String s7, int s8)
    {   
        String sql = "UPDATE studentinfoschema.ssc_info SET name = "+ s1 +", clgID = "+ s2 +", dept = "+ s3 +", currEdu = "+ s4 +", csem = "+ s5 +", contact = "+ s6 +", dob = "+ s7 +"WHERE name ="+ s1 +";";
        try{
            ps = myConn.prepareCall(sql);
            ps.executeUpdate();
            ps = null;
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }
    void UpHsscinfo(String s1, int s2, int s3, String s4, String s5, String s6, String s7, int s8, int s11, int s10, int s9)
    {   
        String sql = "UPDATE studentinfoschema.hssc_info SET name = "+ s1 +", Hyop = "+ s2 +", Hrn = "+ s3 +", HBoard = "+ s4 +", HMedium = "+ s5 +", HSch = "+ s6 +", Hcity = "+ s7 +", Hptng = "+ s8 +", math = "+ s11 +", chemistry = "+ s10 +", physics = "+ s9 +"WHERE name = "+ s1 +";";
        try{
            ps = myConn.prepareCall(sql);
            ps.executeUpdate();
            ps = null;
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }
    void UpDipinfo(String s1, int s2, int s3, int s4, int s5, int s6, int s7)
    {   
        String sql = "UPDATE studentinfoschema.diploma_info SET name ="+ s1 +", Dptng1 = "+ s2 +", Dptng2 = "+ s3 +", Dptng3 = "+ s4 +", Dptng4 = "+ s5 +", Dptng5 = "+ s6 +", Dptng6 = "+ s7 +"WHERE name = "+ s1 +";";
        try{
            ps = myConn.prepareCall(sql);
            ps.executeUpdate();
            ps = null;
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }
    void UpUginfo(String s1, int s2, int s3, int s4, int s5, int s6, int s7, int s8, int s9)
    {   
        String sql = "UPDATE studentinfoschema.ug_info SET name ="+ s1 +", Eptng1 = "+ s2 +", Eptng2 = "+ s3 +", Eptng3 = "+ s4 +", Eptng4 = "+ s5 +", Eptng5 = "+ s6 +", Eptng6 = "+ s7 +", Eptng7 = " + s8 +", Eptng8 = "+ s9 +"WHERE name ="+ s1 +";";
        try{
            ps = myConn.prepareCall(sql);
            ps.executeUpdate();
            ps = null;
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }
    void UpPginfo(String s1, int s2, int s3, int s4, int s5)
    {   
        String sql = "UPDATE studentinfoschema.pg_info SET name = "+ s1 +", Pptng1 = "+ s2 +", Pptng2 = "+ s3 +", Pptng3 = "+ s4 +", Pptng4 = "+ s5 +"WHERE name = "+ s1 +";";
        try{
            ps = myConn.prepareCall(sql);
            ps.executeUpdate();
            ps = null;
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }
    void UpUlinfo(String s1, String s2, String s3, String s4, String s5, String s6, String s7)
    {   
        String sql = "UPDATE studentinfoschema.other_info SET name = "+ s1 +", Cemail = "+ s2 +", PEmail = "+ s3 +", FatherCntct = "+ s4 +", FamCntct = "+ s5 +", certification = "+ s6 +", AddInfo = "+ s7 +"WHERE name = "+ s1 +";";
        try{
            ps = myConn.prepareCall(sql);
            ps.executeUpdate();
            ps = null;
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }
    
}
