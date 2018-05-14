
package sims;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.Initializable;
import java.sql.*;

import javafx.scene.input.MouseEvent;
import com.jfoenix.controls.JFXTextField;
import java.util.List;
import java.util.Optional;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.MenuButton;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextField;
import javafx.scene.control.Tooltip;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;



public class Editing2Controller implements Initializable 
{

  
    @Override
    public void initialize(URL url, ResourceBundle rb) 
    {
        SPass.requestFocus();
        
        //IdFld.setStyle("-fx-border-color: #ff2323; -fx-text-fill: white; -fx-prompt-text-fill: white;"); when error occurs or not filled
        
        chzHBrdDrpDwn();
        chzSBrdDrpDwn();
        
        s1 = Editing1Controller.newName;
        System.out.println(s1);
        
        j = Editing1Controller.useSem;
        System.out.println(j);
        
        o = Editing1Controller.up;
        hide(o);
        
        
                
        chzPostSSDwn();
       
        selEPentg();
        selPPentg();
        
        SSch.setTooltip(new Tooltip("Do not use , or ."));
        HSch.setTooltip(new Tooltip("Do not use , or ."));
        
        n = DatabaseCon.connect();
        operation();
        
    }  
    
    
    Connection n = null;
    
    public static int i, h;
    public int a;
    
    static String s1;
    
    
    public  void disableGrad()
    {
        if(a == 2)
        {
           PPane.setDisable(true);
           EPane.setDisable(false);
        }
        
        if(a == 1)
        {
           EPane.setDisable(true);
           PPane.setDisable(false);
        }
    }
    
    @FXML
    private Label delData;
    
    void operation()
    {
        if(Editing1Controller.ui == 0)
        {
            update();
        }
        else if(Editing1Controller.ui == 1)
        {
            insert();
        }
    }
    
    void insert()
    {
        s2 = 0; s3 = 0; s8 = 0; t2 = 0; t3 = 0; t8 = 0; t9 = 0; t10 = 0; t11 = 0; d1 = 0; d2 = 0; d3 = 0; d4 = 0; d5 = 0; d6 = 0;
        e1 = 0; e2 = 0; e3 = 0; e4 = 0; e5 = 0; e6 = 0; e7 = 0; e8 = 0; p1 = 0; p2 = 0; p3 = 0; p4 = 0;
        s4 = null; s5 = null; s6 = null; s7 = null; t4 = null; t5 = null; t6 = null; t7 = null; 
        
        delData.setVisible(false);
       
    }
    
