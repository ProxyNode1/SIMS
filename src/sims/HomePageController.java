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
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.layout.VBox;
import javafx.scene.control.Label;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;




/**
 * FXML Controller class
 *
 * @author VIC's
 */
public class HomePageController implements Initializable 
{

    @FXML
    private TableView<InputClass> Table = new TableView<InputClass>();
    
    
    
    
    
    
    
    @FXML 
    private TableColumn<?, Integer> SnoCol;  
    
    @FXML 
    private TableColumn<InputClass, Integer> clgIdCol;  
    
    @FXML
    private TableColumn<InputClass, String> nameCol;  
    
    @FXML 
    private TableColumn<InputClass, String> branchCol;  
    
    @FXML 
    private TableColumn<InputClass, Integer> CsemCol;  
    
    @FXML 
    private TableColumn<InputClass, String> currentEduCol;  
    
    @FXML 
    private TableColumn<InputClass, String> contectCol;  
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) 
    {
        /*//sets the columns
        SnoCol.setCellValueFactory("1");
        clgIdCol.setCellValueFactory(new PropertyValueFactory<InputClass, Integer>("clgId") );
        nameCol.setCellValueFactory(new PropertyValueFactory<InputClass, String>("name") );
        branchCol.setCellValueFactory(new PropertyValueFactory<InputClass, String>("branch") );
        CsemCol.setCellValueFactory(new PropertyValueFactory<InputClass, Integer>("Csem") );
        currentEduCol.setCellValueFactory(new PropertyValueFactory<InputClass, String>("currentEdu") );
        contectCol.setCellValueFactory(new PropertyValueFactory<InputClass, String>("contect") );
        */
    }
    
   private final ObservableList<InputClass> data = FXCollections.observableArrayList(new InputClass(new InputClass(26354, "Vikram", "CSE", 6, "Undergraduate", "9425990093")));
    
    Table.setItems(inpt);
    table.getColumns().addAll( clgId,  name,  branch,  Csem,  currentEdu, contect);


    

    @FXML
    private VBox menuBar;
    
    
    @FXML
    private Pane Mpage;
     

    
    @FXML
    private Label CloseBtn;
    
    
    @FXML
    void handleClose(MouseEvent event)
    {
        
        System.exit(0);
       
    }
    
    @FXML
    private JFXButton addRow;
    
    

}    
    

