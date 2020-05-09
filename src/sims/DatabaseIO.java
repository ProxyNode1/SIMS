package sims;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;

public class DatabaseIO 
{   
    public DatabaseIO() 
    {                
        try
        {
            connection = DatabaseCon.connect();
            statement = connection.createStatement(); 
            createTables();               
        }
        
        catch(SQLException e)
        {
           System.out.println("Connection could not be established!"); 
           System.err.println(e.getMessage());
        }
    }
    
    
    public String getSchemaName()
    {
        return schemaName;
    }
    
    
    public void createTables()
    {
        String cr8schema = "CREATE SCHEMA " + schemaName;
        
        String basicInfo =  "CREATE TABLE IF NOT EXISTS " + schemaName +".basic_info ("+ 
                            "basic_info_Name VARCHAR(30) NOT NULL, "+
                            "ClgId VARCHAR(10) NOT NULL, "+
                            "DOB DATE NOT NULL, "+ //year, month, date
                            "Course VARCHAR(15) NOT NULL, "+
                            "CurrentSem INT(1) UNSIGNED NOT NULL, "+
                            "Contact VARCHAR(15) NOT NULL, "+
                            "PRIMARY KEY (basic_info_Name));";
        
        String sscInfo =    "CREATE TABLE IF NOT EXISTS " + schemaName +".ssc_info ("+
                            "basic_info_Name VARCHAR(30) NULL,"+
                            "PassYear INT(4) UNSIGNED NOT NULL,"+
                            "RollNo VARCHAR(10) NOT NULL,"+
                            "Board VARCHAR(5) NOT NULL,"+
                            "Medium VARCHAR(10) NOT NULL,"+
                            "School VARCHAR(30) NOT NULL,"+
                            "City VARCHAR(10) NOT NULL,"+
                            "Percentage FLOAT UNSIGNED NOT NULL,"+
                            "INDEX Name_idx (basic_info_Name ASC) VISIBLE, "+ //ASC = Ascending
                            "CONSTRAINT FK_SName FOREIGN KEY (basic_info_Name) REFERENCES "+
                            ""+ schemaName +".basic_info (basic_info_Name) "+
                            "ON DELETE CASCADE "+
                            "ON UPDATE CASCADE);";
        
        String hssInfo = "CREATE TABLE IF NOT EXISTS " + schemaName +".hss_info ("+
                          "basic_info_Name VARCHAR(30) NULL, "+
                          "PassYear INT(4) UNSIGNED NULL, "+
                          "RollNo VARCHAR(10) NOT NULL, "+
                          "Board VARCHAR(5) NULL, "+
                          "Medium VARCHAR(10) NULL, "+
                          "School VARCHAR(30) NULL, "+
                          "City VARCHAR(10) NULL, "+
                          "Percentage FLOAT UNSIGNED NULL, "+
                          "MathPercentage FLOAT UNSIGNED NULL, "+
                          "ChemistryPercentage FLOAT UNSIGNED NULL, "+
                          "PhysicsPercentage FLOAT NULL, "+
                          "INDEX Name_idx (basic_info_Name ASC), "+
                          "CONSTRAINT FK_HName FOREIGN KEY (basic_info_Name) "+
                          "REFERENCES "+ schemaName +".basic_info (basic_info_Name) "+
                          "ON DELETE CASCADE " +
                          "ON UPDATE CASCADE);";
        
        String dipInfo = "CREATE TABLE IF NOT EXISTS " + schemaName +".diploma_info (" +
                         "basic_info_Name VARCHAR(30) NULL, "+
                         "PassYear INT(4) UNSIGNED NULL, "+
                         "School VARCHAR(30) NULL, "+
                         "City VARCHAR(10) NULL, "+
                         "Percentage1 FLOAT UNSIGNED NULL, "+
                         "Percentage2 FLOAT UNSIGNED NULL, "+
                         "Percentage3 FLOAT UNSIGNED NULL, "+
                         "Percentage4 FLOAT UNSIGNED NULL, "+
                         "Percentage5 FLOAT UNSIGNED NULL, "+
                         "Percentage6 FLOAT UNSIGNED NULL, "+
                         "INDEX Name_idx (basic_info_Name ASC), "+
                         "CONSTRAINT FK_DName FOREIGN KEY (basic_info_Name) "+
                         "REFERENCES "+ schemaName +".basic_info (basic_info_Name) "+
                         "ON DELETE CASCADE "+
                         "ON UPDATE CASCADE );";
        
        String uInfo = "CREATE TABLE IF NOT EXISTS " + schemaName +".ug_info (" +
                       "basic_info_Name VARCHAR(30) NULL," +
                       "School VARCHAR(30) NULL," +
                       "City VARCHAR(10) NULL," +
                       "Percentage1 FLOAT UNSIGNED NULL," +
                       "Percentage2 FLOAT UNSIGNED NULL," +
                       "Percentage3 FLOAT UNSIGNED NULL," +
                       "Percentage4 FLOAT UNSIGNED NULL," +
                       "Percentage5 FLOAT UNSIGNED NULL," +
                       "Percentage6 FLOAT UNSIGNED NULL," +
                       "Percentage7 FLOAT UNSIGNED NULL," +
                       "Percentage8 FLOAT UNSIGNED NULL," +
                       "INDEX Name_idx (basic_info_Name ASC), "+
                       "CONSTRAINT FK_UName FOREIGN KEY (basic_info_Name) "+
                       "REFERENCES "+ schemaName +".basic_info (basic_info_Name) "+
                       "ON DELETE CASCADE " +
                       "ON UPDATE CASCADE);";
        
        String pInfo = "CREATE TABLE IF NOT EXISTS " + schemaName +".pg_info (" +
                       "basic_info_Name VARCHAR(30) NULL, "+
                       "School VARCHAR(30) NULL, "+
                       "City VARCHAR(10) NULL, "+
                       "Percentage1 FLOAT UNSIGNED NULL, "+
                       "Percentage2 FLOAT UNSIGNED NULL, "+
                       "Percentage3 FLOAT UNSIGNED NULL, "+
                       "Percentage4 FLOAT UNSIGNED NULL, "+
                       "INDEX Name_idx (basic_info_Name ASC), "+
                       "CONSTRAINT FK_PName FOREIGN KEY (basic_info_Name) "+
                       "REFERENCES "+ schemaName +".basic_info (basic_info_Name) "+
                       "ON DELETE CASCADE "+
                       "ON UPDATE CASCADE);";
        
        String oInfo = "CREATE TABLE IF NOT EXISTS " + schemaName +".other_info (" +
                       "basic_info_Name VARCHAR(30) NULL, "+
                       "CollegeEmail VARCHAR(50) NOT NULL, "+
                       "PersonalEmail VARCHAR(50) NULL, "+
                       "FatherContact VARCHAR(10) NOT NULL, "+
                       "FamilyContact VARCHAR(10) NULL, "+
                       "AdditionalInfo TEXT NULL, "+
                       "INDEX Name_idx (basic_info_Name ASC), "+
                       "UNIQUE INDEX PEmail_UNIQUE (PersonalEmail ASC), "+
                       "UNIQUE INDEX CEmail_UNIQUE (CollegeEmail ASC), "+
                       "CONSTRAINT FK_OName FOREIGN KEY (basic_info_Name) "+
                       "REFERENCES "+ schemaName +".basic_info (basic_info_Name) "+                                       
                       "ON DELETE CASCADE "+
                       "ON UPDATE CASCADE);";
        
        try
        { 
            statement.executeUpdate(cr8schema);  
            statement.executeUpdate(basicInfo);
            statement.executeUpdate(sscInfo);
            statement.executeUpdate(hssInfo);
            statement.executeUpdate(dipInfo);
            statement.executeUpdate(uInfo);
            statement.executeUpdate(pInfo);
            statement.executeUpdate(oInfo);
            
            System.out.println("Tables Created");
        }
       
        catch(SQLException e)
        {
            System.err.println(e.getMessage());
        }
               
    }
    
    
    ////////////////////////////////////////////////////////////////////
    //Insert Values
    
