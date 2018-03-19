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
import javafx.scene.control.MenuButton;
import javafx.scene.layout.VBox;
import javafx.scene.shape.Circle;
import javafx.scene.image.ImageView;


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
    private Circle BtnTo3;

    @FXML
    private Circle BtnTo2;

    @FXML
    private Circle BtnTo1;
    
    
    @FXML
    private ImageView CloseBtn;
    
    

    
}
