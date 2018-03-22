
package sims;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.Initializable;


import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXCheckBox;
import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import javafx.scene.layout.VBox;
import javafx.scene.shape.Circle;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

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
    

    @FXML
    private VBox menuBar;
    
    @FXML
    private Label CloseBtn;
    @FXML
    void handleClose(ActionEvent event) 
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
    private Circle BtnTo3;

    @FXML
    private JFXButton SavBtn;

    @FXML
    private TextArea AddInfoField;

    @FXML
    private JFXTextField MomCntct;

    @FXML
    private JFXCheckBox CertifTick;

    @FXML
    private Circle BtnTo2;

    @FXML
    private Circle BtnTo1;
    
    
   
    
}
