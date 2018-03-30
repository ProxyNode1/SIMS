
package sims;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.Initializable;

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
                
        
        getEduDrpDwn();
        getDeptDrpDwn();
        getDobMnth();
                
        DobYear.setTooltip(new Tooltip("eg. 1997"));
        SemFld.setTooltip(new Tooltip("eg. 6, for 6th semester"));
    }    
    
     
    
    @FXML
    private JFXTextField IdFld;

    @FXML
    private MenuButton EduDrpDwn;
    
    @FXML
    private MenuItem pg;
    
    @FXML
    private MenuItem ug;
    
    public void getEduDrpDwn()
    {
              
       pg.setOnAction(new EventHandler<ActionEvent>() 
       {
            public void handle(ActionEvent t) 
            {
                EduDrpDwn.setText("  Postgraduation");
            }
       }
       );
       
       ug.setOnAction(new EventHandler<ActionEvent>() 
       {
            public void handle(ActionEvent t) 
            {
                EduDrpDwn.setText("  Undergraduation");
            }
       }
       );
    }
    
    
    

    @FXML
    private JFXTextField CntctFld;

    @FXML
    private JFXTextField NamFld;

    @FXML
    private JFXTextField DpmtFld;

    @FXML
    private JFXTextField SemFld;
    
    
    @FXML
    private Label BtnTo1;
   
    @FXML
    private Label BtnTo2;
    
    public void toEdit2(MouseEvent event) //this function allows to transport to another tab without opening another window and same goes for other 2 functions
    {
        
        
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
    private Label CloseBtn;
    
    @FXML
    void handleClose(MouseEvent event)
    {
        
        System.exit(0);
        
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
    
    @FXML
    private Pane Edit1;
 
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
    
    public void getDeptDrpDwn()
    {
              
       mech.setOnAction(new EventHandler<ActionEvent>() 
       {
            public void handle(ActionEvent t) 
            {
                DeptDrpDwn.setText(" Mechanical Enginnering");
            }
       }
       );
       
       cs.setOnAction(new EventHandler<ActionEvent>() 
       {
            public void handle(ActionEvent t) 
            {
                DeptDrpDwn.setText(" Computer Science and Engineering");
            }
       }
       );
       
       enc.setOnAction(new EventHandler<ActionEvent>() 
       {
            public void handle(ActionEvent t) 
            {
                DeptDrpDwn.setText(" Electronics and Communication");
            }
       }
       );
       
       civ.setOnAction(new EventHandler<ActionEvent>() 
       {
            public void handle(ActionEvent t) 
            {
                DeptDrpDwn.setText(" Civil Engineering");
            }
       }
       );
    }
    
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
    
    public void getDobMnth()
    {
              
       jan.setOnAction(new EventHandler<ActionEvent>() 
       {
            public void handle(ActionEvent t) 
            {
                DobMnth.setText(" January");
            }
       }
       );
       
       fab.setOnAction(new EventHandler<ActionEvent>() 
       {
            public void handle(ActionEvent t) 
            {
                DobMnth.setText(" Fabruary");
            }
       }
       );
       
       march.setOnAction(new EventHandler<ActionEvent>() 
       {
            public void handle(ActionEvent t) 
            {
                DobMnth.setText(" March");
            }
       }
       );
       
       april.setOnAction(new EventHandler<ActionEvent>() 
       {
            public void handle(ActionEvent t) 
            {
                DobMnth.setText(" April");
            }
       }
       );
       
       may.setOnAction(new EventHandler<ActionEvent>() 
       {
            public void handle(ActionEvent t) 
            {
                DobMnth.setText(" May");
            }
       }
       );
       
       june.setOnAction(new EventHandler<ActionEvent>() 
       {
            public void handle(ActionEvent t) 
            {
                DobMnth.setText(" June");
            }
       }
       );
       
       july.setOnAction(new EventHandler<ActionEvent>() 
       {
            public void handle(ActionEvent t) 
            {
                DobMnth.setText(" July");
            }
       }
       );
       
       aug.setOnAction(new EventHandler<ActionEvent>() 
       {
            public void handle(ActionEvent t) 
            {
                DobMnth.setText(" August");
            }
       }
       );
       
       sept.setOnAction(new EventHandler<ActionEvent>() 
       {
            public void handle(ActionEvent t) 
            {
                DobMnth.setText(" September");
            }
       }
       );
       
       oct.setOnAction(new EventHandler<ActionEvent>() 
       {
            public void handle(ActionEvent t) 
            {
                DobMnth.setText(" October");
            }
       }
       );
       
       nov.setOnAction(new EventHandler<ActionEvent>() 
       {
            public void handle(ActionEvent t) 
            {
                DobMnth.setText(" November");
            }
       }
       );
       
       dec.setOnAction(new EventHandler<ActionEvent>() 
       {
            public void handle(ActionEvent t) 
            {
                DobMnth.setText(" December");
            }
       }
       );
       
    }

    @FXML
    private JFXTextField DobYear;

    @FXML
    private JFXTextField DobDay;
    
}