    void InsertValues()
    {               
        ResultSet resultSet = null;
        /*System.out.println( edit1.getNameVal());
        
        String query = "INSERT INTO "+ schemaName +".basic_info VALUES('"+
                edit1.getNameVal() +"', '"+ edit1.getClgIDVal() +"', "+
                edit1.getYearVal() +"-"+ edit1.getMonthVal() +"-"+ edit1.getDayVal() +", "+
                edit1.getCourseVal() +", "+ edit1.getCurrSemVal() +", "+ 
                edit1.getContactVal() +");";              
                   
        System.out.println(query);
            
        try
        {
            prepStatement = connection.prepareCall(query);
            prepStatement.executeUpdate();
            prepStatement = null;
        }
        
        catch(SQLException e)
        {
            System.out.println(e.getMessage());
        }
        */
        
        
        
        /*SSCInfoData edit2SSC = SSCInfoData.getInstance();
        
                
        String query = "INSERT INTO "+ schemaName +".ssc_info value ('"+ edit1.getNameVal() 
                +"', "+ edit2SSC.getPassYearVal() +", '"+ edit2SSC.getRNoVal() 
                +"', '"+ edit2SSC.getBoardVal() +"', '"+ edit2SSC.getMediumVal() 
                +"', '"+ edit2SSC.getSchoolVal() +"', '"+ edit2SSC.getCityVal() +"', "+ edit2SSC.getPercentVal() + ");";
        
        System.out.println(query);
        
        try
        {
            prepStatement = connection.prepareCall(query);
            prepStatement.executeUpdate();
            prepStatement = null;
        }
        
        catch(SQLException e)
        {
            System.out.println(e.getMessage());
        }
        */
                
        
        /*HSSInfoData edit2Hss = HSSInfoData.getInstance();
                         
        
        String query = "INSERT INTO "+ schemaName +".hss_info value ('"+ edit1.getNameVal() 
                +"', "+ edit2Hss.getPassYearVal() +", '"+ edit2Hss.getRNoVal() 
                +"', '"+ edit2Hss.getBoardVal() +"', '"+ edit2Hss.getMediumVal() 
                +"', '"+ edit2Hss.getSchoolVal() +"', '"+ edit2Hss.getCityVal() +"', "+ edit2Hss.getPercentVal()
                +", "+ edit2Hss.getPhysicsVal() +", "+ edit2Hss.getChemistryVal() +", "+ edit2Hss.getMathVal() +");";
        
        System.out.println(query);
        
        try
        {
            prepStatement = connection.prepareCall(query);
            prepStatement.executeUpdate();
            prepStatement = null;
        }
        
        catch(SQLException e)
        {
            System.out.println(e.getMessage());
        }*/
                
         
        /*DiplomaInfoData edit2Diploma = DiplomaInfoData.getInstance();
               
        String query = "INSERT INTO "+ schemaName +".diploma_info VALUES( '"+ edit1.getNameVal() + "', "+  edit2Diploma.getPassYearVal()
                +", '"+ edit2Diploma.getSchoolVal() +"', '"+ edit2Diploma.getCityVal() +"', "+ edit2Diploma.getPercent1Val() 
                + ", "+ edit2Diploma.getPercent2Val() + ", "+ edit2Diploma.getPercent3Val() + ", "+ edit2Diploma.getPercent4Val()
                + ", "+ edit2Diploma.getPercent5Val() + ", "+ edit2Diploma.getPercent6Val() +");" ;
               
                
        
        System.out.println(query);
        
        try
        {
            prepStatement = connection.prepareCall(query);
            prepStatement.executeUpdate();
            prepStatement = null;
        }
        
        catch(SQLException e)
        {
            System.out.println(e.getMessage());
        }*/
                 
        
        /*UGInfoData edit2UG = UGInfoData.getInstance();
                             
        String query = "INSERT INTO "+ schemaName +".ug_info VALUES( '"+ edit1.getNameVal() + "', "+  edit2UG.getPassYearVal()
                +", '"+ edit2UG.getSchoolVal() +"', '"+ edit2UG.getCityVal() +"', "+ edit2UG.getPercent1Val() 
                + ", "+ edit2UG.getPercent2Val() + ", "+ edit2UG.getPercent3Val() + ", "+ edit2UG.getPercent4Val()
                + ", "+ edit2UG.getPercent5Val() + ", "+ edit2UG.getPercent6Val() +", "+ edit2UG.getPercent7Val() 
                + ", "+ edit2UG.getPercent8Val() +");" ;
        
        System.out.println(query);
        
        try
        {
            prepStatement = connection.prepareCall(query);
            prepStatement.executeUpdate();
            prepStatement = null;
        }
        
        catch(SQLException e)
        {
            System.out.println(e.getMessage());
        }*/
        
                       
              
        /*PGInfoData edit2PG = PGInfoData.getInstance();
               
        String query = "INSERT INTO "+ schemaName +".pg_info VALUES( '"+ edit1.getNameVal() + "', "+  edit2PG.getPassYearVal()
                +", '"+ edit2PG.getSchoolVal() +"', '"+ edit2PG.getCityVal() +"', "+ edit2PG.getPercent1Val() 
                + ", "+ edit2PG.getPercent2Val() + ", "+ edit2PG.getPercent3Val() + ", "+ edit2PG.getPercent4Val() +");" ;
                        
        System.out.println(query);
        
        try
        {
            prepStatement = connection.prepareCall(query);
            prepStatement.executeUpdate();
            prepStatement = null;
        }
        
        catch(SQLException e)
        {
            System.out.println(e.getMessage());
        }*/
        
        
        /*OtherInfoData edit3 = OtherInfoData.getInstance();
        
        String query = "INSERT INTO "+ schemaName +".other_info VALUES"
                + "( "
                +"  '"+ edit1.getNameVal() +"'" 
                +", '"+ edit3.getUniversityMailVal()  +"'"
                +", '"+ edit3.getPersonMailVal() +"'"
                +", '"+ edit3.getDadContactVal() +"'"
                +", '"+ edit3.getFamContactVal() +"'"
                +", '"+ edit3.getAddInfoVal() +"'"                
                +");" ;
                                        
        System.out.println(query);
        
        try
        {
            prepStatement = connection.prepareCall(query);
            prepStatement.executeUpdate();
            prepStatement = null;
        }
        
        catch(SQLException e)
        {
            System.out.println(e.getMessage());
        }*/
        
        
    }
    
       
    //////////////////////////////Update Table////////////////////////////////    
    /*void UpBasicinfo(String s1, String s2, String s3, String s4, int s5, String s6, String s7)
    {   
        
        String query = "UPDATE studentinfoschema.basic_info SET name = " + s1 
                + ", clgID = " + s2 + ", dept = " + s3 + ", cedu = " + s4 
                + ", csem = " + s5 + ", contact = " + s6 + ", dob = " + s7 
                + " WHERE name = '" + Editing1Controller.oldName + "';";
        try
        {
            prepStmt = connection.prepareCall(query);
            prepStmt.executeUpdate();
            prepStmt = null;
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }
    
    
    void UpSscinfo(String s1, int s2, int s3, String s4, String s5, String s6, String s7, int s8)
    {   
        System.out.println(s4);
        String query = "UPDATE studentinfoschema.ssc_info SET name = " + s1 + ", Syop = " 
                + s2 + ", Srn = " + s3 + ", SBoard = " + s4 + ", SMedium = " + s5 
                + ", SSch = " + s6 + ", Scity = " + s7 + " WHERE name = '" 
                + Editing1Controller.oldName +"';";
        try
        {
            prepStmt = connection.prepareCall(query);
            prepStmt.executeUpdate();
            prepStmt = null;
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }
    
    
    void Uphssinfo(String s1, int s2, int s3, String s4, String s5, String s6, 
            String s7, int s8, int s11, int s10, int s9)
    {   
        String query = "UPDATE studentinfoschema.hss_info SET name = " + s1 + ", Hyop = " 
                + s2 + ", Hrn = " + s3 + ", HBoard = " + s4 + ", HMedium = " + s5 
                + ", HSch = " + s6 + ", Hcity = " + s7 + ", Hptg = " + s8 
                + ", math = " + s11 + ", chemistry = " + s10 + ", physics = " + s9 
                + " WHERE name = '" + Editing1Controller.oldName + "';";
        try
        {
            prepStmt = connection.prepareCall(query);
            prepStmt.executeUpdate();
            prepStmt = null;
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }
    
    
    void UpDipinfo(String s1, int s2, int s3, int s4, int s5, int s6, int s7)
    {   
        String query = "UPDATE studentinfoschema.diploma_info SET name =" + s1 
                + ", Dptng1 = " + s2 + ", Dptng2 = " + s3 + ", Dptng3 = " + s4 
                + ", Dptng4 = " + s5 + ", Dptng5 = " + s6 + ", Dptng6 = " + s7 
                + " WHERE name = '" + Editing1Controller.oldName + "';";
        try
        {
            prepStmt = connection.prepareCall(query);
            prepStmt.executeUpdate();
            prepStmt = null;
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }
    
    
    void UpUginfo(String s1, int s2, int s3, int s4, int s5, int s6, int s7, 
            int s8, int s9)
    {   
        String query = "UPDATE studentinfoschema.ug_info SET name = " + s1 
                + ", Eptng1 = " + s2 + ", Eptng2 = " + s3 + ", Eptng3 = " + s4 
                + ", Eptng4 = " + s5 + ", Eptng5 = " + s6 + ", Eptng6 = " + s7 
                + ", Eptng7 = " + s8 + ", Eptng8 = " + s9 + " WHERE name = '" 
                + Editing1Controller.oldName + "';";
        try
        {
            prepStmt = connection.prepareCall(query);
            prepStmt.executeUpdate();
            prepStmt = null;
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }
    
    
    void UpPginfo(String s1, int s2, int s3, int s4, int s5)
    {   
        String query = "UPDATE studentinfoschema.pg_info SET name = " + s1 
                + ", Pptng1 = " + s2 + ", Pptng2 = " + s3 + ", Pptng3 = " + s4 
                + ", Pptng4 = " + s5 + " WHERE name = '" + Editing1Controller.oldName + "';";
        try
        {
            prepStmt = connection.prepareCall(query);
            prepStmt.executeUpdate();
            prepStmt = null;
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }
    
    
    void UpUlinfo(String s1, String s2, String s3, String s4, String s5, String s6, String s7)
    {   
       
        String query = "UPDATE studentinfoschema.other_info SET name = " + s1 
                + ", Cemail = " + s2 + ", PEmail = " + s3 + ", FatherCntct = " 
                + s4 + ", FamCntct = " + s5 + ", certification = " + s6 + ", AddInfo = " 
                + s7 + " WHERE name = '" + Editing1Controller.oldName + "';";
        try
        {
            prepStmt = connection.prepareCall(query);
            prepStmt.executeUpdate();
            prepStmt = null;
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }
    
    
    
    //////////////////////////////Delete Table///////////////////////////// 
    void DelBasicinfo()
    {   String query = "DELETE FROM studentinfoschema.basic_info WHERE name = '" 
            + Editing1Controller.oldName + "' ;";
        try
        {
            prepStmt = connection.prepareCall(query);
            prepStmt.executeUpdate();
            prepStmt = null;
        }
        catch(Exception e)
        {
            
            e.printStackTrace();
        }
    }*/
    
    
    ////////////////////////////////////////////////////////////////////////////
    // Get Data From The Table
    
