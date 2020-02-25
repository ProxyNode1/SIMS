package sims;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.Initializable;


import com.jfoenix.controls.JFXButton;
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
import java.util.regex.Pattern;


import com.jfoenix.controls.JFXCheckBox;
import java.sql.*;
import java.util.Optional;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;



/**
 * FXML Controller class
 *
 * @author VIC's
 */
public class Editing3Controller implements Initializable {

    int e = 0;
    
    //Connection h = null;
    
    //public String s1;
    public String personMailVal, universityMailVal, dadContactVal, famContactVal, addInfoVal;
    
    @FXML
    private Pane Edit3;
       
    @FXML
    private JFXTextField personMail;
    
    @FXML
    private JFXTextField universityMail;
                
    @FXML
    private JFXTextField dadContact;
    
    @FXML
    private JFXTextField famContact;
       
    @FXML
    private TextArea addInfo;
    
    @FXML
    private Label saveAddInfo;
    
    @FXML
    private JFXButton savData;
    
    @FXML
    public Label errbtn; //?
     
    
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) 
    {
        Edit3.requestFocus();

        /*if(Editing1Controller.ui  == 1)
        {
            try
            {
                s1 = Editing1Controller.newName;
                System.out.println(s1);
                Editing1Controller.setValues();
                e = 0;
            }
            catch(Exception x)
            {
                e = 1;
                errbtn.setText("Check input fields again!"); 
            }
        }*/
        
        addInfo.setTooltip(new Tooltip("use '. ' after every statement. "));
            
        //h = DatabaseCon.connect();
        //operation();

    }    
        
    
    public void setPersonMail()
    {           
        String tmp = personMail.getText();
        if(!Pattern.compile("^(.+@.+)$", Pattern.CASE_INSENSITIVE).matcher(tmp).matches() || tmp.length() == 0 )            
        { 
            personMail.setText(null);
            personMail.setStyle("-fx-border-color: #ff2323; -fx-text-fill: white; -fx-prompt-text-fill: white;");
            System.out.println("false"); 
            personMail = null;
        } 
        else 
        { 
            personMail.setStyle("-fx-border-color: #ffffff; -fx-text-fill: white; -fx-prompt-text-fill: white;");
            personMailVal = "'"+tmp+"'";
            System.out.println(personMailVal);
        }
         
    }
    
    
    public void setUnivMail()
    {   
        String tmp = universityMail.getText();
        if(!Pattern.compile("^(.+@.+)$", Pattern.CASE_INSENSITIVE).matcher(tmp).matches() || tmp.length() == 0 )            
        {            
            universityMail.setText(null);
            universityMail.setStyle("-fx-border-color: #ff2323; -fx-text-fill: white; -fx-prompt-text-fill: white;");
            System.out.println("false"); 
            universityMail = null;  
        }
        else 
        {
            universityMail.setStyle("-fx-border-color: #ffffff; -fx-text-fill: white; -fx-prompt-text-fill: white;");
            universityMailVal = "'"+universityMail.getText()+"'";
            System.out.println(universityMailVal);
        }        
    }
    
    
    public void setDadContact() 
    {   
        String tmp = dadContact.getText();        
        if(!Pattern.compile("^[+]?([0-9]{2,3})?[-]?[0-9]{10}$").matcher(tmp).matches())
        {
            dadContact.setStyle("-fx-border-color: #ffffff; -fx-text-fill: white; -fx-prompt-text-fill: white;");
            dadContactVal = "'"+tmp+"'";
            System.out.println(dadContactVal);
            
        }
        else
        {
            System.out.println(tmp);
            dadContact.setText(null);
            dadContact.setStyle("-fx-border-color: #ff2323; -fx-text-fill: white; -fx-prompt-text-fill: white;");
            dadContactVal = null;
            System.out.println("got Fathers Contact");
        }
    }
    
    
    public void setFamContact()
    {   
        String tmp = famContact.getText();        
        if(!Pattern.compile("^[+]?([0-9]{2,3})?[-]?[0-9]{10}$").matcher(tmp).matches())
        {
            famContact.setStyle("-fx-border-color: #ffffff; -fx-text-fill: white; -fx-prompt-text-fill: white;");
            famContactVal = "'"+tmp+"'";
            System.out.println(famContactVal);
            
        }      
        else
        {
            famContactVal = null;
            famContact.setText("");
            famContact.setStyle("-fx-border-color: #ff2323; -fx-text-fill: white; -fx-prompt-text-fill: white;");
            System.out.println("got Familys Contact");
        }
    }
    
    
    public void setAddInfo(MouseEvent event)
     {  
            addInfoVal = "'"+addInfo.getText()+"'";
            System.out.println(addInfoVal);
    }
    
    /*void operation()
    {
        if(Editing1Controller.ui == 0)
        {
            update();
        }
        else if(Editing1Controller.ui == 1)
        {
            insert();
        }
    }*/
    
    /*void insert()
    {
        h1 = null; h2 = null; h3 = null; h4 = null; h5 = null; h6 = null; 
        e = 0;
        delData.setVisible(false);       
    }*/
    
    /*void update()
    {
        delData.setVisible(true);
         
        try 
        {
            Statement myStmt = h.createStatement();
            ResultSet myRs = myStmt.executeQuery("select * from studentinfoschema.other_info where name = '" + Editing1Controller.oldName +"';");
            
            while(myRs.next())
            {
                
                s1 = myRs.getString(1);
                
                CEmail.setText((myRs.getString(2)).toUpperCase());
                                
                if(myRs.getString(3) != null)
                {
                    PEmail.setText(myRs.getString(3).toUpperCase());
                }
                else if(myRs.getString(3) == null)
                {
                    PEmail.setText("");
                }
                
                DadCntct.setText(myRs.getString(4));
                
                
                System.out.println(myRs.getString(5));
                String s = myRs.getString(5);
                if(s == null)
                {
                    FamCntct.setText(null);
                }
                else if(s != null)
                {
                    FamCntct.setText(myRs.getString(5));
                }

                boolean y =  myRs.getBoolean(6);
                if(y == true)
                {
                    CertifTick.setSelected(true);
                }
                else
                {
                    CertifTick.setSelected(false);
                }
                
                System.out.println(myRs.getString(7));
                if(myRs.getString(7) == null)
                {
                    AddInfoField.setText("");
                }
                else
                {
                    AddInfoField.setText(myRs.getString(7));
                }
                
                h1 = "'"+myRs.getString(2)+"'";
                h2 = "'"+myRs.getString(3)+"'";
                h3 = "'"+myRs.getString(4)+"'";
                h4 = "'"+myRs.getString(5)+"'";
                h5 = "'"+myRs.getBoolean(6)+"'";
                h6 = "'"+myRs.getString(7)+"'";
                         
                e = 0;
            } 
            
        }
        catch(Exception n)
        {
            System.out.println("check");
            e = 1;
            n.printStackTrace();
        } 
    }*/ 
    
    
    /*public static void setValues()
    {
        DatabaseIO a = new DatabaseIO();
        
        a.setUlinfo("'"+s1+"'", h1, h2, h3, h4, h5, h6); 
    }*/
    
    /*public static void upValues()
    {
        DatabaseIO a = new DatabaseIO();
        
        a.UpUlinfo("'"+s1+"'", h1, h2, h3, h4, h5, h6); 
    }
    */
    
    /*public void delEdit(MouseEvent event)
    {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Delete data");
        alert.setHeaderText("Are you sure you want to delete data of "+ (Editing1Controller.oldName).toUpperCase()+ "?");
        alert.setContentText("If you delete this, it wil be removed from database.");

        Optional<ButtonType> result = alert.showAndWait();
        if (result.get() == ButtonType.OK)
        {
            DatabaseIO d = new DatabaseIO();
            d.DelBasicinfo();

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
        else 
        {
            // ... user chose CANCEL or closed the dialog
        }
    }*/
    
    
    
    /*public void toEdit1(MouseEvent event)
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
    }*/

    
    public void toSave(MouseEvent event)
    {        
        
        DatabaseIO Connection = new DatabaseIO();
        
        Connection.InsertValues();
        
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
    
    
    public void toPrevPg(MouseEvent event)
    {
        try 
        {
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
        catch (Exception ex) 
          {
            ex.printStackTrace();
          }
    }    
    
    
}
