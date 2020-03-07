package sims;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.Initializable;


import javafx.scene.input.MouseEvent;
import com.jfoenix.controls.JFXTextField;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.MenuButton;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import java.util.regex.Pattern;


import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import java.util.List;
import java.util.Optional;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.Tooltip;




public class Editing2Controller implements Initializable 
{
    
    private String errorStyle = "-fx-border-color: #ff2323; -fx-text-fill: white; -fx-prompt-text-fill: white; ";
    private String successStyle = "-fx-border-color: #23ff23; -fx-text-fill: white; -fx-prompt-text-fill: white; ";
    
    @FXML
    private Pane edit2;
              
    @Override
    public void initialize(URL url, ResourceBundle rb) 
    {
        edit2.requestFocus();
        
        //IdFld.setStyle(errorStyle); when error occurs or not filled    
        //SSch.setTooltip(new Tooltip("Do not use , or ."));
        //HSch.setTooltip(new Tooltip("Do not use , or ."));
        
    }  
          
    ////////////////////////////////////////////////////////////////////////////
    // Set Values
       
    ////////////////////////////////////////////////////////////////////////////
    // Secondary School Fields
    
    @FXML
    private JFXTextField sPassYear;
        
    @FXML
    private JFXTextField sRNo;
    
    @FXML
    private MenuButton sBoard;
    
    @FXML
    private MenuItem scbse;

    @FXML
    private MenuItem scisce;
    
    @FXML
    private MenuItem sstate;

    @FXML
    private MenuItem sibo;
    
    @FXML
    private MenuItem scie;
    
    @FXML
    private JFXTextField sMedium;
    
    @FXML
    private JFXTextField sSchool;
    
    @FXML
    private JFXTextField sCity;
    
    @FXML
    private JFXTextField sPercent;


    Editing2DataSSC edit2Ssc = Editing2DataSSC.getInstance();
    
          
    public void setSPassYear()
    {           
        String tmp = sPassYear.getText();
        if (tmp != null && tmp.length() == 4) 
        {
            try 
            {
                edit2Ssc.setPassYearVal(Integer.parseInt(tmp));
                sPassYear.setStyle(successStyle);
            } 
            catch (NumberFormatException e) 
            {
                sPassYear.setText(null);
                edit2Ssc.setPassYearVal(0);
                sPassYear.setStyle(errorStyle);
                System.out.println("sPassYearVal not an integer");
            }
        }
        else
        {
            sPassYear.setText(null);
            edit2Ssc.setPassYearVal(0);
            sPassYear.setStyle(errorStyle);
            System.out.println("sPassYearVal not an integer");
        }
    }
    
    
    public void setSRNo()
    {   
        String tmp = sRNo.getText();
        if(tmp == null || !Pattern.compile("[a-zA-Z0-9 -/]+", Pattern.CASE_INSENSITIVE).matcher(tmp).matches())
        {
            sRNo.setText(null);
            edit2Ssc.setRNoVal(null);
            sRNo.setStyle(errorStyle);
        }        
        else
        {
            edit2Ssc.setRNoVal(tmp);
            sRNo.setStyle(successStyle); 
        }        
    }
    
    public void setSCBSE()
    {
        sBoard.setText("CBSE");
        edit2Ssc.setBoardVal("CBSE");   
        sBoard.setStyle("-fx-border-color: #23ff23; -fx-background-color: #2F3136;");
    }
    
    public void setSCISCE()
    {
        sBoard.setText("CISCE");
        edit2Ssc.setBoardVal("CISCE");
        sBoard.setStyle("-fx-border-color: #23ff23; -fx-background-color: #2F3136;");
    }
    
    public void setSState()
    {
        sBoard.setText("STATE");
        edit2Ssc.setBoardVal("STATE");
        sBoard.setStyle("-fx-border-color: #23ff23; -fx-background-color: #2F3136;");
    }
    
    public void setSIBO()
    {
        sBoard.setText("IBO");
        edit2Ssc.setBoardVal("IBO");
        sBoard.setStyle("-fx-border-color: #23ff23");
    }
     
