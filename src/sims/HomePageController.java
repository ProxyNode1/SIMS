package sims;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.Initializable;


import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;


import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.Label;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import com.jfoenix.controls.JFXButton;
import javafx.scene.paint.Paint;



public class HomePageController implements Initializable 
{
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
    
    
    @FXML
    private Pane homePage;
    
    @FXML
    public Label StatusBtn;
    
    @FXML
    private JFXButton addData;
    
    Connection h = null;   
    ObservableList<InputClass> ip;
     
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) 
    {
        homePage.requestFocus();
        h = DatabaseCon.connect();
             
        if(h == null)
        {
            StatusBtn.setTextFill(Paint.valueOf("RED"));
            StatusBtn.setText("*Warning, Database Connection Cannot Be Established!"); 
        }
        
        else
        {
            StatusBtn.setTextFill(Paint.valueOf("SPRINGGREEN"));
            StatusBtn.setText("Database Connection Established!"); 
        }
        
        //String g = Editing1Controller.oldName;
        
        FillTable();
    }
    
    
    public void AddData(MouseEvent event) 
    {        
        try 
        {
           
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
    
    
    public void FillTable()
    {

        ip = FXCollections.observableArrayList();

        try
        {
            Statement myStmt = h.createStatement();
            ResultSet myRs = myStmt.executeQuery("select * from studentinfoschema.basic_info");
            while(myRs.next())
            {
                ip.add(new InputClass("   "+myRs.getString(2), "   "+myRs.getString(1).toUpperCase(), "   "+myRs.getString(3).toUpperCase(), "   "+myRs.getInt(5), "   "+myRs.getString(4).toUpperCase(), "   "+myRs.getString(6)));
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
    }
    
    
    /* public void OpenEntry(MouseEvent event) 
    {
        
        if(event.getClickCount() == 2) //on double click
        {
            try 
            {
                InputClass person = Table.getSelectionModel().getSelectedItem();
                String x = person.getName(); 
                
                String b = x.trim();
                System.out.println(b);
                //(Editing1Controller.oldName) = b;
                //Editing1Controller.ui = 0;
            
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
    }*/
  
}   