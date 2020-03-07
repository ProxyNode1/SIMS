package sims;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.Initializable;


import com.jfoenix.controls.JFXTextField;
import java.io.IOException;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.MenuButton; 
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.scene.control.MenuItem;
import javafx.scene.control.Tooltip;
import javafx.scene.control.Label;
import java.util.regex.Pattern;


import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Optional;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ButtonType;



public class Editing1Controller implements Initializable 
{

    private final String errorStyle = "-fx-border-color: #ff2323; -fx-text-fill: white; -fx-prompt-text-fill: white; ";
    private final String successStyle = "-fx-border-color: #23ff23; -fx-text-fill: white; -fx-prompt-text-fill: white; ";
    
    Editing1Data dataclass;       
        
    @FXML
    private Pane edit1;
            
    @FXML
    private JFXTextField name;
    
    @FXML
    public JFXTextField clgID;
    
    @FXML
    private JFXTextField dobYear;
    
    @FXML
    private MenuButton dobMonth;
               
    @FXML
    private MenuItem january;
    
    @FXML
    private MenuItem faburary;

    @FXML
    private MenuItem march; 

    @FXML
    private MenuItem april;
    
    @FXML
    private MenuItem may;

    @FXML
    private MenuItem june;

    @FXML
    private MenuItem july;
    
    @FXML
    private MenuItem august;
    
    @FXML
    private MenuItem september;
    
    @FXML
    private MenuItem october;

    @FXML
    private MenuItem november;
    
    @FXML
    private MenuItem december;
    
    @FXML
    private Label monthLbl;
    
    @FXML
    private JFXTextField dobDay;
    
    @FXML
    private JFXTextField course;
    
    @FXML
    private JFXTextField currSem;
    
    @FXML
    private JFXTextField contact;
         
    
    public Editing1Controller()
    {
        dataclass = Editing1Data.getInstance();
    }
            
    @Override
    public void initialize(URL url, ResourceBundle rb) 
    {  
        edit1.requestFocus();
                       
        name.setTooltip(new Tooltip ("use Fullname"));
        dobYear.setTooltip(new Tooltip("eg. YYYY"));
        course.setTooltip(new Tooltip("eg. BE Computer Science"));
    }    
     
    ////////////////////////////////////////////////////////////////////////////
    // Set Values 
    
    public void setNameVal()
    {       
        String tmp = name.getText();
        if(tmp == null || !Pattern.compile("[a-zA-Z]+", Pattern.CASE_INSENSITIVE).matcher(tmp).matches())
        { 
            name.setText(null);
            dataclass.setNameVal(null);
            name.setStyle(errorStyle);
        } 
        
        else 
        { 
            name.setText(tmp);
            name.setStyle(successStyle);
            dataclass.setNameVal(tmp);            
        }
    }
    
    
    public void setClgIDVal()
    {   
        String tmp = clgID.getText();
        
        if(tmp == null || tmp.trim().isEmpty())
        {
            clgID.setText(null);
            dataclass.setClgIDVal(null);
            clgID.setStyle(errorStyle);   
        }
        else
        {
            clgID.setText(tmp);
            dataclass.setClgIDVal(tmp);
            clgID.setStyle(successStyle);         
        }              
    }
    
    
    int numDays = 0;
    
    public void setJanuary()
    {
        numDays = 31;
        dobMonth.setText("January");
        dataclass.setMonthVal("1");
        dobMonth.setStyle(successStyle);
        
        if (dataclass.getDayVal() < 1 || dataclass.getDayVal() > numDays) 
        {
            dobDay.setText(null);
            dataclass.setDayVal(0);
        }
    }
    
    public void setFabruary()
    {
        if (dataclass.getYearVal() % 4 == 0) 
        {
            numDays = 29;
        } 
        else 
        {
            numDays = 28;
        }
        dobMonth.setText("Fabruary");
        dataclass.setMonthVal("2");
        dobMonth.setStyle(successStyle);
        
        if (dataclass.getDayVal() < 1 || dataclass.getDayVal() > numDays) 
        {
            dobDay.setText(null);
            dataclass.setDayVal(0); 
        }
    }
    
