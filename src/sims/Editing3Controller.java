
package sims;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.Initializable;


import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXCheckBox;
import com.jfoenix.controls.JFXTextField;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextArea;
import javafx.scene.layout.VBox;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import static sims.Sims.stage;




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
        EmailBtn.requestFocus();
        
    }    
    Stage primaryStage = stage;

    @FXML
    private Pane Edit3;
    
    @FXML
    private VBox menuBar;
    
    @FXML
    private Label CloseBtn;
    
    @FXML
    void handleClose(MouseEvent event)
    {
        
        System.exit(0);
        
    }

    @FXML
    private JFXTextField CEmailBtn;

    @FXML
    private JFXTextField DadCntct;

    @FXML
    private JFXTextField EmailBtn;

    
    @FXML
    private JFXButton SavBtn;
    public void toSave(MouseEvent event)
     {
        try 
        {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("HomePage.fxml"));
            Parent root1 = (Parent) fxmlLoader.load();
            Stage stage = new Stage();
            stage.setScene(new Scene(root1));
            stage.initStyle(StageStyle.TRANSPARENT);
            stage.show();
        } 
        catch (Exception ex) 
        {
            ex.printStackTrace();
            
        }
    }
    
    

    @FXML
    private TextArea AddInfoField;

    @FXML
    private JFXTextField MomCntct;

    @FXML
    private JFXCheckBox CertifTick;

   @FXML
    private Label BtnTo1;
    
     public void toEdit1(MouseEvent event)
     {
        try 
        {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("Editing1.fxml"));
            Parent root1 = (Parent) fxmlLoader.load();
            Stage stage = new Stage();
            stage.setScene(new Scene(root1));
            stage.initStyle(StageStyle.UNDECORATED);
            stage.show();
            primaryStage.close();
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
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("Editing2.fxml"));
            Parent root1 = (Parent) fxmlLoader.load();
            Stage stage = new Stage();
            stage.setScene(new Scene(root1));
            stage.initStyle(StageStyle.UNDECORATED);
            stage.show();
            primaryStage.close();
        } 
        catch (Exception ex) 
        {
            ex.printStackTrace();
        }
    }

    @FXML
    private Label BtnTo3;  
    
    /*public void toEdit3(MouseEvent event)
    {
        try 
        {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("Editing3.fxml"));
            Parent root1 = (Parent) fxmlLoader.load();
            Stage stage = new Stage();
            stage.setScene(new Scene(root1));
            stage.initStyle(StageStyle.TRANSPARENT);
            stage.show();
        } 
        catch (Exception ex) 
          {
            ex.printStackTrace();
          }
    }*/
    
    
   
    
}
