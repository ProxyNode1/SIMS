
package sims;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.Initializable;

import com.jfoenix.controls.JFXTextField;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Optional;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.MenuButton; 
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.scene.control.MenuItem;
import javafx.scene.control.Tooltip;



public class Editing1Controller implements Initializable 
{

    //public static int up, ui = 1;
    
    //public static String a, oldName;
    //public static int useSem;
       
    //public static String newName;
    public static String s1, s2, s3b, s3, s4, s6;
    public static int s3a, s3c, s5;
    
    Connection h = null; 
    
    
    @FXML
    private Pane edit1;
            
    @FXML
    private JFXTextField name;
    
    @FXML
    public JFXTextField clgID;
    
    @FXML
    private JFXTextField dobYear;
    
    @FXML
    private MenuButton dobMonth;
               
    @FXML
    private MenuItem jan;
    
    @FXML
    private MenuItem fab;

    @FXML
    private MenuItem march; 

    @FXML
    private MenuItem april;
    
    @FXML
    private MenuItem may;

    @FXML
    private MenuItem june;

    @FXML
    private MenuItem july;
    
    @FXML
    private MenuItem aug;
    
    @FXML
    private MenuItem sept;
    
    @FXML
    private MenuItem oct;

    @FXML
    private MenuItem nov;
    
    @FXML
    private MenuItem dec;
    
    @FXML
    private Label monthLbl;
    
    @FXML
    private JFXTextField dobDay;
    
    @FXML
    private JFXTextField course;
    
    @FXML
    private JFXTextField currSem;
    
    @FXML
    private JFXTextField contact;
        
    @FXML
    private Label home;
    
            
    @Override
    public void initialize(URL url, ResourceBundle rb) 
    {  
        edit1.requestFocus();
        //ClgID.setStyle("-fx-border-color: #ff2323; -fx-text-fill: white; -fx-prompt-text-fill: white;"); when error occurs or not filled
                
        
        //chzDobMnth();
        
        h = DatabaseCon.connect();
        
        name.setTooltip(new Tooltip ("use Fullname"));
        dobYear.setTooltip(new Tooltip("eg. 1997"));
        course.setTooltip(new Tooltip("eg. BE Computer Science"));
          
        //operation();
    }    
    
    
    
    
    /*void operation()
    {
        if(ui == 0)
        {
            update();
        }
        else if(ui == 1)
        {
            insert();
        }
            
    }*/
    
