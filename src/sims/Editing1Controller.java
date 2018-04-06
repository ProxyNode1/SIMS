
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
        
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(Editing1Controller.class.getResource("Editing2.fxml"));
        Parent root;
        try {
            root = loader.load();
        } catch (IOException ex) {
            Logger.getLogger(Editing1Controller.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        
        
        
    }    
    
     
    
    @FXML
    private JFXTextField IdFld;
    public JFXTextField getIdFld() {
        return IdFld;
    }

    public void setIdFld(JFXTextField IdFld) {
        this.IdFld = IdFld;
    } 

    @FXML
    private JFXTextField CntctFld;
    public JFXTextField getCntctFld() {
        return CntctFld;
    }

    public void setCntctFld(JFXTextField CntctFld) {
        this.CntctFld = CntctFld;
    }

    @FXML
    private JFXTextField NamFld;
    
    public JFXTextField getNamFld() {
        return NamFld;
    }

    public void setNamFld(JFXTextField NamFld) {
        this.NamFld = NamFld;
    }
  

    @FXML
    private JFXTextField SemFld;
    public JFXTextField getSemFld() {
        return SemFld;
    }

    public void setSemFld(JFXTextField SemFld) {
        this.SemFld = SemFld;
    }
    
    @FXML
    private MenuButton EduDrpDwn;
    public MenuButton getEduDrpDwn() {
        return EduDrpDwn;
    }

    public void setEduDrpDwn(MenuButton EduDrpDwn) {
        this.EduDrpDwn = EduDrpDwn;
    }
    
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
    public MenuButton getDeptDrpDwn() {
        return DeptDrpDwn;
    }

    public void setDeptDrpDwn(MenuButton DeptDrpDwn) {
        this.DeptDrpDwn = DeptDrpDwn;
    }
    
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
    private Label MnthLbl;
    
    @FXML
    private MenuButton DobMnth;
    public MenuButton getDobMnth() {
        return DobMnth;
    }

    public void setDobMnth(MenuButton DobMnth) {
        this.DobMnth = DobMnth;
    }
    
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
            }
       }
       );
       
       fab.setOnAction(new EventHandler<ActionEvent>() 
       {
            public void handle(ActionEvent t) 
            {
                DobMnth.setText(" Fabruary");
                MnthLbl.setVisible(true);
            }
       }
       );
       
       march.setOnAction(new EventHandler<ActionEvent>() 
       {
            public void handle(ActionEvent t) 
            {
                DobMnth.setText(" March");
                MnthLbl.setVisible(true);
            }
       }
       );
       
       april.setOnAction(new EventHandler<ActionEvent>() 
       {
            public void handle(ActionEvent t) 
            {
                DobMnth.setText(" April");
                MnthLbl.setVisible(true);
            }
       }
       );
       
       may.setOnAction(new EventHandler<ActionEvent>() 
       {
            public void handle(ActionEvent t) 
            {
                DobMnth.setText(" May");
                MnthLbl.setVisible(true);
            }
       }
       );
       
       june.setOnAction(new EventHandler<ActionEvent>() 
       {
            public void handle(ActionEvent t) 
            {
                DobMnth.setText(" June");
                MnthLbl.setVisible(true);
            }
       }
       );
       
       july.setOnAction(new EventHandler<ActionEvent>() 
       {
            public void handle(ActionEvent t) 
            {
                DobMnth.setText(" July");
                MnthLbl.setVisible(true);
            }
       }
       );
       
       aug.setOnAction(new EventHandler<ActionEvent>() 
       {
            public void handle(ActionEvent t) 
            {
                DobMnth.setText(" August");
                MnthLbl.setVisible(true);
            }
       }
       );
       
       sept.setOnAction(new EventHandler<ActionEvent>() 
       {
            public void handle(ActionEvent t) 
            {
                DobMnth.setText(" September");
                MnthLbl.setVisible(true);
            }
       }
       );
       
       oct.setOnAction(new EventHandler<ActionEvent>() 
       {
            public void handle(ActionEvent t) 
            {
                DobMnth.setText(" October");
                MnthLbl.setVisible(true);
            }
       }
       );
       
       nov.setOnAction(new EventHandler<ActionEvent>() 
       {
            public void handle(ActionEvent t) 
            {
                DobMnth.setText(" November");
                MnthLbl.setVisible(true);
            }
       }
       );
       
       dec.setOnAction(new EventHandler<ActionEvent>() 
       {
            public void handle(ActionEvent t) 
            {
                DobMnth.setText(" December");
                MnthLbl.setVisible(true);
            }
       }
       );
       
    }

    @FXML
    private JFXTextField DobYear;
    public JFXTextField getDobYear() {
        return DobYear;
    }

    public void setDobYear(JFXTextField DobYear) {
        this.DobYear = DobYear;
    }
    

    @FXML
    private JFXTextField DobDay;
    public JFXTextField getDobDay() {
        return DobDay;
    }

    public void setDobDay(JFXTextField DobDay) {
        this.DobDay = DobDay;
    }
}