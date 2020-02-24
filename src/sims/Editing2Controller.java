package sims;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.Initializable;


import javafx.scene.input.MouseEvent;
import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.MenuButton;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import java.util.regex.Pattern;


import java.util.List;
import java.util.Optional;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.Tooltip;




public class Editing2Controller implements Initializable 
{
    
    //Connection n = null;
          
    //static String name;
    
    @FXML
    private Pane Edit2;
              
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
    
       
    ////////////////////////////////////////////////////////////////////////////
    // Secondary School Fields
    
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
    
    int s1, s2;
    
    float s7;
    
    String s3, s4, s5, s6;
    
        
    public void setSPassYear()
    {   
        String tmp1 = sPassYear.getText();
        if( tmp1.length() == 4)  
        {
            try 
            {
                int tmp2 = Integer.parseInt(tmp1);
                sPassYear.setStyle("-fx-border-color: #ffffff; -fx-text-fill: white; -fx-prompt-text-fill: white;");
                s1 = tmp2;
                System.out.println(s1);
            }
            
            catch (Exception e) 
            {
                sPassYear.setText(null);
                sPassYear.setStyle("-fx-border-color: #ff2323; -fx-text-fill: white; -fx-prompt-text-fill: white;");
            } 
        }
        
        else
        {
            sPassYear.setText(null);
            sPassYear.setStyle("-fx-border-color: #ff2323; -fx-text-fill: white; -fx-prompt-text-fill: white;");
            System.out.println("year length < 4");

        }        
    }
    
    
    public void setSRNo()
    {   
        try
        {
            sRNo.setStyle("-fx-border-color: #ffffff; -fx-text-fill: white; -fx-prompt-text-fill: white;");
            s2 = Integer.parseInt(sRNo.getText());
            System.out.println(s2);     
        }
        catch(Exception e)
        {
            sRNo.setText(null);
            sRNo.setStyle("-fx-border-color: #ff2323; -fx-text-fill: white; -fx-prompt-text-fill: white;");
        }
    }
    
    public void setSBoard()
    {
              
       scbse.setOnAction(new EventHandler<ActionEvent>() 
       {
            public void handle(ActionEvent t) 
            {
                sBoard.setText("CBSE");
                String ab  = "CBSE";
                s3 = "'"+ab+"'";
                System.out.println(s3);

            }
       } );
       
       scisce.setOnAction(new EventHandler<ActionEvent>() 
       {
            public void handle(ActionEvent t) 
            {
                sBoard.setText("CISCE");
                String ab  = "CISCE";
                s3 = "'"+ab+"'";   
                System.out.println(s3);
            }
       } );
       
       sstate.setOnAction(new EventHandler<ActionEvent>() 
       {
            public void handle(ActionEvent t) 
            {
                sBoard.setText("STATE");
                String ab  = "STATE";
                s3 = "'"+ab+"'";
                System.out.println(s3);
            }
       } );
       
       sibo.setOnAction(new EventHandler<ActionEvent>() 
       {
            public void handle(ActionEvent t) 
            {
                sBoard.setText("IBO");
                String ab  = "IBO";
                s3 = "'"+ab+"'";
                System.out.println(s3);
            }
       } );
       
       scie.setOnAction(new EventHandler<ActionEvent>() 
       {
            public void handle(ActionEvent t) 
            {
                sBoard.setText("CIE");
                String ab  = "CIE";
                s3 = "'"+ab+"'";
                System.out.println(s3);
            }
       } );
    }
    
    
    public void setSMedium()
    {   
        String tmp = sMedium.getText();
        if(!Pattern.compile("[a-zA-Z]+", Pattern.CASE_INSENSITIVE).matcher(tmp).matches() || tmp.length() == 0 )
        { 
            sMedium.setText(null);
            sMedium.setStyle("-fx-border-color: #ff2323; -fx-text-fill: white; -fx-prompt-text-fill: white;");
            System.out.println("false"); 
            s4 = null;
        } 
        else 
        { 
            sMedium.setStyle("-fx-border-color: #ffffff; -fx-text-fill: white; -fx-prompt-text-fill: white;");
            s4 = "'"+tmp+"'";
            System.out.println(s4);
        }
    }
    
    
    public void setSSchool()
    {    
        String tmp = sSchool.getText();
        if(!Pattern.compile("[a-zA-Z]+", Pattern.CASE_INSENSITIVE).matcher(tmp).matches() || tmp.length() == 0 )
        { 
            sSchool.setText(null);
            sSchool.setStyle("-fx-border-color: #ff2323; -fx-text-fill: white; -fx-prompt-text-fill: white;");
            System.out.println("false"); 
            s5 = null;  
        } 
        else 
        { 
            sSchool.setStyle("-fx-border-color: #ffffff; -fx-text-fill: white; -fx-prompt-text-fill: white;");
            s5 = "'"+tmp+"'";
            System.out.println(s5);
        }
    }
    
        
    public void setSCity()
    {   
        String tmp = sCity.getText();
        if(!Pattern.compile("[a-zA-Z]+", Pattern.CASE_INSENSITIVE).matcher(tmp).matches() || tmp.length() == 0 )
        { 
            sCity.setText(null);
            sCity.setStyle("-fx-border-color: #ff2323; -fx-text-fill: white; -fx-prompt-text-fill: white;");
            System.out.println("false"); 
            s6 = null;
        } 
        else 
        { 
            sCity.setStyle("-fx-border-color: #ffffff; -fx-text-fill: white; -fx-prompt-text-fill: white;");
            s6 = "'"+tmp+"'";
            System.out.println(s6);
        }
    }
    
    
    public void setSPercent()
    {          
        try
        {
            sPercent.setStyle("-fx-border-color: #ffffff; -fx-text-fill: white; -fx-prompt-text-fill: white;");
            s7 = Float.parseFloat(sPercent.getText());
            System.out.println(s7);       
        }
        catch(Exception e)
        {
            sPercent.setText(null);
            sPercent.setStyle("-fx-border-color: #ff2323; -fx-text-fill: white; -fx-prompt-text-fill: white;");
        }
    }

     
    ////////////////////////////////////////////////////////////////////////////
    //PreUniversity Drop Down
 
    
    @FXML
    private MenuButton preUnivesity;
       
