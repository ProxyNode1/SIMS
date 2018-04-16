/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sims;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.Initializable;


import javafx.scene.input.MouseEvent;
import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.MenuButton;
import javafx.scene.control.MenuItem;
import javafx.scene.control.Tooltip;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;





/**
 * FXML Controller class
 *
 * @author VIC's
 */
public class Editing2Controller implements Initializable 
{

  
    @Override
    public void initialize(URL url, ResourceBundle rb) 
    {
        SPass.requestFocus();
        chzPostSSDwn();
        //IdFld.setStyle("-fx-border-color: #ff2323; -fx-text-fill: white; -fx-prompt-text-fill: white;"); when error occurs or not filled
        SBrd.setTooltip(new Tooltip("eg. state"));
        HBrd.setTooltip(new Tooltip("eg. state"));
        
        s1 = Editing1Controller.useName;
        int o = Editing1Controller.up;
        hide(o);
        
    }  
    
    DatabaseIO xyz = new DatabaseIO();
    
    @FXML
    private Pane Edit2;
    
    
    @FXML
    public static Label BtnTo1;
    
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
    private Label BtnTo3;  
    
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
    public static int i;
    public int a;
    
    public  void disableGrad()
    {
        if(a == 2)
        {
           PPane.setDisable(true);
           EPane.setDisable(false);
        }
        
        if(a == 1)
        {
           EPane.setDisable(true);
           PPane.setDisable(false);
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
    
    

    /////////////////////////////////////////////Secondary School Fields
    int s3, s2, s8;
    String s1;
    String s4, s5, s6, s7;
    
    @FXML
    private JFXTextField SPass;
    public void getSPass()
    {   s2 = Integer.parseInt(SPass.getText());
        System.out.println(s2);            
    }
    
    @FXML
    private JFXTextField SRoll;
    public void getSRoll()
    {   s3 = Integer.parseInt(SRoll.getText());
        System.out.println(s3);            
    }
    
    @FXML
    private JFXTextField SBrd;
    public void getSBrd()
    {   s4 = "'"+SBrd.getText()+"'";
        System.out.println(s4);
    }
    
    @FXML
    private JFXTextField SMed;
    public void getSMed()
    {   s5 = "'"+SMed.getText()+"'";
        System.out.println(s5);
    }
    
    @FXML
    private JFXTextField SSch;
    public void getSSch()
    {   s6 = "'"+SSch.getText()+"'";
        System.out.println(s6);
    }
    
    @FXML
    private JFXTextField SCity;
    public void getSCity()
    {   s7 = "'"+SCity.getText()+"'";
        System.out.println(s7);
    }
    
    @FXML
    private JFXTextField SPentg;
    public void getSPtng()
    {       s8 = Integer.parseInt(SPentg.getText());
            System.out.println(s8);            
    }

    
    ///////////////////////////////////High School Fields/////////////////////////
    
    @FXML
    private MenuButton PostSS;
    
    public MenuButton getPostSS() {
        return PostSS;
    }

    public void setPostSS(MenuButton PostSS) {
        this.PostSS = PostSS;
    }
    
    @FXML
    private Pane HPane;
    
    
    @FXML
    private JFXTextField HPass;
    public JFXTextField getHPass() {
        return HPass;
    }

    public void setHPass(JFXTextField HPass) {
        this.HPass = HPass;
    }
    
    @FXML
    private JFXTextField HBrd;
    public JFXTextField getHBrd() {
        return HBrd;
    }

    public void setHBrd(JFXTextField HBrd) {
        this.HBrd = HBrd;
    }
    
    @FXML
    private JFXTextField HMed;
    public JFXTextField getHMed() {
        return HMed;
    }

    public void setHMed(JFXTextField HMed) {
        this.HMed = HMed;
    }

    @FXML
    private JFXTextField HCity;
    public JFXTextField getHCity() {
        return HCity;
    }

    public void setHCity(JFXTextField HCity) {
        this.HCity = HCity;
    }
    

    @FXML
    private JFXTextField HSch;
    public JFXTextField getHSch() {
        return HSch;
    }

    public void setHSch(JFXTextField HSch) {
        this.HSch = HSch;
    }
    
    @FXML
    private JFXTextField HPentg;
    public JFXTextField getHPentg() {
        return HPentg;
    }

    public void setHPentg(JFXTextField HPentg) {
        this.HPentg = HPentg;
    }
    
    @FXML
    private JFXTextField HRoll;
    public JFXTextField getHRoll() {
        return HRoll;
    }

    public void setHRoll(JFXTextField HRoll) {
        this.HRoll = HRoll;
    }
    
    
    
    @FXML
    private MenuItem HSSC;
    
    
    public MenuItem getHSSC() {
        return HSSC;
    }

    public void setHSSC(MenuItem HSSC) {
        this.HSSC = HSSC;
    }
    
    
    public void chzPostSSDwn()
    {
                
       HSSC.setOnAction(new EventHandler<ActionEvent>() 
       {
            public void handle(ActionEvent t) 
            {
                PostSS.setText("  HSSC");
                DPane.setVisible(false);
                HPane.setVisible(true);
            }
       }
       );
       
       
       DIPLOMA.setOnAction(new EventHandler<ActionEvent>() 
       {
            public void handle(ActionEvent t) 
            {
                PostSS.setText("  DIPLOMA");
                HPane.setVisible(false);
                DPane.setVisible(true);
            }
       }
       );
    }
    
    ////////////////////////// Diploma Fields //////////////////////
    
    @FXML
    private Pane DPane;
    
    @FXML
    private MenuItem DIPLOMA;
    
    @FXML
    private MenuButton DSem;
    
    @FXML
    private JFXTextField DPentg;
        
    
    @FXML
    private JFXTextField DCrs;
    
    public MenuItem getDIPLOMA() {
        return DIPLOMA;
    }

    public void setDIPLOMA(MenuItem DIPLOMA) {
        this.DIPLOMA = DIPLOMA;
    }

    public MenuButton getDSem() {
        return DSem;
    }

    public void setDSem(MenuButton DSem) {
        this.DSem = DSem;
    }

    public JFXTextField getDPentg() {
        return DPentg;
    }

    public void setDPentg(JFXTextField DPentg) {
        this.DPentg = DPentg;
    }

    public JFXTextField getDCrs() {
        return DCrs;
    }

    public void setDCrs(JFXTextField DCrs) {
        this.DCrs = DCrs;
    }
    
    
    public void hide(int o)
    {   
        if(o == 1)
        {
            EPentg.setDisable(true);
            ESem.setDisable(true);
        }
        if(o == 2)
        {
            PPentg.setDisable(true);
            PSem.setDisable(true);
        }
    }
    
    int j = Editing1Controller.useSem;
    ////////////////////////////Engineering Fields/////////////////////
        
    @FXML
    private static Pane EPane;
    
    
    @FXML
    private JFXTextField EPentg;
    
    @FXML
    private MenuButton ESem;
    
    

    public MenuButton getESem() {
        return ESem;
    }

    public void setESem(MenuButton ESem) {
        this.ESem = ESem;
    }
    
    
       

    //////////////////////////////////////Postgraduation Fields///////////////////////////
      
    @FXML
    private static Pane PPane;

    public Pane getPPane() {
        return PPane;
    }

    public void setPPane(Pane PPane) {
        this.PPane = PPane;
    }
    
    @FXML
    private JFXTextField PPentg; 
    
    @FXML
    private MenuButton PSem;
     
    public JFXTextField getPPentg() {
        return PPentg;
    }

    public void setPPentg(JFXTextField PPentg) {
        this.PPentg = PPentg;
    }

    public MenuButton getPSem() {
        return PSem;
    }

    public void setPSem(MenuButton PSem) {
        this.PSem = PSem;
    }

    
    public void setValues()
    {       
        xyz.setSscinfo(s1, s2, s3, s4, s5, s6, s7, s8); 
        //xyz.;
    }
}
