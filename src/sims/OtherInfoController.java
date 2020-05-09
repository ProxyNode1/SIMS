package sims;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.Initializable;


import com.jfoenix.controls.JFXTextField;
import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import javafx.scene.layout.Pane;
import java.util.regex.Pattern;


import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.input.MouseEvent;



public class OtherInfoController implements Initializable 
{
    @Override
    public void initialize(URL url, ResourceBundle rb) 
    {
        edit3.requestFocus();
        
        setValues();

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
    public void setValues()
    {
        String tmp1;
        
        tmp1 = dataClass.getPersonMailVal();        
        if(tmp1 != null)
        {
            personMail.setText(tmp1);
        }
        
        
        tmp1 = dataClass.getUniversityMailVal();
        if(tmp1 != null)
        {
            universityMail.setText(tmp1);
        }
        
        
        tmp1 = dataClass.getDadContactVal();
        if(tmp1 != null)
        {
            dadContact.setText(tmp1);
        }
        
        
        tmp1 = dataClass.getFamContactVal();
        if(tmp1 != null)
        {
            famContact.setText(tmp1);
        }
        
        
        tmp1 = dataClass.getAddInfoVal();
        if(tmp1 != null)
        {
            addInfo.setText(tmp1);
        }
    } 
    
    
    //////////////////////////////////////////////////////////////////////////
    // Take Input
    public void getPersonMail() throws NullPointerException
    {           
        String tmp = personMail.getText();
        if(tmp == null || !Pattern.compile("^(.+@.+)$", Pattern.CASE_INSENSITIVE).matcher(tmp).matches())            
        { 
            personMail.setText(null);             
            dataClass.setPersonMailVal(null);
            personMail.setStyle(errorStyle);
            
            throw new NullPointerException("personMail null");
        } 
        else 
        {                            
            dataClass.setPersonMailVal(tmp);
            personMail.setStyle(null);
        }
        
    }
    
    
    public void getUnivMail() throws NullPointerException
    {   
        String tmp = universityMail.getText();
        if(tmp == null  || !Pattern.compile("^(.+@.+)$", Pattern.CASE_INSENSITIVE).matcher(tmp).matches())            
        {            
            universityMail.setText(null);
            dataClass.setUniversityMailVal(null);
            universityMail.setStyle(errorStyle);
            
            throw new NullPointerException("universityMail null");
        }
        else 
        {           
            dataClass.setUniversityMailVal(tmp);
            universityMail.setStyle(null);
        }        
    }
    
    
    public void getDadContact() throws NullPointerException
    {   
        String tmp = dadContact.getText();        
        if(tmp == null || !Pattern.compile("^[+]?([0-9]{2,3})?[-]?[0-9]{10}$").matcher(tmp).matches())
        {
            dadContact.setText(null);
            dataClass.setDadContactVal(null);
            dadContact.setStyle(errorStyle);
            
            throw new NullPointerException("dadContact null");
        }
        else
        {   
            dataClass.setDadContactVal(tmp);  
            dadContact.setStyle(null);
        }
    }
    
    
    public void getFamContact() throws NullPointerException
    {   
        String tmp = famContact.getText();        
        if(tmp == null || !Pattern.compile("^[+]?([0-9]{2,3})?[-]?[0-9]{10}$").matcher(tmp).matches())
        {
            famContact.setText(null);
            dataClass.setFamContactVal(null);
            famContact.setStyle(errorStyle);
            
            throw new NullPointerException("famContact null");
        }      
        else
        {             
            dataClass.setFamContactVal(tmp); 
            famContact.setStyle(null);
        }
    }
    
    
    public void getAddInfo()
    {  
        dataClass.setAddInfoVal(addInfo.getText());         
    }
    
        
    
    public void ValidateField()
    {
       getPersonMail();
       getUnivMail();
       getDadContact();
       getFamContact();
       getAddInfo();
    }
    
    
    
    
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
    
    
    private final String errorStyle = "-fx-border-color: #ff2323;";
    
    
    private final OtherInfoData dataClass = OtherInfoData.getInstance();
    
}
