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

    @Override
    public void initialize(URL url, ResourceBundle rb) 
    {
        getInput();
        TableOP();        
       
    }
    
    @FXML
    private final TableView<InputClass> Table = new TableView<>();
       
    @FXML 
    private final TableColumn<InputClass, Integer> snoCol = new TableColumn<>("S No.");  
    
    @FXML 
    private final TableColumn<InputClass, Integer> clgIDCol = new TableColumn<>("College ID");  
            
    @FXML
    private final TableColumn<InputClass, String> nameCol = new TableColumn<>("Name");   
    
    @FXML 
    private final TableColumn<InputClass, String> branchCol = new TableColumn<>("Branch");   
    
    @FXML 
    private final TableColumn<InputClass, Integer> CsemCol = new TableColumn<>("Current Sem");    
    
    @FXML 
    private final TableColumn<InputClass, String> currentEduCol = new TableColumn<>("Current Education");   
    
    @FXML 
    private final TableColumn<InputClass, String> contactCol = new TableColumn<>("Contact");   
    
    public ObservableList<InputClass> getInput()
    {
        
        
        ObservableList<InputClass> ip = FXCollections.observableArrayList();
        ip.add(new InputClass(1, 33, "Saurabh", "CSE", 6, "Undergraduation", "9987248564")); //add values to table
        ip.add(new InputClass(2, 8, "Ashwini", "CSE", 6, "Undergraduation", "8587515673"));
        ip.add(new InputClass(3, 32, "Sapna", "CSE", 6, "Undergraduation", "7865112684"));
        ip.add(new InputClass(4, 26, "Rohan", "CSE", 6, "Undergraduation", "91728567895"));
        ip.add(new InputClass(5, 43, "Vikram", "CSE", 6, "Undergraduation", "9425990093"));
        
        return ip;
    }
    public void TableOP()
    {
        snoCol.setCellValueFactory(new PropertyValueFactory<>("sno")); //take value from sno from its class
        clgIDCol.setCellValueFactory(new PropertyValueFactory<>("collegeId"));
        nameCol.setCellValueFactory(new PropertyValueFactory<>("name"));
        branchCol.setCellValueFactory(new PropertyValueFactory<>("branch"));
        CsemCol.setCellValueFactory(new PropertyValueFactory<>("Csem"));
        currentEduCol.setCellValueFactory(new PropertyValueFactory<>("currentEdu"));
        contactCol.setCellValueFactory(new PropertyValueFactory<>("contact"));
        
        Table.setItems(getInput());
        Table.getColumns().addAll(snoCol, clgIDCol, nameCol, branchCol, CsemCol, currentEduCol, contactCol);
    }
    

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
    
    @FXML
    private Label StatusBtn;

}    
    

