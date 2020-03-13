package sims;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.Initializable;


import com.jfoenix.controls.JFXTextField;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextArea;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import java.util.regex.Pattern;


import javafx.scene.control.Tooltip;
import javafx.scene.control.Label;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXCheckBox;
import java.sql.*;
import java.util.Optional;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;



/**
 * FXML Controller class
 *
 * @author VIC's
 */
public class Editing3Controller implements Initializable {

        
    private String errorStyle = "-fx-border-color: #ff2323; -fx-text-fill: white; -fx-prompt-text-fill: white; ";
    private String successStyle = "-fx-border-color: #23ff23; -fx-text-fill: white; -fx-prompt-text-fill: white; ";
    
    //private String personMailVal = null, universityMailVal = null, dadContactVal = null, famContactVal = null, addInfoVal = null;
   
    Editing3Data dataClass = Editing3Data.getInstance();
    
    @FXML
    private Pane edit3;
       
    @FXML
    private JFXTextField personMail;
    
    @FXML
    private JFXTextField universityMail;
                
    @FXML
    private JFXTextField dadContact;
    
    @FXML
    private JFXTextField famContact;
       
    @FXML
    private TextArea addInfo;
            
       
    @Override
    public void initialize(URL url, ResourceBundle rb) 
    {
        edit3.requestFocus();

        /*if(Editing1Controller.ui  == 1)
        {
            try
            {
                s1 = Editing1Controller.newName;
                System.out.println(s1);
                Editing1Controller.setValues();
                e = 0;
            }
            catch(Exception x)
            {
                e = 1;
                errbtn.setText("Check input fields again!"); 
            }
        }*/
        
        //addInfo.setTooltip(new Tooltip("use '. ' after every statement. "));
            
        //h = DatabaseCon.connect();
        //operation();

    }    
        
    ///////////////////////////////////////////////////////////////////////////
    // Set Values
    
    public void setPersonMail()
    {           
        String tmp = personMail.getText();
        if(tmp == null || !Pattern.compile("^(.+@.+)$", Pattern.CASE_INSENSITIVE).matcher(tmp).matches())            
        { 
            personMail.setText(null);             
            dataClass.setPersonMailVal(null);
            personMail.setStyle(errorStyle);
            System.out.println("false");
        } 
        else 
        {                            
            dataClass.setPersonMailVal(tmp);
            personMail.setStyle(successStyle); 
        }
        
    }
    
    
    public void setUnivMail()
    {   
        String tmp = universityMail.getText();
        if(tmp == null  || !Pattern.compile("^(.+@.+)$", Pattern.CASE_INSENSITIVE).matcher(tmp).matches())            
        {            
            universityMail.setText(null);
            dataClass.setUniversityMailVal(null);
            universityMail.setStyle(errorStyle);
            System.out.println("false");
        }
        else 
        {           
            dataClass.setUniversityMailVal(tmp);            
            universityMail.setStyle(successStyle); 
        }        
    }
    
    
    public void setDadContact() 
    {   
        String tmp = dadContact.getText();        
        if(tmp == null || !Pattern.compile("^[+]?([0-9]{2,3})?[-]?[0-9]{10}$").matcher(tmp).matches())
        {
            dadContact.setText(null);
            dataClass.setDadContactVal(null);
            dadContact.setStyle(errorStyle);
            System.out.println("Fathers Contact failed");            
        }
        else
        {   
            dataClass.setDadContactVal(tmp);
            dadContact.setStyle(successStyle);                
        }
    }
    
    
    public void setFamContact()
    {   
        String tmp = famContact.getText();        
        if(tmp == null || !Pattern.compile("^[+]?([0-9]{2,3})?[-]?[0-9]{10}$").matcher(tmp).matches())
        {
            famContact.setText(null);
            dataClass.setFamContactVal(null);
            famContact.setStyle(errorStyle);
            System.out.println("Family Contact failed");            
        }      
        else
        {             
            dataClass.setFamContactVal(tmp);            
            famContact.setStyle(successStyle);   
        }
    }
    
    
    public void setAddInfo()
    {  
        dataClass.setAddInfoVal(addInfo.getText());
        //addInfo.setStyle(successStyle);         
    }
    
             
    public void toSave(MouseEvent event)
    {        
        
        DatabaseIO Connection = new DatabaseIO();
        
        Connection.InsertValues();
        
        try 
        {
            Parent editPag1 = FXMLLoader.load(getClass().getResource("HomePage.fxml"));
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
    
    
    public void toPrevPg(MouseEvent event)
    {
        try 
        {
            Parent editPag1 = FXMLLoader.load(getClass().getResource("Editing2.fxml"));
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
       
    
    public void toHomepg(MouseEvent event)
    {
        try 
        {
            Parent editPag1 = FXMLLoader.load(getClass().getResource("HomePage.fxml"));
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
    
    
}