    @FXML
    private Pane hPane;
       
    @FXML
    private Pane dPane;
       
      
    public void setHSS()
    {
        preUnivesity.setText("Higher Secondary School");
        dPane.setVisible(false);
        hPane.setVisible(true);
    }
    
    public void setDiploma()
    {
        preUnivesity.setText("Diploma");
        hPane.setVisible(false);
        dPane.setVisible(true);
    }
            
    
    
    //static int HD;
    
    
             
    
    ///////////////////////////////////////////////////////////////////////////
    // Set High School Fields
                 
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
    private TextField hPhysics;
    
    @FXML
    private TextField hChemistry;
    
    @FXML
    private TextField hMath;
    
    int h1, h2;
    
    float h7, h8, h9, h10;
    
    String h3, h4, h5, h6;
    
        
    public void setHPassYear()
    {
        String tmp1 = hPassYear.getText();
        if (tmp1.length() == 4) 
        {
            try 
            {
                int tmp2 = Integer.parseInt(tmp1);
                hPassYear.setStyle("-fx-border-color: #ffffff; -fx-text-fill: white; -fx-prompt-text-fill: white;");
                h1 = tmp2;
                System.out.println(h1);
            } 
            
            catch (Exception e) 
            {
                hPassYear.setText(null);
                hPassYear.setStyle("-fx-border-color: #ff2323; -fx-text-fill: white; -fx-prompt-text-fill: white;");
            }
        } 
        
        else 
        {
            hPassYear.setText(null);
            hPassYear.setStyle("-fx-border-color: #ff2323; -fx-text-fill: white; -fx-prompt-text-fill: white;");
            System.out.println("year length < 4");
        }
    }
        
       
    public void setHRNo()
    {         
        try
        {
            hRNo.setStyle("-fx-border-color: #ffffff; -fx-text-fill: white; -fx-prompt-text-fill: white;");
            h2 = Integer.parseInt(hRNo.getText());
            System.out.println(h2);     
        }
        catch(Exception e)
        {
            hRNo.setText(null);
            hRNo.setStyle("-fx-border-color: #ff2323; -fx-text-fill: white; -fx-prompt-text-fill: white;");
        }
    }
    