    void update()
    {
        delData.setVisible(true);
         
        try //to fill ssc 
        {
            Statement myStmt = n.createStatement();
            ResultSet myRs = myStmt.executeQuery("select * from studentinfoschema.ssc_info where name = '" + Editing1Controller.oldName +"';");
            
            while(myRs.next())
            {
                s1 = myRs.getString(1);
                SPass.setText(Integer.toString(myRs.getInt(2)));
                SRoll.setText(Integer.toString(myRs.getInt(3)));
                
                String n = myRs.getString(4);
                System.out.println(n);
                if(n.equalsIgnoreCase("CBSE"))
                {
                    SBrdDrpDwn.setText("CBSE");
                    s4 = "'"+n+"'";
                }
                else if(n.equalsIgnoreCase("CISCE"))
                {
                    System.out.println(n);
                    SBrdDrpDwn.setText("CISCE");
                    s4 = "'"+n+"'";
                }
                
                else if(n.equalsIgnoreCase("STATE"))
                {
                    System.out.println(n);
                    SBrdDrpDwn.setText("STATE");
                    s4 = "'"+n+"'";
                }
                
                else if(n.equalsIgnoreCase("IBO"))
                {
                    System.out.println(n);
                    SBrdDrpDwn.setText("IBO");
                    s4 = "'"+n+"'";
                }
                
                else if(n.equalsIgnoreCase("CIE"))
                {
                    System.out.println(n);
                    SBrdDrpDwn.setText("CIE");
                    s4 = "'"+n+"'";
                }

                SMed.setText(myRs.getString(5).toUpperCase());
                SSch.setText(myRs.getString(6).toUpperCase());   
                SCity.setText(myRs.getString(7).toUpperCase());
                SPentg.setText(Integer.toString(myRs.getInt(8)));

                s2 = myRs.getInt(2);
                s3 = myRs.getInt(3);
                s5 = "'"+myRs.getString(5).toUpperCase()+"'";        
                s6 = "'"+myRs.getString(6).toUpperCase()+"'";
                s7 = "'"+myRs.getString(7).toUpperCase()+"'";        
                s8 = myRs.getInt(8);

            } 
            
        }
        catch(Exception n)
        {
            System.out.println("check ssc");
            n.printStackTrace();
        }
        
        try // to fill hssc
        {
            Statement myStmt = n.createStatement();
            ResultSet myRs = myStmt.executeQuery("select * from studentinfoschema.hssc_info where name = '" + Editing1Controller.oldName +"';");
            
            while(myRs.next())
            {
                s1 = (myRs.getString(1)).toUpperCase();
                
                int l = myRs.getInt(2);
                if(l > 0)
                {
                    HD = 0;
                    PostSS.setText("HSSC");
                    HPane.setVisible(true);
                    DPane.setVisible(false);
                }
                
                HPass.setText(Integer.toString(myRs.getInt(2)));
                
                HRoll.setText(Integer.toString(myRs.getInt(3)));
                
                               
                String n = myRs.getString(4);
                System.out.println(n);
                if(n.equalsIgnoreCase("CBSE"))
                {
                    HBrdDrpDwn.setText("CBSE");
                    t4 = "'"+n+"'";
                }
                else if(n.equalsIgnoreCase("CISCE"))
                {
                    System.out.println(n);
                    HBrdDrpDwn.setText("CISCE");
                    t4 = "'"+n+"'";
                }
                
                else if(n.equalsIgnoreCase("STATE"))
                {
                    System.out.println(n);
                    HBrdDrpDwn.setText("STATE");
                    t4 = "'"+n+"'";
                }
                
                else if(n.equalsIgnoreCase("IBO"))
                {
                    System.out.println(n);
                    HBrdDrpDwn.setText("IBO");
                    t4 = "'"+n+"'";
                }
                
                else if(n.equalsIgnoreCase("CIE"))
                {
                    System.out.println(n);
                    HBrdDrpDwn.setText("CIE");
                    t4 = "'"+n+"'";
                }
                
                
                if(myRs.getString(5) != null)
                {
                    HMed.setText(myRs.getString(5).toUpperCase());
                }
                else
                {
                    HMed.setText(myRs.getString(5));
                }
                                
                if(myRs.getString(6) != null)
                {
                    HSch.setText(myRs.getString(6).toUpperCase());
                }
                else
                {
                    HSch.setText(myRs.getString(6));
                }

                if(myRs.getString(7) != null)
                {
                    HCity.setText(myRs.getString(7).toUpperCase());
                }
                else
                {
                    HCity.setText(myRs.getString(7));
                }
                
                HPentg.setText(Integer.toString(t8));
                HM.setText(Integer.toString(t9));
                HC.setText(Integer.toString(t10));
                HP.setText(Integer.toString(t11));
                

                t2 = myRs.getInt(2);
                t3 = myRs.getInt(3);
                t5 = "'"+myRs.getString(5)+"'"; 
                t6 = "'"+myRs.getString(6)+"'";
                t7 = "'"+myRs.getString(7)+"'";        
                t8 = myRs.getInt(8);
                t9 = myRs.getInt(9);
                t10 = myRs.getInt(10);
                t11 = myRs.getInt(11);        
            }   
        }
        catch(Exception n)
        {
            System.out.println("check hssc");
            n.printStackTrace();
        }
        
        try // to fill diploma
        {
            Statement myStmt = n.createStatement();
            ResultSet myRs = myStmt.executeQuery("select * from studentinfoschema.diploma_info where name = '" + Editing1Controller.oldName +"';");
            
            while(myRs.next())
            {
                s1 = (myRs.getString(1)).toUpperCase();
                int l = myRs.getInt(2);
                if(l > 0)
                {
                    HD = 1;
                    PostSS.setText("DIPLOMA");
                    HPane.setVisible(false);
                    DPane.setVisible(true);
                }
                
                DPentg1.setText(Integer.toString(myRs.getInt(2)));
                DPentg2.setText(Integer.toString(myRs.getInt(3)));
                DPentg3.setText(Integer.toString(myRs.getInt(4)));
                DPentg4.setText(Integer.toString(myRs.getInt(5)));
                DPentg5.setText(Integer.toString(myRs.getInt(6)));
                DPentg6.setText(Integer.toString(myRs.getInt(7)));
                
                
                d2 = myRs.getInt(2);
                d2 = myRs.getInt(3);
                d3 = myRs.getInt(4);
                d4 = myRs.getInt(5);
                d5 = myRs.getInt(6);
                d6 = myRs.getInt(7);
                
            } 
            
        }
        catch(Exception n)
        {
            System.out.println("check diploma");
            n.printStackTrace();
        }
        
        if(o == 1)
        {
            try // to fill Enginnering
            {
                Statement myStmt = n.createStatement();
                ResultSet myRs = myStmt.executeQuery("select * from studentinfoschema.ug_info where name = '" + Editing1Controller.oldName +"';");

                while(myRs.next())
                {
                    s1 = (myRs.getString(1)).toUpperCase();
                    selEPentg();                

                    EPentg1.setText(Integer.toString(myRs.getInt(2)));
                    EPentg2.setText(Integer.toString(myRs.getInt(3)));
                    EPentg3.setText(Integer.toString(myRs.getInt(4)));
                    EPentg4.setText(Integer.toString(myRs.getInt(5)));
                    EPentg5.setText(Integer.toString(myRs.getInt(6)));
                    EPentg6.setText(Integer.toString(myRs.getInt(7)));
                    EPentg7.setText(Integer.toString(myRs.getInt(8)));
                    EPentg8.setText(Integer.toString(myRs.getInt(9)));
                    
                    e1 = myRs.getInt(2);
                    e2 = myRs.getInt(3);
                    e3 = myRs.getInt(4);
                    e4 = myRs.getInt(5);
                    e5 = myRs.getInt(6);
                    e6 = myRs.getInt(7);
                    e7 = myRs.getInt(8);
                    e8 = myRs.getInt(9);

                    delEPentg();

                } 

            }
            catch(Exception n)
            {
                System.out.println("check UG");
                n.printStackTrace();
            }
        }
        
        else if(o == 0)
        {
            try // to fill PG
            {
                Statement myStmt = n.createStatement();
                ResultSet myRs = myStmt.executeQuery("select * from studentinfoschema.pg_info where name = '" + Editing1Controller.oldName +"';");

                while(myRs.next())
                {
                    s1 = (myRs.getString(1)).toUpperCase();

                    selPPentg();                

                    p1 = myRs.getInt(2);
                    p2 = myRs.getInt(3);
                    p3 = myRs.getInt(4);
                    p4 = myRs.getInt(5);

                    PPentg1.setText(Integer.toString(myRs.getInt(2)));
                    PPentg2.setText(Integer.toString(myRs.getInt(3)));
                    PPentg3.setText(Integer.toString(myRs.getInt(4)));
                    PPentg4.setText(Integer.toString(myRs.getInt(5)));
                    
                    delPPentg();
                } 

            }
            catch(Exception n)
            {
                System.out.println("check PG");
                n.printStackTrace();
            }
        }
    }
    
    
    /////////////////////////////////////////////**Secondary School Fields**///////////////
    static int s3, s2, s8;
    