    public void setMarch()
    {
        numDays = 31;
        dobMonth.setText("March");
        dataclass.setMonthVal("3");
        dobMonth.setStyle(successStyle);
        
        if (dataclass.getDayVal() < 1 || dataclass.getDayVal() > numDays) 
        {
            dobDay.setText(null);
            dataclass.setDayVal(0);
        }
    }
    
    public void setApril()
    {
        numDays = 30;
        dobMonth.setText("April");
        dataclass.setMonthVal("4");
        dobMonth.setStyle(successStyle);
        
        if (dataclass.getDayVal() < 1 || dataclass.getDayVal() > numDays) 
        {
            dobDay.setText(null);
            dataclass.setDayVal(0);
        }
    }
    
    public void setMay()
    {
        numDays = 31;
        dobMonth.setText("May");
        dataclass.setMonthVal("5");
        dobMonth.setStyle(successStyle);
        
        if (dataclass.getDayVal() < 1 || dataclass.getDayVal() > numDays) 
        {
            dobDay.setText(null);
            dataclass.setDayVal(0);
        }
    }
    
    public void setJune()
    {
        numDays = 30;
        dobMonth.setText("June");
        dataclass.setMonthVal("6");
        dobMonth.setStyle(successStyle);
        
        if (dataclass.getDayVal() < 1 || dataclass.getDayVal() > numDays) 
        {
            dobDay.setText(null);
            dataclass.setDayVal(0);
        }
    }
    
    public void setJuly()
    {
        numDays = 31;
        dobMonth.setText("July");
        dataclass.setMonthVal("7");
        dobMonth.setStyle(successStyle);
        
        if (dataclass.getDayVal() < 1 || dataclass.getDayVal() > numDays) 
        {
            dobDay.setText(null);
            dataclass.setDayVal(0);
        }
    }
    
    public void setAugust()
    {
        numDays = 31;
        dobMonth.setText("August");
        dataclass.setMonthVal("8");
        dobMonth.setStyle(successStyle);
        
        if (dataclass.getDayVal() < 1 || dataclass.getDayVal() > numDays) 
        {
            dobDay.setText(null);
            dataclass.setDayVal(0); 
        }
    }
    
    public void setSeptember()
    {
        numDays = 30;
        dobMonth.setText("September");
        dataclass.setMonthVal("9");
        dobMonth.setStyle(successStyle);
        
        if (dataclass.getDayVal() < 1 || dataclass.getDayVal() > numDays) 
        {
            dobDay.setText(null);
            dataclass.setDayVal(0);
        }
    }
    
    public void setOctober()
    {
        numDays = 31;
        dobMonth.setText("October");
        dataclass.setMonthVal("10");
        dobMonth.setStyle(successStyle);
        
        if (dataclass.getDayVal() < 1 || dataclass.getDayVal() > numDays) 
        {
            dobDay.setText(null);
            dataclass.setDayVal(0);
        }
    }
    
    public void setNovember()
    {
        numDays = 30;
        dobMonth.setText("November");
        dataclass.setMonthVal("11");
        dobMonth.setStyle(successStyle);
        
        if (dataclass.getDayVal() < 1 || dataclass.getDayVal() > numDays) 
        {
            dobDay.setText(null);
            dataclass.setDayVal(0);
        }
    }
    
