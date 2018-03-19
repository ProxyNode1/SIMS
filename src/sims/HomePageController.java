/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sims;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.Initializable;



import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import javafx.scene.control.TableView;
import com.jfoenix.controls.JFXButton;

/**
 * FXML Controller class
 *
 * @author VIC's
 */
public class HomePageController implements Initializable {

    
    @Override
    public void initialize(URL url, ResourceBundle rb) 
    {
        // TODO
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
    private ImageView CloseBtn;
    
    @FXML
    private JFXButton addRow;

}    
    

