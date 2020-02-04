
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



public class Editing1Controller implements Initializable {

    public static int up, ui = 1;
    
    public static String a, oldName;
    public static int useSem;
       
    public static String newName;
    public static String s2, s3, s4, s6, s7, s72;
    public static int s5, s71, s73;
    
    Connection h = null; 
    
    
    @FXML
    private Pane Edit1;
            
    @FXML
    private JFXTextField Name;
    
    @FXML
    public JFXTextField ClgID;
    
    @FXML
    private JFXTextField DobYear;
    
    @FXML
    private MenuButton DobMnth;
               
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
    private Label MnthLbl;
    
    @FXML
    private JFXTextField DobDay;
    
    @FXML
    private JFXTextField Course;
    
    @FXML
    private JFXTextField CurrSem;
    
    @FXML
    private JFXTextField Contact;
        
    @FXML
    private Label BtnTo2;
    
    @FXML
    private Label BtnTo3; 
    
    @FXML
    private Label bck;
        
    @FXML
    private Label delData;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) 
    {  
        Edit1.requestFocus();
        //ClgID.setStyle("-fx-border-color: #ff2323; -fx-text-fill: white; -fx-prompt-text-fill: white;"); when error occurs or not filled
                
        
        chzDobMnth();
        
        h = DatabaseCon.connect();
        
        Name.setTooltip(new Tooltip ("use Fullname"));
        DobYear.setTooltip(new Tooltip("eg. 1997"));
        Course.setTooltip(new Tooltip("eg. BE Computer Science"));
          
        operation();
    }    
    
    
    
    
    void operation()
    {
        if(ui == 0)
        {
            update();
        }
        else if(ui == 1)
        {
            insert();
        }
            
    }
    
    void insert()
    {
        newName = null; s2 = null; s3 = null; s4 = null; s6 = null; s7 = null; s72 = null;
        s5 = 0; s71 = 0; s73 = 0; 
        
        delData.setVisible(false); 
    }
    
    
    void update()
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
        
    }
    
    
    
    public void getName()
    {       
        String l = Name.getText();
        if(l.matches("^[ A-Za-z]+$") == false || l.length() == 0)
        { 
            Name.setText(null);
            Name.setStyle("-fx-border-color: #ff2323; -fx-text-fill: white; -fx-prompt-text-fill: white;");
            System.out.println("false"); 
            newName = null;
        } 
        else 
        { 
            Name.setStyle("-fx-border-color: #ffffff; -fx-text-fill: white; -fx-prompt-text-fill: white;");
            newName = l;
            System.out.println(newName);
        }

    }
    
    
    public void getID()
    {   s2 = "'"+ClgID.getText()+"'";
        System.out.println(s2);
    }
     
    
    public void getSem()
    {       
        int l = Integer.parseInt(CurrSem.getText());
        if(up == 1 && l<=9 && l>0)
        {   
            CurrSem.setStyle("-fx-border-color: #ffffff; -fx-text-fill: white; -fx-prompt-text-fill: white;");
            s5 = l;
            useSem = s5;
            System.out.println(s5);
        }
        
        else if(up == 0 && l<=5 && l>0)
        {   
            CurrSem.setStyle("-fx-border-color: #ffffff; -fx-text-fill: white; -fx-prompt-text-fill: white;");
            s5 = l;
            useSem = s5;
            System.out.println(s5);
        } 
        
        else
        {
            CurrSem.setText(null);
            CurrSem.setStyle("-fx-border-color: #ff2323; -fx-text-fill: white; -fx-prompt-text-fill: white;");
            s5 = 0;
            System.out.println("check");
        }

    }
    
    
    
    
    public void getCntct()
    {  
        String l = "'"+Contact.getText()+"'";
        
        if(l.length() == 12)
        {
            Contact.setStyle("-fx-border-color: #ffffff; -fx-text-fill: white; -fx-prompt-text-fill: white;");
            s6 = l;
            System.out.println(s6);
            
        }
        else
        {
            System.out.println(l);
            Contact.setText(null);
            Contact.setStyle("-fx-border-color: #ff2323; -fx-text-fill: white; -fx-prompt-text-fill: white;");
            s6 = null;
            System.out.println("check");
            
        }
    } 
    
    
    public void DobYear()
    {      
        String l = DobYear.getText();
        if(l.length() == 4)
        {
            try
            {
                DobYear.setStyle("-fx-border-color: #ffffff; -fx-text-fill: white; -fx-prompt-text-fill: white;");
                s71 = Integer.parseInt(DobYear.getText());
                System.out.println(s71);
            }
            catch(Exception e)
            {
                DobYear.setText(null);
                DobYear.setStyle("-fx-border-color: #ff2323; -fx-text-fill: white; -fx-prompt-text-fill: white;");
            }
        }
        else
        {
            DobYear.setText(null);
            DobYear.setStyle("-fx-border-color: #ff2323; -fx-text-fill: white; -fx-prompt-text-fill: white;");
        }
            
    }
    
    int dd;
    
    
    
    public void chzDobMnth()
    {
              
       jan.setOnAction(new EventHandler<ActionEvent>() 
       {
            public void handle(ActionEvent t) 
            {
                dd = 31;
                DobMnth.setText("January");
                MnthLbl.setVisible(true);
                s72 = "1";
            }
       }       );
       
       fab.setOnAction(new EventHandler<ActionEvent>() 
       {
            public void handle(ActionEvent t) 
            {
                if(s71%4 == 0)
                {
                    dd = 29;
                }
                else
                {
                    dd = 28;
                }
                DobMnth.setText("Fabruary");
                MnthLbl.setVisible(true);
                s72 = "2";
            }
       }       );
       
       march.setOnAction(new EventHandler<ActionEvent>() 
       {
            public void handle(ActionEvent t) 
            {
                dd = 31;
                DobMnth.setText("March");
                MnthLbl.setVisible(true);
                s72 = "3";
            }
       }
       );
       
       april.setOnAction(new EventHandler<ActionEvent>() 
       {
            public void handle(ActionEvent t) 
            {
                dd = 30;
                DobMnth.setText("April");
                MnthLbl.setVisible(true);
                s72 = "4";
            }
       }
       );
       
       may.setOnAction(new EventHandler<ActionEvent>() 
       {
            public void handle(ActionEvent t) 
            {
                dd = 31;
                DobMnth.setText("May");
                MnthLbl.setVisible(true);
                s72 = "5";
            }
       }
       );
       
       june.setOnAction(new EventHandler<ActionEvent>() 
       {
            public void handle(ActionEvent t) 
            {
                dd = 30;
                DobMnth.setText("June");
                MnthLbl.setVisible(true);
                s72 = "6";
            }
       }
       );
       
       july.setOnAction(new EventHandler<ActionEvent>() 
       {
            public void handle(ActionEvent t) 
            {
                dd = 31;
                DobMnth.setText("July");
                MnthLbl.setVisible(true);
                s72 = "7";
            }
       }
       );
       
       aug.setOnAction(new EventHandler<ActionEvent>() 
       {
            public void handle(ActionEvent t) 
            {
                dd = 31;
                DobMnth.setText("August");
                MnthLbl.setVisible(true);
                s72 = "8";
            }
       }
       );
       
       sept.setOnAction(new EventHandler<ActionEvent>() 
       {
            public void handle(ActionEvent t) 
            {
                dd = 30;
                DobMnth.setText("September");
                MnthLbl.setVisible(true);
                s72 = "9";
            }
       }
       );
       
       oct.setOnAction(new EventHandler<ActionEvent>() 
       {
            public void handle(ActionEvent t) 
            {
                dd = 31;
                DobMnth.setText("October");
                MnthLbl.setVisible(true);
                s72 = "10";
            }
       }
       );
       
       nov.setOnAction(new EventHandler<ActionEvent>() 
       {
            public void handle(ActionEvent t) 
            {
                dd = 30;
                DobMnth.setText("November");
                MnthLbl.setVisible(true);
                s72 = "11";
            }
       }
       );
       
       dec.setOnAction(new EventHandler<ActionEvent>() 
       {
            public void handle(ActionEvent t) 
            {
                dd = 31;
                DobMnth.setText("December");
                MnthLbl.setVisible(true);
                s72 = "12";
    
            }
       }
       );
       
    }
    
    
    
    public void DobDay()
    {  
        int l = Integer.parseInt(DobDay.getText());
        if(l <= dd)
        {
            DobDay.setStyle("-fx-border-color: #ffffff; -fx-text-fill: white; -fx-prompt-text-fill: white;");
            s73 = l;
            System.out.println(s73);
            s7 = "'"+ s71 + "-" + s72 + "-" + s73 + "'"; 
            System.out.println(s7);
        }
        else
        {
            DobDay.setText(null);
            DobDay.setStyle("-fx-border-color: #ff2323; -fx-text-fill: white; -fx-prompt-text-fill: white;");
        }
    }
    
    
   
    public static void setValues()
    {
        DatabaseIO d = new DatabaseIO();
        d.setBasicinfo("'"+newName+"'", s2, s3, s4, s5, s6, s7); 
    }
    
    public static void upValues()
    {
        DatabaseIO d = new DatabaseIO();
        d.UpBasicinfo("'"+newName+"'", s2, s3, s4, s5, s6, s7); 
    }
    
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
            // ... user chose CANCEL or closed the dialog
        }
    }
    
        
    public void toEdit2(MouseEvent event) //this function allows to transport to another tab without opening another window and same goes for other 2 functions
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
 
    
    
    public void toEdit3(MouseEvent event)
    {
        
        try 
        {
            Parent editPag1 = FXMLLoader.load(getClass().getResource("Editing3.fxml"));
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