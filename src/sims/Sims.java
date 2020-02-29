package sims;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;


public class Sims extends Application 
{
    
    @Override
    public void start(Stage stage) throws Exception 
    {        
        //DatabaseIO a = new DatabaseIO();
        
        Parent root = FXMLLoader.load(getClass().getResource("HomePage.fxml"));
        
        stage.resizableProperty().setValue(Boolean.FALSE);
        stage.setScene(new Scene(root, 1280, 720));  
        //stage.setResizable(false);
        stage.sizeToScene();
        stage.show();

    }
   
    public static void main(String[] args) 
    {
        launch(args);
    }
    
}