package sims;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class DatabaseIO 
{
    Connection myConn = null;
    Statement stmt = null;
    PreparedStatement ps =null;
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
        String basicInfo =  "CREATE TABLE IF NOT EXIST `student_info_schema`.`basic_info` (" + 
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
        
        String sscInfo =    "CREATE TABLE IF NOT EXIST `student_info_schema`.`ssc_info` ("+
                            "`name` VARCHAR(30) NOT NULL,"+
                            "`SYop` DATE NOT NULL,"+
                            "`SRn` INT(5) UNSIGNED NOT NULL,"+
                            "`SBoard` VARCHAR(5) NOT NULL,"+
                            "`SMedium` VARCHAR(10) NOT NULL,"+
                            "`SSch` VARCHAR(30) NOT NULL,"+
                            "`SCity` VARCHAR(10) NOT NULL,"+
                            "`SPtng` INT(2) UNSIGNED NOT NULL,"+
                            "INDEX `Sname_idx` (`name` ASC),"+
                            "CONSTRAINT `Sname`"+
                            "FOREIGN KEY (`name`)"+
                            "REFERENCES `student_info_schema`.`basic_info` (`name`)"+
                            "ON DELETE NO ACTION"+
                            "ON UPDATE NO ACTION);";
        
        String hsscInfo = "CREATE TABLE IF NOT EXIST `student_info_schema`.`hssc_info` (" +
                          "`name` VARCHAR(30) NOT NULL," +
                          "`HYop` DATE NOT NULL," +
                          "`HRn` INT(5) UNSIGNED NOT NULL," +
                          "`HBoard` VARCHAR(5) NOT NULL," +
                          "`HMedium` VARCHAR(10) NOT NULL," +
                          "`HSch` VARCHAR(30) NOT NULL," +
                          "`HCity` VARCHAR(10) NOT NULL," +
                          "`HPtng` INT(2) UNSIGNED NOT NULL," +
                          "`physics` INT(2) NOT NULL," +
                          "`chemistry` INT(2) UNSIGNED NOT NULL," +
                          "`math` INT(2) UNSIGNED NOT NULL," +
                          "INDEX `Hname_idx` (`name` ASC)," +
                          "CONSTRAINT `Hname`" +
                          "FOREIGN KEY (`name`)" +
                          "REFERENCES `student_info_schema`.`basic_info` (`name`)" +
                          "ON DELETE NO ACTION" +
                          "ON UPDATE NO ACTION);";
        
        String dipInfo = "CREATE TABLE IF NOT EXIST `student_info_schema`.`diploma_info` (" +
                         "`name` VARCHAR(30) NOT NULL," +
                         "`DSem1` INT(1) UNSIGNED NOT NULL," +
                         "`DPtng1` INT(2) UNSIGNED NOT NULL," +
                         "`DSem2` INT(1) UNSIGNED NOT NULL," +
                         "`DPtng2` INT(2) UNSIGNED NOT NULL," +
                         "`DSem3` INT(1) UNSIGNED NOT NULL," +
                         "`DPtng3` INT(2) UNSIGNED NOT NULL," +
                         "`DSem4` INT(1) UNSIGNED NOT NULL," +
                         "`DPtng4` INT(2) UNSIGNED NOT NULL," +
                         "`DSem5` INT(1) UNSIGNED NOT NULL," +
                         "`DPtng5` INT(2) UNSIGNED NOT NULL," +
                         "`DSem6` INT(1) UNSIGNED NOT NULL," +
                         "`DPtng6` INT(2) UNSIGNED NOT NULL," +
                         "INDEX `Dname_idx` (`name` ASC)," +
                         "CONSTRAINT `Dname`" +
                         "FOREIGN KEY (`name`)" +
                         "REFERENCES `student_info_schema`.`basic_info` (`name`)" +
                         "ON DELETE NO ACTION" +
                         "ON UPDATE NO ACTION);";
        
        String uInfo = "CREATE TABLE IF NOT EXIST `student_info_schema`.`ug_info` (" +
                       "`name` VARCHAR(30) NOT NULL," +
                       "`ESem1` INT(1) UNSIGNED NOT NULL," +
                       "`EPtng1` INT(2) UNSIGNED NOT NULL" +
                       "`ESem2` INT(1) UNSIGNED NOT NULL," +
                       "`EPtng2` INT(2) UNSIGNED NOT NULL," +
                       "`ESem3` INT(1) UNSIGNED NOT NULL," +
                       "`EPtng3` INT(2) UNSIGNED NOT NULL," +
                       "`ESem4` INT(1) UNSIGNED NOT NULL," +
                       "`EPtng4` INT(2) UNSIGNED NOT NULL," +
                       "`ESem5` INT(1) UNSIGNED NOT NULL," +
                       "`EPtng5` INT(2) UNSIGNED NOT NULL," +
                       "`ESem6` INT(1) UNSIGNED NOT NULL," +
                       "`EPtng6` INT(2) UNSIGNED NOT NULL" +
                       "`ESem7` INT(1) UNSIGNED NOT NULL," +
                       "`EPtng7` INT(2) UNSIGNED NOT NULL," +
                       "`ESem8` INT(1) UNSIGNED NOT NULL," +
                       "`EPtng8` INT(2) UNSIGNED NOT NULL,n" +
                       "INDEX `Uname_idx` (`name` ASC)," +
                       "CONSTRAINT `Uname`" +
                       "FOREIGN KEY (`name`)" +
                       "REFERENCES `student_info_schema`.`basic_info` (`name`)" +
                       "ON DELETE NO ACTION" +
                       "ON UPDATE NO ACTION);";
        
        String pInfo = "CREATE TABLE IF NOT EXIST `student_info_schema`.`pg_info` (" +
                       "`name` VARCHAR(30) NOT NULL," +
                       "`PSem1` INT(1) UNSIGNED NOT NULL," +
                       "`PPtng1` INT(2) UNSIGNED NOT NULL," +
                       "`PSem2` INT(1) UNSIGNED NOT NULL," +
                       "`PPtng2` INT(2) UNSIGNED NOT NULL," +
                       "`PSem3` INT(1) UNSIGNED NOT NULL," +
                       "`PPtng3` INT(2) UNSIGNED NOT NULL," +
                       "`PSem4` INT(1) UNSIGNED NOT NULL," +
                       "`PPtng4` INT(2) UNSIGNED NOT NULL," +
                       "INDEX `Pname_idx` (`name` ASC)," +
                       "CONSTRAINT `Pname`" +
                       "FOREIGN KEY (`name`)" +
                       "REFERENCES `student_info_schema`.`basic_info` (`name`)" +
                       "ON DELETE NO ACTION" +
                       "ON UPDATE NO ACTION);";
        
        String oInfo = "CREATE TABLE IF NOT EXIST `student_info_schema`.`other_info` (" +
                       "`name` VARCHAR(30) NOT NULL," +
                       "`PEmail` VARCHAR(45) NULL," +
                       "`CEmail` VARCHAR(45) NOT NULL," +
                       "`FatherCntct` VARCHAR(45) NOT NULL," +
                       "`FamCntct` VARCHAR(45) NULL," +
                       "`Certification` CHAR(1) NULL," +
                       "`AddInfo` VARCHAR(100) NULL," +
                       "INDEX `Oname_idx` (`name` ASC)," +
                       "UNIQUE INDEX `PEmail_UNIQUE` (`PEmail` ASC)," +
                       "UNIQUE INDEX `CEmail_UNIQUE` (`CEmail` ASC)," +
                       "CONSTRAINT `Oname`" +
                       "FOREIGN KEY (`name`)" +
                       "REFERENCES `student_info_schema`.`basic_info` (`name`)" +
                       "ON DELETE NO ACTION" +
                       "ON UPDATE NO ACTION);";
        
        try{
            stmt = myConn.createStatement();
            stmt.executeUpdate(basicInfo);
            System.out.println("succ 1");
        }
        catch(Exception e)
        {
            e.printStackTrace();
            System.out.println("err 1");
        }
        
        try{
            stmt = myConn.createStatement();
            stmt.executeUpdate(sscInfo);
            System.out.println("succ 2");
        }
        catch(Exception e)
        {
            e.printStackTrace();
            System.out.println("err 2");
        }
        
        try{
            stmt = myConn.createStatement();
            stmt.executeUpdate(hsscInfo);
            System.out.println("succ 3");
        }
        catch(Exception e)
        {
            e.printStackTrace();
            System.out.println("err 3");
        }
        
        try{
            stmt = myConn.createStatement();
            stmt.executeUpdate(dipInfo);
            System.out.println("succ 4");
        }
        catch(Exception e)
        {
            e.printStackTrace();
            System.out.println("err 4");
        }
        
        try{
            stmt = myConn.createStatement();
            stmt.executeUpdate(uInfo);
            System.out.println("succ 5");
        }
        catch(Exception e)
        {
            e.printStackTrace();
            System.out.println("err 5");
        }
        
        try{
            stmt = myConn.createStatement();
            stmt.executeUpdate(pInfo);
            System.out.println("succ 6");
        }
        catch(Exception e)
        {
            e.printStackTrace();
            System.out.println("err 6");
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
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }
}
