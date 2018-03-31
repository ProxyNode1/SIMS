package sims;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.Initializable;



import com.jfoenix.controls.JFXButton;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.layout.VBox;
import javafx.scene.control.Label;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;





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
        TableOP();               
       
    }
    
    @FXML 
    private  TableView<InputClass> Table = new TableView<>();
      
       
    @FXML 
    private  TableColumn<InputClass, Integer> clgIDCol = new TableColumn<>();  
            
    @FXML
    private  TableColumn<InputClass, String> nameCol = new TableColumn<>();   
    
    @FXML 
    private  TableColumn<InputClass, String> branchCol = new TableColumn<>();   
    
    @FXML 
    private  TableColumn<InputClass, Integer> CsemCol = new TableColumn<>();    
    
    @FXML 
    private  TableColumn<InputClass, String> currentEduCol = new TableColumn<>();   
    
    @FXML 
    private  TableColumn<InputClass, String> contactCol = new TableColumn<>();   
    
    
    public ObservableList<InputClass> getInput()
    {
        ObservableList<InputClass> ip = FXCollections.observableArrayList();
        ip.add(new InputClass( 33, "Saurabh", "CSE", 6, "Undergraduation", "9987248564")); //add values to table
        ip.add(new InputClass( 8, "Ashwini", "CSE", 6, "Undergraduation", "8587515673"));
        ip.add(new InputClass( 32, "Sapna", "CSE", 6, "Undergraduation", "7865112684"));
        ip.add(new InputClass( 26, "Rohan", "CSE", 6, "Undergraduation", "9172856789"));
        ip.add(new InputClass( 43, "Vikram", "CSE", 6, "Undergraduation", "9425990093"));
        
        return ip;
    }
    public void TableOP()
    {
        clgIDCol.setCellValueFactory(new PropertyValueFactory<>("collegeId")); //take value from sno from its class
        nameCol.setCellValueFactory(new PropertyValueFactory<>("name"));
        branchCol.setCellValueFactory(new PropertyValueFactory<>("branch"));
        CsemCol.setCellValueFactory(new PropertyValueFactory<>("Csem"));
        currentEduCol.setCellValueFactory(new PropertyValueFactory<>("currentEdu"));
        contactCol.setCellValueFactory(new PropertyValueFactory<>("contact"));
        
        Table.setItems(getInput());
        //Table.getColumns().addAll(clgIDCol, nameCol, branchCol, CsemCol, currentEduCol, contactCol);
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
    public void toEdit(MouseEvent event) //this function allow add new person to the database and show them in table, after filling their details
    {
        
        
        try {
           
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
    private Label StatusBtn;

}   