    public void setDecember()
    {
        numDays = 31;
        dobMonth.setText("December");
        dataclass.setMonthVal("12");
        dobMonth.setStyle(successStyle);
        
        if (dataclass.getDayVal() < 1 || dataclass.getDayVal() > numDays) 
        {
            dobDay.setText(null);
            dataclass.setDayVal(0);
        }
    }
    
    
    public void setMonthVal()
    {
        monthLbl.setVisible(true);               
    }
       
        
    public void setDayVal()
    {  
        try
        {
            int tmp = Integer.parseInt(dobDay.getText()); 
            if (tmp != 0 && tmp <= 31 && tmp <= numDays ) 
            {
                dobDay.setText(String.valueOf(tmp)); 
                dataclass.setDayVal(tmp);
                dobDay.setStyle(successStyle);
            }
            else
            {
                dobDay.setText(null);
                dataclass.setDayVal(0);
                dobDay.setStyle(errorStyle);
            }
                       
        }
        
        catch(NumberFormatException e)
        {
            dobDay.setText(null);
            dataclass.setDayVal(0);
            dobDay.setStyle(errorStyle);
        }       
    }  
    
    
    public void setYearVal()
    {      
        String tmp = dobYear.getText();
        if(tmp != null && tmp.length() == 4)
        {
            try
            {
                dataclass.setYearVal(Integer.parseInt(tmp));                
                dobYear.setText(tmp);
                dobYear.setStyle(successStyle);                
            }            
            catch(NumberFormatException e)
            {
                dobYear.setText(null);
                dataclass.setYearVal(0);
                dobYear.setStyle(errorStyle);
            }
        }
        else
        {
            dobYear.setText(null);
            dataclass.setYearVal(0);
            dobYear.setStyle(errorStyle);
        }            
    }
         
    
    public void setCourseVal()
    {       
        String tmp = course.getText();               
        if(tmp == null || !Pattern.compile("[a-zA-Z0-9 -]+", Pattern.CASE_INSENSITIVE).matcher(tmp).matches())
        { 
            course.setText(null);
            dataclass.setCourseVal(null);
            course.setStyle(errorStyle);            
        } 
        
        else 
        { 
            course.setText(tmp);
            dataclass.setCourseVal(tmp);
            course.setStyle(successStyle);
        }        
    }
    
    
    public void setCurrSemVal()
    {          
        String tmp = currSem.getText();
        if (tmp != null) 
        {
            try 
            {
                dataclass.setCurrSemVal(Integer.parseInt(tmp));
                currSem.setText(tmp);                
                currSem.setStyle(successStyle);
            } 
            catch (NumberFormatException e) 
            {
                currSem.setText(null);
                dataclass.setCurrSemVal(0);
                currSem.setStyle(errorStyle);
            }
        }
        else
        {
            currSem.setText(null);
            dataclass.setCurrSemVal(0);
            currSem.setStyle(errorStyle);
        }
    }
    
    
    public void setContactVal()
    {  
        String tmp = contact.getText();       
        if(tmp == null || !Pattern.compile("^[+]?([0-9]{2,3})?[-]?[0-9]{10}$").matcher(tmp).matches())
        { 
            contact.setText(null);
            dataclass.setContactVal(null);
            contact.setStyle(errorStyle);
        } 
        
        else 
        { 
            contact.setText(tmp);
            contact.setStyle(successStyle);
            dataclass.setContactVal(tmp);
        }
    } 
    
    
    
    ////////////////////////////////////////////////////////////////////////////
    // Changing to different page
    
    public void toNextPg(MouseEvent event) //this function allows to transport to another tab without opening another window and same goes for other 2 functions
    {  
        DatabaseIO db = new DatabaseIO();
        
        db.InsertValues();
        
        try 
        {
            Parent editPag1 = FXMLLoader.load(getClass().getResource("Editing2.fxml"));
            Scene editPg1Scene = new Scene(editPag1);
            Stage appStage = (Stage)((Node)event.getSource()).getScene().getWindow();
            appStage.setScene(editPg1Scene);
            appStage.show();
            
        } 
        catch (IOException e) 
        {
            e.printStackTrace();
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
        catch (IOException e) 
          {
            e.printStackTrace();
          }
    }
}