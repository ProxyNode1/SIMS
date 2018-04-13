
package sims;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.Initializable;


import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXCheckBox;
import com.jfoenix.controls.JFXTextField;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextArea;
import javafx.scene.layout.VBox;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;





/**
 * FXML Controller class
 *
 * @author VIC's
 */
public class Editing3Controller implements Initializable {

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) 
    {
        Email.requestFocus();
        //IdFld.setStyle("-fx-border-color: #ff2323; -fx-text-fill: white; -fx-prompt-text-fill: white;"); when error occurs or not filled
        
    }    
    

    @FXML
    private Pane Edit3;
   

    @FXML
    private JFXTextField CEmail;
    public JFXTextField getCEmail() {
        return CEmail;
    }

    public void setCEmail(JFXTextField CEmail) {
        this.CEmail = CEmail;
    }

    @FXML
    private JFXTextField DadCntct;
    public JFXTextField getDadCntct() {
        return DadCntct;
    }

    public void setDadCntct(JFXTextField DadCntct) {
        this.DadCntct = DadCntct;
    }
    
    @FXML
    private JFXTextField Email;
    public JFXTextField getEmail() {
        return Email;
    }

    public void setEmail(JFXTextField Email) {
        this.Email = Email;
    }
        
    @FXML
    private TextArea AddInfoField;
    public TextArea getAddInfoField() {
        return AddInfoField;
    }

    public void setAddInfoField(TextArea AddInfoField) {
        this.AddInfoField = AddInfoField;
    }

    @FXML
    private JFXTextField FamCntct;
    public JFXTextField getFamCntct() {
        return FamCntct;
    }

    public void setFamCntct(JFXTextField FamCntct) {
        this.FamCntct = FamCntct;
    }

    @FXML
    private JFXCheckBox CertifTick;
    public JFXCheckBox getCertifTick() {
        return CertifTick;
    }

    public void setCertifTick(JFXCheckBox CertifTick) {
        this.CertifTick = CertifTick;
    }
    

   @FXML
    private Label BtnTo1;
    
     public void toEdit1(MouseEvent event)
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

    
    @FXML
    private Label BtnTo2;
    
    public void toEdit2(MouseEvent event)
    {
        try {
            Parent editPag1 = FXMLLoader.load(getClass().getResource("Editing2.fxml"));
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
    
    @FXML
    private JFXButton SavBtn;
    public void toSave(MouseEvent event)
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
    
    @FXML
    private Label bck;
    
    public void bck2HP(MouseEvent event)
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
    
    @FXML
    public static Label StatusBtn1;

        
    /*public void showError()
    {
        StatusBtn.setVisible(true);
    }*/
}
