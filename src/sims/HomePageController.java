package sims;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.Initializable;


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
import javafx.scene.paint.Paint;
import java.io.IOException;
import java.sql.SQLException;


import java.sql.ResultSet;


import java.sql.Statement;
import com.jfoenix.controls.JFXButton;
import com.sun.javafx.collections.ElementObservableListDecorator;




public class HomePageController implements Initializable 
{    
    @Override
    public void initialize(URL url, ResourceBundle rb) 
    {
        homePage.requestFocus();
                
        if(DatabaseCon.connect() == null)
        {
            StatusBtn.setTextFill(Paint.valueOf("RED"));
            StatusBtn.setText("*Warning, Database Connection Cannot Be Established!"); 
        }
        
        else
        {
            StatusBtn.setTextFill(Paint.valueOf("SPRINGGREEN"));
            StatusBtn.setText("Database Connection Established!"); 
        }
        
        FillTable();
    }
    
    
    public void FillTable()
    {
        ObservableList<HomePageData> observableList = FXCollections.observableArrayList(); //Observalble List with on ArrayList Feature
                 
        try
        {                        
            ResultSet resultSet = dbIO.getBasicInfoForTable();
            
            if(resultSet == null)
            {
                System.out.println("fked");
                return;
            }
            
            while(resultSet.next()) //while there is one more row....
            {
                
                
                observableList.add(new HomePageData(
                        resultSet.getString(2),                // College ID
                        resultSet.getString(1),                // Name
                        resultSet.getString(4).toUpperCase(),  // Course
                        resultSet.getInt(5),                   // Current Sem
                        resultSet.getString(6)                 //Contact
                ));
                
                
                /*String tmp = "This: "+ resultSet.getString(2) +
                        "   "+ resultSet.getString(1) +  
                        "   "+ resultSet.getString(4).toUpperCase() + 
                        "   "+ resultSet.getInt(5) + 
                        "   "+ resultSet.getString(6); 
            
                System.out.println(tmp);*/
                //System.out.println(observableList.get(0).getName());
            }
            
        }
        
        catch(SQLException e)
        {
            System.err.println(e.getMessage());
        }
        
        clgIDColumn.setCellValueFactory(new PropertyValueFactory<>("collegeId")); //the argument is a data class variable
        nameColumn.setCellValueFactory(new PropertyValueFactory<>("name"));
        courseColumn.setCellValueFactory(new PropertyValueFactory<>("course"));
        currSemColumn.setCellValueFactory(new PropertyValueFactory<>("currSem"));
        contactColumn.setCellValueFactory(new PropertyValueFactory<>("contact"));        
        
        //Table.setItems(null);
        Table.setItems(observableList);
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
        catch (IOException e) 
        {
            System.err.println(e.getMessage());
        }
    }
    
    
    public void OpenEntry(MouseEvent event) 
    {
        
        if(event.getClickCount() == 2) //on double click
        {
            try 
            {
                BasicInfoData Edit1Data = BasicInfoData.getInstance();
                HomePageData person = Table.getSelectionModel().getSelectedItem();
                Edit1Data.setOldNameVal(person.getName()); 
                
                dbIO.getBasicInfo();
                           
                
                
                //(Editing1Controller.oldName) = b;
                //Editing1Controller.ui = 0;
            
                /*Parent editPag1 = FXMLLoader.load(getClass().getResource("Editing1.fxml"));
                Scene editPg1Scene = new Scene(editPag1);
                Stage appStage = (Stage)((Node)event.getSource()).getScene().getWindow();
                appStage.setScene(editPg1Scene);
                appStage.show();*/

            } 
            catch (Exception e) 
            {
                System.err.println(e.getMessage());
            }

        }
    }
    
    
    private final DatabaseIO dbIO = new DatabaseIO();
    
    @FXML
    private  final Pane homePage = new Pane();
    
    @FXML
    public final Label StatusBtn = new Label();
    
    @FXML 
    private final TableView<HomePageData> Table = new TableView<HomePageData>();
    
    @FXML 
    private final TableColumn<HomePageData, String> clgIDColumn = new TableColumn<HomePageData, String>();  
            
    @FXML
    private final TableColumn<HomePageData, String> nameColumn = new TableColumn<HomePageData, String>();   
    
    @FXML 
    private final TableColumn<HomePageData, String> courseColumn = new TableColumn<HomePageData, String>();   
    
    @FXML 
    private final TableColumn<HomePageData, Integer> currSemColumn = new TableColumn<HomePageData, Integer>();    
        
    @FXML 
    private final TableColumn<HomePageData, String> contactColumn = new TableColumn<HomePageData, String>(); 
  
}   