    public void setSCIE()
    {
        sBoard.setText("CIE");
        edit2Ssc.setBoardVal("CIE");
        sBoard.setStyle("-fx-border-color: #23ff23; -fx-background-color: #2F3136;");
    }
      
    
    public void setSMedium()
    {   
        String tmp = sMedium.getText();
        if(tmp == null || !Pattern.compile("[a-zA-Z]+", Pattern.CASE_INSENSITIVE).matcher(tmp).matches())
        { 
            sMedium.setText(null);
            edit2Ssc.setMediumVal(null);
            sMedium.setStyle(errorStyle);
            System.out.println("false");             
        } 
        else 
        { 
           edit2Ssc.setMediumVal(tmp);
           sMedium.setStyle(successStyle); 
        }
    }
    
    
    public void setSSchool()
    {    
        String tmp = sSchool.getText();
        if(tmp == null || !Pattern.compile("^[a-zA-Z0-9. -]+$", Pattern.CASE_INSENSITIVE).matcher(tmp).matches())
        { 
            sSchool.setText(null);
            edit2Ssc.setSchoolVal(null);
            sSchool.setStyle(errorStyle);
            System.out.println("false");           
        } 
        else 
        { 
            edit2Ssc.setSchoolVal(tmp);
            sSchool.setStyle(successStyle);
        }
    }
    
        
    public void setSCity()
    {   
        String tmp = sCity.getText();
        if(tmp == null || !Pattern.compile("[a-zA-Z0-9 ]+", Pattern.CASE_INSENSITIVE).matcher(tmp).matches())
        { 
            sCity.setText(null);
            edit2Ssc.setCityVal(null);
            sCity.setStyle(errorStyle);
            System.out.println("false");             
        } 
        else 
        { 
            edit2Ssc.setCityVal(tmp);
            sCity.setStyle(successStyle);
        }
    }
    
    
    public void setSPercent()
    {           
        String tmp = sPercent.getText();
        if (tmp != null) 
        {
            try 
            {
                edit2Ssc.setPercentVal(Float.parseFloat(tmp));
                sPercent.setStyle(successStyle);
            } 
            catch (NumberFormatException e) 
            {
                sPercent.setText(null);
                edit2Ssc.setPercentVal(0.f);
                sPercent.setStyle(errorStyle);
                System.out.println("sPercentVal not a float");
            }
        }
        else
        {
            sPercent.setText(null);
            edit2Ssc.setPercentVal(0.f);
            sPercent.setStyle(errorStyle);
            System.out.println("sPercentVal not a float");
        }
        
    }

     
    ////////////////////////////////////////////////////////////////////////////
    //PreUniversity Drop Down
 
    
    @FXML
    private MenuButton preUnivesity;
       
    @FXML
    private Pane hPane;
       
    @FXML
    private Pane dPane;
       
      
    public void setHSS()
    {
        preUnivesity.setText("Higher Secondary School");
        dPane.setVisible(false);
        hPane.setVisible(true);
    }
    
    public void setDiploma()
    {
        preUnivesity.setText("Diploma");
        hPane.setVisible(false);
        dPane.setVisible(true);
    }
    
    
    ///////////////////////////////////////////////////////////////////////////
    // Set Higher Secondary School Fields
                 
    @FXML
    private JFXTextField hPassYear;
    
    @FXML
    private JFXTextField hRNo;
    
    @FXML
    private MenuButton hBoard;
         
    @FXML
    private MenuItem hcbse;

    @FXML
    private MenuItem hcisce;
    
    @FXML
    private MenuItem hstate;

    @FXML
    private MenuItem hibo;
    
    @FXML
    private MenuItem hcie;
    
    @FXML
    private JFXTextField hMedium;
    
    @FXML
    private JFXTextField hSchool;
    
    @FXML
    private JFXTextField hCity;
    
    @FXML
    private JFXTextField hPercent;
    
    @FXML
    private TextField hPhysics;
    
    @FXML
    private TextField hChemistry;
    
    @FXML
    private TextField hMath;
    
    Editing2DataHSS edit2Hss = Editing2DataHSS.getInstance();
    
    public void setHPassYear()
    {
        String tmp = hPassYear.getText();
        if (tmp != null && tmp.length() == 4) 
        {
            try 
            {
                edit2Hss.setPassYearVal(Integer.parseInt(tmp));
                hPassYear.setStyle(successStyle);
            } 
            
            catch (NumberFormatException e) 
            {
                hPassYear.setText(null);
                 edit2Hss.setPassYearVal(0);
                hPassYear.setStyle(errorStyle);
                System.out.println("hPassYear not an integer");
            }
        } 
        
        else 
        {
            hPassYear.setText(null);
            edit2Hss.setPassYearVal(0);
            hPassYear.setStyle(errorStyle);
            System.out.println("year length < 4");
        }       
    }
        
       
    public void setHRNo()
    {          
        String tmp = hRNo.getText();
        if(tmp == null || !Pattern.compile("[a-zA-Z0-9-/ ]+", Pattern.CASE_INSENSITIVE).matcher(tmp).matches())
        {
            hRNo.setText(null);
            edit2Hss.setRNoVal(null);
            hRNo.setStyle(errorStyle);
        }        
        else
        {
            edit2Hss.setRNoVal(tmp);
            hRNo.setStyle(successStyle);  
        }  
    }
    

    public void setHCBSE()
    {
        hBoard.setText("CBSE");
        edit2Hss.setBoardVal("CBSE"); 
        hBoard.setStyle("-fx-border-color: #23ff23; -fx-background-color: #2F3136;");
    }
    
    public void setHCISCE()
    {
        hBoard.setText("CISCE");
        edit2Hss.setBoardVal("CISCE");
        hBoard.setStyle("-fx-border-color: #23ff23; -fx-background-color: #2F3136;");
    }
    
