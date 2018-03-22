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
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.shape.Circle;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;


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
    
    


    @FXML
    private Label CloseBtn;
    
        
    
    @FXML
    private JFXTextField SPentg;

    @FXML
    private JFXTextField SSch;

    @FXML
    private JFXTextField HPass;

    @FXML
    private JFXTextField HCity;

    @FXML
    private JFXTextField SBrd;

    @FXML
    private JFXTextField SRoll;

    @FXML
    private Circle BtnTo3;

    @FXML
    private JFXTextField HBrd;

    @FXML
    private Circle BtnTo2;

    @FXML
    private JFXTextField HMark;

    @FXML
    private Circle BtnTo1;

    @FXML
    private JFXTextField SCity;

    @FXML
    private VBox menuBar;

    @FXML
    private Pane HSch;

    @FXML
    private JFXTextField SPass;

    @FXML
    private JFXTextField SMark;

    @FXML
    private JFXTextField HPentg;

    @FXML
    private JFXTextField HRoll;

    @FXML
    private JFXTextField SMed;
    
    @FXML
    void handleClose(MouseEvent event)
    {
        //Platform.exit();
        System.exit(0);
        /* get a handle to the stage
        Stage stage = (Stage) CloseBtn.getScene().getWindow();
        // do what you have to do
        stage.close();*/
    }
    
}
