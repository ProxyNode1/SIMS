/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sims;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;import javafx.stage.Stage;
import javafx.stage.StageStyle;
;

/**
 *
 * @author VIC's
 */
public class FXMLDocumentController implements Initializable {
    
     @FXML
     private JFXButton saveBtn;

     public void handleSaveButt(ActionEvent event){
         try {
             System.out.println("Clicked Dick!!!");
             FXMLLoader fxmlloader = new FXMLLoader(getClass().getResource("FXML_HomePage.fxml"));
             Parent root1 = (Parent) fxmlloader.load();
             Stage stage = new Stage();
             stage.setScene(new Scene(root1));
             stage.initStyle(StageStyle.TRANSPARENT);
             stage.show();
         } catch (IOException ex) {
             Logger.getLogger(FXMLDocumentController.class.getName()).log(Level.SEVERE, null, ex);
         }
     }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