    /*void insert()
    {
        newName = null; s2 = null; s3 = null; s4 = null; s6 = null; s7 = null; s72 = null;
        s5 = 0; s71 = 0; s73 = 0; 
        
        delData.setVisible(false); 
    }*/
    
    
    /*void update()
    {
        delData.setVisible(true);
         
        try 
        {
            Statement myStmt = h.createStatement();
            ResultSet myRs = myStmt.executeQuery("select * from studentinfoschema.basic_info where name = '"+ oldName +"'");
            while(myRs.next())
            {
                Name.setText((myRs.getString(1)).toUpperCase());
                oldName = myRs.getString(1);
                newName = oldName;
                
                ClgID.setText((myRs.getString(2)).toUpperCase());
                     
                CurrSem.setText(Integer.toString(myRs.getInt(5))); 
                
                Contact.setText((myRs.getString(6)).toUpperCase()); 
                
                String xyzs = myRs.getString(7);                
                String[] strArray = xyzs.split("\\-");
                String[] s = new String[3];
                
                System.arraycopy(strArray, 0, s, 0, 3); //copies strArray into s till 2nd index
                
                s71 = Integer.parseInt(s[0]);
                s72 = s[1];       
                s73 = Integer.parseInt(s[2]);
                DobYear.setText(s[0]);
                DobDay.setText(s[2]);
                int x =  Integer.parseInt(s[1]);
                
                switch (x) {
                    case 1:
                        DobMnth.setText("January");
                        break;
                        
                    case 2:
                        DobMnth.setText("February");
                        break;
                        
                    case 3:
                        DobMnth.setText("March");
                        break;
                        
                    case 4:
                        DobMnth.setText("April");
                        break;
                        
                    case 5:
                        DobMnth.setText("May");
                        break;
                        
                    case 6:
                        DobMnth.setText("June");
                        break;
                        
                    case 7:
                        DobMnth.setText("July");
                        break;
                        
                    case 8:
                        DobMnth.setText("August");
                        break;
                    
                    case 9:
                        DobMnth.setText("September");
                        break;
                        
                    case 10:
                        DobMnth.setText("October");
                        break;
                        
                    case 11:
                        DobMnth.setText("November");
                        break;
                        
                    case 12:
                        DobMnth.setText("December");
                        break;
                    
                    default:
                        break;
                }
                
                s2 = "'"+myRs.getString(2)+"'";
                s3 = "'"+myRs.getString(3)+"'";
                
                int g =  myRs.getInt(5);
                System.out.println(g);
                useSem = g;
                s5 = g;
                
                s6 = "'"+myRs.getString(6)+"'"; 
                s7 = "'"+ myRs.getString(7) +"'";

            } 
            
        }
        catch(Exception e)
        {
            System.out.println("check");
            e.printStackTrace();
        }
        
    }*/
    
    
    ////////////////////////////// GET and SET DATA /////////////////////////////////
    public void getName()
    {       
        String tmp = name.getText();
        
        if( !tmp.matches("^[ A-Za-z]+$") || tmp.length() == 0)
        { 
            //name.setText(null);
            name.setStyle("-fx-border-color: #ff2323; -fx-text-fill: white; -fx-prompt-text-fill: white;");
            System.out.println("false"); 
            s1 = null;
        } 
        
        else 
        { 
            name.setStyle("-fx-border-color: #ffffff; -fx-text-fill: white; -fx-prompt-text-fill: white;");
            s1 = tmp;
            System.out.println(s1);
        }
    }
    
    
    public void getClgID()
    {   
        s2 = "'"+clgID.getText()+"'";
        System.out.println(s2);
    }
     
    
    public void getDobYear()
    {      
        String tmp = dobYear.getText();
        if(tmp.length() == 4)
        {
            try
            {
                s3a = Integer.parseInt(dobYear.getText());
                dobYear.setStyle("-fx-border-color: #ffffff; -fx-text-fill: white; -fx-prompt-text-fill: white;");
                System.out.println(s3a);
            }
            catch(Exception e)
            {
                dobYear.setText(null);
                dobYear.setStyle("-fx-border-color: #ff2323; -fx-text-fill: white; -fx-prompt-text-fill: white;");
            }
        }
        else
        {
            dobYear.setText(null);
            dobYear.setStyle("-fx-border-color: #ff2323; -fx-text-fill: white; -fx-prompt-text-fill: white;");
        }
            
    }
    
    int numDays = 0;
    