    public ResultSet getBasicInfoForTable()
    {
        String query = "SELECT * FROM "+ schemaName +".basic_info";
        
        try
        {
           return connection.createStatement().executeQuery(query); 
           
           /*while(resultSet.next())
           {
           String tmp = resultSet.getString(2) +
                        "   "+ resultSet.getString(1) +  
                        "   "+ resultSet.getString(4).toUpperCase() + 
                        "   "+ resultSet.getInt(5) + 
                        "   "+ resultSet.getString(6); 
            
                System.out.println(tmp);
           }*/         
          
        }
        
        catch(SQLException e)
        {
            System.err.println(e.getMessage());
            return null;
        }
        
                        
        
    }
    
    
    public void getBasicInfo()
    {
        String query = "SELECT * FROM "+ schemaName +".basic_info WHERE basic_info_name = '"+ edit1.getOldNameVal() + "';";
        
        try
        {
           ResultSet resultSet = connection.createStatement().executeQuery(query); 
           while(resultSet.next())
           {
               edit1.setNameVal(resultSet.getString(1)); //Name
               edit1.setOldNameVal(resultSet.getString(1)); // Old Name
               edit1.setClgIDVal(resultSet.getString(2)); //ClgID
               
               
               String Date[] = resultSet.getString(3).split("-");  //Date (yyyy-mm-dd)         
               edit1.setYearVal( Integer.parseInt(Date[0]) );
               edit1.setMonthVal( Integer.parseInt(Date[1]) );
               edit1.setDayVal( Integer.parseInt(Date[2]) );
               
               
               
               edit1.setCourseVal(resultSet.getString(4)); //Course
               edit1.setCurrSemVal(resultSet.getInt(5)); //CurrSem
               edit1.setContactVal(resultSet.getString(6)); //Contact*/
            
                
               break;
           }
        }
        
        catch(SQLException e)
        {
            System.err.println(e.getMessage());
        }
    }
    
    
    public void getSscInfo()
    {
        String query = "SELECT * FROM "+ schemaName +".ssc_info WHERE basic_info_name = "+ edit1.getOldNameVal();
        
        try
        {
           ResultSet resultSet = connection.createStatement().executeQuery(query); 
           /*while(resultSet.next())
           {
           String tmp = resultSet.getString(2) +
                        "   "+ resultSet.getString(1) +  
                        "   "+ resultSet.getString(4).toUpperCase() + 
                        "   "+ resultSet.getInt(5) + 
                        "   "+ resultSet.getString(6); 
            
                System.out.println(tmp);
           }*/
        }
        
        catch(SQLException e)
        {
            System.err.println(e.getMessage());
        }
        
                        
        //return resultSet;
    }
    
    
    public void getHssInfo()
    {
        String query = "SELECT * FROM "+ schemaName +".hss_info WHERE basic_info_name = "+ edit1.getNameVal();
        
        try
        {
           ResultSet resultSet = connection.createStatement().executeQuery(query); 
           /*while(resultSet.next())
           {
           String tmp = resultSet.getString(2) +
                        "   "+ resultSet.getString(1) +  
                        "   "+ resultSet.getString(4).toUpperCase() + 
                        "   "+ resultSet.getInt(5) + 
                        "   "+ resultSet.getString(6); 
            
                System.out.println(tmp);
           }*/
        }
        
        catch(SQLException e)
        {
            System.err.println(e.getMessage());
        }
        
                        
        //return resultSet;
    }
    
    
    public void getDiplomaInfo()
    {
        String query = "SELECT * FROM "+ schemaName +".diploma_info WHERE basic_info_name = "+ edit1.getNameVal();
        
        try
        {
           ResultSet resultSet = connection.createStatement().executeQuery(query); 
           /*while(resultSet.next())
           {
           String tmp = resultSet.getString(2) +
                        "   "+ resultSet.getString(1) +  
                        "   "+ resultSet.getString(4).toUpperCase() + 
                        "   "+ resultSet.getInt(5) + 
                        "   "+ resultSet.getString(6); 
            
                System.out.println(tmp);
           }*/
        }
        
        catch(SQLException e)
        {
            System.err.println(e.getMessage());
        }
        
                        
        //return resultSet;
    }
    
    
    public void getUGInfo()
    {
        String query = "SELECT * FROM "+ schemaName +".ug_info WHERE basic_info_name = "+ edit1.getNameVal();
        
        try
        {
           ResultSet resultSet = connection.createStatement().executeQuery(query); 
           /*while(resultSet.next())
           {
           String tmp = resultSet.getString(2) +
                        "   "+ resultSet.getString(1) +  
                        "   "+ resultSet.getString(4).toUpperCase() + 
                        "   "+ resultSet.getInt(5) + 
                        "   "+ resultSet.getString(6); 
            
                System.out.println(tmp);
           }*/
        }
        
        catch(SQLException e)
        {
            System.err.println(e.getMessage());
        }
        
                        
        //return resultSet;
    }
    
    
    public void getPGInfo()
    {
        String query = "SELECT * FROM "+ schemaName +".pg_info WHERE basic_info_name = "+ edit1.getNameVal();
        
        try
        {
           ResultSet resultSet = connection.createStatement().executeQuery(query); 
           /*while(resultSet.next())
           {
           String tmp = resultSet.getString(2) +
                        "   "+ resultSet.getString(1) +  
                        "   "+ resultSet.getString(4).toUpperCase() + 
                        "   "+ resultSet.getInt(5) + 
                        "   "+ resultSet.getString(6); 
            
                System.out.println(tmp);
           }*/
        }
        
        catch(SQLException e)
        {
            System.err.println(e.getMessage());
        }
        
                        
        //return resultSet;
    }
    
    
    public void getOtherInfo()
    {
        String query = "SELECT * FROM "+ schemaName +".other_info WHERE basic_info_name = "+ edit1.getNameVal();
        
        try
        {
           ResultSet resultSet = connection.createStatement().executeQuery(query); 
           /*while(resultSet.next())
           {
           String tmp = resultSet.getString(2) +
                        "   "+ resultSet.getString(1) +  
                        "   "+ resultSet.getString(4).toUpperCase() + 
                        "   "+ resultSet.getInt(5) + 
                        "   "+ resultSet.getString(6); 
            
                System.out.println(tmp);
           }*/
        }
        
        catch(SQLException e)
        {
            System.err.println(e.getMessage());
        }
        
                        
        //return resultSet;
    }
    
    
    
    private Connection connection = null;
    private Statement statement = null;
    private PreparedStatement prepStatement = null;
        
    private String schemaName = "studentinfoschema";
    
    private final BasicInfoData edit1 = BasicInfoData.getInstance();
    private final SSCInfoData edit2Ssc = SSCInfoData.getInstance();
    private final HSSInfoData edit2Hss = HSSInfoData.getInstance();
    private final DiplomaInfoData edit2Diploma = DiplomaInfoData.getInstance();
    private final UGInfoData edit2UG = UGInfoData.getInstance();
    private final PGInfoData edit2PG = PGInfoData.getInstance();
    private final OtherInfoData edit3 = OtherInfoData.getInstance();
    
}
