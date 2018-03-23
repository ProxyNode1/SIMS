/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sims;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

/**
 *
 * @author VIC's
 */
public class Sims extends Application 
{
    public static Stage stage;
    @Override
    public void start(Stage stage) throws Exception 
    {
        this.stage = stage;
        Parent root = FXMLLoader.load(getClass().getResource("Editing1.fxml"));
        stage.initStyle(StageStyle.UNDECORATED);
        
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
        Sims.stage.setResizable(false);
    }

    
    public static void main(String[] args) 
    {
        launch(args);
    }
    
}