    static String s4, s5, s6, s7;
    
    @FXML
    private JFXTextField SPass;
    public void getSPass()
    {    
        try
        {
            SPass.setStyle("-fx-border-color: #ffffff; -fx-text-fill: white; -fx-prompt-text-fill: white;");
            s2 = Integer.parseInt(SPass.getText());
            System.out.println(s2);     
        }
        catch(Exception e)
        {
            SPass.setText(null);
            SPass.setStyle("-fx-border-color: #ff2323; -fx-text-fill: white; -fx-prompt-text-fill: white;");
        }
    }
    
    @FXML
    private JFXTextField SRoll;
    public void getSRoll()
    {   
        try
        {
            SRoll.setStyle("-fx-border-color: #ffffff; -fx-text-fill: white; -fx-prompt-text-fill: white;");
            s3 = Integer.parseInt(SRoll.getText());
            System.out.println(s3);     
        }
        catch(Exception e)
        {
            SRoll.setText(null);
            SRoll.setStyle("-fx-border-color: #ff2323; -fx-text-fill: white; -fx-prompt-text-fill: white;");
        }
    }
    
        
    @FXML
    private MenuButton SBrdDrpDwn;
         
    @FXML
    private MenuItem Scbse;

    @FXML
    private MenuItem Scisce;
    
    @FXML
    private MenuItem Sstate;

    @FXML
    private MenuItem Sibo;
    
    @FXML
    private MenuItem Scie;
    
    public void chzSBrdDrpDwn()
    {
              
       Scbse.setOnAction(new EventHandler<ActionEvent>() 
       {
            public void handle(ActionEvent t) 
            {
                SBrdDrpDwn.setText("CBSE");
                String ab  = "CBSE";
                s4 = "'"+ab+"'";
                System.out.println(s4);

            }
       } );
       
       Scisce.setOnAction(new EventHandler<ActionEvent>() 
       {
            public void handle(ActionEvent t) 
            {
                SBrdDrpDwn.setText("CISCE");
                String ab  = "CISCE";
                s4 = "'"+ab+"'";   
                System.out.println(s4);
            }
       } );
       
       Sstate.setOnAction(new EventHandler<ActionEvent>() 
       {
            public void handle(ActionEvent t) 
            {
                SBrdDrpDwn.setText("STATE");
                String ab  = "STATE";
                s4 = "'"+ab+"'";
                System.out.println(s4);
            }
       } );
       
       Sibo.setOnAction(new EventHandler<ActionEvent>() 
       {
            public void handle(ActionEvent t) 
            {
                SBrdDrpDwn.setText("IBO");
                String ab  = "IBO";
                s4 = "'"+ab+"'";
                System.out.println(s4);
            }
       } );
       
       Scie.setOnAction(new EventHandler<ActionEvent>() 
       {
            public void handle(ActionEvent t) 
            {
                SBrdDrpDwn.setText("CIE");
                String ab  = "CIE";
                s4 = "'"+ab+"'";
                System.out.println(s4);
            }
       } );
    }
    
    @FXML
    private JFXTextField SMed;
    public void getSMed()
    {   
        String l = SMed.getText();
        if(l.matches("[a-zA-Z]+") == false || l.length() == 0)
        { 
            SMed.setText(null);
            SMed.setStyle("-fx-border-color: #ff2323; -fx-text-fill: white; -fx-prompt-text-fill: white;");
            System.out.println("false"); 
            s5 = null;
        } 
        else 
        { 
            SMed.setStyle("-fx-border-color: #ffffff; -fx-text-fill: white; -fx-prompt-text-fill: white;");
            s5 = "'"+l+"'";
            System.out.println(s5);
        }
    }
    