    public void setHBoard()
    {
              
       hcbse.setOnAction(new EventHandler<ActionEvent>() 
       {
            public void handle(ActionEvent t) 
            {
                hBoard.setText("CBSE");
                String ab  = "CBSE";
                h3 = "'"+ab+"'";
                System.out.println(h3);

            }
       } );
       
       hcisce.setOnAction(new EventHandler<ActionEvent>() 
       {
            public void handle(ActionEvent t) 
            {
                hBoard.setText("CISCE");
                String ab  = "CISCE";
                h3 = "'"+ab+"'";   
                System.out.println(h3);
            }
       } );
       
       hstate.setOnAction(new EventHandler<ActionEvent>() 
       {
            public void handle(ActionEvent t) 
            {
                hBoard.setText("STATE");
                String ab  = "STATE";
                h3 = "'"+ab+"'";
                System.out.println(h3);
            }
       } );
       
       hibo.setOnAction(new EventHandler<ActionEvent>() 
       {
            public void handle(ActionEvent t) 
            {
                hBoard.setText("IBO");
                String ab  = "IBO";
                h3 = "'"+ab+"'";
                System.out.println(h3);
            }
       } );
       
       hcie.setOnAction(new EventHandler<ActionEvent>() 
       {
            public void handle(ActionEvent t) 
            {
                hBoard.setText("CIE");
                String ab  = "CIE";
                h3 = "'"+ab+"'";
                System.out.println(h3);
            }
       } );
    }
        
        
    public void setHMedium()
    {   
        String tmp = hMedium.getText();
        if(!Pattern.compile("[a-zA-Z]+", Pattern.CASE_INSENSITIVE).matcher(tmp).matches() || tmp.length() == 0 )
        { 
            hMedium.setText(null);
            hMedium.setStyle("-fx-border-color: #ff2323; -fx-text-fill: white; -fx-prompt-text-fill: white;");
            System.out.println("false"); 
            h4 = null;
        } 
        else 
        { 
            hMedium.setStyle("-fx-border-color: #ffffff; -fx-text-fill: white; -fx-prompt-text-fill: white;");
            h4 = "'"+tmp+"'";
            System.out.println(h4);
        }
    }
    
        
    public void setHSchool()
    {   
        String tmp = hSchool.getText();
        if(!Pattern.compile("[a-zA-Z]+", Pattern.CASE_INSENSITIVE).matcher(tmp).matches() || tmp.length() == 0 )
        { 
            hSchool.setText(null);
            hSchool.setStyle("-fx-border-color: #ff2323; -fx-text-fill: white; -fx-prompt-text-fill: white;");
            System.out.println("false"); 
            h5 = null;
        } 
        else 
        { 
            hSchool.setStyle("-fx-border-color: #ffffff; -fx-text-fill: white; -fx-prompt-text-fill: white;");
            h5 = "'"+tmp+"'";
            System.out.println(h5);
        }
    }
    
    
    public void setHCity()
    {   
        String tmp = hCity.getText();
        if(!Pattern.compile("[a-zA-Z]+", Pattern.CASE_INSENSITIVE).matcher(tmp).matches() || tmp.length() == 0 )
        { 
            hCity.setText(null);
            hCity.setStyle("-fx-border-color: #ff2323; -fx-text-fill: white; -fx-prompt-text-fill: white;");
            System.out.println("false"); 
            h6 = null;
        } 
        else 
        { 
            hCity.setStyle("-fx-border-color: #ffffff; -fx-text-fill: white; -fx-prompt-text-fill: white;");
            h6 = "'"+tmp+"'";
            System.out.println(h6);
        }
    }
    
    
    public void setHPercent()
    {   
        try
        {
            hPercent.setStyle("-fx-border-color: #ffffff; -fx-text-fill: white; -fx-prompt-text-fill: white;");
            h7 = Float.parseFloat(hPercent.getText());
            System.out.println(h7);       
        }
        catch(Exception e)
        {
            hPercent.setText(null);
            hPercent.setStyle("-fx-border-color: #ff2323; -fx-text-fill: white; -fx-prompt-text-fill: white;");
        }
    }
    
    
    public void setHPhysics()
    {    
        try
        {   
            h8 = Float.parseFloat(hPhysics.getText());
            System.out.println(h8);     
        }
        catch(Exception e)
        {
            hPhysics.setText(null);
            //hphysics.setStyle("-fx-border-color: #ff2323; -fx-text-fill: white; -fx-prompt-text-fill: white;");
        }
    }
    
    
    public void setHChemistry()
    {   
        try
        {    
            h9 = Float.parseFloat(hChemistry.getText());
            System.out.println(h9);      
        }
        catch(Exception e)
        {
            hChemistry.setText(null);  
            //hchemistry.setStyle("-fx-border-color: #ff2323; -fx-text-fill: white; -fx-prompt-text-fill: white;");
        }
    }
    
    
    public void setHMath()
    {    
        try
        {
            h10 = Float.parseFloat(hMath.getText());
            System.out.println(h10);   
        }
        catch(Exception e)
        {
            hMath.setText(null);
            //hmath.setStyle("-fx-border-color: #ff2323; -fx-text-fill: white; -fx-prompt-text-fill: white;");
        }
    }
    
    
    ////////////////////////////////////////////////////
    // Set Diploma Fields 
  
    
    @FXML
    private JFXTextField dPassYear;
    
