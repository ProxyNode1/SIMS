/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sims;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.Initializable;

import com.jfoenix.controls.JFXTextField;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.layout.VBox;
import javafx.scene.control.Label;
import javafx.scene.control.MenuButton; 
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import static sims.Sims.stage;





/**
 * FXML Controller class
 *
 * @author VIC's
 */
public class Editing1Controller implements Initializable {

   
    @Override
    public void initialize(URL url, ResourceBundle rb) 
    {
        NamFld.requestFocus();
        
        
    }    
    Stage primaryStage = stage;
     
    @FXML
    private VBox menuBar;

    @FXML
    private JFXTextField IdFld;

    @FXML
    private MenuButton EduBtn;

    @FXML
    private JFXTextField CntctFld;

    @FXML
    private JFXTextField DOBFld;

    @FXML
    private JFXTextField NamFld;

    @FXML
    private JFXTextField DpmtFld;

    @FXML
    private JFXTextField SemFld;
    
    @FXML
    private Label BtnTo1;
    
     /*public void toEdit1(MouseEvent event)
     {
        
         try 
        {
            
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("Editing1.fxml"));
            Parent root1 = (Parent) fxmlLoader.load();
            Stage stage = new Stage();
            stage.setScene(new Scene(root1));
            stage.initStyle(StageStyle.TRANSPARENT);
            stage.show();
        } 
        catch (Exception ex) 
        {
            ex.printStackTrace();
            
        }
    }*/

    
    @FXML
    private Label BtnTo2;
    
    public void toEdit2(MouseEvent event)
    {
        
        
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("Editing2.fxml"));
            Parent root1 = (Parent) fxmlLoader.load();
            Stage stage = new Stage();
            stage.setScene(new Scene(root1));
            stage.initStyle(StageStyle.UNDECORATED);
            stage.show();
            primaryStage.close();
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
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("Editing3.fxml"));
            Parent root1 = (Parent) fxmlLoader.load();
            Stage stage = new Stage();
            stage.setScene(new Scene(root1));
            stage.initStyle(StageStyle.UNDECORATED);
            stage.show();
            primaryStage.close();
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
    private Pane Edit1;
    
    

    
    
    
    

    
}
