/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sims;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.Initializable;

import com.jfoenix.controls.JFXTextField;
import java.io.IOException;
import java.util.regex.Pattern;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Tab;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import javafx.scene.control.Tooltip;



public class DetailsController implements Initializable 
{
    @Override
    public void initialize(URL url, ResourceBundle rb) 
    {
        //nameField.setTooltip(new Tooltip ("use Fullname"));
                
        String tmp1 = oBasicInfoData.getNameVal();
        if(tmp1 != null)
        {
            nameField.setText(tmp1);
        }
                 
        InitilizeTabs();
    }   
    
        
    void InitilizeTabs()
    {
        try 
        {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("BasicInfo.fxml"));
            
            basicInfoTab.setContent(loader.load());
            oBasicInfoController = loader.getController();
        } 
        catch (Exception ex) 
        {
            System.out.println("Cant load 1st tab");
            System.err.println(ex.getMessage());
        }
        
        
        try 
        {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("SSCInfo.fxml"));
            
            sscInfoTab.setContent(loader.load());
            oSSCInfoController = loader.getController();
        } 
        catch (IOException ex) 
        {
            System.out.println("Cant load 2nd tab");
            System.err.println(ex.getMessage());
        }
        
        
        try 
        {   
            FXMLLoader loader = new FXMLLoader(getClass().getResource("HSSInfo.fxml"));
            
            hssInfoTab.setContent(loader.load());
            oHSSInfoController = loader.getController();
        } 
        catch (IOException ex) 
        {
            System.out.println("Cant load 3rd tab");
            System.err.println(ex.getMessage());
        }
        
        
        try 
        {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("DiplomaInfo.fxml"));
            
            diplomaInfoTab.setContent(loader.load());
            oDiplomaInfoController = loader.getController();
        } 
        catch (IOException ex) 
        {
            System.out.println("Cant load 4th tab");
            System.err.println(ex.getMessage());
        }
        
        
        try 
        {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("UGInfo.fxml"));
            
            ugInfoTab.setContent(loader.load());
            oUGInfoController = loader.getController();
        } 
        catch (IOException ex) 
        {
            System.out.println("Cant load 5th tab");
            System.err.println(ex.getMessage());
        }
        
        
        try 
        {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("PGInfo.fxml"));
            
            pgInfoTab.setContent(loader.load());
            oPGInfoController = loader.getController();
        } 
        catch (IOException ex) 
        {
            System.out.println("Cant load 6th tab");
            System.err.println(ex.getMessage());
        }
        
        
        try 
        {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("OtherInfo.fxml"));
            
            otherInfoTab.setContent(loader.load());
            oOtherInfoController = loader.getController();
        } 
        catch (IOException ex) 
        {
            System.out.println("Cant load 7th tab");
            System.err.println(ex.getMessage());
        }
    }
    
            
    public void getName() throws NullPointerException
    {       
        String tmp = nameField.getText();
        if(tmp == null || !Pattern.compile("[a-zA-Z]+", Pattern.CASE_INSENSITIVE).matcher(tmp).matches())
        { 
            nameField.setText(null);
            oBasicInfoData.setNameVal(null);
            nameField.setStyle(errorStyle);
            
            throw new NullPointerException("name null");
        } 
        
        else 
        { 
            nameField.setText(tmp);
            nameField.setStyle(null); 
            oBasicInfoData.setNameVal(tmp);            
        }
    }
     
    
    public void validateData()
    {
        getName();
        oBasicInfoController.ValidateFields();
        oSSCInfoController.ValidateFields();
        oHSSInfoController.ValidateFields();
        oDiplomaInfoController.ValidateFields();
        oUGInfoController.ValidateFields();
        oPGInfoController.ValidateFields();
        oOtherInfoController.ValidateField();
    }
    
    
    public void saveData()
    {
        validateData();
    }
    
    
    public void updateData()
    {
        
    }
    
    
    public void deleteData()
    {
        
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
    
    
    
    private final String errorStyle = "-fx-border-color: #ff2323;";   

    @FXML
    private JFXTextField nameField;
    
    @FXML
    private Tab basicInfoTab;

    @FXML
    private Tab sscInfoTab;

    @FXML
    private Tab hssInfoTab;

    @FXML
    private Tab diplomaInfoTab;

    @FXML
    private Tab ugInfoTab;

    @FXML
    private Tab pgInfoTab;

    @FXML
    private Tab otherInfoTab;
    
    private final BasicInfoData oBasicInfoData = BasicInfoData.getInstance();
    
    
    private BasicInfoController oBasicInfoController;
    private SSCInfoController oSSCInfoController;
    private HSSInfoController oHSSInfoController;
    private DiplomaInfoController oDiplomaInfoController;
    private UGInfoController oUGInfoController;
    private PGInfoController oPGInfoController;
    private OtherInfoController oOtherInfoController;
}


