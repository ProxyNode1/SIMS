package sims;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.Initializable;


import com.jfoenix.controls.JFXDatePicker;
import com.jfoenix.controls.JFXTextField;
import javafx.fxml.FXML;
import javafx.scene.control.Tooltip;
import java.util.regex.Pattern;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;





public class BasicInfoController implements Initializable 
{
    @Override
    public void initialize(URL url, ResourceBundle rb) 
    {  
              
        course.setTooltip(new Tooltip("eg. BE Computer Science"));
        
        setValues();
    }    
     
    ////////////////////////////////////////////////////////////////////////////
    // Set Values 
    
    public void setValues()
    {
        String tmp1;
        int tmp2;
        
        
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
            dataClass.setClgIDVal(tmp); 
            clgID.setStyle(null);       
        }              
    }
    
    
    public void getDate() throws NullPointerException
    {
        LocalDate date = dob.getValue();
        
        /*dataClass.setYearVal(date.getYear());
            dataClass.setMonthVal(date.getMonthValue());
            dataClass.setDayVal(date.getDayOfMonth()); */
                
        if(date != null)
        {
            dataClass.setYearVal(date.getYear());
            dataClass.setMonthVal(date.getMonthValue());
            dataClass.setDayVal(date.getDayOfMonth());
            dob.setStyle(null);
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
            dataClass.setCourseVal(tmp);
            course.setStyle(null);
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
                currSem.setStyle(null);
                
            } 
            catch (NumberFormatException e) 
            {
                currSem.setText(null);
                dataClass.setCurrSemVal(0);
                currSem.setStyle(errorStyle);
                
                throw new NullPointerException("currSem1 null");
            }
        }
        else
        {
            currSem.setText(null);
            dataClass.setCurrSemVal(0);
            currSem.setStyle(errorStyle);
            
            throw new NullPointerException("currSem2 null");
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
            contact.setStyle(null);
        }
    } 
    
    ////////////////////////////////////////////////////////////////////////////
    // Validate Input
    
    public void ValidateFields()
    {       
       getClgID();
       getDate();
       getCourse();
       getCurrSem();
       getContact();
    }
    
    
    public void SetFieldEditable(boolean Value)
    {
        clgID.setEditable(Value);
        clgID.setDisable(!Value);
        
        dob.setEditable(Value);
        dob.setDisable(!Value);
        
        course.setEditable(Value);
        course.setDisable(!Value);
        
        currSem.setEditable(Value);
        currSem.setDisable(!Value);
        
        contact.setEditable(Value);
        contact.setDisable(!Value);
    }
    
            

    private final String errorStyle = "-fx-border-color: #ff2323;";
    
    
    private final BasicInfoData dataClass = BasicInfoData.getInstance();      
        
        
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
}