    @FXML
    private JFXTextField SSch;
    public void getSSch()
    {    
        String l = SSch.getText();
        if(l.matches("[a-zA-Z]+") == false || l.length() == 0)
        { 
            SSch.setText(null);
            SSch.setStyle("-fx-border-color: #ff2323; -fx-text-fill: white; -fx-prompt-text-fill: white;");
            System.out.println("false"); 
            s6 = null;
            
        } 
        else 
        { 
            SSch.setStyle("-fx-border-color: #ffffff; -fx-text-fill: white; -fx-prompt-text-fill: white;");
            s6 = "'"+l+"'";
            System.out.println(s6);
        }
    }
    
    
    @FXML
    private JFXTextField SCity;
    public void getSCity()
    {   
        String l = SCity.getText();
        if(l.matches("[a-zA-Z]+") == false || l.length() == 0)
        { 
            SCity.setText(null);
            SCity.setStyle("-fx-border-color: #ff2323; -fx-text-fill: white; -fx-prompt-text-fill: white;");
            System.out.println("false"); 
            s7 = null;
        } 
        else 
        { 
            SCity.setStyle("-fx-border-color: #ffffff; -fx-text-fill: white; -fx-prompt-text-fill: white;");
            s7 = "'"+l+"'";
            System.out.println(s7);
        }
    }
    
    @FXML
    private JFXTextField SPentg;
    public void getSPtng()
    {          
        try
        {
            SPentg.setStyle("-fx-border-color: #ffffff; -fx-text-fill: white; -fx-prompt-text-fill: white;");
            s8 = Integer.parseInt(SPentg.getText());
            System.out.println(s8);     
        }
        catch(Exception e)
        {
            SPentg.setText(null);
            SPentg.setStyle("-fx-border-color: #ff2323; -fx-text-fill: white; -fx-prompt-text-fill: white;");
        }
    }

    
    ///////////////////////////////////
    
    static int HD;
    
    @FXML
    private MenuButton PostSS;
          
    @FXML
    private MenuItem HSSC;
      
    @FXML
    private MenuItem DIPLOMA;
 
    public void chzPostSSDwn()
    {
                
       if(Editing1Controller.ui == 1)
       {
            HSSC.setOnAction(new EventHandler<ActionEvent>() 
            {
                public void handle(ActionEvent t) 
                {
                    PostSS.setText("HSSC");
                    HD = 0;
                    DPane.setVisible(false);
                    HPane.setVisible(true);
                }
           }
           );


           DIPLOMA.setOnAction(new EventHandler<ActionEvent>() 
           {
                public void handle(ActionEvent t) 
                {
                    PostSS.setText("DIPLOMA");
                    HD = 1;
                    HPane.setVisible(false);
                    DPane.setVisible(true);
                }
           }
           );
        }
    }
    
    ///////////////////////////////////////////**High School Fields**/////////////////////////
    
    @FXML
    private Pane HPane;
    
    static int t2, t3, t8, t9, t10, t11;
    static String t4, t5, t6, t7;
    
    @FXML
    private JFXTextField HPass;
    public void getHPass()
    {              
        try
        {
            int l = Integer.parseInt(HPass.getText());
            if( l-s2 >= 2)
            {
                HPass.setStyle("-fx-border-color: #ffffff; -fx-text-fill: white; -fx-prompt-text-fill: white;");
                t2 = l;
                System.out.println(t2);
            }
            else
            {
                HPass.setText(null);
                HPass.setStyle("-fx-border-color: #ff2323; -fx-text-fill: white; -fx-prompt-text-fill: white;");
                System.out.println("check");

            }
        }    
        catch(Exception e)
        {
            HPass.setText(null);
            HPass.setStyle("-fx-border-color: #ff2323; -fx-text-fill: white; -fx-prompt-text-fill: white;");
        }
        
    }
    
    @FXML
    private JFXTextField HRoll;
    public void getHRoll()
    {         
        try
        {
            HRoll.setStyle("-fx-border-color: #ffffff; -fx-text-fill: white; -fx-prompt-text-fill: white;");
            t3 = Integer.parseInt(HRoll.getText());
            System.out.println(t3);     
        }
        catch(Exception e)
        {
            HRoll.setText(null);
            HRoll.setStyle("-fx-border-color: #ff2323; -fx-text-fill: white; -fx-prompt-text-fill: white;");
        }
    }
    
    @FXML
    private MenuButton HBrdDrpDwn;
         
    @FXML
    private MenuItem Hcbse;

    @FXML
    private MenuItem Hcisce;
    
    @FXML
    private MenuItem Hstate;

    @FXML
    private MenuItem Hibo;
    
    @FXML
    private MenuItem Hcie;
    