    public void getDobMonth()
    {
        monthLbl.setVisible(true);    
       
        jan.setOnAction
        ( 
                new EventHandler<ActionEvent>() 
                {
                    public void handle(ActionEvent t) 
                    {
                        numDays = 31;
                        dobMonth.setText("January");
                        s3b = "1";
                    }
                }
        );
       
        fab.setOnAction
        (
                new EventHandler<ActionEvent>() 
                {
                    public void handle(ActionEvent t) 
                    {
                        if (s3a % 4 == 0) {
                            numDays = 29;
                        } else {
                            numDays = 28;
                        }
                        dobMonth.setText("Fabruary");
                        s3b = "2";
                    }
                }
        );
       
        march.setOnAction
        (
                new EventHandler<ActionEvent>()        
                {            
                    public void handle(ActionEvent t) 
                    {
                        numDays = 31;
                        dobMonth.setText("March");
                        s3b = "3";
                    }
                }
        );
       
        april.setOnAction
        (
            new EventHandler<ActionEvent>() 
            {
                public void handle(ActionEvent t) 
                {
                    numDays = 30;
                    dobMonth.setText("April");
                    s3b = "4";
                }
            }
        );
       
        may.setOnAction
        (
            new EventHandler<ActionEvent>() 
            {
                public void handle(ActionEvent t) 
                {
                    numDays = 31;
                    dobMonth.setText("May");
                    s3b = "5";
                }
            }
        );
              
        june.setOnAction
        (
                new EventHandler<ActionEvent>() 
                {
                    public void handle(ActionEvent t) 
                    {
                        numDays = 30;
                        dobMonth.setText("June");
                        s3b = "6";
                    }
                }
        );
       
        july.setOnAction
        (
            new EventHandler<ActionEvent>()
            {
                public void handle(ActionEvent t) 
                {
                    numDays = 31;
                    dobMonth.setText("July");
                    s3b = "7";
                }
            }
        );
       
        aug.setOnAction
        (
            new EventHandler<ActionEvent>() 
            {
                public void handle(ActionEvent t) 
                {
                    numDays = 31;
                    dobMonth.setText("August");
                    s3b = "8";
                }
            }
        );
       
        sept.setOnAction
        (
                new EventHandler<ActionEvent>() 
                {
                    public void handle(ActionEvent t) 
                    {
                        numDays = 30;
                        dobMonth.setText("September");
                        s3b = "9";
                    }
                }
        );

        oct.setOnAction
        (
            new EventHandler<ActionEvent>() 
            {
                public void handle(ActionEvent t) 
                {
                    numDays = 31;
                    dobMonth.setText("October");
                    s3b = "10";
                }
            }
        );

        nov.setOnAction
        (
                new EventHandler<ActionEvent>() 
                {
                    public void handle(ActionEvent t) 
                    {
                        numDays = 30;
                        dobMonth.setText("November");
                        s3b = "11";
                    }
                }
        );

        dec.setOnAction
        (
                new EventHandler<ActionEvent>() 
                {
                    public void handle(ActionEvent t) 
                    {
                        numDays = 31;
                        dobMonth.setText("December");
                        s3b = "12";
                    }
                }
        );
       
    }
        
    public void getDobDay()
    {  
        int tmp = Integer.parseInt(dobDay.getText());
        if(tmp <= numDays)
        {
            dobDay.setStyle("-fx-border-color: #ffffff; -fx-text-fill: white; -fx-prompt-text-fill: white;");
            s3c = tmp;
            System.out.println(s3c); 
        }
        else
        {
            dobDay.setText(null);
            dobDay.setStyle("-fx-border-color: #ff2323; -fx-text-fill: white; -fx-prompt-text-fill: white;");
        }
    }  
    
    public void getDOB()
    {
        s3 = "'"+ s3a + "-" + s3b + "-" + s3c + "'"; 
        System.out.println(s3);
    }
    
    
    public void getCourse()
    {       
        s4 = "'"+course.getText()+"'";
        System.out.println(s4);
    }
    
    
    public void getCurrSem()
    {       
        s5 = Integer.parseInt(currSem.getText());
        System.out.println(s5);
    }
    
    
    public void getContact()
    {  
        String tmp = "'"+contact.getText()+"'";
        
        if(tmp.length() == 12)
        {
            contact.setStyle("-fx-border-color: #ffffff; -fx-text-fill: white; -fx-prompt-text-fill: white;");
            s6 = tmp;
            System.out.println(s6);
            
        }
        else
        {
            System.out.println(tmp);
            contact.setText(null);
            contact.setStyle("-fx-border-color: #ff2323; -fx-text-fill: white; -fx-prompt-text-fill: white;");
            s6 = null;
            System.out.println("check contact");
            
        }
    } 
    
    
    
   //inserting value 
    public static void setValues()
    {
        DatabaseIO d = new DatabaseIO();
        d.setBasicinfo("'"+s1+"'", s2, s3, s4, s5, s6, s7); 
    }
    
    
    
    //Updating existing value
    /*public static void upValues()
    {
        DatabaseIO d = new DatabaseIO();
        d.UpBasicinfo("'"+newName+"'", s2, s3, s4, s5, s6, s7); 
    }
    
    
    
    //delete existing value
    public void delEdit(MouseEvent event)
    {
        Alert alert = new Alert(AlertType.CONFIRMATION);
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
            // ... user either CLOSES or CANCELs the dialog
        }
    }*/
    
        
    public void toEdit2(MouseEvent event) //this function allows to transport to another tab without opening another window and same goes for other 2 functions
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