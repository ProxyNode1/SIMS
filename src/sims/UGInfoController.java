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

/**
 * FXML Controller class
 *
 * @author Vic's
 */
public class UGInfoController implements Initializable 
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
                throw new NullPointerException("UPassYear1 null");
            }
        }
        else
        {
            passYear.setText(null);
            dataClass.setPassYearVal(0);
            passYear.setStyle(errorStyle);
            throw new NullPointerException("UPassYear2 null");
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
            throw new NullPointerException("USchool null");        
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
            throw new NullPointerException("UCity null");           
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
                throw new NullPointerException("UPercentVal1 not a float");
            }
        }
        else
        {
            percent.setText(null);
            dataClass.setPercentVal(0.f);
            percent.setStyle(errorStyle);
            throw new NullPointerException("UPercentVal2 not a float");
        }
        
    }    
    
    
    
    public void ValidateFields()
    {
       getPassYear();
       getSchool();
       getCity();
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
    private JFXTextField school;
    
    @FXML
    private JFXTextField city;
    
    @FXML 
    private JFXTextField percent;
    
    private final String errorStyle = "-fx-border-color: #ff2323; ";
            
    private final UGInfoData dataClass = UGInfoData.getInstance();
}