    public void chzHBrdDrpDwn()
    {
              
       Hcbse.setOnAction(new EventHandler<ActionEvent>() 
       {
            public void handle(ActionEvent t) 
            {
                HBrdDrpDwn.setText("CBSE");
                String ab  = "CBSE";
                t4 = "'"+ab+"'";
                System.out.println(t4);

            }
       } );
       
       Hcisce.setOnAction(new EventHandler<ActionEvent>() 
       {
            public void handle(ActionEvent t) 
            {
                HBrdDrpDwn.setText("CISCE");
                String ab  = "CISCE";
                t4 = "'"+ab+"'";   
                System.out.println(t4);
            }
       } );
       
       Hstate.setOnAction(new EventHandler<ActionEvent>() 
       {
            public void handle(ActionEvent t) 
            {
                HBrdDrpDwn.setText("STATE");
                String ab  = "STATE";
                t4 = "'"+ab+"'";
                System.out.println(t4);
            }
       } );
       
       Hibo.setOnAction(new EventHandler<ActionEvent>() 
       {
            public void handle(ActionEvent t) 
            {
                HBrdDrpDwn.setText("IBO");
                String ab  = "IBO";
                t4 = "'"+ab+"'";
                System.out.println(t4);
            }
       } );
       
       Hcie.setOnAction(new EventHandler<ActionEvent>() 
       {
            public void handle(ActionEvent t) 
            {
                HBrdDrpDwn.setText("CIE");
                String ab  = "CIE";
                t4 = "'"+ab+"'";
                System.out.println(t4);
            }
       } );
    }
        
    @FXML
    private JFXTextField HMed;
    public void getHMed()
    {   
        String l = HMed.getText();
        if(l.matches("[a-zA-Z]+") == false || l.length() == 0)
        { 
            HMed.setText(null);
            HMed.setStyle("-fx-border-color: #ff2323; -fx-text-fill: white; -fx-prompt-text-fill: white;");
            System.out.println("false"); 
            t5 = null;
        } 
        else 
        { 
            HMed.setStyle("-fx-border-color: #ffffff; -fx-text-fill: white; -fx-prompt-text-fill: white;");
            t5 = "'"+l+"'";
            System.out.println(t5);
        }
    }
    
    @FXML
    private JFXTextField HSch;
    public void getHSch()
    {   
        String l = HSch.getText();
        if(l.matches("[a-zA-Z]+") == false || l.length() == 0)
        { 
            HSch.setText(null);
            HSch.setStyle("-fx-border-color: #ff2323; -fx-text-fill: white; -fx-prompt-text-fill: white;");
            System.out.println("false"); 
            t6 = null;
        } 
        else 
        { 
            HSch.setStyle("-fx-border-color: #ffffff; -fx-text-fill: white; -fx-prompt-text-fill: white;");
            t6 = "'"+l+"'";
            System.out.println(t6);
        }
    }
    
    @FXML
    private JFXTextField HCity;
    public void getHCity()
    {   
        String l = HCity.getText();
        if(l.matches("[a-zA-Z]+") == false || l.length() == 0)
        { 
            HCity.setText(null);
            HCity.setStyle("-fx-border-color: #ff2323; -fx-text-fill: white; -fx-prompt-text-fill: white;");
            System.out.println("false"); 
            t7 = null;
        } 
        else 
        { 
            HCity.setStyle("-fx-border-color: #ffffff; -fx-text-fill: white; -fx-prompt-text-fill: white;");
            t7 = "'"+l+"'";
            System.out.println(t7);
        }
    }
    
    @FXML
    private JFXTextField HPentg;
    public void getHPentg()
    {   
        try
        {
            HPentg.setStyle("-fx-border-color: #ffffff; -fx-text-fill: white; -fx-prompt-text-fill: white;");
            t8 = Integer.parseInt(HPentg.getText());
            System.out.println(t8);       
        }
        catch(Exception e)
        {
            HPentg.setText(null);
            HPentg.setStyle("-fx-border-color: #ff2323; -fx-text-fill: white; -fx-prompt-text-fill: white;");
        }
    }
    
    @FXML
    private TextField HP;
    public void getHP()
    {    
        try
        {   
            t9 = Integer.parseInt(HP.getText());
            System.out.println(t9);     
        }
        catch(Exception e)
        {
            HP.setText(null);
            
        }
    }
    
    @FXML
    private TextField HC;
    public void getHC()
    {   
        try
        {    
            t10 = Integer.parseInt(HC.getText());
            System.out.println(t10);      
        }
        catch(Exception e)
        {
            HC.setText(null);
            
        }
    }
    
    @FXML
    private TextField HM;
    public void getHM()
    {    
        try
        {
            t11 = Integer.parseInt(HM.getText());
            System.out.println(t11);   
        }
        catch(Exception e)
        {
            HM.setText(null);
            
        }
    }
    
    ////////////////////////// Diploma Fields //////////////////////
    
    @FXML
    private Pane DPane;
    
    static int d1, d2, d3, d4, d5, d6;    
    
    @FXML
    private JFXTextField DPentg1;
    
    @FXML
    private JFXTextField DPentg2;
    
    @FXML
    private JFXTextField DPentg3;
    
    @FXML
    private JFXTextField DPentg4;
    
    @FXML
    private JFXTextField DPentg5;
    
    @FXML
    private JFXTextField DPentg6;
    
    
    public void getDPentg1()
    {   
         
        try
        {
            DPentg1.setStyle("-fx-border-color: #ffffff; -fx-text-fill: white; -fx-prompt-text-fill: white;");
            d1 = Integer.parseInt(DPentg1.getText());
            System.out.println(d1);     
        }
        catch(Exception e)
        {
            DPentg1.setText(null);
            DPentg1.setStyle("-fx-border-color: #ff2323; -fx-text-fill: white; -fx-prompt-text-fill: white;");
        }
    }
    