    public void setHState()
    {
        hBoard.setText("STATE");
        edit2Hss.setBoardVal("STATE");
        hBoard.setStyle("-fx-border-color: #23ff23; -fx-background-color: #2F3136;");
    }
    
    public void setHIBO()
    {
        hBoard.setText("IBO");
        edit2Hss.setBoardVal("IBO");
        hBoard.setStyle("-fx-border-color: #23ff23; -fx-background-color: #2F3136;");
    }
     
    public void setHCIE()
    {
        hBoard.setText("CIE");
        edit2Hss.setBoardVal("CIE");
        hBoard.setStyle("-fx-border-color: #23ff23; -fx-background-color: #2F3136;");
    }  
       
    
    public void setHMedium()
    {   
        String tmp = hMedium.getText();
        if(tmp == null || !Pattern.compile("[a-zA-Z]+", Pattern.CASE_INSENSITIVE).matcher(tmp).matches())
        { 
            hMedium.setText(null);
            edit2Hss.setMediumVal(null);
            hMedium.setStyle(errorStyle);
            System.out.println("false");             
        } 
        else 
        { 
           edit2Hss.setMediumVal(tmp);
           hMedium.setStyle(successStyle);
        }
    }
    
        
    public void setHSchool()
    {   
        String tmp = hSchool.getText();
        if(tmp == null || !Pattern.compile("^[a-zA-Z0-9. -]+$", Pattern.CASE_INSENSITIVE).matcher(tmp).matches())
        { 
            hSchool.setText(null);
            edit2Hss.setSchoolVal(null);
            hSchool.setStyle(errorStyle);
            System.out.println("false");             
        } 
        else 
        { 
            edit2Hss.setSchoolVal(tmp);
            hSchool.setStyle(successStyle);
        }
    }
    
    
    public void setHCity()
    {   
        String tmp = hCity.getText();
        if(tmp == null || !Pattern.compile("[a-zA-Z0-9 ]+", Pattern.CASE_INSENSITIVE).matcher(tmp).matches())
        { 
            hCity.setText(null);
            edit2Hss.setCityVal(null);
            hCity.setStyle(errorStyle);
            System.out.println("false");             
        } 
        else 
        { 
            hCity.setStyle(successStyle);                
            edit2Hss.setCityVal(tmp);         
        }
    }
    
    
    public void setHPercent()
    {   
        String tmp = hPercent.getText();
        if (tmp != null) 
        {
            try 
            {
                edit2Hss.setPercentVal(Float.parseFloat(tmp));
                hPercent.setStyle(successStyle);
            } 
            catch (NumberFormatException e) 
            {
                hPercent.setText(null);
                edit2Hss.setPercentVal(0.f);
                hPercent.setStyle(errorStyle);
                System.out.println("hPercentVal not a float");
            }
        }
        else
        {
            hPercent.setText(null);
            edit2Hss.setPercentVal(0.f);
            hPercent.setStyle(errorStyle);
            System.out.println("hPercentVal not a float");
        }
    }
    
    
    public void setHPhysics()
    {        
        String tmp = hPhysics.getText();
        if (tmp != null) 
        {
            try 
            {
                edit2Hss.setPhysicsVal(Float.parseFloat(tmp));
                hPhysics.setStyle(successStyle);
            } 
            catch (NumberFormatException e) 
            {
                hPhysics.setText(null);
                edit2Hss.setPhysicsVal(0.f);
                hPhysics.setStyle(errorStyle);
                System.out.println("hPhysicsVal not a float");
            }
        }
        else
        {
            hPhysics.setText(null);
            edit2Hss.setPhysicsVal(0.f);
            hPhysics.setStyle(errorStyle);
            System.out.println("hPhysicsVal not a float");
        }
    }
    
    
    public void setHChemistry()
    {   
        String tmp = hChemistry.getText();
        if (tmp != null) 
        {
            try 
            {
                edit2Hss.setChemistryVal(Float.parseFloat(tmp));
                hChemistry.setStyle(successStyle);
            } 
            catch (NumberFormatException e) 
            {
                hChemistry.setText(null);
                edit2Hss.setChemistryVal(0.f);
                hChemistry.setStyle(errorStyle);
                System.out.println("hChemistryVal not a float");
            }
        }
        else
        {
            hChemistry.setText(null);
            edit2Hss.setChemistryVal(0.f);
            hChemistry.setStyle(errorStyle);
            System.out.println("hChemistryVal not a float");
        }
    }
    
    
    public void setHMath()
    {   
        String tmp = hMath.getText();
        if (tmp != null) 
        {
            try 
            {
                edit2Hss.setMathVal(Float.parseFloat(tmp));
                hMath.setStyle(successStyle);
            } 
            catch (NumberFormatException e) 
            {
                hMath.setText(null);
                edit2Hss.setMathVal(0.f);
                hMath.setStyle(errorStyle);
                System.out.println("hMathVal not a float");
            }
        }
        else
        {
            hMath.setText(null);
            edit2Hss.setMathVal(0.f);
            hMath.setStyle(errorStyle);
            System.out.println("hMathVal not a float");
        }
    }
        
