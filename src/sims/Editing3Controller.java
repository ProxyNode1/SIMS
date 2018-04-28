
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
import javafx.scene.control.Label;
import javafx.scene.control.Tooltip;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;





/**
 * FXML Controller class
 *
 * @author VIC's
 */
public class Editing3Controller implements Initializable {

    @Override
    public void initialize(URL url, ResourceBundle rb) 
    {
        CEmail.requestFocus();
        //IdFld.setStyle("-fx-border-color: #ff2323; -fx-text-fill: white; -fx-prompt-text-fill: white;"); when error occurs or not filled
        try
        {
            s1 = Editing1Controller.useName;
            System.out.println(s1);
        }
        catch(Exception e)
        {
            errbtn.setText("Check input fields again!");
        }
        AddInfoField.setTooltip(new Tooltip("use '. ' after every statement "));
        Editing1Controller.setValues();
    }    
    

    @FXML
    private Label delData;
    
    @FXML
    private Pane Edit3;
   
    String s1;
    String h1 = null, h2 = null, h3 = null, h4 = null, h5 = null, h6 = null;
    
    @FXML
    public Label errbtn;
    
    @FXML
    private JFXTextField Email;
    public void getEmail()
    {   
        if(Email.getText() == null || Email.getText().trim().isEmpty())
        {
            h1 = null;
        }
        else
        {
            h1 = "'"+Email.getText()+"'";
            System.out.println(h1);
        }
    }
    
    @FXML
    private JFXTextField CEmail;
    public void getCEmail()
    {   h2 = "'"+CEmail.getText()+"'";
        System.out.println(h2);
    }
    

    @FXML
    private JFXTextField DadCntct;
    public void getDadCntct()
    {   
        String l = "'"+DadCntct.getText()+"'";
        if(DadCntct.getText() == null || DadCntct.getText().trim().isEmpty())
        {
            System.out.println(l);
            DadCntct.setText(null);
            DadCntct.setStyle("-fx-border-color: #ff2323; -fx-text-fill: white; -fx-prompt-text-fill: white;");
            h3 = null;
            System.out.println("check");
        }
        if(l.length() == 12)
        {
            h3 = l;
            System.out.println(h3);
            
        }
        else
        {
            System.out.println(l);
            DadCntct.setText(null);
            DadCntct.setStyle("-fx-border-color: #ff2323; -fx-text-fill: white; -fx-prompt-text-fill: white;");
            h3 = null;
            System.out.println("check");
        }
    }
    @FXML
    private JFXTextField FamCntct;
    public void getFamCntct()
    {   
        
        String l = "'"+FamCntct.getText()+"'";
        
        if(l.length() == 12)
        {
            h4 = l;
            System.out.println(h4);
            
        }
        else
        {
            System.out.println(l);
            DadCntct.setText(null);
            DadCntct.setStyle("-fx-border-color: #ff2323; -fx-text-fill: white; -fx-prompt-text-fill: white;");
            h4 = null;
            System.out.println("check");
        }
    }
    
    @FXML
    private JFXCheckBox CertifTick;
    public void getCertifTick()
    {   
        h5 = "'"+CertifTick.isSelected()+"'"; 
        System.out.println(h5);          
    }
    
    @FXML
    private TextArea AddInfoField;
    
    @FXML
    private Label saveTxt;
        
    public void savInfo(MouseEvent event)
     {  //h6 = AddInfoField.getText().replaceAll("\n", System.getProperty("line.separator"));
        if(AddInfoField.getText() == null || AddInfoField.getText().trim().isEmpty())
        {
            h6 = null;
        }
        else
        {
            h6 = "'"+AddInfoField.getText()+"'";
            System.out.println(h6);
        }
    }
    
    public void setValues()
    {
        DatabaseIO a = new DatabaseIO();
        a.setUlinfo(s1, h1, h2, h3, h4, h5, h6); 
    }
    
    public void delEdit3()
    {
       DatabaseIO d = new DatabaseIO();
       d.DelUlinfo(Editing1Controller.useName); 
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
            appStage.show();        } 
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
            Editing2Controller.setValues();
            setValues();
            
            
            Parent editPag1 = FXMLLoader.load(getClass().getResource("HomePage.fxml"));
            Scene editPg1Scene = new Scene(editPag1);
            Stage appStage = (Stage)((Node)event.getSource()).getScene().getWindow();
            appStage.setScene(editPg1Scene);
            appStage.show();
        }
         
        catch (Exception ex) 
        {
            ex.printStackTrace();
            errbtn.setText("Check input fields again!"); 
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
    
    
}
