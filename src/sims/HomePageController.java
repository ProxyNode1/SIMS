/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sims;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.Initializable;



import com.jfoenix.controls.JFXButton;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.layout.VBox;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;



/**
 * FXML Controller class
 *
 * @author VIC's
 */
public class HomePageController implements Initializable {

    
    @Override
    public void initialize(URL url, ResourceBundle rb) 
    {
               
    }



    

    @FXML
    private VBox menuBar;
    
     @FXML
    private TableView<?> Table;

    @FXML
    private TableColumn<?, ?> ClgID;
     
    @FXML
    private TableColumn<?, ?> Name;
     
    @FXML
    private TableColumn<?, ?> Branch;

    @FXML
    private TableColumn<?, ?> Contect;
    
    @FXML
    private TableColumn<?, ?> CurrSem;
    
    
    @FXML
    private Label CloseBtn;
    
    
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
    
    @FXML
    private JFXButton addRow;

}    
    