    ////////////////////////////////////////////////////
    // Set Diploma Fields 
  
    
    @FXML
    private JFXTextField dPassYear;
    
    @FXML
    private JFXTextField dSchool;
    
    @FXML
    private JFXTextField dCity;
    
    @FXML 
    private JFXTextField dPercent1;
    
    @FXML
    private JFXTextField dPercent2;
    
    @FXML
    private JFXTextField dPercent3;
    
    @FXML
    private JFXTextField dPercent4;
    
    @FXML
    private JFXTextField dPercent5;
    
    @FXML
    private JFXTextField dPercent6;
    
    private int dPassYearVal;
    
    private float dPercent1Val, dPercent2Val, dPercent3Val, dPercent4Val, dPercent5Val, dPercent6Val;   
    
    private String dSchoolVal, dCityVal;
    
    
    
    public void setDPassYear()
    {                  
        String tmp = dPassYear.getText();
        if (tmp != null && tmp.length() == 4) 
        {
            try 
            {
                dPassYearVal = Integer.parseInt(tmp);
                dPassYear.setStyle(successStyle);                
                System.out.println(dPassYearVal);
            } 
            
            catch (NumberFormatException e) 
            {
                dPassYear.setText(null);
                dPassYearVal = 0;
                dPassYear.setStyle(errorStyle);
                System.out.println("dPassYear not an integer");
            }
        } 
        
        else 
        {
            dPassYear.setText(null);
            dPassYearVal = 0;
            dPassYear.setStyle(errorStyle);
            System.out.println("year length < 4");
        }
    }
    
    
    public void setDSchool()
    {    
        String tmp= dSchool.getText();
        if(tmp == null || !Pattern.compile("^[a-zA-Z0-9. -]+$", Pattern.CASE_INSENSITIVE).matcher(tmp).matches())
        { 
            dSchool.setText(null);
            dSchoolVal = null;
            dSchool.setStyle(errorStyle);
            System.out.println("false");             
            
        } 
        else 
        { 
            dSchool.setStyle(successStyle);                
            dSchoolVal = tmp;
            System.out.println(dSchoolVal);
        }
    }
    
    
    public void setDCity()
    {   
        String tmp = dCity.getText();
        if(tmp == null || !Pattern.compile("[a-zA-Z0-9 ]+", Pattern.CASE_INSENSITIVE).matcher(tmp).matches())
        { 
            dCity.setText(null);
            dCityVal = null;
            dCity.setStyle(errorStyle);
            System.out.println("false");
        } 
        else 
        { 
            dCity.setStyle(successStyle);                
            dCityVal = tmp;
            System.out.println(dCityVal);
        }
    }
    
    
    public void setDPercent1()
    {           
        String tmp = dPercent1.getText();
        if (tmp != null) 
        {
            try 
            {
                dPercent1Val = Float.parseFloat(tmp);
                dPercent1.setStyle(successStyle);
                System.out.println(dPercent1Val);
            } 
            catch (NumberFormatException e) 
            {
                dPercent1.setText(null);
                dPercent1Val = 0.f;
                dPercent1.setStyle(errorStyle);
                System.out.println("dPercent1Val not a float");
            }
        }
        else
        {
            dPercent1.setText(null);
            dPercent1Val = 0.f;
            dPercent1.setStyle(errorStyle);
            System.out.println("dPercent1Val not a float");
        }
    }
    
    
    public void setDPercent2()
    {   
        String tmp = dPercent2.getText();
        if (tmp != null) 
        {
            try 
            {
                dPercent2Val = Float.parseFloat(tmp);
                dPercent2.setStyle(successStyle);
                System.out.println(dPercent2Val);
            } 
            catch (NumberFormatException e) 
            {
                dPercent2.setText(null);
                dPercent2Val = 0.f;
                dPercent2.setStyle(errorStyle);
                System.out.println("dPercent2Val not a float");
            }
        }
        else
        {
            dPercent2.setText(null);
            dPercent2Val = 0.f;
            dPercent2.setStyle(errorStyle);
            System.out.println("dPercent2Val not a float");
        }
    }
    
    
    public void setDPercent3()
    {   
        String tmp = dPercent3.getText();
        if (tmp != null) 
        {
            try 
            {
                dPercent3Val = Float.parseFloat(tmp);
                dPercent3.setStyle(successStyle);
                System.out.println(dPercent3Val);
            } 
            catch (NumberFormatException e) 
            {
                dPercent3.setText(null);
                dPercent3Val = 0.f;
                dPercent3.setStyle(errorStyle);
                System.out.println("dPercent3Val not a float");
            }
        }
        else
        {
            dPercent3.setText(null);
            dPercent3Val = 0.f;
            dPercent3.setStyle(errorStyle);
            System.out.println("dPercent3Val not a float");
        }
    }
    
    
    public void setDPercent4()
    {    
        String tmp = dPercent4.getText();
        if (tmp != null) 
        {
            try 
            {
                dPercent4Val = Float.parseFloat(tmp);
                dPercent4.setStyle(successStyle);
                System.out.println(dPercent4Val);
            } 
            catch (NumberFormatException e) 
            {
                dPercent4.setText(null);
                dPercent4Val = 0.f;
                dPercent4.setStyle(errorStyle);
                System.out.println("dPercent4Val not a float");
            }
        }
        else
        {
            dPercent4.setText(null);
            dPercent4Val = 0.f;
            dPercent4.setStyle(errorStyle);
            System.out.println("dPercent4Val not a float");
        }
        
    }
    
    
    public void setDPercent5()
    {   
        String tmp = dPercent5.getText();
        if (tmp != null) 
        {
            try 
            {
                dPercent5Val = Float.parseFloat(tmp);
                dPercent5.setStyle(successStyle);
                System.out.println(dPercent5Val);
            } 
            catch (NumberFormatException e) 
            {
                dPercent5.setText(null);
                dPercent5Val = 0.f;
                dPercent5.setStyle(errorStyle);
                System.out.println("dPercent5Val not a float");
            }
        }
        else
        {
            dPercent5.setText(null);
            dPercent5Val = 0.f;
            dPercent5.setStyle(errorStyle);
            System.out.println("dPercent5Val not a float");
        }
        
    }
    
    
    public void setDPercent6()
    {  
        String tmp = dPercent6.getText();
        if (tmp != null) 
        {
            try 
            {
                dPercent6Val = Float.parseFloat(tmp);
                dPercent6.setStyle(successStyle);
                System.out.println(dPercent6Val);
            } 
            catch (NumberFormatException e) 
            {
                dPercent6.setText(null);
                dPercent6Val = 0.f;
                dPercent6.setStyle(errorStyle);
                System.out.println("dPercent6Val not a float");
            }
        }
        else
        {
            dPercent6.setText(null);
            dPercent6Val = 0.f;
            dPercent6.setStyle(errorStyle);
            System.out.println("dPercent6Val not a float");
        }
    }
       
    
    //////////////////////////////////////////////////////////
    