    public void getDPentg2()
    {   

        try
        {
            DPentg2.setStyle("-fx-border-color: #ffffff; -fx-text-fill: white; -fx-prompt-text-fill: white;");
            d2 = Integer.parseInt(DPentg2.getText());
            System.out.println(d2);    
        }
        catch(Exception e)
        {
            DPentg2.setText(null);
            DPentg2.setStyle("-fx-border-color: #ff2323; -fx-text-fill: white; -fx-prompt-text-fill: white;");
        }
    }
    
    public void getDPentg3()
    {   

        try
        {
            DPentg3.setStyle("-fx-border-color: #ffffff; -fx-text-fill: white; -fx-prompt-text-fill: white;");
            d3 = Integer.parseInt(DPentg3.getText());
            System.out.println(d3);      
        }
        catch(Exception e)
        {
            DPentg3.setText(null);
            DPentg3.setStyle("-fx-border-color: #ff2323; -fx-text-fill: white; -fx-prompt-text-fill: white;");
        }
    }
    
    public void getDPentg4()
    {   
 
        try
        {
            DPentg4.setStyle("-fx-border-color: #ffffff; -fx-text-fill: white; -fx-prompt-text-fill: white;");
            d4 = Integer.parseInt(DPentg4.getText());
            System.out.println(d4);     
        }
        catch(Exception e)
        {
            DPentg4.setText(null);
            DPentg4.setStyle("-fx-border-color: #ff2323; -fx-text-fill: white; -fx-prompt-text-fill: white;");
        }
        
    }
    
    public void getDPentg5()
    {   
        try
        {
            DPentg5.setStyle("-fx-border-color: #ffffff; -fx-text-fill: white; -fx-prompt-text-fill: white;");
            d5 = Integer.parseInt(DPentg5.getText());
            System.out.println(d5);      
        }
        catch(Exception e)
        {
            DPentg5.setText(null);
            DPentg5.setStyle("-fx-border-color: #ff2323; -fx-text-fill: white; -fx-prompt-text-fill: white;");
        }
        
    }
    
    public void getDPentg6()
    {  
        try
        {
            DPentg6.setStyle("-fx-border-color: #ffffff; -fx-text-fill: white; -fx-prompt-text-fill: white;");
            d6 = Integer.parseInt(DPentg6.getText());
            System.out.println(d6);       
        }
        catch(Exception e)
        {
            DPentg6.setText(null);
            DPentg6.setStyle("-fx-border-color: #ff2323; -fx-text-fill: white; -fx-prompt-text-fill: white;");
        }
    }
        
    //////////////////////////////////////////////////////////
    public void hide(int o)
    {   
        if(o == 1)
        {
            EPentg1.setDisable(true);
            EPentg2.setDisable(true);
            EPentg3.setDisable(true);
            EPentg4.setDisable(true);
            EPentg5.setDisable(true);
            EPentg6.setDisable(true);
            EPentg7.setDisable(true);
            EPentg8.setDisable(true);

        }
        if(o == 2)
        {
            PPentg1.setDisable(true);
            PPentg2.setDisable(true);
            PPentg3.setDisable(true);
            PPentg4.setDisable(true);
           
        }
    }
    
    int j, o;
    ////////////////////////////Engineering Fields/////////////////////
        
    @FXML
    private static Pane EPane;

    @FXML
    private JFXTextField EPentg1;
    
    @FXML
    private JFXTextField EPentg2;
    
    @FXML
    private JFXTextField EPentg3;
    
    @FXML
    private JFXTextField EPentg4;
    
    @FXML
    private JFXTextField EPentg5;
    
    @FXML
    private JFXTextField EPentg6;
    
    @FXML
    private JFXTextField EPentg7;
    
    @FXML
    private JFXTextField EPentg8;

    static int e1, e2, e3, e4, e5, e6, e7, e8;
    
    public void getEPentg1()
    {   
          
        try
        {
            EPentg1.setStyle("-fx-border-color: #ffffff; -fx-text-fill: white; -fx-prompt-text-fill: white;");
            e1 = Integer.parseInt(EPentg1.getText());
            System.out.println(e1);     
        }
        catch(Exception e)
        {
            EPentg1.setText(null);
            EPentg1.setStyle("-fx-border-color: #ff2323; -fx-text-fill: white; -fx-prompt-text-fill: white;");
        }
    }
    
    public void getEPentg2()
    {   
        
        try
        {
            EPentg2.setStyle("-fx-border-color: #ffffff; -fx-text-fill: white; -fx-prompt-text-fill: white;");
            e2 = Integer.parseInt(EPentg2.getText());
            System.out.println(e2);      
        }
        catch(Exception e)
        {
            EPentg2.setText(null);
            EPentg2.setStyle("-fx-border-color: #ff2323; -fx-text-fill: white; -fx-prompt-text-fill: white;");
        }
        
    }
    