    @FXML
    private JFXTextField dSchool;
    
    @FXML
    private JFXTextField dCity;
    
    @FXML 
    private JFXTextField dPercent1;
    
    @FXML
    private JFXTextField dPercent2;
    
    @FXML
    private JFXTextField dPercent3;
    
    @FXML
    private JFXTextField dPercent4;
    
    @FXML
    private JFXTextField dPercent5;
    
    @FXML
    private JFXTextField dPercent6;
    
    int d1;
    
    float d4, d5, d6, d7, d8, d9;   
    
    String d2, d3;
    
    
    
    public void setDPassYear()
    {                  
        String tmp1 = dPassYear.getText();
        if (tmp1.length() == 4) 
        {
            try 
            {
                int tmp2 = Integer.parseInt(tmp1);
                dPassYear.setStyle("-fx-border-color: #ffffff; -fx-text-fill: white; -fx-prompt-text-fill: white;");
                d1 = tmp2;
                System.out.println(d1);
            } 
            
            catch (Exception e) 
            {
                dPassYear.setText(null);
                dPassYear.setStyle("-fx-border-color: #ff2323; -fx-text-fill: white; -fx-prompt-text-fill: white;");
            }
        } 
        
        else 
        {
            dPassYear.setText(null);
            dPassYear.setStyle("-fx-border-color: #ff2323; -fx-text-fill: white; -fx-prompt-text-fill: white;");
            System.out.println("year length < 4");
        }
    }
    
    
    public void setDSchool()
    {    
        String tmp= dSchool.getText();
        if(!Pattern.compile("[a-zA-Z]+", Pattern.CASE_INSENSITIVE).matcher(tmp).matches() || tmp.length() == 0 )
        { 
            dSchool.setText(null);
            dSchool.setStyle("-fx-border-color: #ff2323; -fx-text-fill: white; -fx-prompt-text-fill: white;");
            System.out.println("false"); 
            d2 = null;
            
        } 
        else 
        { 
            dSchool.setStyle("-fx-border-color: #ffffff; -fx-text-fill: white; -fx-prompt-text-fill: white;");
            d2 = "'"+tmp+"'";
            System.out.println(d2);
        }
    }
    
    
    public void setDCity()
    {   
        String tmp = dCity.getText();
        if(!Pattern.compile("[a-zA-Z]+", Pattern.CASE_INSENSITIVE).matcher(tmp).matches() || tmp.length() == 0 )
        { 
            dCity.setText(null);
            dCity.setStyle("-fx-border-color: #ff2323; -fx-text-fill: white; -fx-prompt-text-fill: white;");
            System.out.println("false"); 
            d3 = null;
        } 
        else 
        { 
            dCity.setStyle("-fx-border-color: #ffffff; -fx-text-fill: white; -fx-prompt-text-fill: white;");
            d3 = "'"+tmp+"'";
            System.out.println(d3);
        }
    }
    
    
    public void setDPercent1()
    {                 
        try
        {
            dPercent1.setStyle("-fx-border-color: #ffffff; -fx-text-fill: white; -fx-prompt-text-fill: white;");
            d4 = Float.parseFloat(dPercent1.getText());
            System.out.println(d4);       
        }
        catch(Exception e)
        {
            dPercent1.setText(null);
            dPercent1.setStyle("-fx-border-color: #ff2323; -fx-text-fill: white; -fx-prompt-text-fill: white;");
        }
    }
    
    
    public void setDPercent2()
    {   
        try
        {
            dPercent2.setStyle("-fx-border-color: #ffffff; -fx-text-fill: white; -fx-prompt-text-fill: white;");
            d5 = Float.parseFloat(dPercent2.getText());
            System.out.println(d5);       
        }
        catch(Exception e)
        {
            dPercent2.setText(null);
            dPercent2.setStyle("-fx-border-color: #ff2323; -fx-text-fill: white; -fx-prompt-text-fill: white;");
        }
    }
    
    
    public void setDPercent3()
    {   
        try
        {
            dPercent3.setStyle("-fx-border-color: #ffffff; -fx-text-fill: white; -fx-prompt-text-fill: white;");
            d6 = Float.parseFloat(dPercent3.getText());
            System.out.println(d6);       
        }
        catch(Exception e)
        {
            dPercent3.setText(null);
            dPercent3.setStyle("-fx-border-color: #ff2323; -fx-text-fill: white; -fx-prompt-text-fill: white;");
        }
    }
    
    
    public void setDPercent4()
    {    
        try
        {
            dPercent4.setStyle("-fx-border-color: #ffffff; -fx-text-fill: white; -fx-prompt-text-fill: white;");
            d7 = Float.parseFloat(dPercent4.getText());
            System.out.println(d7);       
        }
        catch(Exception e)
        {
            dPercent4.setText(null);
            dPercent4.setStyle("-fx-border-color: #ff2323; -fx-text-fill: white; -fx-prompt-text-fill: white;");
        }
        
    }
    
    
    public void setDPercent5()
    {   
        try
        {
            dPercent5.setStyle("-fx-border-color: #ffffff; -fx-text-fill: white; -fx-prompt-text-fill: white;");
            d8 = Float.parseFloat(dPercent5.getText());
            System.out.println(d8);       
        }
        catch(Exception e)
        {
            dPercent5.setText(null);
            dPercent5.setStyle("-fx-border-color: #ff2323; -fx-text-fill: white; -fx-prompt-text-fill: white;");
        }
        
    }
    
    
    public void setDPercent6()
    {  
        try
        {
            dPercent6.setStyle("-fx-border-color: #ffffff; -fx-text-fill: white; -fx-prompt-text-fill: white;");
            d9 = Float.parseFloat(dPercent6.getText());
            System.out.println(d9);       
        }
        catch(Exception e)
        {
            dPercent6.setText(null);
            dPercent6.setStyle("-fx-border-color: #ff2323; -fx-text-fill: white; -fx-prompt-text-fill: white;");
        }
    }
       
    
    //////////////////////////////////////////////////////////
    