    /*int j, o;
    
    public void hide(int o)
    {   
        if(o == 1)
        {
            EPentg1.setDisable(true);
            EPentg2.setDisable(true);
            EPentg3.setDisable(true);
            EPentg4.setDisable(true);
            EPentg5.setDisable(true);
            EPentg6.setDisable(true);
            EPentg7.setDisable(true);
            EPentg8.setDisable(true);

        }
        if(o == 2)
        {
            PPentg1.setDisable(true);
            PPentg2.setDisable(true);
            PPentg3.setDisable(true);
            PPentg4.setDisable(true);
           
        }
    }*/
    
    //////////////////////////////////////////////////////////
    // Set Undergraduation Fields
    
    
    @FXML
    private JFXTextField ePassYear;
    
    @FXML
    private JFXTextField eSchool;
    
    @FXML
    private JFXTextField eCity;
       
    @FXML
    private JFXTextField ePercent1;
    
    @FXML
    private JFXTextField ePercent2;
    
    @FXML
    private JFXTextField ePercent3;
    
    @FXML
    private JFXTextField ePercent4;
    
    @FXML
    private JFXTextField ePercent5;
    
    @FXML
    private JFXTextField ePercent6;
    
    @FXML
    private JFXTextField ePercent7;
    
    @FXML
    private JFXTextField ePercent8;

    private int ePassYearVal;
    
    private float ePercent1Val, ePercent2Val, ePercent3Val, ePercent4Val, 
          ePercent5Val, ePercent6Val, ePercent7Val, ePercent8Val;
    
