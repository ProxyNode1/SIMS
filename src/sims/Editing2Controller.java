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
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.MenuButton;
import javafx.scene.layout.VBox;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import static sims.Sims.stage;




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
        
    }  
    
    Stage primaryStage = stage;
    @FXML
    private Pane Edit2;
    
    @FXML
    private Label BtnTo1;
    
    public void toEdit1(MouseEvent event)
     {
        try 
        {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("Editing1.fxml"));
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
    private Label BtnTo2;
    
    /*public void toEdit2(MouseEvent event)
    {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("Editing2.fxml"));
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
    private JFXTextField SPentg;

    @FXML
    private JFXTextField HMed;

    @FXML
    private JFXTextField HCity;

    @FXML
    private JFXTextField SSch11;

    @FXML
    private JFXTextField SRoll;

    @FXML
    private MenuButton EduBtn1;

    
    @FXML
    private JFXTextField HBrd;
    

    @FXML
    private JFXTextField HSSch;

    @FXML
    private VBox menuBar;

    @FXML
    private MenuButton EduBtn;

    @FXML
    private JFXTextField HPentg;

    @FXML
    private Label CloseBtn;

    @FXML
    private JFXTextField SMed;

    @FXML
    private JFXTextField SSch;

    @FXML
    private JFXTextField HPass;

    @FXML
    private JFXTextField SBrd;

    

    @FXML
    private JFXTextField SCity;

    @FXML
    private JFXTextField SPass;

    @FXML
    private JFXTextField SSch1;

    @FXML
    private MenuButton PostSS;

    

    @FXML
    private JFXTextField HRoll;

    
    @FXML
    void handleClose(MouseEvent event)
    {
        
        System.exit(0);
        
    }
    
}