    /*int j, o;
    
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
    }*/
    
    //////////////////////////////////////////////////////////
    // Set Undergraduation Fields
    
    
    @FXML
    private JFXTextField ePassYear;
    
    @FXML
    private JFXTextField eSchool;
    
    @FXML
    private JFXTextField eCity;
       
    @FXML
    private JFXTextField ePercent1;
    
    @FXML
    private JFXTextField ePercent2;
    
    @FXML
    private JFXTextField ePercent3;
    
    @FXML
    private JFXTextField ePercent4;
    
    @FXML
    private JFXTextField ePercent5;
    
    @FXML
    private JFXTextField ePercent6;
    
    @FXML
    private JFXTextField ePercent7;
    
    @FXML
    private JFXTextField ePercent8;

    int e1;
    
    float e4, e5, e6, e7, e8, e9, e10, e11;
    
    String e2, e3;
    
    
    public void setEPassYear()
    {                   
        String tmp1 = ePassYear.getText();
        if (tmp1.length() == 4) 
        {
            try 
            {
                int tmp2 = Integer.parseInt(tmp1);
                ePassYear.setStyle("-fx-border-color: #ffffff; -fx-text-fill: white; -fx-prompt-text-fill: white;");
                e1 = tmp2;
                System.out.println(e1);
            } 
            
            catch (Exception e) 
            {
                ePassYear.setText(null);
                ePassYear.setStyle("-fx-border-color: #ff2323; -fx-text-fill: white; -fx-prompt-text-fill: white;");
            }
        } 
        
        else 
        {
            ePassYear.setText(null);
            ePassYear.setStyle("-fx-border-color: #ff2323; -fx-text-fill: white; -fx-prompt-text-fill: white;");
            System.out.println("year length < 4");
        }
    }
    
    
    public void setESchool()
    {    
        String tmp = eSchool.getText();
        if(!Pattern.compile("[a-zA-Z]+", Pattern.CASE_INSENSITIVE).matcher(tmp).matches() || tmp.length() == 0 )
        { 
            eSchool.setText(null);
            eSchool.setStyle("-fx-border-color: #ff2323; -fx-text-fill: white; -fx-prompt-text-fill: white;");
            System.out.println("false"); 
            e2 = null;
            
        } 
        else 
        { 
            eSchool.setStyle("-fx-border-color: #ffffff; -fx-text-fill: white; -fx-prompt-text-fill: white;");
            e2 = "'"+tmp+"'";
            System.out.println(e2);
        }
    }
    
    
    public void setECity()
    {   
        String tmp = eCity.getText();
        if(!Pattern.compile("[a-zA-Z]+", Pattern.CASE_INSENSITIVE).matcher(tmp).matches() || tmp.length() == 0 )
        { 
            eCity.setText(null);
            eCity.setStyle("-fx-border-color: #ff2323; -fx-text-fill: white; -fx-prompt-text-fill: white;");
            System.out.println("false"); 
            e3 = null;
        } 
        else 
        { 
            eCity.setStyle("-fx-border-color: #ffffff; -fx-text-fill: white; -fx-prompt-text-fill: white;");
            e3 = "'"+tmp+"'";
            System.out.println(e3);
        }
    }
    
    
    public void setEPercent1()
    {             
        try
        {
            ePercent1.setStyle("-fx-border-color: #ffffff; -fx-text-fill: white; -fx-prompt-text-fill: white;");
            e4 = Float.parseFloat(ePercent1.getText());
            System.out.println(e4);       
        }
        catch(Exception e)
        {
            ePercent1.setText(null);
            ePercent1.setStyle("-fx-border-color: #ff2323; -fx-text-fill: white; -fx-prompt-text-fill: white;");
        }
    }
    
    
    public void setEPercent2()
    {           
        try
        {
            ePercent2.setStyle("-fx-border-color: #ffffff; -fx-text-fill: white; -fx-prompt-text-fill: white;");
            e5 = Float.parseFloat(ePercent2.getText());
            System.out.println(e5);       
        }
        catch(Exception e)
        {
            ePercent2.setText(null);
            ePercent2.setStyle("-fx-border-color: #ff2323; -fx-text-fill: white; -fx-prompt-text-fill: white;");
        }        
    }
    
    
    public void setEPercent3()
    {           
        try
        {
            ePercent3.setStyle("-fx-border-color: #ffffff; -fx-text-fill: white; -fx-prompt-text-fill: white;");
            e6 = Float.parseFloat(ePercent3.getText());
            System.out.println(e6);       
        }
        catch(Exception e)
        {
            ePercent3.setText(null);
            ePercent3.setStyle("-fx-border-color: #ff2323; -fx-text-fill: white; -fx-prompt-text-fill: white;");
        }  
    }
    
    
    public void setEPercent4()
    {           
        try
        {
            ePercent4.setStyle("-fx-border-color: #ffffff; -fx-text-fill: white; -fx-prompt-text-fill: white;");
            e7 = Float.parseFloat(ePercent4.getText());
            System.out.println(e7);       
        }
        catch(Exception e)
        {
            ePercent4.setText(null);
            ePercent4.setStyle("-fx-border-color: #ff2323; -fx-text-fill: white; -fx-prompt-text-fill: white;");
        }  
    }
    
    
    public void setEPercent5()
    {               
        try
        {
            ePercent5.setStyle("-fx-border-color: #ffffff; -fx-text-fill: white; -fx-prompt-text-fill: white;");
            e8 = Float.parseFloat(ePercent5.getText());
            System.out.println(e8);       
        }
        catch(Exception e)
        {
            ePercent5.setText(null);
            ePercent5.setStyle("-fx-border-color: #ff2323; -fx-text-fill: white; -fx-prompt-text-fill: white;");
        }  
    }
    
    
    public void setEPercent6()
    {   
        try
        {
            ePercent6.setStyle("-fx-border-color: #ffffff; -fx-text-fill: white; -fx-prompt-text-fill: white;");
            e9 = Float.parseFloat(ePercent6.getText());
            System.out.println(e9);       
        }
        catch(Exception e)
        {
            ePercent6.setText(null);
            ePercent6.setStyle("-fx-border-color: #ff2323; -fx-text-fill: white; -fx-prompt-text-fill: white;");
        }  
    }
    
    
    public void setEPercent7()
    {           
        try
        {
            ePercent7.setStyle("-fx-border-color: #ffffff; -fx-text-fill: white; -fx-prompt-text-fill: white;");
            e10 = Float.parseFloat(ePercent7.getText());
            System.out.println(e10);       
        }
        catch(Exception e)
        {
            ePercent7.setText(null);
            ePercent7.setStyle("-fx-border-color: #ff2323; -fx-text-fill: white; -fx-prompt-text-fill: white;");
        }          
    }
    
    
    public void setEPercent8()
    {  
        try
        {
            ePercent8.setStyle("-fx-border-color: #ffffff; -fx-text-fill: white; -fx-prompt-text-fill: white;");
            e11 = Float.parseFloat(ePercent8.getText());
            System.out.println(e11);       
        }
        catch(Exception e)
        {
            ePercent8.setText(null);
            ePercent8.setStyle("-fx-border-color: #ff2323; -fx-text-fill: white; -fx-prompt-text-fill: white;");
        }  
    }
    
