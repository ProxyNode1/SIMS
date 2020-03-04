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

    private String errorStyle = "-fx-border-color: #ff2323; -fx-text-fill: white; -fx-prompt-text-fill: white; ";
    private String successStyle = "-fx-border-color: #23ff23; -fx-text-fill: white; -fx-prompt-text-fill: white; ";
    
    private String nameVal = null, clgIDVal = null, monthVal = null, dobVal = null, courseVal = null, contactVal = null;
    int yearVal = 0, dayVal = 0, currSemVal = 0;
       
        
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
        nameVal = null;
        clgIDVal = null; 
        monthVal = null; 
        dobVal = null;
        courseVal = null;
        contactVal = null;
        yearVal = 0; 
        dayVal = 0;
        currSemVal = 0;        
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
            nameVal = null;
            name.setStyle(errorStyle);
            System.out.println("false");
        } 
        
        else 
        { 
            name.setStyle(successStyle);
            nameVal = tmp;
            System.out.println(nameVal);
        }
    }
    
    
    public void setClgIDVal()
    {   
        String tmp = clgID.getText();
        
        if(tmp == null || tmp.trim().isEmpty())
        {
            clgID.setText(null);
            clgIDVal = null;
            clgID.setStyle(errorStyle);   
        }
        else
        {
            clgIDVal = tmp;
            clgID.setStyle(successStyle);
            System.out.println(clgIDVal);            
        }       
        
    }
     
           
    int numDays = 0;
    
    public void setJanuary()
    {
        numDays = 31;
        dobMonth.setText("January");
        monthVal = "1";
        dobMonth.setStyle(successStyle);
        
        if (dayVal < 1 || dayVal > numDays) 
        {
            dobDay.setText(null);
            dayVal = 0;            
            System.out.println("'day' out of limit or not initilized");
        }
    }
    
    public void setFabruary()
    {
        if (yearVal % 4 == 0) 
        {
            numDays = 29;
        } 
        else 
        {
            numDays = 28;
        }
        dobMonth.setText("Fabruary");
        monthVal = "2";
        dobMonth.setStyle(successStyle);
        
        if (dayVal < 1 || dayVal > numDays) 
        {
            dobDay.setText(null);
            dayVal = 0;            
            System.out.println("'day' out of limit or not initilized");
        }
    }
    
    public void setMarch()
    {
        numDays = 31;
        dobMonth.setText("March");
        monthVal = "3";
        dobMonth.setStyle(successStyle);
        
        if (dayVal < 1 || dayVal > numDays) 
        {
            dobDay.setText(null);
            dayVal = 0;            
            System.out.println("'day' out of limit or not initilized");
        }
    }
    
    public void setApril()
    {
        numDays = 30;
        dobMonth.setText("April");
        monthVal = "4";
        dobMonth.setStyle(successStyle);
        
        if (dayVal < 1 || dayVal > numDays) 
        {
            dobDay.setText(null);
            dayVal = 0;            
            System.out.println("'day' out of limit or not initilized");
        }
    }
    
    public void setMay()
    {
        numDays = 31;
        dobMonth.setText("May");
        monthVal = "5";
        dobMonth.setStyle(successStyle);
        
        if (dayVal < 1 || dayVal > numDays) 
        {
            dobDay.setText(null);
            dayVal = 0;            
            System.out.println("'day' out of limit or not initilized");
        }
    }
    
    public void setJune()
    {
        numDays = 30;
        dobMonth.setText("June");
        monthVal = "6";
        dobMonth.setStyle(successStyle);
        
        if (dayVal < 1 || dayVal > numDays) 
        {
            dobDay.setText(null);
            dayVal = 0;            
            System.out.println("'day' out of limit or not initilized");
        }
    }
    
    public void setJuly()
    {
        numDays = 31;
        dobMonth.setText("July");
        monthVal = "7";
        dobMonth.setStyle(successStyle);
        
        if (dayVal < 1 || dayVal > numDays) 
        {
            dobDay.setText(null);
            dayVal = 0;            
            System.out.println("'day' out of limit or not initilized");
        }
    }
    
    public void setAugust()
    {
        numDays = 31;
        dobMonth.setText("August");
        monthVal = "8";
        dobMonth.setStyle(successStyle);
        
        if (dayVal < 1 || dayVal > numDays) 
        {
            dobDay.setText(null);
            dayVal = 0;
            dobDay.setStyle(errorStyle);
            System.out.println("'day' out of limit or not initilized");
        }
    }
    
    public void setSeptember()
    {
        numDays = 30;
        dobMonth.setText("September");
        monthVal = "9";
        dobMonth.setStyle(successStyle);
        
        if (dayVal < 1 || dayVal > numDays) 
        {
            dobDay.setText(null);
            dayVal = 0;
            dobDay.setStyle(errorStyle);
            System.out.println("'day' out of limit or not initilized");
        }
    }
    
    public void setOctober()
    {
        numDays = 31;
        dobMonth.setText("October");
        monthVal = "10";
        dobMonth.setStyle(successStyle);
        
        if (dayVal < 1 || dayVal > numDays) 
        {
            dobDay.setText(null);
            dayVal = 0;
            dobDay.setStyle(errorStyle);
            System.out.println("'day' out of limit or not initilized");
        }
    }
    
    public void setNovember()
    {
        numDays = 30;
        dobMonth.setText("November");
        monthVal = "11";
        dobMonth.setStyle(successStyle);
        
        if (dayVal < 1 || dayVal > numDays) 
        {
            dobDay.setText(null);
            dayVal = 0;
            dobDay.setStyle(errorStyle);
            System.out.println("'day' out of limit or not initilized");
        }
    }
    
    public void setDecember()
    {
        numDays = 31;
        dobMonth.setText("December");
        monthVal = "12";
        dobMonth.setStyle(successStyle);
        
        if (dayVal < 1 || dayVal > numDays) 
        {
            dobDay.setText(null);
            dayVal = 0;
            dobDay.setStyle(errorStyle);
            System.out.println("'day' out of limit or not initilized");
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
                dobDay.setStyle(successStyle);
                dayVal = tmp;
                System.out.println(dayVal);
            }
            else
            {
                dobDay.setText(null);
                dayVal = 0;
                dobDay.setStyle(errorStyle);
                System.out.println("'day' out of limit or not initilized");
            }
                       
        }
        
        catch(NumberFormatException e)
        {
            dobDay.setText(null);
            dayVal = 0;
            dobDay.setStyle(errorStyle);
            System.out.println("dayVal not an integer");
        }       
    }  
    
    
    public void setYearVal()
    {      
        String tmp = dobYear.getText();
        if(tmp != null && tmp.length() == 4)
        {
            try
            {
                yearVal = Integer.parseInt(tmp);
                dobYear.setStyle(successStyle);
                System.out.println(yearVal);
            }
            catch(NumberFormatException e)
            {
                dobYear.setText(null);
                yearVal = 0;
                dobYear.setStyle(errorStyle);
            }
        }
        else
        {
            dobYear.setText(null);
            yearVal = 0;
            dobYear.setStyle(errorStyle);
        }            
    }
         
    
    public void setCourseVal()
    {       
        String tmp = course.getText();               
        if(tmp == null || !Pattern.compile("[a-zA-Z0-9]+", Pattern.CASE_INSENSITIVE).matcher(tmp).matches())
        { 
            course.setText(null);
            courseVal = null;
            course.setStyle(errorStyle);
            System.out.println("false");             
        } 
        
        else 
        { 
            course.setStyle(successStyle);
            courseVal = tmp;
            System.out.println(courseVal);
        }        
    }
    
    
    public void setCurrSemVal()
    {          
        String tmp = currSem.getText();
        if (tmp != null) 
        {
            try 
            {
                currSemVal = Integer.parseInt(tmp);
                currSem.setStyle(successStyle);
                System.out.println(currSemVal);
            } 
            catch (NumberFormatException e) 
            {
                currSem.setText(null);
                currSemVal = 0;
                currSem.setStyle(errorStyle);
                System.out.println("currSemVal not an integer");
            }
        }
        else
        {
            currSem.setText(null);
            currSemVal = 0;
            currSem.setStyle(errorStyle);
            System.out.println("currSemVal not an integer");
        }
    }
    
    
    public void setContactVal()
    {  
        String tmp = contact.getText();       
        if(tmp == null || !Pattern.compile("^[+]?([0-9]{2,3})?[-]?[0-9]{10}$").matcher(tmp).matches())
        { 
            contact.setText(null);
            contactVal = null;
            contact.setStyle(errorStyle);
            System.out.println("false");
        } 
        
        else 
        { 
            contact.setStyle(successStyle);
            contactVal = tmp;
            System.out.println(contactVal);
        }
    } 
    
    
    ///////////////////////////////////////////////////////////////////////////
    // Get Values
    
    public String getNameVal()
    {
        return this.nameVal;
    }
    
    
    public String getClgIDVal()
    {
        return this.clgIDVal;
    }
    
    
    public String getMonthVal()
    {
        return this.monthVal;
    }
    
    
    public int getYearVal()
    {
        return this.yearVal;
    }
    
    
    public int getDayVal()
    {
        return this.dayVal;
    }
    
    
    public String getCourseVal()
    {
        return this.courseVal;
    }
    
    
    public int getCurrSemVal()
    {
        return this.currSemVal;
    }
    
    
    public String getContactVal()
    {
        return this.contactVal;
    }
    
    
    ////////////////////////////////////////////////////////////////////////////
    // Changing to different page
    
    public void toNextPg(MouseEvent event) //this function allows to transport to another tab without opening another window and same goes for other 2 functions
    {  
        DatabaseIO Connection = new DatabaseIO();
        
        Connection.InsertValues();
        
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