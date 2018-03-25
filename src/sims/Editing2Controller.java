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
import javafx.scene.layout.VBox;
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
        getPostSSDwn();
        
    }  
    
    
    @FXML
    private Pane Edit2;
    
    
    @FXML
    private Label BtnTo1;
    
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
    private Label BtnTo2;
    
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
    
    

    /////////////////////////////////////////////Secondary School Fields
    @FXML
    private JFXTextField SPentg;

    @FXML
    private JFXTextField SRoll;

    @FXML
    private JFXTextField SMed;

    @FXML
    private JFXTextField SSch;

    @FXML
    private JFXTextField SBrd;

    @FXML
    private JFXTextField SCity;

    @FXML
    private JFXTextField SPass;
    
    
    ///////////////////////////////////High School Fields/////////////////////////
    @FXML
    private Pane HPane;
    
    @FXML
    private JFXTextField HPass;
    
    @FXML
    private JFXTextField HBrd;
    
    @FXML
    private JFXTextField HMed;

    @FXML
    private JFXTextField HCity;
    

    @FXML
    private JFXTextField HSSch;
    
    @FXML
    private JFXTextField HPentg;
    
    @FXML
    private JFXTextField HRoll;
    
    @FXML
    private MenuButton PostSS;
    
    @FXML
    private MenuItem HSSC;
    
    @FXML
    private MenuItem DIPLOMA;
    
    public void getPostSSDwn()
    {
                
       HSSC.setOnAction(new EventHandler<ActionEvent>() 
       {
            public void handle(ActionEvent t) 
            {
                PostSS.setText("  HSSC");
                
            }
       }
       );
       
       DIPLOMA.setOnAction(new EventHandler<ActionEvent>() 
       {
            public void handle(ActionEvent t) 
            {
                PostSS.setText("  DIPLOMA");
            }
       }
       );
    }
    
    ////////////////////////////Engineering Fields
        
    @FXML
    private JFXTextField EPentg;
    
    @FXML
    private MenuButton ESem;
    
    public void createESem()
    {
        
        
        
    }

    //////////////////////////////////////Postgraduation Fields
      
    @FXML
    private JFXTextField PPentg; 
    
    @FXML
    private MenuButton PSem;

    
    
    
    
}
