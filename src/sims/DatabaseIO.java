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
        String basicInfo =  "CREATE TABLE IF NOT EXISTS `student_info_schema`.`basic_info` (" + 
                            "`name` VARCHAR(30) NOT NULL," +
                            "`clgId` VARCHAR(10) NOT NULL," +
                            "`dept` VARCHAR(5) NOT NULL," +
                            "`cedu` VARCHAR(2) NOT NULL," +
                            "`csem` INT(1) UNSIGNED NOT NULL," +
                            "`contact` VARCHAR(10) NOT NULL," +
                            "`dob` DATE NOT NULL," +
                            "UNIQUE INDEX `clgId_UNIQUE` (`clgId` ASC)," +
                            "PRIMARY KEY (`name`)," +
                            "UNIQUE INDEX `name_UNIQUE` (`name` ASC)," +
                            "UNIQUE INDEX `contact_UNIQUE` (`contact` ASC));" ;
        
        String sscInfo =    "CREATE TABLE IF NOT EXISTS `student_info_schema`.`ssc_info` ("+
                            "`name` VARCHAR(30) NULL,"+
                            "`SYop` INT(4) NOT NULL,"+
                            "`SRn` INT(5) UNSIGNED NOT NULL,"+
                            "`SBoard` VARCHAR(5) NOT NULL,"+
                            "`SMedium` VARCHAR(10) NOT NULL,"+
                            "`SSch` VARCHAR(30) NOT NULL,"+
                            "`SCity` VARCHAR(10) NOT NULL,"+
                            "`SPtng` INT(2) UNSIGNED NOT NULL,"+
                            "INDEX `Sname_idx` (`name` ASC),"+
                            "CONSTRAINT `Sname`"+
                            "FOREIGN KEY (`name`)"+
                            "REFERENCES `student_info_schema`.`basic_info` (`name`)" +
                            "ON DELETE CASCADE " +
                            "ON UPDATE CASCADE);";
        
        String hsscInfo = "CREATE TABLE IF NOT EXISTS `student_info_schema`.`hssc_info` (" +
                          "`name` VARCHAR(30) NULL," +
                          "`HYop` INT(4) NULL," +
                          "`HRn` INT(5) UNSIGNED NULL," +
                          "`HBoard` VARCHAR(5) NULL," +
                          "`HMedium` VARCHAR(10) NULL," +
                          "`HSch` VARCHAR(30) NULL," +
                          "`HCity` VARCHAR(10) NULL," +
                          "`HPtng` INT(2) UNSIGNED NULL," +
                          "`physics` INT(2) NULL," +
                          "`chemistry` INT(2) UNSIGNED NULL," +
                          "`math` INT(2) UNSIGNED NULL," +
                          "INDEX `Hname_idx` (`name` ASC)," +
                          "CONSTRAINT `Hname`" +
                          "FOREIGN KEY (`name`)" +
                          "REFERENCES `student_info_schema`.`basic_info` (`name`)" +
                          "ON DELETE CASCADE " +
                          "ON UPDATE CASCADE);";
        
        String dipInfo = "CREATE TABLE IF NOT EXISTS `student_info_schema`.`diploma_info` (" +
                         "`name` VARCHAR(30) NULL," +
                         "`DSem1` INT(1) UNSIGNED NULL," +
                         "`DPtng1` INT(3) UNSIGNED NULL," +
                         "`DSem2` INT(1) UNSIGNED NULL," +
                         "`DPtng2` INT(3) UNSIGNED NULL," +
                         "`DSem3` INT(1) UNSIGNED NULL," +
                         "`DPtng3` INT(3) UNSIGNED NULL," +
                         "`DSem4` INT(1) UNSIGNED NULL," +
                         "`DPtng4` INT(3) UNSIGNED NULL," +
                         "`DSem5` INT(1) UNSIGNED NULL," +
                         "`DPtng5` INT(3) UNSIGNED NULL," +
                         "`DSem6` INT(1) UNSIGNED NULL," +
                         "`DPtng6` INT(3) UNSIGNED NULL," +
                         "INDEX `Dname_idx` (`name` ASC)," +
                         "CONSTRAINT `Dname`" +
                         "FOREIGN KEY (`name`)" +
                         "REFERENCES `student_info_schema`.`basic_info` (`name`)" +
                         "ON DELETE CASCADE " +
                         "ON UPDATE CASCADE);";
        
        String uInfo = "CREATE TABLE IF NOT EXISTS `student_info_schema`.`ug_info` (" +
                       "`name` VARCHAR(30) NULL," +
                       "`ESem1` INT(1) UNSIGNED NULL," +
                       "`EPtng1` INT(3) UNSIGNED NULL," +
                       "`ESem2` INT(1) UNSIGNED NULL," +
                       "`EPtng2` INT(3) UNSIGNED NULL," +
                       "`ESem3` INT(1) UNSIGNED NULL," +
                       "`EPtng3` INT(3) UNSIGNED NULL," +
                       "`ESem4` INT(1) UNSIGNED NULL," +
                       "`EPtng4` INT(3) UNSIGNED NULL," +
                       "`ESem5` INT(1) UNSIGNED NULL," +
                       "`EPtng5` INT(3) UNSIGNED NULL," +
                       "`ESem6` INT(1) UNSIGNED NULL," +
                       "`EPtng6` INT(3) UNSIGNED NULL," +
                       "`ESem7` INT(1) UNSIGNED NULL," +
                       "`EPtng7` INT(3) UNSIGNED NULL," +
                       "`ESem8` INT(1) UNSIGNED NULL," +
                       "`EPtng8` INT(3) UNSIGNED NULL," +
                       "INDEX `Uname_idx` (`name` ASC)," +
                       "CONSTRAINT `Uname`" +
                       "FOREIGN KEY (`name`)" +
                       "REFERENCES `student_info_schema`.`basic_info` (`name`)" +
                       "ON DELETE CASCADE " +
                       "ON UPDATE CASCADE);";
        
        String pInfo = "CREATE TABLE IF NOT EXISTS `student_info_schema`.`pg_info` (" +
                       "`name` VARCHAR(30) NULL," +
                       "`PSem1` INT(1) UNSIGNED NULL," +
                       "`PPtng1` INT(3) UNSIGNED NULL," +
                       "`PSem2` INT(1) UNSIGNED NULL," +
                       "`PPtng2` INT(3) UNSIGNED NULL," +
                       "`PSem3` INT(1) UNSIGNED NULL," +
                       "`PPtng3` INT(3) UNSIGNED NULL," +
                       "`PSem4` INT(1) UNSIGNED NULL," +
                       "`PPtng4` INT(3) UNSIGNED NULL," +
                       "INDEX `Pname_idx` (`name` ASC)," +
                       "CONSTRAINT `Pname`" +
                       "FOREIGN KEY (`name`)" +
                       "REFERENCES `student_info_schema`.`basic_info` (`name`)" +
                       "ON DELETE CASCADE " +
                       "ON UPDATE CASCADE);";
        
        String oInfo = "CREATE TABLE IF NOT EXISTS `student_info_schema`.`other_info` (" +
                       "`name` VARCHAR(30) NULL," +
                       "`PEmail` VARCHAR(50) NULL," +
                       "`CEmail` VARCHAR(50) NOT NULL," +
                       "`FatherCntct` VARCHAR(10) NOT NULL," +
                       "`FamCntct` VARCHAR(10) NULL," +
                       "`Certification` VARCHAR(5) NULL," +
                       "`AddInfo` TEXT NULL," +
                       "INDEX `Oname_idx` (`name` ASC)," +
                       "UNIQUE INDEX `PEmail_UNIQUE` (`PEmail` ASC)," +
                       "UNIQUE INDEX `CEmail_UNIQUE` (`CEmail` ASC)," +
                       "CONSTRAINT `Oname`" +
                       "FOREIGN KEY (`name`)" +
                       "REFERENCES `student_info_schema`.`basic_info` (`name`)"+
                       "ON DELETE CASCADE " +
                       "ON UPDATE CASCADE);";
        
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
    {   String sql = "insert into student_info_schema.basic_info VALUES("+ s1 + ","+ s2 +","+ s3 +","+ s4 +","+ s5 +","+ s6 +","+ s7 +");";
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
        String sql = "insert into student_info_schema.ssc_info VALUES("+ s1 + ","+ s2 +","+ s3 +","+ s4 +","+ s5 +","+ s6 +","+ s7 +","+ s8 +");";
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
    
    void setHsscinfo(String s1, int s2, int s3, String s4, String s5, String s6, String s7, int s8, int s9, int s10, int s11)
    {
        String sql = "insert into student_info_schema.hssc_info VALUES("+ s1 + ","+ s2 +","+ s3 +","+ s4 +","+ s5 +","+ s6 +","+ s7 +","+ s8 +","+ s9 +","+ s10 +","+ s11 +");";
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
        String sql = "insert into student_info_schema.diploma_info VALUES("+ s1 +", 1,"+ s2 +", 2,"+ s3 +", 3,"+ s4 +", 4,"+ s5 +", 5,"+ s6 +", 6,"+ s7 +");";
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
        String sql = "insert into student_info_schema.ug_info VALUES ("+ s1 + ", 1, "+ s2 +", 2, "+ s3 +", 3, "+ s4 +", 4, "+ s5 +" , 5, "+ s6 +", 6, "+ s7 +", 7, "+ s8 +", 8, "+ s9 +" );";
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
        String sql = "insert into student_info_schema.pg_info VALUES("+ s1 +", 1,"+ s2 +", 2,"+ s3 +", 3,"+ s4 +", 4,"+ s5 +");";
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
        String sql = "insert into student_info_schema.other_info VALUES ("+ s1 + "," + s2 + "," + s3 +","+ s4 +","+ s5 +","+ s6 +","+ s7 +");";
        
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