    public void getEPentg3()
    {   
         
        try
        {
            EPentg3.setStyle("-fx-border-color: #ffffff; -fx-text-fill: white; -fx-prompt-text-fill: white;");
            e3 = Integer.parseInt(EPentg3.getText());
            System.out.println(e3);     
        }
        catch(Exception e)
        {
            EPentg3.setText(null);
            EPentg3.setStyle("-fx-border-color: #ff2323; -fx-text-fill: white; -fx-prompt-text-fill: white;");
        }
    }
    
    public void getEPentg4()
    {   
        
        try
        {
            EPentg4.setStyle("-fx-border-color: #ffffff; -fx-text-fill: white; -fx-prompt-text-fill: white;");
            e4 = Integer.parseInt(EPentg4.getText());
            System.out.println(e4);      
        }
        catch(Exception e)
        {
            EPentg4.setText(null);
            EPentg4.setStyle("-fx-border-color: #ff2323; -fx-text-fill: white; -fx-prompt-text-fill: white;");
        }
    }
    
    public void getEPentg5()
    {   
            
        try
        {
            EPentg5.setStyle("-fx-border-color: #ffffff; -fx-text-fill: white; -fx-prompt-text-fill: white;");
            e5 = Integer.parseInt(EPentg5.getText());
            System.out.println(e5);    
        }
        catch(Exception e)
        {
            EPentg5.setText(null);
            EPentg5.setStyle("-fx-border-color: #ff2323; -fx-text-fill: white; -fx-prompt-text-fill: white;");
        }
    }
    
    public void getEPentg6()
    {   

        try
        {
            EPentg6.setStyle("-fx-border-color: #ffffff; -fx-text-fill: white; -fx-prompt-text-fill: white;");
            e6 = Integer.parseInt(EPentg6.getText());
            System.out.println(e6);     
        }
        catch(Exception e)
        {
            EPentg6.setText(null);
            EPentg6.setStyle("-fx-border-color: #ff2323; -fx-text-fill: white; -fx-prompt-text-fill: white;");
        }
    }
    
    public void getEPentg7()
    {   
        
        try
        {
            EPentg7.setStyle("-fx-border-color: #ffffff; -fx-text-fill: white; -fx-prompt-text-fill: white;");
            e7 = Integer.parseInt(EPentg7.getText());
            System.out.println(e7);     
        }
        catch(Exception e)
        {
            EPentg7.setText(null);
            EPentg7.setStyle("-fx-border-color: #ff2323; -fx-text-fill: white; -fx-prompt-text-fill: white;");
        }
        
    }
    
    public void getEPentg8()
    {   

        try
        {
            EPentg8.setStyle("-fx-border-color: #ffffff; -fx-text-fill: white; -fx-prompt-text-fill: white;");
            e8 = Integer.parseInt(EPentg8.getText());
            System.out.println(e8);     
        }
        catch(Exception e)
        {
            EPentg8.setText(null);
            EPentg8.setStyle("-fx-border-color: #ff2323; -fx-text-fill: white; -fx-prompt-text-fill: white;");
        }
    }
    
    @FXML
    private List<JFXTextField> EList; //see Editing2.fxml to more info
    
    public void selEPentg()
    { 
        for(int count = 0; count<j-1 && o == 1; count++)
        {
            EList.get(count).setDisable(false);
        }
    }
    
    public void delEPentg()
    { 
        for(int count = 7; count >= j-1 && o == 1; count--)
        {
            EList.get(count).setText(null);
        }
    }
    
    //////////////////////////////////////Postgraduation Fields///////////////////////////
      
    @FXML
    private static Pane PPane;

    @FXML
    private JFXTextField PPentg1; 
    
    @FXML
    private JFXTextField PPentg2;
    
    @FXML
    private JFXTextField PPentg3;
    
    @FXML
    private JFXTextField PPentg4;
    
    static int p1, p2, p3, p4;
    
    
    
    public void getPPentg1()
    {    
        try
        {
            PPentg1.setStyle("-fx-border-color: #ffffff; -fx-text-fill: white; -fx-prompt-text-fill: white;");
            p1 = Integer.parseInt(PPentg1.getText());
            System.out.println(p1);    
        }
        catch(Exception e)
        {
            PPentg1.setText(null);
            PPentg1.setStyle("-fx-border-color: #ff2323; -fx-text-fill: white; -fx-prompt-text-fill: white;");
        }
    }
    
    public void getPPentg2()
    {   
        
        try
        {
            PPentg2.setStyle("-fx-border-color: #ffffff; -fx-text-fill: white; -fx-prompt-text-fill: white;");
            p2 = Integer.parseInt(PPentg2.getText());
            System.out.println(p2);      
        }
        catch(Exception e)
        {
            PPentg2.setText(null);
            PPentg2.setStyle("-fx-border-color: #ff2323; -fx-text-fill: white; -fx-prompt-text-fill: white;");
        }
    }
    
