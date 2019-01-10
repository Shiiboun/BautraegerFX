package gui;

import db.DBConnector;
import gui.kunde.KundeControl;
import javafx.application.Application;
import javafx.stage.Stage;

public class Main extends Application {

    public static void main(String[] args) {
        launch(args);
    }
    
    @Override
    public void start(Stage primaryStage) {

        new KundeControl(primaryStage);
        
        // Produkt-Datenbank:
        MySQLAccess.init("178.254.15.200","s274608_2827186", "WCEfYuPlIM#2N!3", "db274608x2827186");
        DBConnector.user = "s274608_2827186";
        DBConnector.pass = "WCEfYuPlIM#2N!3";
        DBConnector.db_url = "jdbc:mysql://" + "178.254.15.200" + "/" + "db274608x2827186";
        
        // Lokale Datenbank:
//        MySQLAccess.init("localhost","root", "root", "bautraegerfx");
//        DBConnector.user = "root";
//        DBConnector.pass = "root";
//        DBConnector.db_url = "jdbc:mysql://" + "localhost" + "/" + "bautraegerfx";
        
        try {
        	MySQLAccess.GetInstance().getConnection().prepareStatement("USE db274608x2827186");
            MySQLAccess.GetInstance().getConnection().prepareStatement("SELECT * FROM kunde");
            System.out.println("VERBINDUNG OK");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}