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





/**
 * FXML Controller class
 *
 * @author VIC's
 */
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
        int o = Editing1Controller.up;
        hide(o);
        h = o;
        
        chzPostSSDwn();
        //chzDPentg();
        //chzEPentg();
        //chzPPentg();
        
    }  
    
    DatabaseIO xyz = new DatabaseIO();
    
    public static int i, h;
    public int a;
    
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
    
    
    
    

    /////////////////////////////////////////////Secondary School Fields
    int s3, s2, s8;
    String s1;
    String s4, s5, s6, s7;
    
    @FXML
    private JFXTextField SPass;
    public void getSPass()
    {   s2 = Integer.parseInt(SPass.getText());
        System.out.println(s2);            
    }
    
    @FXML
    private JFXTextField SRoll;
    public void getSRoll()
    {   s3 = Integer.parseInt(SRoll.getText());
        System.out.println(s3);            
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
    {       s8 = Integer.parseInt(SPentg.getText());
            System.out.println(s8);            
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
    
    ///////////////////////////////////////////High School Fields/////////////////////////
    
    @FXML
    private Pane HPane;
    
    int t3, t2, t8, t9, t10, t11;
    String t4, t5, t6, t7;
    
    @FXML
    private JFXTextField HPass;
    public void getHPass()
    {       t2 = Integer.parseInt(HPass.getText());
            System.out.println(t2);            
    }
    
    @FXML
    private JFXTextField HRoll;
    public void getHRoll()
    {       t3 = Integer.parseInt(HRoll.getText());
            System.out.println(t3);            
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
    {   t8 = Integer.parseInt(HPentg.getText());
        System.out.println(t8);            
    }
    
    @FXML
    private TextField HP;
    public void getHP()
    {   t9 = Integer.parseInt(HP.getText());
        System.out.println(t9);            
    }
    
    @FXML
    private TextField HC;
    public void getHC()
    {   t10 = Integer.parseInt(HC.getText());
        System.out.println(t10);            
    }
    
    @FXML
    private TextField HM;
    public void getHM()
    {   t11 = Integer.parseInt(HM.getText());
        System.out.println(t11);            
    }
    
    ////////////////////////// Diploma Fields //////////////////////
    
    @FXML
    private Pane DPane;
    
    @FXML
    private MenuButton DSem;
    
    @FXML
    private MenuItem D1;
    
    @FXML
    private MenuItem D2;
    
    @FXML
    private MenuItem D3;
    
    @FXML
    private MenuItem D4;
    
    @FXML
    private MenuItem D5;
    
    @FXML
    private MenuItem D6;
    
    @FXML
    private JFXTextField DPentg;
    int x;
    public int getDPentg()
    {   
        DPentg.setText(null);
        x = Integer.parseInt(DPentg.getText());
        return x;
    }
    
    int d1, d2, d3, d4, d5, d6;
    
    public void getDsem()
    {
              
       D1.setOnAction(new EventHandler<ActionEvent>() 
       {
            public void handle(ActionEvent t) 
            {
                D1.setText(" 1");
                d1 = getDPentg();
                System.out.println(d1);
                
            }
       }       );
       
       D2.setOnAction(new EventHandler<ActionEvent>() 
       {
            public void handle(ActionEvent t) 
            {
                D2.setText(" 1");
                d2 = getDPentg();
                System.out.println(d2);
                
            }
       }       );
       
       D3.setOnAction(new EventHandler<ActionEvent>() 
       {
            public void handle(ActionEvent t) 
            {
                D3.setText(" 1");
                d3 = getDPentg();
                System.out.println(d3);
                
            }
       }       );
       
       D4.setOnAction(new EventHandler<ActionEvent>() 
       {
            public void handle(ActionEvent t) 
            {
                D4.setText(" 1");
                d4 = getDPentg();
                System.out.println(d4);
                
            }
       }       );
       
       D5.setOnAction(new EventHandler<ActionEvent>() 
       {
            public void handle(ActionEvent t) 
            {
                D5.setText(" 1");
                d5 = getDPentg();
                System.out.println(d5);
                
            }
       }       );
       
       D6.setOnAction(new EventHandler<ActionEvent>() 
       {
            public void handle(ActionEvent t) 
            {
                D6.setText(" 1");
                d6 = getDPentg();
                System.out.println(d6);
                
            }
       }       );
       
    }
    
    //////////////////////////////////////////////////////////
    public void hide(int o)
    {   
        if(o == 1)
        {
            EPentg.setDisable(true);
            ESem.setDisable(true);
            
        
        }
        if(o == 2)
        {
            PPentg.setDisable(true);
            PSem.setDisable(true);
            
        }
    }
    
    int j = Editing1Controller.useSem;
    ////////////////////////////Engineering Fields/////////////////////
        
    @FXML
    private static Pane EPane;
      
    @FXML
    private MenuButton ESem;
        
    @FXML
    private MenuItem E1;
    
    @FXML
    private MenuItem E2;
    
    @FXML
    private MenuItem E3;
    
    @FXML
    private MenuItem E4;
    
    @FXML
    private MenuItem E5;
    
    @FXML
    private MenuItem E6;
    
    @FXML
    private MenuItem E7;
    
    @FXML
    private MenuItem E8;
    
        
    @FXML
    private JFXTextField EPentg;
    
    int e1, e2, e3, e4, e5, e6, e7, e8;
    
    /*public void chzEPentg()
    {
        if(j > 1 && j<=8)
        { 
            E1.setOnAction(new EventHandler<ActionEvent>() 
            {
                public void handle(ActionEvent t) 
                {
                    ESem.setText("1");
                    EPentg.setText(null);
                    e1 = Integer.parseInt(EPentg.getText());  
                    System.out.println(e1);
                }
            });
        }
        else 
        {
            e1 = 0;
        }
        
        if(j > 2 && j<=8)
        { 
            E2.setOnAction(new EventHandler<ActionEvent>() 
            {
                public void handle(ActionEvent t) 
                {
                    ESem.setText("2");
                    EPentg.setText(null);
                    e2 = Integer.parseInt(EPentg.getText()); 
                    System.out.println(e2);
                }
            });
        }
        else 
        {
            e2 = 0;
        }
        
        if(j > 3 && j<=8)
        { 
            E3.setOnAction(new EventHandler<ActionEvent>() 
            {
                public void handle(ActionEvent t) 
                {
                    ESem.setText("3");
                    EPentg.setText(null);
                    e3 = Integer.parseInt(EPentg.getText()); 
                    System.out.println(e3);
                }
            });
        }
        else 
        {
            e3 = 0;
        }
        
        if(j > 4 && j<=8)
        { 
            E4.setOnAction(new EventHandler<ActionEvent>() 
            {
                public void handle(ActionEvent t) 
                {
                    ESem.setText("4");
                    EPentg.setText(null);
                    e4 = Integer.parseInt(EPentg.getText());  
                    System.out.println(e4);
                }
            });
        }
        else 
        {
            e4 = 0;
        }
        
        if(j > 5 && j<=8)
        { 
            E5.setOnAction(new EventHandler<ActionEvent>() 
            {
                public void handle(ActionEvent t) 
                {
                    ESem.setText("5");
                    EPentg.setText(null);
                    e5 = Integer.parseInt(EPentg.getText()); 
                    System.out.println(e5);
                }
            });
        }
        else 
        {
            e5 = 0;
        }
        
        if(j > 6 && j<=8)
        { 
            E6.setOnAction(new EventHandler<ActionEvent>() 
            {
                public void handle(ActionEvent t) 
                {
                    ESem.setText("6");
                    EPentg.setText(null);
                    e6 = Integer.parseInt(EPentg.getText());  
                    System.out.println(e6);
                }
            });
        }
        else 
        {
            e6 = 0;
        }
        
        if(j > 7 && j<=8)
        { 
            E7.setOnAction(new EventHandler<ActionEvent>() 
            {
                public void handle(ActionEvent t) 
                {
                    ESem.setText("7");
                    EPentg.setText(null);
                    e7 = Integer.parseInt(EPentg.getText());
                    System.out.println(e7);
                }
            });
        }
        else 
        {
            e7 = 0;
        }
        
        if(j<=8)
        { 
            E8.setOnAction(new EventHandler<ActionEvent>() 
            {
                public void handle(ActionEvent t) 
                {
                    ESem.setText("8");
                    EPentg.setText(null);
                    e8 = Integer.parseInt(EPentg.getText());
                    System.out.println(e8);
                }
            });
        }
        else 
        {
            e8 = 0;
        }
        
    }*/
           
    
    //////////////////////////////////////Postgraduation Fields///////////////////////////
      
    @FXML
    private static Pane PPane;

    @FXML
    private MenuButton PSem;
    
    @FXML
    private MenuItem P1;
    
    @FXML
    private MenuItem P2;
    
    @FXML
    private MenuItem P3;
    
    @FXML
    private MenuItem P4;
     
    @FXML
    private JFXTextField PPentg; 
    
    int p1, p2, p3, p4;
    
    /*public void chzPPentg()
    {
        if(j > 1 && j<=4)
        { 
            P1.setOnAction(new EventHandler<ActionEvent>() 
            {
                public void handle(ActionEvent t) 
                {
                    PSem.setText("1");
                    PPentg.setText(null);
                    p1 = Integer.parseInt(PPentg.getText());  
                    System.out.println(p1);
                }
            });
        }
        else 
        {
            p1 = 0;
        }
        
        if(j > 2 && j<=4)
        { 
            P2.setOnAction(new EventHandler<ActionEvent>() 
            {
                public void handle(ActionEvent t) 
                {
                    PSem.setText("2");
                    PPentg.setText(null);
                    p2 = Integer.parseInt(PPentg.getText()); 
                    System.out.println(p2);
                }
            });
        }
        else 
        {
            p2 = 0;
        }
        
        if(j > 3 && j<=4)
        { 
            P3.setOnAction(new EventHandler<ActionEvent>() 
            {
                public void handle(ActionEvent t) 
                {
                    PSem.setText("3");
                    PPentg.setText(null);
                    p3 = Integer.parseInt(PPentg.getText()); 
                    System.out.println(p3);
                }
            });
        }
        else 
        {
            p3 = 0;
        }
        
        if(j<=4)
        { 
            P4.setOnAction(new EventHandler<ActionEvent>() 
            {
                public void handle(ActionEvent t) 
                {
                    PSem.setText("4");
                    PPentg.setText(null);
                    p4 = Integer.parseInt(PPentg.getText());  
                    System.out.println(p4);
                }
            });
        }
        else 
        {
            p4 = 0;
        }

    }*/
    //////////////////////////////////////////////////////////
   
    
    public void setValues()
    {       
        xyz.setSscinfo(s1, s2, s3, s4, s5, s6, s7, s8); 
        xyz.setHsscinfo(s1,  t2,  t3,  t4,  t5,  t6,  t7,  t8,  t9,  t10, t11);
        xyz.setDipinfo(s1, d1, d2, d3, d4, d5, d6);
       /* if(Editing2Controller.h == 2)
        {
            xyz.setUginfo(s1, e1, e2, e3, e4, e5, e6, e7, e8);
            xyz.setPginfo(s1, 0, 0, 0, 0);
        }
        
        if(Editing2Controller.h == 1)
        {
            xyz.setUginfo(s1, 0, 0, 0, 0, 0, 0, 0, 0);
            xyz.setPginfo(s1, p1, p2, p3, p4);
        }*/
        
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
        setValues();
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