    /*@FXML
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
    
    <fx:define>
          <ArrayList fx:id="EList">
              <fx:reference source="ePercent1" />
              <fx:reference source="ePercent2" />
              <fx:reference source="ePercent3" />
              <fx:reference source="ePercent4" />
              <fx:reference source="ePercent5" />
              <fx:reference source="ePercent6" />
              <fx:reference source="ePercent7" />
              <fx:reference source="ePercent8" />
          </ArrayList>
          <ArrayList fx:id="PList">
              <fx:reference source="pPercent1" />
              <fx:reference source="pPercent2" />
              <fx:reference source="pPercent3" />
              <fx:reference source="pPercent4" />
          </ArrayList>
      </fx:define>
    
    
    
    */
    
    /////////////////////////////////////////////////////////////////
    // Set Postgraduation Fields
    
    
    @FXML
    private JFXTextField pPassYear;
    
    @FXML
    private JFXTextField pSchool;
    
    @FXML
    private JFXTextField pCity;
       
    @FXML
    private JFXTextField pPercent1;
    
    @FXML
    private JFXTextField pPercent2;
    
    @FXML
    private JFXTextField pPercent3;
    
    @FXML
    private JFXTextField pPercent4;
    
    int p1;    
    
    float p4, p5, p6, p7;

