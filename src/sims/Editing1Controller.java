
package sims;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.Initializable;

import com.jfoenix.controls.JFXTextField;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.MenuButton; 
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.scene.control.MenuItem;
import javafx.scene.control.Tooltip;



public class Editing1Controller implements Initializable {

    
    @Override
    public void initialize(URL url, ResourceBundle rb) 
    {  
        Edit1.requestFocus();
        //IdFld.setStyle("-fx-border-color: #ff2323; -fx-text-fill: white; -fx-prompt-text-fill: white;"); when error occurs or not filled
                
        
        chzEduDrpDwn();
        chzDeptDrpDwn();
        chzDobMnth();
                
        NamFld.setTooltip(new Tooltip ("use Fullname"));
        DobYear.setTooltip(new Tooltip("eg. 1997"));
        SemFld.setTooltip(new Tooltip("eg. 6, for 6th semester"));
        
        StatusBtn1.setText(a);
                  
    }    
    
    public static String a, useName;
    
    @FXML
    private Pane Edit1;
    
    public String s1, s2, s3, s4, s6, s7, s71, s72, s73;
    public int s5;  
    
    @FXML
    private JFXTextField NamFld;
    public void getName()
    {       s1 = "'"+NamFld.getText()+"'";
            System.out.println(s1);
            useName = s1;
    }
    
    @FXML
    public JFXTextField IdFld;
    public void getID()
    {   s2 = "'"+IdFld.getText()+"'";
        System.out.println(s2);
    }
    
    @FXML
    private MenuButton DeptDrpDwn;
         
    @FXML
    private MenuItem mech;

    @FXML
    private MenuItem cs;
    
    @FXML
    private MenuItem enc;

    @FXML
    private MenuItem civ;
    
    public void chzDeptDrpDwn()
    {
              
       mech.setOnAction(new EventHandler<ActionEvent>() 
       {
            public void handle(ActionEvent t) 
            {
                DeptDrpDwn.setText(" MECH");
                String ab  = "MECH";
                s3 = "'"+ab+"'";
                System.out.println(s3);

            }
       } );
       
       cs.setOnAction(new EventHandler<ActionEvent>() 
       {
            public void handle(ActionEvent t) 
            {
                DeptDrpDwn.setText(" CSE");
                String ab  = "CSE";
                s3 = "'"+ab+"'";   
                System.out.println(s3);
            }
       } );
       
       enc.setOnAction(new EventHandler<ActionEvent>() 
       {
            public void handle(ActionEvent t) 
            {
                DeptDrpDwn.setText(" EnC");
                String ab  = "EnC";
                s3 = "'"+ab+"'";
                System.out.println(s3);
            }
       } );
       
       civ.setOnAction(new EventHandler<ActionEvent>() 
       {
            public void handle(ActionEvent t) 
            {
                DeptDrpDwn.setText(" CIVIL");
                String ab  = "CIVIL";
                s3 = "'"+ab+"'";
                System.out.println(s3);
            }
       } );
    }

    @FXML
    private MenuButton EduDrpDwn;
 
    @FXML
    private MenuItem pg;
    
    @FXML
    private MenuItem ug;
    
    public void chzEduDrpDwn()
    {
              
       pg.setOnAction(new EventHandler<ActionEvent>() 
       {
            public void handle(ActionEvent t) 
            {
                EduDrpDwn.setText("  Postgraduation");
                Editing2Controller.i = 1;
                String ab  = "PG";
                s4 = "'"+ab+"'";
                System.out.println(s4);
            
            }
       });
       
       ug.setOnAction(new EventHandler<ActionEvent>() 
       {
            public void handle(ActionEvent t) 
            {
                EduDrpDwn.setText("  Undergraduation");
                Editing2Controller.i = 2;
                String ab  = "UG";
                s4 = "'"+ab+"'";
                System.out.println(s4);
                
            }
        });
    }
    
    @FXML
    private JFXTextField SemFld;
    public void getSem()
    {       s5 = Integer.parseInt(SemFld.getText());
            System.out.println(s5);
    }
    
    @FXML
    private JFXTextField CntctFld;
    public void getCntct()
    {   s6 = "'"+CntctFld.getText()+"'";
        System.out.println(s6);
    } 
    
    @FXML
    private JFXTextField DobYear;
    public void DobYear()
    {       s71 = DobYear.getText();
            System.out.println(s71);
            
    }
    
    @FXML
    private Label MnthLbl;
    
