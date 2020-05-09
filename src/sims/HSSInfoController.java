/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sims;

import com.jfoenix.controls.JFXTextField;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.regex.Pattern;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.MenuButton;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextField;


public class HSSInfoController implements Initializable 
{
    @Override
    public void initialize(URL url, ResourceBundle rb) 
    {
        setValues();
    }    
    
    
    ////////////////////////////////////////////////////////////////////////////
    // Set Values
    public void setValues()
    {
        String tmp1;
        int tmp2;
        float tmp3;
        
        tmp2 = dataClass.getPassYearVal();        
        if(tmp2 != 0)
        {
            passYear.setText(Integer.toString(tmp2));
        }
        
        
        tmp1 = dataClass.getRNoVal();
        if(tmp1 != null)
        {
            rNo.setText(tmp1);
        }
        
        
        tmp1 = dataClass.getBoardVal();
        if(tmp1 != null)
        {
            board.setText(tmp1);
        }
        
        
        tmp1 = dataClass.getMediumVal();
        if(tmp1 != null)
        {
            medium.setText(tmp1);
        }
        
        
        tmp1 = dataClass.getSchoolVal();
        if(tmp1 != null)
        {
            school.setText(tmp1);
        }
        
        
        tmp1 = dataClass.getCityVal();
        if(tmp1 != null)
        {
            city.setText(tmp1);
        }
        
        
        tmp3 = dataClass.getPercentVal();
        if(tmp1 != null)
        {
            percent.setText(Float.toString(tmp3));
        }
        
                
    }
    
    
    
    ////////////////////////////////////////////////////////////////////////////
    // Take Input
    
    public void getPassYear() throws NullPointerException
    {           
        String tmp = passYear.getText();
        if (tmp != null && tmp.length() == 4) 
        {
            try 
            {
                dataClass.setPassYearVal(Integer.parseInt(tmp));
            } 
            catch (NumberFormatException e) 
            {
                passYear.setText(null);
                dataClass.setPassYearVal(0);
                passYear.setStyle(errorStyle);
                throw new NullPointerException("hPassYear1 null");
            }
        }
        else
        {
            passYear.setText(null);
            dataClass.setPassYearVal(0);
            passYear.setStyle(errorStyle);
            throw new NullPointerException("hPassYear2 null");
        }
    }
    
    
    public void getRNo() throws NullPointerException
    {   
        String tmp = rNo.getText();
        if(tmp == null || !Pattern.compile("[a-zA-Z0-9 -/]+", Pattern.CASE_INSENSITIVE).matcher(tmp).matches())
        {
            rNo.setText(null);
            dataClass.setRNoVal(null);
            rNo.setStyle(errorStyle);
            throw new NullPointerException("hRno null");
        }        
        else
        {
            dataClass.setRNoVal(tmp);
        }        
    }
    
    
    void getBoard() throws NullPointerException
    {
        String tmp = board.getText();
        if(tmp == null )
        {
            board.setText("Select List Item");
            dataClass.setBoardVal("null"); 
            board.setStyle(errorStyle);
            throw new NullPointerException("hBoard null");
        } 
        else
        {
            dataClass.setBoardVal(tmp);
        } 
        
    }
    
    public void getCBSE()
    {
        board.setText("CBSE");
        //dataClass.setBoardVal("CBSE");
    }
    
    public void getCISCE()
    {
        board.setText("CISCE");
        //dataClass.setBoardVal("CISCE");
    }
    
    public void getState()
    {
        board.setText("STATE");
        //dataClass.setBoardVal("STATE");
    }
    
    public void getIBO()
    {
        board.setText("IBO");
        //dataClass.setBoardVal("IBO");
    }
     
    public void getSCIE()
    {
        board.setText("CIE");
        //dataClass.setBoardVal("CIE");
    }
      
    
    public void getMedium() throws NullPointerException
    {   
        String tmp = medium.getText();
        if(tmp == null || !Pattern.compile("[a-zA-Z]+", Pattern.CASE_INSENSITIVE).matcher(tmp).matches())
        { 
            medium.setText(null);
            dataClass.setMediumVal(null);
            medium.setStyle(errorStyle);
            throw new NullPointerException("hMedium null");            
        } 
        else 
        { 
           dataClass.setMediumVal(tmp); 
        }
    }
    
    
    public void getSchool() throws NullPointerException
    {    
        String tmp = school.getText();
        if(tmp == null || !Pattern.compile("^[a-zA-Z0-9. -]+$", Pattern.CASE_INSENSITIVE).matcher(tmp).matches())
        { 
            school.setText(null);
            dataClass.setSchoolVal(null);
            school.setStyle(errorStyle);
            throw new NullPointerException("hSchool null");        
        } 
        else 
        { 
            dataClass.setSchoolVal(tmp);
        }
    }
    
        
    public void getCity() throws NullPointerException
    {   
        String tmp = city.getText();
        if(tmp == null || !Pattern.compile("[a-zA-Z0-9 ,]+", Pattern.CASE_INSENSITIVE).matcher(tmp).matches())
        { 
            city.setText(null);
            dataClass.setCityVal(null);
            city.setStyle(errorStyle);
            throw new NullPointerException("hCity null");           
        } 
        else 
        { 
            dataClass.setCityVal(tmp);
        }
    }
    
    
    public void getPercent() throws NullPointerException
    {           
        String tmp = percent.getText();
        if (tmp != null && Float.parseFloat(tmp) <= 100.0) 
        {
            try 
            {
                dataClass.setPercentVal(Float.parseFloat(tmp));
            } 
            catch (NumberFormatException e) 
            {
                percent.setText(null);
                dataClass.setPercentVal(0.f);
                percent.setStyle(errorStyle);
                throw new NullPointerException("hPercentVal1 not a float");
            }
        }
        else
        {
            percent.setText(null);
            dataClass.setPercentVal(0.f);
            percent.setStyle(errorStyle);
            throw new NullPointerException("hPercentVal2 not a float");
        }
        
    }    
    
    public void ValidateFields()
    {
       getPassYear();
       getRNo();
       getMedium();             
       getSchool();
       getCity();
       getBoard(); 
       getPercent();
    }
    
    
    
     public void saveDat()
    {
        try 
        {
            ValidateFields();
        }
        
        catch(Exception e)
        {
            System.err.println(e.getMessage());
        }        
    }
    
    
     
    @FXML
    private JFXTextField passYear;
        
    @FXML
    private JFXTextField rNo;
    
    @FXML
    private MenuButton board;
    
    @FXML
    private MenuItem cbse;

    @FXML
    private MenuItem cisce;
    
    @FXML
    private MenuItem state;

    @FXML
    private MenuItem ibo;
    
    @FXML
    private MenuItem cie;
    
    @FXML
    private JFXTextField medium;
    
    @FXML
    private JFXTextField school;
    
    @FXML
    private JFXTextField city;
    
    @FXML
    private JFXTextField percent;       
        
    @FXML
    private Button save;
    
    
    private final String errorStyle = "-fx-border-color: #ff2323; ";
    
    private final HSSInfoData dataClass = HSSInfoData.getInstance();  
}