    String p2, p3;
    
    
    public void setPPassYear()
    {           
        String tmp1 = pPassYear.getText();
        if (tmp1.length() == 4) 
        {
            try 
            {
                int tmp2 = Integer.parseInt(tmp1);
                pPassYear.setStyle("-fx-border-color: #ffffff; -fx-text-fill: white; -fx-prompt-text-fill: white;");
                p1 = tmp2;
                System.out.println(p1);
            } 
            
            catch (Exception e) 
            {
                pPassYear.setText(null);
                pPassYear.setStyle("-fx-border-color: #ff2323; -fx-text-fill: white; -fx-prompt-text-fill: white;");
            }
        } 
        
        else 
        {
            pPassYear.setText(null);
            pPassYear.setStyle("-fx-border-color: #ff2323; -fx-text-fill: white; -fx-prompt-text-fill: white;");
            System.out.println("year length < 4");
        }
    }
    
    
    public void setPSchool()
    {    
        String tmp = pSchool.getText();
        if(!Pattern.compile("[a-zA-Z]+", Pattern.CASE_INSENSITIVE).matcher(tmp).matches() || tmp.length() == 0 )
        { 
            pSchool.setText(null);
            pSchool.setStyle("-fx-border-color: #ff2323; -fx-text-fill: white; -fx-prompt-text-fill: white;");
            System.out.println("false"); 
            p2 = null;
            
        } 
        else 
        { 
            pSchool.setStyle("-fx-border-color: #ffffff; -fx-text-fill: white; -fx-prompt-text-fill: white;");
            p2 = "'"+tmp+"'";
            System.out.println(p2);
        }
    }
    
    
    public void setPCity()
    {   
        String tmp = pCity.getText();
        if(!Pattern.compile("[a-zA-Z]+", Pattern.CASE_INSENSITIVE).matcher(tmp).matches() || tmp.length() == 0 )
        { 
            pCity.setText(null);
            pCity.setStyle("-fx-border-color: #ff2323; -fx-text-fill: white; -fx-prompt-text-fill: white;");
            System.out.println("false"); 
            p3 = null;
        } 
        else 
        { 
            pCity.setStyle("-fx-border-color: #ffffff; -fx-text-fill: white; -fx-prompt-text-fill: white;");
            p3 = "'"+tmp+"'";
            System.out.println(p3);
        }
    }
    
    
    public void setPPercent1()
    {           
        try
        {
            pPercent1.setStyle("-fx-border-color: #ffffff; -fx-text-fill: white; -fx-prompt-text-fill: white;");
            p4 = Float.parseFloat(pPercent1.getText());
            System.out.println(p4);       
        }
        catch(Exception e)
        {
            pPercent1.setText(null);
            pPercent1.setStyle("-fx-border-color: #ff2323; -fx-text-fill: white; -fx-prompt-text-fill: white;");
        } 
    }
    
