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
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Tab;
import javafx.scene.layout.AnchorPane;

/**
 * FXML Controller class
 *
 * @author Vic's
 */
public class DetailsController implements Initializable 
{

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


    @Override
    public void initialize(URL url, ResourceBundle rb) 
    {
        
        nameField.setText("");
        
        try 
        {
            //Anc1 = loader.load(this.getClass().getResource("Test2"));
            basicInfoTab.setContent(FXMLLoader.load(getClass().getResource("BasicInfo.fxml")));
        } 
        catch (Exception ex) 
        {
            System.out.println("Cant load 1st tab");
            System.err.println(ex.getMessage());
        }
        
        try 
        {
            sscInfoTab.setContent(FXMLLoader.load(getClass().getResource("SSCInfo.fxml")));
        } 
        catch (IOException ex) 
        {
            System.out.println("Cant load 2nd tab");
            System.err.println(ex.getMessage());
        }
        
        try 
        {
            hssInfoTab.setContent(FXMLLoader.load(getClass().getResource("")));
        } 
        catch (IOException ex) 
        {
            System.out.println("Cant load 3rd tab");
            System.err.println(ex.getMessage());
        }
        
        try 
        {
            diplomaInfoTab.setContent(FXMLLoader.load(getClass().getResource("")));
        } 
        catch (IOException ex) 
        {
            System.out.println("Cant load 4th tab");
            System.err.println(ex.getMessage());
        }
        
        try 
        {
            ugInfoTab.setContent(FXMLLoader.load(getClass().getResource("")));
        } 
        catch (IOException ex) 
        {
            System.out.println("Cant load 5th tab");
            System.err.println(ex.getMessage());
        }
        
        try 
        {
            pgInfoTab.setContent(FXMLLoader.load(getClass().getResource("")));
        } 
        catch (IOException ex) 
        {
            System.out.println("Cant load 6th tab");
            System.err.println(ex.getMessage());
        }
        
        try 
        {
            otherInfoTab.setContent(FXMLLoader.load(getClass().getResource("")));
        } 
        catch (IOException ex) 
        {
            System.out.println("Cant load 7th tab");
            System.err.println(ex.getMessage());
        }
    }    
    
}


