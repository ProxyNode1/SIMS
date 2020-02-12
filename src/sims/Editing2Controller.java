
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
    
    Connection n = null;
    
    public static int i, h;
    public int a;
    
    static String s1;
    
    @FXML
    private Pane Edit2;
    
    ///////////////////////////// Secondary School Variables /////////////////////
    
    static int s3, s2, s8;
    
    static String s4, s5, s6, s7;
    
    @FXML
    private JFXTextField sPassYear;
    
    @FXML
    private JFXTextField sRNo;
    
    @FXML
    private MenuButton sBoard;
    
    @FXML
    private MenuItem scbse;

    @FXML
    private MenuItem scisce;
    
    @FXML
    private MenuItem sstate;

    @FXML
    private MenuItem sibo;
    
    @FXML
    private MenuItem scie;
    
    @FXML
    private JFXTextField sMedium;
    
    @FXML
    private JFXTextField sSchool;
    
    @FXML
    private JFXTextField sCity;
    
    @FXML
    private JFXTextField sPercent;
    
    /////////////////////////////////// POST SSC Drop Down Menu /////////////////////
    
    static int HD;
    
    @FXML
    private MenuButton PostSS;
             
    ///////////////////////////// High School Variables /////////////////////
    
    static int t2, t3, t8, t9, t10, t11;
    static String t4, t5, t6, t7;
    
    @FXML
    private MenuItem HSSC;
    
    @FXML
    private Pane HPane;
      
    @FXML
    private JFXTextField hPassYear;
    
    @FXML
    private JFXTextField hRNo;
    
    @FXML
    private MenuButton hBoard;
         
    @FXML
    private MenuItem hcbse;

    @FXML
    private MenuItem hcisce;
    
    @FXML
    private MenuItem hstate;

    @FXML
    private MenuItem hibo;
    
    @FXML
    private MenuItem hcie;
    
    @FXML
    private JFXTextField hMedium;
    
    @FXML
    private JFXTextField hSchool;
    
    @FXML
    private JFXTextField hCity;
    
    @FXML
    private JFXTextField hPercent;
    
    @FXML
    private TextField hphysics;
    
    @FXML
    private TextField hchemistry;
    
    @FXML
    private TextField hmath;
    
    ///////////////////////////// Diploma School Variables /////////////////////
    
    @FXML
    private MenuItem DIPLOMA;
    
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
    
    ///////////////////////////// UG School Variables /////////////////////
    
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
    
    ///////////////////////////// PG School Variables /////////////////////
        
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
    
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) 
    {
        Edit2.requestFocus();
        
        //IdFld.setStyle("-fx-border-color: #ff2323; -fx-text-fill: white; -fx-prompt-text-fill: white;"); when error occurs or not filled
        
        //chzHBrdDrpDwn();
        //chzSBrdDrpDwn();
        
        /*s1 = Editing1Controller.newName;
        System.out.println(s1);
        
        j = Editing1Controller.useSem;
        System.out.println(j);
        
        o = Editing1Controller.up;
        hide(o);*/
        
        
                
        //chzPostSSDwn();
       
        //selEPentg();
        //selPPentg();
        
        //SSch.setTooltip(new Tooltip("Do not use , or ."));
        //HSch.setTooltip(new Tooltip("Do not use , or ."));
        
        //n = DatabaseCon.connect();
        //operation();
        
    }  
       
    
    /*void insert()
    {
        s2 = 0; s3 = 0; s8 = 0; t2 = 0; t3 = 0; t8 = 0; t9 = 0; t10 = 0; t11 = 0; d1 = 0; d2 = 0; d3 = 0; d4 = 0; d5 = 0; d6 = 0;
        e1 = 0; e2 = 0; e3 = 0; e4 = 0; e5 = 0; e6 = 0; e7 = 0; e8 = 0; p1 = 0; p2 = 0; p3 = 0; p4 = 0;
        s4 = null; s5 = null; s6 = null; s7 = null; t4 = null; t5 = null; t6 = null; t7 = null; 
        
        delData.setVisible(false);
       
    }*/
    
       
    /////////////////////////////////////////////**Secondary School Fields**///////////////
        
    public void getSPassYear()
    {    
        try
        {
            sPassYear.setStyle("-fx-border-color: #ffffff; -fx-text-fill: white; -fx-prompt-text-fill: white;");
            s2 = Integer.parseInt(sPassYear.getText());
            System.out.println(s2);     
        }
        catch(Exception e)
        {
            sPassYear.setText(null);
            sPassYear.setStyle("-fx-border-color: #ff2323; -fx-text-fill: white; -fx-prompt-text-fill: white;");
        }
    }
    
    
    public void getSRNo()
    {   
        try
        {
            sRNo.setStyle("-fx-border-color: #ffffff; -fx-text-fill: white; -fx-prompt-text-fill: white;");
            s3 = Integer.parseInt(sRNo.getText());
            System.out.println(s3);     
        }
        catch(Exception e)
        {
            sRNo.setText(null);
            sRNo.setStyle("-fx-border-color: #ff2323; -fx-text-fill: white; -fx-prompt-text-fill: white;");
        }
    }
    
    public void getSBoard()
    {
              
       scbse.setOnAction(new EventHandler<ActionEvent>() 
       {
            public void handle(ActionEvent t) 
            {
                sBoard.setText("CBSE");
                String ab  = "CBSE";
                s4 = "'"+ab+"'";
                System.out.println(s4);

            }
       } );
       
       scisce.setOnAction(new EventHandler<ActionEvent>() 
       {
            public void handle(ActionEvent t) 
            {
                sBoard.setText("CISCE");
                String ab  = "CISCE";
                s4 = "'"+ab+"'";   
                System.out.println(s4);
            }
       } );
       
       sstate.setOnAction(new EventHandler<ActionEvent>() 
       {
            public void handle(ActionEvent t) 
            {
                sBoard.setText("STATE");
                String ab  = "STATE";
                s4 = "'"+ab+"'";
                System.out.println(s4);
            }
       } );
       
       sibo.setOnAction(new EventHandler<ActionEvent>() 
       {
            public void handle(ActionEvent t) 
            {
                sBoard.setText("IBO");
                String ab  = "IBO";
                s4 = "'"+ab+"'";
                System.out.println(s4);
            }
       } );
       
       scie.setOnAction(new EventHandler<ActionEvent>() 
       {
            public void handle(ActionEvent t) 
            {
                sBoard.setText("CIE");
                String ab  = "CIE";
                s4 = "'"+ab+"'";
                System.out.println(s4);
            }
       } );
    }
    
    
    public void getSMedium()
    {   
        String l = sMedium.getText();
        if(l.matches("[a-zA-Z]+") == false || l.length() == 0)
        { 
            sMedium.setText(null);
            sMedium.setStyle("-fx-border-color: #ff2323; -fx-text-fill: white; -fx-prompt-text-fill: white;");
            System.out.println("false"); 
            s5 = null;
        } 
        else 
        { 
            sMedium.setStyle("-fx-border-color: #ffffff; -fx-text-fill: white; -fx-prompt-text-fill: white;");
            s5 = "'"+l+"'";
            System.out.println(s5);
        }
    }
    
    
    public void getSSchool()
    {    
        String l = sSchool.getText();
        if(l.matches("[a-zA-Z]+") == false || l.length() == 0)
        { 
            sSchool.setText(null);
            sSchool.setStyle("-fx-border-color: #ff2323; -fx-text-fill: white; -fx-prompt-text-fill: white;");
            System.out.println("false"); 
            s6 = null;
            
        } 
        else 
        { 
            sSchool.setStyle("-fx-border-color: #ffffff; -fx-text-fill: white; -fx-prompt-text-fill: white;");
            s6 = "'"+l+"'";
            System.out.println(s6);
        }
    }
    
    
    
    public void getSCity()
    {   
        String l = sCity.getText();
        if(l.matches("[a-zA-Z]+") == false || l.length() == 0)
        { 
            sCity.setText(null);
            sCity.setStyle("-fx-border-color: #ff2323; -fx-text-fill: white; -fx-prompt-text-fill: white;");
            System.out.println("false"); 
            s7 = null;
        } 
        else 
        { 
            sCity.setStyle("-fx-border-color: #ffffff; -fx-text-fill: white; -fx-prompt-text-fill: white;");
            s7 = "'"+l+"'";
            System.out.println(s7);
        }
    }
    
    
    public void getSPercent()
    {          
        try
        {
            sPercent.setStyle("-fx-border-color: #ffffff; -fx-text-fill: white; -fx-prompt-text-fill: white;");
            s8 = Integer.parseInt(sPercent.getText());
            System.out.println(s8);     
        }
        catch(Exception e)
        {
            sPercent.setText(null);
            sPercent.setStyle("-fx-border-color: #ff2323; -fx-text-fill: white; -fx-prompt-text-fill: white;");
        }
    }

    
    //////////////////////////////// **Post SSC Drop Down** ////////////////////////
 
    /*public void chzPostSSDwn()
    {
                
       if(Editing1Controller.ui == 1)
       {
            HSSC.setOnAction(new EventHandler<ActionEvent>() 
            {
                public void handle(ActionEvent t) 
                {
                    PostSS.setText("HSC");
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
    }*/
    
    
    ///////////////////////////////////////////**High School Fields**/////////////////////////
        
    public void getHPassYear()
    {              
        try
        {
            int l = Integer.parseInt(hPassYear.getText());
            if( l-s2 >= 2)
            {
                hPassYear.setStyle("-fx-border-color: #ffffff; -fx-text-fill: white; -fx-prompt-text-fill: white;");
                t2 = l;
                System.out.println(t2);
            }
            else
            {
                hPassYear.setText(null);
                hPassYear.setStyle("-fx-border-color: #ff2323; -fx-text-fill: white; -fx-prompt-text-fill: white;");
                System.out.println("check");

            }
        }    
        catch(Exception e)
        {
            hPassYear.setText(null);
            hPassYear.setStyle("-fx-border-color: #ff2323; -fx-text-fill: white; -fx-prompt-text-fill: white;");
        }
        
    }
    
        
    public void getHRNo()
    {         
        try
        {
            hRNo.setStyle("-fx-border-color: #ffffff; -fx-text-fill: white; -fx-prompt-text-fill: white;");
            t3 = Integer.parseInt(hRNo.getText());
            System.out.println(t3);     
        }
        catch(Exception e)
        {
            hRNo.setText(null);
            hRNo.setStyle("-fx-border-color: #ff2323; -fx-text-fill: white; -fx-prompt-text-fill: white;");
        }
    }
    

    public void getHBoard()
    {
              
       hcbse.setOnAction(new EventHandler<ActionEvent>() 
       {
            public void handle(ActionEvent t) 
            {
                hBoard.setText("CBSE");
                String ab  = "CBSE";
                t4 = "'"+ab+"'";
                System.out.println(t4);

            }
       } );
       
       hcisce.setOnAction(new EventHandler<ActionEvent>() 
       {
            public void handle(ActionEvent t) 
            {
                hBoard.setText("CISCE");
                String ab  = "CISCE";
                t4 = "'"+ab+"'";   
                System.out.println(t4);
            }
       } );
       
       hstate.setOnAction(new EventHandler<ActionEvent>() 
       {
            public void handle(ActionEvent t) 
            {
                hBoard.setText("STATE");
                String ab  = "STATE";
                t4 = "'"+ab+"'";
                System.out.println(t4);
            }
       } );
       
       hibo.setOnAction(new EventHandler<ActionEvent>() 
       {
            public void handle(ActionEvent t) 
            {
                hBoard.setText("IBO");
                String ab  = "IBO";
                t4 = "'"+ab+"'";
                System.out.println(t4);
            }
       } );
       
       hcie.setOnAction(new EventHandler<ActionEvent>() 
       {
            public void handle(ActionEvent t) 
            {
                hBoard.setText("CIE");
                String ab  = "CIE";
                t4 = "'"+ab+"'";
                System.out.println(t4);
            }
       } );
    }
        
        
    public void getHMedium()
    {   
        String l = hMedium.getText();
        if(l.matches("[a-zA-Z]+") == false || l.length() == 0)
        { 
            hMedium.setText(null);
            hMedium.setStyle("-fx-border-color: #ff2323; -fx-text-fill: white; -fx-prompt-text-fill: white;");
            System.out.println("false"); 
            t5 = null;
        } 
        else 
        { 
            hMedium.setStyle("-fx-border-color: #ffffff; -fx-text-fill: white; -fx-prompt-text-fill: white;");
            t5 = "'"+l+"'";
            System.out.println(t5);
        }
    }
    
        
    public void getHSchool()
    {   
        String l = hSchool.getText();
        if(l.matches("[a-zA-Z]+") == false || l.length() == 0)
        { 
            hSchool.setText(null);
            hSchool.setStyle("-fx-border-color: #ff2323; -fx-text-fill: white; -fx-prompt-text-fill: white;");
            System.out.println("false"); 
            t6 = null;
        } 
        else 
        { 
            hSchool.setStyle("-fx-border-color: #ffffff; -fx-text-fill: white; -fx-prompt-text-fill: white;");
            t6 = "'"+l+"'";
            System.out.println(t6);
        }
    }
    
    
    public void getHCity()
    {   
        String l = hCity.getText();
        if(l.matches("[a-zA-Z]+") == false || l.length() == 0)
        { 
            hCity.setText(null);
            hCity.setStyle("-fx-border-color: #ff2323; -fx-text-fill: white; -fx-prompt-text-fill: white;");
            System.out.println("false"); 
            t7 = null;
        } 
        else 
        { 
            hCity.setStyle("-fx-border-color: #ffffff; -fx-text-fill: white; -fx-prompt-text-fill: white;");
            t7 = "'"+l+"'";
            System.out.println(t7);
        }
    }
    
    
    public void getHPercent()
    {   
        try
        {
            hPercent.setStyle("-fx-border-color: #ffffff; -fx-text-fill: white; -fx-prompt-text-fill: white;");
            t8 = Integer.parseInt(hPercent.getText());
            System.out.println(t8);       
        }
        catch(Exception e)
        {
            hPercent.setText(null);
            hPercent.setStyle("-fx-border-color: #ff2323; -fx-text-fill: white; -fx-prompt-text-fill: white;");
        }
    }
    
    
    public void getHPhysics()
    {    
        try
        {   
            t9 = Integer.parseInt(hphysics.getText());
            System.out.println(t9);     
        }
        catch(Exception e)
        {
            hphysics.setText(null);
            
        }
    }
    
    
    public void getHChemistry()
    {   
        try
        {    
            t10 = Integer.parseInt(hchemistry.getText());
            System.out.println(t10);      
        }
        catch(Exception e)
        {
            hchemistry.setText(null);
            
        }
    }
    
    
    public void getHMath()
    {    
        try
        {
            t11 = Integer.parseInt(hmath.getText());
            System.out.println(t11);   
        }
        catch(Exception e)
        {
            hmath.setText(null);
            
        }
    }
    
    
    ////////////////////////// Diploma Fields //////////////////////
          
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
    
    int j, o;
    
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
    
    ////////////////////////////Engineering Fields/////////////////////
         
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
   
    
    /*
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
        alert.setHeaderText("Are you sure you want to delete data of "+ (Editing1Controller.oldName).toUpperCase()+ "?");
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
    */
    
        
    
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