    private String eSchoolVal, eCityVal;
    
    
    public void setEPassYear()
    {                  
        String tmp = ePassYear.getText();
        if (tmp != null && tmp.length() == 4)
        {
            try 
            {
                ePassYearVal = Integer.parseInt(tmp);
                ePassYear.setStyle(successStyle);
                System.out.println(ePassYearVal);
            } 
            
            catch (NumberFormatException e) 
            {
                ePassYear.setText(null);
                ePassYearVal = 0;
                ePassYear.setStyle(errorStyle);
                System.out.println("ePassYear not an integer");
            }
        } 
        
        else 
        {
            ePassYear.setText(null);
            ePassYearVal = 0;
            ePassYear.setStyle(errorStyle);
            System.out.println("year length < 4");
        }
    }
    
    
    public void setESchool()
    {    
        String tmp = eSchool.getText();
        if(tmp == null || !Pattern.compile("^[a-zA-Z0-9. -]+$", Pattern.CASE_INSENSITIVE).matcher(tmp).matches())
        { 
            eSchool.setText(null);
            eSchoolVal = null;
            eSchool.setStyle(errorStyle);
            System.out.println("false");
            
        } 
        else 
        { 
            eSchool.setStyle(successStyle);
            eSchoolVal = tmp;
            System.out.println(eSchoolVal);
        }
    }
    
    
    public void setECity()
    {           
        String tmp = eCity.getText();
        if(tmp == null || !Pattern.compile("[a-zA-Z0-9 ]+", Pattern.CASE_INSENSITIVE).matcher(tmp).matches())
        { 
            eCity.setText(null);
            eCityVal = null;
            eCity.setStyle(errorStyle);
            System.out.println("false");
        } 
        else 
        { 
            eCity.setStyle(successStyle);
            eCityVal = tmp;
            System.out.println(eCityVal);
        }
    }
    
    
    public void setEPercent1()
    {           
        String tmp = ePercent1.getText();
        if (tmp != null) 
        {
            try 
            {
                ePercent1Val = Float.parseFloat(tmp);
                ePercent1.setStyle(successStyle);
                System.out.println(ePercent1Val);
            } 
            catch (NumberFormatException e) 
            {
                ePercent1.setText(null);
                ePercent1Val = 0.f;
                ePercent1.setStyle(errorStyle);
                System.out.println("ePercent1Val not a float");
            }
        }
        else
        {
            ePercent1.setText(null);
            ePercent1Val = 0.f;
            ePercent1.setStyle(errorStyle);
            System.out.println("ePercent1Val not a float");
        }
    }
    
    
    public void setEPercent2()
    {   
        String tmp = ePercent2.getText();
        if (tmp != null) 
        {
            try 
            {
                ePercent2Val = Float.parseFloat(tmp);
                ePercent2.setStyle(successStyle);
                System.out.println(ePercent2Val);
            } 
            catch (NumberFormatException e) 
            {
                ePercent2.setText(null);
                ePercent2Val = 0.f;
                ePercent2.setStyle(errorStyle);
                System.out.println("ePercent2Val not a float");
            }
        }
        else
        {
            ePercent2.setText(null);
            ePercent2Val = 0.f;
            ePercent2.setStyle(errorStyle);
            System.out.println("ePercent2Val not a float");
        }
    }
    
    
    public void setEPercent3()
    {   
        String tmp = ePercent3.getText();
        if (tmp != null) 
        {
            try 
            {
                ePercent3Val = Float.parseFloat(tmp);
                ePercent3.setStyle(successStyle);
                System.out.println(ePercent3Val);
            } 
            catch (NumberFormatException e) 
            {
                ePercent3.setText(null);
                ePercent3Val = 0.f;
                ePercent3.setStyle(errorStyle);
                System.out.println("ePercent3Val not a float");
            }
        }
        else
        {
            ePercent3.setText(null);
            ePercent3Val = 0.f;
            ePercent3.setStyle(errorStyle);
            System.out.println("ePercent3Val not a float");
        }
    }
    
    
    public void setEPercent4()
    {    
        String tmp = ePercent4.getText();
        if (tmp != null) 
        {
            try 
            {
                ePercent4Val = Float.parseFloat(tmp);
                ePercent4.setStyle(successStyle);
                System.out.println(ePercent4Val);
            } 
            catch (NumberFormatException e) 
            {
                ePercent4.setText(null);
                ePercent4Val = 0.f;
                ePercent4.setStyle(errorStyle);
                System.out.println("ePercent4Val not a float");
            }
        }
        else
        {
            ePercent4.setText(null);
            ePercent4Val = 0.f;
            ePercent4.setStyle(errorStyle);
            System.out.println("ePercent4Val not a float");
        }
        
    }
    
    
    public void setEPercent5()
    {   
        String tmp = ePercent5.getText();
        if (tmp != null) 
        {
            try 
            {
                ePercent5Val = Float.parseFloat(tmp);
                ePercent5.setStyle(successStyle);
                System.out.println(ePercent5Val);
            } 
            catch (NumberFormatException e) 
            {
                ePercent5.setText(null);
                ePercent5Val = 0.f;
                ePercent5.setStyle(errorStyle);
                System.out.println("ePercent5Val not a float");
            }
        }
        else
        {
            ePercent5.setText(null);
            ePercent5Val = 0.f;
            ePercent5.setStyle(errorStyle);
            System.out.println("ePercent5Val not a float");
        }
        
    }
    
    
    public void setEPercent6()
    {  
        String tmp = ePercent6.getText();
        if (tmp != null) 
        {
            try 
            {
                ePercent6Val = Float.parseFloat(tmp);
                ePercent6.setStyle(successStyle);
                System.out.println(ePercent6Val);
            } 
            catch (NumberFormatException e) 
            {
                ePercent6.setText(null);
                ePercent6Val = 0.f;
                ePercent6.setStyle(errorStyle);
                System.out.println("ePercent6Val not a float");
            }
        }
        else
        {
            ePercent6.setText(null);
            ePercent6Val = 0.f;
            ePercent6.setStyle(errorStyle);
            System.out.println("ePercent6Val not a float");
        }
    }
    
    
    public void setEPercent7()
    {  
        String tmp = ePercent7.getText();
        if (tmp != null) 
        {
            try 
            {
                ePercent7Val = Float.parseFloat(tmp);
                ePercent7.setStyle(successStyle);
                System.out.println(ePercent7Val);
            } 
            catch (NumberFormatException e) 
            {
                ePercent7.setText(null);
                ePercent7Val = 0.f;
                ePercent7.setStyle(errorStyle);
                System.out.println("ePercent7Val not a float");
            }
        }
        else
        {
            ePercent7.setText(null);
            ePercent7Val = 0.f;
            ePercent7.setStyle(errorStyle);
            System.out.println("ePercent7Val not a float");
        }          
    }
    
    
    public void setEPercent8()
    {  
        String tmp = ePercent8.getText();
        if (tmp != null) 
        {
            try 
            {
                ePercent8Val = Float.parseFloat(tmp);
                ePercent8.setStyle(successStyle);
                System.out.println(ePercent8Val);
            } 
            catch (NumberFormatException e) 
            {
                ePercent8.setText(null);
                ePercent8Val = 0.f;
                ePercent8.setStyle(errorStyle);
                System.out.println("ePercent8Val not a float");
            }
        }
        else
        {
            ePercent8.setText(null);
            ePercent8Val = 0.f;
            ePercent8.setStyle(errorStyle);
            System.out.println("ePercent8Val not a float");
        }  
    }
    
   
    
