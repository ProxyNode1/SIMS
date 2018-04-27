/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sims;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.Initializable;


import javafx.scene.input.MouseEvent;
import com.jfoenix.controls.JFXTextField;
import java.util.ArrayList;
import java.util.List;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
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
        SBrd.setTooltip(new Tooltip("eg. state"));
        HBrd.setTooltip(new Tooltip("eg. state"));
        
        s1 = Editing1Controller.useName;
        System.out.println(s1);
        j = Editing1Controller.useSem;
        System.out.println(j);
        
        o = Editing1Controller.up;
        hide(o);
                
        chzPostSSDwn();
       
        selEPentg();
        selPPentg();
        
    }  
    
    
    
    public static int i, h;
    public int a;
    
    @FXML
    private Label takeFocus;
    
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
    
    
    
    

    /////////////////////////////////////////////**Secondary School Fields**///////////////
    static int  s3, s2, s8;
    static String s1;
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
    private JFXTextField SBrd;
    public void getSBrd()
    {   s4 = "'"+SBrd.getText()+"'";
        System.out.println(s4);
    }
    
    @FXML
    private JFXTextField SMed;
    public void getSMed()
    {   s5 = "'"+SMed.getText()+"'";
        System.out.println(s5);
    }
    
    @FXML
    private JFXTextField SSch;
    public void getSSch()
    {   s6 = "'"+SSch.getText()+"'";
        System.out.println(s6);
    }
    
    @FXML
    private JFXTextField SCity;
    public void getSCity()
    {   s7 = "'"+SCity.getText()+"'";
        System.out.println(s7);
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
                
       HSSC.setOnAction(new EventHandler<ActionEvent>() 
       {
            public void handle(ActionEvent t) 
            {
                PostSS.setText("  HSSC");
                HD = 1;
                DPane.setVisible(false);
                HPane.setVisible(true);
            }
       }
       );
       
       
       DIPLOMA.setOnAction(new EventHandler<ActionEvent>() 
       {
            public void handle(ActionEvent t) 
            {
                PostSS.setText("  DIPLOMA");
                HD = 2;
                HPane.setVisible(false);
                DPane.setVisible(true);
            }
       }
       );
    }
    
    ///////////////////////////////////////////**High School Fields**/////////////////////////
    
    @FXML
    private Pane HPane;
    
    static int t3, t2, t8, t9, t10, t11;
    static String t4 = "null", t5 = "null", t6 = "null", t7 = "null";
    
    @FXML
    private JFXTextField HPass;
    public void getHPass()
    {              
        try
        {
            HPass.setStyle("-fx-border-color: #ffffff; -fx-text-fill: white; -fx-prompt-text-fill: white;");
            t2 = Integer.parseInt(HPass.getText());
            System.out.println(t2);          
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
    private JFXTextField HBrd;
    public void getHBrd()
    {   t4 = "'"+HBrd.getText()+"'";
        System.out.println(t4);
    }

        
    @FXML
    private JFXTextField HMed;
    public void getHMed()
    {   t5 = "'"+HMed.getText()+"'";
        System.out.println(t5);
    }
    
    @FXML
    private JFXTextField HSch;
    public void getHSch()
    {   t6 = "'"+HSch.getText()+"'";
        System.out.println(t6);
    }
    
    @FXML
    private JFXTextField HCity;
    public void getHCity()
    {   t7 = "'"+HCity.getText()+"'";
        System.out.println(t7);
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
            HP.setStyle("-fx-border-color: #ffffff; -fx-text-fill: white; -fx-prompt-text-fill: white;");
            t9 = Integer.parseInt(HP.getText());
            System.out.println(t9);     
        }
        catch(Exception e)
        {
            HP.setText(null);
            HP.setStyle("-fx-border-color: #ff2323; -fx-text-fill: white; -fx-prompt-text-fill: white;");
        }
    }
    
    @FXML
    private TextField HC;
    public void getHC()
    {   
        try
        {
            HC.setStyle("-fx-border-color: #ffffff; -fx-text-fill: white; -fx-prompt-text-fill: white;");
            t10 = Integer.parseInt(HC.getText());
            System.out.println(t10);      
        }
        catch(Exception e)
        {
            HC.setText(null);
            HC.setStyle("-fx-border-color: #ff2323; -fx-text-fill: white; -fx-prompt-text-fill: white;");
        }
    }
    
    @FXML
    private TextField HM;
    public void getHM()
    {    
        try
        {
            HM.setStyle("-fx-border-color: #ffffff; -fx-text-fill: white; -fx-prompt-text-fill: white;");
            t11 = Integer.parseInt(HM.getText());
            System.out.println(t11);   
        }
        catch(Exception e)
        {
            HM.setText(null);
            HM.setStyle("-fx-border-color: #ff2323; -fx-text-fill: white; -fx-prompt-text-fill: white;");
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
    private List<JFXTextField> EList;
    
    public void selEPentg()
    { 
        for(int count = 0; count<j-1 && o == 2; count++)
        {
            EList.get(count).setDisable(false);
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
    private List<JFXTextField> PList;
    
    public void selPPentg()
    { 
        for(int count = 0; count<j-1 && o == 1; count++)
        {
            PList.get(count).setDisable(false);
        }
    }
    
    //////////////////////////////////////////////////////////
   
    
    public static void setValues()
    {       
        DatabaseIO xyz = new DatabaseIO();
        xyz.setSscinfo(s1, s2, s3, s4, s5, s6, s7, s8); 
        xyz.setHsscinfo(s1,  t2,  t3,  t4,  t5,  t6,  t7,  t8,  t11,  t10, t9);
        xyz.setDipinfo(s1, d1, d2, d3, d4, d5, d6);
        xyz.setUginfo(s1, e1, e2, e3, e4, e5, e6, e7, e8);
        xyz.setPginfo(s1, p1, p2, p3, p4);
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