    public void setPPercent2()
    {           
        try
        {
            pPercent2.setStyle("-fx-border-color: #ffffff; -fx-text-fill: white; -fx-prompt-text-fill: white;");
            p5 = Float.parseFloat(pPercent2.getText());
            System.out.println(p5);       
        }
        catch(Exception e)
        {
            pPercent2.setText(null);
            pPercent2.setStyle("-fx-border-color: #ff2323; -fx-text-fill: white; -fx-prompt-text-fill: white;");
        } 
    }
    
    public void setPPercent3()
    {           
        try
        {
            pPercent3.setStyle("-fx-border-color: #ffffff; -fx-text-fill: white; -fx-prompt-text-fill: white;");
            p6 = Float.parseFloat(pPercent3.getText());
            System.out.println(p6);       
        }
        catch(Exception e)
        {
            pPercent3.setText(null);
            pPercent3.setStyle("-fx-border-color: #ff2323; -fx-text-fill: white; -fx-prompt-text-fill: white;");
        } 
    }
    
    public void setPPercent4()
    {           
        try
        {
            pPercent4.setStyle("-fx-border-color: #ffffff; -fx-text-fill: white; -fx-prompt-text-fill: white;");
            p7 = Float.parseFloat(pPercent4.getText());
            System.out.println(p7);       
        }
        catch(Exception e)
        {
            pPercent4.setText(null);
            pPercent4.setStyle("-fx-border-color: #ff2323; -fx-text-fill: white; -fx-prompt-text-fill: white;");
        } 
    }
    
    /*@FXML
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
    }*/
    
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
    
        
    
    /*@FXML
    public static Label BtnTo1;*/
    
    public void toPrevPg(MouseEvent event)
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
    
    
    public void toNextPg(MouseEvent event)
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
    
        
    public void toHomePg(MouseEvent event)
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