package sims;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.Initializable;



import com.jfoenix.controls.JFXButton;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
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
        
                       
        StatusBtn0.setText(a);
        
        h = DatabaseCon.connect();
        
        //String g = Editing1Controller.useName;
    }
    
    public static String a;
    
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
    
    
    /*public ObservableList<InputClass> getInput()
    {
        ObservableList<InputClass> ip = FXCollections.observableArrayList();
        ip.add(new InputClass( 33, "Saurabh Sutar", "CSE", 6, "Undergraduation", "9987248564")); //add values to table
        ip.add(new InputClass( 8, "Ashwini Dhale", "CSE", 6, "Undergraduation", "8587515673"));
        ip.add(new InputClass( 32, "Sapna Choksey", "CIVIL", 6, "Undergraduation", "7865112684"));
        ip.add(new InputClass( 26, "Rohan Majrikar", "ENC", 6, "Undergraduation", "9172856789"));
        ip.add(new InputClass( 43, "Vikramaditya Thakur", "MECH", 6, "Undergraduation", "9425990093"));
        
        return ip;
    }*/
    
    ObservableList<InputClass> ip;
    Connection h;
    
    
    public void TableOP()
    {

        ip = FXCollections.observableArrayList();

        try
        {
            Statement myStmt = h.createStatement();
            ResultSet myRs = myStmt.executeQuery("select * from student_info_schema.ssc_info");
            while(myRs.next())
            {
                ip.add(new InputClass(myRs.getString(2), myRs.getString(1), myRs.getString(3), myRs.getInt(5), myRs.getString(4), myRs.getString(6)));
                /*String s = myRs.getString(2); //2 is the column number
                System.out.println(s); 
                System.out.println(myRs.getInt(1)); */
            }
        }
        
        catch(Exception e)
        {
            e.printStackTrace();
        }
        
        clgIDCol.setCellValueFactory(new PropertyValueFactory<>("collegeId")); //take value from sno from its class
        nameCol.setCellValueFactory(new PropertyValueFactory<>("name"));
        branchCol.setCellValueFactory(new PropertyValueFactory<>("branch"));
        CsemCol.setCellValueFactory(new PropertyValueFactory<>("Csem"));
        currentEduCol.setCellValueFactory(new PropertyValueFactory<>("currentEdu"));
        contactCol.setCellValueFactory(new PropertyValueFactory<>("contact"));
        
        
        Table.setItems(null);
        Table.setItems(ip);
        //Table.getColumns().addAll(clgIDCol, nameCol, branchCol, CsemCol, currentEduCol, contactCol);
    }
    
    
    
 
    @FXML
    private Pane Mpage;
     
    
        
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
    public Label StatusBtn0;
    

    
    public void clickItem(MouseEvent event) //this will allow to view info of students
    {
        if(event.getClickCount() == 2) //on double click
        {
            //StatusBtn0.setVisible(true);
        }
    }

}   