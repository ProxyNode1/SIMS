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
            
    SSCInfoData dataClassSSC = SSCInfoData.getInstance();
    
    
    public void setSPassYear()
    {           
        String tmp = sPassYear.getText();
        if (tmp != null && tmp.length() == 4) 
        {
            try 
            {
                dataClassSSC.setPassYearVal(Integer.parseInt(tmp));
                sPassYear.setStyle(successStyle);
            } 
            catch (NumberFormatException e) 
            {
                sPassYear.setText(null);
                dataClassSSC.setPassYearVal(0);
                sPassYear.setStyle(errorStyle);
                System.out.println("sPassYearVal not an integer");
            }
        }
        else
        {
            sPassYear.setText(null);
            dataClassSSC.setPassYearVal(0);
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
            dataClassSSC.setRNoVal(null);
            sRNo.setStyle(errorStyle);
        }        
        else
        {
            dataClassSSC.setRNoVal(tmp);
            sRNo.setStyle(successStyle); 
        }        
    }
    
    public void setSCBSE()
    {
        sBoard.setText("CBSE");
        dataClassSSC.setBoardVal("CBSE");   
        sBoard.setStyle("-fx-border-color: #23ff23; -fx-background-color: #2F3136;");
    }
    
    public void setSCISCE()
    {
        sBoard.setText("CISCE");
        dataClassSSC.setBoardVal("CISCE");
        sBoard.setStyle("-fx-border-color: #23ff23; -fx-background-color: #2F3136;");
    }
    
    public void setSState()
    {
        sBoard.setText("STATE");
        dataClassSSC.setBoardVal("STATE");
        sBoard.setStyle("-fx-border-color: #23ff23; -fx-background-color: #2F3136;");
    }
    
    public void setSIBO()
    {
        sBoard.setText("IBO");
        dataClassSSC.setBoardVal("IBO");
        sBoard.setStyle("-fx-border-color: #23ff23");
    }
     
    public void setSCIE()
    {
        sBoard.setText("CIE");
        dataClassSSC.setBoardVal("CIE");
        sBoard.setStyle("-fx-border-color: #23ff23; -fx-background-color: #2F3136;");
    }
      
    
    public void setSMedium()
    {   
        String tmp = sMedium.getText();
        if(tmp == null || !Pattern.compile("[a-zA-Z]+", Pattern.CASE_INSENSITIVE).matcher(tmp).matches())
        { 
            sMedium.setText(null);
            dataClassSSC.setMediumVal(null);
            sMedium.setStyle(errorStyle);
            System.out.println("false");             
        } 
        else 
        { 
           dataClassSSC.setMediumVal(tmp);
           sMedium.setStyle(successStyle); 
        }
    }
    
    
    public void setSSchool()
    {    
        String tmp = sSchool.getText();
        if(tmp == null || !Pattern.compile("^[a-zA-Z0-9. -]+$", Pattern.CASE_INSENSITIVE).matcher(tmp).matches())
        { 
            sSchool.setText(null);
            dataClassSSC.setSchoolVal(null);
            sSchool.setStyle(errorStyle);
            System.out.println("false");           
        } 
        else 
        { 
            dataClassSSC.setSchoolVal(tmp);
            sSchool.setStyle(successStyle);
        }
    }
    
        
    public void setSCity()
    {   
        String tmp = sCity.getText();
        if(tmp == null || !Pattern.compile("[a-zA-Z0-9 ]+", Pattern.CASE_INSENSITIVE).matcher(tmp).matches())
        { 
            sCity.setText(null);
            dataClassSSC.setCityVal(null);
            sCity.setStyle(errorStyle);
            System.out.println("false");             
        } 
        else 
        { 
            dataClassSSC.setCityVal(tmp);
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
                dataClassSSC.setPercentVal(Float.parseFloat(tmp));
                sPercent.setStyle(successStyle);
            } 
            catch (NumberFormatException e) 
            {
                sPercent.setText(null);
                dataClassSSC.setPercentVal(0.f);
                sPercent.setStyle(errorStyle);
                System.out.println("sPercentVal not a float");
            }
        }
        else
        {
            sPercent.setText(null);
            dataClassSSC.setPercentVal(0.f);
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
    
    HSSInfoData dataClassHss = HSSInfoData.getInstance();
    
    
    public void setHPassYear()
    {
        String tmp = hPassYear.getText();
        if (tmp != null && tmp.length() == 4) 
        {
            try 
            {
                dataClassHss.setPassYearVal(Integer.parseInt(tmp));
                hPassYear.setStyle(successStyle);
            } 
            
            catch (NumberFormatException e) 
            {
                hPassYear.setText(null);
                 dataClassHss.setPassYearVal(0);
                hPassYear.setStyle(errorStyle);
                System.out.println("hPassYear not an integer");
            }
        } 
        
        else 
        {
            hPassYear.setText(null);
            dataClassHss.setPassYearVal(0);
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
            dataClassHss.setRNoVal(null);
            hRNo.setStyle(errorStyle);
        }        
        else
        {
            dataClassHss.setRNoVal(tmp);
            hRNo.setStyle(successStyle);  
        }  
    }
    

    public void setHCBSE()
    {
        hBoard.setText("CBSE");
        dataClassHss.setBoardVal("CBSE"); 
        hBoard.setStyle("-fx-border-color: #23ff23; -fx-background-color: #2F3136;");
    }
    
    public void setHCISCE()
    {
        hBoard.setText("CISCE");
        dataClassHss.setBoardVal("CISCE");
        hBoard.setStyle("-fx-border-color: #23ff23; -fx-background-color: #2F3136;");
    }
    
    public void setHState()
    {
        hBoard.setText("STATE");
        dataClassHss.setBoardVal("STATE");
        hBoard.setStyle("-fx-border-color: #23ff23; -fx-background-color: #2F3136;");
    }
    
    public void setHIBO()
    {
        hBoard.setText("IBO");
        dataClassHss.setBoardVal("IBO");
        hBoard.setStyle("-fx-border-color: #23ff23; -fx-background-color: #2F3136;");
    }
     
    public void setHCIE()
    {
        hBoard.setText("CIE");
        dataClassHss.setBoardVal("CIE");
        hBoard.setStyle("-fx-border-color: #23ff23; -fx-background-color: #2F3136;");
    }  
       
    
    public void setHMedium()
    {   
        String tmp = hMedium.getText();
        if(tmp == null || !Pattern.compile("[a-zA-Z]+", Pattern.CASE_INSENSITIVE).matcher(tmp).matches())
        { 
            hMedium.setText(null);
            dataClassHss.setMediumVal(null);
            hMedium.setStyle(errorStyle);
            System.out.println("false");             
        } 
        else 
        { 
           dataClassHss.setMediumVal(tmp);
           hMedium.setStyle(successStyle);
        }
    }
    
        
    public void setHSchool()
    {   
        String tmp = hSchool.getText();
        if(tmp == null || !Pattern.compile("^[a-zA-Z0-9. -]+$", Pattern.CASE_INSENSITIVE).matcher(tmp).matches())
        { 
            hSchool.setText(null);
            dataClassHss.setSchoolVal(null);
            hSchool.setStyle(errorStyle);
            System.out.println("false");             
        } 
        else 
        { 
            dataClassHss.setSchoolVal(tmp);
            hSchool.setStyle(successStyle);
        }
    }
    
    
    public void setHCity()
    {   
        String tmp = hCity.getText();
        if(tmp == null || !Pattern.compile("[a-zA-Z0-9 ]+", Pattern.CASE_INSENSITIVE).matcher(tmp).matches())
        { 
            hCity.setText(null);
            dataClassHss.setCityVal(null);
            hCity.setStyle(errorStyle);
            System.out.println("false");             
        } 
        else 
        { 
            hCity.setStyle(successStyle);                
            dataClassHss.setCityVal(tmp);         
        }
    }
    
    
    public void setHPercent()
    {   
        String tmp = hPercent.getText();
        if (tmp != null) 
        {
            try 
            {
                dataClassHss.setPercentVal(Float.parseFloat(tmp));
                hPercent.setStyle(successStyle);
            } 
            catch (NumberFormatException e) 
            {
                hPercent.setText(null);
                dataClassHss.setPercentVal(0.f);
                hPercent.setStyle(errorStyle);
                System.out.println("hPercentVal not a float");
            }
        }
        else
        {
            hPercent.setText(null);
            dataClassHss.setPercentVal(0.f);
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
                dataClassHss.setPhysicsVal(Float.parseFloat(tmp));
                hPhysics.setStyle(successStyle);
            } 
            catch (NumberFormatException e) 
            {
                hPhysics.setText(null);
                dataClassHss.setPhysicsVal(0.f);
                hPhysics.setStyle(errorStyle);
                System.out.println("hPhysicsVal not a float");
            }
        }
        else
        {
            hPhysics.setText(null);
            dataClassHss.setPhysicsVal(0.f);
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
                dataClassHss.setChemistryVal(Float.parseFloat(tmp));
                hChemistry.setStyle(successStyle);
            } 
            catch (NumberFormatException e) 
            {
                hChemistry.setText(null);
                dataClassHss.setChemistryVal(0.f);
                hChemistry.setStyle(errorStyle);
                System.out.println("hChemistryVal not a float");
            }
        }
        else
        {
            hChemistry.setText(null);
            dataClassHss.setChemistryVal(0.f);
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
                dataClassHss.setMathVal(Float.parseFloat(tmp));
                hMath.setStyle(successStyle);
            } 
            catch (NumberFormatException e) 
            {
                hMath.setText(null);
                dataClassHss.setMathVal(0.f);
                hMath.setStyle(errorStyle);
                System.out.println("hMathVal not a float");
            }
        }
        else
        {
            hMath.setText(null);
            dataClassHss.setMathVal(0.f);
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
            
    DiplomaInfoData dataClassDiploma = DiplomaInfoData.getInstance();
    
    
    public void setDPassYear()
    {                  
        String tmp = dPassYear.getText();
        if (tmp != null && tmp.length() == 4) 
        {
            try 
            {
                dataClassDiploma.setPassYearVal(Integer.parseInt(tmp));
                dPassYear.setStyle(successStyle);
            } 
            
            catch (NumberFormatException e) 
            {
                dPassYear.setText(null);
                dataClassDiploma.setPassYearVal(0);
                dPassYear.setStyle(errorStyle);
                System.out.println("dPassYear not an integer");
            }
        }       
        else 
        {
            dPassYear.setText(null);
            dataClassDiploma.setPassYearVal(0);
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
            dataClassDiploma.setSchoolVal(null);
            dSchool.setStyle(errorStyle);
            System.out.println("false");             
            
        } 
        else 
        {                             
            dataClassDiploma.setSchoolVal(tmp);
            dSchool.setStyle(successStyle);
        }
    }
    
    
    public void setDCity()
    {   
        String tmp = dCity.getText();
        if(tmp == null || !Pattern.compile("[a-zA-Z0-9 ]+", Pattern.CASE_INSENSITIVE).matcher(tmp).matches())
        { 
            dCity.setText(null);
            dataClassDiploma.setCityVal(null);
            dCity.setStyle(errorStyle);
            System.out.println("false");
        } 
        else 
        {                             
            dataClassDiploma.setCityVal(tmp);
            dCity.setStyle(successStyle);
        }
    }
    
    
    /*public void setDPercent1()
    {           
        String tmp = dPercent1.getText();
        if (tmp != null) 
        {
            try 
            {
                dataClassDiploma.setPercent1Val(Float.parseFloat(tmp));
                dPercent1.setStyle(successStyle);
            } 
            catch (NumberFormatException e) 
            {
                dPercent1.setText(null);
                dataClassDiploma.setPercent1Val(0.f);
                dPercent1.setStyle(errorStyle);
                System.out.println("dPercent1Val not a float");
            }
        }
        else
        {
            dPercent1.setText(null);
            dataClassDiploma.setPercent1Val(0.f);
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
                dataClassDiploma.setPercent2Val(Float.parseFloat(tmp));
                dPercent2.setStyle(successStyle);
            } 
            catch (NumberFormatException e) 
            {
                dPercent2.setText(null);
                dataClassDiploma.setPercent2Val(0.f);
                dPercent2.setStyle(errorStyle);
                System.out.println("dPercent2Val not a float");
            }
        }
        else
        {
            dPercent2.setText(null);
            dataClassDiploma.setPercent2Val(0.f);
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
                dataClassDiploma.setPercent3Val(Float.parseFloat(tmp));
                dPercent3.setStyle(successStyle);
            } 
            catch (NumberFormatException e) 
            {
                dPercent3.setText(null);
               dataClassDiploma.setPercent3Val(0.f);
                dPercent3.setStyle(errorStyle);
                System.out.println("dPercent3Val not a float");
            }
        }
        else
        {
            dPercent3.setText(null);
            dataClassDiploma.setPercent3Val(0.f);
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
                dataClassDiploma.setPercent4Val(Float.parseFloat(tmp));
                dPercent4.setStyle(successStyle);
            } 
            catch (NumberFormatException e) 
            {
                dPercent4.setText(null);
                dataClassDiploma.setPercent4Val(0.f);
                dPercent4.setStyle(errorStyle);
                System.out.println("dPercent4Val not a float");
            }
        }
        else
        {
            dPercent4.setText(null);
            dataClassDiploma.setPercent4Val(0.f);
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
                dataClassDiploma.setPercent5Val(Float.parseFloat(tmp));
                dPercent5.setStyle(successStyle);
            } 
            catch (NumberFormatException e) 
            {
                dPercent5.setText(null);
                dataClassDiploma.setPercent5Val(0.f);
                dPercent5.setStyle(errorStyle);
                System.out.println("dPercent5Val not a float");
            }
        }
        else
        {
            dPercent5.setText(null);
            dataClassDiploma.setPercent5Val(0.f);
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
                dataClassDiploma.setPercent6Val(Float.parseFloat(tmp));
                dPercent6.setStyle(successStyle);
            } 
            catch (NumberFormatException e) 
            {
                dPercent6.setText(null);
                dataClassDiploma.setPercent6Val(0.f);
                dPercent6.setStyle(errorStyle);
                System.out.println("dPercent6Val not a float");
            }
        }
        else
        {
            dPercent6.setText(null);
            dataClassDiploma.setPercent6Val(0.f);
            dPercent6.setStyle(errorStyle);
            System.out.println("dPercent6Val not a float");
        }
    }*/
       
    
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
    
        
    UGInfoData dataClassUG = UGInfoData.getInstance();
    
    
    public void setEPassYear()
    {                  
        String tmp = ePassYear.getText();
        if (tmp != null && tmp.length() == 4)
        {
            try 
            {
                dataClassUG.setPassYearVal(Integer.parseInt(tmp));
                ePassYear.setStyle(successStyle);
            } 
            
            catch (NumberFormatException e) 
            {
                ePassYear.setText(null);
                dataClassUG.setPassYearVal(0);
                ePassYear.setStyle(errorStyle);
                System.out.println("ePassYear not an integer");
            }
        } 
        
        else 
        {
            ePassYear.setText(null);
            dataClassUG.setPassYearVal(0);
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
            dataClassUG.setSchoolVal(null);
            eSchool.setStyle(errorStyle);
            System.out.println("false");
            
        } 
        else 
        {             
            dataClassUG.setSchoolVal(tmp);
            eSchool.setStyle(successStyle);
        }
    }
    
    
    public void setECity()
    {           
        String tmp = eCity.getText();
        if(tmp == null || !Pattern.compile("[a-zA-Z0-9 ]+", Pattern.CASE_INSENSITIVE).matcher(tmp).matches())
        { 
            eCity.setText(null);
            dataClassUG.setCityVal(null);
            eCity.setStyle(errorStyle);
            System.out.println("false");
        } 
        else 
        {            
            dataClassUG.setCityVal(tmp);
            eCity.setStyle(successStyle);
        }
    }
    
    
    /*public void setEPercent1()
    {           
        String tmp = ePercent1.getText();
        if (tmp != null) 
        {
            try 
            {
                dataClassUG.setPercent1Val(Float.parseFloat(tmp));
                ePercent1.setStyle(successStyle);
            } 
            catch (NumberFormatException e) 
            {
                ePercent1.setText(null);
                dataClassUG.setPercent1Val(0.f);
                ePercent1.setStyle(errorStyle);
                System.out.println("ePercent1Val not a float");
            }
        }
        else
        {
            ePercent1.setText(null);
            dataClassUG.setPercent1Val(0.f);
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
                dataClassUG.setPercent2Val(Float.parseFloat(tmp));
                ePercent2.setStyle(successStyle);
            } 
            catch (NumberFormatException e) 
            {
                ePercent2.setText(null);
                dataClassUG.setPercent2Val(0.f);
                ePercent2.setStyle(errorStyle);
                System.out.println("ePercent2Val not a float");
            }
        }
        else
        {
            ePercent2.setText(null);
            dataClassUG.setPercent2Val(0.f);
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
                dataClassUG.setPercent3Val(Float.parseFloat(tmp));
                ePercent3.setStyle(successStyle);
            } 
            catch (NumberFormatException e) 
            {
                ePercent3.setText(null);
                dataClassUG.setPercent3Val(0.f);
                ePercent3.setStyle(errorStyle);
                System.out.println("ePercent3Val not a float");
            }
        }
        else
        {
            ePercent3.setText(null);
            dataClassUG.setPercent3Val(0.f);
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
                dataClassUG.setPercent4Val(Float.parseFloat(tmp));
                ePercent4.setStyle(successStyle);
            } 
            catch (NumberFormatException e) 
            {
                ePercent4.setText(null);
                dataClassUG.setPercent4Val(0.f);
                ePercent4.setStyle(errorStyle);
                System.out.println("ePercent4Val not a float");
            }
        }
        else
        {
            ePercent4.setText(null);
            dataClassUG.setPercent4Val(0.f);
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
                dataClassUG.setPercent5Val(Float.parseFloat(tmp));
                ePercent5.setStyle(successStyle);
            } 
            catch (NumberFormatException e) 
            {
                ePercent5.setText(null);
                dataClassUG.setPercent5Val(0.f);
                ePercent5.setStyle(errorStyle);
                System.out.println("ePercent5Val not a float");
            }
        }
        else
        {
            ePercent5.setText(null);
            dataClassUG.setPercent5Val(0.f);
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
                dataClassUG.setPercent6Val(Float.parseFloat(tmp));
                ePercent6.setStyle(successStyle);
            } 
            catch (NumberFormatException e) 
            {
                ePercent6.setText(null);
                dataClassUG.setPercent6Val(0.f);
                ePercent6.setStyle(errorStyle);
                System.out.println("ePercent6Val not a float");
            }
        }
        else
        {
            ePercent6.setText(null);
            dataClassUG.setPercent6Val(0.f);
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
                dataClassUG.setPercent7Val(Float.parseFloat(tmp));
                ePercent7.setStyle(successStyle);
            } 
            catch (NumberFormatException e) 
            {
                ePercent7.setText(null);
                dataClassUG.setPercent7Val(0.f);
                ePercent7.setStyle(errorStyle);
                System.out.println("ePercent7Val not a float");
            }
        }
        else
        {
            ePercent7.setText(null);
            dataClassUG.setPercent7Val(0.f);
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
                dataClassUG.setPercent8Val(Float.parseFloat(tmp));
                ePercent8.setStyle(successStyle);
            } 
            catch (NumberFormatException e) 
            {
                ePercent8.setText(null);
                dataClassUG.setPercent8Val(0.f);
                ePercent8.setStyle(errorStyle);
                System.out.println("ePercent8Val not a float");
            }
        }
        else
        {
            ePercent8.setText(null);
            dataClassUG.setPercent8Val(0.f);
            ePercent8.setStyle(errorStyle);
            System.out.println("ePercent8Val not a float");
        }  
    }*/
    
   
    
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
        
    PGInfoData dataClassPG = PGInfoData.getInstance();
    
    
    public void setPPassYear()
    {           
        String tmp = pPassYear.getText();
        if (tmp != null && tmp.length() == 4)
        {
            try 
            {
                dataClassPG.setPassYearVal(Integer.parseInt(tmp));
                pPassYear.setStyle(successStyle);
            } 
            
            catch (NumberFormatException e) 
            {
                pPassYear.setText(null);
                dataClassPG.setPassYearVal(0);
                pPassYear.setStyle(errorStyle);
                System.out.println("pPassYear not an integer");
            }
        } 
        
        else 
        {
            pPassYear.setText(null);
            dataClassPG.setPassYearVal(0);
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
            dataClassPG.setSchoolVal(null);
            pSchool.setStyle(errorStyle);
            System.out.println("false");             
        } 
        else 
        {             
            dataClassPG.setSchoolVal(tmp);
            pSchool.setStyle(successStyle);
        }
    }
    
    
    public void setPCity()
    {   
        String tmp = pCity.getText();
        if(tmp == null || !Pattern.compile("[a-zA-Z0-9 ]+", Pattern.CASE_INSENSITIVE).matcher(tmp).matches())
        { 
            pCity.setText(null);
            dataClassPG.setCityVal(null);
            pCity.setStyle(errorStyle);
            System.out.println("false"); 
        } 
        else 
        {             
            dataClassPG.setCityVal(tmp);
            pCity.setStyle(successStyle);
        }
    }
    
    
    /*public void setPPercent1()
    {           
        String tmp = pPercent1.getText();
        if (tmp != null) 
        {
            try 
            {
                dataClassPG.setPercent1Val(Float.parseFloat(tmp));
                pPercent1.setStyle(successStyle);
            } 
            catch (NumberFormatException e) 
            {
                pPercent1.setText(null);
                dataClassPG.setPercent1Val(0.f);
                pPercent1.setStyle(errorStyle);
                System.out.println("pPercent1Val not a float");
            }
        }
        else
        {
            pPercent1.setText(null);
            dataClassPG.setPercent1Val(0.f);
            pPercent1.setStyle(errorStyle);
            System.out.println("pPercent1Val not a float");
        }
    }
    
    
    public void setPPercent2()
    {   
        String tmp = pPercent2.getText();
        if (tmp != null) 
        {
            try 
            {
                dataClassPG.setPercent2Val(Float.parseFloat(tmp));
                pPercent2.setStyle(successStyle);
            } 
            catch (NumberFormatException e) 
            {
                pPercent2.setText(null);
                dataClassPG.setPercent2Val(0.f);
                pPercent2.setStyle(errorStyle);
                System.out.println("pPercent2Val not a float");
            }
        }
        else
        {
            pPercent2.setText(null);
            dataClassPG.setPercent2Val(0.f);
            pPercent2.setStyle(errorStyle);
            System.out.println("pPercent2Val not a float");
        }
    }
    
    
    public void setPPercent3()
    {   
        String tmp = pPercent3.getText();
        if (tmp != null) 
        {
            try 
            {
                dataClassPG.setPercent3Val(Float.parseFloat(tmp));
                pPercent3.setStyle(successStyle);
            } 
            catch (NumberFormatException e) 
            {
                pPercent3.setText(null);
                dataClassPG.setPercent3Val(0.f);
                pPercent3.setStyle(errorStyle);
                System.out.println("pPercent3Val not a float");
            }
        }
        else
        {
            pPercent3.setText(null);
            dataClassPG.setPercent3Val(0.f);
            pPercent3.setStyle(errorStyle);
            System.out.println("pPercent3Val not a float");
        }
    }
    
    
    public void setPPercent4()
    {    
        String tmp = pPercent4.getText();
        if (tmp != null) 
        {
            try 
            {
                dataClassPG.setPercent4Val(Float.parseFloat(tmp));
                pPercent4.setStyle(successStyle);
            } 
            catch (NumberFormatException e) 
            {
                pPercent4.setText(null);
                dataClassPG.setPercent4Val(0.f);
                pPercent4.setStyle(errorStyle);
                System.out.println("pPercent4Val not a float");
            }
        }
        else
        {
            pPercent4.setText(null);
            dataClassPG.setPercent4Val(0.f);
            pPercent4.setStyle(errorStyle);
            System.out.println("pPercent4Val not a float");
        }
        
    }*/
    
       
         
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