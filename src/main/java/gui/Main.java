package main.java.gui;

import main.java.db.DBConnector;
import main.java.gui.kunde.KundeControl;
import javafx.application.Application;
import javafx.stage.Stage;

public class Main extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {

        new KundeControl(primaryStage);


        //MySQLAccess.init("localhost","root", "1234", "bautraegerfx");
        MySQLAccess.init("178.254.15.200","s274608_2827186", "WCEfYuPlIM#2N!3", "db274608x2827186");
       
        try {
        	MySQLAccess.GetInstance().getConnection().prepareStatement("USE db274608x2827186");
            MySQLAccess.GetInstance().getConnection().prepareStatement("SELECT * FROM kunde");
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        
    }
}