    /////////////////////////////////////////////////////////////////
    // Set Postgraduation Fields
    
    
    @FXML
    private JFXTextField pPassYear;
    
    @FXML
    private JFXTextField pSchool;
    
    @FXML
    private JFXTextField pCity;
       
    @FXML
    private JFXTextField pPercent1;
    
    @FXML
    private JFXTextField pPercent2;
    
    @FXML
    private JFXTextField pPercent3;
    
    @FXML
    private JFXTextField pPercent4;
    
    private int pPassYearVal;    
    
    private float pPercent1Val, pPercent2Val, pPercent3Val, pPercent4Val;

    private String pSchoolVal, pCityVal;
    
    
    public void setPPassYear()
    {           
        String tmp = pPassYear.getText();
        if (tmp != null && tmp.length() == 4)
        {
            try 
            {
                pPassYearVal = Integer.parseInt(tmp);
                pPassYear.setStyle(successStyle);
                System.out.println(pPassYearVal);
            } 
            
            catch (NumberFormatException e) 
            {
                pPassYear.setText(null);
                pPassYearVal = 0;
                pPassYear.setStyle(errorStyle);
                System.out.println("pPassYear not an integer");
            }
        } 
        
        else 
        {
            pPassYear.setText(null);
            pPassYearVal = 0;
            pPassYear.setStyle(errorStyle);
            System.out.println("year length < 4");
        }
    }
    
    
    public void setPSchool()
    {    
        String tmp = pSchool.getText();
        if(tmp == null || !Pattern.compile("^[a-zA-Z0-9. -]+$", Pattern.CASE_INSENSITIVE).matcher(tmp).matches())
        { 
            pSchool.setText(null);
            pSchoolVal = null;
            pSchool.setStyle(errorStyle);
            System.out.println("false");             
        } 
        else 
        { 
            pSchool.setStyle(successStyle);
            pSchoolVal = tmp;
            System.out.println(pSchoolVal);
        }
    }
    
    
    public void setPCity()
    {   
        String tmp = pCity.getText();
        if(tmp == null || !Pattern.compile("[a-zA-Z0-9 ]+", Pattern.CASE_INSENSITIVE).matcher(tmp).matches())
        { 
            pCity.setText(null);
            pCityVal = null;
            pCity.setStyle(errorStyle);
            System.out.println("false"); 
        } 
        else 
        { 
            pCity.setStyle(successStyle);
            pCityVal = tmp;
            System.out.println(pCityVal);
        }
    }
    
    
    public void setPPercent1()
    {           
        String tmp = pPercent1.getText();
        if (tmp != null) 
        {
            try 
            {
                pPercent1Val = Float.parseFloat(tmp);
                pPercent1.setStyle(successStyle);
                System.out.println(pPercent1Val);
            } 
            catch (NumberFormatException e) 
            {
                pPercent1.setText(null);
                pPercent1Val = 0.f;
                pPercent1.setStyle(errorStyle);
                System.out.println("ePercent1Val not a float");
            }
        }
        else
        {
            pPercent1.setText(null);
            pPercent1Val = 0.f;
            pPercent1.setStyle(errorStyle);
            System.out.println("ePercent1Val not a float");
        }
    }
    
    
    public void setPPercent2()
    {   
        String tmp = pPercent2.getText();
        if (tmp != null) 
        {
            try 
            {
                pPercent2Val = Float.parseFloat(tmp);
                pPercent2.setStyle(successStyle);
                System.out.println(pPercent2Val);
            } 
            catch (NumberFormatException e) 
            {
                pPercent2.setText(null);
                pPercent2Val = 0.f;
                pPercent2.setStyle(errorStyle);
                System.out.println("ePercent2Val not a float");
            }
        }
        else
        {
            pPercent2.setText(null);
            pPercent2Val = 0.f;
            pPercent2.setStyle(errorStyle);
            System.out.println("ePercent2Val not a float");
        }
    }
    
    
    public void setPPercent3()
    {   
        String tmp = pPercent3.getText();
        if (tmp != null) 
        {
            try 
            {
                pPercent3Val = Float.parseFloat(tmp);
                pPercent3.setStyle(successStyle);
                System.out.println(pPercent3Val);
            } 
            catch (NumberFormatException e) 
            {
                pPercent3.setText(null);
                pPercent3Val = 0.f;
                pPercent3.setStyle(errorStyle);
                System.out.println("ePercent3Val not a float");
            }
        }
        else
        {
            pPercent3.setText(null);
            pPercent3Val = 0.f;
            pPercent3.setStyle(errorStyle);
            System.out.println("ePercent3Val not a float");
        }
    }
    
    
    public void setPPercent4()
    {    
        String tmp = pPercent4.getText();
        if (tmp != null) 
        {
            try 
            {
                pPercent4Val = Float.parseFloat(tmp);
                pPercent4.setStyle(successStyle);
                System.out.println(pPercent4Val);
            } 
            catch (NumberFormatException e) 
            {
                pPercent4.setText(null);
                pPercent4Val = 0.f;
                pPercent4.setStyle(errorStyle);
                System.out.println("ePercent4Val not a float");
            }
        }
        else
        {
            pPercent4.setText(null);
            pPercent4Val = 0.f;
            pPercent4.setStyle(errorStyle);
            System.out.println("ePercent4Val not a float");
        }
        
    }
    
    
    ///////////////////////////////////////////////////////////////////////////
    // Get Values
    
