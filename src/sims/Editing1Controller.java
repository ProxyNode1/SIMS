/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sims;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.scene.shape.Circle;








/**
 *
 * @author VIC's
 */
public class Editing1Controller implements Initializable 
{
    @Override
    public void initialize(URL url, ResourceBundle rb) 
    {
       System.out.println("lele");
        Gen.requestFocus();
        
    }  
    
    @FXML
     private Label Gen;

    @FXML
    private JFXTextField NameTXT;

    @FXML
    private JFXTextField idTXT;

    @FXML
    private JFXTextField dobTXT;

    @FXML
    private JFXTextField cntctTXT;

    @FXML
    private JFXTextField semTXT;

    @FXML
    private JFXTextField branchTXT;

    @FXML
    private VBox menuBar;

    @FXML
    private Circle BtnTo2;

    @FXML
    private Circle BtnTo1;

    @FXML
    private Circle BtnTo3;
    
    

      
    
}