    @FXML
    private MenuButton DobMnth;
    
    
    @FXML
    private MenuItem jan;
    
    @FXML
    private MenuItem fab;

    @FXML
    private MenuItem march; 

    @FXML
    private MenuItem april;
    
    @FXML
    private MenuItem may;

    @FXML
    private MenuItem june;

    @FXML
    private MenuItem july;
    
    @FXML
    private MenuItem aug;
    
    @FXML
    private MenuItem sept;
    
    @FXML
    private MenuItem oct;

    @FXML
    private MenuItem nov;
    
    @FXML
    private MenuItem dec;
    
    public void chzDobMnth()
    {
              
       jan.setOnAction(new EventHandler<ActionEvent>() 
       {
            public void handle(ActionEvent t) 
            {
                DobMnth.setText(" January");
                MnthLbl.setVisible(true);
                s72 = "1";
            }
       }       );
       
       fab.setOnAction(new EventHandler<ActionEvent>() 
       {
            public void handle(ActionEvent t) 
            {
                DobMnth.setText(" Fabruary");
                MnthLbl.setVisible(true);
                s72 = "2";
            }
       }       );
       
       march.setOnAction(new EventHandler<ActionEvent>() 
       {
            public void handle(ActionEvent t) 
            {
                DobMnth.setText(" March");
                MnthLbl.setVisible(true);
                s72 = "3";
            }
       }
       );
       
       april.setOnAction(new EventHandler<ActionEvent>() 
       {
            public void handle(ActionEvent t) 
            {
                DobMnth.setText(" April");
                MnthLbl.setVisible(true);
                s72 = "4";
            }
       }
       );
       
       may.setOnAction(new EventHandler<ActionEvent>() 
       {
            public void handle(ActionEvent t) 
            {
                DobMnth.setText(" May");
                MnthLbl.setVisible(true);
                s72 = "5";
            }
       }
       );
       
       june.setOnAction(new EventHandler<ActionEvent>() 
       {
            public void handle(ActionEvent t) 
            {
                DobMnth.setText(" June");
                MnthLbl.setVisible(true);
                s72 = "6";
            }
       }
       );
       
       july.setOnAction(new EventHandler<ActionEvent>() 
       {
            public void handle(ActionEvent t) 
            {
                DobMnth.setText(" July");
                MnthLbl.setVisible(true);
                s72 = "7";
            }
       }
       );
       
       aug.setOnAction(new EventHandler<ActionEvent>() 
       {
            public void handle(ActionEvent t) 
            {
                DobMnth.setText(" August");
                MnthLbl.setVisible(true);
                s72 = "8";
            }
       }
       );
       
       sept.setOnAction(new EventHandler<ActionEvent>() 
       {
            public void handle(ActionEvent t) 
            {
                DobMnth.setText(" September");
                MnthLbl.setVisible(true);
                s72 = "9";
            }
       }
       );
       
       oct.setOnAction(new EventHandler<ActionEvent>() 
       {
            public void handle(ActionEvent t) 
            {
                DobMnth.setText(" October");
                MnthLbl.setVisible(true);
                s72 = "10";
            }
       }
       );
       
       nov.setOnAction(new EventHandler<ActionEvent>() 
       {
            public void handle(ActionEvent t) 
            {
                DobMnth.setText(" November");
                MnthLbl.setVisible(true);
                s72 = "11";
            }
       }
       );
       
       dec.setOnAction(new EventHandler<ActionEvent>() 
       {
            public void handle(ActionEvent t) 
            {
                DobMnth.setText(" December");
                MnthLbl.setVisible(true);
                s72 = "12";
    
            }
       }
       );
       
    }
    
    @FXML
    private JFXTextField DobDay;
    public void DobDay()
    {       s73 = DobDay.getText();
            System.out.println(s73);
            s7 = "'"+ s71 + "-" + s72 + "-" + s73 + "'"; 
            System.out.println(s7);
    }
    
    
   
    public void setValues()
    {
        DatabaseIO a = new DatabaseIO();
        a.setBasicinfo(s1, s2, s3, s4, s5, s6, s7); 
    }
    
    
    @FXML
    private Label BtnTo2;
    
    public void toEdit2(MouseEvent event) //this function allows to transport to another tab without opening another window and same goes for other 2 functions
    {
        setValues();
        
        try {
           
            Parent editPag1 = FXMLLoader.load(getClass().getResource("Editing2.fxml"));
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
    public Label StatusBtn1;
    
    
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