    ////////////////////////////////////////////////////////////////////////////
    // Diploma
      
    int getDPassYearVal()
    {
        return dPassYearVal;
    }
    
    String getDSchoolVal()
    {
       return dSchoolVal;
    }
    
    String getDCityVal()
    {
        return dCityVal;        
    }
    
    float getDPercent1Val()
    {
        return dPercent1Val;
    }
    
    float getDPercent2Val()
    {
        return dPercent2Val;
    }
    
    float getDPercent3Val()
    {
        return dPercent3Val;
    }
    
    float getDPercent4Val()
    {
        return dPercent4Val;
    }
    
    float getDPercent5Val()
    {
        return dPercent5Val;
    }
    
    float getDPercent6Val()
    {
        return dPercent6Val;
    }
    
    ////////////////////////////////////////////////////////////////////////////
    // Undergraduation
        
    int getEPassYearVal()
    {
        return ePassYearVal;
    }
    
    String getESchoolVal()
    {
       return eSchoolVal;
    }
    
    String getECityVal()
    {
        return eCityVal;        
    }
    
    float getEPercent1Val()
    {
        return ePercent1Val;
    }
    
    float getEPercent2Val()
    {
        return ePercent2Val;
    }
    
    float getEPercent3Val()
    {
        return ePercent3Val;
    }
    
    float getEPercent4Val()
    {
        return ePercent4Val;
    }
    
    float getEPercent5Val()
    {
        return ePercent5Val;
    }
    
    float getEPercent6Val()
    {
        return ePercent6Val;
    }
    
    float getEPercent7Val()
    {
        return ePercent7Val;
    }
    
    float getEPercent8Val()
    {
        return ePercent8Val;
    }
    
    ////////////////////////////////////////////////////////////////////////////
    // Postgraduation
        
    int getPPassYearVal()
    {
        return pPassYearVal;
    }
    
    String getPSchoolVal()
    {
       return pSchoolVal;
    }
    
    String getPCityVal()
    {
        return pCityVal;        
    }
    
    float getPPercent1Val()
    {
        return pPercent1Val;
    }
    
    float getPPercent2Val()
    {
        return pPercent2Val;
    }
    
    float getPPercent3Val()
    {
        return pPercent3Val;
    }
    
    float getPPercent4Val()
    {
        return pPercent4Val;
    }
    
         
    public void toPrevPg(MouseEvent event)
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
    
    
    public void toNextPg(MouseEvent event)
    {
        DatabaseIO dbIO = new DatabaseIO();
        dbIO.InsertValues();
        
        try 
        {
            Parent editPag1 = FXMLLoader.load(getClass().getResource("Editing3.fxml"));
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
    
        
    public void toHomePg(MouseEvent event)
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