    public void getPPentg3()
    {   
        
        try
        {
            PPentg3.setStyle("-fx-border-color: #ffffff; -fx-text-fill: white; -fx-prompt-text-fill: white;");
            p3 = Integer.parseInt(PPentg3.getText());
            System.out.println(p3);     
        }
        catch(Exception e)
        {
            PPentg3.setText(null);
            PPentg3.setStyle("-fx-border-color: #ff2323; -fx-text-fill: white; -fx-prompt-text-fill: white;");
        }
        
    }
    
    public void getPPentg4()
    {   
           
        try
        {
            PPentg4.setStyle("-fx-border-color: #ffffff; -fx-text-fill: white; -fx-prompt-text-fill: white;");
            p4 = Integer.parseInt(PPentg4.getText());
            System.out.println(p4);      
        }
        catch(Exception e)
        {
            PPentg4.setText(null);
            PPentg4.setStyle("-fx-border-color: #ff2323; -fx-text-fill: white; -fx-prompt-text-fill: white;");
        }
    }
    
    @FXML
    private List<JFXTextField> PList; //see Editing2.fxml to more info
    
    public void selPPentg()
    { 
        for(int count = 0; count<j-1 && o == 0; count++)
        {
            PList.get(count).setDisable(false);
        }
    }
    
    public void delPPentg()
    { 
        for(int count = 3; count <= j-1 && o == 0; count--)
        {
            PList.get(count).setText(null);
        }
    }
    
    //////////////////////////////////////////////////////////
   
    
    public static void setValues()
    {       
        DatabaseIO xyz = new DatabaseIO();
        xyz.setSscinfo("'"+s1+"'", s2, s3, s4, s5, s6, s7, s8); 
        xyz.setHsscinfo("'"+s1+"'",  t2,  t3,  t4,  t5,  t6,  t7,  t8,  t11,  t10, t9);
        xyz.setDipinfo("'"+s1+"'", d1, d2, d3, d4, d5, d6);
        xyz.setUginfo("'"+s1+"'", e1, e2, e3, e4, e5, e6, e7, e8);
        xyz.setPginfo("'"+s1+"'", p1, p2, p3, p4);
    }
    
    public static void upValues()
    {       
        DatabaseIO xyz = new DatabaseIO();
        xyz.UpSscinfo("'"+s1+"'", s2, s3, s4, s5, s6, s7, s8); 
        xyz.UpHsscinfo("'"+s1+"'",  t2,  t3,  t4,  t5,  t6,  t7,  t8,  t11,  t10, t9);
        xyz.UpDipinfo("'"+s1+"'", d1, d2, d3, d4, d5, d6);
        xyz.UpUginfo("'"+s1+"'", e1, e2, e3, e4, e5, e6, e7, e8);
        xyz.UpPginfo("'"+s1+"'", p1, p2, p3, p4);
    }
    
    public void delEdit(MouseEvent event)
    {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Delete data");
        alert.setHeaderText("Are you sure you want to delete data of "+ Editing1Controller.oldName+ "?");
        alert.setContentText("If you delete this, it will be removed from database.");

        Optional<ButtonType> result = alert.showAndWait();
        if (result.get() == ButtonType.OK)
        {
            DatabaseIO d = new DatabaseIO();
            d.DelBasicinfo();

            try
            {
                Parent editPag1 = FXMLLoader.load(getClass().getResource("HomePage.fxml"));
                Scene editPg1Scene = new Scene(editPag1);
                Stage appStage = (Stage)((Node)event.getSource()).getScene().getWindow();
                appStage.setScene(editPg1Scene);
                appStage.show();
            }
            catch(Exception e)
            {
                e.printStackTrace();
            }
        } 
        else 
        {
            // ... user chose CANCEL or closed the dialog
        }
    }
    
    @FXML
    private Pane Edit2;
    
    
    @FXML
    public static Label BtnTo1;
    
    public void toEdit1(MouseEvent event)
     {  
        try 
        {
            Parent editPag1 = FXMLLoader.load(getClass().getResource("Editing1.fxml"));
            Scene editPg1Scene = new Scene(editPag1);
            Stage appStage = (Stage)((Node)event.getSource()).getScene().getWindow();
            appStage.setScene(editPg1Scene);
            appStage.show();
        } 
        catch (Exception ex) 
        {
            ex.printStackTrace();
            
        }
    }
    
    @FXML
    private Label BtnTo3;  
    
    public void toEdit3(MouseEvent event)
    {
        
        try 
        {
            Parent editPag1 = FXMLLoader.load(getClass().getResource("Editing3.fxml"));
            Scene editPg1Scene = new Scene(editPag1);
            Stage appStage = (Stage)((Node)event.getSource()).getScene().getWindow();
            appStage.setScene(editPg1Scene);
            appStage.show();
        } 
        catch (Exception ex) 
          {
            ex.printStackTrace();
          }
    }
    
    @FXML
    private Label bck;
    
    public void bck2HP(MouseEvent event)
    {
        try 
        {
            Parent editPag1 = FXMLLoader.load(getClass().getResource("HomePage.fxml"));
            Scene editPg1Scene = new Scene(editPag1);
            Stage appStage = (Stage)((Node)event.getSource()).getScene().getWindow();
            appStage.setScene(editPg1Scene);
            appStage.show();
        } 
        catch (Exception ex) 
        {
          ex.printStackTrace();
        }
    }
    
}
