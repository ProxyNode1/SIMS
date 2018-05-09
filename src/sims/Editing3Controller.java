
package sims;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.Initializable;


import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXCheckBox;
import com.jfoenix.controls.JFXTextField;
import java.sql.*;
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

        if(Editing1Controller.ui  == 1)
        {
            try
            {
                s1 = Editing1Controller.useName;
                System.out.println(s1);
                Editing1Controller.setValues();
                e = 0;
            }
            catch(Exception x)
            {
                e = 1;
                errbtn.setText("Check input fields again!"); 
            }
        }
        
        AddInfoField.setTooltip(new Tooltip("use '. ' after every statement. "));
                
        h = DatabaseCon.connect();
        operation();
        
    }    
    
    int e = 0;
    
    Connection h = null;
    
    void operation()
    {
        if(Editing1Controller.ui == 0)
        {
            update();
        }
        else if(Editing1Controller.ui == 1)
        {
            insert();
        }
    }
    
    void insert()
    {
        h1 = null; h2 = null; h3 = null; h4 = null; h5 = null; h6 = null; 
        e = 0;
        delData.setVisible(false);
       
    }
    
    void update()
    {
        delData.setVisible(true);
         
        try 
        {
            Statement myStmt = h.createStatement();
            ResultSet myRs = myStmt.executeQuery("select * from studentinfoschema.other_info where name = '" + Editing1Controller.useName +"';");
            
            while(myRs.next())
            {
                s1 = (myRs.getString(1)).toUpperCase();//
                h1 = (myRs.getString(2)).toUpperCase();
                if(myRs.getString(3) != null)
                {
                    h2 = myRs.getString(3).toUpperCase();
                }
                else
                {
                    h2 = myRs.getString(3);
                }
                h3 =  myRs.getString(4);
                h4 =  myRs.getString(5);
                boolean y =  myRs.getBoolean(6); 
                h6 =  myRs.getString(7);
              
                CEmail.setText(h1);
                Email.setText(h2);
                DadCntct.setText(h3);
                FamCntct.setText(h4);
                if(y == true)
                {
                    CertifTick.setSelected(true);
                    h5 = "true";
                }
                else
                {
                    CertifTick.setSelected(false);
                    h5 = "false";
                }
                AddInfoField.setText(h6);      
                
                e = 0;
            } 
            
        }
        catch(Exception n)
        {
            System.out.println("check");
            e = 1;
            n.printStackTrace();
        }
        
    }
    

    @FXML
    private Label delData;
    
    @FXML
    private Pane Edit3;
   
    public static String s1;
    public static String h1, h2, h3, h4, h5, h6;
    
    
    @FXML
    private JFXTextField Email;
    public void getEmail()
    {   
              h2 = "'"+Email.getText()+"'";
            System.out.println(h2);
        
    }
    
    @FXML
    private JFXTextField CEmail;
    public void getCEmail()
    {   
        
        if(CEmail.getText() == null)
        {
            System.out.println(h1);
            CEmail.setStyle("-fx-border-color: #ff2323; -fx-text-fill: white; -fx-prompt-text-fill: white;");
            h1 = null;
            
        }
        else 
        {
            CEmail.setStyle("-fx-border-color: #ffffff; -fx-text-fill: white; -fx-prompt-text-fill: white;");
            h1 = "'"+CEmail.getText()+"'";
            System.out.println(h1);

        }
        
    }
    

    @FXML
    private JFXTextField DadCntct;
    public void getDadCntct()
    {   
        String l = "'"+DadCntct.getText()+"'";
        if(DadCntct.getText() == null)
        {
            System.out.println(l);
            DadCntct.setText(null);
            DadCntct.setStyle("-fx-border-color: #ff2323; -fx-text-fill: white; -fx-prompt-text-fill: white;");
            h3 = null;
            System.out.println("check");
        }
        if(l.length() == 12)
        {
            DadCntct.setStyle("-fx-border-color: #ffffff; -fx-text-fill: white; -fx-prompt-text-fill: white;");
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
            FamCntct.setStyle("-fx-border-color: #ffffff; -fx-text-fill: white; -fx-prompt-text-fill: white;");
            h4 = l;
            System.out.println(h4);
            
        }
        else
        {
            System.out.println(l);
            FamCntct.setText(null);
            FamCntct.setStyle("-fx-border-color: #ff2323; -fx-text-fill: white; -fx-prompt-text-fill: white;");
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
    
    public static void setValues()
    {
        DatabaseIO a = new DatabaseIO();
        
        a.setUlinfo(s1, h1, h2, h3, h4, h5, h6); 
    }
    
    public static void upValues()
    {
        DatabaseIO a = new DatabaseIO();
        
        a.UpUlinfo(s1, h1, h2, h3, h4, h5, h6); 
    }
    
    public void delEdit3(MouseEvent event)
    {
        DatabaseIO d = new DatabaseIO();
        d.DelBasicinfo(Editing1Controller.useName);
       
        try
        {
            Parent editPag1 = FXMLLoader.load(getClass().getResource("HomePage.fxml"));
            Scene editPg1Scene = new Scene(editPag1);
            Stage appStage = (Stage)((Node)event.getSource()).getScene().getWindow();
            appStage.setScene(editPg1Scene);
            appStage.show();
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
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
    public Label errbtn;
    
    @FXML
    private JFXButton SavBtn;
    public void toSave(MouseEvent event)
    {
        
        try
        {
            if(Editing1Controller.ui == 0)
            {
                Editing1Controller.upValues();
                Editing2Controller.upValues();
                upValues();
                e = 0;
            }
            if(Editing1Controller.ui == 1)
            {
                setValues();
                Editing2Controller.setValues();
                e = 0;
            }
        }
         
        catch (Exception ex) 
        {
            e = 1;
            ex.printStackTrace();
        }
        
        if(e == 0)
        {
            try
            {
                Parent editPag1 = FXMLLoader.load(getClass().getResource("HomePage.fxml"));
                Scene editPg1Scene = new Scene(editPag1);
                Stage appStage = (Stage)((Node)event.getSource()).getScene().getWindow();
                appStage.setScene(editPg1Scene);
                appStage.show();
            }
            catch(Exception xyz)
            {
                System.out.println("page changing error!");
            }
        }
        if (e == 1)
        {
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
