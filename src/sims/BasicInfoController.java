package sims;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.Initializable;


import com.jfoenix.controls.JFXDatePicker;
import com.jfoenix.controls.JFXTextField;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;

import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.scene.control.Tooltip;
import java.util.regex.Pattern;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;


import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import javafx.scene.control.MenuItem;
import javafx.scene.control.MenuButton; 
import javafx.scene.control.Label;
import java.util.Optional;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ButtonType;



public class BasicInfoController implements Initializable 
{

    private final String errorStyle = "-fx-border-color: #ff2323; -fx-text-fill: white; -fx-prompt-text-fill: white; ";
    
    
    BasicInfoData dataClass = BasicInfoData.getInstance();      
        
    @FXML
    private Pane edit1;
            
    @FXML
    private JFXTextField name;
    
    @FXML
    public JFXTextField clgID;
    
    @FXML
    private JFXDatePicker dob;
            
    @FXML
    private JFXTextField course;
    
    @FXML
    private JFXTextField currSem;
    
    @FXML
    private JFXTextField contact;
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) 
    {  
        edit1.requestFocus();
                       
        name.setTooltip(new Tooltip ("use Fullname"));
        course.setTooltip(new Tooltip("eg. BE Computer Science"));
        
        setValues();
    }    
     
    ////////////////////////////////////////////////////////////////////////////
    // Set Values 
    
    public void setValues()
    {
        String tmp1;
        int tmp2;
        
        tmp1 = dataClass.getNameVal();
        if(tmp1 != null)
        {
            name.setText(tmp1);
        }
        
        
        tmp1 = dataClass.getClgIDVal();
        if(tmp1 != null)
        {
            clgID.setText(tmp1);
        }
        
        
        int year = dataClass.getYearVal();
        int month = dataClass.getMonthVal();
        int day = dataClass.getDayVal();
        
        if(year != 0 && month != 0 && day != 0)
        {
            String date = String.format("%02d", month) +"-"+ String.format("%02d", day) +"-"+ String.format("%04d",year); //02-03-0002
            
            System.out.println(date);
            
            dob.setValue(LocalDate.parse(date, DateTimeFormatter.ofPattern("MM-dd-yyyy"))); 
        }
        
        
        tmp1 = dataClass.getCourseVal();
        if(tmp1 != null)
        {
            course.setText(tmp1);
        }
        
        
        tmp2 = dataClass.getCurrSemVal();
        if(tmp2 != 0)
        {
            currSem.setText(Integer.toString(tmp2));
        }
        
        
        tmp1 = dataClass.getContactVal();
        if(tmp1 != null)
        {
            contact.setText(tmp1);
        }
    }
    
    ////////////////////////////////////////////////////////////////
    
    public void getName() throws NullPointerException
    {       
        String tmp = name.getText();
        if(tmp == null || !Pattern.compile("[a-zA-Z]+", Pattern.CASE_INSENSITIVE).matcher(tmp).matches())
        { 
            name.setText(null);
            dataClass.setNameVal(null);
            name.setStyle(errorStyle);
            
            throw new NullPointerException("name null");
        } 
        
        else 
        { 
            name.setText(tmp);
            dataClass.setNameVal(tmp);            
        }
    }
    
    
    public void getClgID() throws NullPointerException
    {   
        String tmp = clgID.getText();
        
        if(tmp == null || tmp.trim().isEmpty())
        {
            clgID.setText(null);
            dataClass.setClgIDVal(null);
            clgID.setStyle(errorStyle);   
            
            throw new NullPointerException("clgID null");
        }
        else
        {
            clgID.setText(tmp);
            dataClass.setClgIDVal(tmp);        
        }              
    }
    
    public void getDate() throws NullPointerException
    {
        LocalDate date = dob.getValue();
        
        /*dataClass.setYearVal(date.getYear());
            dataClass.setMonthVal(date.getMonthValue());
            dataClass.setDayVal(date.getDayOfMonth()); 
        
            dob.setStyle(successStyle);*/
        
        if(date != null)
        {
            dataClass.setYearVal(date.getYear());
            dataClass.setMonthVal(date.getMonthValue());
            dataClass.setDayVal(date.getDayOfMonth());
        }
        
        else
        {
            dataClass.setYearVal(0);
            dataClass.setMonthVal(0);
            dataClass.setDayVal(0); 
            
            dob.setStyle(errorStyle);
            throw new NullPointerException("dob null");
        }
        
    }
               
    
    public void getCourse() throws NullPointerException
    {       
        String tmp = course.getText();               
        if(tmp == null || !Pattern.compile("[a-zA-Z0-9 -]+", Pattern.CASE_INSENSITIVE).matcher(tmp).matches())
        { 
            course.setText(null);
            dataClass.setCourseVal(null);
            course.setStyle(errorStyle); 
            
            throw new NullPointerException("course null");
        } 
        
        else 
        { 
            course.setText(tmp);
            dataClass.setCourseVal(tmp);
        }        
    }
    
    
    public void getCurrSem() throws NullPointerException
    {          
        String tmp = currSem.getText();
        if (tmp != null) 
        {
            try 
            {
                dataClass.setCurrSemVal(Integer.parseInt(tmp));
                currSem.setText(tmp);
            } 
            catch (NumberFormatException e) 
            {
                currSem.setText(null);
                dataClass.setCurrSemVal(0);
                currSem.setStyle(errorStyle);
                
                throw new NullPointerException("currSem null");
            }
        }
        else
        {
            currSem.setText(null);
            dataClass.setCurrSemVal(0);
            currSem.setStyle(errorStyle);
            
            throw new NullPointerException("currSem null");
        }
    }
    
    
    public void getContact() throws NullPointerException
    {  
        String tmp = contact.getText();       
        if(tmp == null || !Pattern.compile("^[+]?([0-9]{2,3})?[-]?[0-9]{10}$").matcher(tmp).matches())
        { 
            contact.setText(null);
            dataClass.setContactVal(null);
            contact.setStyle(errorStyle);
            
            throw new NullPointerException("contact null");
        } 
        
        else 
        { 
            contact.setText(tmp);
            dataClass.setContactVal(tmp);
        }
    } 
    
    ////////////////////////////////////////////////////////////////////////////
    // Validate Input
    
    public void ValidateFields()
    {
       getName();
       getClgID();
       getDate();
       getCourse();
       getCurrSem();
       getContact();
    }
    
    ////////////////////////////////////////////////////////////////////////////
    // Changing to different page
    
    public void toNextPg(MouseEvent event) //this function allows to transport to another tab without opening another window and same goes for other 2 functions
    {                  
        try 
        {
            ValidateFields(); //save the fields value
            
            Parent editPag1 = FXMLLoader.load(getClass().getResource("Editing2.fxml"));
            Scene editPg1Scene = new Scene(editPag1);
            Stage appStage = (Stage)((Node)event.getSource()).getScene().getWindow();
            appStage.setScene(editPg1Scene);
            appStage.show();
            
        } 
        catch (Exception e) 
        {
            System.err.println(e.getMessage());
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
        catch (Exception e) 
        {
            System.err.println(e.getMessage());
        }
    }
}